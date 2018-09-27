package pkgQuiz;

public class CarPayment {
	
	
	
	// attributes for the 4 variables given and a two more for convenience
	
	private double totalCost;
	private int downPayment;
	private int loanLength;
	private double interestRate;
	private double monthlyRate;
	private double principal;
	
	
	// constructor to fill the attributes, I am assuming the user would be inputing their interest rate as a whole number rather than its decimal equivalent
	
	public CarPayment(double totalCost, int downPayment, int loanLength, double interestRate) {
		
		
		this.totalCost = totalCost;
		this.downPayment = downPayment;
		this.loanLength = loanLength;
		this.interestRate = interestRate / 100;
		this.monthlyRate = interestRate / 1200;
		this.principal = totalCost - downPayment;
	}


	public double getTotalCost() {
		return totalCost;
	}


	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}


	public int getDownPayment() {
		return downPayment;
	}


	public void setDownPayment(int downPayment) {
		this.downPayment = downPayment;
	}


	public int getLoanLength() {
		return loanLength;
	}


	public void setLoanLength(int loanLength) {
		this.loanLength = loanLength;
	}


	public double getInterestRate() {
		return interestRate;
	}


	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	
	// two methods for calculating monthlyPayment and totalInterest
	
	public double monthlyPayment()
	{
		return ((monthlyRate) * principal) / (1 - Math.pow((1 + (monthlyRate)), loanLength * -1));		
	}
	
	public double totalInterest()
	{
		return (monthlyPayment() * loanLength) - principal;	
	}
	
	
	

}
