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
import jp.co.futureantiques.webapptraining.model.comicMiyoshi.ComicMainMiyoshi;
import jp.co.futureantiques.webapptraining.model.comicMiyoshi.MagazineMiyoshi;
import jp.co.futureantiques.webapptraining.model.form.comicMiyoshi.ComicMiyoshiDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.comicMiyoshi.ComicMiyoshiInputForm;
import jp.co.futureantiques.webapptraining.model.form.comicMiyoshi.ComicMiyoshiSearchForm;
import jp.co.futureantiques.webapptraining.service.ComicMiyoshiService;

/**
 * ComicMiyoshiのコントローラークラス
 * @author Miyoshi
 */
@Controller
@RequestMapping(value = "/comicMiyoshi")
public class ComicMiyoshiController {

	/**漫画のサービス*/
	private final ComicMiyoshiService comicMiyoshiService;

	/**
	 * コンストラクタ
	 * @Param ComicMiyoshiService comicMiyoshiService;
	 */
	@Autowired
	ComicMiyoshiController(final ComicMiyoshiService comicMiyoshiService) {
		this.comicMiyoshiService = comicMiyoshiService;
	}

	/**
	 * 連載雑誌エンティティのリストを取得する
	 * @return MagazineEntityのリスト
	 */
	@ModelAttribute
	public List<MagazineMiyoshi> getListMagazineMiyoshi() {
		return comicMiyoshiService.getListMagazineMiyoshi();
	}

	/**
	 * 検索画面に遷移する
	 * @param comicMiyoshiSearchForm comicMiyoshiSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchComic(@ModelAttribute final ComicMiyoshiSearchForm comicMiyoshiSearchForm) {
		return "comicMiyoshi/search";
	}

	/**
	 *検索結果を取得して検索画面に遷移する
	 *@param comicMiyoshiSearchForm form
	 *@param Model model
	 *@param Pageable pageable
	 *@return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String SearchComic(final ComicMiyoshiSearchForm form, final Model model, final Pageable pageable) {

		//入力された条件を元にレコードを取得する
		final Page<ComicMainMiyoshi> comicList = comicMiyoshiService.getPageComic(form, pageable);
		if (comicList.getTotalElements() != 0) {

			//検索結果がある場合、Modelに結果をセットする。
			model.addAttribute("page", comicList);
			model.addAttribute("comicList", comicList.getContent());
			model.addAttribute("url", "search");
		}

		return "comicMiyoshi/search";
	}

	/**
	 * 追加画面に遷移する
	 * @param ComicMiyoshiInputForm comicMiyoshiInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertComic(@ModelAttribute final ComicMiyoshiInputForm comicMiyoshiInputForm) {
		return "comicMiyoshi/insert";
	}

	/**
	 * ComicMainMiyoshiテーブルにデータを登録して検索画面に遷移する
	 * @param ComicMiyoshiInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertComic(@ModelAttribute @Validated final ComicMiyoshiInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合自画面に戻る
			return "comicMiyoshi/insert";
		}

		//データを登録する
		final ComicMainMiyoshi comicMainMiyoshi = comicMiyoshiService.insertComic(form);
		return "redirect:/comicMiyoshi?result=insert&id=" + comicMainMiyoshi.getId();
	}

	/**
	 * 更新画面に遷移する
	 * @param long id
	 * @param ComicMiyoshiInputForm comicMiyoshiInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateComic(@RequestParam(name = "id") final long id,
			@ModelAttribute final ComicMiyoshiInputForm comicMiyoshiInputForm) {

		//IDキーにComicMainMiyoshiテーブルを検索する
		ComicMainMiyoshi comicMainMiyoshi = comicMiyoshiService.getComic(id);

		//フォームにレコードの値をセットする
		comicMiyoshiInputForm.initWithComicMainMiyoshi(comicMainMiyoshi);
		return "comicMiyoshi/update";
	}

	/**
	 * ComicMainMiyoshiテーブルのデータを更新して検索画面に遷移する
	 * @param ComicMiyoshiInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateComic(@Validated final ComicMiyoshiInputForm form, final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合自画面に戻る
			return "comicMiyoshi/update";
		}

		//データを更新する
		ComicMainMiyoshi comicMainMiyoshi = comicMiyoshiService.updateComic(form);
		if (comicMainMiyoshi == null) {

			//更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/comicMain?result=updatefailed";
		}
		return "redirect:/comicMiyoshi?result=update&id=" + comicMainMiyoshi.getId();
	}

	/**
	 * ComicMainMiyoshiテーブルのレコードを論理削除して検索画面に遷移する
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteComic(@RequestParam(name = "id") final long id) {

		//IDをキーにレコードを論理削除する
		comicMiyoshiService.deleteComicById(id);
		return "redirect:/comicMiyoshi?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 * @param ComicMiyoshiSearchForm form
	 * @param ComicMiyoshiDeleteForm comicMiyoshiDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteComic(final ComicMiyoshiSearchForm form,
			@ModelAttribute final ComicMiyoshiDeleteForm comicMiyoshiDeleteForm, final Model model) {

		//ComicMainMiyoshiテーブルから削除フラグが1のレコードを検索する
		final List<ComicMainMiyoshi> comicList = comicMiyoshiService.getListComic(form);

		//Modelに検索結果を格納する
		model.addAttribute(comicList);
		return "comicMiyoshi/deletecomp";
	}

	/**
	 * ComicMainMiyoshiテーブルのデータを完全削除して検索画面に遷移する
	 * @param ComicMiyoshiDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompComic(@Validated final ComicMiyoshiDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合、再検索して自画面に戻る
			ComicMiyoshiSearchForm comicMiyoshiSearchForm = new ComicMiyoshiSearchForm();
			comicMiyoshiSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<ComicMainMiyoshi> comicList = comicMiyoshiService.getListComic(comicMiyoshiSearchForm);

			//Modelに検索結果を格納する
			model.addAttribute(comicList);
			return "comicMiyoshi/deletecomp";
		}

		//データを完全削除する
		comicMiyoshiService.deleteComicComp(form.getDeleteIds());
		return "redirect:/comicMiyoshi?result=deletecomp";
	}
}
