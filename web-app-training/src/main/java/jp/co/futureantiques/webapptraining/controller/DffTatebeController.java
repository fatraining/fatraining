package jp.co.futureantiques.webapptraining.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.dffTatebe.DffMainTatebe;
import jp.co.futureantiques.webapptraining.model.dffTatebe.DffTitleTatebe;
import jp.co.futureantiques.webapptraining.model.dffTatebe.DffTypeTatebe;
import jp.co.futureantiques.webapptraining.model.form.dffTatebe.DffTatebeDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.dffTatebe.DffTatebeInputForm;
import jp.co.futureantiques.webapptraining.model.form.dffTatebe.DffTatebeSearchForm;
import jp.co.futureantiques.webapptraining.service.DffTatebeService;

/** DESSIDIA FINAL FANTASYのコントローラークラス
 * @author user Tatebe
 */
@Controller
@RequestMapping(value = "/dffTatebe")
public class DffTatebeController {

	/** DESSIDIA FINAL FANTASYの検索サービス */
	private final DffTatebeService dffTatebeService;

	/**
	 * コンストラクタ
	 *
	 * @param DffTatebeService dffTatebeService
	 */
	@Autowired
	public DffTatebeController(final DffTatebeService dffTatebeService) {
		this.dffTatebeService = dffTatebeService;
	}

	/**
	 * 作品名エンティティのリストを取得する
	 *
	 * @return TitleTatebeのEntityのリスト
	 */
	@ModelAttribute
	public List<DffTitleTatebe> getListTitle() {
		return dffTatebeService.getListTitleTatebe();
	}

	/**
	 * タイプエンティティのリストを取得する
	 *
	 * @return TypeTatebeのEntityのリスト
	 */
	@ModelAttribute
	public List<DffTypeTatebe> getListType() {
		return dffTatebeService.getListTypeTatebe();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param DffTatebeSearchForm dffTatebeSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchDff(@ModelAttribute final DffTatebeSearchForm dffTatebeSearchForm) {
		return "dffTatebe/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param DffTatebeSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchDff(final DffTatebeSearchForm form, final Model model, final Pageable pageable) {

		//入力された検索条件をもとにレコードを取得
		final Page<DffMainTatebe> dffList = dffTatebeService.getPageDffTatebe(form, pageable);
		if (dffList.getTotalElements() != 0) {

			//検索結果がある場合Modelに結果をセットする
			model.addAttribute("page", dffList);
			model.addAttribute("dffList", dffList.getContent());
			model.addAttribute("url", "search");
		}
		return "dffTatebe/search";
	}

	/**
	 *追加画面に遷移する
	 *
	 * @param DffTatebeInputForm dffTatebeInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertDff(@ModelAttribute final DffTatebeInputForm dffTatebeInputForm) {
		return "dffTatebe/insert";
	}

	/**
	 * DffMainTatebeテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param DffTatebeInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertDffTatebe(@ModelAttribute @Validated final DffTatebeInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合自画面に戻る
			return "dffTatebe/insert";
		}

		//データを登録する
		final DffMainTatebe dffMainTatebe = dffTatebeService.insertDffTatebe(form);
		return "redirect:/dffTatebe?result=insert&id=" + dffMainTatebe.getId();
	}

	/**更新画面に遷移する
	 *
	 * @param long id
	 * @param DffTatebeInputForm dffTatebeInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUodateDff(@RequestParam(name = "id") final long id,
			@ModelAttribute final DffTatebeInputForm dffTatebeInputForm) {

		//IDをキーにDffTatebeMainテーブルを検索する
		DffMainTatebe dffMainTatebe = dffTatebeService.getDffTatebe(id);

		//フォームにレコードの値をセットする
		dffTatebeInputForm.initWithDffMainTatebe(dffMainTatebe);
		return "dffTatebe/update";
	}

	/**
	 * DffMainTatebeテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param DffTatebeInputForm form
	 * @param bindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateDff(@Validated final DffTatebeInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合自画面に戻る
			return "dffTatebe/update";
		}

		//データを更新する
		DffMainTatebe dffMainTatebe = dffTatebeService.updateDffTatebe(form);
		if (dffMainTatebe == null) {

			//更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/dffTatebe?result=updatefailed";
		}
		return "redirect:/dffTatebe?result=update&id=" + dffMainTatebe.getId();
	}

	/**
	 * DffMainTatebeテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteDff(@RequestParam(name = "id") final long id) {

		//IDをキーにレコードを論理削除する
		dffTatebeService.deleteDffTatebeById(id);
		return "redirect:/dffTatebe?result=delete&id=" + id;
	}

	/**
	 *完全削除画面に遷移する
	 *
	 * @param DffTatebeSearchForm
	 * @param DffTatebeDeleteForm dffTatebeDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteComp(final DffTatebeSearchForm form,
			@ModelAttribute final DffTatebeDeleteForm dffTatebeDeleteForm, final Model model) {

		//DffMainTatebeテーブルから削除フラグ1のレコードを検索する
		final List<DffMainTatebe> dffList = dffTatebeService.getListDffTatebe(form);

		//Modelに検索結果を格納する
		model.addAttribute(dffList);
		return "dffTatebe/deletecomp";
	}

	/**
	 * DffMainTatebeテーブルのデータを完全削除して検索画面に移る
	 *
	 * @param DffTatebeDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompDffTatebe(@Validated final DffTatebeDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合、再検索して次画面に戻る
			DffTatebeSearchForm dffTatebeSearchForm = new DffTatebeSearchForm();
			dffTatebeSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<DffMainTatebe> dffList = dffTatebeService
					.getListDffTatebe(dffTatebeSearchForm);

			model.addAttribute(dffList);
			return "dffTatebe/deletecomp";
		}

		//データを完全削除する
		dffTatebeService.deleteDffTatebeComp(form.getDeleteIds());
		return "redirect:/dffTatebe?result=deletecomp";
	}

}
