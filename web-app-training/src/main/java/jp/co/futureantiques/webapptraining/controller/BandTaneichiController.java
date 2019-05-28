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
import jp.co.futureantiques.webapptraining.model.bandTaneichi.BandMainTaneichi;
import jp.co.futureantiques.webapptraining.model.bandTaneichi.BandSexTaneichi;
import jp.co.futureantiques.webapptraining.model.bandTaneichi.GenreTaneichi;
import jp.co.futureantiques.webapptraining.model.form.bandTaneichi.BandTaneichiDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.bandTaneichi.BandTaneichiInputForm;
import jp.co.futureantiques.webapptraining.model.form.bandTaneichi.BandTaneichiSearchForm;
import jp.co.futureantiques.webapptraining.service.BandTaneichiService;

/**
 * BandTaneichiのコントローラークラス
 * @author future
 *
 */
@Controller
@RequestMapping(value = "/bandtaneichi")
public class BandTaneichiController {

	/** バンドのサービス*/
	private final BandTaneichiService bandTaneichiService;

	/**
	 * コンストラクタ
	 *
	 * @param BandTaneichiService bandTaneichiService
	 */
	@Autowired
	public BandTaneichiController(final BandTaneichiService bandTaneichiService) {
		this.bandTaneichiService = bandTaneichiService;
	}

	/**
	 * バンド性別エンティティのリストを取得する
	 *
	 * @return BandSexTaneichiEntityのリスト
	 */
	@ModelAttribute
	public List<BandSexTaneichi> getListBandSex() {
		return bandTaneichiService.getListBandSex();
	}

	/**
	 * ジャンルエンティティのリストを取得
	 *
	 * @return GenreTanichiEntityのリスト
	 */
	@ModelAttribute
	public List<GenreTaneichi> getListGenre() {
		return bandTaneichiService.getListGenre();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param BandTaneichiSearchForm bandTaneichiSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchBand(@ModelAttribute final BandTaneichiSearchForm bandTaneichiSearchForm) {
		return "bandtaneichi/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @oaram BandTaneichiSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchBand(final BandTaneichiSearchForm form, final Model model, final Pageable pageable) {

		//入力された検索条件を元にレコードを取得
		final Page<BandMainTaneichi> bandList = bandTaneichiService.getPageBand(form, pageable);
		if (bandList.getTotalElements() != 0) {

			// 検索結果がある場合Modelに結果をセットする
			model.addAttribute("page", bandList);
			model.addAttribute("bandList", bandList.getContent());
			model.addAttribute("url", "search");
		}
		return "bandtaneichi/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param BandTaneichiInputForm bandTaneichiInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertBand(@ModelAttribute final BandTaneichiInputForm bandTaneichiInputForm) {
		return "bandtaneichi/insert";
	}

	/**
	 * BandMainテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param BandTaneichiInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertBand(@ModelAttribute @Validated final BandTaneichiInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーが有る場合自画面に戻る
			return "bandtaneichi/insert";
		}

		// データを登録する
		final BandMainTaneichi bandMainTaneichi = bandTaneichiService.insertBand(form);
		return "redirect:/bandtaneichi?result=insert&id=" + bandMainTaneichi.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param BandTaneichiInputForm bandTaneichiInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateBand(@RequestParam(name = "id") final long id,
			@ModelAttribute final BandTaneichiInputForm bandTaneichiInputForm) {

		// IDをキーにBandMainTaneichiテーブルを検索する
		BandMainTaneichi bandMainTaneichi = bandTaneichiService.getBand(id);

		// フォームにレコードの値をセットする
		bandTaneichiInputForm.initWithBandMainTaneichi(bandMainTaneichi);
		return "bandTaneichi/update";
	}

	/**
	 * BandMainTaneichiテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param BandTaneichiInputForm form
	 * @param Bindingresult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updaeBand(@Validated final BandTaneichiInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			//  入力エラーが有る場合自画面に戻る
			return "bandtaneichi/update";
		}

		// データを更新する
		BandMainTaneichi bandMainTaneichi = bandTaneichiService.updateBand(form);
		if (bandMainTaneichi == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/bandtaneichi?result=updatefailed";
		}
		return "redirect:/bandtaneichi?result=update&id=" + bandMainTaneichi.getId();
	}

	/**
	 * BandMainTaneichiテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param log id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteBand(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		bandTaneichiService.deleteBandById(id);
		return "redirect:/bandTaneichi?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param BandTaneichiSearchForm form
	 * @param BandTaneichiDeleteForm bandTaneichiDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompBand(final BandTaneichiSearchForm form,
			@ModelAttribute final BandTaneichiDeleteForm bandTaneichiDeleteForm, final Model model) {

		// BandMainTaneichiテーブルから削除フラグが１のレコードを検索する
		final List<BandMainTaneichi> bandList = bandTaneichiService.getListBand(form);

		// Modelに検索結果を格納する
		model.addAttribute(bandList);
		return "bandtaneichi/deletecomp";
	}

	/**
	 * BandMainTaneichiテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param BandTaneichiDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompBand(@Validated final BandTaneichiDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーが有る場合、再検索して自画面に戻る
			BandTaneichiSearchForm bandTaneichiSearchForm = new BandTaneichiSearchForm();
			bandTaneichiSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<BandMainTaneichi> bandList = bandTaneichiService.getListBand(bandTaneichiSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(bandList);
			return "bandTaneichi/deletecomp";
		}

		// データを完全削除する
		bandTaneichiService.deleteBandComp(form.getDeleteIds());
		return "redirect:/bandtaneichi?result=deletecomp";
	}
}
