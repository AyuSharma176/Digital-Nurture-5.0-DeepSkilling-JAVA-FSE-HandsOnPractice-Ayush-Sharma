public abstract class DocumentFactory {

    // Factory method
    public abstract Document createDocument();

    // Optional: a template method showing typical usage
    public Document openNewDocument() {
        Document doc = createDocument();
        doc.open();
        return doc;
    }
}