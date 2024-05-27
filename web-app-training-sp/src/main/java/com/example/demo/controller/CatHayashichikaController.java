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
import com.example.demo.model.catHayashichika.CatMainHayashichika;
import com.example.demo.model.catHayashichika.FromHayashichika;
import com.example.demo.model.catHayashichika.SizeHayashichika;
import com.example.demo.model.catHayashichika.TypeHayashichika;
import com.example.demo.model.form.catHayashichika.CatHayashichikaDeleteForm;
import com.example.demo.model.form.catHayashichika.CatHayashichikaInputForm;
import com.example.demo.model.form.catHayashichika.CatHayashichikaSearchForm;
import com.example.demo.service.CatHayashichikaService;

/**
 * CatHayashichikaのコントローラークラス 
 * @author future
 */

@Controller
@RequestMapping(value = "/catHayashichika")
public class CatHayashichikaController {

	/**猫のサービス*/
	private final CatHayashichikaService catHayashichikaService;

	/**
	 * コンストラクタ
	 * @param CatHayashichikaService catHayashichikaService
	 */
	
	public CatHayashichikaController(final CatHayashichikaService catHayashichikaService) {
		this.catHayashichikaService = catHayashichikaService;
	}

	/**
	 * 毛種のエンティティリストを取得する
	 * @return TypeHayashichikaのリスト
	 */
	
	@ModelAttribute
	public List<TypeHayashichika> getListTypeHayashichika() {
		return catHayashichikaService.getListTypeHayashichika();
	}

	/**
	 * 体型のエンティティリストを取得する
	 * @return SizeHayashichikaのリスト
	 */
	
	@ModelAttribute
	public List<SizeHayashichika> getListsiSizeHayashichika() {
		return catHayashichikaService.getListSizeHayashichika();
	}

	/**
	 * 原産国のエンティティリストを取得する
	 * @return fromHayashichikaEntityのリスト
	 */
	
	@ModelAttribute
	public List<FromHayashichika> getListFromHayashichika() {
		return catHayashichikaService.getListFromHayashichika();
	}

	/**検索画面に遷移する
	 * 
	 * @param CatHayashichikaSearchForm catHayashichikaSearchForm
	 * @return 検索画面のパス
	 */
	
	@GetMapping(value = "")
	public String showSearchCat(@ModelAttribute final CatHayashichikaSearchForm catHayashichikaSearchForm) {
		return "catHayashichika/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 * @param CatHayashichikaSearchForm form
	 * @param Model model
	 * @param Pageble pageble
	 * @return 検索画面のパス
	 */
	
	@PostMapping(value = "search")
	public String searchCat(final CatHayashichikaSearchForm form, final Model model, final Pageable pageable) {

		//入力された検索条件を元にレコードを取得する
		final Page<CatMainHayashichika> catList = catHayashichikaService.getPageCat(form, pageable);
		if (catList.getTotalElements() != 0) {
			
			//検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", catList);
			model.addAttribute("catList", catList.getContent());
			model.addAttribute("url", "search");
		}
		return "catHayashichika/search";
	}

	/**
	 * 追加画面に遷移する
	 * @param CatHayashichikaInputForm catHayashichikaInputForm
	 * @return 追加画面のパス
	 */
	
	@GetMapping(value = "insert")
	public String showInsertCat(@ModelAttribute final CatHayashichikaInputForm catHayashichikaInputForm) {
		return "catHayashichika/insert";
	}

	/**
	 * CatMainテーブルにデータを登録して検索画面に遷移する
	 * @param CatHayashichikaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	
	@PostMapping(value = "insert")
	public String insertCat(@ModelAttribute @Validated final CatHayashichikaInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合自画面に戻る
			return "catHayashichika/insert";
		}
		
		//データを登録する
		final CatMainHayashichika catMain = catHayashichikaService.insertCat(form);
		return "redirect:/catHayashichika?result=insert&id=" + catMain.getId();
	}

	/**
	 * 更新画面に遷移する
	 * @param long id
	 * @param CatHayashichikaInputForm catHayashichikaInputForm
	 * @return 更新画面のパス
	 */
	
	@GetMapping(value = "update")
	public String showUpdateCat(@RequestParam(name = "id") final long id,
			@ModelAttribute final CatHayashichikaInputForm catHayashichikaInputForm) {

		//IDをキーにCatMainテーブルを検索する
		CatMainHayashichika catMain = catHayashichikaService.getCat(id);

		//フォームにレコードの値をセットする
		catHayashichikaInputForm.initWithCatMain(catMain);
		return "catHayashichika/update";
	}

	/**
	 * CatMainHayashichikaテーブルのデータを更新して検索画面に遷移する
	 * @param CatHayashichikaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	
	@PostMapping(value = "update")
	public String updateCat(@Validated final CatHayashichikaInputForm form, final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {
			//入力エラーがある場合自画面に戻る
			return "catHayashichika/update";
		}
		
		//データを更新する
		CatMainHayashichika catMain = catHayashichikaService.updateCat(form);
		if (catMain == null) {
			
		//更新が失敗した場合、検索画面にメッセージを表示する。
			return "redirect:/catHayashichika?result=updatefailed";
		}
		return "redirect:/catHayashichika?result=update&id=" + catMain.getId();
	}

	/**
	 * CatMainHayashichikaテーブルのレコードを論理削除して検索画面に遷移する
	 * @param long id
	 * @return 検索画面のパス
	 */
	
	@GetMapping("delete")
	public String deleteCat(@RequestParam(name = "id") final long id) {
		//IDをキーにレコードを倫理削除する
		catHayashichikaService.deleteCatById(id);
		return "redirect:/catHayashichika?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
 	 * @param CatHayashichikaSearchForm form
	 * @param CatHayashichikaDeleteForm catHayashichikaDeleteForm
	 * @param Model model
	 * @ret
	 * urn 完全削除画面のパス
	 */
	
	@GetMapping(value = "deletecomp")
	public String showDeleteCompCat(final CatHayashichikaSearchForm form,
			@ModelAttribute final CatHayashichikaDeleteForm catHayashichikaDeleteForm, final Model model) {

		//CatMainテーブルから削除フラグが1のレコードを検索する
		final List<CatMainHayashichika> catList = catHayashichikaService.getListCat(form);

		//Modelに検索結果を格納する
		model.addAttribute(catList);
		return "catHayashichika/deletecomp";
	}

	/**
	 * CatMainHayashichikaのテーブルデータを完全削除して検索画面に遷移する
	 * @param CatHayashichikaDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	
	@PostMapping(value = "deletecomp")
	public String deleteCompCat(@Validated final CatHayashichikaDeleteForm form, final BindingResult bindingResult,
			final Model model) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合、再検索して自画面に戻る
			CatHayashichikaSearchForm catHayashichikaSearchForm = new CatHayashichikaSearchForm();
			catHayashichikaSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<CatMainHayashichika> catList = catHayashichikaService.getListCat(catHayashichikaSearchForm);

			//Modelに検索結果を格納する
			model.addAttribute(catList);
			return "catHayashichika/deletecomp";
		}
		
		//データを完全削除する
		catHayashichikaService.deleteCatComp(form.getDeleteIds());
		return "redirect:/catHayashichika?result=deletecomp";
	}
}
