public class PersonList {
	private Node first;
	public PersonList() {
		first = null;
	}
	public void insert(TreePerson person) {
		first = new Node(person, first);
	}
	public void clear() {
		first = null;
	}
	public IteratorTP iterator() {
		return new TreePersonIter(first);
	}
}