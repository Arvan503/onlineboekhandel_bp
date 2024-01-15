import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Book;
import entity.User;
import service.BookService;
import service.UserService;

public class Main {
    private static BookService bookService = new BookService();
    private static UserService userService = new UserService();

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Create a book");
            System.out.println("2. Read a book");
            System.out.println("3. Update a book");
            System.out.println("4. Delete a book");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the title:");
                    String title = scanner.next();

                    System.out.println("Enter the author:");
                    String author = scanner.next();

                    System.out.println("Enter the genre:");
                    String genre = scanner.next();

                    System.out.println("Enter the description:");
                    String description = scanner.next();

                    System.out.println("Enter the price:");
                    BigDecimal price = scanner.nextBigDecimal();

                    System.out.println("Enter the stock quantity:");
                    int stockQuantity = scanner.nextInt();

                    System.out.println("Enter the publication date (yyyy-mm-dd):");
                    String publicationDate = scanner.next();

                    System.out.println("Enter the ISBN number:");
                    String isbnNumber = scanner.next();

                    System.out.println("Enter the copy:");
                    int copy = scanner.nextInt();

                    Book book = new Book();
                    book.setTitle(title);
                    book.setAuthor(author);
                    book.setGenre(genre);
                    book.setDescription(description);
                    book.setPrice(price);
                    book.setStockQuantity(stockQuantity);
                    book.setPublicationDate(publicationDate);
                    book.setIsbnNumber(isbnNumber);
                    book.setCopy(copy);

                    bookService.createBook(book);

                    System.out.println("Book created successfully!");
                    break;

                case 2:
                    System.out.println("Enter the ID of the book:");
                    int id = scanner.nextInt();

                    book = bookService.getBookById(id);

                    if (book != null) {
                        System.out.println("Title: " + book.getTitle());
                        System.out.println("Author: " + book.getAuthor());
                        System.out.println("Genre: " + book.getGenre());
                        System.out.println("Description: " + book.getDescription());
                        System.out.println("Price: " + book.getPrice());
                        System.out.println("Stock Quantity: " + book.getStockQuantity());
                        System.out.println("Publication Date: " + book.getPublicationDate());
                        System.out.println("ISBN Number: " + book.getIsbnNumber());
                        System.out.println("Copy: " + book.getCopy());
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3:
                    System.out.println("Enter the ID of the book:");
                    id = scanner.nextInt();

                    book = bookService.getBookById(id);

                    if (book != null) {
                        System.out.println("Enter the new title:");
                        title = scanner.next();
                        book.setTitle(title);

                        System.out.println("Enter the new author:");
                        author = scanner.next();
                        book.setAuthor(author);

                        System.out.println("Enter the new genre:");
                        genre = scanner.next();
                        book.setGenre(genre);

                        System.out.println("Enter the new description:");
                        description = scanner.next();
                        book.setDescription(description);

                        System.out.println("Enter the new price:");
                        price = new BigDecimal(scanner.next());
                        book.setPrice(price);

                        System.out.println("Enter the new stock quantity:");
                        stockQuantity = scanner.nextInt();
                        book.setStockQuantity(stockQuantity);

                        System.out.println("Enter the new publication date (yyyy-mm-dd):");
                        publicationDate = scanner.next();
                        book.setPublicationDate(publicationDate);

                        System.out.println("Enter the new ISBN number:");
                        isbnNumber = scanner.next();
                        book.setIsbnNumber(isbnNumber);

                        System.out.println("Enter the new copy:");
                        copy = scanner.nextInt();
                        book.setCopy(copy);

                        bookService.updateBook(book);

                        System.out.println("Book updated successfully!");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.println("Enter the ID of the book:");
                    id = scanner.nextInt();

                    bookService.deleteBook(id);

                    System.out.println("Book deleted successfully!");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    

//       List<Book> books = bookService.getallbookTitles();
//
//        books.forEach(book -> {
//            System.out.println(" Title = " + book.getTitle() + " Price = " + book.getPrice());
//        });
//
//    }



//        List<User> users = userService.getallusernamesandpasswords();
//
//        users.forEach(user -> {
//            System.out.println(" Username = " + user.getUsername() + " Password = " + user.getPassword());
//        });




//        BookService bookService = new BookService();
//
//        // Create a list of books
//        List<Book> booksToAdd = new ArrayList<>();
//
//        Book book1 = new Book();
//        book1.setTitle("The Shining");
//        book1.setAuthor("Stephen King");
//        book1.setGenre("Horror");
//        book1.setDescription("A psychological horror novel that explores supernatural occurrences in an isolated hotel.");
//        book1.setPrice(new BigDecimal("22.99"));
//        book1.setStockQuantity(85);
//        book1.setPublicationDate("1977-01-28");
//        book1.setIsbnNumber("9780385121675");
//        book1.setCopy(15);
//
//        // Call the createBooks method to insert the books
//        List<Book> createdBooks = bookService.createBooks(booksToAdd);


    }





