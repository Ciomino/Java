class Tecnico extends Dipendente {
    public Tecnico(String nome, double stipendio) {
        super(nome, stipendio);
    }

    @Override
    public double calcolaBonus() {
        return stipendio * 0.15;
    }
}
