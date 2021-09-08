package studyobserver;

public class RobotHead implements EmergencyStoppable {
	@Override
	public void Stop() {
		System.out.println("The other robots stopped.");
		System.out.println("But this is already stopped.");
	}
}
