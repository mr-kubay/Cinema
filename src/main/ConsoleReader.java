package main;

import java.util.Scanner;

public class ConsoleReader {
	Scanner read;
	CinemaManager manager;
	
	public ConsoleReader(Scanner read,CinemaManager manager) {
		this.read = read;
		this.manager = manager;
	}
	
	public void printMenu() {
		try {
			System.out.println("enter 'a'");

			while(read.next().equals("a")) {

				System.out.println("Enter '+' if you are admin or '-' if you are user :");
				String symbol = read.next();
				try {
					if(symbol.equals("+")) {
						System.out.println("you can :");
						System.out.println("1 - add film");
						System.out.println("2 - delete film");
						System.out.println("3 - show current films");
						System.out.println("4 - add Hall");
						System.out.println("5 - delete Hall");
						System.out.println("6 - show current Halls");
						System.out.println("7 - add session");
						System.out.println("8 - delete session");
						System.out.println("9 - show Sessions");
						System.out.println("10 - show Sessions By Day");
						System.out.println("11 - show Sessions by Film");
						System.out.println("12 - show Film list");

						switch(read.nextInt()) {
						case 1:
							manager.addFilm();
							break;
						case 2: 
							System.out.println("Enter film's name you want to delete: ");
							String FilmName = read.next();
							manager.deleteFilm(FilmName);
							break;
						case 3:
							manager.showFilmList();
							break;
						case 4:
							manager.addHall();
							break;
						case 5:
							System.out.println("Enter number to delete");
							int data = read.nextInt();
							manager.deleteHall(data);
							break;
						case 6 : 
							manager.showHalls();
							break;
						case 7: 
							manager.addSession();
							manager.writeToFile();
							break;
						case 8 : 
							System.out.println("Delete by: 1)number hall  2)by film");
							switch(read.nextInt()) {
							case 1:
								System.out.println("Enter number hall");
								int NumberHall = read.nextInt();
								manager.deleteSession(NumberHall);
								manager.writeToFile();
								break;
							case 2: 
								System.out.println("Enter fiilm name");
								String filmName = read.next();
								manager.deleteSession(filmName);
								manager.writeToFile();
								break;
							}
							break;
						case 9 :
							manager.readFromFile();
							break;
						case 10 : 
							System.out.println("Enter day");
							manager.showSessionByDay(read.next());
							break;
						case 11 : 
							System.out.println("Enter film");
							manager.showSessionByFilm(read.next());
							break;
						case 12 : 
							manager.showFilmList();
							break;
						default:
							throw new Exception() ;
						}


					}

					else {
						System.out.println("you are user and you can:");
						System.out.println("1 - show Sessions By Day");
						System.out.println("2 - show Sessions by Film");
						System.out.println("3 - show Film list");

						switch(read.nextInt()) {
						case 1 : 
							System.out.println("Enter day");
							manager.showSessionByDay(read.next());
							break;
						case 2 : 
							System.out.println("Enter film");
							manager.showSessionByFilm(read.next());
							break;
						case 3 : 
							manager.showFilmList();
							break;
						default:
							throw new Exception() ;
						}

					}
					System.out.println("To continue press 'a' to exit press anythins");

				}catch (Exception e) {continue;}


			}
			System.out.println("Bye");
		} catch(Exception e ) {	}
		finally {
			read.close();
		}
	}
}
