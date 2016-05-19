package endpoint;

public class CContents {

	private String name;
	private String who;
	private String time;
	private String ex;
	private String favButton;

	// YatteMainでIDふってあげてね
	private int No;

	// getter,setter類//

	public String getWho() {
		return who;
	}

	public void setWho(String who) {
		this.who = who;
	}

	public String getEx() {
		return ex;
	}

	public void setEx(String ex) {
		this.ex = ex;
	}


	public String getTime() {
		return time;
	}

	public void setTime(String localDateTime) {
		this.time = localDateTime;
	}

	public String getYattal() {
		return favButton;
	}

	public void setYattal(String yattal) {
		this.favButton = yattal;
	}



	public int getNo() {
		return No;
	}

	public void setNo(int no) {
		No = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
