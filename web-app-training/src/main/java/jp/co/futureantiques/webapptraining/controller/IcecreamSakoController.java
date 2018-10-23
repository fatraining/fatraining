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

import jp.co.futureantiques.webapptraining.model.IcecreamSako.GenreSako;
import jp.co.futureantiques.webapptraining.model.IcecreamSako.IcecreamMainSako;
import jp.co.futureantiques.webapptraining.model.IcecreamSako.MakerSako;
import jp.co.futureantiques.webapptraining.model.form.icecreamSako.IcecreamDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.icecreamSako.IcecreamInputForm;
import jp.co.futureantiques.webapptraining.model.form.icecreamSako.IcecreamSearchForm;
import jp.co.futureantiques.webapptraining.service.IcecreamSakoService;

/**
 * icecream_main_sakoのコントローラークラス
 *
 * @author MINAMI SAKO
 */
@Controller
@RequestMapping(value = "/icecream")
public class IcecreamSakoController {

	/** 名前のサービス */
	private final IcecreamSakoService icecreamSakoService;

	/**
	 * コンストラクタ
	 *
	 * @param IcecreamSakoService icecreamSakoService
	 */
	@Autowired
	public IcecreamSakoController(final IcecreamSakoService icecreamSakoService) {
		this.icecreamSakoService = icecreamSakoService;
	}

	/**
	 *ジャンルエンティティのリストを取得する
	 *
	 * @return GenreEntityのリスト
	 */
	@ModelAttribute
	public List<GenreSako> getListGenre() {
		return icecreamSakoService.getListGenreSako();
	}

	/**
	 * メーカーエンティティのリストを取得する
	 *
	 * @return MakerEntityのリスト
	 */
	@ModelAttribute
	public List<MakerSako> getListMaker() {
		return icecreamSakoService.getListMakerSako();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param IcecreamSearchForm icecreamSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchIcecream(@ModelAttribute final IcecreamSearchForm icecreamSearchForm) {
		return "icecreamSako/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param IcecreamSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchIcecream(final IcecreamSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<IcecreamMainSako> icecreamList = icecreamSakoService.getPageIcecream(form, pageable);
		if (icecreamList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", icecreamList);
			model.addAttribute("icecreamList", icecreamList.getContent());
			model.addAttribute("url", "search");
		}
		return "icecreamSako/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param IcecreamInputForm icecreamInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertIcecream(@ModelAttribute final IcecreamInputForm icecreamInputForm) {
		return "IcecreamSako/insert";
	}

	/**
	 * IcecreamMainSakoテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param IcecreamInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertIcecream(@ModelAttribute @Validated final IcecreamInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合次画面に戻る
			return "IcecreamSako/insert";
		}

		// データを登録する
		final IcecreamMainSako icecreamMainSako = icecreamSakoService.insertIcecream(form);
		return "redirect:/icecream?result=insert&id=" + icecreamMainSako.getId();
		}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param IcecreamInputForm icecreamInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateIcecream(@RequestParam(name = "id") final long id,
			@ModelAttribute final IcecreamInputForm icecreamInputForm) {

		// IDをキーにIcecreamMainSakoテーブルを検索する
		IcecreamMainSako icecreamMainSako = icecreamSakoService.getIcecream(id);

		// フォームにレコードの値をセットする
		icecreamInputForm.initWithIcecreamMain(icecreamMainSako);
		return "icecreamSako/update";
			}

	/**
	 * IcecreamMainSakoテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param IcecreamInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateIcecream(@Validated final IcecreamInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合次画面に戻る
			return "icecreamSako/update";
		}

		// データを更新する
		IcecreamMainSako icecreamMainSako = icecreamSakoService.updateIcecream(form);
		if (icecreamMainSako == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/icecream?result=updatefailed";
		}
		return "redirect:/icecream?result=update&id=" + icecreamMainSako.getId();
			}

	/**
	 * IcecreamMainSakoテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteIcecream(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		icecreamSakoService.deleteIcecreamById(id);
		return "redirect:/icecream?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param IcecreamSearchForm form
	 * @param IcecreamDeleteForm icecreamDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompIcecream(final IcecreamSearchForm form,
			@ModelAttribute final IcecreamDeleteForm icecreamDeleteForm, final Model model) {

		// IcecreamMainSakoテーブルから削除フラグが1のレコードを検索する
		final List<IcecreamMainSako> icecreamList = icecreamSakoService.getListIcecream(form);

		// Modelに検索結果を格納する
		model.addAttribute(icecreamList);
		return "icecreamSako/deletecomp";
			}

	/**
	 * IcecreamMainSakoテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param IcecreamDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompIcecream(@Validated final IcecreamDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			IcecreamSearchForm icecreamSearchForm = new IcecreamSearchForm();
			icecreamSearchForm.setIsDelete(1);
			final List<IcecreamMainSako> icecreamList = icecreamSakoService.getListIcecream(icecreamSearchForm);

			// Modelに検索結果を格納する
			model.addAllAttributes(icecreamList);
			return "icecreamSako/deletecomp";
		}

		// データを完全削除する
		icecreamSakoService.deleteIcecreamComp(form.getDeleteIds());
		return "redirect:/icecream?result=deletecomp";
			}
}
