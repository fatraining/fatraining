package action;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;

import org.apache.struts2.dispatcher.ServletRedirectResult;

@Results({
	@Result(name = "main1", value = "main1.action", type = ServletRedirectResult.class),
	@Result(name = "main2", value = "main2.action", type = ServletRedirectResult.class),
	@Result(name = "main3", value = "main3.action", type = ServletRedirectResult.class),
	@Result(name = "main4", value = "main4.action", type = ServletRedirectResult.class),
	@Result(name = "main5", value = "main5.action", type = ServletRedirectResult.class),
	@Result(name = "main6", value = "main6.action", type = ServletRedirectResult.class),
	@Result(name = "main7", value = "main7.action", type = ServletRedirectResult.class),
	@Result(name = "main8", value = "main8.action", type = ServletRedirectResult.class),
	@Result(name = "main9", value = "main9.action", type = ServletRedirectResult.class),
	@Result(name = "main10", value = "main10.action", type = ServletRedirectResult.class)
})

public class MenuAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	
	public String execute() throws Exception {
		return "sccess";
	}

	public String gotoMain1() {
		return "main1";
	}

	public String gotoMain2() {
		return "main2";
	}
	
	public String gotoMain3() {
		return "main3";
	}

	public String gotoMain4() {
		return "main4";
	}
	
	public String gotoMain5() {
		return "main5";
	}

	public String gotoMain6() {
		return "main6";
	}
	
	public String gotoMain7() {
		return "main7";
	}

	public String gotoMain8() {
		return "main8";
	}
	
	public String gotoMain9() {
		return "main9";
	}

	public String gotoMain10() {
		return "main10";
	}
}