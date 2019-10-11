/**
 * <h1> Ticket Class </h1>
 * <p>
 * This class takes in information passed by the Film and Customer classes. 
 * Based on the information (Customer Age, Student Status, etc), this class will
 * calculate the appropriate price for the customer.
 * </p>
 * @author Charles Monaghan (Student ID: 18012390)
 * @version 1.0
 */
package cinemaBookingApplication;

public class Ticket 
{
	private Film film;			// Passes through The film name and rating.
	private Customer customer;	// Passes through the customer age, student status and name.
	
	// Constructor for the Ticket class.
	public Ticket(Customer customer, Film film)
	{
		this.film = film;
		this.customer = customer;
	}
	
	public double cost()
	{
		double finalCost = 0;	// Stores the price of the movie ticket
		
		// Runs if the cusotmer IS a student.
		if (customer.isStudent() == true)
		{
			// Checks that the customer is between the ages 8 - 20.
			if ((customer.getAge() > 7) && (customer.getAge() < 21))
			{
				// Runs if customer is less than 19 years of age.
				if (customer.getAge() < 19)
				{
					finalCost = 6.4;	// Discounted STUDENT price for children (Aged less than 18).
				}
				// Runs if customer is 19 years or older.
				else
				{
					finalCost = 8.0;	// Discounted STUDENT price for adults (Aged 18 or more).
				}
			}
			// Runs if customer is aged less than 8 or greater than 20.
			else
			{
				if (customer.getAge() > 8)
				{
					finalCost = 9.3;	// Discounted STUDENT price for adults (Aged above 25).
				}
				else
				{
					finalCost = 7.0;	// Default price.
				}
			}
		}
		// Runs if the customer is NOT a student.
		else 
		{
			if (customer.getAge() < 8)
			{
				finalCost = 7.0;	// Discounted price for children (Aged less than 18).
			}
			else if (customer.getAge() < 70)
			{
				finalCost = 10.0;	// Normal price.
			}
			else 
			{
				finalCost = 9.5;	// Discounted price for seniors (Above age 70).
			}
		}
		
		return finalCost;
	}

	// Public getter and setter methods.
	public Film getFilm() 
	{
		return film;
	}

	public void setFilm(Film film)
	{
		this.film = film;
	}

	public Customer getCustomer() 
	{
		return customer;
	}

	public void setCustomer(Customer customer) 
	{
		this.customer = customer;
	}

	@Override
	public String toString() 
	{
		return "FILM TICKET for " + film + "\nCUSTOMER DETAILS: " + customer + "\nTOTAL COST: " + cost();
	}
	
	
}
