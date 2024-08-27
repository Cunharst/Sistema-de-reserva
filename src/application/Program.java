package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner entrada = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Pull the room number: ");
		int number = entrada.nextInt();
		System.out.println("Enter the check-in data: ");
		Date checkIn = sdf.parse(entrada.next());
		System.out.println("Enter the check-out data: ");
		Date checkOut = sdf.parse(entrada.next());
		
		if(! checkOut.after(checkIn)) {
			System.out.println("Error in reservation. Check in must be before check out");
		}
		
		else {
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
			 
			 Date now = new Date();
			 
			 if(checkIn.before(now)||checkOut.before(now)) {
				 System.out.println("Error in reservation. The dates shoul be in future");
			 }
			 
			 else if(! checkOut.after(checkIn)) {
				 System.out.println("Error in reservation. Check in must be before check out");
			 }
			 
			 else {
			 
			 reservation.updateDates(checkIn, checkOut);
			 System.out.println(reservation);
			 }
		}
		
		entrada.close();
	}

}
