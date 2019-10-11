/**
 * <h1> RATING Class </h1>
 * <p>
	This class sets the rating for the film and helps calculate the 
	price of the chosen film.
 * </p>
 * @author Charles Monaghan
 * @version 1.0
 */
package cinemaBookingApplication;

public enum RATING
{
	GENERAL(0, "G"), PARENTALGUIDANCE(12, "P"), MATURE(16, "M");
	private int minAge;		// Minimum age to watch a film (0, 12 and 16 respectively).
	private String initial;	// Rating initial to print in the main method.
	
	private RATING(int minAge, String initial)
	{
		this.setMinAge(minAge);
		this.initial = initial;
	}

	// Public getter and setter methods.
	public int getMinAge()
	{
		return minAge;
	}

	public void setMinAge(int minAge) 
	{
		this.minAge = minAge;
	} 
	
	public String getInitial() {
		return initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}

	@Override
	public String toString() 
	{
		return this.getInitial();
	}
}
