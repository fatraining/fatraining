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
import jp.co.futureantiques.webapptraining.model.form.egg.eggDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.egg.eggInputForm;
import jp.co.futureantiques.webapptraining.model.form.egg.eggSearchForm;
import jp.co.futureantiques.webapptraining.model.egg.Genre;
import jp.co.futureantiques.webapptraining.model.egg.eggActor;
import jp.co.futureantiques.webapptraining.model.egg.eggMain;
import jp.co.futureantiques.webapptraining.service.eggService;

/**
 * eggのコントローラークラス
 *
 * @author future
 */
@Controller
@RequestMapping(value = "/eggsekine")
public class EggSekineController {

	/** たまご料理のサービス */
	private final EggSekineService eggService;

	/**
	 * コンストラクタ
	 *
	 * @param eggService eggSampleService
	 */
	@Autowired
	public EggSekineController(final EggSekineService eggsekineService) {
		this.eggsekineService = eggsekineService;
	}

	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return GenreEntityのリスト
	 */
	@ModelAttribute
	public List<Genre> getListGenre() {
		return eggService.getListGenre();
	}

	/**
	 * 調理法エンティティのリストを取得する
	 *
	 * @return cookEntityのリスト
	 */
	@ModelAttribute
	public List<Cook> getListCook() {
		return EggSekineService.getListCook();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param eggSearchForm eggSampleSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchegg(@ModelAttribute final EggSekineSearchFormeggSekineSearchForm) {
		return "egg/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param eggSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchegg(final EggSekineSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<eggMain> eggList = eggSekineService.getPageegg(form, pageable);
		if (eggList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", eggList);
			model.addAttribute("eggList", eggList.getContent());
			model.addAttribute("url", "search");
		}
		return "eggsekine/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param EggSekineInputForm eggSekineInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertegg(@ModelAttribute final EggSekineInputForm eggSekineInputForm) {
		return "egg/insert";
	}

	/**
	 * eggMainテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param eggInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertegg(@ModelAttribute @Validated final EggSekineInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "eggsekine/insert";
		}

		// データを登録する
		final eggMain eggMain = eggSekineService.insertegg(form);
		return "redirect:/eggsample?result=insert&id=" + eggMain.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param eggSampleInputForm eggSampleInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateegg(@RequestParam(name = "id") final long id,
			@ModelAttribute final EggSekineInputForm eggInputForm) {

		// IDをキーにeggMainテーブルを検索する
		eggMain eggMain = eggSekineService.getegg(id);

		// フォームにレコードの値をセットする
		eggInputForm.initWitheggMain(eggMain);
		return "eggsekine/update";
	}

	/**
	 * eggMainテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param eggInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateegg(@Validated final EggSekineInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "eggsekine/update";
		}

		// データを更新する
		eggMain eggMain = eggsekineService.updateegg(form);
		if (eggMain == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/eggsekine?result=updatefailed";
		}
		return "redirect:/eggsekine?result=update&id=" + eggMain.getId();
	}

	/**
	 * eggMainテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteegg(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		eggSekineService.deleteeggById(id);
		return "redirect:/eggsekine?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param eggSearchForm form
	 * @param eggDeleteForm eggDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompegg(final eggSearchForm form,
			@ModelAttribute final eggDeleteForm eggDeleteForm, final Model model) {

		// eggMainテーブルから削除フラグが1のレコードを検索する
		final List<eggMain> eggList = eggSekineService.getListegg(form);

		// Modelに検索結果を格納する
		model.addAttribute(eggList);
		return "eggSekine/deletecomp";
	}

	/**
	 * eggMainテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param eggDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompegg(@Validated final EggSekineDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			EggSekineSearchForm eggSekineSearchForm = new EggSekineSearchForm();
			eggSekineSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<eggMain> eggList = eggSekineService.getListegg(eggSekineSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(eggList);
			return "eggSekine/deletecomp";
		}

		// データを完全削除する
		eggSekineService.deleteeggComp(form.getDeleteIds());
		return "redirect:/eggSekine?result=deletecomp";
	}
}


