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
import jp.co.futureantiques.webapptraining.model.GuiterFujimoto.CompanyFujimoto;
import jp.co.futureantiques.webapptraining.model.GuiterFujimoto.GuiterMainFujimoto;
import jp.co.futureantiques.webapptraining.model.GuiterFujimoto.WoodFujimoto;
import jp.co.futureantiques.webapptraining.model.form.guiterFujimoto.GuiterDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.guiterFujimoto.GuiterInputForm;
import jp.co.futureantiques.webapptraining.model.form.guiterFujimoto.GuiterSearchForm;
import jp.co.futureantiques.webapptraining.service.GuiterFujimotoService;

/**
 * guiter_main_fujimotoのコントローラークラス
 *
 * @author FUJIMOTO YOSHIHISA
 */
@Controller
@RequestMapping(value = "/guiterfujimoto")
public class GuiterFujimotoController {

	/**名前のサービス
	*/
	private final GuiterFujimotoService guiterFujimotoService;

	/**コンストラクタ
	*
	*@param GuiterFujimotoService guiterFujimotoService
	*/
	@Autowired
	public GuiterFujimotoController(final GuiterFujimotoService guiterFujimotoService) {
		this.guiterFujimotoService = guiterFujimotoService;
	}

	/**
	 * 会社エンティティのリストを取得する
	 *
	 * @return CompanyEntityのリスト
	 */
	@ModelAttribute
	public List<CompanyFujimoto> getListCompanyFujimoto() {
		return guiterFujimotoService.getListCompanyFujimoto();
	}

	/**
	 * 木材エンティティのリストを取得する
	 *
	 * @return WoodEntityのリスト
	 */
	@ModelAttribute
	public List<WoodFujimoto> getLIstWoodFujimoto() {
		return guiterFujimotoService.getListWoodFujimoto();
	}

	/**
	 * 検索画面に遷移する
	 * @param GuiterSearchForm guiterSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchGuiter(@ModelAttribute final GuiterSearchForm guiterSearchForm) {
		return "guiterfujimoto/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 * @param GuiterSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchGuiter(
			final GuiterSearchForm form, final Model model, final Pageable pageable) {

		//入力された検索条件を基にレコードを取得する
		final Page<GuiterMainFujimoto> guiterList = guiterFujimotoService.getPageGuiter(form, pageable);
		if (guiterList.getTotalElements() != 0) {

			//検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", guiterList);
			model.addAttribute("guiterList", guiterList.getContent());
			model.addAttribute("url", "search");
		}
		return "guiterfujimoto/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param GuiterInputForm GuiterInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertGuiter(@ModelAttribute final GuiterInputForm GuiterInputForm) {
		return "guiterfujimoto/insert";
	}

	/**
	 * Guiter_Main_Fujimotoテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param GuiterInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertGuiter(@ModelAttribute @Validated final GuiterInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "guiterfujimoto/insert";
		}

		// データを登録する
		final GuiterMainFujimoto guiterMainFujimoto = guiterFujimotoService.insertGuiter(form);
		return "redirect:/guiterfujimoto?result=insert&id=" + guiterMainFujimoto.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param GuiterInputForm GuiterFujimotoInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateGuiter(@RequestParam(name = "id") final long id,
			@ModelAttribute final GuiterInputForm guiterInputForm) {

		// IDをキーにMovieMainテーブルを検索する
		GuiterMainFujimoto guiterMainFujimoto = guiterFujimotoService.getGuiter(id);

		// フォームにレコードの値をセットする
		guiterInputForm.initWithGuiterMainFujimoto(guiterMainFujimoto);
		return "guiterfujimoto/update";
	}

	/**
	 * GuiterMainFujimotoテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param GuiterInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateGuiter(@Validated final GuiterInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "guiterfujimoto/update";
		}

		// データを更新する
		GuiterMainFujimoto guiterMainFujimoto = guiterFujimotoService.updateGuiter(form);
		if (guiterMainFujimoto == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/guiterfujimoto?result=updatefailed";
		}
		return "redirect:/guiterfujimoto?result=update&id=" + guiterMainFujimoto.getId();
	}

	/**
	 * GuiterMainテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteGuiter(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		guiterFujimotoService.deleteGuiterById(id);
		return "redirect:/guiterfujimoto?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param GuiterSearchForm form
	 * @param GuiterDeleteForm guiterDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompGuiter(final GuiterSearchForm form,
			@ModelAttribute final GuiterDeleteForm guiterDeleteForm, final Model model) {

		// GuiterMainテーブルから削除フラグが1のレコードを検索する
		final List<GuiterMainFujimoto> guiterList = guiterFujimotoService.getListGuiter(form);

		// Modelに検索結果を格納する
		model.addAttribute(guiterList);
		return "guiterfujimoto/deletecomp";
	}

	/**
	 * GuiterMainテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param GuiterDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompGuiter(@Validated final GuiterDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			GuiterSearchForm guiterSearchForm = new GuiterSearchForm();
			guiterSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<GuiterMainFujimoto> guiterMainFujimotolist = guiterFujimotoService.getListGuiter(guiterSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(guiterMainFujimotolist);
			return "guiterfujimoto/deletecomp";
		}

		// データを完全削除する
		guiterFujimotoService.deleteGuiterComp(form.getDeleteIds());
		return "redirect:/guiterfujimoto?result=deletecomp";
	}
}


