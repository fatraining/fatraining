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
import jp.co.futureantiques.webapptraining.model.form.mobileLegendsSakuma.MobileLegendsSakumaDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.mobileLegendsSakuma.MobileLegendsSakumaInputForm;
import jp.co.futureantiques.webapptraining.model.form.mobileLegendsSakuma.MobileLegendsSakumaSearchForm;
import jp.co.futureantiques.webapptraining.model.mobileLegendsSakuma.FeatureSakuma;
import jp.co.futureantiques.webapptraining.model.mobileLegendsSakuma.MobileLegendsMainSakuma;
import jp.co.futureantiques.webapptraining.model.mobileLegendsSakuma.TypeSakuma;
import jp.co.futureantiques.webapptraining.service.MobileLegendsSakumaService;

/**
 * MobileLegendsのコントローラークラス
 *
 * @author Sakuma
 *
 */

@Controller
@RequestMapping(value = "/mobileLegendsSakuma")
public class MobileLegendsSakumaController {

	/**MobileLegendsの検索サービス*/
	private final MobileLegendsSakumaService mobileLegendsSakumaService;

	/**
	 * コンストラクタ
	 *
	 * @param MobileLegendsService mobileLegendsSakumaService
	 */

	@Autowired
	public MobileLegendsSakumaController(final MobileLegendsSakumaService mobileLegendsSakumaService) {
		this.mobileLegendsSakumaService = mobileLegendsSakumaService;
	}

	/**
	 * タイプエンティティのリストを取得する
	 *
	 * @return TypeSakumaEntityのリスト
	 */

	@ModelAttribute
	public List<TypeSakuma> getListType() {
		return mobileLegendsSakumaService.getListTypeSakuma();
	}

	/**
	 * 特徴エンティティのリストを取得する
	 *
	 * @return FeatureSakumaEntityのリスト
	 */

	@ModelAttribute
	public List<FeatureSakuma> getListFeature() {
		return mobileLegendsSakumaService.getListFeatureSakuma();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param MobileLegendsSakumaSearchForm mobileLegendsSakumaSearchForm
	 * @return 検索画面のパス
	 */

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchMobileLegends(
			@ModelAttribute final MobileLegendsSakumaSearchForm mobileLegendsSakumaSearchForm) {
		return "mobileLegendsSakuma/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param MobileLegendsSakumaSearchForm form
	 * @param Model model
	 * @param Pageble pageble
	 * @return 検索画面のパス
	 */

	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchMobileLegends(final MobileLegendsSakumaSearchForm form, final Model model,
			final Pageable pageable) {

		//入力された検索条件をもとにレコードを取得
		final Page<MobileLegendsMainSakuma> mobileLegendsList = mobileLegendsSakumaService
				.getPageMobileLegendsSakuma(form, pageable);
		if (mobileLegendsList.getTotalElements() != 0) {

			//検索結果がある場合Modelに結果をセットする
			model.addAttribute("page", mobileLegendsList);
			model.addAttribute("mobileLegendsList", mobileLegendsList.getContent());
			model.addAttribute("url", "search");
		}
		return "mobileLegendsSakuma/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param MobileLegendsSakumaInputForm mobileLegendsSakumaInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertMobileLegends(
			@ModelAttribute final MobileLegendsSakumaInputForm mobileLegendsSakumaInputForm) {
		return "mobileLegendsSakuma/insert";
	}

	/**
	 * MobileLegendsMainSakumaテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param mobileLegendsSakumaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertMobileLegendsSakuma(@ModelAttribute @Validated final MobileLegendsSakumaInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合自画面に戻る
			return "mobileLegendsSakuma/insert";
		}

		//データを登録する
		final MobileLegendsMainSakuma mobileLegendsMainSakuma = mobileLegendsSakumaService
				.insertMobileLegendsSakuma(form);
		return "redirect:/mobileLegendsSakuma?result=insert&id=" + mobileLegendsMainSakuma.getId();
	}

	/**更新画面に遷移する
	 *
	 * @param long id
	 * @param MobileLegendsSakumaInputForm mobileLegendsSakumaInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateMobileLegends(@RequestParam(name = "id") final long id,
			@ModelAttribute final MobileLegendsSakumaInputForm mobileLegendsSakumaInputForm) {

		//IDをキーにMobileLegendsSakumaMainテーブルを検索する
		MobileLegendsMainSakuma mobileLegendsMain = mobileLegendsSakumaService.getMobileLegendsSakuma(id);

		//フォームにレコードの値をセットする
		mobileLegendsSakumaInputForm.initWithMobileLegendsMainSakuma(mobileLegendsMain);
		return "mobileLegendsSakuma/update";
	}

	/**
	 * MobileLegendsMainSakumaテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param MobileLegendsSakumaInputForm form
	 * @param bindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateMobileLegends(@Validated final MobileLegendsSakumaInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合自画面に戻る
			return "mobileLegendsSakuma/update";
		}

		//データを更新する
		MobileLegendsMainSakuma mobileLegendsMainSakuma = mobileLegendsSakumaService.updateMobileLegendsSakuma(form);
		if (mobileLegendsMainSakuma == null) {

			//更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/mobileLegendsSakuma?result=updatefailed";
		}
		return "redirect:/mobileLegendsSakuma?result=update&id=" + mobileLegendsMainSakuma.getId();
	}

	/**
	 * MobileLegendsMainSakumaテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteMobileLegends(@RequestParam(name = "id") final long id) {

		//IDをキーにレコードを論理削除する
		mobileLegendsSakumaService.deleteMobileLegendsSakumaById(id);
		return "redirect:/mobileLegendsSakuma?result=delete&id=" + id;
	}

	/**
	 *完全削除画面に遷移する
	 *
	 * @param MobileLegendsSakumaSearchForm
	 * @param MobileLegendsSakumaDeleteForm mobileLegendsSakumaDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompMobileLegends(final MobileLegendsSakumaSearchForm form,
			@ModelAttribute final MobileLegendsSakumaDeleteForm mobileLegendsDeleteForm, final Model model) {

		//MobileLegendsMainSakumaテーブルから削除フラグ1のレコードを検索する
		final List<MobileLegendsMainSakuma> mobileLegendsList = mobileLegendsSakumaService
				.getListMobileLegendsSakuma(form);

		//Modelに検索結果を格納する
		model.addAttribute(mobileLegendsList);
		return "mobileLegendsSakuma/deletecomp";
	}

	/**
	 * MobileLegendsMainSakumaテーブルのデータを完全削除して検索画面に移る
	 *
	 * @param MobileLegendsSakumaDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompPlayer(@Validated final MobileLegendsSakumaDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合、再検索して次画面に戻る
			MobileLegendsSakumaSearchForm mobileLegendsSakumaSearchForm = new MobileLegendsSakumaSearchForm();
			mobileLegendsSakumaSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<MobileLegendsMainSakuma> mobileLegendsList = mobileLegendsSakumaService
					.getListMobileLegendsSakuma(mobileLegendsSakumaSearchForm);

			model.addAttribute(mobileLegendsList);
			return "mobileLegendsSakuma/deletecomp";
		}

		//データを完全削除する
		mobileLegendsSakumaService.deleteMobileLegendsSakumaComp(form.getDeleteIds());
		return "redirect:/mobileLegendsSakuma?result=deletecomp";
	}

}
