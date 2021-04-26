package character;

/**
 * Simple POJO for Episode data
 */
public class Episode {

	private int id;
	private String name;
	
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
	@Override
	public String toString() {
		return "Episode [id=" + id + ", name=" + name + "]";
	}
}
