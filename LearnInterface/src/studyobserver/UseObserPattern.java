package studyobserver;

public interface UseObserPattern {
	void subscribe(EmergencyStoppable r);
	void unsubscribe(EmergencyStoppable r);
	void notifyParts();
	
}
