package arrays;

public class Library {
	private String name;
	private String address;
	private String city;
	private Book[] books = new Book[50];
	private int idx;
	Library(String name, String address, String city, Book[] books) {
		this.name = name;
		this.address = address;
		this.city = city;
		this.books = books;
		this.idx=0;
	}

	public Library() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Book[] getBooks() {
		return books;
	}

	public void setBooks(Book[] books) {
		this.books = books;
	}

//	List bookslist = Arrays.asList(books);  // isse better hai ki books ko arraylist hi maan lo

	public boolean addBook(Book book) {
		
		if(idx<=49) {
			books[idx]= book;
			idx++;
			System.out.println("Book is successfully added");
			return true;
		}
		else {
			System.out.println("Book Already exists in library");
			return false;
		}
	}

	public boolean borrowBook(String title) {
		for(int i=0;i<=idx;i++) {
			if(books[i].getTitle()==title) {
				System.out.println("Book succesfully borrowed");
				return true;
			}
		}
		System.out.println("Can't borrow the book");
		return false;
	}

	public boolean returnBook(String title) {
		return true;
	}
}

class Book extends Library {
	private String title;
	private String author;
	private String genre;
	private boolean isAvailable;

	public Book(String title, String author, String genre, boolean isAvailable) {
		super();
		this.title = title.toUpperCase();
		this.author = author;
		this.genre = genre;
		this.isAvailable = isAvailable;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isAvailable() {
		return isAvailable = true;
	}

	public void setAvailable(boolean available) {
//		isAvailable = isAvailable;
		this.isAvailable = available;
	}
}