package endpoint;

import java.util.List;

public class testClass {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		YatteDao dao = new YatteDao();
		List<yatteName> result = dao.name();
		System.out.println(result);
	}

}
