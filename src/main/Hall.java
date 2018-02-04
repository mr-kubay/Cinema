package main;

public class Hall {
	private int number;
	
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Hall(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Hall [number=" + number + "]";
	}
	

}
