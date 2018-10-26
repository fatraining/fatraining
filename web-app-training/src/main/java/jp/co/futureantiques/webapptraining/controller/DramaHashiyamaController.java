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

import jp.co.futureantiques.webapptraining.model.dramaHashiyama.ChannelHashiyama;
import jp.co.futureantiques.webapptraining.model.dramaHashiyama.DramaActorHashiyama;
import jp.co.futureantiques.webapptraining.model.dramaHashiyama.DramaMainHashiyama;
import jp.co.futureantiques.webapptraining.model.form.dramaHashiyama.DramaDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.dramaHashiyama.DramaInputForm;
import jp.co.futureantiques.webapptraining.model.form.dramaHashiyama.DramaSearchForm;
import jp.co.futureantiques.webapptraining.service.DramaHashiyamaService;


/**
 * Drama_main_hashiyamaのコントローラークラス
 *
 * @author hashiyama
 */

@Controller
@RequestMapping(value = "/dramahashiyama")
public class DramaHashiyamaController {

	/** ドラマのサービス */
	private final DramaHashiyamaService dramaHashiyamaService;

	/**
	 * コンストラクタ
	 *
	 * @param DramaHashiyamaService dramaHashiyamaService
	 */
	@Autowired
	public DramaHashiyamaController(final DramaHashiyamaService dramaHashiyamaService) {
		this.dramaHashiyamaService = dramaHashiyamaService;
	}

	/**
	 *主演俳優エンティティのリストを取得する
	 *
	 * @return DramaActorEntityのリスト
	 */
	@ModelAttribute
	public List<DramaActorHashiyama> getListActor() {
		return dramaHashiyamaService.getListDramaActorHashiyama();
	}

	/**
	 * テレビ局エンティティのリストを取得する
	 *
	 * @return ChannelEntityのリスト
	 */
	@ModelAttribute
	public List<ChannelHashiyama> getListChannel() {
		return dramaHashiyamaService.getListChannelHashiyama();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param DramaSearchForm dramaSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchDrama(@ModelAttribute final DramaSearchForm dramaSearchForm) {
		return "dramahashiyama/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param DramaSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchDrama(final DramaSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<DramaMainHashiyama> dramaList = dramaHashiyamaService.getPageDrama(form, pageable);
		if (dramaList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", dramaList);
			model.addAttribute("dramaList", dramaList.getContent());
			model.addAttribute("url", "search");
		}
		return "dramahashiyama/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param DramaInputForm dramaInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertDrama(@ModelAttribute final DramaInputForm dramaInputForm) {
		return "dramahashiyama/insert";
	}

	/**
	 * DramaMainHashiyamaテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param DramaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertDrama(@ModelAttribute @Validated final DramaInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "dramahashiyama/insert";
		}

		// データを登録する
		final DramaMainHashiyama dramaMainHashiyama = dramaHashiyamaService.insertDrama(form);
		return "redirect:/drama?result=insert&id=" + dramaMainHashiyama.getId();
		}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param DramaInputForm dramaInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateDrama(@RequestParam(name = "id") final long id,
			@ModelAttribute final DramaInputForm dramaInputForm) {

		// IDをキーにDramaMainHashiyamaテーブルを検索する
		DramaMainHashiyama dramaMainHashiyama = dramaHashiyamaService.getDrama(id);

		// フォームにレコードの値をセットする
		dramaInputForm.initWithDramaMainHashiyama(dramaMainHashiyama);
		return "dramahashiyama/update";
			}

	/**
	 * DramaMainHashiyamaテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param DramaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateDrama(@Validated final DramaInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "dramahashiyama/update";
		}

		// データを更新する
		DramaMainHashiyama dramaMainHashiyama = dramaHashiyamaService.updateDrama(form);
		if (dramaMainHashiyama == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/drama?result=updatefailed";
		}
		return "redirect:/dramahashiyama?result=update&id=" + dramaMainHashiyama.getId();
			}

	/**
	 * DramaMainHashiyamaテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteDrama(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		dramaHashiyamaService.deleteDramaById(id);
		return "redirect:/dramahashiyama?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param DramaSearchForm form
	 * @param DramaDeleteForm dramaDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompIdol(final DramaSearchForm form,
			@ModelAttribute final DramaDeleteForm dramaDeleteForm, final Model model) {

		// DramaMainHashiyamaテーブルから削除フラグが1のレコードを検索する
		final List<DramaMainHashiyama> dramaList = dramaHashiyamaService.getListDrama(form);

		// Modelに検索結果を格納する
		model.addAttribute(dramaList);
		return "dramahashiyama/deletecomp";
			}

	/**
	 * DramaMainHashiyamaテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param DramaDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompDrama(@Validated final DramaDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			DramaSearchForm dramaSearchForm = new DramaSearchForm();
			dramaSearchForm.setIsDelete(1);
			final List <DramaMainHashiyama> dramaList = dramaHashiyamaService.getListDrama(dramaSearchForm);

			// Modelに検索結果を格納する
			model.addAllAttributes(dramaList);
			return "dramahashiyama/deletecomp";
		}

		// データを完全削除する
		dramaHashiyamaService.deleteDramaComp(form.getDeleteIds());
		return "redirect:/dramahashiyama?result=deletecomp";
			}
}