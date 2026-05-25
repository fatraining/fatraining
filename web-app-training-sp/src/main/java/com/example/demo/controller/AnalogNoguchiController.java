package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.constant.CommonConst;
import com.example.demo.model.analogNoguchi.AnalogMainNoguchi;
import com.example.demo.model.analogNoguchi.Genre1Noguchi;
import com.example.demo.model.analogNoguchi.Genre2Noguchi;
import com.example.demo.model.analogNoguchi.TypeNoguchi;
import com.example.demo.model.form.analogNoguchi.AnalogNoguchiDeleteForm;
import com.example.demo.model.form.analogNoguchi.AnalogNoguchiInputForm;
import com.example.demo.model.form.analogNoguchi.AnalogNoguchiSearchForm;
import com.example.demo.service.AnalogNoguchiService;

/**
 * AnalogMainのコントローラークラス
 * 
 * @author future
 */
@Controller
@RequestMapping(value = "/analog")
public class AnalogNoguchiController {

	/** アナログゲームのサービス */
	private final AnalogNoguchiService analogNoguchiService;

	/** コンストラクタ */
	public AnalogNoguchiController(final AnalogNoguchiService analogNoguchiService) {
		this.analogNoguchiService = analogNoguchiService;
	}

	/**
	 * 種類エンティティのリストを取得する
	 * 
	 * @return TypeEntityのリスト
	 */
	@ModelAttribute("typeList")
	public List<TypeNoguchi> getListType() {
		return analogNoguchiService.getListType();
	}

	/**
	 * ジャンル1エンティティのリストを取得する
	 * 
	 * @return Genre1Entityのリスト
	 */
	@ModelAttribute("genre1List")
	public List<Genre1Noguchi> getGenre1() {
		return analogNoguchiService.getListGenre1();
	}

	/**
	 * ジャンル2エンティティのリストを取得する
	 * 
	 * @return Genre2Entityのリスト
	 */
	@ModelAttribute("genre2List")
	public List<Genre2Noguchi> getGenre2() {
		return analogNoguchiService.getListGenre2();
	}

	/**
	 * 対象年齢のリストを取得する
	 * 
	 * @return TargetYearsのリスト
	 */
	@ModelAttribute("targetYearsList")
	public List<Integer> getTargetYearsList() {
		return analogNoguchiService.getTargetYearsList();
	}

	/**
	 * 検索画面に遷移する
	 * 
	 * @param AnalogNoguchiSearchForm analogNoguchiSearchForm
	 * @return 検索画面のパスtest
	 */
	@GetMapping(value = "")
	public String showSearchAnalog(@ModelAttribute final AnalogNoguchiSearchForm analogNoguchiSearchForm) {
		return "analog/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 * 
	 * @param AnalogNoguchiSearchForm form
	 * @param Model model
	 * @param Pageble pageble
	 * @return 検索画面のパス
	 */
	@PostMapping(value = "search")
	public String searchAnalog(final AnalogNoguchiSearchForm form, final Model model, final Pageable pageable) {

		//入力された検索条件を元にレコードを取得する
		final Page<AnalogMainNoguchi> analogList = analogNoguchiService.getPageAnalog(form, pageable);

		if (analogList.getTotalElements() != 0) {

			//検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", analogList);
			model.addAttribute("analogList", analogList.getContent());
			model.addAttribute("url", "search");
		}

		return "analog/search";
	}

	/**
	 * 追加画面に遷移する
	 * 
	 * @param AnalogNoguchiInputForm analogNoguchiInputForm
	 * @return 追加画面のパス
	 */
	@GetMapping(value = "insert")
	public String showInsertAnalog(@ModelAttribute final AnalogNoguchiInputForm analogNoguchiInputForm) {
		return "analog/insert";
	}

	/**
	 * AnalogMainテーブルにデータを登録して検索画面に遷移する
	 * 
	 * @param AnalogNoguchiInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合、追加画面に
	 *          ない場合、検索画面にパス
	 */
	@PostMapping(value = "insert")
	public String insertAnalog(@ModelAttribute @Validated final AnalogNoguchiInputForm form,
			final BindingResult bindingResult) {

		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合、自画面に戻る
			return "analog/insert";
		}

		//データを登録する
		final AnalogMainNoguchi analogMainNoguchi = analogNoguchiService.insertAnalog(form);
		return "redirect:/analog?result=insert&id=" + analogMainNoguchi.getId();
	}

