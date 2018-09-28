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

import jp.co.futureantiques.webapptraining.model.IdolKataoka.ColorKataoka;
import jp.co.futureantiques.webapptraining.model.IdolKataoka.GroupKataoka;
import jp.co.futureantiques.webapptraining.model.IdolKataoka.IdolMainKataoka;
import jp.co.futureantiques.webapptraining.model.form.IdolKataoka.IdolDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.IdolKataoka.IdolInputForm;
import jp.co.futureantiques.webapptraining.model.form.IdolKataoka.IdolSearchForm;
import jp.co.futureantiques.webapptraining.service.IdolKataokaService;

/**
 * Idol_main_kataokaのコントローラークラス
 *
 * @author skataoka
 */
@Controller
@RequestMapping(value = "/idol")
public class IdolKataokaController {

	/** アイドル名のサービス */
	private final IdolKataokaService idolKataokaService;

	/**
	 * コンストラクタ
	 *
	 * @param IdolKataokaService idolKataokaService
	 */
	@Autowired
	public IdolKataokaController(final IdolKataokaService idolKataokaService) {
		this.idolKataokaService = idolKataokaService;
	}

	/**
	 *メンバーカラーエンティティのリストを取得する
	 *
	 * @return ColorEntityのリスト
	 */
	@ModelAttribute
	public List<ColorKataoka> getListColor() {
		return idolKataokaService.getListColorKataoka();
	}

	/**
	 * 所属グループエンティティのリストを取得する
	 *
	 * @return GroupEntityのリスト
	 */
	@ModelAttribute
	public List<GroupKataoka> getListGroup() {
		return idolKataokaService.getListGroupKataoka();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param IdolSearchForm idolSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchIdol(@ModelAttribute final IdolSearchForm idolSearchForm) {
		return "idolkataoka/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param IdolSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchIdol(final IdolSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<IdolMainKataoka> idolList = idolKataokaService.getPageIdol(form, pageable);
		if (idolList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", idolList);
			model.addAttribute("idolList", idolList.getContent());
			model.addAttribute("url", "search");
		}
		return "idolkataoka/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param IdolInputForm idolInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertIdol(@ModelAttribute final IdolInputForm idolInputForm) {
		return "idolkataoka/insert";
	}

	/**
	 * IdolMainKataokaテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param IdolInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertIdol(@ModelAttribute @Validated final IdolInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合次画面に戻る
			return "idolkataoka/insert";
		}

		// データを登録する
		final IdolMainKataoka idolMainKataoka = idolKataokaService.insertIdol(form);
		return "redirect:/idol?result=insert&id=" + idolMainKataoka.getIdolId();
		}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param IdolInputForm idolInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateIdol(@RequestParam(name = "id") final long id,
			@ModelAttribute final IdolInputForm idolInputForm) {

		// IDをキーにIdolMainKataokaテーブルを検索する
		IdolMainKataoka idolMainKataoka = idolKataokaService.getIdol(id);

		// フォームにレコードの値をセットする
		idolInputForm.initWithIdolMainKataoka(idolMainKataoka);
		return "idol/update";
			}

	/**
	 * IdolMainKataokaテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param IdolInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateIdol(@Validated final IdolInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合次画面に戻る
			return "idol/update";
		}

		// データを更新する
		IdolMainKataoka idolMainKataoka = idolKataokaService.updateIdol(form);
		if (idolMainKataoka == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/idol?result=updatefailed";
		}
		return "redirect:/idol?result=update&id=" + idolMainKataoka.getIdolId();
			}

	/**
	 * IdolMainKataokaテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteIdol(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		idolKataokaService.deleteIdolById(id);
		return "redirect:/idol?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param IdolSearchForm form
	 * @param IdolDeleteForm idolDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompIdol(final IdolSearchForm form,
			@ModelAttribute final IdolDeleteForm idolDeleteForm, final Model model) {

		// IdolMainKataokaテーブルから削除フラグが1のレコードを検索する
		final List<IdolMainKataoka> idolList = idolKataokaService.getListIdol(form);

		// Modelに検索結果を格納する
		model.addAttribute(idolList);
		return "idol/deletecomp";
			}

	/**
	 * IdolMainKataokaテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param IdolDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompIdol(@Validated final IdolDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			IdolSearchForm idolSearchForm = new IdolSearchForm();
			idolSearchForm.setIsDelete(1);
			final List<IdolMainKataoka> idolList = idolKataokaService.getListIdol(idolSearchForm);

			// Modelに検索結果を格納する
			model.addAllAttributes(idolList);
			return "idol/deletecomp";
		}

		// データを完全削除する
		idolKataokaService.deleteIdolComp(form.getDeleteIds());
		return "redirect:/idol?result=deletecomp";
			}
}
