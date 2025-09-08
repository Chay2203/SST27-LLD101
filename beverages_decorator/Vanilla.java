package beverages_decorator;

public class Vanilla extends CondimentDecorator {
	
	public Vanilla(Beverage beverage) {
		super(beverage);
	}

	@Override
	public int cost() {
		return beverage.cost() + 4;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Vanilla";
	}
}
