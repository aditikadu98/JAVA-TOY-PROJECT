package customer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Rental_procedure {

	public static void rent_info() {
		// TODO Auto-generated method stub
		int z = 1;
		do {

			try {

				System.out.println("Enter 0 to search for another toy or enter any integer to take on rent !");
				Scanner s = new Scanner(System.in);
				int a = s.nextInt();
				z = 2;
				if (a == 0) {
					Customer_serviceimpl obj = new Customer_serviceimpl();
					obj.search();
				} else {

					Scanner sc = new Scanner(System.in);

					SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
					System.out.println(" ");
					System.out.print("Enter start date: ");
					String StartDate = sc.nextLine();
					GetDate.setStartdate(StartDate);
					System.out.print("Enter end date  : ");
					String EndDate = sc.nextLine();
					GetDate.setEnddate(EndDate);
					Date date1 = myFormat.parse(StartDate);
					Date date2 = myFormat.parse(EndDate);
					long diff = date2.getTime() - date1.getTime();
					long Total_Days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
					System.out.println("Total days           : " + Total_Days);
					long Total_amt = Total_Days * Toy.getRental_cost();
					Total_Amount.setMy_amount(Total_amt);
					System.out.println("Total amount for given period to be paid: " + Total_amt);

					int r = 1;
					do {
						try {
							System.out.println(" ");
							System.out.println("Enter 1 to confirm your order else any integer to go home page");
							Scanner sc1 = new Scanner(System.in);
							int b = sc1.nextInt();
							r = 2;
							if (b == 1) {
								Toy_ServiceImplementation obj = new Toy_ServiceImplementation();
								obj.insert();
							} else {
								Toy_ServiceImplementation obj = new Toy_ServiceImplementation();
								obj.search();
							}
						} catch (Exception e) {
							System.out.println("Sorry !Invalid input");
						}
					} while (r == 1);

				}
			} catch (Exception e) {
				System.out.println("Sorry !Invalid input");
			}
		} while (z == 1);
	}
}
