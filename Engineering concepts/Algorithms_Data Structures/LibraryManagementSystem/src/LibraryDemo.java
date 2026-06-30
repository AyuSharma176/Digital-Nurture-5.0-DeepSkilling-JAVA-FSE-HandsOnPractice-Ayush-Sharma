public class LibraryDemo {
    public static void main(String[] args) {
        Book[] books = {
                new Book(1, "The Hobbit", "J.R.R. Tolkien"),
                new Book(2, "1984", "George Orwell"),
                new Book(3, "Dune", "Frank Herbert"),
                new Book(4, "Brave New World", "Aldous Huxley"),
                new Book(5, "Fahrenheit 451", "Ray Bradbury")
        };

        System.out.println("Linear search for 'Dune':");
        Book found = LibrarySearch.linearSearchByTitle(books, "Dune");
        System.out.println(found != null ? found : "Not found");

        LibrarySearch.sortByTitle(books);
        System.out.println("\nSorted by title:");
        for (Book b : books) System.out.println(b);

        System.out.println("\nBinary search for 'The Hobbit':");
        found = LibrarySearch.binarySearchByTitle(books, "The Hobbit");
        System.out.println(found != null ? found : "Not found");
    }
}