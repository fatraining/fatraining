package jp.co.futureantiques.webapptraining.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.futureantiques.webapptraining.model.form.resipeishikawa.ResipeIshikawaSearchForm;
import jp.co.futureantiques.webapptraining.model.resipeishikawa.GenreIshikawa;
import jp.co.futureantiques.webapptraining.model.resipeishikawa.ResipeMainIshikawa;
import jp.co.futureantiques.webapptraining.model.resipeishikawa.VegetableIshikawa;
import jp.co.futureantiques.webapptraining.service.ResipeIshikawaService;

/**
 * Resipeのコントローラークラス
 *
 * @author t.ishikawa
 */
@Controller
@RequestMapping(value ="/resipeIshikawa")
public class ResipeIshikawaController {

	/**献立のサービス */
	private final ResipeIshikawaService resipeIshikawaService;

	/**コンストラクタ
	 *
	 * @param ResipeIshikawaService resipeIshikawaService
	 */
	@Autowired
	public ResipeIshikawaController(final ResipeIshikawaService resipeIshikawaService) {
		this.resipeIshikawaService = resipeIshikawaService;
	}

	/**
	 * 野菜エンティティのリストを取得する
	 *
	 * @return VegetableEntityのリスト
	 */
	@ModelAttribute
	public List<VegetableIshikawa> getListVegetable(){
		return resipeIshikawaService.getListVegetable();
	}

	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return GenreEntityのリスト
	 */
	@ModelAttribute
	public List<GenreIshikawa> getListGenre(){
		return resipeIshikawaService.getListGenre();
	}

	/**
	 * 検索画面に遷移する
	 *
	 *@param resipeIshikawaSearchForm resipeIshikawaSearchFrom
	 *@param 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearch(@ModelAttribute final ResipeIshikawaSearchForm resipeIshikawaSearchForm) {
		return "resipeishikawa/search";
	}

	/**
	 *検索結果を取得して検索画面に遷移する
	 *
	 *@param ResipeIshikawaSearchForm
	 *@param Model model
	 *@param Pageable pageable
	 *@param 検索画面のパス
	 */
	@RequestMapping(value = "search",method = RequestMethod.POST)
	public String searchResipe(final ResipeIshikawaSearchForm form,final Model model,final Pageable pageable) {

		//入力された検索条件を元にレコードを取得する
		final Page<ResipeMainIshikawa>resipeIshikawaList = resipeIshikawaService.getPageResipe(form, pageable);
		if(resipeIshikawaList.getTotalElements()!= 0) {

			//検索結果がある場合はModelに結果をセットする
			model.addAttribute("page",resipeIshikawaList);
			model.addAttribute("resipeIshikawaList",resipeIshikawaList.getContent());
			model.addAttribute("url","search");
		}
		return  "resipeIshikawa/search";
	}
}