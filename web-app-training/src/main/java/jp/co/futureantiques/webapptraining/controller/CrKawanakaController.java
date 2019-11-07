package jp.co.futureantiques.webapptraining.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import jp.co.futureantiques.webapptraining.model.crKawanaka.CategoryKawanaka;
import jp.co.futureantiques.webapptraining.model.crKawanaka.CrMainKawanaka;
import jp.co.futureantiques.webapptraining.model.crKawanaka.DistributionKawanaka;
import jp.co.futureantiques.webapptraining.model.form.crKawanaka.CrDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.crKawanaka.CrInputForm;
import jp.co.futureantiques.webapptraining.model.form.crKawanaka.CrSearchForm;
import jp.co.futureantiques.webapptraining.service.CrKawanakaService;

/**
 *CrKawanakaコントローラークラス
 *@author Misato Kawanaka
 */
@Controller
@RequestMapping(value = "/crkawanaka")
public class CrKawanakaController {
	/**CrKawanakaサービスクラス*/
	private final CrKawanakaService crKawanakaService;

	/**コンストラクタ
	 * @param CrKawanakaService crKawanakaService
	 */
	@Autowired
	public CrKawanakaController(final CrKawanakaService crKawanakaService) {
		this.crKawanakaService = crKawanakaService;
	}

	/**
	 * categoryKawanakaエンティティのリストを取得する
	 * @return CategoryKawanakaエンティティのリスト
	 */
	@ModelAttribute
	public List<CategoryKawanaka> getListCategoryKawanaka() {
		return crKawanakaService.getListCategoryKawanaka();
	}

	/**
	 * DistributionKawanakaエンティティのリストを取得する
	 * @return DistributionKawanakaエンティティのリスト
	 */
	@ModelAttribute
	public List<DistributionKawanaka> getListDistributionKawanaka() {
		return crKawanakaService.getListDistributionKawanaka();
	}

	/**
	 * 検索画面に遷移する
	 * @param CrSearchForm from
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearcthCr(@ModelAttribute final CrSearchForm crSearchFrom) {
		return "crkawanaka/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 * @param CrSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchCr(final CrSearchForm form, final Model model, final Pageable pageable) {
		//入力された検索結果をもとにレコードを取得する
		final Page<CrMainKawanaka> crList = crKawanakaService.getPageCr(form, pageable);
		if (crList.getTotalElements() != 0) {
			//検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", crList);
			model.addAttribute("crList", crList.getContent());
			model.addAttribute("url", "search");
		}
		return "crkawanaka/search";
	}

	/*
	 * 追加画面に遷移する
	 * @param CrInputForm crInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertCr(@ModelAttribute final CrInputForm crInputForm) {
		return "crkawanaka/insert";
	}

	//これらDIしないといけない
	@Autowired
	ResourceLoader resourceLoader;
	@Autowired
	ServletContext context;
	@Autowired
	WebApplicationContext wac;

	/**
	 * cr_main_kawanakaテーブルにデータを登録して検索画面に遷移する
	 * @param CrInputForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合追加画面のパス、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertCr(
			@ModelAttribute @Validated final CrInputForm form,
			final BindingResult bindingResult, Model model, MultipartFile crImage) {

		if (bindingResult.hasErrors()) {
			//入力エラーがある場合、戻る
			return "crkawanaka/insert";
		}

		//データを登録する
		final CrMainKawanaka crMainKawanaka = crKawanakaService.insertCr(form);
		return "redirect:/crkawanaka?result=insert&id=" + crMainKawanaka.getId();
	}

	/**
	 * 更新画面に遷移する
	 * @param long id
	 * @param rInputForm crInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateCr(@RequestParam(name = "id") final long id,
			@ModelAttribute final CrInputForm crInputForm) {
		CrMainKawanaka crMainkawanaka = crKawanakaService.getCr(id);

		crInputForm.initWithCrMainKawanaka(crMainkawanaka);
		return "crkawanaka/update";
	}

	/**
	 * cr_main_kawanakaテーブルのデータを更新して検索画面に遷移する
	 * @param CrInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合、更新画面のパス、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateCr(

			@Validated final CrInputForm form,
			final BindingResult bindingResult, MultipartFile crImage) {

		//入力エラーがある場合、次画面に戻る
		if (bindingResult.hasErrors()) {
			return "crkawanaka/update";
		}

		//データを更新する
		CrMainKawanaka crMainKawanaka = crKawanakaService.updateCr(form);
		if (crMainKawanaka == null) {

			//更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/crkawanaka?result=updatefailed";
		}
		return "redirect:/crkawanaka?result=update&id=" + crMainKawanaka.getId();
	}

	/**
	 * cr_main_kawanakaテーブルのデータを論理削除して検索画面に遷移する
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteCr(@RequestParam(name = "id") final long id) {

		//IDをキーにレコードを論理削除する
		crKawanakaService.deleteCrById(id);
		return "redirect:/crkawanaka?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 * @param CrSearchForm form
	 * @param CrDeleteForm flowerDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompCr(
			final CrSearchForm form,
			@ModelAttribute CrDeleteForm crDeleteForm, Model model) {

		//cr_main_kawanakaから削除フラグが1のデータを検索する
		final List<CrMainKawanaka> crList = crKawanakaService.getListCr(form);

		//modelに検索結果を格納する
		model.addAttribute(crList);
		return "crkawanaka/deletecomp";
	}

	/**
	 * cr_main_kawanakaのデータを完全削除して検索画面に遷移する
	 * @param CrDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合、完全削除画面、ない場合検索画面のパス
	 */

	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompCr(
			@Validated final CrDeleteForm form,
			final BindingResult bindingResult,
			final Model model) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合、再検索して自画面に戻る
			CrSearchForm crSearchForm = new CrSearchForm();
			crSearchForm.setIsDelete(1);
			final List<CrMainKawanaka> crList = crKawanakaService.getListCr(crSearchForm);

			//modelに検索結果を格納する
			model.addAttribute(crList);
			return "crkawanaka/deletecomp";
		}

		//データを完全削除する
		crKawanakaService.deleteCrComp(form.getDeleteIds());
		return "redirect:/crkawanaka?result=deletecomp";
	}
}
