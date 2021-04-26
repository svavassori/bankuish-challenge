package service;

import java.util.List;

import character.CharacterIndex;
import character.CharacterInfo;

public interface Popularity {
	
	/**
	 * Returns the list of Characters with the respective popularity index.
	 * 
	 * @param characters the {@link CharacterInfo} to query for popularity
	 * @return the list of {@link CharacterInfo} with their popularity index
	 */
	List<CharacterIndex> getPopularity(List<CharacterInfo> characters);
}
