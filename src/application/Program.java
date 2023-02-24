package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int number = sc.nextInt();

		System.out.print("check-in date(dd/MM;yyyy): ");
		Date checkin = sdf.parse(sc.next());

		System.out.print("check-out date (dd/MM/yyyy)");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(number, checkin, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data  to update the reservation:");
			System.out.print("check-in date(dd/MM;yyyy): ");
			checkin = sdf.parse(sc.next());

			System.out.print("check-out date (dd/MM/yyyy)");
			checkOut = sdf.parse(sc.next());

			Date now = new Date();
			if (checkin.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for  update must be future dates");
			} else if (!checkOut.after(checkin)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");

			} else {

				reservation.updateDates(checkin, checkOut);
				System.out.println("Reservation" + reservation);
			}
		}

		sc.close();
	}

}
