package main;

public class Film {
	private String name;
	private int duration;
	private String day;
	
	public Film(String name, String day) {
		this.name = name;
		this.day = day;
	}
	
	public Film() {}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "Film [name=" + name + ", day=" + day
				+ "]";
	}


	
	
	
}
