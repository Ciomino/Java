abstract class Dipendente implements BonusCalcolabile{
    public String nome;
    public double stipendio;

    public Dipendente(String nome, double stipendio) {
        this.nome = nome;
        this.stipendio = stipendio;
    }

    @Override
    public abstract double calcolaBonus();

    
}