	/**
	 * 更新画面に遷移する
	 * 
	 * @param long id
	 * @param AnalogNoguchiInputForm analogNoguchiInputForm
	 * @return 更新画面のパス
	 */
	@GetMapping(value = "update")
	public String showUpdateAnalog(@RequestParam(name = "id") final long id,
			@ModelAttribute final AnalogNoguchiInputForm analogNoguchiInputForm) {

		//IDをキーにAnalogMainテーブルを検索する
		AnalogMainNoguchi analogMainNoguchi = analogNoguchiService.getAnalog(id);

		//フォームにレコードの値をセットする
		analogNoguchiInputForm.initWithAnalogMainNoguchi(analogMainNoguchi);
		return "analog/update";
	}

	/**
	 * AnalogMainテーブルのデータを更新して検索画面に遷移する
	 * 
	 * @param AnalogNoguchiInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合、更新画面に
	 *          ない場合、検索画面のパス
	 */
	@PostMapping(value = "update")
	public String updateAnalog(@Validated final AnalogNoguchiInputForm form, final BindingResult bindingResult) {

		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合、自画面に戻る
			return "analog/update";
		}

		//データを更新する
		AnalogMainNoguchi analogMainNoguchi = analogNoguchiService.updateAnalog(form);

		if (analogMainNoguchi == null) {

			//更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/analog?result=updatefailed";
		}

		return "redirect:/analog?result=update&id=" + analogMainNoguchi.getId();
	}

	/**
	 * AnalogMainテーブルのレコードを論理削除して検索画面に遷移する
	 * 
	 * @param long id
	 * @return 検索画面のパス
	 */
	@GetMapping("delete")
	public String deleteAnalog(@RequestParam(name = "id") final long id) {

		//IDをキーにレコードを論理削除する
		analogNoguchiService.deleteAnalogById(id);
		return "redirect:/analog?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 * 
	 * @param AnalogNoguchiSearchForm form
	 * @param AnalogNoguchiDeleteForm analogNoguchiDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@GetMapping(value = "deletecomp")
	public String showDeleteCompAnalog(final AnalogNoguchiSearchForm form,
			@ModelAttribute final AnalogNoguchiDeleteForm analogNoguchiDeleteForm, final Model model) {

		//AnalogMainテーブルから削除フラグが1のレコードを検索する
		final List<AnalogMainNoguchi> analogList = analogNoguchiService.getListAnalog(form);

		//Modelに検索結果を格納する
		model.addAttribute("analogList", analogList);
		return "analog/deletecomp";
	}

	/**
	 * AnalogMainテーブルのデータを完全に削除して検索画面に遷移する
	 * 
	 * @param AnalogNoguchiDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合、完全削除画面に
	 *          ない場合、検索画面のパス
	 */
	@PostMapping(value = "deletecomp")
	public String deleteCompAnalog(@Validated final AnalogNoguchiDeleteForm form, final BindingResult bindingResult,
			final Model model) {

		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合、再検索して自画面に戻る
			AnalogNoguchiSearchForm analogNoguchiSearchForm = new AnalogNoguchiSearchForm();
			analogNoguchiSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<AnalogMainNoguchi> analogList = analogNoguchiService.getListAnalog(analogNoguchiSearchForm);

			//Modelに検索結果を格納する
			model.addAllAttributes(analogList);
			return "analog/deletecomp";
		}

		//データを完全に削除する
		analogNoguchiService.deleteAnalogComp(form.getDeleteIds());
		return "redirect:/analog?result=deletecomp";
	}
}
