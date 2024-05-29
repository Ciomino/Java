// Definizione di una classe concreta chiamata Amministrativo che estende la classe astratta Dipendente
class Amministrativo extends Dipendente {
    
    // Costruttore della classe Amministrativo che inizializza i campi nome e stipendio
    // Utilizza il costruttore della superclasse Dipendente
    public Amministrativo(String nome, double stipendio) {
        super(nome, stipendio);
    }

    // Implementazione del metodo astratto calcolaBonus definito nella classe Dipendente
    // In questo caso, il bonus dell'Amministrativo è calcolato come il 10% del suo stipendio
    @Override
    public double calcolaBonus() {
        return stipendio * 0.10;
    }
}
