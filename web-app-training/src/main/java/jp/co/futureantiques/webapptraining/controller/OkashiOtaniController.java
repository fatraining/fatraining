package jp.co.futureantiques.webapptraining.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.form.okashiotani.OkashiOtaniDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.okashiotani.OkashiOtaniInputForm;
import jp.co.futureantiques.webapptraining.model.form.okashiotani.OkashiOtaniSearchForm;
import jp.co.futureantiques.webapptraining.model.okashiotani.MakerOtani;
import jp.co.futureantiques.webapptraining.model.okashiotani.OkashiMainOtani;
import jp.co.futureantiques.webapptraining.model.okashiotani.TypeOtani;
import jp.co.futureantiques.webapptraining.service.OkashiOtaniService;

/**
 * OkashiOtaniのコントローラークラス
 *
 * @author otani
 */
@Controller
@RequestMapping(value = "/okashiotani")
public class OkashiOtaniController {

	/** お菓子のサービス */
	private final OkashiOtaniService okashiOtaniService;

	/**
	 * コンストラクタ
	 *
	 * @param OkashiOtaniService okashiOtaniService
	 */
	@Autowired
	public OkashiOtaniController(final OkashiOtaniService okashiOtaniService) {
		this.okashiOtaniService = okashiOtaniService;
	}

	/**
	 * 種類エンティティのリストを取得する
	 *
	 * @return TypeOtaniEntityのリスト
	 */
	@ModelAttribute
	public List<TypeOtani> getListTypeOtani() {
		return okashiOtaniService.getListTypeOtani();
	}

	/**
	 * メーカーエンティティのリストを取得する
	 *
	 * @return MakerOtaniEntityのリスト
	 */
	@ModelAttribute
	public List<MakerOtani> getListMaker() {
		return okashiOtaniService.getListMakerOtani();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param OkashiOtaniSearchForm okashiOtaniSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchOkashi(@ModelAttribute final OkashiOtaniSearchForm okashiOtaniSearchForm) {
		return "okashiotani/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param OkashiOtaniSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchOkashi(final OkashiOtaniSearchForm form, final Model model,
			final @PageableDefault(page = 0, value = 10) Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<OkashiMainOtani> okashiList = okashiOtaniService.getPageOkashiOtani(form, pageable);
		if (okashiList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", okashiList);
			model.addAttribute("okashiList", okashiList.getContent());
			model.addAttribute("url", "search");
		}
		return "okashiotani/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param OkashiOtaniInputForm okashiOtaniInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertOkashi(@ModelAttribute final OkashiOtaniInputForm okashiOtaniInputForm) {
		return "okashiotani/insert";
	}

	/**
	 * OkashiMainテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param OkashiOtaniInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertOkashi(@ModelAttribute @Validated final OkashiOtaniInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "okashiotani/insert";
		}

		// データを登録する
		final OkashiMainOtani okashiMainOtani = okashiOtaniService.insertOkashiOtani(form);
		return "redirect:/okashiotani?result=insert&id=" + okashiMainOtani.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param OkashiOtaniInputForm okashiOtaniInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateOkashi(@RequestParam(name = "id") final long id,
			@ModelAttribute final OkashiOtaniInputForm okashiOtaniInputForm) {

		// IDをキーにOkashiMainテーブルを検索する
		OkashiMainOtani okashiMainOtani = okashiOtaniService.getOkashiOtani(id);

		// フォームにレコードの値をセットする
		okashiOtaniInputForm.initWithOkashiMain(okashiMainOtani);
		return "okashiotani/update";
	}

	/**
	 * OkashiMainテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param OkashiOtaniInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateOkashi(@Validated final OkashiOtaniInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "okashiotani/update";
		}

		// データを更新する
		OkashiMainOtani okashiMainOtani = okashiOtaniService.updateOkashiOtani(form);
		if (okashiMainOtani == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/okashiotani?result=updatefailed";
		}
		return "redirect:/okashiotani?result=update&id=" + okashiMainOtani.getId();
	}

	/**
	 * OkashiMainテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteOkashiOtani(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		okashiOtaniService.deleteOkashiOtaniById(id);
		return "redirect:/okashiotani?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param OkashiOtaniSearchForm form
	 * @param OkashiOtaniDeleteForm okashiOtaniDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompOkashiOtani(final OkashiOtaniSearchForm form,
			@ModelAttribute final OkashiOtaniDeleteForm okashiOtaniDeleteForm, final Model model) {

		// OkashiMainOtaniテーブルから削除フラグが1のレコードを検索する
		final List<OkashiMainOtani> okashiList = okashiOtaniService.getListOkashiOtani(form);

		// Modelに検索結果を格納する
		model.addAttribute(okashiList);
		return "okashiotani/deletecomp";
	}

	/**
	 * OkashiMainテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param OkashiOtaniDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompOkashiOtani(@Validated final OkashiOtaniDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			OkashiOtaniSearchForm okashiOtaniSearchForm = new OkashiOtaniSearchForm();
			okashiOtaniSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<OkashiMainOtani> okashiList = okashiOtaniService.getListOkashiOtani(okashiOtaniSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(okashiList);
			return "okashiotani/deletecomp";
		}

		// データを完全削除する
		okashiOtaniService.deleteOkashiOtaniComp(form.getDeleteIds());
		return "redirect:/okashiotani?result=deletecomp";
	}
}
