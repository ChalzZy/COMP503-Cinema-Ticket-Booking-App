/**
 * <h1> Customer Class </h1>
 * <p>
 * The customer class connects to the ticket class and returns information
 * based on the information given by the ticket class. It prints to console
 * a representation of the a customer which includes: name, ge and the student status.
 * </p>
 * @author Charles Monaghan
 * @version 1.0
 */
package cinemaBookingApplication;

public class Customer
{
	private String name;
	private int age;
	private boolean isStudent;
	
	// Default constructor
	public Customer()
	{
		this.name = "NONAME";
		this.age = 999;
		this.isStudent = true;
	}
	
	// Constructor that passes in a name, a age and a student status.
	public Customer(String name, int age, boolean isStudent)
	{
		this.name = name;
		this.age = age;
		this.isStudent = isStudent;
	}
	
	// Public getter and setter methods
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public boolean isStudent()
{
		return isStudent;
	}

	public void setStudent(boolean isStudent)
	{
		this.isStudent = isStudent;
	}

	@Override
	public String toString() 
	{
		// Runs if the customer IS a student.
		if (isStudent == true)
		{
			return "CUSTOMER DETAILS: " + name + " age: " + age + " Student? Yes";
		}
		// Runs if the customer IS NOT a student.
		else
		{
			return "CUSTOMER DETAILS: " + name + " age: " + age + " Student? No";
		}
	}
}
