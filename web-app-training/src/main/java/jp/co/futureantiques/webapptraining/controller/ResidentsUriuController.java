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
import jp.co.futureantiques.webapptraining.model.form.residentsUriu.ResidentsUriuDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.residentsUriu.ResidentsUriuInputForm;
import jp.co.futureantiques.webapptraining.model.form.residentsUriu.ResidentsUriuSearchForm;
import jp.co.futureantiques.webapptraining.model.residentsUriu.AnimalUriu;
import jp.co.futureantiques.webapptraining.model.residentsUriu.ResidentsMainUriu;
import jp.co.futureantiques.webapptraining.model.residentsUriu.TypeUriu;
import jp.co.futureantiques.webapptraining.service.ResidentsUriuService;

/**
 * ResidentsUriuのコントローラークラス
 *
 */

@Controller
@RequestMapping(value="/residentsUriu")
public class ResidentsUriuController {

	/** 住人のサービス */
	private final ResidentsUriuService residentsUriuService;

	/**
	 * コンストラクタ
	 *
	 * @param ResidentsUriuService residentsUriuService
	 */

	@Autowired
	public ResidentsUriuController(final ResidentsUriuService residentsUriuService) {
		this.residentsUriuService = residentsUriuService;
	}

	/**
	 * TypeUriuエンティティのリストを取得する
	 *
	 * @return TypeUriuEntityのリスト
	 */
	@ModelAttribute
	public List<TypeUriu> getListTypeUriu(){
		return residentsUriuService.getListTypeUriu();
	}

	/**
	 * AnimalUriuEntityのリストを取得する
	 *
	 * @return AnimalUriuEntityのリスト
	 */
	@ModelAttribute
	public List<AnimalUriu> getListAnimalUriu(){
		return residentsUriuService.getListAnimalUriu();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param ResidentsUriuSearchForm residentsUriuSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchResidentsUriu(@ModelAttribute final ResidentsUriuSearchForm residentsUriuSearchForm) {
		return "residentsUriu/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param ResidentsUriuSearchForm form
	 * @param Residents residents
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value="search",method=RequestMethod.POST)
	public String searchResidentsUriu(final ResidentsUriuSearchForm form,final Model model,final Pageable pageable) {
		// 入力された検索条件を元にレコードを取得する
		final Page<ResidentsMainUriu> residentsUriuList = residentsUriuService.getPageResidentsUriu(form,pageable);
		if(residentsUriuList.getTotalElements()!=0) {
			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page",residentsUriuList);
			model.addAttribute("residentsUriuList",residentsUriuList.getContent());
			model.addAttribute("url","search");
		}
		return "residentsUriu/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param ResidentsUriuInputForm residentsUriuInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value="insert",method=RequestMethod.GET)
	public String showInsertResidentsUriu(@ModelAttribute final ResidentsUriuInputForm residenstUriuInputForm) {
		return "residentsUriu/insert";
	}

	/**
	 * ResidentsMainUriuテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param ResidentsUriuInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */

	@RequestMapping(value="insert",method=RequestMethod.POST)
	public String insertResidentsUriu(@ModelAttribute @Validated final ResidentsUriuInputForm form,final BindingResult bindingResult) {
		if(bindingResult.hasFieldErrors()) {
			// 入力エラーがある場合自画面に戻る
			return "residentsUriu/insert";
		}
		// データを登録する
		final ResidentsMainUriu residentsMainUriu = residentsUriuService.insertResidentsUriu(form);
		return "redirect:/residentsUriu?result=insert&id=" + residentsMainUriu.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param ResidentsUriuInputForm residentsUriuInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value="update",method=RequestMethod.GET)
	public String showUpdateResidentsUriu(@RequestParam(name="id")final long id,@ModelAttribute final ResidentsUriuInputForm residentsUriuInputForm) {
		// IDをキーにResidentsMainUriuテーブルを検索する
		ResidentsMainUriu residentsMainUriu = residentsUriuService.getResidentsUriu(id);
		// フォームにレコードの値をセットする
		residentsUriuInputForm.initWithResidentsMainUriu(residentsMainUriu);
		return "residentsUriu/update";
	}

	/**
	 * ResidentsMainUriuテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param ResidentsUriuInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateResidentsUriu(@Validated final ResidentsUriuInputForm form,final BindingResult bindingResult) {
		if(bindingResult.hasFieldErrors()) {
			// 入力エラーがある場合自画面に戻る
			return "residentsUriu/update";
		}

		// データを更新する
		ResidentsMainUriu residentsMainUriu = residentsUriuService.updateResidentsUriu(form);
		if(residentsMainUriu==null) {
			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/residentsUriu?result=updatefailed";
		}
		return "redirect:/residentsUriu?result=update&id=" + residentsMainUriu.getId();
	}

	/**
	 * Residentsテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String deleteResidentsUriu(@RequestParam(name="id")final long id) {
		// IDをキーにしてレコードを論理削除する
		residentsUriuService.deleteResidentsUriuById(id);
		return "redirect:/residentsUriu?result=delete&id=" + id;
	}


	/**
	 * 完全削除画面に遷移する
	 *
	 * @param ResidentsUriuSearchForm form
	 * @param ResidentsUriuDeleteForm residentsUriuDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value="deletecomp",method=RequestMethod.GET)
	public String showDeleteCompResidentsUriu(final ResidentsUriuSearchForm form,@ModelAttribute final ResidentsUriuDeleteForm residentsUriuDeleteForm,final Model model) {
		// ResidentsMainUriuテーブルから削除フラグが1のレコードを検索する
		final List<ResidentsMainUriu> residentsUriuList = residentsUriuService.getListResidentsUriu(form);
		// Modelに検索結果を格納する
		model.addAttribute(residentsUriuList);
		return "residentsUriu/deletecomp";
	}

	/**
	 * ResidentsMainUriuテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param ResidentsUriuDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value="deletecomp",method=RequestMethod.POST)
	public String deleteCompResidentsUriu(@Validated final ResidentsUriuDeleteForm form,final BindingResult bindingResult,final Model model) {
		if(bindingResult.hasFieldErrors()) {
			// 入力エラーがある場合、再検索して自画面に戻る
			ResidentsUriuSearchForm residentsUriuSearchForm = new ResidentsUriuSearchForm();
			residentsUriuSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<ResidentsMainUriu> residentUriuList = residentsUriuService.getListResidentsUriu(residentsUriuSearchForm);
			// Modelに検索結果を格納する
			model.addAttribute(residentUriuList);
			return "residentsUriu/deletecomp";
		}

		// データを完全削除する
		residentsUriuService.deleteResidentsUriuComp(form.getDeleteIds());
		return "redirect:/residentsUriu?result=deletecomp";
	}

}
