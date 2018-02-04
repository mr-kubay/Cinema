package main;
import java.util.*;

public class Kinoteatr  {
	List<Film> filmList = null;
	List<Hall> hallList = null;
	List<Session> sessionList;
	
	public Kinoteatr() {
		
		this.filmList = new ArrayList<>();
		this.hallList = new ArrayList<>();
		this.sessionList = new ArrayList<>();
	}
	
	public List<Film> getFilms() {
		return filmList;
	}
	
	public List<Hall> getHalls() {
		return hallList;
	}
	
	public List<Session> getSessions() {
		return sessionList;
	}
	
	public void addFilm(Film film) {
		filmList.add(film);
	}
	
	public void addHall(Hall hall) {
		hallList.add(hall);
	}
	
	public void addSession(Session s) {
		sessionList.add(s);
	}
	
	public void defaultFilms() {
		filmList.add(new Film("Thor", "Monday"));
		filmList.add(new Film("Darco", "Monday"));
		filmList.add(new Film("Johny D", "Tuesday"));
		
		hallList.add(new Hall(1));
		hallList.add(new Hall(2));
		
		sessionList.add(new Session(new Film("Thor", "Monday"), new Hall(1)));
		sessionList.add(new Session(new Film("Johny D", "Monday"), new Hall(2)));
		sessionList.add(new Session(new Film("Sins", "Tuesday"), new Hall(1)));
	}
	
}
