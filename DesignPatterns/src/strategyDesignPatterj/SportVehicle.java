package strategyDesignPatterj;

public class SportVehicle extends Vehicle{
	
	public SportVehicle() {
		super(new NormalDriveStartegy());
	}
	
}
