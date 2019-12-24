public final class Engineer extends Person {
    @Override
    public void isSalutedBy(Person person) {
        person.salute(this);
    }

    @Override
    public void salute(Doctor doctor) {
        System.out.println("E-D: Good day, doctor!");
    }

    @Override
    public void salute(Engineer engineer) {
        System.out.println("E-E: Yo, bro! Nice to see you!");
    }

    @Override
    public void salute(Lawyer lawyer) {
        System.out.println("E-L: Good evening!");
    }
}
