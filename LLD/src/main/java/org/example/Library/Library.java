package org.example.Library;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class Library {

    private Map<String, Book> books;

    public Library() {
        books = new HashMap<>();
    }

    // Add Book
    public void addBook(Book book) {
        if (books.containsKey(book.getId())) {
            System.out.println("Book with this ID already exists.");
            return;
        }

        books.put(book.getId(), book);
        System.out.println("Book added successfully.");
    }

    // View All Books
    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        Collection<Book> allBooks = books.values();
        for (Book book : allBooks) {
            book.display();
        }
    }

    // Issue Book
    public void issueBook(String id) {
        Book book = books.get(id);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (book.isIssued()) {
            System.out.println("Book already issued.");
        } else {
            book.issue();
            System.out.println("Book issued successfully.");
        }
    }

    // Return Book
    public void returnBook(String id) {
        Book book = books.get(id);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!book.isIssued()) {
            System.out.println("Book was not issued.");
        } else {
            book.returnBook();
            System.out.println("Book returned successfully.");
        }
    }

    // Search By Author
    public void searchByAuthor(String authorName) {

        boolean found = false;

        for (Book book : books.values()) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                book.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found by this author.");
        }
    }
}
