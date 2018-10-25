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

import jp.co.futureantiques.webapptraining.model.form.musicalpieceSearch.MusicalpieceSearchMainForm;
import jp.co.futureantiques.webapptraining.model.musicalpieceSearch.AlbumRuike;
import jp.co.futureantiques.webapptraining.model.musicalpieceSearch.ArianaMainRuike;
import jp.co.futureantiques.webapptraining.model.musicalpieceSearch.ColaboRuike;
import jp.co.futureantiques.webapptraining.service.MusicalpieceSearchService;

/*
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

	/** コンストラクタ */
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

	//追加画面に推移
	// MusicalpieceSearchMainForm musicalpieceSearchmainForm
	//追加のパス
	//@RequestMapping(value = "insert", method = RequestMethod.GET)
	//public String showInsertAriana(@ModelAttribute final MusicalpieceSearchMainForm musicalpieceSearchmainForm){
	//return "musicalpieceSearch/search";
	//}

}
