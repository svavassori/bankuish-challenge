package character;

/**
 * Simple POJO for Origin data
 */
public class Origin {

	private int id;
	private String name;
	private String type;
	private String dimension;
	private String created;
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	@Override
	public String toString() {
		return "Origin [id=" + id + ", name=" + name + ", type=" + type + ", dimension=" + dimension + ", created="
				+ created + "]";
	}
}
