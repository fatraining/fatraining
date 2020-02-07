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
import jp.co.futureantiques.webapptraining.model.form.riderSaito.RiderSaitoDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.riderSaito.RiderSaitoInputForm;
import jp.co.futureantiques.webapptraining.model.form.riderSaito.RiderSaitoSearchForm;
import jp.co.futureantiques.webapptraining.model.riderSaito.AgeSaito;
import jp.co.futureantiques.webapptraining.model.riderSaito.RiderMainSaito;
import jp.co.futureantiques.webapptraining.service.RiderSaitoService;

/**
 * RiderSaitoのコントローラークラス
 * @author future
 *
 */

@Controller
@RequestMapping(value = "/ridersaito")
public class RiderSaitoController {

	/** 仮面ライダーのサービス */
	private final RiderSaitoService riderSaitoService;

	/**
	 * コンストラクタ
	 * @param RiderSaitoService riderSaitoService
	 * */
	@Autowired
	public RiderSaitoController(final RiderSaitoService riderSaitoService) {
		this.riderSaitoService = riderSaitoService;
	}

	/** 年代のエンティティのリストを取得する。
	 *
	 *@param AgeEntityのリスト
	 * */
	@ModelAttribute
	public List<AgeSaito> getListAge() {
		return riderSaitoService.getListAge();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param RiderSaitoSearchForm RiderSaitoSearchForm
	 * @return 検索画面のパス
	 */

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchRider(@ModelAttribute final RiderSaitoSearchForm riderSaitoSearchForm) {
		return "ridersaito/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @oaram RiderSaitoSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */

	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchRider(final RiderSaitoSearchForm form, final Model model, final Pageable pageable) {

		//入力された検索条件を元にレコードを取得
		final Page<RiderMainSaito> riderList = riderSaitoService.getPageRider(form, pageable);
		if (riderList.getTotalElements() != 0) {

			// 検索結果がある場合Modelに結果をセットする
			model.addAttribute("page", riderList);
			model.addAttribute("riderList", riderList.getContent());
			model.addAttribute("url", "search");
		}
		return "ridersaito/search";
	}
	/**
	 * 追加画面に遷移する
	 *
	 * @param RiderSaitoInputForm RiderSaitoInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertRider(@ModelAttribute final RiderSaitoInputForm InputForm) {
		return "ridersaito/insert";
	}

	/**
	 * RiderMainSaitoテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param RiderSaitoInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertRider(@ModelAttribute @Validated final RiderSaitoInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーが有る場合自画面に戻る
			return "ridersaito/insert";
		}

		// データを登録する
		final RiderMainSaito riderMainSaito = riderSaitoService.insertRider(form);
		return "redirect:/ridersaito?result=insert&id=" + riderMainSaito.getRiderId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param RiderSaitoInputForm RiderSaitoInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateRider(@RequestParam(name = "id") final long riderid,
			@ModelAttribute final RiderSaitoInputForm RiderSaitoInputForm) {

		// RiderIDをキーにriderMainSaitoテーブルを検索する
		RiderMainSaito riderMainSaito = riderSaitoService.getRider(riderid);

		// フォームにレコードの値をセットする
		RiderSaitoInputForm.initWithRiderMainSaito(riderMainSaito);
		return "riderSaito/update";
	}

	/**
	 * RiderMainSaitoテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param RiderSaitoInputForm form
	 * @param Bindingresult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updaeRider(@Validated final RiderSaitoInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			//  入力エラーが有る場合自画面に戻る
			return "riderSaito/update";
		}

		// データを更新する
		RiderMainSaito riderMainSaito = riderSaitoService.updateRider(form);
		if (riderMainSaito == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/ridersaito?result=updatefailed";
		}
		return "redirect:/ridersaito?result=update&id=" + riderMainSaito.getRiderId();
	}

	/**
	 * RiderMainSaitoテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */


	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteRider(@RequestParam(name = "id") final long riderId) {

		// IDをキーにレコードを論理削除する
		riderSaitoService.deleteRiderByRiderId(riderId);
		return "redirect:/ridersaito?result=delete&id=" + riderId;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param RiderSaitoSearchForm form
	 * @param RiderSaitoDeleteForm RiderSaitoDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompRider(final RiderSaitoSearchForm form,
			@ModelAttribute final RiderSaitoDeleteForm riderSaitoDeleteForm, final Model model) {

		// riderMainSaitoテーブルから削除フラグが１のレコードを検索する
		final List<RiderMainSaito> riderList = riderSaitoService.getListRider(form);

		// Modelに検索結果を格納する
		model.addAttribute(riderList);
		return "ridersaito/deletecomp";
	}

	/**
	 * riderMaianSaitoテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param RiderSaitoDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */

	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompRider(@Validated final RiderSaitoDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーが有る場合、再検索して自画面に戻る
			RiderSaitoSearchForm RiderSaitoSearchForm = new RiderSaitoSearchForm();
			RiderSaitoSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<RiderMainSaito> RiderList =riderSaitoService.getListRider(RiderSaitoSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(RiderList);
			return "ridersaito/deletecomp";
		}

		// データを完全削除する
	    riderSaitoService.deleteRiderComp(form.getDeleteIds());
		return "redirect:/ridersaito?result=deletecomp";
	}
}
