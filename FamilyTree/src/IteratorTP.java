public interface IteratorTP {
	/**
	 * Check if there are more elements on iterator.
	 * @return true if the iteration has more elements.
	 */
    boolean hasNext();
	/**
	 * Get the next element.
	 * @return the next element of TreePerson.
	 */
    TreePerson next();
}
