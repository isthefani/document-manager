package comFlyweight;

import java.util.HashMap;
import java.util.Map;

// 1. Flyweight (Interface)
interface Document {
    void printContent(String author);
}

// 2. ConcreteFlyweight
class ConcreteDocument implements Document {
    private String content;

    public ConcreteDocument(String content) {
        this.content = content;
    }

    public void printContent(String author) {
        System.out.println("Documento: " + content + " | Autor: " + author);
    }
}

// 3. FlyweightFactory
class DocumentFactory {
    private Map<String, Document> documents = new HashMap<>();

    public Document getDocument(String content) {
        // Verifica se o objeto já existe na memória
        if (documents.containsKey(content)) {
            return documents.get(content);
        } else {
            // Caso contrário, cria um novo objeto e o armazena na memória
            Document document = new ConcreteDocument(content);
            documents.put(content, document);
            return document;
        }
    }

    public int getCacheSize() {
        return documents.size();
    }
}

// 4. Cliente
public class Main {
    public static void main(String[] args) {
        DocumentFactory documentFactory = new DocumentFactory();

        Document doc1 = documentFactory.getDocument("Conteúdo 1");
        doc1.printContent("Autor 1");

        Document doc2 = documentFactory.getDocument("Conteúdo 2");
        doc2.printContent("Autor 2");

        Document doc3 = documentFactory.getDocument("Conteúdo 1");
        doc3.printContent("Autor 3");

        System.out.println();

        int cacheSize = documentFactory.getCacheSize();

        System.out.println("Total de objetos criados: " + cacheSize);
        System.out.println("O Documento 2 foi criado com base em um objeto já existente? " + (doc2 == doc1));
        System.out.println("O Documento 3 foi criado com base em um objeto já existente? " + (doc3 == doc1));
    }
}
