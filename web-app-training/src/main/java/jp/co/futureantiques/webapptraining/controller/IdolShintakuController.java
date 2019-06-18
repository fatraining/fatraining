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
import jp.co.futureantiques.webapptraining.model.form.idolShintaku.IdolShintakuDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.idolShintaku.IdolShintakuInputForm;
import jp.co.futureantiques.webapptraining.model.form.idolShintaku.IdolShintakuSearchForm;
import jp.co.futureantiques.webapptraining.model.idolShintaku.IdolMainShintaku;
import jp.co.futureantiques.webapptraining.model.idolShintaku.TypeShintaku;
import jp.co.futureantiques.webapptraining.model.idolShintaku.UnitShintaku;
import jp.co.futureantiques.webapptraining.service.IdolShintakuService;

/**
 * IdolShintakuのコントローラークラス
 *
 * @author shintaku
 */
@Controller
@RequestMapping(value = "/idolshintaku")
public class IdolShintakuController {

	//アイドルのサービス
	private final IdolShintakuService idolShintakuService;

	/**
	 * コンストラクタ
	 *
	 * @param IdolShintakuService idolShintakuService
	 */
	@Autowired
	public IdolShintakuController(final IdolShintakuService idolShintakuService) {
		this.idolShintakuService = idolShintakuService;
	}

	/**
	 * 属性エンティティのリストを取得する
	 *
	 * @return TypeShintakuEntityのリスト
	 */
	@ModelAttribute
	public List<TypeShintaku> getListType() {
		return idolShintakuService.getListType();
	}

	/**
	 * ユニットエンティティのリストを取得する
	 *
	 * @return UnitShintakuEntityのリスト
	 */
	@ModelAttribute
	public List<UnitShintaku> getListUnit() {
	return idolShintakuService.getListUnit();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param IdolShintakuSearchForm idolShintakuSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchIdol(@ModelAttribute final IdolShintakuSearchForm idolShintakuSearchForm) {
	return "idolShintaku/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param IdolShintakuSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchIdol(final IdolShintakuSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<IdolMainShintaku> idolList = idolShintakuService.getPageIdol(form, pageable);
		if (idolList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", idolList);
			model.addAttribute("idolList", idolList.getContent());
			model.addAttribute("url", "search");
		}
		return "idolShintaku/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param IdolShintakuInputForm idolShintakuInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert",method = RequestMethod.GET)
	public String showInsertIdol(@ModelAttribute final IdolShintakuInputForm idolShintakuInputForm) {
		return "idolShintaku/insert";
	}

	/**
	 * idol_main_shintakuテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param IdolShintakuInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合は追加画面、ない場合は検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertIdol(@ModelAttribute @Validated final IdolShintakuInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "idolShintaku/insert";
		}

		// データを登録する
		final IdolMainShintaku idolMainShintaku = idolShintakuService.insertIdol(form);
		return "redirect:/idolshintaku?result=insert&id=" + idolMainShintaku.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param IdolShintakuInputForm idolShintakuInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateIdol(@RequestParam(name = "id") final long id,
			@ModelAttribute final IdolShintakuInputForm idolShintakuInputForm) {

		// IDをキーにMovieMainテーブルを検索する
		IdolMainShintaku idolMainShintaku = idolShintakuService.getIdol(id);

		// フォームにレコードの値をセットする
		idolShintakuInputForm.initWithIdolMainShintaku(idolMainShintaku);
		return "idolShintaku/update";
	}

	/**
	 * idol_main_shintakuテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param IdolSHintakuInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合は更新画面、ない場合は検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateIdol(@Validated final IdolShintakuInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "idolShintaku/update";
		}

		// データを更新する
		IdolMainShintaku idolMainShintaku = idolShintakuService.updateIdol(form);
		if (idolMainShintaku == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/idolshintaku?result=updatefailed";
		}
		return "redirect:/idolshintaku?result=update&id=" + idolMainShintaku.getId();
	}

	/**
	 * idol_main_shintakuテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteIdol(@RequestParam(name = "id") final long id) {

		//IDをキーにレコードを論理削除する
		idolShintakuService.deleteIdolById(id);
		return "redirect:/idolshintaku?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param IdolShintakuSearchForm form
	 * @param IdolShintakuDeleteForm idolShintakuDeleteForm
	 * @param Model model
	 * @return 完全削除のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompMovie(final IdolShintakuSearchForm form,
			@ModelAttribute final IdolShintakuDeleteForm idolShintakuDeleteForm, final Model model) {

		// idol_main_shintakuテーブルから削除フラグが1のレコードを検索する
		final List<IdolMainShintaku> idolList = idolShintakuService.getListIdol(form);

		// Modelに検索結果を格納する
		model.addAttribute(idolList);
		return "idolShintaku/deletecomp";
	}

	/**
	 * idol_main_shintakuテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param idolShintakuDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合は完全削除画面、ない場合は検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompIdol(@Validated final IdolShintakuDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			IdolShintakuSearchForm idolShintakuSearchForm = new IdolShintakuSearchForm();
			idolShintakuSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<IdolMainShintaku> idolList = idolShintakuService.getListIdol(idolShintakuSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(idolList);
			return "idolShintaku/deletecomp";
		}

		// データを完全削除する
		idolShintakuService.deleteIdolComp(form.getDeleteIds());
		return "redirect:/idolshintaku?result=deletecomp";
	}
}
