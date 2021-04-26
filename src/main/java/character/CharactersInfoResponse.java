package character;
import java.util.List;

/**
 * Temporary POJO to query characters info data.
 */
public class CharactersInfoResponse {

	public Data data;
	
	
	public static class Data {
		
		public List<CharacterInfo> charactersByIds;
	}
}
