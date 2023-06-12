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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.apexLegendsLegendTanamachi.ClassTanamachi;
import jp.co.futureantiques.webapptraining.model.apexLegendsLegendTanamachi.FromTanamachi;
import jp.co.futureantiques.webapptraining.model.apexLegendsLegendTanamachi.LegendMainTanamachi;
import jp.co.futureantiques.webapptraining.model.form.apexLegendsLegendTanamachi.LegendDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.apexLegendsLegendTanamachi.LegendInputForm;
import jp.co.futureantiques.webapptraining.model.form.apexLegendsLegendTanamachi.LegendRestorationForm;
import jp.co.futureantiques.webapptraining.model.form.apexLegendsLegendTanamachi.LegendSearchForm;
import jp.co.futureantiques.webapptraining.service.LegendTanamachiService;

/**
 * Legendのコントローラークラス
 *
 *@author future
 */
@Controller
@RequestMapping(value = "/legendTanamachi")
public class LegendTanamachiController {

	/** レジェンドのサービス */
	private final LegendTanamachiService legendTanamachiService;

	/**
	 * コンストラクタ
	 *
	 * @param LegendTanamachiService legendTanamachiService
	 */
	@Autowired
	public LegendTanamachiController(final LegendTanamachiService legendTanamachiService) {
		this.legendTanamachiService = legendTanamachiService;
	}

	/**
	 * 出身地エンティティのリストを取得する
	 *
	 * @return FromTanamachiEntityのリスト
	 */
	@ModelAttribute
	public List<FromTanamachi> getListFromTanamachi() {
		return legendTanamachiService.getListFromTanamachi();
	}

