public class PersonList {
	private Node first;
	public PersonList() {
		first = null;
	}
	public void insert(TreePerson person) {
		Node node = new Node(person, first);
		first = node;
	}
	public void clear() {
		first = null;
	}
	public IteratorTP iterator() {
		return new TreePersonIter(first);
	}
}