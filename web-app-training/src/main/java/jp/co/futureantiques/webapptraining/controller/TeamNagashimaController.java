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
import jp.co.futureantiques.webapptraining.model.form.teamNagashima.TeamNagashimaDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.teamNagashima.TeamNagashimaInputForm;
import jp.co.futureantiques.webapptraining.model.form.teamNagashima.TeamNagashimaSearchForm;
import jp.co.futureantiques.webapptraining.model.teamNagashima.CoachNagashima;
import jp.co.futureantiques.webapptraining.model.teamNagashima.RegionNagashima;
import jp.co.futureantiques.webapptraining.model.teamNagashima.TeamMainNagashima;
import jp.co.futureantiques.webapptraining.service.TeamNagashimaService;

/**
 * TeamNagashimaのコントローラークラス
 * @author future
 *
 */
@Controller
@RequestMapping(value = "/teamNagashima")
public class TeamNagashimaController {

	/**チームのサービス*/
	private final TeamNagashimaService teamNagashimaService;

	/**
	 * コンストラクタ
	 *
	 * @param TeamNagashimaServvice teamNagashimaService
	 */
	@Autowired
	public TeamNagashimaController(final TeamNagashimaService teamNagashimaService) {
		this.teamNagashimaService = teamNagashimaService;
	}

	/**
	 * 地域エンティティのリストを取得する
	 *
	 * @return RegionEntityのリスト
	 */
	@ModelAttribute
	public List<RegionNagashima> getListRegionNagashima() {
		return teamNagashimaService.getListRegionNagashima();
	}

	/**
	 * 監督国籍エンティティリストを取得する
	 *
	 * @return CoachEntityのリスト
	 */
	@ModelAttribute
	public List<CoachNagashima> getListCoachNagashima() {
		return teamNagashimaService.getListCoachNagashima();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param TeamNagashimaSerchForm teamNagashimaSerchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchTeamNagashima(@ModelAttribute final TeamNagashimaSearchForm teamNagashimaSearchForm) {
		return "teamNagashima/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param TeamNagashimaSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchTeamNagashima(final TeamNagashimaSearchForm form, final Model model, final Pageable pageable) {
		//入力された検索条件を元にレコードを取得する
		final Page<TeamMainNagashima> teamNagashimaList = teamNagashimaService.getPageTeamNagashima(form, pageable);
		if (teamNagashimaList.getTotalElements() != 0) {
			//検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", teamNagashimaList);
			model.addAttribute("teamNagashimaList", teamNagashimaList.getContent());
			model.addAttribute("url", "search");
		}
		return "teamNagashima/search";
	}

	/**
	 * 追加画面に推移する
	 *
	 * @param TeamNagashimaInputForm teamNagashimaInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertTeamNagashima(@ModelAttribute final TeamNagashimaInputForm teamNagashimaInputForm) {
		return "teamNagashima/insert";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertTeam(@ModelAttribute @Validated final TeamNagashimaInputForm form,
			BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合自画面に戻る
			return "teamNagashima/insert";
		}

		//データを登録する
		final TeamMainNagashima teamMainNagashima = teamNagashimaService.insertTeamNagashima(form);
		return "redirect:/teamNagashima?result=insert&id=" + teamMainNagashima.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @palam TeamNagashimaInputForm teamNagashimaInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateTeamNagashima(@RequestParam(name = "id") final long id,
			@ModelAttribute final TeamNagashimaInputForm teamNagashimaInputForm) {

		//IDをキーにTeamMainテーブルを検索する
		TeamMainNagashima teamMainNagashima = teamNagashimaService.getTeamNagashima(id);

		//フォームにレコードの値をセットする
		teamNagashimaInputForm.initWithTeamMainNagashima(teamMainNagashima);
		return "teamNagashima/update";
	}

	/**
	 * TeamMainテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param TeamNagashimaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateTeam(@Validated final TeamNagashimaInputForm form, final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合自画面に戻る
			return "teamNagashima/update";
		}

		//データを更新する
		TeamMainNagashima teamMainNagashima = teamNagashimaService.updateTeamNagashima(form);
		if (teamMainNagashima == null) {

			//更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/teamNagashima?result=updatefailed";
		}
		return "redirect:/teamNagashima?result=uppdatefaild=" + teamMainNagashima.getId();
	}

	/**
	 * TeamMainテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteteamNagashima(@RequestParam(name = "id") final long id) {

		//IDをキーにレコードを論理削除する
		teamNagashimaService.deleteTeamNagashimaById(id);
		return "redirect:/teamNagashima?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に推移する
	 * @param TeamNagashimaSearchForm form
	 * @param TeamNagashimaDeleteForm teamNagashimaDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showdeleteCompTeam(final TeamNagashimaSearchForm form,
			@ModelAttribute final TeamNagashimaDeleteForm teamNagashimaDeleteForm, final Model model) {

		//TeamMainテーブルから削除フラグが１のレコードを検索する
		final List<TeamMainNagashima> teamList = teamNagashimaService.getListTeamNagashima(form);

		//Modelに検索結果を格納する
		model.addAttribute(teamList);
		return "teamNagashima/deletecomp";
	}

	/**
	 * TeamMainテーブルのデータを完全に削除して検索画面に遷移する
	 *
	 * @param TeamNagashimaDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return　入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompTeam(@Validated final TeamNagashimaDeleteForm form, final BindingResult bindingResult,
			final Model model) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合、再検索して自画面に戻る
			TeamNagashimaSearchForm teamNagashimaForm = new TeamNagashimaSearchForm();
			teamNagashimaForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<TeamMainNagashima> teamNagashimaList = teamNagashimaService
					.getListTeamNagashima(teamNagashimaForm);

			//Modelにデータを格納する
			model.addAttribute(teamNagashimaList);
			return "teamNagashima/deletecomp";
		}

		//データを完全に削除する
		teamNagashimaService.deleteTeamNagashimaComp(form.getDeleteIds());
		return "redirect:/teamNagashima?result=deletecomp";
	}
}
