package week1.day2;

public class Library {

public static void main(String[] args) {
          
     // Creating an object of the Library class
     Library Book1 = new Library();
     
     // Calling the addBook method with a null argument
     Book1.addBook(null);
     
     // Calling the issueBook method
     Book1.issueBook();
     }

 // Method to add a book to the library
 public String addBook(String bookTitle) {
     
     System.out.println("Book added successfully");
     
     // Returning the book title
     return bookTitle;
     }

 // Method to issue a book from the library
 public void issueBook() {
     // Printing a success message
     System.out.println("Book issued successfully");
     }
}

