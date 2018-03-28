package demo;

public class Customer {
	private double firstname;
	
	public Customer(){}
	
	public Customer(double firstname){
		this.firstname = firstname;
	}
	
	// firstname
	public double getFirstname() {
		return firstname;
	}
	public void setFirstname(double firstname) {
		this.firstname = firstname;
	}

}