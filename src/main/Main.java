package main;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner read = new Scanner(System.in); 
		Kinoteatr kinoteatr = new Kinoteatr();
		CinemaManager manager = new CinemaManager(read, kinoteatr);
		
		try {
			kinoteatr.defaultFilms();
			manager.writeToFile();
			ConsoleReader consoleReader = new ConsoleReader(read, manager);
			consoleReader.printMenu();	
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			read.close();
		}
		
	}
}
