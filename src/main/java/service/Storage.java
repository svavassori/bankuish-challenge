package service;

import client.RequestCharacters;

public interface Storage {

	/**
	 * Stores the given {@link RequestCharacters} to a persistent storage.
	 * 
	 * @param request the {@link RequestCharacters} to store.
	 */
	void store(RequestCharacters request);
}
