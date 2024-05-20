package lms;

public class LMSTester {
    public static void main(String[] args) {
        LMS iliauniLibrary = new LMS();

        Book harry = new Book("Harry Potter", "J. K. Rowling"); // new book
        Book lor = new Book("Lord of the rings", "tolkien");
        Book oop = new Book("OOP", "paata gogisvhili");
        iliauniLibrary.addBook(lor);
        iliauniLibrary.addBook(oop);
        iliauniLibrary.addBook(harry); // new book

        Student gocha = new Student("Gocha", "Gegeshidze", "dfasdf");
        iliauniLibrary.borrowBook(lor, gocha);

        Student maka = new Student("Maka", "Lobjanidze", "3421325");
        iliauniLibrary.borrowBook(oop, maka);

        Student oto = new Student("Otari", "kapanadze", "123523423");
        iliauniLibrary.borrowBook(harry, oto);

        iliauniLibrary.saveState(iliauniLibrary.getBooks(), "libraryState.txt"); // saves the state in libraryState.txt
        iliauniLibrary.loadState("libraryState.txt"); // loads the state in libraryState.txt

    }
}
