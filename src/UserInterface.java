package Application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Locale.Category;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserInterface 
{
	private static Scanner input = new Scanner (System.in);
	//movie entries
	static Movie[] movie_array = {
	    new Movie("The Great Adventure", "NORMAL", 10.00),
	    new Movie("Beyond the Horizon", "3D", 15.50),
	    new Movie("Cosmic Journey", "IMAX", 18.00),
	    new Movie("The Silent Forest", "NORMAL", 9.50),
	    new Movie("Ocean's Depth", "3D", 14.00),
	    new Movie("Galactic Quest", "IMAX", 20.00),
	    new Movie("Mystery in the Mountains", "NORMAL", 8.00),
	    new Movie("Dragon's Lair", "3D", 16.00),
	    new Movie("Space Odyssey", "IMAX", 19.00),
	    new Movie("The Lost City", "NORMAL", 11.00),
	    new Movie("Virtual Reality", "3D", 15.00),
	    new Movie("The Final Frontier", "IMAX", 17.50),
	    new Movie("Echoes of Time", "NORMAL", 10.50),
	    new Movie("Dreamland", "3D", 13.50),
	    new Movie("The Infinite Sky", "IMAX", 18.50),
	    new Movie("Secret of the Sands", "NORMAL", 9.00),
	    new Movie("Realm of Shadows", "3D", 14.50),
	    new Movie("Starlight Symphony", "IMAX", 21.00),
	    new Movie("Chasing the Wind", "NORMAL", 12.00),
	    new Movie("The Enchanted Forest", "3D", 16.50)
	};
	static ArrayList<Movie> movies = new ArrayList<>(Arrays.asList(movie_array));

	//Cinemahall entries
	static CinemaHall[] hall_array = {
            new CinemaHall("1", 100, "Fully Booked"),
            new CinemaHall("2", 120, "Available"),
            new CinemaHall("3", 80, "Not Available"),
            new CinemaHall("4", 150, "Repair"),
            new CinemaHall("5", 90, "Fully Booked"),
            new CinemaHall("6", 130, "Available"),
            new CinemaHall("7", 75, "Not Available"),
            new CinemaHall("8", 160, "Repair"),
            new CinemaHall("9", 110, "Fully Booked"),
            new CinemaHall("10", 140, "Available")
        };
	static ArrayList <CinemaHall> cinema_halls = new ArrayList<>(Arrays.asList(hall_array));
	
	//Showtimes entries
	static Showtime[] showtimes_array = {
        new Showtime("The Great Adventure", "1", LocalTime.of(14, 30), LocalDate.of(2024, 7, 24), "AVAILABLE", 10.00),
        new Showtime("Beyond the Horizon", "1", LocalTime.of(16, 45), LocalDate.of(2024, 7, 25), "FULLY_BOOKED", 15.50),
        new Showtime("Cosmic Journey", "1", LocalTime.of(19, 00), LocalDate.of(2024, 7, 26), "CANCELLED", 18.00),
        new Showtime("Beyond the Horizon", "2", LocalTime.of(12, 15), LocalDate.of(2024, 7, 27), "NOT_AVAILABLE", 9.50),
        new Showtime("Ocean's Depth", "3", LocalTime.of(20, 30), LocalDate.of(2024, 7, 28), "AVAILABLE", 14.00),
        new Showtime("Galactic Quest", "4", LocalTime.of(11, 00), LocalDate.of(2024, 7, 29), "FULLY_BOOKED", 20.00),
        new Showtime("Mystery in the Mountains","5" , LocalTime.of(15, 30), LocalDate.of(2024, 7, 30), "NOT_AVAILABLE", 8.00),
        new Showtime("Cosmic Journey","6" , LocalTime.of(18, 45), LocalDate.of(2024, 7, 31), "CANCELLED", 16.00),
        new Showtime("Space Odyssey","4", LocalTime.of(13, 00), LocalDate.of(2024, 8, 1), "AVAILABLE", 19.00),
        new Showtime("The Lost City","3", LocalTime.of(10, 30), LocalDate.of(2024, 8, 2), "FULLY_BOOKED", 11.00),
        new Showtime("Virtual Reality","5"  , LocalTime.of(17, 00), LocalDate.of(2024, 8, 3), "NOT_AVAILABLE", 15.00),
        new Showtime("Virtual Reality","6" , LocalTime.of(14, 00), LocalDate.of(2024, 8, 4), "CANCELLED", 17.50),
        new Showtime("Echoes of Time","7", LocalTime.of(19, 15), LocalDate.of(2024, 8, 5), "AVAILABLE", 10.50),
        new Showtime("Dreamland","2", LocalTime.of(13, 45), LocalDate.of(2024, 8, 6), "FULLY_BOOKED", 13.50),
        new Showtime("Beyond the Horizon","1", LocalTime.of(21, 00), LocalDate.of(2024, 8, 7), "NOT_AVAILABLE", 18.50),
        new Showtime("Secret of the Sands","3", LocalTime.of(11, 15), LocalDate.of(2024, 8, 8), "CANCELLED", 9.00),
        new Showtime("Realm of Shadows","4", LocalTime.of(16, 00), LocalDate.of(2024, 8, 9), "AVAILABLE", 14.50),
        new Showtime("Starlight Symphony","5", LocalTime.of(20, 15), LocalDate.of(2024, 8, 10), "FULLY_BOOKED", 21.00),
        new Showtime("Chasing the Wind","7", LocalTime.of(12, 00), LocalDate.of(2024, 8, 11), "NOT_AVAILABLE", 12.00),
        new Showtime("The Enchanted Forest","3", LocalTime.of(18, 30), LocalDate.of(2024, 8, 12), "CANCELLED", 16.50)
	 };
	static ArrayList<Showtime> showtimes = new ArrayList<>(Arrays.asList(showtimes_array));
	
	//Member entries
	 static Member[] members_array = {
		new Member("Alice Johnson", "alice.johnson@example.com", LocalDate.of(1990, 5, 15)),
		new Member("Bob Smith", "bob.smith@example.com", LocalDate.of(1985, 3, 22)),
		new Member("Charlie Brown", "charlie.brown@example.com", LocalDate.of(1992, 7, 10)),
		new Member("Diana Prince", "diana.prince@example.com", LocalDate.of(1988, 11, 5)),
		new Member("Ethan Hunt", "ethan.hunt@example.com", LocalDate.of(1995, 1, 20)),
		new Member("Fiona Gallagher", "fiona.gallagher@example.com", LocalDate.of(1991, 9, 30)),
		new Member("George Michael", "george.michael@example.com", LocalDate.of(1987, 12, 25)),
		new Member("Hannah Baker", "hannah.baker@example.com", LocalDate.of(1993, 2, 14)),
		new Member("Ian Malcolm", "ian.malcolm@example.com", LocalDate.of(1996, 4, 12)),
		new Member("Jasmine Lee", "jasmine.lee@example.com", LocalDate.of(1998, 6, 18))
	};
	 
	static ArrayList<Member> members = new ArrayList<>(Arrays.asList(members_array));

	//Booking entries
	static ArrayList<Booking> bookings = new ArrayList<>();
	
	public static void main(String[] args)
	{
		UserInterface ui = new UserInterface();

		System.out.println("Cineplex ABC: Movie ticket booking system\n");
		//display Movie list for user to select
		System.out.print(Color.LIME+"\nMovies:\n"+Color.RESET);

		Movie.displayMovieList(movies);
		Movie movieSelected = getMovieSelected();
		
		//display movie's showtimes for user to select
		System.out.print(Color.LIME+"\nShowtimes available:\n"+Color.RESET);
		Showtime.displayShowtimes(showtimes,movieSelected.getTitle());
		Showtime showtimeSelected = getShowtimeSelected(movieSelected);
		
		//Display details
		System.out.print(Color.LIME+"\nDetails:\n"+Color.RESET);
		showtimeSelected.viewInformation();

		//User books tickets
		boolean validTickets = false;
		int adult = -1;
		int children = -1;
		int oku = -1;
		int senior = -1;
		int student = -1;
		int requestedTickets = -1;
		while(!validTickets) {
			System.out.print(Color.LIME+"\nPurchase Tickets:\n"+Color.RESET);
			adult = getPositiveInt("adult		:");
			children = getPositiveInt("Children	:");
			oku = getPositiveInt("OKU		:");
			senior = getPositiveInt("Senior		:");
			student = getPositiveInt("Student		:");
			
			//validate tickets input
			requestedTickets = adult+children+oku+senior+student;
			int availableSeats = cinema_halls.get(Integer.parseInt(showtimeSelected.getHallNumber())).getAvailableSeats();
			if(requestedTickets>availableSeats)
				System.out.println(Color.RED +"Sorry, you cannot book " 
			+ requestedTickets + " tickets. Only " + availableSeats + " seats are available." + Color.RESET);
			else
				validTickets = true;
		}
		double totalPrice = Booking.calculateTotalPrice(adult,children,oku,senior,student,showtimeSelected,movieSelected);
		System.out.printf(Color.RED+"Total Tickets : %d \t Total Price: %.2f \n\n"+Color.RESET,requestedTickets,totalPrice);
		
		// Confirm booking
        int choice = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.println(Color.RED + "Confirm booking?");
            System.out.println(Color.RED + "1) " + Color.LIME + "Yes");
            System.out.println(Color.RED + "2) " + Color.LIME + "No");
            System.out.print(Color.RESET + "Enter your choice: ");
            if (input.hasNextInt()) {
                choice = input.nextInt();
                if (choice < 1 || choice > 2) {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                    continue;
                }
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                input.next(); // Discard the invalid input
            }
        }
        if (choice == 1) {
            // Create booking
        	// public Booking(Movie movie, Member member, Showtime showtime, String status,int totalSeat,double totalPrice) {      	
        	bookings.add(new Booking(movieSelected, members.get(1), showtimeSelected, "BOOKED", requestedTickets, totalPrice));
            System.out.println(Color.LIME + "Booking created successfully." + Color.RESET);
            System.out.println(); // Add a newline for layout
        } else {
            System.out.println(Color.RED + "Booking cancelled." + Color.RESET);
            return;
        }
	}
	
	//other methods
	
	/*NOT DONE YET*/
	public Member getMember() {
        System.out.print(Color.LIME + "Enter member name:" + Color.RESET);
        String name = input.nextLine();
        Member memberFound = Member.findMember(members, name);
        if(memberFound != null)
        	return memberFound;
        else { //skip first
            System.out.print(Color.LIME + "Enter email:" + Color.RESET);
            String email = input.nextLine();
            
            boolean validBirthday = false;
            LocalDate birthday = null;
            
            while(!validBirthday) {
	            System.out.println("Enter the birthday (yyyy-MM-dd):");
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	            String birthday_input = input.nextLine();
	            birthday = LocalDate.parse(birthday_input,formatter);
	
	            if (birthday != null) {
	                System.out.println("You entered the birthday: " + birthday);
	            } else {
	                System.out.println("Invalid date format. Please use yyyy-MM-dd.");
	            }	
            }
        }
		return memberFound;
	}
	
	public static int getPositiveInt(String prompt) {
		boolean isPositiveInt = false;
		int num = -1;
		while(!isPositiveInt)
		{
			System.out.print(Color.LIME +prompt+ Color.RESET);
			
			if(input.hasNextInt()) {
				num = input.nextInt();
				
				if(num>=0 )
					isPositiveInt = true;
				else 
					System.out.println(Color.RED+"Invalid input. Please enter a positive number."+Color.RESET);
			}
			else {
				input.next();
				System.out.println(Color.RED+"Invalid input. Please enter a  positive number."+Color.RESET);
			}
		}
		return num;
	}

	public static Movie getMovieSelected() {
		boolean validMovieChoice = false;
		int movieChoice = -1;
		while(!validMovieChoice)
		{
			System.out.print(Color.LIME + "\nMovie		:" + Color.RESET);
			
			if(input.hasNextInt()) {
				movieChoice = input.nextInt();
				
				if(movieChoice>0 && movieChoice <= movies.size())
					validMovieChoice = true;
				else 
					System.out.println(Color.RED+"Invalid input. Please enter a valid movie choice."+Color.RESET);
			}
			else {
				input.next();
				System.out.println(Color.RED+"Invalid input. Please enter a valid movie choice."+Color.RESET);
			}
		}
		return movies.get(movieChoice-1);

	}
	
	public static Showtime getShowtimeSelected(Movie movieSelected) {
		boolean validShowtimeChoice = false;
		int showtimeChoice = -1;
		while(!validShowtimeChoice)
		{
			System.out.print(Color.LIME+"\nShowtimes		:"+Color.RESET);
			
			if(input.hasNextInt()) {
				showtimeChoice = input.nextInt();
				
				if(showtimeChoice>0 && showtimeChoice <= Showtime.getShowtimesCount(showtimes,movieSelected.getTitle()))
					validShowtimeChoice = true;
				else 
					System.out.println(Color.RED+"Invalid input. Please enter a valid showtime choice."+Color.RESET);
			}
			else {
				input.next();
				System.out.println(Color.RED+"Invalid input. Please enter a valid showtime choice."+Color.RESET);
			}
		}
		return showtimes.get(showtimeChoice);
	}


}

