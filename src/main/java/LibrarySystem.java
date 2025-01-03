import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    protected List<String> books; // Changed access to protected for testability
    protected List<String> borrowedBooks;

    public LibrarySystem() {
        books = new ArrayList<>();
        borrowedBooks = new ArrayList<>();
        initializeLibrary();
    }

    private void initializeLibrary() {
        // Initialize the library with default books
        books.add("Moby Dick");
        books.add("To Kill a Mockingbird");
        books.add("The Great Gatsby");
        books.add("1984");
        books.add("Pride and Prejudice");
    }

    public void displayAvailableBooks() {
        System.out.println("Available books:");
        if (books.isEmpty()) {
            System.out.println("No books are currently available.");
        } else {
            books.forEach(System.out::println);
        }
    }

    public String borrowBook(String bookName) {
        if (!books.contains(bookName)) {
            return "Error: Book not found in the library.";
        }
        if (borrowedBooks.contains(bookName)) {
            return "Error: This book is already borrowed.";
        }
        books.remove(bookName);
        borrowedBooks.add(bookName);
        return "You have successfully borrowed: " + bookName;
    }

    public String returnBook(String bookName) {
        if (!borrowedBooks.contains(bookName)) {
            return "Error: This book was not borrowed.";
        }
        borrowedBooks.remove(bookName);
        books.add(bookName);
        return "You have successfully returned: " + bookName;
    }

    public void displayBorrowedBooks() {
        System.out.println("Borrowed books:");
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books are currently borrowed.");
        } else {
            borrowedBooks.forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        // Display initial available books
        library.displayAvailableBooks();

        // Borrow books
        System.out.println(library.borrowBook("Moby Dick"));
        System.out.println(library.borrowBook("The Great Gatsby"));
        System.out.println(library.borrowBook("1984"));

        // Display available and borrowed books
        library.displayAvailableBooks();
        library.displayBorrowedBooks();

        // Return books
        System.out.println(library.returnBook("Moby Dick"));
        System.out.println(library.returnBook("To Kill a Mockingbird")); // Book not borrowed

        // Display final available and borrowed books
        library.displayAvailableBooks();
        library.displayBorrowedBooks();
    }
}
