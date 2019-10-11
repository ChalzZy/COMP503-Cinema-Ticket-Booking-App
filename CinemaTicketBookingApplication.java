/**
 * <h1> Cinema Ticket Booking Application </h1>
 * <p>
 * The application takes a user name, age and movie choice and
 * calculates the price and rating for the customer. 
 * </p>
 * <b>Note:</b> The program requires accurate inputs from
 * the user as there is no input validation.
 * 
 * @author Charles Monaghan
 * @version 1.0
 */
package cinemaBookingApplication;
import java.util.Scanner;

public class CinemaTicketBookingApplication 
{
	private static int NUMBER_OF_FILMS = 4; 					// The number of films available to watch.
	private static Film[] films; 								// Used to store the film name and rating.
	private static Scanner keyboard = new Scanner(System.in); 	// 'java.util.Scanner': To take user input.
	
	/**
	 * This method is used to add the user to
	 * enter their 'name', 'age' and to declare if they
	 * are a student (YES or NO). Based on the user input,
	 * the method will return the appropriate customer
	 * information.
	 * @return This will return a customer object
	 */
	
	private static Customer customerDetailsInput()
	{
		boolean userStudentBool = false;

		System.out.println("Please enter your name:");
		String userName = keyboard.nextLine();				// Customer name.
		
		System.out.println("Please enter your age");		// Customer age.
		int userAge = Integer.parseInt(keyboard.nextLine());
		
		System.out.println("Are you a student(Y/N)");
		char userStudent = keyboard.nextLine().charAt(0);	// Is the customer a student? (Y/N)
		
		if (userStudent == 'Y') 
		{
			userStudentBool = true;		// Returns TRUE if the customer is a student.
		}
		else
		{
			userStudentBool = false;	// Returns FALSE if the customer is NOT a student.
		}
		
		Customer customerDetails = new Customer(userName, userAge, userStudentBool);

		return customerDetails;		
	}
	
	/**
	 * This method loops through all the available films and prints them out.
	 * After looping, it asks the user to input an integer based on the movie
	 * they would like to watch.
	 * @return This will return a representation of the toString() method in the film.java class.
	 */
	
	private static Film filmSelection()
	{
		for(int i = 0; i < NUMBER_OF_FILMS; i++)
		{
			System.out.println((i+1)+" " + films[i].toString());
		}
		
		System.out.println("Which film would you like to watch:");
		int filmNumber = Integer.parseInt(keyboard.nextLine());

		return films[filmNumber-1];
	}
	
	/**
	 * This method checks that the customer is of eligible age to watch their chosen movie.
	 * @param aCustomer All the customer information.
	 * @param aFilm Customer's chosen film
	 * @return String displaying the ticket, customer and cost.
	 */
	
	public static Ticket issueTicket(Customer aCustomer, Film aFilm)
	{
		if(aCustomer.getAge() < aFilm.getRating().getMinAge())
		{
			return null;
		}
		return new Ticket(aCustomer, aFilm);
	}
	
	/**
	 * Lays out the program and hard codes films into the film array.  
	 */
	
	public static void main(String[] args) 
	{
		System.out.println("Welcome to the Cinema Ticket Purchasing System");

		/**
		 * Initiatlases the film[] with hard coded films.
		 */
		films = new Film[NUMBER_OF_FILMS];
		films[0] = new Film("Ant-Man", RATING.MATURE);
		films[1] = new Film("Minions", RATING.PARENTALGUIDANCE);
		films[2] = new Film("Jurassic World", RATING.PARENTALGUIDANCE);
		films[3] = new Film("Inside Out", RATING.GENERAL);

		boolean finished = false; // The program will reloop to this position if the customer would like another ticket.
		while(!finished)
		{
			Customer c = customerDetailsInput();
			Film f = filmSelection();
			Ticket t = issueTicket(c,f);
			if(t != null)
			{
				System.out.println("Your ticket is ready to be collected!");
				System.out.println("------------------------------------------------------------");
				System.out.println(t);
				System.out.println("------------------------------------------------------------");
			}
			else
			{
				System.out.println("Sorry, cannot issue ticket for age restricted film.");
			}
			
			/**
			 * Checks if the customer would like another ticket.
			 */
			System.out.println("Would you like to purchase another ticket? (Y/N)");
			char anotherTicket = keyboard.nextLine().charAt(0);
			if(anotherTicket == 'N')
			{
				finished = true; // End of program
			}
		}
		keyboard.close(); // Close memory leak.
	}
}
