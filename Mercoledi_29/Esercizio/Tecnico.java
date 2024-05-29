// Definizione di una classe concreta chiamata Tecnico che estende la classe astratta Dipendente
class Tecnico extends Dipendente {
    
    // Costruttore della classe Tecnico che inizializza i campi nome e stipendio
    // Utilizza il costruttore della superclasse Dipendente
    public Tecnico(String nome, double stipendio) {
        super(nome, stipendio);
    }

    // Implementazione del metodo astratto calcolaBonus definito nella classe Dipendente
    // In questo caso, il bonus del Tecnico è calcolato come il 15% del suo stipendio
    @Override
    public double calcolaBonus() {
        return stipendio * 0.15;
    }
}
