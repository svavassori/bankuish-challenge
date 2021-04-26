package client;
import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import character.CharacterByIds;
import character.CharacterIndex;
import character.CharacterInfo;
import character.CharactersInfoResponse;
import service.Popularity;
import service.Storage;

/**
 * Controller class to query and filter the list of characters according to
 * client's request.
 */
@RestController
@RequestMapping("/characters")
public class Requester {
	
	private static String URL = "https://rickandmortyapi.com/graphql";
	private static String QUERY_IDS = "{ \"query\": \"{"
										+ "  charactersByIds(ids: {LIST}) {"
										+ "    id,"
										+ "    name,"
										+ "    status,"
										+ "    species,"
										+ "    type,"
										+ "    gender,"
										+ "    image,"
										+ "    created,"
										+ "    origin {"
										+ "      id,"
										+ "      name,"
										+ "      type,"
										+ "      dimension,"
										+ "      created"
										+ "    },"
										+ "    episode {"
										+ "      id,"
										+ "      name"
										+ "    }"
										+ "  }"
										+ "}\" }";
	private static String ALL_IDS = "{\"query\":\"{characters{results{id}}}\"}";
	
	@Autowired private Storage storage;
	@Autowired private Popularity popularity;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
				 consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<CharacterIndex> requestCharacters(@RequestBody RequestCharacters reqChar) {
		
		storage.store(reqChar);
		
		// query all ids
		List<Integer> retrievedIds = post(ALL_IDS, CharacterByIds.class).getIds();
		
		// filter locally and limit to n (1 <= n <= 5)
		Set<Integer> toExclude = reqChar.getExcludedIds();
		List<Integer> ids = retrievedIds.stream()
										.filter(id -> !toExclude.contains(id))
										.limit(reqChar.getNumOfCharacters())
										.collect(toList());
		
		// send second query with filtered ids and get full character data
		String query = QUERY_IDS.replace("{LIST}", ids.toString());
		List<CharacterInfo> resp = post(query, CharactersInfoResponse.class)
														.data.charactersByIds;
		
		List<CharacterIndex> characters = popularity.getPopularity(resp);
		characters.sort(comparingDouble(CharacterIndex::getPopularityIndex));
		
		return characters;
	}

	private <T> T post(String requestBody, Class<T> clazz) {
		return WebClient.create(URL)
						.post()
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)
						.bodyValue(requestBody)
						.retrieve()
						.bodyToMono(clazz)
						.block();
	}
}
