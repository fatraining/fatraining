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

import jp.co.futureantiques.webapptraining.model.form.machoizawa.MuscleDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.machoizawa.MuscleInputForm;
import jp.co.futureantiques.webapptraining.model.form.machoizawa.MuscleSearchForm;
import jp.co.futureantiques.webapptraining.model.machoizawa.BodyIzawa;
import jp.co.futureantiques.webapptraining.model.machoizawa.MuscleIzawa;
import jp.co.futureantiques.webapptraining.service.MachoIzawaService;

/**
 * MovieSampleのコントローラークラス
 *
 * @author future
 */
@Controller
@RequestMapping(value = "/machoman")
public class MachoIzawaController {

	/** 筋トレのサービス */
	private final MachoIzawaService machoIzawaService;

	/**
	 * コンストラクタ
	 *
	 * @param MovieSampleService movieSampleService
	 */
	@Autowired
	public MachoIzawaController(final MachoIzawaService machoIzawaService) {
		this.machoIzawaService = machoIzawaService;
	}

	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return GenreEntityのリスト
	 */
	@ModelAttribute
	public List<BodyIzawa> getListBody() {
		return machoIzawaService.getListBody();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param MovieSampleSearchForm movieSampleSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchMuscle(@ModelAttribute final MuscleSearchForm muscleSearchForm) {
		return "machoizawa/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param MovieSampleSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchMuscle(final MuscleSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<MuscleIzawa> muscleList = machoIzawaService.getPageMuscle(form, pageable);
		if (muscleList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", muscleList);
			model.addAttribute("muscleList", muscleList.getContent());
			model.addAttribute("url", "search");
		}
		return "machoizawa/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param MovieSampleInputForm movieSampleInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertMuscle(@ModelAttribute final MuscleInputForm muscleInputForm) {
		return "machoizawa/insert";
	}

	/**
	 * MovieMainテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param MovieSampleInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertMuscle(@ModelAttribute @Validated final MuscleInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "machoizawa/insert";
		}

		// データを登録する
		final MuscleIzawa muscleIzawa = machoIzawaService.insertMuscle(form);
		return "redirect:/machoman?result=insert&id=" + muscleIzawa.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param MovieSampleInputForm movieSampleInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateMuscle(@RequestParam(name = "id") final long id,
			@ModelAttribute final MuscleInputForm muscleInputForm) {

		// IDをキーにMovieMainテーブルを検索する
		MuscleIzawa muscleIzawa = machoIzawaService.getMuscle(id);

		// フォームにレコードの値をセットする
		muscleInputForm.initWithMuscleIzawa(muscleIzawa);
		return "machoizawa/update";
	}

	/**
	 * MovieMainテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param MovieSampleInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateMuscle(@Validated final MuscleInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "machoizawa/update";
		}

		// データを更新する
		MuscleIzawa muscleIzawa = machoIzawaService.updateMuscle(form);
		if (muscleIzawa == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/machoizawa?result=updatefailed";
		}
		return "redirect:/machoman?result=update&id=" + muscleIzawa.getId();
	}

	/**
	 * MovieMainテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteMuscle(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		machoIzawaService.deleteMuscleById(id);
		return "redirect:/machoman?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param MovieSampleSearchForm form
	 * @param MovieSampleDeleteForm movieSampleDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompMuscle(final MuscleSearchForm form,
			@ModelAttribute final MuscleDeleteForm muscleDeleteForm, final Model model) {

		// MovieMainテーブルから削除フラグが1のレコードを検索する
		final List<MuscleIzawa> muscleList = machoIzawaService.getListMuscle(form);

		// Modelに検索結果を格納する
		model.addAttribute(muscleList);
		return "machoizawa/deletecomp";
	}

	/**
	 * MovieMainテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param MovieSampleDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompMuscle(@Validated final MuscleDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			MuscleSearchForm muscleSearchForm = new MuscleSearchForm();
			muscleSearchForm.setIsDelete(1);
			final List<MuscleIzawa> muscleList = machoIzawaService.getListMuscle(muscleSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(muscleList);
			return "machoizawa/deletecomp";
		}

		// データを完全削除する
		machoIzawaService.deleteMuscleComp(form.getDeleteIds());
		return "redirect:/machoman?result=deletecomp";

	}
}
