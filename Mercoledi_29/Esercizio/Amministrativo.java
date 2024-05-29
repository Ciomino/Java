class Amministrativo extends Dipendente {
    public Amministrativo(String nome, double stipendio) {
        super(nome, stipendio);
    }

    @Override
    public double calcolaBonus() {
        return stipendio * 0.10;
    }
}