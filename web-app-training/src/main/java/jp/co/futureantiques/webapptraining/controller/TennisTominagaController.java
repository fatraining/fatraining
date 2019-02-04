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
import jp.co.futureantiques.webapptraining.model.form.tennisTominaga.PlayerMainDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.tennisTominaga.PlayerMainInputForm;
import jp.co.futureantiques.webapptraining.model.form.tennisTominaga.PlayerMainSearchForm;
import jp.co.futureantiques.webapptraining.model.tennisTominaga.NationalityTominaga;
import jp.co.futureantiques.webapptraining.model.tennisTominaga.PlayerMainTominaga;
import jp.co.futureantiques.webapptraining.service.TennisTominagaService;

/**
 * Tennisのコントローラークラス
 *
 *ここで検索メソッド等、サービスにある各種メソッドを呼び出す
 * @author future
 */

//このテニスプレイヤー検索アプリは現状見れますが
//国籍や利き手等、ヌルで登録すると表示時にエラーが起こります

@Controller
@RequestMapping(value = "/tennisTominaga")//このurlを受け取たらクラスを呼ぶ
public class TennisTominagaController {

	/** テニスのサービス */
	private final TennisTominagaService tennisTominagaService;

	/**
	 * コンストラクタ //インスタンスを生成するときは必ずテニスのサービスを引数で渡す
	 *
	 * @param TennisTominagaService tennisTominagaService
	 */
	@Autowired
	public TennisTominagaController(final TennisTominagaService tennisTominagaService) {
		this.tennisTominagaService = tennisTominagaService;

	}

	/**
	 * 国籍のエンティティのリストを取得する
	 *
	 * @return NationalityEntityのリスト
	 */
	@ModelAttribute //指定したクラスにリクエストパラメータをバインドするアノテーション。 https://qiita.com/YAKINIKU/items/abaa54ba531a30850d10
	//このアノテーションをつけたメソッドはリクエストのたびに@RequestMappingメソッドの前に呼ばれる
	//国籍のエンティティのリストを返す
	public List<NationalityTominaga> getListNationality() {
		return tennisTominagaService.getListNationality();
		//		return  new ArrayList<NationalityTominaga>();

	}

	/**
	 * 検索画面に遷移する
	 *
	 * @return 検索画面のパス
	 */

	//何も入力されていない場合、、そのまま画面に戻す
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchPlayer(@ModelAttribute final PlayerMainSearchForm playerMainSearchForm) {
		return "tennisTominaga/search";

	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param PlayerMainSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */

	//searchのリクエストを受け取ったらこのメソッドが呼び出される。処理をした後にsearchへリンクで移動
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchPlayer(final PlayerMainSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する 定数としてレコードをページ型のリストに入れる
		//入れるためのレコードはサービスのgetPagePlayerメソッドからの戻り値を使う
		//引数として渡しているformには自動で検索条件のデータが入り、
		//pageableにはページングのデータが入るので気にしないでもよい
		final Page<PlayerMainTominaga> playerList = tennisTominagaService.getPagePlayer(form, pageable);
		if (playerList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", playerList);
			model.addAttribute("playerList", playerList.getContent());
			model.addAttribute("url", "search");

		}

		return "tennisTominaga/search";

	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param PlayerMainInputForm playerMainInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertPlayer(@ModelAttribute final PlayerMainInputForm playerMainInputForm) {
		return "tennisTominaga/insert";


	}

	/**
	 * PlayerMainテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param PlayerMainInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertPlayer(@ModelAttribute @Validated final PlayerMainInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "tennisTominaga/insert";
		}

		// データを登録する
		final PlayerMainTominaga playerMain = tennisTominagaService.insertPlayer(form);
		return "redirect:/tennisTominaga?result=insert&id=" + playerMain.getId();

	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param PlayerMainInputForm playerMainInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdatePlayer(@RequestParam(name = "id") final long id,
			@ModelAttribute final PlayerMainInputForm playerMainInputForm) {

		// IDをキーにPlayerMainテーブルを検索する
		PlayerMainTominaga playerMain = tennisTominagaService.getPlayer(id);

		// フォームにレコードの値をセットする
		playerMainInputForm.initWithPlayerMain(playerMain);
		return "tennisTominaga/update";

	}

	/**
	 * PlayerMainテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param PlayerMainInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updatePlayer(@Validated final PlayerMainInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "tennisTominaga/update";
		}

		// データを更新する
		PlayerMainTominaga playerMain = tennisTominagaService.updatePlayer(form);
		if (playerMain == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/tennisTominaga?result=updatefailed";
		}
		return "redirect:/tennisTominaga?result=update&id=" + playerMain.getId();

	}

	/**
	 * PlayerMainテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deletePlayer(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		tennisTominagaService.deletePlayerById(id);
		return "redirect:/tennisTominaga?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param PlayerMainSearchForm form
	 * @param PlayerMainDeleteForm playerMainDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompPlayer(final PlayerMainSearchForm form,
			@ModelAttribute final PlayerMainDeleteForm playerMainDeleteForm, final Model model) {

		// PlayerMainテーブルから削除フラグが1のレコードを検索する
		final List<PlayerMainTominaga> playerList = tennisTominagaService.getListPlayer(form);

		// Modelに検索結果を格納する
		model.addAttribute(playerList);
		return "tennisTominaga/deletecomp";
	}

	/**
	 * PlayerMainテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param PlayerMainDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */



	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompPlayer(@Validated final PlayerMainDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			PlayerMainSearchForm playerMainSearchForm = new PlayerMainSearchForm();
			playerMainSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<PlayerMainTominaga> playerList = tennisTominagaService.getListPlayer(playerMainSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(playerList);
			return "tennisTominaga/deletecomp";

		}

		// データを完全削除する
		tennisTominagaService.deletePlayerComp(form.getDeleteIds());
		return "redirect:/tennisTominaga?result=deletecomp";

	}

}
