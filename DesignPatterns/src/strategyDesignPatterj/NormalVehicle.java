package strategyDesignPatterj;

public class NormalVehicle extends Vehicle {

	public NormalVehicle() {
		super(new SportsDriveStrategy());
	}

}
