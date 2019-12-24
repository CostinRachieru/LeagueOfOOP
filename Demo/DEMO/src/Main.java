import java.util.LinkedList;

public final class Main {
    public static void main(String[] args) {
        LinkedList<Person> persons = new LinkedList<>();
        PersonFactory personFactory = PersonFactory.getInstance();

        persons.add(personFactory.createPerson("Doctor"));
        persons.add(personFactory.createPerson("Lawyer"));
        persons.add(personFactory.createPerson("Engineer"));

        for (int i = 0; i < persons.size(); ++i) {
            for (int j = 0; j < persons.size(); ++j) {
                persons.get(i).isSalutedBy(persons.get(j));
            }
            System.out.println();
        }
    }
}
