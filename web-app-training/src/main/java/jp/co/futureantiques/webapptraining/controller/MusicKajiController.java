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
import jp.co.futureantiques.webapptraining.model.form.musicKaji.MusicKajiDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.musicKaji.MusicKajiInputForm;
import jp.co.futureantiques.webapptraining.model.form.musicKaji.MusicKajiSearchForm;
import jp.co.futureantiques.webapptraining.model.musicKaji.ComposerKaji;
import jp.co.futureantiques.webapptraining.model.musicKaji.MusicMainKaji;
import jp.co.futureantiques.webapptraining.model.musicKaji.UnitKaji;
import jp.co.futureantiques.webapptraining.service.MusicKajiService;

/**
 * MusicKajiのコントローラークラス
 *
 * @author futute
 */
@Controller
@RequestMapping(value = "/musicKaji")
public class MusicKajiController {

	/** 楽曲のサービス **/
	private final MusicKajiService musicKajiService;

	/**
	 * コントラクタ
	 *
	 * @param MusicKajiService musicKajiService
	 */
	@Autowired
	public MusicKajiController(final MusicKajiService musicKajiService) {
		this.musicKajiService = musicKajiService;
	}

	/**
	 * ユニットエンティティのリストを取得する
	 *
	 * @return UnitKajiEntityのリスト
	 */
	@ModelAttribute
	public List<UnitKaji> getListUnitKaji() {
		return musicKajiService.getListUnitKaji();
	}

	/**
	 * 作曲者エンティティのリストを取得する
	 *
	 * @return ComposerKajiEntityのリスト
	 */
	@ModelAttribute
	public List<ComposerKaji> getListComposerKaji() {
		return musicKajiService.getListComposerKaji();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param MusicKajiSearchForm musicKajiSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchMusicKaji(@ModelAttribute final MusicKajiSearchForm musicKajiSearchForm) {
		return "musicKaji/search";
	}

	/**
	 * 検索画面を取得して検索画面に遷移する
	 *
	 * @param MusicKajiSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchMusicKaji(final MusicKajiSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<MusicMainKaji> musicKajiList = musicKajiService.getPageMusicMainKaji(form, pageable);
		if (musicKajiList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", musicKajiList);
			model.addAttribute("musicKajiList", musicKajiList.getContent());
			model.addAttribute("url", "search");
		}
		return "musicKaji/search";
	}

	/**
	 * 新規画面に遷移する
	 *
	 * @param MusicKajiInputForm movieKajiInputForm
	 * @return 新規画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertMusic(@ModelAttribute final MusicKajiInputForm musicKajiInputForm) {
		return "musicKaji/insert";
	}

	/**
	 * MusicMainKajiテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param MusicKajiInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertMusic(@ModelAttribute @Validated final MusicKajiInputForm form,
			final BindingResult bindingResult, Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "musicKaji/insert";
		}

		// データを登録する
		final MusicMainKaji musicMainKaji = musicKajiService.insertMusic(form);
		return "redirect:/musicKaji?result=insert&id=" + musicMainKaji.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param MusicKajiInputForm musicKajiInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateMusic(@RequestParam(name = "id") final long id,
			@ModelAttribute final MusicKajiInputForm musicKajiInputForm, Model model, final Pageable pageable) {

		// IDをキーにMusicMainKajiテーブルを検索する
		MusicMainKaji musicMainKaji = musicKajiService.getMusic(id);

		// フォームにレコードの値をセットする
		musicKajiInputForm.initWithMusicMainKaji(musicMainKaji);
		return "musicKaji/update";
	}

	/**
	 * MusicMainKajiテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param MusicKajiInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateMusic(@Validated final MusicKajiInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "musicKaji/update";
		}

		//データを更新する
		MusicMainKaji musicMainKaji = musicKajiService.updateMusic(form);
		if (musicMainKaji == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/musicKaji?result=updatefailed";
		}
		return "redirect:/musicKaji?result=update&id=" + musicMainKaji.getId();
	}

	/**
	 * MusicMainKajiテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteMusic(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		musicKajiService.deleteMusicById(id);
		return "redirect:/musicKaji?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param MusicKajiSearchForm form
	 * @param MusicKajiDeleteForm musicKajiDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompMusic(final MusicKajiSearchForm form,
			@ModelAttribute final MusicKajiDeleteForm musicKajiDeleteForm, final Model model) {

		// MusicMainKajiテーブルから削除フラグが1のレコードを検索する
		final List<MusicMainKaji> musicKajiList = musicKajiService.getListMusicMainKaji(form);

		// Modelに検索結果を格納する
		model.addAttribute(musicKajiList);
		return "musicKaji/deletecomp";
	}

	/**
	 * MusicMainKajiテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param MusicKajiDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompMusic(@Validated final MusicKajiDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			MusicKajiSearchForm musicKajiSearchForm = new MusicKajiSearchForm();
			musicKajiSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<MusicMainKaji> musicKajiList = musicKajiService.getListMusicMainKaji(musicKajiSearchForm);

			// Modelに検索画面を格納する
			model.addAttribute(musicKajiList);
			return "musicKaji/deletecomp";
		}

		// データを完全削除する
		musicKajiService.deleteMusicComp(form.getDeleteIds());
		return "redirect:/musicKaji?result=deletecomp";
	}

}
