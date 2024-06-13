public class Veicolo {

    private String marca;
    private String modello;
    private int prezzo;
    private String targa;
    private char patente;
    private boolean tipo;

    public Veicolo(String marca, String modello, int prezzo, String targa, char patente, boolean tipo) {
        this.marca = marca;
        this.modello = modello;
        this.prezzo = prezzo;
        this.targa = targa;
        this.patente = patente;
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public String getTarga() {
        return targa;
    }

    public char getPatente() {
        return patente;
    }

    public boolean isTipo() {
        return tipo;
    }

    //Metodo getter che stampa tutti gli attributi di Veicolo
    public void getAll(){
        if(tipo){
            System.out.println("Dati dell'automobile");
            System.out.println("Marca: " + marca);
            System.out.println("Modello: " + modello);
            System.out.println("Prezzo: " + prezzo);
            System.out.println("Targa: " + targa);
            System.out.println("Patente: " + patente);
        }else{        
            System.out.println("Dati della motocicletta");
            System.out.println("Marca: " + marca);
            System.out.println("Modello: " + modello);
            System.out.println("Prezzo: " + prezzo);
            System.out.println("Targa: " + targa);
            System.out.println("Patente: " + patente);
        }
    
    }
}
