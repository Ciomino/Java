// Definizione di una classe concreta chiamata Manager che estende la classe astratta Dipendente
class Manager extends Dipendente {
    
    // Costruttore della classe Manager che inizializza i campi nome e stipendio
    // Utilizza il costruttore della superclasse Dipendente
    public Manager(String nome, double stipendio) {
        super(nome, stipendio);
    }

    // Implementazione del metodo astratto calcolaBonus definito nella classe Dipendente
    // In questo caso, il bonus del Manager è calcolato come il 20% del suo stipendio
    @Override
    public double calcolaBonus() {
        return stipendio * 0.20;
    }
}
