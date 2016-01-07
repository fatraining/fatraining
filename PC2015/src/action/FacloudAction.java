package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.YasaiResultTable;
import model.Ryouri;
import model.Yasai;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import dao.YasaiDao;

@Result(name = "facloud", value = "facloud.action", type = ServletRedirectResult.class)
public class FacloudAction extends AbstractAction {

	
	private static final long serialVersionUID = 1L;

	private String titleTxt = "たいとる";
	
	// 画面表示時に実行
	@Override
	public String execute() {
		return "success";
	}
	
	public String getTitleTxt(){
		return this.titleTxt;
	}

}
