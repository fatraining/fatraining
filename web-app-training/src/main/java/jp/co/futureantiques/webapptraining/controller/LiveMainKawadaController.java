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
import jp.co.futureantiques.webapptraining.model.form.liveMainKawada.LiveMainKawadaDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.liveMainKawada.LiveMainKawadaInputForm;
import jp.co.futureantiques.webapptraining.model.form.liveMainKawada.LiveMainKawadaSearchForm;
import jp.co.futureantiques.webapptraining.model.liveMainKawada.AlbumKawada;
import jp.co.futureantiques.webapptraining.model.liveMainKawada.LiveMainKawada;
import jp.co.futureantiques.webapptraining.model.liveMainKawada.StyleKawada;
import jp.co.futureantiques.webapptraining.service.LiveMainKawadaService;

/**
 * LiveMainKawadaのコントローラークラス
 * @author future
 *
 */
@Controller
@RequestMapping(value = "/liveKawada")
public class LiveMainKawadaController {

	/**ライブ定番曲のサービス*/
	private final LiveMainKawadaService liveMainKawadaService;

	/**
	 * コンストラクタ
	 *
	 * @param LiveMainKawadaService liveMainKawadaService
	 */
	@Autowired
	public LiveMainKawadaController(final LiveMainKawadaService liveMainKawadaService) {
		this.liveMainKawadaService = liveMainKawadaService;
	}

	/**
	 * アルバムエンティティのリストを取得する
	 *
	 * @return AlbumKawadaEntityのリスト
	 */
	@ModelAttribute
	public List<AlbumKawada> getListAlbumKawada(){
		return liveMainKawadaService.getListAlbumKawada();
	}

	/**
	 * スタイルエンティティのリストを取得する
	 *
	 * @return StyleKawadaEntityのリスト
	 */
	@ModelAttribute
	public List<StyleKawada> getListStyleKawada(){
		return liveMainKawadaService.getListStyleKawada();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param LiveMainKawadaSearchForm liveMainKawadaSearchForm
	 * @return 検索画面のパス
	 *
	 */
	@RequestMapping(value ="", method = RequestMethod.GET)
	public String showSearchLive(@ModelAttribute final LiveMainKawadaSearchForm liveMainKawadaSearchForm) {
		return "liveKawada/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param LiveMainKawadaSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 *
	 */
	@RequestMapping(value = "search" , method = RequestMethod.POST)
	public String searchLive(final LiveMainKawadaSearchForm form,final Model model,final Pageable pageable) {

		//入力された検索条件を元にレコードを取得する
		final Page<LiveMainKawada> liveList = liveMainKawadaService.getPageLive(form, pageable);
		if(liveList.getTotalElements() != 0) {

			//検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page",liveList);
			model.addAttribute("liveList",liveList.getContent());
			model.addAttribute("url","search");
		}
		return "liveKawada/search";
	}

	/**
	 * 追加画面に遷移する
	 * @param LiveMainKawadaInputForm liveMainKawadaInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertLive(@ModelAttribute final LiveMainKawadaInputForm liveMainKawadaInputForm) {
		return "liveKawada/insert";
	}

	/**
	 * LiveMainKawadaテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param LiveMainKawadaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value ="insert" , method = RequestMethod.POST)
	public String insertLive(@ModelAttribute @Validated final LiveMainKawadaInputForm form,
			final BindingResult bindingResult) {
		if(bindingResult.hasFieldErrors()) {

			//入力エラーがある場合自画面に戻る
			return "liveKawada/insert";
		}

		//データを登録する
		final LiveMainKawada liveMainKawada = liveMainKawadaService.insertLive(form);
		return "redirect:/liveKawada?result=insert&id=" + liveMainKawada.getId();
	}

	/**
	 * 更新画面に遷移する
	 * @param ling id
	 * @param LiveMainKawadaInputForm liveMainKawadaInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update" , method = RequestMethod.GET)
	public String showUpdateLive(@RequestParam(name = "id" ) final long id,
			@ModelAttribute final LiveMainKawadaInputForm liveMainKawadaInputForm) {

		//IDをキーにLiveMainKawadateテーブルを検索する
		LiveMainKawada liveMainKawada = liveMainKawadaService.getLive(id);

		//フォームにレコードの値をセットする
		liveMainKawadaInputForm.initWithLiveMainKawada(liveMainKawada);
		return "liveKawada/update";
	}

	/**
	 * LiveMainKawadaテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param LiveMainKawadaInputForm form
	 * @oaram BindingResult bindingResult
	 * @retunn 入力エラーがある場合更新画面 ない場合検索画面のパス
	 *
	 */
	@RequestMapping(value = "update" , method = RequestMethod.POST)
	public String updateLive(@Validated final LiveMainKawadaInputForm form,
			final BindingResult bindingResult) {
		if(bindingResult.hasFieldErrors()) {

			//入力エラーがある場合自画面に戻る
			return "liveKawada/update";
		}

		//データを更新する
		LiveMainKawada liveMainKawada = liveMainKawadaService.updateLive(form);
		if(liveMainKawada == null) {

			//更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/liveKawada?result = updatefailed";
		}
		return"redirect:/liveKawada?result=update&id=" + liveMainKawada.getId();
	}

	/**
	 * LiveMainKawadaテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @patam long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete" , method = RequestMethod.GET)
	public String deleteLive(@RequestParam(name = "id") final long id) {

		//IDをキーにレコードを論理削除する
		liveMainKawadaService.deleteLiveMainKawadaById(id);
		return"redirect:/liveKawada?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param LiveMainKawadaSearchForm form
	 * @param LiveMainKawadaDeleteForm liveMainKawadaDeleteForm
	 * @param Model model
	 * @return 完全削除のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompLive(final LiveMainKawadaSearchForm form,
			@ModelAttribute final LiveMainKawadaDeleteForm liveMainKawadaDeleteFrom, final Model model) {

		//LiveMainKawadaテーブルから削除フラグが１のレコードを検索する
		final List<LiveMainKawada> liveList = liveMainKawadaService.getListLive(form);

		//Modelに検索結果を格納する
		model.addAttribute(liveList);
		return"liveKawada/deletecomp";
	}

	/**
	 * LiveMainKawadaテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param LiveMainKawadaDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value="deletecomp" , method = RequestMethod.POST)
	public String deleteCompLive(@Validated final LiveMainKawadaDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if(bindingResult.hasFieldErrors()) {

			//入力エラーがある場合、再検索して次画面に戻る
			LiveMainKawadaSearchForm liveMainKawadaSearchForm = new LiveMainKawadaSearchForm();
			liveMainKawadaSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<LiveMainKawada> liveList = liveMainKawadaService.getListLive(liveMainKawadaSearchForm);

			//Modelに検索結果を格納する
			model.addAttribute(liveList);
			return"liveKawada/deletecomp";
		}

		//データを完全削除する
		liveMainKawadaService.deleteLiveMainKawadaComp(form.getIds());
		return "redirect:/liveKawada?result=deletecomp";
	}
}
