package Fsit_Project.Baby_Toy_Rental;

import java.util.InputMismatchException;
import java.util.Scanner;

import customer.Customer;
import customer.Customer_serviceimpl;
import customer.Rental_procedure;
import customer.Toy_ServiceImplementation;

public class App {
	public static void main(String[] args) throws Exception {
		int w = 1;// passing a loop when unexpected exception occurs
		do {
			try {
				@SuppressWarnings("resource")
				Scanner s1 = new Scanner(System.in);
				System.out.println("New user!!  Enter 0 to register");
				System.out.println("Enter 1 to login");
				int e = s1.nextInt();// statement that may cause an Exception
				w = 2;

				if (e == 0) {

					Customer.registration(); // redirect to registration page

				} else if (e == 1) {
					Customer.LoginPage(); // redirect to Login page
				} else {
					System.out.println("Sorry !Invalid input");
					App.main(args);
				}
			} catch (InputMismatchException e) {
				System.out.println("Sorry !Invalid input");

			}
		} while (w == 1);

	}
}