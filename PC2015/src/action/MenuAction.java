package action;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;

import org.apache.struts2.dispatcher.ServletRedirectResult;

@Results({
	@Result(name = "main1", value = "main1.action", type = ServletRedirectResult.class),
	@Result(name = "main2", value = "main2.action", type = ServletRedirectResult.class)
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
}