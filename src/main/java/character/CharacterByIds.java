package character;
import static java.util.stream.Collectors.toList;

import java.util.List;

/**
 * Temporary POJO to query Characters by Ids.
 */
public class CharacterByIds {

	public Data data;
	
	public List<Integer> getIds() {
		
		return data.characters.results.stream()
										.mapToInt(id -> id.id)
										.boxed()
										.collect(toList());
	}
	
	public static class Data {
		
		public Characters characters;
	}
	
	public static class Characters {
		
		public List<IDS> results;
	}
	
	public static class IDS {
		
		public int id;
	}
}
