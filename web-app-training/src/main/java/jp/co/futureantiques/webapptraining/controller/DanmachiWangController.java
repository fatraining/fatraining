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
import jp.co.futureantiques.webapptraining.model.DanmachiWang.DanmachiMain;
import jp.co.futureantiques.webapptraining.model.DanmachiWang.Fami;
import jp.co.futureantiques.webapptraining.model.DanmachiWang.Race;
import jp.co.futureantiques.webapptraining.model.form.DanmachiWang.DanmachiDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.DanmachiWang.DanmachiInputForm;
import jp.co.futureantiques.webapptraining.model.form.DanmachiWang.DanmachiSearchForm;
import jp.co.futureantiques.webapptraining.service.DanmachiService;

/**
 * Danmachiのコントローラークラス
 *
 * @author Wang
 */
@Controller
@RequestMapping(value = "/danmachiWang")
public class DanmachiWangController {


	/**ダンまちのサービス*/
	private final DanmachiService danmachiService;

	/**
	 * コンストラクタ
	 *
	 * @param DanmachiService danmachiService
	 */
	@Autowired
	public DanmachiWangController(final DanmachiService danmachiService) {
		this.danmachiService = danmachiService;
	}

/*	@Autowired
	private DanmachiRepository danmachiRepository;*/

	/**
	 * ファミリアエンティティのリストを取得する
	 *
	 * @return Famiのリスト
	 */
	@ModelAttribute
	public List<Fami> getListFami() {
		return danmachiService.getListFami();
	}

	/**
	 * 種族エンティティのリストを取得する
	 *
	 * @return Raceのリスト
	 */
	@ModelAttribute
	public List<Race> getListRace() {
		return danmachiService.getListRace();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param DanmachiSearchForm dSearchFrom
	 * @return 検索画面のパス
	 */

/*	@GetMapping("")
	public String find() {

		List<DanmachiMain> danmachiMain = danmachiRepository.findAll();
		System.out.println("================================================");
		System.out.println(danmachiMain);
		System.out.println("================================================");
		return "danmachiWang/search";
	}*/

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearch(@ModelAttribute final DanmachiSearchForm danmachiSearchForm) {
		return "danmachiWang/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param DanmachiSearchForm
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */

	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchDanmachi(final DanmachiSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<DanmachiMain> DanmachiList = danmachiService.getPageDanmachi(form, pageable);
		if (DanmachiList.getTotalElements() != 0) {

			// 検索結果がある場合はModelに結果をセットする
			model.addAttribute("page", DanmachiList);
			model.addAttribute("DanmachiList", DanmachiList.getContent());
			model.addAttribute("url", "search");
		}
		return "danmachiWang/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param DanmachiInputForm dInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertDanmachi(@ModelAttribute final DanmachiInputForm danmachiInputForm) {
		return "danmachiWang/insert";
	}

	/**
	 * Danmachiテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param DanmachiInputForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合追加画面、ない場合は検索画面のパス
	 */

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertDanmachi(@ModelAttribute @Validated final DanmachiInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "danmachiWang/insert";
		}

		// データを登録する
		final DanmachiMain d = danmachiService.insertDanmachi(form);
		return "redirect:/danmachiWang?result=insert&id=" + d.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param DanmachiInputForm dInputForm
	 * @return 更新画面のパス
	 */

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateDanmachi(final DanmachiSearchForm form, @RequestParam(name = "id") final long id,
			@ModelAttribute final DanmachiInputForm danmachiInputForm,
			Model model, final Pageable pageable) {

		// IDをキーにDanmachiテーブルを検索する
		DanmachiMain danmachimain = danmachiService.getDanmachi(id);

		// フォームにレコードの値をセットする
		danmachiInputForm.initWithDanmachi(danmachimain);
		return "danmachiWang/update";
	}

	/**
	 * Danmachiテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param DanmachiInputFormform
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateDanmachi(@Validated final DanmachiInputForm form,Model model,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "danmachiWang/update";
		}

		//delflg判定
		DanmachiMain danmachiMainGetDanmachi = danmachiService.getDanmachi(form.getId());
		if (Integer.parseInt(danmachiMainGetDanmachi.getDelFlg()) ==1) {
			return "redirect:/danmachiWang?result=updatedelete&id=" + danmachiMainGetDanmachi.getId();
		}
		// データを更新する
		DanmachiMain danmachiMain = danmachiService.updateDanmachi(form);
		if(danmachiMain == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示をする
			return "redirect:/danmachiWang?result=updatefailed";
		}
		return "redirect:/danmachiWang?result=update&id=" + danmachiMain.getId();
	}
	/**
	 * Danmachiテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteDanmachi(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		danmachiService.deleteDanmachiById(id);
		return "redirect:/danmachiWang?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param DanmachiSearchForm form
	 * @param DanmachiDeleteForm dDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompDanmachi(final DanmachiSearchForm form,
			@ModelAttribute final DanmachiDeleteForm dDeleteForm, final Model model) {

		// Danmachiテーブルから削除フラグが1のレコードを検索する
		final List<DanmachiMain> DanmachiList = danmachiService.getListDanmachi(form);

		// Modelに検索結果を格納する
		model.addAttribute(DanmachiList);
		return "danmachiWang/deletecomp";
	}

	/**
	 * Danmachiテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param DanmachiDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */

	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompDanmachi(@Validated final DanmachiDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			DanmachiSearchForm danmachiSearchForm = new DanmachiSearchForm();
			danmachiSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<DanmachiMain> DanmachiList = danmachiService.getListDanmachi(danmachiSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(DanmachiList);
			return "danmachiWang/deletecomp";
		}

		// データを完全削除する
		danmachiService.deleteDanmachiComp(form.getDeleteIds());
		return "redirect:/danmachiWang?result=deletecomp";
	}
}
