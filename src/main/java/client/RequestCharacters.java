package client;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class models the input request of characters from client.
 */
public class RequestCharacters {
	
	private int numOfCharacters;
	private Set<Integer> excludedIds;
	
	@JsonCreator
	public RequestCharacters(@JsonProperty("numOfCharacters") int numOfCharacters,
							 @JsonProperty("excludedIds") Set<Integer> excludedIds) {
		
		if (numOfCharacters < 1 || numOfCharacters > 5) {
			
			throw new IllegalArgumentException("Number of requested characters "
										+ "must be [1,5]: " + numOfCharacters);
		}
		
		this.numOfCharacters = numOfCharacters;
		this.excludedIds = excludedIds == null ? Set.of() : excludedIds;
	}
	
	public int getNumOfCharacters() {
		return numOfCharacters;
	}
	
	public Set<Integer> getExcludedIds() {
		return excludedIds;
	}

	@Override
	public String toString() {
		return "RequestCharacters [numOfCharacters=" + numOfCharacters +
				", excludedIds=" + excludedIds + "]";
	}
}
