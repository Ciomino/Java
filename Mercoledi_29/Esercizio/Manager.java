class Manager extends Dipendente {
    public Manager(String nome, double stipendio) {
        super(nome, stipendio);
    }

    @Override
    public double calcolaBonus() {
        return stipendio * 0.20;
    }
}