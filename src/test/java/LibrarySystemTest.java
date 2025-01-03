import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibrarySystemTest {
    private LibrarySystem library;

    @BeforeEach
    void setUp() {
        library = new LibrarySystem();
    }

    @Test
    void testDisplayAvailableBooks() {
        // Test that the library initially has the correct number of books
        library.displayAvailableBooks(); // Manually verify if necessary
    }

    @Test
    void testBorrowBookSuccessfully() {
        library.borrowBook("Moby Dick");
        assertFalse(library.books.contains("Moby Dick"));
        assertTrue(library.borrowedBooks.contains("Moby Dick"));
    }

    @Test
    void testBorrowNonExistentBook() {
        library.borrowBook("Non-Existent Book");
        assertFalse(library.borrowedBooks.contains("Non-Existent Book"));
    }

    @Test
    void testBorrowAlreadyBorrowedBook() {
        library.borrowBook("Moby Dick");
        library.borrowBook("Moby Dick"); // Attempt to borrow again
        assertEquals(1, library.borrowedBooks.size());
    }

    @Test
    void testReturnBookSuccessfully() {
        library.borrowBook("Moby Dick");
        library.returnBook("Moby Dick");
        assertTrue(library.books.contains("Moby Dick"));
        assertFalse(library.borrowedBooks.contains("Moby Dick"));
    }

    @Test
    void testReturnBookNotBorrowed() {
        library.returnBook("To Kill a Mockingbird"); // Never borrowed
        assertTrue(library.books.contains("To Kill a Mockingbird"));
    }

    @Test
    void testDisplayBorrowedBooks() {
        library.borrowBook("Moby Dick");
        library.borrowBook("1984");
        library.displayBorrowedBooks(); // Manually verify if necessary
    }
}
