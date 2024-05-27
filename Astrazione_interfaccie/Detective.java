public class Detective implements  Agente{

    public String nome;
    public String cognome;
    public String matricola;
    
    public Detective(String nome, String cognome, String matricola){
        this.nome=nome;
        this.cognome=cognome;
        this.matricola=matricola;
    }

    @Override
    public void descriviLavoro() {
        System.out.println("Investiga sul caso");
    }

    @Override
    public void ottieniMatricola() {
        System.out.println(matricola);
        
    }
    // @Override
    // public void stampa(){
    //     System.out.println("E' un detective");
    //     super.stampa();
    // }
    
}
