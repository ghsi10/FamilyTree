public class TreePerson extends Person {
	public Person marriedTo;
	public PersonList children;
	public Relationship relationship;
	public enum Relationship {
		single, married, divorce;
	}
	public TreePerson(int id, String name, Gender gender) {
		super(id, name, gender);
		this.relationship = Relationship.single;
		children = new PersonList();
	}
}
