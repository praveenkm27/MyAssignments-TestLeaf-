package week1.day2;

public class LibraryManagement {

 public static void main(String[] args) {
     
     // Creating an object of the Library class
     Library Newbook1 = new Library();

     // Calling the addBook method with a null argument
     Newbook1.addBook(null);

     // Calling the issueBook method
     Newbook1.issueBook();
     }
}


