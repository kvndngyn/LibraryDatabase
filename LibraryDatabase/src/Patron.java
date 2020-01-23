/**
 * This is the patron class that gives a patron their first and last name, how many books they can borrow, and how many books they
 * have borrowed.
 * 
 * @author Kevin Nguyen
 *
 */
public class Patron {

	private String firstName, lastName; 
	private Book[] books = new Book[3];
	/**
	 * This gives the patron their first and last name.
	 * 
	 * @param firstName		Patron's first name.
	 * @param lastName		Patron's last name.
	 */
	public Patron(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

/**
 * Returns a book that was given out. 
 * If the books was not checked out, it can not be returned.
 * 
 * @param book		The book.
 * @return			The booked that was checked in OR does not allow a book to be checked in if it was not checked out.
 */
	public String returnBook(Book book) {
		if(indexOf(book) != -1) {
			book.checkIn();
			books[indexOf(book)] = null;
			return book.getTitle() + "by " + book.getAuthor() + " has been succesfully checked in.";
			
		} else {
			return "you can't return a book you don't have";
		}
	}
	/**
	 * Check out a selected book.
	 * If the book was already checked out, it lets user know it's currently checked out.
	 * If the patron has more than 3 books, it does not allow more to be checked out.
	 * 
	 * @param book	The book.
	 * @return		The book being borrow OR the lets user know book has been checked out already OR lets user know the patron has 3 books checked out already.
	 */
	public String borrowBook (Book book) {
		if(book.isCheckedIn() && canBorrow()) {
			
			book.checkOut();
			books[indexOf(null)] = book;
			
			return "book" + book.getTitle() + " by " + book.getAuthor() + " has been successfully checked out";
		
		} else if(!book.isCheckedIn()){
			return "book" + book.getTitle() + " by " + book.getAuthor() + " is currently checked out";
		
		} else {
			return "Patron cannot borrow more than 3 books";
		}
	}
	/**
	 * Determines whether patron can borrow a book.
	 * 
	 * @return true if patron can borrow book OR false if patron has 3 books.
	 */
	public boolean canBorrow() {
		for (int i = 0; i < books.length; i++) {
			if(books[i] == null) {
				return true;
			}
		}return false;
	}
	/**
	 * Determines which book is 1, 2, or 3.
	 * 
	 * @param book	The book.
	 * @return		Which book was checked out.
	 */
	private int indexOf(Book book) {
		
		for (int i = 0; i < books.length; i++) {
			if(book == null && books[i] == null) {
                return i;
            } else if(books[i].equals(book)){
                return i;
            }
		}
	return -1;
	
}
	
	public String toString() {
		return firstName + " " + lastName;
	}
	
/**
 * Gets the first name of the patron.
 * 
 * @return	Patron's first name.
 */
	public String getFirstName() {
		return firstName;
	}
	
/**
 * Sets the first name of the patron.
 * 
 * @param firstName	Inputs Patron's first name.
 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
/**
 * Gets the last name of the patron.
 * 
 * @return	Patron's last name.
 */
	public String getLastName() {
		return lastName;
	}
	
/**
 * Sets the last name of the patron.
 * 
 * @param lastName	Inputs Patron's last name.
 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}