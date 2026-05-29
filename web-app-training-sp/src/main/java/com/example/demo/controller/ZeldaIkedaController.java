package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.form.zelda.ZeldaDeleteForm;
import com.example.demo.model.form.zelda.ZeldaInputForm;
import com.example.demo.model.form.zelda.ZeldaSearchForm;
import com.example.demo.model.zeldaikeda.CompatibleModelIkeda;
import com.example.demo.model.zeldaikeda.GenreIkeda;
import com.example.demo.model.zeldaikeda.TimeSeriesIkeda;
import com.example.demo.model.zeldaikeda.ZeldaMainIkeda;
import com.example.demo.service.ZeldaIkedaService;

@Controller
@RequestMapping(value = "/zeldaIkeda")
public class ZeldaIkedaController {

	/** ゼルダのサービス*/
	private final ZeldaIkedaService zeldaIkedaService;

	/**
	 * コンストラクタ
	 * @param ZeldaIkedaService zeldaIkedaService
	 */
	public ZeldaIkedaController(final ZeldaIkedaService zeldaIkedaService) {
		this.zeldaIkedaService = zeldaIkedaService;
	}

	/**
	 * ジャンルのエンティティリストを取得する
	 * @return GenreIkedaのリスト
	 */
	@ModelAttribute
	public List<GenreIkeda> getListGenreIkeda() {
		return zeldaIkedaService.getListGenreIkeda();
	}

	/**
	 * 時系列のエンティティリストを取得する
	 * @return TimeSeriesIkedaのリスト
	 */
	@ModelAttribute
	public List<TimeSeriesIkeda> getListTimeSeriesIkeda() {
		return zeldaIkedaService.getListTimeSeriesIkeda();
	}

	/**
	 * 対応機種のエンティティリストを取得する
	 * @return CompatibleModelIkedaのリスト
	 */
	@ModelAttribute
	public List<CompatibleModelIkeda> getListCompatibleModelIkeda() {
		return zeldaIkedaService.getListCompatibleModelIkeda();
	}

	/**検索画面に遷移する
	 * 
	 * @param ZeldaSearchForm zeldaSearchForm
	 * @return 検索画面のパス
	 */
	@GetMapping(value = "")
	public String showSearchZelda(@ModelAttribute final ZeldaSearchForm zeldaSearchForm) {
		return "zeldaIkeda/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 * @param ZeldaSearchForm form
	 * @param Model model
	 * @param Pageble pageble
	 * @return 検索画面のパス
	 */
	@PostMapping(value = "search")
	public String searchZelda(final ZeldaSearchForm form, final Model model, final Pageable pageable) {

		//入力された検索条件を元にレコードを取得する
		final Page<ZeldaMainIkeda> zeldaList = zeldaIkedaService.getPageZelda(form, pageable);
		if (zeldaList.getTotalElements() != 0) {

			//検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", zeldaList);
			model.addAttribute("zeldaList", zeldaList.getContent());
			model.addAttribute("url", "search");
		}
		return "zeldaIkeda/search";
	}

	/**
	 * 追加画面に遷移する
	 * @param ZeldaInputForm zeldaInputForm
	 * @return 追加画面のパス
	 */
	@GetMapping(value = "insert")
	public String showInsertZelda(@ModelAttribute final ZeldaInputForm zeldaInputForm) {
		return "zeldaIkeda/insert";
	}

	/**
	 * ZeldaMainテーブルにデータを登録して検索画面に遷移する
	 * @param ZeldaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@PostMapping(value = "insert")
	public String insertZelda(@ModelAttribute @Validated final ZeldaInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合自画面に戻る
			return "zeldaIkeda/insert";
		}

		//データを登録する
		final ZeldaMainIkeda zeldaMain = zeldaIkedaService.insertZelda(form);
		return "redirect:/zeldaIkeda?result=insert&id=" + zeldaMain.getZeldaId();
	}

	/**
	 * 更新画面に遷移する
	 * @param long id
	 * @param ZeldaInputForm zeldaInputForm
	 * @return 更新画面のパス
	 */
	@GetMapping(value = "update")
	public String showUpdateZelda(@RequestParam(name = "id") final long id,
			@ModelAttribute final ZeldaInputForm zeldaInputForm) {

		//IDをキーにZeldaMainIkedaテーブルを検索する
		ZeldaMainIkeda zeldaMain = zeldaIkedaService.getZelda(id);

		//フォームにレコードの値をセットする
		zeldaInputForm.initWithZeldaMain(zeldaMain);
		return "zeldaIkeda/update";
	}

	/**
	 * ZeldaMainIkedaテーブルのデータを更新して検索画面に遷移する
	 * @param ZeldaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、更新途中にデータを削除された場合検索画面のパス、ない場合検索画面のパス
	 */
	@PostMapping(value = "update")
	public String updateZelda(@Validated final ZeldaInputForm form, 
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合自画面に戻る
			return "zeldaIkeda/update";
		}

		//更新途中でデータが削除された場合、検索画面にメッセージを表示する
		try {

			//データを更新する
			ZeldaMainIkeda zeldaMain = zeldaIkedaService.updateZelda(form);
			if (zeldaMain == null) {

				//更新が失敗した場合、検索画面にメッセージを表示する
				return "redirect:/zeldaIkeda?result=updatefailed";
			}
			return "redirect:/zeldaIkeda?result=update&id=" + zeldaMain.getZeldaId();

		//例外の内容が正しければ検索画面にメッセージを表示する
		} catch (NoSuchElementException e) {
			return "redirect:/zeldaIkeda?result=updatefailed";
		}
	}

