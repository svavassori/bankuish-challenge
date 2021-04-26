package character;
import java.util.List;

/**
 * Simple POJO for Character info data
 */
public class CharacterInfo {

	private int id;
	private String name;
	private String status;
	private String species;
	private String type;
	private String gender;
	private String image;
	private String created;
	private Origin origin;
	private List<Episode> episode;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public Origin getOrigin() {
		return origin;
	}
	public void setOrigin(Origin origin) {
		this.origin = origin;
	}
	public List<Episode> getEpisode() {
		return episode;
	}
	public void setEpisode(List<Episode> episode) {
		this.episode = episode;
	}
	@Override
	public String toString() {
		return "CharacterInfo [id=" + id + ", name=" + name + ", status=" + status + ", species=" + species + ", type="
				+ type + ", gender=" + gender + ", image=" + image + ", created=" + created + ", origin=" + origin
				+ ", episode=" + episode + "]";
	}
}
