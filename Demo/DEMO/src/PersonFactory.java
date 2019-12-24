final class PersonFactory {
    private static PersonFactory instance = null;

    private PersonFactory() { }

    static PersonFactory getInstance() {
        if (instance == null) {
            instance = new PersonFactory();
        }
        return instance;
    }

    Person createPerson(final String type) {
        switch (type) {
            case "Doctor": return new Doctor();
            case "Engineer": return new Engineer();
            case "Lawyer": return new Lawyer();
            default : return null;
        }
    }
}
