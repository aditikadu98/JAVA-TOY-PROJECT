package customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import database_connection.DbUtility;

public class Toy_ServiceImplementation implements Toy_Service {

	@Override
	public void insert() throws Exception {
		// TODO Auto-generated method stub

		try {

			Connection conn = DbUtility.getNetwork();
			String sql = "insert into toy_rental (Customer_id,  Toy_id,  Rental_Start_Date,  Rental_End_Date, Rental_Amount_Per_Day, Total_amount, Fine, Toy_status)values (?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, Customer.getCustomerId());
			stmt.setInt(2, Toy.getToy_id());
			stmt.setString(3, GetDate.getStartdate());
			stmt.setString(4, GetDate.getEnddate());
			stmt.setInt(5, Toy.getRental_cost());
			stmt.setLong(6, Total_Amount.getMy_amount());
			stmt.setInt(7, 0);
			stmt.setString(8, "On Rent");
			stmt.executeUpdate();
			stmt.close();

			String sql1 = "select rental_id from toy_rental where customer_id=? and toy_id=?  ";
			PreparedStatement stmt1 = conn.prepareStatement(sql1);
			stmt1.setInt(1, Customer.getCustomerId());
			stmt1.setInt(2, Toy.getToy_id());
			ResultSet rs = stmt1.executeQuery();
			while (rs.next()) {
				System.out.println("Your order id is:     " + rs.getInt("Rental_id"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(" ");
		System.out.println("Your order is placed");
		int h = 1;
		do {

			try {
               
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

	}

	@Override
	public void search() {
		// TODO Auto-generated method stub
		int x = 1;
		do {
			try {

				@SuppressWarnings("resource")
				Scanner s = new Scanner(System.in);
				System.out.println(" ");
				System.out.println("Enter 0 to search toys");
				System.out.println("Enter 1 to return the toy");
				System.out.println("Enter 2 to check your order details");

				int a = s.nextInt();
				if (a == 0) {
					Toy_ServiceImplementation obj = new Toy_ServiceImplementation();
					obj.display();
				} else if (a == 1) {
					Toy_return.returntoy();
				}

				else if (a == 2) {
					Customer_serviceimpl obj3 = new Customer_serviceimpl();
					obj3.display();

				} else {
					System.out.println("Sorry !Invalid input");
					Toy_ServiceImplementation obj2 = new Toy_ServiceImplementation();
					obj2.search();

					// m.search();// calling the search() method after wrong input
				}
				x = 2;
			} catch (Exception e) {
				System.out.println("Sorry !Invalid input");// catching Exception
			}
		} while (x == 1);// run in loop after exception occurs
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		try {
			Connection conn = DbUtility.getNetwork();
			String sql = "select toy_id , toy_name from toy_details";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.print("Toy Id : " + rs.getInt("toy_id"));

				System.out.println("Toy Name : " + rs.getString("Toy_name"));
			}
			Customer_serviceimpl obj = new Customer_serviceimpl();
			obj.search();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
