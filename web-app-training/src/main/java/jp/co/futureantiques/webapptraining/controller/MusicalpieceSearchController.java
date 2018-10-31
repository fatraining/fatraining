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

import jp.co.futureantiques.webapptraining.model.form.musicalpieceSearch.MusicalpieceSearchInputForm;
import jp.co.futureantiques.webapptraining.model.form.musicalpieceSearch.MusicalpieceSearchMainForm;
import jp.co.futureantiques.webapptraining.model.musicalpieceSearch.AlbumRuike;
import jp.co.futureantiques.webapptraining.model.musicalpieceSearch.ArianaMainRuike;
import jp.co.futureantiques.webapptraining.model.musicalpieceSearch.ColaboRuike;
import jp.co.futureantiques.webapptraining.service.MusicalpieceSearchService;

/**
 * musicalpieceSearchのコントローラークラス
 *
 * @author future
 * @param <MusicalpieceMain>
 */
@Controller
@RequestMapping(value = "/musicalpieceSearch")
public class MusicalpieceSearchController {

	/** 楽曲検索のサービスを呼ぶ */
	private final MusicalpieceSearchService musicalpieceSearchService;

	/**
	 * コンストラクタ
	 *
	 * @param MusicalpieceSearchService musicalpieceSearchService
	 **/
	@Autowired
	public MusicalpieceSearchController(final MusicalpieceSearchService musicalpieceSearchService) {
		this.musicalpieceSearchService = musicalpieceSearchService;
	}

	/**
	 * アルバムエンティティのリストを取得する
	 *
	 * @return AlbumEntityのリスト
	 */
	@ModelAttribute
	public List<AlbumRuike> getListAlbumRuike() {
		return musicalpieceSearchService.getListAlbumRuike();
	}

	/**
	 *コラボアーティストエンティティのリストを取得する
	 *
	 * @return colaboEntityのリスト
	 */
	@ModelAttribute
	public List<ColaboRuike> getListColaboRuike() {
		return musicalpieceSearchService.getListColaboRuike();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param musicalpieceSearchMainForm MusicalpieceSearchMainForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchMusicalPiece(@ModelAttribute final MusicalpieceSearchMainForm musicalpieceSearchMainForm) {
		return "musicalpieceSearch/musicalpieceSearchmain";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param musicalpieceSearchmainForm  form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchAriana(final MusicalpieceSearchMainForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<ArianaMainRuike> arianamainList = musicalpieceSearchService.getPageArianaMainRuike(form, pageable);
		if (arianamainList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", arianamainList);
			model.addAttribute("arianamainList", arianamainList.getContent());
			model.addAttribute("url", "search");
		}
		return "musicalpieceSearch/musicalpieceSearchmain";
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param MusicalpieceSearchMainForm musicalpieceSearchMainForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateAriana(@RequestParam(name = "id") final long id,
			@ModelAttribute final MusicalpieceSearchInputForm musicalpieceSearchInputForm) {

		// IDをキーにArianaMainRuikeテーブルを検索する
		ArianaMainRuike arianaMainRuike = musicalpieceSearchService.getAriana(id);

		// フォームにレコードの値をセットする
		musicalpieceSearchInputForm.initWithArianaMainRuike(arianaMainRuike);
		return "musicalpieceSearch/MusicalpieceSearchUpdate";
	}

	/**
	 * アリアナメインテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param MusicalpieceSearchInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateArianaMainRuike(@Validated final MusicalpieceSearchInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "musicalpieceSearch/MusicalpieceSearchUpdate";
		}

		    // データを更新する
		ArianaMainRuike arianaRuikeMain = musicalpieceSearchService.updateArianaMainRuike(form);
		if (arianaRuikeMain == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/musicalpieceSearch?result=updatefailed";
		}
		return "redirect:/musicalpieceSearch?result=update&id=" + arianaRuikeMain.getSingleId();
	}
}
