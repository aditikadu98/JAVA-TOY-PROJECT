package customer;

public class Toy {

public static int getToy_id() {
		return Toy_id;
	}
	public static void setToy_id(int toy_id) {
		Toy_id = toy_id;
	}
	public static String getToy_name() {
		return Toy_name;
	}
	public  static void setToy_name(String toy_name) {
		Toy_name = toy_name;
	}
	public  static String getToy_type() {
		return Toy_type;
	}
	public  static void setToy_type(String toy_type) {
		Toy_type = toy_type;
	}
	public  static int getMinimum_age() {
		return Minimum_age;
	}
	public static void setMinimum_age(int minimum_age) {
		Minimum_age = minimum_age;
	}
	public static int getMaximum_age() {
		return Maximum_age;
	}
	public  static void setMaximum_age(int maximum_age) {
		Maximum_age = maximum_age;
	}
	public static int getCost() {
		return Cost;
	}
	public static void setCost(int cost) {
		Cost = cost;
	}
	public static int getQuantity() {
		return Quantity;
	}
	public static void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public  static int getRental_cost() {
		return Rental_cost;
	}
	public static void setRental_cost(int rental_cost) {
		Rental_cost = rental_cost;
	}
	static int  Toy_id;

static String Toy_name;
static String Toy_type;
static int Minimum_age;
static int Maximum_age;
static int Cost;
static int Quantity;
static int Rental_cost;

	
	
}
