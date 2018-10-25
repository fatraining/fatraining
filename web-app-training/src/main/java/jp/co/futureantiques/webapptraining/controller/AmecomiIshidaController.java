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

import jp.co.futureantiques.webapptraining.model.amecomiishida.AmecomiCharIshida;
import jp.co.futureantiques.webapptraining.model.amecomiishida.CompanyIshida;
import jp.co.futureantiques.webapptraining.model.amecomiishida.SideIshida;
import jp.co.futureantiques.webapptraining.model.form.amecomiIshida.AmecomiIshidaSearchForm;
import jp.co.futureantiques.webapptraining.service.AmecomiIshidaService;

@Controller
@RequestMapping(value = "/amecomiishida")
public class AmecomiIshidaController {

	/** AmecomiIshidaのサービス */
	private final AmecomiIshidaService amecomiIshidaService;

	/**
	 * コンストラクタ
	 * @param AmecomiIshidaService amecomiIshidaService
	 */
	@Autowired
	public AmecomiIshidaController(final AmecomiIshidaService amecomiIshidaService) {
		this.amecomiIshidaService=amecomiIshidaService;
	}

	/**
	 * CompanyIshidaエンティティのリストを取得する
	 * @return CompanyIshidaEntityのリスト
	 */
	@ModelAttribute
	public List<CompanyIshida> getListCompanyIshida(){
		return amecomiIshidaService.getListCompanyIshida();
	}

	/**
	 * SideIshidaエンティティのリストを取得する
	 * @return SideIshidaEntityのリスト
	 */
	@ModelAttribute
	public List<SideIshida> getListSideIshida(){
		return amecomiIshidaService.getListSideIshida();
	}

	/**
	 * 検索画面に遷移する
	 * @param AmecomiCharIshidaForm amecomiIshidaSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value="",method=RequestMethod.GET)
	public String showSearchAmecomiIshida(@ModelAttribute final AmecomiIshidaSearchForm amecomiIshidaSearchForm) {
		return "amecomiishida/search";

	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 * @param amecomiIshidaSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value="search", method=RequestMethod.POST)
	public String searchAmecomiIshida(final AmecomiIshidaSearchForm form,final Model model,final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<AmecomiCharIshida> amecomiIshidaList=amecomiIshidaService.getPageAmecomiIshida(form, pageable);
		if(amecomiIshidaList.getTotalElements() !=0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page",amecomiIshidaList);
			model.addAttribute("amecomiCharList",amecomiIshidaList.getContent());
			model.addAttribute("url","search");
		}
		return "amecomiishida/search";
	}

//	/**
//	 * AmecomiCharテーブルのレコードを論理削除して検索画面に遷移する
//	 * @param long id
//	 * @return 検索画面のパス
//	 */
//	@RequestMapping(value="delete", method=RequestMethod.GET)
//	public String deleteAmecomiIshida(@RequestParam(name="id") final long id) {
//
//		// IDをキーにレコードを論理削除する
//		amecomiIshidaService.deleteAmecomiCharIshidaById(id);
//		return "redirect:/amecomiishida?result=delete&id="+id;
//	}
}
