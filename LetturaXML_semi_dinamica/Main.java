import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {
    // Contatore per generare ID univoci per ogni persona
    private static int idCounter = 1;
    // Documento XML e radice dell'albero XML
    private static Document document;
    private static Element root;
    // Mappa per associare ID a oggetti Persona
    private static Map<Integer, Person> personMap = new HashMap<>();

    public static void main(String[] args) {
        try {
            // Inizializzazione del documento XML
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            document = documentBuilder.newDocument();

            // Creazione dell'elemento radice
            root = document.createElement("persons");
            document.appendChild(root);

            Scanner scanner = new Scanner(System.in);
            String choice;

            do {
                // Menu per l'utente
                System.out.println("1. Aggiungi nuovo utente");
                System.out.println("2. Cerca utente per ID");
                System.out.println("3. Esci");
                System.out.print("Scelta: ");
                choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        // Aggiunta di un nuovo utente
                        addNewUser();
                        break;
                    case "2":
                        // Ricerca di un utente per ID
                        searchUserById();
                        break;
                    case "3":
                        // Uscita dal programma
                        System.out.println("Uscita...");
                        break;
                    default:
                        System.out.println("Scelta non valida");
                }
            } while (!choice.equals("3"));

        } catch (ParserConfigurationException e) {
            // Gestione delle eccezioni
            e.printStackTrace();
        }
    }

    // Metodo per aggiungere un nuovo utente
    public static void addNewUser() {
        Scanner scanner = new Scanner(System.in);

        // Acquisizione dei dati dell'utente
        System.out.print("Inserisci nome: ");
        String nome = scanner.nextLine();

        System.out.print("Inserisci età: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Inserisci informazioni: ");
        String info = scanner.nextLine();

        // Creazione di un oggetto Persona
        Person person = new Person(nome, age, info);
        // Aggiunta dell'utente alla mappa e all'XML
        personMap.put(idCounter, person);
        addPersonToXML(person);

        System.out.println("Utente aggiunto con successo!");
    }

    // Metodo per cercare un utente per ID
    public static void searchUserById() {
        Scanner in = new Scanner(System.in);
        System.out.print("Inserisci ID dell'utente da cercare: ");
        int id = in.nextInt();

        // Ottenere la lista delle persone dall'XML
        NodeList personList = root.getElementsByTagName("person");

        for (int i = 0; i < personList.getLength(); i++) {
            Node personNode = personList.item(i);

            if (personNode.getNodeType() == Node.ELEMENT_NODE) {
                // Ottenere l'elemento persona
                Element personElement = (Element) personNode;
                int personId = Integer.parseInt(personElement.getAttribute("id"));

                // Verifica se l'ID corrisponde
                if (personId == id) {
                    // Stampare le informazioni dell'utente
                    System.out.println("Nome: " + personElement.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("Età: " + personElement.getElementsByTagName("age").item(0).getTextContent());
                    System.out.println("Informazioni: " + personElement.getElementsByTagName("info").item(0).getTextContent());
                    return;
                }
            }
        }

        System.out.println("Utente non trovato.");
    }

    // Metodo per aggiungere una persona all'XML
    public static void addPersonToXML(Person person) {
        // Creazione dell'elemento persona
        Element personElement = document.createElement("person");
        personElement.setAttribute("id", String.valueOf(idCounter++));

        // Aggiunta del nome
        Element nameElement = document.createElement("name");
        nameElement.appendChild(document.createTextNode(person.getNome()));
        personElement.appendChild(nameElement);

        // Aggiunta dell'età
        Element ageElement = document.createElement("age");
        ageElement.appendChild(document.createTextNode(String.valueOf(person.getAge())));
        personElement.appendChild(ageElement);

        // Aggiunta delle informazioni
        Element infoElement = document.createElement("info");
        infoElement.appendChild(document.createTextNode(person.getInfo()));
        personElement.appendChild(infoElement);

        // Aggiunta dell'elemento persona all'elemento radice
        root.appendChild(personElement);
    }
}
