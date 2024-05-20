package lms;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LMS {

    List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        if (book.getTitle().equals(book.title)) {
            books.remove(book);
            return;
        }
    }

    public void borrowBook(Book book, Student student) {
        if (book.getTitle().equals(book.title)) {
            book.setBorrower(student);
            return;
        }
    }

    public void returnBook(Book book) {
        if (book.getTitle().equals(book.title)) {
            book.setBorrower(null);
            return;
        }

    }

    public void saveState(List<Book> books, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Book book : books) {
                writer.println(book.getTitle() + "," + book.getAuthor());
            }
            System.out.println("State saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving state: " + e.getMessage());
        }
    }



    public List<Book> loadState(String filename) {
        List<Book> loadedBooks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String title = parts[0];
                    String author = parts[1];
                    boolean available = Boolean.parseBoolean(parts[2]);
                    loadedBooks.add(new Book(title, author));
                }
            }
            System.out.println("State loaded successfully.");
        } catch (IOException e) {
            System.err.println("Error loading state: " + e.getMessage());
        }
        return loadedBooks;
    }
    public List<Book> getBooks() {
        return books;
    }
}
