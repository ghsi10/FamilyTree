public class TreePersonIter implements IteratorTP {
	private Node node;
	public TreePersonIter(Node node) {
		this.node = node;
	}
	@Override
	public boolean hasNext() {
		return node != null;
	}
	@Override
	public TreePerson next() {
		Node tmp = node;
		node = node.next;
		return tmp.value;
	}
}
