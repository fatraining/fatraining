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
/* import jp.co.futureantiques.webapptraining.model.voiceActorKoba.CharacterKoba; */
import jp.co.futureantiques.webapptraining.model.form.voiceActorKoba.VoiceActorKobaDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.voiceActorKoba.VoiceActorKobaInputForm;
import jp.co.futureantiques.webapptraining.model.form.voiceActorKoba.VoiceActorKobaSearchForm;
import jp.co.futureantiques.webapptraining.model.voiceActorKoba.AnimeKoba;
import jp.co.futureantiques.webapptraining.model.voiceActorKoba.FromKoba;
import jp.co.futureantiques.webapptraining.model.voiceActorKoba.OfficeKoba;
import jp.co.futureantiques.webapptraining.model.voiceActorKoba.VoiceMainKoba;
import jp.co.futureantiques.webapptraining.service.VoiceActorKobaService;

/**
 * VoiceActorKobaのコントローラークラス
 *
 */

@Controller
@RequestMapping(value="/voiceactorkoba")
public class VoiceActorKobaController {

	/** 男性声優のサービス */
	private final VoiceActorKobaService voiceActorKobaService;

	/**
	 * コンストラクタ
	 *
	 * @param VoiceActorKobaService voiceActorKobaService
	 */

	@Autowired
	public VoiceActorKobaController(final VoiceActorKobaService voiceActorKobaService) {
		this.voiceActorKobaService = voiceActorKobaService;
	}

	/**
	 * 出身地Entityのリストを取得する
	 *
	 * @return FromEntityのリスト
	 */
	@ModelAttribute
	public List<FromKoba> getListFrom(){
		return voiceActorKobaService.getListFrom();
	}

	/**
	 * 事務所エンティティのリストを取得する
	 *
	 * @return OfficeEntityのリスト
	 */
	@ModelAttribute
	public List<OfficeKoba> getListOffice(){
		return voiceActorKobaService.getListOffice();
	}

	/**
	 * アニメタイトルエンティティのリストを取得する
	 *
	 * @return AnimeEntityのリスト
	 */
	@ModelAttribute
	public List<AnimeKoba> getListAnime(){
		return voiceActorKobaService.getListAnime();
	}

	/**
	 * 上記アニメで担当しているキャラクターエンティティのリストを取得する
	 *
	 * @return CharacterEntityのリスト

	@ModelAttribute
	public List<CharacterKoba> getListCharacter(){
		return voiceActorKobaService.getListCharacter();
	} */

	/**
	 * 検索画面に遷移する
	 *
	 * @param VoiceActorKobaSearchForm voiceActorKobaSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchVoiceActor(@ModelAttribute final VoiceActorKobaSearchForm voiceActorKobaSearchForm) {
		return "voiceactorkoba/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param VoiceActorKobaSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */

	@RequestMapping(value="search",method=RequestMethod.POST)
	public String searchVoiceActor(final VoiceActorKobaSearchForm form,final Model model,final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<VoiceMainKoba> voiceActorList = voiceActorKobaService.getPageVoiceActor(form,pageable);
		if(voiceActorList.getTotalElements()!=0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page",voiceActorList);
			model.addAttribute("voiceActorList",voiceActorList.getContent());
			model.addAttribute("url","search");
		}
		return "voiceactorkoba/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param VoiceActorKobaInputForm voiceActorKobaInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value="insert",method=RequestMethod.GET)
	public String showInsertVoiceActor(@ModelAttribute final VoiceActorKobaInputForm voiceActorKobaInputForm) {
		return "voiceactorkoba/insert";
	}

	/**
	 * VoiceMainKobaテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param VoiceActorKobaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */

	@RequestMapping(value="insert",method=RequestMethod.POST)
	public String insertVoiceActor(@ModelAttribute @Validated final VoiceActorKobaInputForm form,final BindingResult bindingResult) {
		if(bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "voiceactorkoba/insert";
		}

		// データを登録する
		final VoiceMainKoba voiceMainKoba = voiceActorKobaService.insertVoiceActor(form);
		return "redirect:/voiceactorkoba?result=insert&id=" + voiceMainKoba.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param VoiceActorKobaInputForm VoiceActorKobaInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value="update",method=RequestMethod.GET)
	public String showUpdateVoiceActor(@RequestParam(name="id")final long id,
		@ModelAttribute final VoiceActorKobaInputForm VoiceActorKobaInputForm) {

		// IDをキーにvoiceMainKobaテーブルを検索する
		VoiceMainKoba voiceMainKoba = voiceActorKobaService.getVoiceActor(id);

		// フォームにレコードの値をセットする
		VoiceActorKobaInputForm.initWithVoiceMainKoba(voiceMainKoba);
		return "voiceActorKoba/update";
	}

	/**
	 * VoiceMainKobaテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param VoiceActorKobaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateVoiceActor(@Validated final VoiceActorKobaInputForm form,final BindingResult bindingResult) {
		if(bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "voiceActorKoba/update";
		}

		// データを更新する
		VoiceMainKoba voiceMainKoba = voiceActorKobaService.updateVoiceActor(form);
		if(voiceMainKoba == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/voiceactorkoba?result=updatefailed";
		}
		return "redirect:/voiceactorkoba?result=update&id=" + voiceMainKoba.getId();
	}

	/**
	 * VoiceActorテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */

	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String deleteVoiceActor(@RequestParam(name="id")final long id) {

		// IDをキーにしてレコードを論理削除する
		voiceActorKobaService.deleteVoiceActorById(id);
		return "redirect:/voiceactorkoba?result=delete&id=" + id;
	}


	/**
	 * 完全削除画面に遷移する
	 *
	 * @param VoiceActorKobaSearchForm form
	 * @param VoiceActorKobaDeleteForm VoiceActorKobaDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompVoiceActor(final VoiceActorKobaSearchForm form,
			@ModelAttribute final VoiceActorKobaDeleteForm voiceActorKobaDeleteForm, final Model model) {

		// voiceMainKobaテーブルから削除フラグが1のレコードを検索する
		final List<VoiceMainKoba> voiceActorList = voiceActorKobaService.getListVoiceActor(form);

		// Modelに検索結果を格納する
		model.addAttribute(voiceActorList);
		return "voiceactorkoba/deletecomp";
	}

	/**
	 * voiceMainKobaテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param VoiceActorKobaDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */

	@RequestMapping(value="deletecomp",method=RequestMethod.POST)
	public String deleteCompVoiceActor(@Validated final VoiceActorKobaDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if(bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			VoiceActorKobaSearchForm VoiceActorKobaSearchForm = new VoiceActorKobaSearchForm();
			VoiceActorKobaSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<VoiceMainKoba> voiceActorList = voiceActorKobaService.getListVoiceActor(VoiceActorKobaSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(voiceActorList);
			return "voiceactorkoba/deletecomp";
		}

		// データを完全削除する
		voiceActorKobaService.deleteVoiceActorComp(form.getDeleteIds());
		return "redirect:/voiceactorkoba?result=deletecomp";
	}

}
