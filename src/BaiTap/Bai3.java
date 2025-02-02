package BaiTap;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Book implements Serializable {
    private String isbn;
    private String bookName;
    private String author;
    private String publisher;
    private float price;

    public String toString() {
        return "ISBN: " + isbn + ", Tên sách: " + bookName +
                ", Tác giả: " + author + ", NXB: " + publisher +
                ", Giá: " + price;
    }
}

class BookManager {
    private List<Book> books;

    public BookManager() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void saveToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Book book : books) {
                writer.write(book.toString());
                writer.newLine();
            }
        }
    }
}

class BookRead {
    public void readFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public void searchBook(String bookName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("book.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(bookName)) {
                    System.out.println("Tìm thấy sách: " + line);
                    return;
                }
            }
            System.out.println("Không tìm thấy sách tên '" + bookName + "'");
        }
    }
}