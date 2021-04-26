package character;
import java.util.Objects;

/**
 * This class models the output Character index returned to a client.
 */
public class CharacterIndex {

	private CharacterInfo character;
	private double popularityIndex;

	public CharacterIndex(CharacterInfo character, double populatiryIndex) {

		if (populatiryIndex < 0) {

			throw new IllegalArgumentException("Index cannot be negative: " + populatiryIndex);
		}

		this.character = Objects.requireNonNull(character);
		this.popularityIndex = populatiryIndex;
	}

	public CharacterInfo getCharacter() {
		return character;
	}

	public double getPopularityIndex() {
		return popularityIndex;
	}

	@Override
	public String toString() {
		return "CharacterIndex [character=" + character + ", popularityIndex=" + popularityIndex + "]";
	}
}
