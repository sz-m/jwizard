public class Main {
    public static void main(String[] args) {
        Wizard wizard = new Wizard("Wizard");
        wizard.addStep("Imię");
        wizard.addStep("Nazwisko", true);
        wizard.addStep("Adres");
        wizard.addStep("Numer telefonu");
        wizard.generate();
    }
}
