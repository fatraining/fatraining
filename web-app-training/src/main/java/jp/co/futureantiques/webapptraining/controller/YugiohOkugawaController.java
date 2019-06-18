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
import jp.co.futureantiques.webapptraining.model.form.yugiohOkugawa.YugiohOkugawaDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.yugiohOkugawa.YugiohOkugawaInputForm;
import jp.co.futureantiques.webapptraining.model.form.yugiohOkugawa.YugiohOkugawaSearchForm;
import jp.co.futureantiques.webapptraining.model.yugiohOkugawa.DeckOkugawa;
import jp.co.futureantiques.webapptraining.model.yugiohOkugawa.SeriesOkugawa;
import jp.co.futureantiques.webapptraining.model.yugiohOkugawa.YugiohMainOkugawa;
import jp.co.futureantiques.webapptraining.service.YugiohOkugawaService;

/** Yugiohのコントローラークラス
 * @author user Okugawa
 */
@Controller
@RequestMapping(value = "/yugiohokugawa")
public class YugiohOkugawaController {

	/** 遊戯王の検索サービス */
	private final YugiohOkugawaService yugiohOkugawaService;

	/** コンストラクタ */
	/**
	 * @param yugiohOkugawaService
	 */
	@Autowired
	public YugiohOkugawaController(final YugiohOkugawaService yugiohOkugawaService) {
		this.yugiohOkugawaService = yugiohOkugawaService;
	}

	/** 作品エンティティのリストを取得する */
	@ModelAttribute
	public List<SeriesOkugawa> getListSeries(){
		return yugiohOkugawaService.getListSeriesOkugawa();
	}

	/**
	 * デッキエンティティのリストを取得する
	 *
	 * @return yugiohOkugawaService
	 */
	@ModelAttribute
	public List<DeckOkugawa> getListDeck(){
		return yugiohOkugawaService.getListDeckOkugawa();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param YugiohOkugawaSearchForm yugiohOkugawaSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchYugioh(@ModelAttribute final YugiohOkugawaSearchForm yugiohOkugawaSearchForm) {
		return "yugiohokugawa/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @oram YugiohOkugawaSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
		public String searchYugioh(final YugiohOkugawaSearchForm form,final Model model, final Pageable pageable) {

			//入力された検索条件をもとにレコードを取得
		final Page<YugiohMainOkugawa> yugiohList = yugiohOkugawaService.getPageYugiohOkugawa(form, pageable);
		if (yugiohList.getTotalElements() != 0) {

			//検索結果がある場合Modelに結果をセットする
			model.addAttribute("page", yugiohList);
			model.addAttribute("yugiohList", yugiohList.getContent());
			model.addAttribute("url","search");
		}
		return "yugiohokugawa/search";
	}

	/**
	 *追加画面に遷移する
	 *
	 * @param YugiohOkugawaInputForm yugiohOkugawaInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertYugioh(@ModelAttribute final YugiohOkugawaInputForm yugiohOkugawaInputForm) {
		return "yugiohokugawa/insert";
	}

	/**
	 * YuguohMainOkugawaテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param YugiohOkugawaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
		public String insertYugiohOkugawa(@ModelAttribute @Validated final YugiohOkugawaInputForm form,
			final BindingResult bindingResult){
		if(bindingResult.hasFieldErrors()) {

			//入力エラーがある場合自画面に戻る
			return "yugiohokugawa/insert";
		}

		//データを登録する
		final YugiohMainOkugawa yugiohMainOkugawa = yugiohOkugawaService.insertYugiohOkugawa(form);
		return "redirect:/yugiohokugawa?result=insert&id=" + yugiohMainOkugawa.getId();
	}

	/**更新画面に遷移する
	 *
	 * @param long id
	 * @param YugiohOkugawaInputForm yugiohOkugawaInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value ="update", method = RequestMethod.GET)
	public String showUodateYugioh(@RequestParam(name = "id") final long id,
			@ModelAttribute final YugiohOkugawaInputForm yugiohOkugawaInputForm){

				//IDをキーにYugiohMAinOkugawaテーブルを検索する
				YugiohMainOkugawa yugiohMain = yugiohOkugawaService.getYugiohOkugawa(id);

				//フォームにレコードの値をセットする
				yugiohOkugawaInputForm.initWithYugiohMainOkugawa(yugiohMain);
				return "yugiohokugawa/update";
			}

	/**
	 * YugiohMainOkugawaテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param YugiohOkugawaInputForm form
	 * @param bindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateYugioh(@Validated final YugiohOkugawaInputForm form,
			final BindingResult bindingResult){
		if(bindingResult.hasFieldErrors()) {

			//入力エラーがある場合自画面に戻る
			return "yugiohokugawa/update";
		}

		//データを更新する
		YugiohMainOkugawa yugiohMainOkugawa = yugiohOkugawaService.updateYugiohOkugawa(form);
		if (yugiohMainOkugawa == null) {

			//更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/yugiohokugawa?result=updatefailed";
		}
		return "redirect:/yugiohokugawa?result=update&id=" + yugiohMainOkugawa.getId();
	}

	/**
	 * YugiohMainOkugawaテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteYugioh(@RequestParam(name = "id") final long id) {

		//IDをキーにレコードを論理削除する
		yugiohOkugawaService.deleteYugiohOkugawaById(id);
		return "redirect:/yugiohokugawa?result=delete&id=" + id;
	}

	/**
	 *
	 * @param YugiohOkugawaSearchForm
	 * @param YugiohOkugawaDeleteForm yugiohOkugawaDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompYugioh(final YugiohOkugawaSearchForm form,
			@ModelAttribute final YugiohOkugawaDeleteForm yugiohOkugawaDeleteForm, final Model model) {

		//YugiohMainOkugawaテーブルから削除フラグ1のレコードを検索する
		final List<YugiohMainOkugawa> yugiohList = yugiohOkugawaService.getListYugiohOkugawa(form);

		//Modelに検索結果を格納する
		model.addAttribute(yugiohList);
		return "yugiohokugawa/deletecomp";
	}

	/**
	 * YugiohMainOkugawaテーブルのデータを完全削除して検索画面に移る
	 *
	 * @param YugiohOkugawaDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompPlayer(@Validated final YugiohOkugawaDeleteForm form,
			final BindingResult bindingResult, final Model model){
		if(bindingResult.hasFieldErrors()) {

			//入力エラーがある場合、再検索して次画面に戻る
			YugiohOkugawaSearchForm yugiohOkugawaSearchForm = new YugiohOkugawaSearchForm();
			yugiohOkugawaSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<YugiohMainOkugawa> yugiohList = yugiohOkugawaService.getListYugiohOkugawa(yugiohOkugawaSearchForm);

			model.addAttribute(yugiohList);
			return "yugiohokugawa/deletecomp";
		}

			//データを完全削除する
			yugiohOkugawaService.deleteYugiohOkugawaComp(form.getDeleteIds());
			return "redirect:/yugiohokugawa?result=deletecomp";
		}

}

