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
import jp.co.futureantiques.webapptraining.model.form.jojoShirasaka.JojoStandDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.jojoShirasaka.JojoStandInputForm;
import jp.co.futureantiques.webapptraining.model.form.jojoShirasaka.JojoStandSearchForm;
import jp.co.futureantiques.webapptraining.model.jojoShirasaka.JojoAppearanceShirasaka;
import jp.co.futureantiques.webapptraining.model.jojoShirasaka.JojoMainShirasaka;
import jp.co.futureantiques.webapptraining.model.jojoShirasaka.JojoSexShirasaka;
import jp.co.futureantiques.webapptraining.service.JojoShirasakaService;



/**
 * Jojoのコントローラークラス
 * @author user
 *
 */
@Controller
@RequestMapping(value = "/jojoshirasaka")
public class JojoShirasakaController {

	/** ジョジョ検索のサービス */
	private final JojoShirasakaService jojoShirasakaService;

	/** コンストラクタ */
	/**
	 * @param jojoShirasakaService
	 */
	@Autowired
	public JojoShirasakaController(final JojoShirasakaService jojoShirasakaService) {
		this.jojoShirasakaService = jojoShirasakaService;
	}

	/** 性別エンティティのリストを取得する */
	@ModelAttribute
	public List<JojoSexShirasaka> getListJojoSex() {
		return jojoShirasakaService.getListJojoSex();
	}

	/** 登場部エンティティのリストを取得する */
	@ModelAttribute
	public List<JojoAppearanceShirasaka> getListJojoAppearance() {
		return jojoShirasakaService.getListJojoAppearance();
	}

	/** 検索画面に遷移する
	 * @param jojoStandSearchForm
	 * @return String
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchJojo(@ModelAttribute final JojoStandSearchForm jojoStandSearchForm) {
		return "jojoshirasaka/search";
	}

	/** 検索結果を取得して検索画面に遷移する */
	/**
	 * @param form
	 * @param model
	 * @param pageable
	 * @return String
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchJojo(final JojoStandSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<JojoMainShirasaka> jojoList = jojoShirasakaService.getPageJojo(form, pageable);
		if (jojoList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", jojoList);
			model.addAttribute("jojoList", jojoList.getContent());
			model.addAttribute("url", "search");
		}
		return "jojoshirasaka/search";
	}


	/**
	 * 追加画面に遷移する
	 *
	 * @param MovieSampleInputForm movieSampleInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertStand(@ModelAttribute final JojoStandInputForm jojoStandInputForm) {
		return "jojoshirasaka/insert";
	}

	/**
	 * JojoMainShirasakaテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param JojoShirasakaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertStand(@ModelAttribute @Validated final JojoStandInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "jojoshirasaka/insert";
		}

		// データを登録する
		final JojoMainShirasaka jojoMainShirasaka = jojoShirasakaService.insertJojo(form);
		return "redirect:/jojoshirasaka?result=insert&id=" + jojoMainShirasaka.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param JojoStandInputForm JojoStandInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateStand(@RequestParam(name = "id") final long id,
			@ModelAttribute final JojoStandInputForm jojoStandInputForm) {

		// IDをキーにJojoMainShirasakaテーブルを検索する
		JojoMainShirasaka jojoMainShirasaka = jojoShirasakaService.getJojoStand(id);

		// フォームにレコードの値をセットする
		jojoStandInputForm.initWithJojoMain(jojoMainShirasaka);
		return "jojoshirasaka/update";
	}

	/**
	 * JojoMainShirasakaテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param JojoStandInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateStand(@Validated final JojoStandInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "jojoshirasaka/update";
		}

		// データを更新する
		JojoMainShirasaka jojoMainShirasaka = jojoShirasakaService.updateStand(form);
		if (jojoMainShirasaka == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/jojoshirasaka?result=updatefailed";
		}
		return "redirect:/jojoshirasaka?result=update&id=" + jojoMainShirasaka.getId();
	}

	/**
	 * JojoMainShirasakaテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteStand(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		jojoShirasakaService.deleteStandById(id);
		return "redirect:/jojoshirasaka?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param JojoStandSearchForm form
	 * @param JojoStandDeleteForm jojoStandDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompStand(final JojoStandSearchForm form,
			@ModelAttribute final JojoStandDeleteForm jojoStandDeleteForm, final Model model) {

		// MovieMainテーブルから削除フラグが1のレコードを検索する
		final List<JojoMainShirasaka> standList = jojoShirasakaService.getListJojoMain(form);

		// Modelに検索結果を格納する
		model.addAttribute(standList);
		return "jojoshirasaka/deletecomp";
	}

	/**
	 * JojoMainShirasakaテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param JojoStandDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompStand(@Validated final JojoStandDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			JojoStandSearchForm jojoStandSearchForm = new JojoStandSearchForm();
			jojoStandSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<JojoMainShirasaka> standList = jojoShirasakaService.getListJojoMain(jojoStandSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(standList);
			return "jojoshirasaka/deletecomp";
		}

		// データを完全削除する
		jojoShirasakaService.deleteStandComp(form.getDeleteIds());
		return "redirect:/jojoshirasaka?result=deletecomp";
	}
}


