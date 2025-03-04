import java.util.HashSet;
import java.util.Objects;

class Book {
    String title;
    String author;

   
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

   
    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author;
    }
}

public class Main {
    public static void main(String[] args) {
        HashSet<Book> bookSet = new HashSet<>();

        
        bookSet.add(new Book("Java Programming", "James Gosling"));
        bookSet.add(new Book("Python Basics", "Guido van Rossum"));
        bookSet.add(new Book("Java Programming", "James Gosling")); // Duplicate

        for (Book book : bookSet) {
            System.out.println(book);
        }
    }
}

// output
// Title: Python Basics, Author: Guido van Rossum
// Title: Java Programming, Author: James Gosling
