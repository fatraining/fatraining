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

import jp.co.futureantiques.webapptraining.model.flowerNakai.ColorNakai;
import jp.co.futureantiques.webapptraining.model.flowerNakai.FlowerMainNakai;
import jp.co.futureantiques.webapptraining.model.flowerNakai.MonthNakai;
import jp.co.futureantiques.webapptraining.model.form.flowerNakai.FlowerDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.flowerNakai.FlowerInputForm;
import jp.co.futureantiques.webapptraining.model.form.flowerNakai.FlowerSearchForm;
import jp.co.futureantiques.webapptraining.service.FlowerNakaiService;

/**
 * FlowerNakaiコントローラークラス
 * @author Rieko Nakai
 *
 */
@Controller
@RequestMapping(value = "/flower")
public class FlowerNakaiController {

	/* FlowerNakaiサービスクラス */
	private final FlowerNakaiService flowerNakaiService;

	/**
	 * コンストラクタ
	 * @param FlowerNakaiService flowerNakaiService
	 */

	@Autowired
	public FlowerNakaiController(final FlowerNakaiService flowerNakaiService) {
		this.flowerNakaiService = flowerNakaiService;
	}

	/**
	 * MonthNakaiエンティティのリストを取得する
	 * @return MonthNakaiエンティティのリスト
	 */
	@ModelAttribute
	public List<MonthNakai> getListMonthNakai(){
		return flowerNakaiService.getListMonthNakai();
	}

	/**
	 * ColorNakaiエンティティのリストを取得する
	 * @return ColorNakaiエンティティのリスト
	 */
	@ModelAttribute
	public List<ColorNakai> getListColorNakai(){
		return flowerNakaiService.getListColorNakai();
	}

	/**
	 * 検索画面に遷移する
	 * @param FlowerSearchForm form
	 * @return 検索画面のパス
	 */
	@RequestMapping(value="", method = RequestMethod.GET)
	public String showSearchFlower(@ModelAttribute final FlowerSearchForm flowerSearchForm) {
		return "flowernakai/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param FlowerSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 */
	@RequestMapping(value="search", method = RequestMethod.POST)
	public String searchFlower(
			final FlowerSearchForm form, final Model model, final Pageable pageable
			) {
		//入力された検索条件を基にレコードを取得する
		final Page<FlowerMainNakai> flowerList = flowerNakaiService.getPageFlower(form, pageable);
		if(flowerList.getTotalElements() != 0) {

			//検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", flowerList);
			model.addAttribute("flowerList", flowerList.getContent());
			model.addAttribute("url", "search");
		}
		return "flowernakai/search";
	}

	/**
	 * 追加画面に遷移する
	 * @param FlowerInputForm flowerInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value="insert", method = RequestMethod.GET)
	public String showInsertFlower(@ModelAttribute final FlowerInputForm flowerInputForm) {
		return "flowernakai/insert";
	}

	/**
	 * flower_main_nakaiテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param FlowerInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面のパス、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert",method = RequestMethod.POST)
	public String insertFlower(
			@ModelAttribute @Validated final FlowerInputForm form,
			final BindingResult bindingResult
		) {
		if(bindingResult.hasErrors()) {

			//入力エラーがある場合、戻る
			return "flowernakai/insert";
		}

		//データを登録する
		final FlowerMainNakai flowerMainNakai = flowerNakaiService.insertFlower(form);
		return "redirect:/flower?result=insert&id=" + flowerMainNakai.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param FlowerInputForm flowerInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateFlower(
			@RequestParam(name = "id") final long id,
			@ModelAttribute final FlowerInputForm flowerInputForm
		) {

		//IDをキーにflower_main_nakaiテーブルを検索する
		FlowerMainNakai flowerMainNakai = flowerNakaiService.getFlower(id);

		//フォームにレコードの値をセットする
		flowerInputForm.initWithFlowerMainNakai(flowerMainNakai);
		return "flowernakai/update";
	}

	/**
	 * flower_main_nakaiテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param FlowerInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合、更新画面のパス、ない場合検索画面のパス
	 */

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateFlower(
			@Validated final FlowerInputForm form,
			final BindingResult bindingResult
		){

		//入力エラーがある場合、自画面に戻る
		if(bindingResult.hasErrors()) {
			return "flowernakai/update";
		}

		//データを更新する
		FlowerMainNakai flowerMainNakai = flowerNakaiService.updateFlower(form);
		if(flowerMainNakai == null) {

			//更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/flower?result=updatefailed";
		}
		return "redirect:/flower?result=update&id=" +flowerMainNakai.getId();
	}

	/**
	 * flower_main_nakaiテーブルのデータを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteFlower(@RequestParam(name = "id")final long id) {

		//IDをキーにレコードを論理削除する
		flowerNakaiService.deleteFlowerById(id);
		return "redirect:/flower?result=delete&id=" +id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param FlowerSearchForm form
	 * @param FlowerDeleteForm flowerDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompFlower(
			final FlowerSearchForm form,
			@ModelAttribute FlowerDeleteForm flowerDeleteForm, Model model
		) {

		//flower_main_tableから削除フラグが1のデータを検索する
		final List<FlowerMainNakai> flowerList = flowerNakaiService.getListFlower(form);

		//modelに検索結果を格納する
		model.addAttribute(flowerList);
		return "flowernakai/deletecomp";
	}

	/**
	 * flower_main_tableのデータを完全削除して検索画面に遷移する
	 *
	 * @param FlowerDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合、完全削除画面、ない場合検索画面のパス
	 */

	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompFlower(
			@Validated final FlowerDeleteForm form,
			final BindingResult bindingResult,
			final Model model
			) {
		if(bindingResult.hasFieldErrors()) {

			//入力エラーがある場合、再検索して自画面に戻る
			FlowerSearchForm flowerSearchForm = new FlowerSearchForm();
			flowerSearchForm.setIsDelete(1);
			final List<FlowerMainNakai> flowerList = flowerNakaiService.getListFlower(flowerSearchForm);

			//modelに検索結果を格納する
			model.addAttribute(flowerList);
			return "flowernakai/deletecomp";
		}

		//データを完全削除する
		flowerNakaiService.deleteFlowerComp(form.getDeleteIds());
		return "redirect:/flower?result=deletecomp";
	}

}
