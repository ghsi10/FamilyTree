public class Main {
	public static void main(String[] args) {
		Tree family = new Tree(1, "Eve", 2, "Adam");
		family.haveAKid(1, 2, 3, "1-1", Person.Gender.male);
		family.haveAKid(1, 2, 4, "1-2", Person.Gender.female);
		family.haveAKid(1, 2, 5, "1-3", Person.Gender.male);
		family.haveAKid(1, 2, 6, "1-4", Person.Gender.female);
		family.marry(4, 15, "father1", Person.Gender.male);
		family.haveAKid(4, 15, 7, "4-2-1", Person.Gender.male);
		family.divorce(4, 15, "With Mother");
		family.show();
	}
}