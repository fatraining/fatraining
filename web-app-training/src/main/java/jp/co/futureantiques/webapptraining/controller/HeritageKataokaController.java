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

import jp.co.futureantiques.webapptraining.model.form.heritageKataoka.HeritageDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.heritageKataoka.HeritageInputForm;
import jp.co.futureantiques.webapptraining.model.form.heritageKataoka.HeritageSearchForm;
import jp.co.futureantiques.webapptraining.model.heritagekataoka.GenreKataoka;
import jp.co.futureantiques.webapptraining.model.heritagekataoka.HeritageMainKataoka;
import jp.co.futureantiques.webapptraining.model.heritagekataoka.LocationKataoka;
import jp.co.futureantiques.webapptraining.service.HeritageKataokaService;

/**
 * Heritageのコントローラークラス
 *
 * @author MIKI KATAOKA
 */
@Controller
@RequestMapping(value = "/heritage") //ローカルホスト名の後に記述。ブラウザのこと
public class HeritageKataokaController {

	/** 世界遺産のサービス */
	private final HeritageKataokaService heritageKataokaService;

	/**
	 * コンストラクタ
	 *
	 * @param HeritageKataokaService heritageKataokaService
	 */
	@Autowired
	public HeritageKataokaController(final HeritageKataokaService heritageKataokaService) {
		this.heritageKataokaService = heritageKataokaService;
	}

	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return GenreEntityのリスト
	 */
	@ModelAttribute
	public List<GenreKataoka> getListGenre() {
		List<GenreKataoka> genres = heritageKataokaService.getListGenre();
		return heritageKataokaService.getListGenre();
	}

	/**
	 * locationエンティティのリストを取得する
	 *
	 * @return LocationEntityのリスト
	 */
	@ModelAttribute
	public List<LocationKataoka> getListLocation() {
		return heritageKataokaService.getListLocation();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param heritageSearchForm heritageSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchHeritage(@ModelAttribute final HeritageSearchForm heritageSearchForm) {
		return "heritagekataoka/search";
	}

	/**
	 *検索結果を取得して検索画面に遷移する
	 *
	 *@param HeritageSearchForm form
	 *@param Model model
	 *@param Pageable pageable
	 *@return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchHeritage(final HeritageSearchForm form, final Model model, final Pageable pageable) {

		//入力された検索条件を元にレコードを取得する
		final Page<HeritageMainKataoka> heritageList = heritageKataokaService.getPageHeritage(form, pageable);
		if (heritageList.getTotalElements() != 0) {

			//検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", heritageList);
			model.addAttribute("heritageList", heritageList.getContent());
			model.addAttribute("url", "search");
		}
		return "heritagekataoka/search"; //←表示させるhtmlを示す
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param HeritageInputForm heritageInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertHeritage(@ModelAttribute final HeritageInputForm heritageInputForm) {
		return "heritagekataoka/insert";
	}

	/**
	 * HeritageMainテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param HeritageInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertHeritage(@ModelAttribute @Validated final HeritageInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合次画面に戻る
			return "heritagekataoka/insert";
		}

		//データを登録する
		final HeritageMainKataoka heritageMainKataoka = heritageKataokaService.insertHeritage(form);
		return "redirect:/heritage?result=insert&id=" + heritageMainKataoka.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param HeritageInputForm heritageInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateHeritage(@RequestParam(name = "id") final long id,
			@ModelAttribute final HeritageInputForm heritageInputForm) {

		//IDをキーにHeritageMainテーブルを検索する
		HeritageMainKataoka heritageMainKataoka = heritageKataokaService.getHeritage(id);

		//フォームにレコードの値をセットする
		heritageInputForm.initWithHeritageMain(heritageMainKataoka);
		return "heritagekataoka/update";
	}

	/**
	 * HeritageMainテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param HeritageInputForm form
	 * @param BindingResult bindingResult
	 * @param 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateHeritage(@Validated final HeritageInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合次画面に戻る
			return "heritagekataoka/update";
		}

		//データを更新する
		HeritageMainKataoka heritageMainKataoka = heritageKataokaService.updateHeritage(form);
		if (heritageMainKataoka == null) {

			//更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/heritage?result=updatefailed";
		}
		return "redirect:/heritage?result=update&id=" + heritageMainKataoka.getId();
	}

	/**
	 * HeritageMainテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteHeritage(@RequestParam(name = "id") final long id) {

		//IDをキーにレコードを論理削除する
		heritageKataokaService.deleteHeritageById(id);
		return "redirect:/heritage?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param HeritageSearchForm form
	 * @para HeritageDeleteForm heritageDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteComHeritage(final HeritageSearchForm form,
			@ModelAttribute final HeritageDeleteForm heritageDeleteForm, final Model model) {

		//Heritageテーブルから削除フラグが1のレコードを検索する
		final List<HeritageMainKataoka> heritageList = heritageKataokaService.getListHeritage(form);

		//Modelに検索結果を格納する
		model.addAttribute(heritageList);
		return "heritagekataoka/deletecomp";
	}

	/**
	 * Heritageテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param HeritageDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面に遷移
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompHeritage(@Validated final HeritageDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合、再検索して自画面に戻る
			HeritageSearchForm heritageSearchForm = new HeritageSearchForm();
			heritageSearchForm.setIsDelete(1);
			final List<HeritageMainKataoka> heritageList = heritageKataokaService.getListHeritage(heritageSearchForm);

			//Modelに検索結果を格納する
			model.addAllAttributes(heritageList);
			return "heritagekataoka/deletecomp";
		}

		//データを完全削除する
		heritageKataokaService.deleteHeritageComp(form.getDeleteIds());
		return "redirect:/heritage?result=deletecomp";

	}
}
