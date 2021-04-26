package service;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.stereotype.Component;

import character.CharacterIndex;
import character.CharacterInfo;

/**
 * For the moment it's a mocked method, in the future should call the
 * remote service.
 */
@Component
public class PopularityLocalService implements Popularity {

	@Override
	public List<CharacterIndex> getPopularity(List<CharacterInfo> characters) {
		
		// We generate the popularity index with this formula: index = x/e^(x/3)
		// where x is the id of the character
		return characters.stream().map(c -> {
			int x = c.getId();
			double index = x / Math.exp(x / 3);
			return new CharacterIndex(c, index);
		}).collect(toList());
	}
}
