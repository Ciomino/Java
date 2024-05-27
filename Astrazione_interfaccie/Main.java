public class Main{
    public static void main(String[] args) {
        Poliziotto poli = new Poliziotto("Mirko", "Campari", "a1b2");
        Detective dete = new Detective("Mario", "Rossi", "c3d4");
        System.out.println("Il poliziotto:");
        poli.descriviLavoro();
        System.out.println("Il detective:");
        dete.descriviLavoro();

        Agente prova1 = new Detective("giorgio", "franco", "ahskda");
        System.out.println("Il detective prova1:");
        prova1.ottieniMatricola();

        Agente prova2 = new Poliziotto("franco", "giorgio", "shkjfdsh");
        System.out.println("Il poliziotto prova2:");
        prova2.ottieniMatricola();

        // prova1.stampa();
        // prova2.stampa();
    }
}