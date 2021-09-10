package studyLamda;

@FunctionalInterface//함수형 인터페이스
//단순한 객체 아닌 함수를 저장, 선언시 그 시점에 해당 함수를 구체화
public interface MyAddable {
	public int add(int x, int y);
	
}
