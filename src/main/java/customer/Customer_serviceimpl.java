package customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import database_connection.DbUtility;

public class Customer_serviceimpl implements Customer_service {

	@Override
	public void insert() {
		// TODO Auto-generated method stub

	}

	@Override
	public void search() {
		// TODO Auto-generated method stub

		int z = 1;
		do {

			try {
				Connection conn = DbUtility.getNetwork();
				System.out.println(" ");
				System.out.print("Enter toy id to take toy on rent :  ");
				Scanner s = new Scanner(System.in);
				int a = s.nextInt();

				String sql = "select * from toy_details where toy_id =?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setInt(1, a);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					if (a == rs.getInt("Toy_id")) {

						System.out.println("Toy Id                  : " + rs.getInt("toy_id"));
						System.out.println("Toy name          : " + rs.getString("Toy_name"));
						System.out.println("Toy type             : " + rs.getString("Toy_type"));
						System.out.println("Maximum age : " + rs.getInt("Maximum_age"));
						System.out.println("Minimum age  : " + rs.getInt("Minimum_age"));
						System.out.println("Cost                      : " + rs.getInt("Cost"));
						System.out.println("Quantity             : " + rs.getInt("Quantity"));
						System.out.println("Rent _cost          : " + rs.getInt("Rent_cost"));
						Toy.setRental_cost(rs.getInt("Rent_cost"));
						Toy.setToy_id(rs.getInt("toy_id"));
					} else if (a != rs.getInt("Toy_id")) {
						Customer_serviceimpl obj = new Customer_serviceimpl();
						obj.search();
					}
					z = 2;
				}

				// Toy_id, Toy_name, Toy_type, Maximum_age, Minimum_age, Cost, Quantity,
				// Rent_cost

			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Invalid Input !");
			}

		} while (z == 1);
		Rental_procedure.rent_info();
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		int h = 1;
		do {
			try {
				Connection conn = DbUtility.getNetwork();

				String sql = "select*from toy_rental where customer_id=?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setInt(1, Customer.getCustomerId());

				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					 System.out.println(" ");
					 System.out.println(" ");
					System.out.println("*************** Rental Id: " + rs.getInt("Rental_Id") + "***************");

					System.out.println("Toy Id                                          : " + rs.getInt("Toy_Id"));
					System.out.println("Start Date                                 :" + rs.getString("Rental_Start_Date"));
					System.out.println("End Date                                   : " + rs.getString("Rental_End_Date"));
					System.out.println("Rental Amount Per Day     : " + rs.getInt("Rental_Amount_Per_Day"));
					System.out.println("Total Amount                          : " + rs.getInt("Total_Amount"));
					System.out.println("Fine                                             :" + rs.getInt("Fine"));
					System.out.println("Toy Status                                 : " + rs.getString("Toy_Status"));

//Rental_id, Customer_id, Toy_id, Rental_Start_Date, Rental_End_Date, Rental_Amount_Per_Day, Total_amount, Fine, Toy_status
				}
				int j = 1;
				do {

					try {
						 System.out.println(" ");
						System.out.println("Enter1 to go to Home page else any integer to Logout!");
						Scanner sc1 = new Scanner(System.in);
						int x = sc1.nextInt();
						j = 2;
						if (x == 1) {
							Toy_ServiceImplementation obj2 = new Toy_ServiceImplementation();
							obj2.search();
						} else {
							Logout.to_logout();
						}
					} catch (Exception e) {
						System.out.println("Invalid Input !");
					}
				} while (j == 1);
				h = 2;

			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (h == 1);
	}

}