	/**
	 * クラスエンティティのリストを取得する
	 *
	 * @return ClassTanamachiEntityのリスト
	 */
	@ModelAttribute
	public List<ClassTanamachi> getListClassTanamachi() {
		return legendTanamachiService.getListClassTanamachi();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param LegendSearchForm form
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String searchLegend(@ModelAttribute final LegendSearchForm legendSearchForm, final Model model) {
		return "legendTanamachi/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param LegendSearchForm legendSerchForm
	 *
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchLegend(@Validated final LegendSearchForm form, BindingResult bindingResult,
			final Model model,
			final Pageable pageable) {

		//文字数
		if (bindingResult.hasFieldErrors()) {
			return "legendTanamachi/search";
		}

		//入力された内容をもとにレコードを取得する
		final Page<LegendMainTanamachi> legendList = legendTanamachiService.getPageLegend(form, pageable);
		if (legendList.getTotalElements() != 0) {

			//検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", legendList);
			model.addAttribute("legendList", legendList.getContent());
			model.addAttribute("url", "search");
		}
		return "legendTanamachi/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param LegendInputForm form
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insertLegend(@ModelAttribute LegendInputForm legendInputForm) {
		return "legendTanamachi/insert";
	}

	/**
	 * LegendMainTanamachiテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param LegendInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertMovie(@ModelAttribute @Validated final LegendInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "legendTanamachi/insert";
		}

		// データを登録する
		final LegendMainTanamachi legendMainTanamachi = legendTanamachiService.insertLegend(form);
		return "redirect:/legendTanamachi?result=insert&legendId=" + legendMainTanamachi.getId();
	}

	/**
	 *  更新画面に遷移する
	 *
	 * @param long legendId
	 * @param LegendInputForm legendInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateLegend(@RequestParam(name = "id") final long legendId,
			@ModelAttribute final LegendInputForm legendInputForm) {

		// IDをキーにLegendMainTanamachiテーブルを検索する
		LegendMainTanamachi legendMainTanamachi = legendTanamachiService.getLegend(legendId);

		// フォームにレコードの値をセットする
		legendInputForm.initWithLegendMainTanamachi(legendMainTanamachi);
		return "legendTanamachi/update";
	}

	/**
	 * LegendMainTanamachiテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param LegendInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateLegend(@Validated final LegendInputForm form, final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合自画面に戻る
			return "legendTanamachi/update";
		}

		//データを更新する
		LegendMainTanamachi legendMainTanamachi = legendTanamachiService.updateLegend(form);
		if (legendMainTanamachi == null) {

			//更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/legendTanamachi?result=updatefailed";
		}
		return "redirect:/legendTanamachi?result=update&legendId=" + legendMainTanamachi.getId();
	}

	/**
	 * legendMainTanamachiテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long legendId
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteLegend(@RequestParam(name = "id") final long id) {

		//IDをキーにレコードを論理削除する
		legendTanamachiService.deleteLegendById(id);
		return "redirect:/legendTanamachi?result=delete&legendId=" + id;
	}

	/**
	 * 復元画面に遷移する
	 *
	 * @param LegendSearchForm legendSearchForm
	 * @param LegendRestorationForm legendRestrationForm
	 * @param Model model
	 * @return 復元画面のパス
	 */
	@RequestMapping(value = "restoration", method = RequestMethod.GET)
	public String showRestorationLegend(final LegendSearchForm form,
			@ModelAttribute final LegendRestorationForm legendRestorationForm, final Model model) {

		//LegendMainTanamachiテーブルから削除フラグが１のレコードを検索する
		final List<LegendMainTanamachi> legendList = legendTanamachiService.getListLegend(form);

		//Modelに検索結果を格納する
		model.addAttribute(legendList);
		return "legendTanamachi/restoration";
	}

	/**
	 *LegendMainTanamachiテーブルのレコードの削除フラグを0に更新して検索画面に遷移する
	 *
	 *@param LegendRestorationForm legendRestorationForm
	 *@param BindingResult bindingResult
	 *@param Model model
	 *@param RedirectAttributes redirectAttributes
	 *@return 入力エラーがある場合復元画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "restoration", method = RequestMethod.POST)
	public String restorationLegend(@Validated LegendRestorationForm form, final BindingResult bindingResult,
			final Model model, final RedirectAttributes redirectAttributes) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			LegendSearchForm legendSearchForm = new LegendSearchForm();
			legendSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<LegendMainTanamachi> legendList = legendTanamachiService.getListLegend(legendSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(legendList);
			return "legendTanamachi/restoration";
		}

		// IDをキーにレコードの削除フラグを0に更新する
		List<Long> failedIds = legendTanamachiService.restoreLegend(form.getDeleteIds());

		//復元成功時、失敗時
		if (failedIds.isEmpty()) {

			//検索画面に遷移し、復元完了メッセージ
			return "redirect:/legendTanamachi?result=restoration";
		} else {

			//フラッシュスコープにidリストを格納し、検索画面に遷移しリダイレクト
			redirectAttributes.addFlashAttribute("failedIds", failedIds);
			return "redirect:/legendTanamachi?result=restorationfailed";
		}
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 *  @param LegendSearchForm legendSearchForm
	 *  @param LegendDeleteForm legendDeleteForm
	 *  @param Model model
	 *  @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompLegend(final LegendSearchForm form,
			@ModelAttribute final LegendDeleteForm legendDeleteForm, final Model model) {

		//LegendMainTanamachiテーブルから削除フラグが１のレコードを検索する
		final List<LegendMainTanamachi> legendList = legendTanamachiService.getListLegend(form);

		//Modelに検索結果を格納する
		model.addAttribute(legendList);

		return "legendTanamachi/deletecomp";
	}

	/**
	 * LegendMainTanamachiテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param LegendDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompLegend(@Validated final LegendDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			LegendSearchForm legendSearchForm = new LegendSearchForm();
			legendSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<LegendMainTanamachi> legendList = legendTanamachiService.getListLegend(legendSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(legendList);
			return "legendTanamachi/deletecomp";
		}

		// データを完全削除する
		boolean found = legendTanamachiService.deleteLegendComp(form.getDeleteIds());

		//物理削除成功or失敗
		if (found) {

			//物理削除成功時
			return "redirect:/legendTanamachi?result=deletecomp";
		} else {

			//物理削除失敗時
			return "redirect:/legendTanamachi?result=deletecompfailed";
		}

	}
}
