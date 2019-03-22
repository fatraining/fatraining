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
import jp.co.futureantiques.webapptraining.model.catNihonyanagi.CatMainNihonyanagi;
import jp.co.futureantiques.webapptraining.model.catNihonyanagi.CharacterNihonyanagi;
import jp.co.futureantiques.webapptraining.model.catNihonyanagi.HairNihonyanagi;
import jp.co.futureantiques.webapptraining.model.catNihonyanagi.SizeNihonyanagi;
import jp.co.futureantiques.webapptraining.model.form.catNihonyanagi.CatDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.catNihonyanagi.CatInputForm;
import jp.co.futureantiques.webapptraining.model.form.catNihonyanagi.CatSearchForm;
import jp.co.futureantiques.webapptraining.service.CatNihonyanagiService;

/**
 * Catのコントローラークラス
 * @author Nihonyanagi
 *
 */
@Controller
@RequestMapping(value = "/cat")
public class CatNihonyanagiController {

	/** ネコのサービス */
	private final CatNihonyanagiService catNihonyanagiService;

	/**
	 * コンストラクタ
	 *
	 * @param CatNihonyanagiService catNihonyanagiService
	 */
	@Autowired
	public CatNihonyanagiController(final CatNihonyanagiService catNihonyanagiService){
		this.catNihonyanagiService = catNihonyanagiService;
	}

	/**
	 * 被毛エンティティのリストを取得する
	 * @return HairEntityのリスト
	 */
	@ModelAttribute
	public List<HairNihonyanagi> getListHairNihonyanagi(){
		return catNihonyanagiService.getListHairNihonyanagi();
	}

	/**
	 * 大きさエンティティのリストを取得する
	 * @return SizeEnthityのリスト
	 */
	@ModelAttribute
	public List<SizeNihonyanagi> getListCatNihonyanagi(){
		return catNihonyanagiService.getListSizeNihonyanagi();
	}

	/**
	 * 性格エンティティのリストを取得する
	 * @return SizeEntityのリスト
	 */
	@ModelAttribute
	public List<CharacterNihonyanagi> getListCharacterNihonyanagi(){
		return catNihonyanagiService.getListCharacterNihonyanagi();
	}



	/**
	 * 検索画面に遷移する
	 * @param CatSearchForm catSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value="",method=RequestMethod.GET)
	public String showSearchCat(@ModelAttribute final CatSearchForm catSearchForm) {
		return "catnihonyanagi/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @para CatSearchForm
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchCat(final CatSearchForm form, final Model model, final Pageable pageable) {

		//入力された検索条件をもとにレコードを取得する
		final Page<CatMainNihonyanagi> catList = catNihonyanagiService.getPageCat(form, pageable);
		if(catList.getTotalElements() != 0) {

			//検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page",catList);
			model.addAttribute("catList",catList.getContent());
			model.addAttribute("url","search");
		}
		return "catnihonyanagi/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param CatInputForm catInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert",method = RequestMethod.GET)
	public String showInsertCat(@ModelAttribute final CatInputForm catInputForm) {
		return "catnihonyanagi/insert";
	}

	/**
	 * CatMainテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param CatInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert",method = RequestMethod.POST)
	public String insertCat(@ModelAttribute @Validated final CatInputForm form, final BindingResult bindingResult){
		if(bindingResult.hasFieldErrors()) {

			//入力エラーがある場合自画面に戻る
			return "catnihonyanagi/insert";
		}

		//データを登録する
		final CatMainNihonyanagi catMainNihonyanagi = catNihonyanagiService.insertCat(form);
		return "redirect:/cat?result=insert&id=" + catMainNihonyanagi.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param CatInputForm catInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update",method = RequestMethod.GET)
	public String showUpdateCat(@RequestParam(name = "id") final long id,
			@ModelAttribute final CatInputForm catInputForm) {

		//IDをキーにCatMainNihonyanagiテーブルを検索する
		CatMainNihonyanagi catMainNihonyanagi = catNihonyanagiService.getCat(id);

		//フォームにレコードの値をセットする
		catInputForm.initWithCatMainNihonyanagi(catMainNihonyanagi);
		return "catnihonyanagi/update";
	}

	/**
	 * CatMainNihonyanagiテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param CatInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update",method = RequestMethod.POST)
	public String updateCat(@Validated final CatInputForm form,
			final BindingResult bindingResult) {
		if(bindingResult.hasFieldErrors()) {

			//入力エラーがある場合自画面に戻る
			return "catnihonyanagi/update";
		}

		//データを更新する
		CatMainNihonyanagi catMainNihonyanagi = catNihonyanagiService.updateCat(form);
		if(catMainNihonyanagi == null) {

			//更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/cat?result=updatefailed";
		}
		return "redirect:/cat?result=update&id=" + catMainNihonyanagi.getId();
	}

	/**
	 * CatMainNihonyanagiテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete",method = RequestMethod.GET)
	public String deleteCat(@RequestParam(name = "id") final long id) {

		//IDをキーにレコードを論理削除する
		catNihonyanagiService.deleteCatById(id);
		return "redirect:/cat?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param CatSearchForm form
	 * @param CatDeleteForm catDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp",method = RequestMethod.GET)
	public String showDeleteCompCat(final CatSearchForm form,
			@ModelAttribute final CatDeleteForm catDeleteForm,final Model model) {

		//CatMainNihonyanagiテーブルから削除フラグが1のレコードを検索する
		final List<CatMainNihonyanagi> catList = catNihonyanagiService.getListCat(form);

		//Modelに検索結果を格納する
		model.addAttribute(catList);
		return "catnihonyanagi/deletecomp";
	}

	/**
	 * CatNihonyanagiMainテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param CatDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp",method = RequestMethod.POST)
	public String deleteCompCat(@Validated final CatDeleteForm form,
			final BindingResult bindingResult, final Model model) {

		if(bindingResult.hasFieldErrors()) {

			//	入力エラーがある場合、再検索して自画面に戻る
			CatSearchForm catSearchForm = new CatSearchForm();
			catSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<CatMainNihonyanagi> catList = catNihonyanagiService.getListCat(catSearchForm);

			//Modelに検索結果を格納する
			model.addAttribute(catList);
			return "catnihonyanagi/deletecomp";
		}

		//データを完全削除する
		catNihonyanagiService.deleteCatComp(form.getDeleteIds());
		return "redirect:/cat?result=deletecomp";
	}
}
