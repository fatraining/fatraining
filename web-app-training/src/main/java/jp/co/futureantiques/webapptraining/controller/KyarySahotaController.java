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
import jp.co.futureantiques.webapptraining.model.form.kyarySahota.KyarySahotaDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.kyarySahota.KyarySahotaInputForm;
import jp.co.futureantiques.webapptraining.model.form.kyarySahota.KyarySahotaSearchForm;
import jp.co.futureantiques.webapptraining.model.kyarySahota.CdNameSahota;
import jp.co.futureantiques.webapptraining.model.kyarySahota.CdTypeSahota;
import jp.co.futureantiques.webapptraining.model.kyarySahota.KyaryMainSahota;
import jp.co.futureantiques.webapptraining.service.KyarySahotaService;

/**
 *KyarySahotaのコントローラークラス
 *
 * @author futureantiques
 */
@Controller
@RequestMapping(value = "/kyarySahota")
public class KyarySahotaController {

	/** 曲名のサービス */
	private final KyarySahotaService kyarySahotaService;

	/**
	 * コンストラクタ
	 *
	 * @param KyarySahotaService kyarySahotaService
	 */
	@Autowired
	public KyarySahotaController(final KyarySahotaService kyarySahotaService) {
		this.kyarySahotaService = kyarySahotaService;
	}

	/**
	 * CD名エンティティのリストを取得する
	 *
	 * @return CdNameSahotaEntityのリスト
	 */
	@ModelAttribute
	public List<CdNameSahota> getListCdNameSahota() {
		return kyarySahotaService.getListCdNameSahota();
	}

	/**
	 * CD形態エンティティのリストを取得する
	 *
	 * @return CdTypeEntityのリスト
	 */
	@ModelAttribute
	public List<CdTypeSahota> getListCdTypeSahota() {
		return kyarySahotaService.getListCdTypeSahota();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param KyarySahotaSearchForm kyarySahotaSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchKyarySahota(@ModelAttribute final KyarySahotaSearchForm kyarySahotaSearchForm) {
		return "kyarySahota/search";
	}

	/**
	 * 検索画面を取得して検索画面に遷移する
	 *
	 * @param KyarySahotaSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchKyarySahota(final KyarySahotaSearchForm form, final Model model, final Pageable pageable) {

		//入力された検索条件を元にレコードを取得する
		final Page<KyaryMainSahota> kyarySahotaList = kyarySahotaService.getPageKyarySahota(form, pageable);
		if (kyarySahotaList.getTotalElements() != 0) {

			//検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", kyarySahotaList);
			model.addAttribute("kyarySahotaList", kyarySahotaList.getContent());
			model.addAttribute("url", "search");
		}
		return "kyarySahota/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param KyarySahotaInputForm kyarySahotaInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertKyarySahota(@ModelAttribute final KyarySahotaInputForm kyarySahotaInputForm) {
		return "kyarySahota/insert";
	}

	/**
	 * KyaryMainSahotaテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param KyarySahotaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertKyarySahota(@ModelAttribute @Validated final KyarySahotaInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合自画面に戻る
			return "kyarySahota/insert";
		}

		//データを登録する
		final KyaryMainSahota kyaryMainSahota = kyarySahotaService.insertKyarySahota(form);
		return "redirect:/kyarySahota?result=insert&id=" + kyaryMainSahota.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param KyarySahotaInputForm kyarySahotaInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateKyarySahota(@RequestParam(name = "id") final long id,
			@ModelAttribute final KyarySahotaInputForm kyarySahotaInputForm) {

		//IDをキーにKyaryMainSahotaテーブルを検索する
		KyaryMainSahota kyaryMainSahota = kyarySahotaService.getKyarySahota(id);

		//フォームにレコードの値をセットする
		kyarySahotaInputForm.initWithKyaryMainSahota(kyaryMainSahota);
		return "kyarySahota/update";
	}

	/**
	 * KyaryMainSahotaテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param KyarySahotaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateKyarySahota(@Validated final KyarySahotaInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合自画面に戻る
			return "kyarySahota/update";
		}

		//データを更新する
		KyaryMainSahota kyaryMainSahota = kyarySahotaService.updateKyarySahota(form);
		if (kyaryMainSahota == null) {

			//更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/kyarySahota?result=updatefailed";
		}
		return "redirect:/kyarySahota?result=update&id=" + kyaryMainSahota.getId();
	}

	/**
	 * KyaryMainSahotaテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteKyarySahota(@RequestParam(name="id")final long id) {

		//IDをキーにレコードを論理削除する
		kyarySahotaService.deleteKyarySahotaById(id);
		return "redirect:/kyarySahota?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param KyarySahotaSearchForm form
	 * @param KyarySahotaDeleteForm kyarySahotaDeleteForm
	 * @paramModel model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteKyarySahotaComp(final KyarySahotaSearchForm form,
			@ModelAttribute final KyarySahotaDeleteForm kyarySahotaDeleteForm, final Model model) {

		//KyaryMainSahotaテーブルから削除フラグが1のレコードを検索する
		final List<KyaryMainSahota> kyarySahotaList = kyarySahotaService.getListKyarySahota(form);

		//Modelに検索結果を格納する
		model.addAttribute(kyarySahotaList);
		return "kyarySahota/deletecomp";
	}

	/**
	 * KyaryMainSahotaテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param KyarySahotaDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompKyarySahota(@Validated final KyarySahotaDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合、再検索して自画面に戻る
			KyarySahotaSearchForm kyarySahotaSearchForm = new KyarySahotaSearchForm();
			kyarySahotaSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<KyaryMainSahota> kyarySahotaList = kyarySahotaService.getListKyarySahota(kyarySahotaSearchForm);

			//Modelに検索結果を格納する
			model.addAttribute(kyarySahotaList);
			return "kyarySahota/deletecomp";
		}
		//データを完全削除する
		kyarySahotaService.deleteKyarySahotaComp(form.getDeleteIds());
		return "redirect:/kyarySahota?result=deletecomp";
	}
}
