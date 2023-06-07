package jp.co.futureantiques.webapptraining.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.form.monsterShirase.MonsterShiraseDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.monsterShirase.MonsterShiraseInputForm;
import jp.co.futureantiques.webapptraining.model.form.monsterShirase.MonsterShiraseSearchForm;
import jp.co.futureantiques.webapptraining.model.monsterShirase.ElementShirase;
import jp.co.futureantiques.webapptraining.model.monsterShirase.GenreShirase;
import jp.co.futureantiques.webapptraining.model.monsterShirase.MonsterMainShirase;
import jp.co.futureantiques.webapptraining.model.monsterShirase.TitleShirase;
import jp.co.futureantiques.webapptraining.service.MonsterShiraseService;

/**
* MonsterShiraseのコントローラークラス
*
* @author Shirase
*/
@Controller
@RequestMapping(value = "/monsterShirase")
public class MonsterShiraseController {

	/** モンスターのサービス**/
	private final MonsterShiraseService monsterShiraseService;

	/**
	 * コンストラクタ
	 * @param MonsterShiraseService monsterShiraseService
	 */
	@Autowired
	public MonsterShiraseController(final MonsterShiraseService monsterShiraseService) {
		this.monsterShiraseService = monsterShiraseService;
	}

	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return GenreShiraseのリスト
	 */
	@ModelAttribute
	public List<GenreShirase> getListGenreShirase() {
		return monsterShiraseService.getListGenreShirase();
	}

	/**
	 * 弱点属性エンティティのリストを取得する
	 *
	 * @return ElementShiraseのリスト
	 */
	@ModelAttribute
	public List<ElementShirase> getListElementShirase() {
		return monsterShiraseService.getListElementShirase();
	}

	/**
	 * 初登場作品エンティティのリストを取得する
	 *
	 * @return TitleShiraseのリスト
	 */
	@ModelAttribute
	public List<TitleShirase> getListTitleShirase() {
		return monsterShiraseService.getListTitleShirase();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param MonsterShiraseSearchForm monsterSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchMonster(@ModelAttribute final MonsterShiraseSearchForm monsterShiraseSearchForm) {
		return "monsterShirase/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param MonsterShiraseSearchFrom monsterShiraseSearchForm
	 * @param Model model
	 * @param Pageable Pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchMonster(final MonsterShiraseSearchForm monsterShiraseSearchForm, final Model model,
			final @PageableDefault(page = 0, value = 10) Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<MonsterMainShirase> monsterList = monsterShiraseService.getPageMonsterShirase(monsterShiraseSearchForm, pageable);
		if (monsterList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", monsterList);
			model.addAttribute("monsterList", monsterList.getContent());
			model.addAttribute("url", "search");
		}
		return "monsterShirase/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param MonsterShiraseInputForm monsterShiraseInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertMonster(@ModelAttribute final MonsterShiraseInputForm monsterShiraseInputForm) {
		return "monsterShirase/insert";
	}

	/**
	 * MonsterMainShiraseテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param MonsterInputForm monsterShiraseInputForm
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合は追加画面のパス、ない場合は検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertMonster(@ModelAttribute @Validated
			final MonsterShiraseInputForm monsterShiraseInputForm, final BindingResult bindingResult) {

		// 入力エラーがある場合自画面に戻る
		if (bindingResult.hasFieldErrors()) {
			return "monsterShirase/insert";
		}

		// データを登録する
		final MonsterMainShirase monsterMainShirase = monsterShiraseService.insertMonster(monsterShiraseInputForm);
		return "redirect:/monsterShirase?result=insert&id=" + monsterMainShirase.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param MonsterShiraseInputForm monsterShiraseInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateMonster(@RequestParam(name = "id") final long id,
			@ModelAttribute final MonsterShiraseInputForm monsterShiraseInputForm) {

		// IDをキーにMonsterMainテーブルを検索
		MonsterMainShirase monsterMainShirase = monsterShiraseService.getMonster(id);

		// フォームにレコードの値をセットする
		monsterShiraseInputForm.initWithMonsterMainShirase(monsterMainShirase);
		return "monsterShirase/update";
	}

	/**
	 * MonsterMainShiraseテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param MonsterShiraseInputForm monsterShiraseInputForm
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合	は更新画面、ない場合は検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateMonsterShirase(@Validated
			final MonsterShiraseInputForm monsterShiraseInputForm, final BindingResult bindingResult) {

		// 入力エラーがある場合自画面に遷移
		if (bindingResult.hasErrors()) {
			return "monsterShirase/update";
		}

		// データを更新する
		MonsterMainShirase monsterMainShirase = monsterShiraseService.updateMonster(monsterShiraseInputForm);

		// 更新失敗の場合、検索画面にてメッセージ表示
		if (monsterMainShirase == null) {
			return "redirect:/monsterShirase?result=updatefailed";
		}
		return "redirect:/monsterShirase?result=update&id=" + monsterMainShirase.getId();
	}

	/**
	 * MonsterMainShiraseテーブルのレコードを論理削除し検索画面に遷移
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteMonster(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		monsterShiraseService.deleteMonsterById(id);
		return "redirect:/monsterShirase?result=delete&id=" + id;
	}

	/**
	 * 物理削除画面に遷移
	 *
	 * @param MonsterShiraseSearchForm monsterShiraseSearchForm
	 * @param MonsterShiraseDeleteForm monsterShiraseDeleteForm
	 * @param Model model
	 * @return 物理削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompMonster(final MonsterShiraseSearchForm monsterShiraseSearchForm,
			@ModelAttribute final MonsterShiraseDeleteForm monsterShiraseDeleteForm, final Model model) {

		// MonsterMainShiraseテーブルから削除フラグが1のレコードを検索する
		final List<MonsterMainShirase> monsterList = monsterShiraseService.getListMonsterShirase(monsterShiraseSearchForm);

		// Modelに検索結果を格納
		model.addAttribute(monsterList);
		return "monsterShirase/deletecomp";
	}

	/**
	 * MonsterMainShiraseテーブルのデータを物理削除して検索画面に遷移
	 *
	 * @param MonsterShiraseDeleteForm monsterShiraseDeleteForm
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合には物理削除画面、ない場合には検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompMonster(@Validated final MonsterShiraseDeleteForm monsterShiraseDeleteForm,
			final BindingResult bindingResult, final Model model) {

		// 入力値エラーの場合、再検索して自画面に戻る
		if (bindingResult.hasErrors()) {
			MonsterShiraseSearchForm monsterShiraseSearchForm = new MonsterShiraseSearchForm();
			monsterShiraseSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<MonsterMainShirase> monsterList = monsterShiraseService.getListMonsterShirase(monsterShiraseSearchForm);

			// Modelに検索結果を格納
			model.addAttribute(monsterList);
			return "monsterShirase/deletecomp";
		}

		// データを物理削除する
		monsterShiraseService.deleteMonsterComp(monsterShiraseDeleteForm.getDeleteIds());
		return "redirect:/monsterShirase?result=deletecomp";
	}

}
