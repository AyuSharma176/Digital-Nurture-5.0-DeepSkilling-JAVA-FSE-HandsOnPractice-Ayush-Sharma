public class FactoryMethodDemo {

    public static void main(String[] args) {

        DocumentFactory factory;

        // Word
        factory = new WordDocumentFactory();
        Document doc1 = factory.createDocument();
        doc1.open();

        // PDF
        factory = new PdfDocumentFactory();
        Document doc2 = factory.createDocument();
        doc2.open();

        // Excel
        factory = new ExcelDocumentFactory();
        Document doc3 = factory.createDocument();
        doc3.open();
    }
}