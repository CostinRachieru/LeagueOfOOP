public final class Lawyer extends Person {
    @Override
    public void isSalutedBy(Person person) {
        person.salute(this);
    }

    @Override
    public void salute(Doctor doctor) {
        System.out.println("L-D: Hello, sir!");
    }

    @Override
    public void salute(Engineer engineer) {
        System.out.println("L-E: Hi, mister!");
    }

    @Override
    public void salute(Lawyer lawyer) {
        System.out.println("L-L: Law has the power, brother lawyer!");
    }
}
