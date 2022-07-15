package strategyDesignPatterj;

public class Vehicle {
	
	DriveStrategy drive;
	
	public Vehicle(DriveStrategy drive) {
		this.drive = drive;
	}
	
	public void driveStrategy() {
		drive.drive();
	}
}
