public class Tree {
	public Person father;
	public Person mother;
	public PersonList children;
	public Tree(int motherId, String motherName, int fatherId, String fatherName) {
		father = new Person(fatherId, fatherName, Person.Gender.male);
		mother = new Person(motherId, motherName, Person.Gender.female);
		children = new PersonList();
	}
	public void marry(int id, int otherId, String otherName, Person.Gender otherGender) {
		TreePerson p = (TreePerson)findPerson(id);
		
		if (p.relationship != TreePerson.Relationship.married) {
			p.marriedTo = new Person(otherId, otherName, otherGender);
			p.relationship = TreePerson.Relationship.married;
		}
	}
	public void divorce(int motherId, int fatherId, String custody) {
		TreePerson p = (TreePerson)findPerson(motherId);
		if (p == null)
			p = (TreePerson)findPerson(fatherId);
		
		if ((p.gender == Person.Gender.female && custody.equals("With Father")) ||
			(p.gender == Person.Gender.male && custody.equals("With Mother"))) {
			p.children.clear();
		}
		
		p.marriedTo = null;
		p.relationship = TreePerson.Relationship.divorce;
	}
	public void haveAKid(int motherId, int fatherId, int kidId, String kidName, Person.Gender kidGender) {
		if (motherId == mother.id && fatherId == father.id) {
			children.insert(new TreePerson(kidId, kidName, kidGender));
			return;
		}
		
		TreePerson p = (TreePerson)findPerson(motherId);
		
		if (p == null)
			p = (TreePerson)findPerson(fatherId);
		
		p.children.insert(new TreePerson(kidId, kidName, kidGender));
	}
	private Person findPerson(int id) {
		if (father.id==id)
			return father;
		if (mother.id==id)
			return mother;
		return findPerson(id, children.iterator());
	}
	private TreePerson findPerson(int id, IteratorTP iter) {	
		if (!iter.hasNext())
			return null;
		TreePerson tmp = iter.next();
		if (tmp.id == id)
			return tmp;
		tmp = findPerson(id, tmp.children.iterator());
		if (tmp != null)
			return tmp;
		return findPerson(id, iter);
	}
	public void show() {
		System.out.println(father);
		System.out.println(mother);
		System.out.println();
		show("\t", children.iterator());
	}
	private void show(String lvl, IteratorTP iter) {
		if (!iter.hasNext())
			return;
		System.out.print(lvl);
		TreePerson p = iter.next();
		System.out.println(p);
		if (p.relationship == TreePerson.Relationship.married) {
			System.out.print(lvl);
			System.out.println(p.marriedTo);
		}
		System.out.println();
		show(lvl+"\t", p.children.iterator());
		show(lvl, iter);
	}
}