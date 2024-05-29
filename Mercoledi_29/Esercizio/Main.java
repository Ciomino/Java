public class Main{
    public static void main(String[] args) {
        Dipendente admin = new Amministrativo("Mirko Campari", 30000);
        Dipendente tecnico = new Tecnico("Manuel Di Nardo", 40000);
        Dipendente manager = new Manager("Francesco Gionta", 50000);

        System.out.println(admin.nome + " ha un bonus annuale di: " + admin.calcolaBonus());
        System.out.println(tecnico.nome + " ha un bonus annuale di: " + tecnico.calcolaBonus());
        System.out.println(manager.nome + " ha un bonus annuale di: " + manager.calcolaBonus());
    }
}