	/**
	 * ZeldaMainIkedaテーブルのレコードを論理削除して検索画面に遷移する
	 * @param long id
	 * @return 検索画面のパス
	 */
	@GetMapping("delete")
	public String deleteZelda(@RequestParam(name = "id") final long id) {

		//IDをキーにレコードを倫理削除する
		zeldaIkedaService.deleteZeldaById(id);
		return "redirect:/zeldaIkeda?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 * @param ZeldaSearchForm form
	 * @param ZeldaDeleteForm zeldaDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@GetMapping(value = "deletecomp")
	public String showDeleteCompZelda(final ZeldaSearchForm form,
			@ModelAttribute final ZeldaDeleteForm zeldaDeleteForm, final Model model) {

		//ZeldaIkedaテーブルから削除フラグが1のレコードを検索する
		final List<ZeldaMainIkeda> zeldaList = zeldaIkedaService.getListZelda(form);

		//Modelに検索結果を格納する
		model.addAttribute(zeldaList);
		return "zeldaIkeda/deletecomp";
	}

	/**
	 * ZeldaMainIkedaのテーブルデータを完全削除して検索画面に遷移する
	 * @param ZeldaDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@PostMapping(value = "deletecomp")
	public String deleteCompZelda(@Validated final ZeldaDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			//エラーがある場合自画面に戻る
			zeldaIkedaService.erroZelda(form, model);
			return "zeldaIkeda/deletecomp";
		}

		//データを完全削除する
		zeldaIkedaService.deleteZeldaComp(form.getDeleteIds());
		return "redirect:/zeldaIkeda?result=deletecomp";
	}

	/**
	 * ZeldaMainIkedaのテーブルデータを復元して検索画面に遷移する
	 * @param ZeldaDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@PostMapping(value = "revoke")
	public String revokeZelda(@Validated final ZeldaDeleteForm form, final BindingResult bindingResult,
			final Model model) {
		if (bindingResult.hasErrors()) {

			//エラーがある場合自画面に戻る
			zeldaIkedaService.erroZelda(form, model);
			return "zeldaIkeda/deletecomp";
		}

		//データを復元する
		zeldaIkedaService.revokeZeldaById(form.getDeleteIds());
		return "redirect:/zeldaIkeda?result=revoke";
	}
}
