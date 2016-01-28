public class PersonList implements IterableTP {
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
	@Override
	public IteratorTP iterator() {
		return new TreePersonIter(first);
	}
}