public final class Doctor extends Person {
    @Override
    public void isSalutedBy(Person person) {
        person.salute(this);
    }

    @Override
    public void salute(Doctor doctor) {
        System.out.println("D-D: Hi, doc! Have a good day!");
    }

    @Override
    public void salute(Engineer engineer) {
        System.out.println("D-E: Hello!");
    }

    @Override
    public void salute(Lawyer lawyer) {
        System.out.println("D-L: Good afternoon!");
    }
}
