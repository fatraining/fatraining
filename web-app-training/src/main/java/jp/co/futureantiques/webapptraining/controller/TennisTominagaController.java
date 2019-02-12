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
@RequestMapping(value = "/tennisTominaga") //このurlを受け取たらクラスを呼ぶ
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

}
