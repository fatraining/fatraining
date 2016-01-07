package action;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;

import org.apache.struts2.dispatcher.ServletRedirectResult;

@Results({
		@Result(name = "facloud", value = "facloud.action", type = ServletRedirectResult.class),
		@Result(name = "main1", value = "main1.action", type = ServletRedirectResult.class),
		@Result(name = "main2", value = "main2.action", type = ServletRedirectResult.class),
		@Result(name = "main3", value = "main3.action", type = ServletRedirectResult.class),
		@Result(name = "main4", value = "bandSearch.action", type = ServletRedirectResult.class),
		@Result(name = "main5", value = "main5.action", type = ServletRedirectResult.class),
		@Result(name = "main6", value = "main6.action", type = ServletRedirectResult.class),
		@Result(name = "main7", value = "main7.action", type = ServletRedirectResult.class),
		@Result(name = "yasaiSearch", value = "yasaiSearch.action", type = ServletRedirectResult.class),
		@Result(name = "main9", value = "main9.action", type = ServletRedirectResult.class),
		@Result(name = "main10", value = "main10.action", type = ServletRedirectResult.class),
		@Result(name = "main11",value = "main11.action", type =ServletRedirectResult.class),
		@Result(name = "main12",value = "main12.action", type =ServletRedirectResult.class),
		@Result(name = "main13",value = "main13.action", type =ServletRedirectResult.class),
		@Result(name = "kaisyaSearch", value = "kaisyaSearch.action", type = ServletRedirectResult.class) })
public class MenuAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	public String execute() throws Exception {
		return "sccess";
	}
	public String gotoFacloud() {
		return "facloud";
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
		return "yasaiSearch";
	}

	public String gotoMain9() {
		return "main9";
	}

	public String gotoMain10() {
		return "main10";
	}
	
	public String gotoMain11(){
		return "main11";
	}
	public String gotoMain12(){
		return "main12";
	}
	public String gotoMain13(){
		return "main13";
	}
	public String gotoStaff() {
		return "kaisyaSearch";
	}
}