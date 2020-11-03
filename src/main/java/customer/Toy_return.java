package customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import database_connection.DbUtility;

public class Toy_return {

	public static void returntoy() {
		// TODO Auto-generated method stub
		try {
			Connection conn = DbUtility.getNetwork();
			Scanner s = new Scanner(System.in);
			System.out.print("Enter order id : ");
			int orderid = s.nextInt();

			String sql = "update toy_rental set toy_status=? where customer_id=? and Rental_id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "Returned");
			stmt.setInt(2, Customer.getCustomerId());
			stmt.setInt(3, orderid);
			stmt.executeUpdate();
            System.out.println("  ");
			System.out.println("Thank you !!");
			System.out.println("Your package will be picked by a courier service !");

			int h = 1;
			do {

				try {
					System.out.println(" ");
					System.out.println("Enter1 to go to Home page else any integer to Logout!");
					Scanner sc1 = new Scanner(System.in);
					int x = sc1.nextInt();
					h = 2;
					if (x == 1) {
						Toy_ServiceImplementation obj2 = new Toy_ServiceImplementation();
						obj2.search();
					} else {
						Logout.to_logout();
					}
				} catch (Exception e) {
					System.out.println("Sorry !Invalid input");
				}
			} while (h == 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
