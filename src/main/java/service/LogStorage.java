package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import client.RequestCharacters;

/**
 * Simply logs all request to a logger.
 */
@Component
public class LogStorage implements Storage {

	private static final Logger logger = LoggerFactory.getLogger(LogStorage.class);
	
	@Override
	public void store(RequestCharacters request) {
		
		logger.info(request.toString());
	}
}
