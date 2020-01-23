import java.util.Scanner; 
import java.util.ArrayList;

/**
 * This is the main Library class that uses the patron class, the book class (which implements the BookInterface class), and initializes each code
 * to create a library check out system. This class can set a patrons name, and allow them to check in and out books that have been put into the system.
 *  
 * @author Kevin Nguyen
 *
 */  
public class Library {
	
	static ArrayList <Patron> UserList = new ArrayList<Patron>();
	static ArrayList <Book> BookList = new ArrayList <Book>();
	
	
	public String status1 = "Available";
	public String status2 = "Borrowed";
	
	/**
	 * Gets the first name and last name of the patron selected.
	 * 
	 * @param firstName	Gets patron's first name.
	 * @param lastName	Gets patron's last name.
	 * @return			selected patron's first and last name.
	 */
	public static int indexOfPatron(String firstName, String lastName) {
		for(int i = 0; i < UserList.size(); i++) {
			if(UserList.get(i).getFirstName().equals(firstName) && UserList.get(i).getLastName().equals(lastName))
					return i;
		}
		return -1;
	}
	
	/**
	 * Gets the title and author of a book.
	 * 
	 * @param title		Book's title.
	 * @param author	Book's author.
	 * @return			Title and author of selected book.
	 */
	public static int indexOfBook(String title, String author) {
		for(int i = 0; i < BookList.size(); i++) {
			if(BookList.get(i).getTitle().equals(title) && BookList.get(i).getAuthor().equals(author)) {
				return i;
		}
		
	}
		return -1;
	
	}
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int choice = 0;
		System.out.println("Libray Checkout System");
		
		String firstName = "", lastName = "", title = "", author = "";
		int index, index2;
		while(choice != 9) {
			System.out.println("1: Add new patron");
			System.out.println("2: Add new book");
			System.out.println("3: Edit patron");
			System.out.println("4: Edit book");
			System.out.println("5: Display all patrons");
			System.out.println("6: Display all books");
			System.out.println("7: Check out book");
			System.out.println("8: Check in book");
			System.out.println("9: Exit");
			System.out.print("Input Choice: ");
			choice = input.nextInt();

			
			switch(choice) {
			
				case 1:
					
					System.out.print("Enter patron first name: ");
					firstName = input.next(); //read name from input
					
					System.out.print("Enter patron last name: ");
					lastName = input.next(); 
					
					UserList.add(new Patron(firstName, lastName)); //add name to list
					System.out.println("-----You have successfully added a new patron!-----");
					
					break;
					
				
				case 2:
					
					System.out.print("Enter book title: ");
					String title1 = input.next();
					
					System.out.print("Enter book author: ");
					String author1 = input.next(); 		
					
					BookList.add(new Book(title1, author1));
					System.out.println("-----You have successfully added a new book!-----");
					
					break; 
					
				case 3:
					
					System.out.print("Enter the first name of the patron you want to edit: ");
					firstName = input.next();
					
					System.out.print("Enter the last name of the patron you want to edit: ");
					lastName = input.next();
					
					index = indexOfPatron(firstName, lastName);
					if(index != -1){
		                System.out.print("Enter the patron's new first name: ");
		                firstName = input.next();
		                UserList.get(index).setFirstName(firstName);
		
		                System.out.print("Enter the patron's new last name: ");
		                lastName = input.next();
		                UserList.get(index).setLastName(lastName);
		                
		            } else {
		            	System.out.println("Patron does not exits");
		            }
					
					break;
					
				case 4:
					
					System.out.print("Enter the title of the book you want to edit: ");
					title = input.nextLine();
					input.next();
					
					System.out.print("Enter the author of the book you want to edit: ");
					author = input.nextLine();
					input.next();
					index = indexOfBook(title, author);
					if(index != -1){
		                System.out.print("Enter the books new title: ");
		                firstName = input.nextLine();
		                BookList.get(index).setTitle(title);
		                input.next();
		
		                System.out.print("Enter the books new author: ");
		                lastName = input.nextLine();
		                BookList.get(index).setAuthor(author);
		                input.next();		
		               
		            } else {
		            	System.out.println("Book does not exits");
		            }
					break;
					
				case 5:
					
					for(int i = 0; i < UserList.size(); i++) {
						System.out.println(UserList.get(i));
					}
					break;
					
				case 6:
					
					for(int i = 0; i < BookList.size(); i++) {
						System.out.println(BookList.get(i));
					}
					break;
					
				case 7:
					
					System.out.print("Enter the first name of the patron that wants to borrow a book: ");
		            firstName = input.next();
		
		            System.out.print("Enter the last name of the patron that wants to borrow a book: ");
		            lastName = input.next();
		
		            index = indexOfPatron(firstName, lastName);
		
		            if (index != -1) {
		                System.out.print("Enter the title of the book they want to borrow: ");
		                title = input.nextLine();
		                input.next();
		
		                System.out.print("Enter the author of the book they want to borrow: ");
		                author = input.nextLine();
		                input.next();
		
		                index2 = indexOfBook(title, author);
		
		                if (index2 != -1){
		                    System.out.println(UserList.get(index).borrowBook(BookList.get(index2)));
		                } else {
		                    System.out.println("Book does not exist.");
		                }
		
		            } else {
		                System.out.println("Patron does not exist.");
		            }
		            break;
				case 8:
					
					System.out.print("Enter the first name of the patron that wants to return a book: ");
		            firstName = input.next();
		
		            System.out.print("Enter the last name of the patron that wants to return a book: ");
		            lastName = input.next();
		
		            index = indexOfPatron(firstName, lastName);
		
		            if (index != -1) {
		                System.out.print("Enter the title of the book they want to return ");
		                title = input.nextLine();
		                input.next();
		
		                System.out.print("Enter the author of the book they want to return: ");
		                author = input.nextLine();
		                input.next();
		
		                index2 = indexOfBook(title, author);
		
		                if (index2 != -1){
		                    System.out.println(UserList.get(index).returnBook(BookList.get(index2)));
		                } else {
		                    System.out.println("Book does not exist.");
		                }
		
		            } else {
		                System.out.println("Patron does not exist.");
		            }
		            break;
				case 9:
					System.exit(0);
					
			}
		}
	}
}