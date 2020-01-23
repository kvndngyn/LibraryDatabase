/**
 * This is the BookInterface that will be used for the book class.
 * 
 * @author Kevin Nguyen
 *
 */
public interface BookInterface {
	/**
	 * Gets title of book.
	 * 
	 * @return	Book title.
	 */
	String getTitle();
	
	/**
	 * Gets name of the author.
	 * 
	 * @return Author's name.
	 */
	String getAuthor();
	
	/**
	 * Gets the amount of time before book is due.
	 * 
	 * @return	Days till book is due.
	 */
	int getDayBeforeDue();
	
	/**
	 * Determines whether booked is checked in.
	 * 
	 * @return	True of false.
	 */
	boolean isCheckedIn();
	
	public void checkIn();
	
	public void checkOut();
	
}
