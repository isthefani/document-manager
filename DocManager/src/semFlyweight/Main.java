package semFlyweight;

// Classe Document sem o Flyweight
class Document {
    private String author;
    private String content;

    public Document(String author, String content) {
        this.author = author;
        this.content = content;
    }

    public void printContent() {
        System.out.println("Documento: " + content + " | Autor: " + author);
    }
}

// Client
public class Main {
    public static void main(String[] args) {
        Document doc1 = new Document("Autor 1", "Conteúdo 1");
        doc1.printContent();

        Document doc2 = new Document("Autor 2", "Contento 2");
        doc2.printContent();

        Document doc3 = new Document("Autor 1","Contento 3");
        doc3.printContent();

        System.out.println();

        System.out.println("O Documento 2 foi criado com base em um objeto já existente? " + (doc2 == doc1));
        System.out.println("O Documento 3 foi criado com base em um objeto já existente? " + (doc3 == doc1));
    }
}
