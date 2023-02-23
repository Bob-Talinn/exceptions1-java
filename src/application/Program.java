package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args)  {

      try {
              Scanner sc = new Scanner(System.in);
              SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
              System.out.println("Room number: ");
              int number = sc.nextInt();
              System.out.println("Check-in date (dd/MM/yyyy):");
              Date checkIn = new Date(sdf.parse(sc.next()).getTime());
              System.out.println("Check-out date (dd/MM/yyyy):");
              Date checkOut = new Date(sdf.parse(sc.next()).getTime());


              Reservation reservation = new Reservation(number, checkIn, checkOut);
              System.out.println("Reservation: " + reservation);

              System.out.println();
              System.out.println("Enter data to update the reservation: ");
              System.out.println("Check-in date (dd/MM/yyyy):");
              checkIn = new Date(sdf.parse(sc.next()).getTime());
              System.out.println("Check-out date (dd/MM/yyyy):");
              checkOut = new Date(sdf.parse(sc.next()).getTime());


              reservation.updateDates(checkIn, checkOut);

              System.out.println("Reservation: " + reservation);
          sc.close();
      }
      catch(ParseException e){
          System.out.println("Invalid date format");
      }
      catch (DomainException e ) {
          System.out.println("Error in reservation: " + e.getMessage());
      }









    }
}
