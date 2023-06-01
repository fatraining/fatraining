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
import jp.co.futureantiques.webapptraining.model.form.kpoptateishi.KpopTateishiDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.kpoptateishi.KpopTateishiInputForm;
import jp.co.futureantiques.webapptraining.model.form.kpoptateishi.KpopTateishiSearchForm;
import jp.co.futureantiques.webapptraining.model.kpoptateishi.Idol;
import jp.co.futureantiques.webapptraining.model.kpoptateishi.KpopMain;
import jp.co.futureantiques.webapptraining.model.kpoptateishi.Office;
import jp.co.futureantiques.webapptraining.service.KpopTateishiService;

/**
 * KpopTateishiのコントローラークラス
 *
 * @author future
 */
@Controller
@RequestMapping(value = "/kpoptateishi")
public class KpopTateishiController {

	/** 楽曲のサービス */
	private final KpopTateishiService kpopTateishiService;

	/**
	 * コンストラクタ
	 *
	 * @param KpopTateishiService kpopTateishiService
	 */
	@Autowired
	public KpopTateishiController(final KpopTateishiService kpopTateishiService) {
		this.kpopTateishiService = kpopTateishiService;
	}

	/**
	 * アイドルエンティティのリストを取得する
	 *
	 * @return IdolEntityのリスト
	 */
	@ModelAttribute
	public List<Idol> getListIdol() {
		return kpopTateishiService.getListIdol();
	}

	/**
	 * 所属事務所エンティティのリストを取得する
	 *
	 * @return OfficeEntityのリスト
	 */
	@ModelAttribute
	public List<Office> getListKpopOffice() {
		return kpopTateishiService.getListOffice();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param KpopTateishiSearchForm kpopTateishiSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchMusic(@ModelAttribute final KpopTateishiSearchForm kpopTateishiSearchForm) {
		return "kpoptateishi/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param KpopTateishiSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchMusic(final KpopTateishiSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<KpopMain> musicList = kpopTateishiService.getPageMusic(form, pageable);
		if (musicList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", musicList);
			model.addAttribute("musicList", musicList.getContent());
			model.addAttribute("url", "search");
		}
		return "/kpoptateishi/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param KpopTateishiInputForm kpopTateishiInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertMusic(@ModelAttribute final KpopTateishiInputForm kpopTateishiInputForm) {
		return "kpoptateishi/insert";
	}

	/**
	 * KpopMainテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param KpopTateishiInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertMusic(@ModelAttribute @Validated final KpopTateishiInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "kpoptateishi/insert";
		}

		// データを登録する
		final KpopMain kpopMain = kpopTateishiService.insertMusic(form);
		return "redirect:/kpoptateishi?result=insert&id=" + kpopMain.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param KpopTateishiInputForm kpopTateishiInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateMusic(@RequestParam(name = "id") final long id,
			@ModelAttribute final KpopTateishiInputForm kpopTateishiInputForm) {

		// IDをキーにMovieMainテーブルを検索する
		KpopMain kpopMain = kpopTateishiService.getMusic(id);

		// フォームにレコードの値をセットする
		kpopTateishiInputForm.initWithKpopMain(kpopMain);
		return "kpoptateishi/update";
	}

	/**
	 * KpopMainテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param KpopTateishiInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateMusic(@Validated final KpopTateishiInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "kpoptateishi/update";
		}

		// データを更新する
		KpopMain kpopMain = kpopTateishiService.updateMusic(form);
		if (kpopMain == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/kpoptateishi?result=updatefailed";
		}
		return "redirect:/kpoptateishi?result=update&id=" + kpopMain.getId();
	}

	/**
	 * KpopMainテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteMusic(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		kpopTateishiService.deleteMusicById(id);
		return "redirect:/kpoptateishi?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param KpopTateishiSearchForm form
	 * @param KpopTateishiDeleteForm kpopTateishiDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompMusic(final KpopTateishiSearchForm form,
			@ModelAttribute final KpopTateishiDeleteForm kpopTateishiDeleteForm, final Model model) {

		// KpopMainテーブルから削除フラグが1のレコードを検索する
		final List<KpopMain> musicList = kpopTateishiService.getListMusic(form);

		// Modelに検索結果を格納する
		model.addAttribute(musicList);
		return "kpoptateishi/deletecomp";
	}

	/**
	 * KpopMainテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param KpopTateishiDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompMusic(@Validated final KpopTateishiDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			KpopTateishiSearchForm kpopTateishiSearchForm = new KpopTateishiSearchForm();
			kpopTateishiSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<KpopMain> musicList = kpopTateishiService.getListMusic(kpopTateishiSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(musicList);
			return "kpoptateishi/deletecomp";
		}

		// データを完全削除する
		kpopTateishiService.deleteMusicComp(form.getDeleteIds());
		return "redirect:/kpoptateishi?result=deletecomp";
	}

	// 削除画面追加機能
	/**
	 *kpopMainTateishiの論理削除されたレコードを復元して削除画面に戻る
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value="restore", method=RequestMethod.GET)
	public String restoreKpop(@RequestParam(name="id")final long id) {

		// idをキーに削除フラグを0にして論理削除から復元する
		kpopTateishiService.restoreById(id);

		// 検索画面にリダイレクト
		return "redirect:/kpoptateishi?result=restore&id=" + id;
	}
}
