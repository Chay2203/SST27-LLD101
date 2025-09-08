package beverages_decorator;

public class Milk extends CondimentDecorator {
	
	public Milk(Beverage beverage) {
		super(beverage);
	}

	@Override
	public int cost() {
		return beverage.cost() + 2;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Milk";
	}
}
