package junbsub;

import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		// 파싱 하여 데이터를 가져온다.
		Parsing p = new Parsing();
		List<Model> list = p.getParsingList();

		// 데이터베이스에 저장한다.
		DataProcess dp = new DataProcess(list);
		dp.startProcess();

		// 데이터베이스를 종료한다.
		DatabaseConnection.close();
	}
}
