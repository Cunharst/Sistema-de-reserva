package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args)  {
		Scanner entrada = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
		System.out.println("Pull the room number: ");
		int number = entrada.nextInt();
		System.out.println("Enter the check-in data: ");
		Date checkIn = sdf.parse(entrada.next());
		System.out.println("Enter the check-out data: ");
		Date checkOut = sdf.parse(entrada.next());
		
		
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.print("Enter data to update the reservation: ");
			System.out.println("Pull the room number: ");
			 number = entrada.nextInt();
			System.out.println("Enter the check-in data: ");
			 checkIn = sdf.parse(entrada.next());
			System.out.println("Enter the check-out data: ");
			 checkOut = sdf.parse(entrada.next());
			 
			
			reservation.updateDates(checkIn, checkOut);
			 System.out.println(reservation);
		}
	
		catch(ParseException e){
			System.out.println("Invalid date format.");
		}
		
		catch (DomainException e) {
			System.out.println("Error in reservation" + e.getMessage());
		}
		
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		entrada.close();
	}

}
