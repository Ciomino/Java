// Definizione di una classe astratta chiamata Dipendente che implementa l'interfaccia BonusCalcolabile
abstract class Dipendente implements BonusCalcolabile {
    
    // Attributi della classe Dipendente: nome e stipendio
    public String nome;
    public double stipendio;

    // Costruttore della classe Dipendente che inizializza i campi nome e stipendio
    public Dipendente(String nome, double stipendio) {
        this.nome = nome;
        this.stipendio = stipendio;
    }

    // Metodo astratto che deve essere implementato dalle classi concrete che estendono Dipendente
    // Questo metodo sarà usato per calcolare il bonus specifico del dipendente
    @Override
    public abstract double calcolaBonus();
}
