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

import jp.co.futureantiques.webapptraining.model.form.musickichise.MusicKichiseSearchForm;
import jp.co.futureantiques.webapptraining.model.musickichise.Artist;
import jp.co.futureantiques.webapptraining.model.musickichise.Janru;
import jp.co.futureantiques.webapptraining.model.musickichise.MusicKichiseMain;
import jp.co.futureantiques.webapptraining.service.MusicKichiseService;

/**
 * MusicKichiseのコントローラークラス
 * @author future
 */

@Controller
@RequestMapping(value = "/musickichise")
public class MusicKichiseController {

	private final MusicKichiseService musicKichiseService;

	/**
	 * コンストラクタ
	 * @param musicKichiseService
	 */
	@Autowired
	public MusicKichiseController(final MusicKichiseService musicKichiseService) {
		this.musicKichiseService = musicKichiseService;
	}

	/**
	 * アーティストエンティティのリストを取得する
	 * @return ArtistEntityのリスト
	 */
	@ModelAttribute
	public List<Artist> getListArtist() {
		return musicKichiseService.getListArtist();
	}

	/**
	 * ジャンルエンティティのリストを取得する
	 * @return
	 */
	@ModelAttribute
	public List<Janru> getListJanru() {
		return musicKichiseService.getListJanru();
	}

	/**
	 * 検索画面に遷移する
	 * @param musicKichiseSearchForm
	 * @return 検索画面のパスをリダイレクト
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showKichiseSearchMusic(@ModelAttribute final MusicKichiseSearchForm musicKichiseSearchForm) {
		return "musickichise/search";
	}

	/**
	 * searchへ遷移した時
	 * @param form
	 * @param model
	 * @param pageable
	 * @return urlを返す
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchKichiseMusic(final MusicKichiseSearchForm form, final Model model, final Pageable pageable) {
		//入力された検索条件を元にレコードを取得する
		final Page<MusicKichiseMain> musicKichiseList = musicKichiseService.getPageMusic(form, pageable);
		if (musicKichiseList.getTotalElements() != 0) {
			//検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", musicKichiseList);
			model.addAttribute("musicList", musicKichiseList.getContent());
			model.addAttribute("url", "search");
		}
		return "musickichise/search";
	}

}
