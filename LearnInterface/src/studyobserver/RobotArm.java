package studyobserver;

public class RobotArm implements EmergencyStoppable{
	
	@Override
	public void Stop() {
		System.out.println("send command: stop Arm");
		//특정 위치로 Lan 통신이 Rs232통신을 해서 장비를 멈추는데 필요한 메세지들을 보냄
	}
}
