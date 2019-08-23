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
import jp.co.futureantiques.webapptraining.model.form.ringoTakizawa.RingoTakizawaDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.ringoTakizawa.RingoTakizawaInputForm;
import jp.co.futureantiques.webapptraining.model.form.ringoTakizawa.RingoTakizawaSearchForm;
import jp.co.futureantiques.webapptraining.model.ringoTakizawa.RingoCdTitleTakizawa;
import jp.co.futureantiques.webapptraining.model.ringoTakizawa.RingoMainTakizawa;
import jp.co.futureantiques.webapptraining.model.ringoTakizawa.RingoSongImageTakizawa;
import jp.co.futureantiques.webapptraining.service.RingoTakizawaService;

/**
 * RingoTakizawaのコントローラークラス
 *
 * @author Mai Takizawa
 */
@Controller
@RequestMapping(value = "/ringoTakizawa")

public class RingoTakizawaController {

	/** 椎名林檎の曲（プレイリスト）のサービス */
	private final RingoTakizawaService ringoTakizawaService;

	/**
	 * コンストラクタ
	 *
	 * @param RingoTakizawaService ringoTakizawaService
	 */
	@Autowired
	public RingoTakizawaController(final RingoTakizawaService ringoTakizawaService) {
		this.ringoTakizawaService = ringoTakizawaService;
	}

	/**
	 * CD名エンティティのリストを取得する
	 *
	 * @return RingoCdTitleTakizawaEntityのリスト
	 */
	@ModelAttribute
	public List<RingoCdTitleTakizawa> getListRingoCdTitleTakizawa() {

		return ringoTakizawaService.getListRingoCdTitleTakizawa();
	}

	/**
	 * 聞きたい気分エンティティのリストを取得する
	 *
	 * @return RingoSongImageTakizawaEntityのリスト
	 */
	@ModelAttribute
	public List<RingoSongImageTakizawa> getListRingoSongImageTakizawa() {
		return ringoTakizawaService.getListRingoSongImageTakizawa();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param RingoTakizawaSearchForm ringoTakizawaSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchRingoTakizawa(@ModelAttribute final RingoTakizawaSearchForm ringoTakizawaSearchForm) {
		return "ringoTakizawa/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param RingoTakizawaSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchRingoTakizawa(final RingoTakizawaSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<RingoMainTakizawa> ringoTakizawaList = ringoTakizawaService.getPageRingo(form, pageable);
		if (ringoTakizawaList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", ringoTakizawaList);
			model.addAttribute("ringoTakizawaList", ringoTakizawaList.getContent());
			model.addAttribute("url", "search");
		}
		return "ringoTakizawa/search";

	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param RingoTakizawaInput ringoTakizawaInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertSpa(@ModelAttribute final RingoTakizawaInputForm ringoTakizawaInputForm) {
		return "ringoTakizawa/insert";
	}

	/**
	 * RingoMainTakizawaテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param RingoTakizawaInput form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertRingo(@ModelAttribute @Validated final RingoTakizawaInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "ringoTakizawa/insert";
		}

		// データを登録する
		final RingoMainTakizawa ringoMainTakizawa = ringoTakizawaService.insertRingo(form);
		return "redirect:/ringoTakizawa?result=insert&id=" + ringoMainTakizawa.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param RingoTakizawaInput RingoTakizawaInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateRingo(@RequestParam(name = "id") final long id,
			@ModelAttribute final RingoTakizawaInputForm ringoTakizawaInputForm) {

		// IDをキーにRingoMainTakizawaテーブルを検索する
		RingoMainTakizawa ringoMainTakizawa = ringoTakizawaService.getRingoMainTakizawa(id);

		// フォームにレコードの値をセットする
		ringoTakizawaInputForm.initWithRingoMainTakizawa(ringoMainTakizawa);
		return "ringoTakizawa/update";
	}

	/**
	 * RingoMainTakizawaテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param RingoTakizawaInput form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateRingo(@Validated final RingoTakizawaInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "ringoTakizawa/update";
		}

		// データを更新する
		RingoMainTakizawa ringoMainTakizawa = ringoTakizawaService.updateRingo(form);
		if (ringoMainTakizawa == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/ringoTakizawa?result=updatefailed";
		}
		return "redirect:/ringoTakizawa?result=update&id=" + ringoMainTakizawa.getId();
	}

	/**
	 * RingoMainTakizawaテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteRingo(@RequestParam(name = "id") final long id) {

		//IDをキーにレコードを論理削除する
		ringoTakizawaService.deleteRingoById(id);
		return "redirect:/ringoTakizawa?result=delete&id=" + id;
	}
	/**
	 * 完全削除画面に遷移する
	 *
	 * @param RingoTakizawaSearchForm form
	 * @param RingoTakizawaDeleteForm ringoTakizawaDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompRingo(final RingoTakizawaSearchForm form,
			@ModelAttribute final RingoTakizawaDeleteForm ringoTakizawaDeleteForm, final Model model) {

		// MovieMainテーブルから削除フラグが1のレコードを検索する
		final List<RingoMainTakizawa> ringoTakizawaList = ringoTakizawaService.getListRingoMainTakizawa(form);

		// Modelに検索結果を格納する
		model.addAttribute(ringoTakizawaList);
		return "ringoTakizawa/deletecomp";
	}
	/**
	 * RingoMainTakizawaテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param RingoTakizawaDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompRingo(@Validated final RingoTakizawaDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			RingoTakizawaSearchForm ringoTakizawaSearchForm = new RingoTakizawaSearchForm();
			ringoTakizawaSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<RingoMainTakizawa> ringoTakizawaList = ringoTakizawaService.getListRingoMainTakizawa(ringoTakizawaSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(ringoTakizawaList);
			return "ringoTakizawa/deletecomp";
		}

		// データを完全削除する
		ringoTakizawaService.deleteRingoComp(form.getDeleteIds());
		return "redirect:/ringoTakizawa?result=deletecomp";
	}
}
