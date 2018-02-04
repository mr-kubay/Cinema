package main;

import java.io.Serializable;

public class Session implements Serializable{
	
	Film film;
	Hall hall;

	public Session(Film film, Hall hall) {
		this.film = film;
		this.hall = hall;
	}

	@Override
	public String toString() {
		return "Session [Film " + film.getName() +"| day: " +film.getDay() +  "| Hall: " + hall.getNumber() + "]";
	}

	

}
