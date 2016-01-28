public class Person {
	public int id;
	public String name;
	public Gender gender;
	public enum Gender {
		male, female;
	}
	public Person(int id, String name, Gender gender) {
		this.id = id;
		this.name = name;
		this.gender = gender;
	}
	public String toString() {
		return "id:" + id + " name:" + name;
	}
}