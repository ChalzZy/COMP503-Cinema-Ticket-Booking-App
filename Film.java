/**
 * <h1> Film Class </h1>
 * <p>
 * This class sets a title for the film and grabs the rating of the film from
 * the RATING class. It returns a string representation of the film and rating.
 * </p>
 * @author Charles Monaghan (Student ID: 18012390)
 * @version 1.0
 */
package cinemaBookingApplication;

public class Film
{
	private String title;	// Film title.
	private RATING rating;	// Film rating.
	
	// Default constructor
	public Film()
	{
		this.title = "NOTITLE";
		this.rating = null;
	}
	
	// Constructor
	public Film(String title, RATING rating)
	{
		this.title = title;
		this.rating = rating;
	}

	// Public getter and setter methods.
	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public RATING getRating() 
	{
		return rating;
	}

	public void setRating(RATING rating) 
	{
		this.rating = rating;
	}

	@Override
	public String toString() 
	{
		return title + " rating: " + "(" +rating+ ")";
	}
	
	
}
