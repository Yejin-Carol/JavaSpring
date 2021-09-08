package studyobserver;

public class RobotLeg implements EmergencyStoppable {
	@Override
	public void Stop() {
		System.out.println("send stop command: Stop Leg. Don't Move.");
	}
}
