package arrays;

import java.util.Arrays;

public class LibraryManagementService {
	public static void main(String[] args) {

		Book book1 = new Book("Sherlock Homes", "Arthur Conan Doyle", " Detective fiction", true);
		Book book2 = new Book("Pride and Prejudice", "Jane Austen", "Jane Austen", true);
		Book book3 = new Book("Anne of Green Gables", "Jane Eyre", "Drama", true);
		Book book4 = new Book("Leave it to PSmith", "P G Wodehouse", "Comedy", true);
		Book book5 = new Book("Angels and Demons", "Dan Brown", "Suspense", true);

		Book[] books = { book1, book2, book3, book4, book5 };

		Book book6 = new Book("Jurassic Park", "Michael Crichton", "Science fiction", true);

		Library library = new Library("Greenville Public Library", "Main Street", "Greenville", books);
		library.addBook(book6);
		
		
		library.returnBook("Leave it to PSmith");
		library.borrowBook("Summer Moonshine");
		library.borrowBook("Leave it to PSMITH");
		library.returnBook("Leave it to Psmith");
		book6.addBook(book6);
		Book book7 = new Book("Matilda", "Roald Dahl", "Fantasy fiction", true);
		book7.addBook(book7);
		library.borrowBook("Jurassic Park");
		library.borrowBook("Sherlock Holmes");
		System.out.println(Arrays.toString(library.getBooks()));

	}
}