package studyobserver;

import java.util.ArrayList;

public class Robot implements UseObserPattern{
	
	public ArrayList<EmergencyStoppable> parts = new ArrayList<>();
	
	@Override
	public void subscribe(EmergencyStoppable r) {
		parts.add(r);
	}
	
	@Override
	public void unsubscribe(EmergencyStoppable r) {
		parts.remove(r);
	}
	
	@Override
	public void notifyParts() {
		//람다버전 소스
		//parts.forEach(item -> item.Stop());
		//람다없는 것
		for(int i=0; i<parts.size(); i++)
			parts.get(i).Stop();
		//향상된 for문
		//for(EmergencyStoppable item : parts)
		//item.Stop();
	}
	
	
}
