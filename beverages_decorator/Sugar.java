package beverages_decorator;

public class Sugar extends CondimentDecorator {
	
	public Sugar(Beverage beverage) {
		super(beverage);
	}

	@Override
	public int cost() {
		return beverage.cost() + 1;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Sugar";
	}
}
