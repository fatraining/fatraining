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
import jp.co.futureantiques.webapptraining.model.drinkOhkubo.ContainerOhkubo;
import jp.co.futureantiques.webapptraining.model.drinkOhkubo.DrinkMainOhkubo;
import jp.co.futureantiques.webapptraining.model.drinkOhkubo.MakerOhkubo;
import jp.co.futureantiques.webapptraining.model.drinkOhkubo.TypeOhkubo;
import jp.co.futureantiques.webapptraining.model.form.drinkOhkubo.DrinkOhkuboDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.drinkOhkubo.DrinkOhkuboInputForm;
import jp.co.futureantiques.webapptraining.model.form.drinkOhkubo.DrinkOhkuboSearchForm;
import jp.co.futureantiques.webapptraining.service.DrinkOhkuboService;

/**
 * Drinkのコントローラークラス
 *
 * @author future
 */

@Controller
@RequestMapping(value="/drinkohkubo")
public class DrinkOhkuboController {
	//飲み物のサービス
	private final DrinkOhkuboService drinkService;

	/**
	 * コンストラクタ
	 *
	 * @param DrinkOhkuboService drinkService
	 */

	@Autowired
	public DrinkOhkuboController(final DrinkOhkuboService drinkService) {
		this.drinkService = drinkService;
	}

	/**
	 * メーカーエンティティのリストを取得する
	 *
	 * @return MakerEntityのリスト
	 */
	@ModelAttribute
	public List<MakerOhkubo> getListMaker() {
		return drinkService.getListMaker();
	}

	/**
	 * 種類エンティティのリストを取得する
	 *
	 * @return TypeEntityのリスト
	 */
	@ModelAttribute
	public List<TypeOhkubo> getListType() {
		return drinkService.getListType();
	}

	/**
	 * 容器エンティティのリストを取得する
	 *
	 * @return ContainerEntityのリスト
	 */
	@ModelAttribute
	public List<ContainerOhkubo> getListContainer() {
		return drinkService.getListContainer();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param DrinkOhkuboSearchForm drinkOhkuboSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchDrink(@ModelAttribute final DrinkOhkuboSearchForm drinkSearchOhkuboForm) {
		return "drinkohkubo/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param DrinkOhkuboSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */

	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchDrink(final DrinkOhkuboSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<DrinkMainOhkubo> drinkList = drinkService.getPageDrink(form, pageable);
		if (drinkList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", drinkList);
			model.addAttribute("drinkList", drinkList.getContent());
			model.addAttribute("url", "search");
		}
		return "drinkohkubo/search";
	}
	/**
	 * 追加画面に遷移する
	 *
	 * @param DrinkOhkuboInputForm drinkOhkuboInputForm
	 * @return 追加画面のパス
	 */

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertDrink(@ModelAttribute final DrinkOhkuboInputForm drinkOhkuboInputForm) {
		return "drinkohkubo/insert";
	}

	/**
	 * DrinkMainOhkuboテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param DrinkOhkuboInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertDrink(@ModelAttribute @Validated final DrinkOhkuboInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "drinkohkubo/insert";
		}

		// データを登録する
		final DrinkMainOhkubo drinkMainOhkubo = drinkService.insertDrink(form);
		return "redirect:/drinkohkubo?result=insert&id=" + drinkMainOhkubo.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param DrinkOhkuboInputForm drinkOhkuboInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateDrink(@RequestParam(name = "id") final long id,
			@ModelAttribute final DrinkOhkuboInputForm drinkOhkuboInputForm) {

		// IDをキーにDrinkMainOhkuboテーブルを検索する
		DrinkMainOhkubo drinkMainOhkubo=drinkService.getDrink(id);

		// フォームにレコードの値をセットする
		drinkOhkuboInputForm.initWithDrinkMainOhkubo(drinkMainOhkubo);
		return "drinkohkubo/update";
	}

	/**
	 * DrinkMainOhkuboテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param DrinkOhkuboInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateDrink(@Validated final DrinkOhkuboInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "drinkohkubo/update";
		}

		// データを更新する
		DrinkMainOhkubo drinkMainOhkubo = drinkService.updateDrink(form);
		if (drinkMainOhkubo == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/drinkohkubo?result=updatefailed";
		}
		return "redirect:/drinkohkubo?result=update&id=" + drinkMainOhkubo.getId();
	}

	/**
	 * DrinkMainOhkuboテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteDrink(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		drinkService.deleteDrinkById(id);
		return "redirect:/drinkohkubo?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param DrinkOhkuboSearchForm form
	 * @param DrinkOhkuboDeleteForm drinkOhkuboDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompDrink(final DrinkOhkuboSearchForm form,
			@ModelAttribute final DrinkOhkuboDeleteForm drinkOhkuboDeleteForm, final Model model) {

		// DrinkMainOhkuboテーブルから削除フラグが1のレコードを検索する
		final List<DrinkMainOhkubo> drinkList = drinkService.getListDrink(form);

		// Modelに検索結果を格納する
		model.addAttribute(drinkList);
		return "drinkohkubo/deletecomp";
	}

	/**
	 * DrinkMainOhkuboテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param DrinkOhkuboDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompDrink(@Validated final DrinkOhkuboDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			DrinkOhkuboSearchForm drinkOhkuboSearchForm = new DrinkOhkuboSearchForm();
			drinkOhkuboSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<DrinkMainOhkubo> drinkMainOhkuboList = drinkService.getListDrink(drinkOhkuboSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(drinkMainOhkuboList);
			return "drinkohkubo/deletecomp";
		}

		// データを完全削除する
		drinkService.deleteDrinkComp(form.getDeleteIds());
		return "redirect:/drinkohkubo?result=deletecomp";
	}
}
