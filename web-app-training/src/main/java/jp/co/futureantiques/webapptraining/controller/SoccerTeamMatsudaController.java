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
import jp.co.futureantiques.webapptraining.model.form.soccerteamMatsuda.TeamMatsudaDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.soccerteamMatsuda.TeamMatsudaInputForm;
import jp.co.futureantiques.webapptraining.model.form.soccerteamMatsuda.TeamMatsudaSearchForm;
import jp.co.futureantiques.webapptraining.model.soccerteamMatsuda.HometownMatsuda;
import jp.co.futureantiques.webapptraining.model.soccerteamMatsuda.TeamColorMatsuda;
import jp.co.futureantiques.webapptraining.model.soccerteamMatsuda.TeamMainMatsuda;
import jp.co.futureantiques.webapptraining.service.SoccerTeamMatsudaService;

/**
 * SoccerTeamMatsudaのコントローラークラス
 *
 * @author future
 */
@Controller
@RequestMapping(value = "/soccerteam")
public class SoccerTeamMatsudaController {

	/** サッカーチームのサービス */
	private final SoccerTeamMatsudaService soccerTeamMatsudaService;

	/**
	 * コンストラクタ
	 *
	 * @param SoccerTeamMatsudaService teamMatsudaService
	 */
	@Autowired
	public SoccerTeamMatsudaController(final SoccerTeamMatsudaService soccerTeamMatsudaService) {
		this.soccerTeamMatsudaService = soccerTeamMatsudaService;
	}

	/**
	 * ホームタウンエンティティのリストを取得する
	 *
	 * @return HometownMatsudaEntityのリスト
	 */
	@ModelAttribute
	public List<HometownMatsuda> getListHometownMatsuda() {
		return soccerTeamMatsudaService.getListHometownMatsuda();
	}

	/**
	 * チームカラーエンティティのリストを取得する
	 *
	 * @return TeamColorEntityのリスト
	 */
	@ModelAttribute
	public List<TeamColorMatsuda> getListTeamColorMatsuda() {
		return soccerTeamMatsudaService.getListTeamColorMatsuda();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param SoccerTeamSearchForm teamMatsudaSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchTeamMatsuda(@ModelAttribute final TeamMatsudaSearchForm teamMatsudaSearchForm) {
		return "soccerteamMatsuda/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param SoccerTeamSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchTeamMatsuda(final TeamMatsudaSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<TeamMainMatsuda> teamList = soccerTeamMatsudaService.getPageTeamMainMatsuda(form, pageable);
		if (teamList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", teamList);
			model.addAttribute("teamList", teamList.getContent());
			model.addAttribute("url", "search");
		}
		return "soccerteamMatsuda/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param TeamMatsudaInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertTeamMatsuda(@ModelAttribute final TeamMatsudaInputForm teamMatsudaInputForm) {
		return "soccerteamMatsuda/insert";
	}

	/**
	 * @param TeamMatsudaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertTeamMatsuda(@ModelAttribute @Validated final TeamMatsudaInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "soccerteamMatsuda/insert";
		}

		// データを登録する
		final TeamMainMatsuda teamMain = soccerTeamMatsudaService.insertTeam(form);
		return "redirect:/soccerteamMatsuda?result=insert&id=" + teamMain.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param TeamMatsudaInputForm teamMatsudaInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateTeam(@RequestParam(name = "id") final long id,
			@ModelAttribute final TeamMatsudaInputForm teamMatsudaInputForm) {

		// IDをキーにTeamMainMatsudaテーブルを検索する
		TeamMainMatsuda teamMain = soccerTeamMatsudaService.getTeam(id);

		// フォームにレコードの値をセットする
		teamMatsudaInputForm.initWithTeamMainMatsuda(teamMain);
		return "soccerteamMatsuda/update";
	}

	/**
	 * MovieMainテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param TeamMatsudaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateTeam(@Validated final TeamMatsudaInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "soccerteamMatsuda/update";
		}

		// データを更新する
		TeamMainMatsuda teamMain = soccerTeamMatsudaService.updateTeam(form);
		if (teamMain == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/soccerteamMatsuda?result=updatefailed";
		}
		return "redirect:/soccerteamMatsuda?result=update&id=" + teamMain.getId();
	}

	/**
	 * TeamMainMatsudaテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteTeam(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		soccerTeamMatsudaService.deleteTeamById(id);
		return "redirect:/soccerteam?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param SoccerTeamSearchForm form
	 * @param TeamMatsudaDeleteForm teamMatsudaDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompTeam(final TeamMatsudaSearchForm form,
			@ModelAttribute final TeamMatsudaDeleteForm teamMatsudaDeleteForm, final Model model) {

		// TeamMainMatsudaテーブルから削除フラグが1のレコードを検索する
		final List<TeamMainMatsuda> teamList = soccerTeamMatsudaService.getListTeamMainMatsuda(form);

		// Modelに検索結果を格納する
		model.addAttribute(teamList);
		return "soccerteamMatsuda/deletecomp";
	}

	/**
	 * <TeamMainMatsudaテーブルのデータを完全削除して検索画面に遷移する>
	 *
	 * @param TeamMatsudaDeleteForm
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompTeam(@Validated final TeamMatsudaDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			TeamMatsudaSearchForm teamMatsudaSearchForm = new TeamMatsudaSearchForm();
			teamMatsudaSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<TeamMainMatsuda> teamList = soccerTeamMatsudaService
					.getListTeamMainMatsuda(teamMatsudaSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(teamList);
			return "soccerteamMatsuda/deletecomp";
		}

		// データを完全削除する
		soccerTeamMatsudaService.deleteTeamComp(form.getDeleteIds());
		return "redirect:/soccerteam?result=deletecomp";
	}
}
