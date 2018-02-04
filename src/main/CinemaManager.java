package main;

import java.io.*;
import java.util.*;

public class CinemaManager implements Serializable {
	
	private Scanner read;
	private Kinoteatr cinema;
	File file = new File("file.txt") ;
	BufferedReader br ;
	BufferedWriter bw;
	
	public CinemaManager () {
		this(new Scanner(System.in) , new Kinoteatr());
	}
	
	public CinemaManager(Scanner read , Kinoteatr kino) {
		this.read = read;
		this.cinema = kino;
	}
	
	
	public Film addFilm() {
		
		System.out.println("write film's name");
		String nameFilm = read.next();
		System.out.println("write day ");
		String day = read.next();
			Film newFilm = new Film(nameFilm, day);
			cinema.addFilm(newFilm);
			return newFilm; 
		
		
	}
	
	public Hall addHall() {
		System.out.println("write Hall's number: ");
		int number = read.nextInt();
		Hall newHall = new Hall(number);
		cinema.addHall(newHall);
		return newHall;
	}
	
	
	
	
	
	public void showHalls() {
		Iterator<Hall> hallIterator = cinema.getHalls().iterator();
		while(hallIterator.hasNext()) {
			System.out.println(hallIterator.next());
		}
	}
	
	public void deleteFilm(String name) {
		Iterator<Film> filmIterator = cinema.getFilms().iterator();
		try {
			while(filmIterator.hasNext()) {
				Film next = filmIterator.next();
			
				if(next.getName().equals(name)) {
					filmIterator.remove();			
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteHall (int data) {
		Iterator<Hall> hallIterator = cinema.getHalls().iterator();
		 
		 while(hallIterator.hasNext()) {
			 Hall next = hallIterator.next();
			 
			 if(next.getNumber() == data) {
				 hallIterator.remove();
			 }
		 }
	}
	
	public void addSession () {
			Session newSession = new Session(addFilm(),addHall());
			cinema.addSession(newSession);
	}
	
	public void showSession() {
		Iterator<Session> sessionIterator = cinema.getSessions().iterator();
			while (sessionIterator.hasNext()) {
				System.out.println(sessionIterator.next());
			}
	}
	
	public void deleteSession(String filmName) {
		Iterator<Session> sessionIterator = cinema.getSessions().iterator();
		while(sessionIterator.hasNext()) {
			Session next = sessionIterator.next();
			if(next.film.getName().equalsIgnoreCase(filmName)) {
				sessionIterator.remove();
			}
		}
	}
	
	public void deleteSession(int hallNumber) {
		Iterator<Session> sessionIterator = cinema.getSessions().iterator();
		while(sessionIterator.hasNext()) {
			Session next = sessionIterator.next();
			if(Integer.compare(next.hall.getNumber(), hallNumber) == 0) {
				sessionIterator.remove();
			}
		}
	}
	
	public void showSessionByDay (String dayName) {
		
		try {
			br = new BufferedReader(new FileReader(file));
			String str;
			boolean res = false;
			while((str = br.readLine()) != null) {
				if(str.contains(dayName)) {
					res = true;
					System.out.println(str);
				}
			}
			if(!res) System.out.println("no result");
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br!=null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
//		
		
	}
	
	public void showSessionByFilm (String filmName) {
		try {
			br = new BufferedReader(new FileReader(file));
			String str;
			boolean res = false;
			while((str = br.readLine()) != null) {
				if(str.contains(filmName)) {
					res = true;
					System.out.println(str);
				}
			}
			if(!res) System.out.println("no result");
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br!=null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void showFilmList() {
		Iterator<Film> filmIterator = cinema.getFilms().iterator();
		boolean is = false;
		while(filmIterator.hasNext()) {
			is = true;
			System.out.println(filmIterator.next());
		}
		if(!is) System.out.println("No films");
	}
	
	public File createFile () {
		try {
			file.createNewFile();
		}catch (Exception e ) {
			e.printStackTrace();
		}
		return file;
	}
	
	public void writeToFile (){
		Iterator<Session> sessionIter = cinema.getSessions().iterator();
		createFile();
		try {
			bw = new BufferedWriter(new FileWriter(file));
			while(sessionIter.hasNext()) {
				Session next = sessionIter.next();
				bw.write(next.toString());
				bw.append("\n");
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw != null) {
					bw.close();
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void readFromFile() {
		
		System.out.println("reading from file");
		
		try {
			br = new BufferedReader(new FileReader(file));
			String c;
			while((c=br.readLine())!= null) {
				System.out.println(c);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(br !=null) {
					br.close();
				}
					
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
