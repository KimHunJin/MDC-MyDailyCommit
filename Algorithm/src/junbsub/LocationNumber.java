package junbsub;

import java.util.ArrayList;
import java.util.List;

class LocationNumber {
	
	private List<String> locationList = new ArrayList<>();
	
	LocationNumber() {
		locationList.add("1159068000"); // 서울
		locationList.add("2820051000"); // 인천
		locationList.add("4111573000"); // 수원
		locationList.add("4148051000"); // 파주
		locationList.add("4211052000"); // 춘천
		locationList.add("4213066000"); // 원주
		locationList.add("4215051000"); // 강릉
		locationList.add("3017063000"); // 대전
		locationList.add("3611056000"); // 세종
		locationList.add("4480025000"); // 홍성
		locationList.add("4311167000"); // 청주
		locationList.add("2914074500"); // 광주
		locationList.add("4611051000"); // 목포
		locationList.add("4613078000"); // 여수
		locationList.add("4511160500"); // 전주
		locationList.add("4513065000"); // 군산
		locationList.add("2647069000"); // 부산
		locationList.add("3114051000"); // 울산
		locationList.add("4812155000"); // 창원
		locationList.add("2711051700"); // 대구
		locationList.add("4717052000"); // 안동
		locationList.add("4711159000"); // 포항
		locationList.add("5011066000"); // 제주
		locationList.add("5013058000"); // 서귀포
	}
	
	List<String> getLocation() {
		return locationList;
	}
}
