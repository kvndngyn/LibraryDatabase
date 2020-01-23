/**
 * This is the book class that implements the book interface.
 * 
 * @author Kevin Nguyen
 *
 */
public class Book implements BookInterface {
	
	private String title, author;
	private int daysBeforeDue;
	private boolean checkedIn;
	
	/**
	 * The book's title and author.
	 * 
	 * @param title 	The book's title.
	 * @param author	The book's author.
	 */
	public Book (String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	/**
	 * Sets title of the book
	 *  
	 * @param title	Book's title.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Sets the author of the book.
	 * 
	 * @param author Book's author.
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getDayBeforeDue() {
		return daysBeforeDue;
	}
	
	
	public boolean isCheckedIn() {
		return checkedIn;
	}
	
	public void checkIn(){
		checkedIn = true;
	}
	
	public void checkOut(){
		checkedIn = false;
		daysBeforeDue = 7;
	}

		

}