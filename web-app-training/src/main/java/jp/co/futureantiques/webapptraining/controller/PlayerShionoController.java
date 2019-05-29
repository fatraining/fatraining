package jp.co.futureantiques.webapptraining.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.futureantiques.webapptraining.model.form.PlayerShiono.PlayerShionoSearchForm;
import jp.co.futureantiques.webapptraining.model.playerShiono.NationalShiono;
import jp.co.futureantiques.webapptraining.model.playerShiono.PlayerMainShiono;
import jp.co.futureantiques.webapptraining.model.playerShiono.TeamShiono;
import jp.co.futureantiques.webapptraining.service.PlayerShionoService;

/**
 * PlayerShionoのコントローラークラス
 *
 * @author Shiono
 */
@Controller
@RequestMapping(value = "/playershiono")
public class PlayerShionoController {

	/** 選手のサービス */
	private final PlayerShionoService playerShionoService;

	/**
	 * コンストラクタ
	 *
	 * @param PlayerShionoService playerShionoService
	 */
	@Autowired
	public PlayerShionoController(final PlayerShionoService playerShionoService) {
		this.playerShionoService = playerShionoService;
	}

	/**
	 * 国籍エンティティのリストを取得する
	 *
	 * @return NationalShionoEntityのリスト
	 */
	@ModelAttribute
	public List<NationalShiono> getListNational() {
		return playerShionoService.getListNationalShiono();
	}

	/**
	 * チームエンティティのリストを取得する
	 *
	 * @return TeamShionoEntityのリスト
	 */
	@ModelAttribute
	public List<TeamShiono> getListTeamShiono() {
		return playerShionoService.getListTeamShiono();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param PlayerShionoSearchForm playerShionoSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchPlayerShiono(@ModelAttribute final PlayerShionoSearchForm playerShionoSearchForm) {
		return "playershiono/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param PlayerShionoSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchPlayerShiono(final PlayerShionoSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<PlayerMainShiono> playerList = playerShionoService.getPagePlayerShiono(form, pageable);
		if (playerList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", playerList);
			model.addAttribute("playerList", playerList.getContent());
			model.addAttribute("url", "search");
		}
		return "playershiono/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param PlayerShionoInputForm playerShionoInputForm
	 * @return 追加画面のパス

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertplayer(@ModelAttribute final PlayerShionoInputForm playerShionoInputForm) {
		return "playershiono/insert";
	}

	/**
	 * PlayerMainShionoテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param PlayerShionoInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertPlayer(@ModelAttribute @Validated final PlayerShionoInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "playershiono/insert";
		}

		// データを登録する
		final PlayerMainShiono playerMain = playerShionoService.insertPlayer(form);
		return "redirect:/playershiono?result=insert&id=" + playerMain.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param PlayerShionoInputForm playerShionoInputForm
	 * @return 更新画面のパス

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdatePlayer(@RequestParam(name = "id") final long id,
			@ModelAttribute final PlayerShionoInputForm playerShionoInputForm) {

		// IDをキーにPlayerMainShionoテーブルを検索する
		PlayerMainShiono playerMain = playerShionoService.getMovie(id);

		// フォームにレコードの値をセットする
		playerShionoInputForm.initWithPlayerMain(playerMain);
		return "playershiono/update";
	}

	/**
	 * PlayerMainShionoテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param PlayerShionoInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updatePlayer(@Validated final PlayerShionoInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "playershiono/update";
		}

		// データを更新する
		PlayerMainShiono playerMain = playerShionoService.updatePlayer(form);
		if (playerMain == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/playershiono?result=updatefailed";
		}
		return "redirect:/playershiono?result=update&id=" + playerMain.getId();
	}

	/**
	 * PlayerMainShionoテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deletePlayer(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		playerShionoService.deletePlayerById(id);
		return "redirect:/playershiono?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param PlayerShionoSearchForm form
	 * @param PlayerShionoDeleteForm playerShionoDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス

	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompPlayer(final PlayerShionoSearchForm form,
			@ModelAttribute final PlayerShionoDeleteForm playerShionoDeleteForm, final Model model) {

		// PlayerMainShionoテーブルから削除フラグが1のレコードを検索する
		final List<PlayerMainShiono> playerList = playerShionoService.getListPlayer(form);

		// Modelに検索結果を格納する
		model.addAttribute(playerList);
		return "playershiono/deletecomp";
	}

	/**
	 * PlayerMainShionoテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param PlayerShionoDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス

	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompPlayer(@Validated final PlayerShionoDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			PlayerShionoSearchForm playerShionoSearchForm = new PlayershionoSearchForm();
			playerShionoSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<PlayerMainShiono> playerList = playerShionoService.getListPlayer(playerShionoSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(playerList);
			return "playershiono/deletecomp";
		}

		// データを完全削除する
		playerShionoService.deletePlayerComp(form.getDeleteIds());
		return "redirect:/playershiono?result=deletecomp";
	}
	*/
}
