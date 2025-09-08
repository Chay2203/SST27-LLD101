package beverages_decorator;

public class Client {

	public static void main(String[] args) {
		
		// Basic cappuccino
		Beverage coffee1 = new Cappuccino();
		System.out.println(coffee1.getDescription() + " - $" + coffee1.cost());
		
		// Cappuccino with milk and sugar
		Beverage coffee2 = new Cappuccino();
		coffee2 = new Milk(coffee2);
		coffee2 = new Sugar(coffee2);
		System.out.println(coffee2.getDescription() + " - $" + coffee2.cost());
		
		// Latte with whipped cream and vanilla
		Beverage coffee3 = new Latte();
		coffee3 = new WhippedCream(coffee3);
		coffee3 = new Vanilla(coffee3);
		System.out.println(coffee3.getDescription() + " - $" + coffee3.cost());
		
		// Complex order - cappuccino with everything
		Beverage coffee4 = new Cappuccino();
		coffee4 = new Milk(coffee4);
		coffee4 = new Sugar(coffee4);
		coffee4 = new WhippedCream(coffee4);
		coffee4 = new Vanilla(coffee4);
		System.out.println(coffee4.getDescription() + " - $" + coffee4.cost());

	}

}