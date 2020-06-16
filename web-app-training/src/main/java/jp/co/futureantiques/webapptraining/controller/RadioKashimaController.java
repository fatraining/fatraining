package jp.co.futureantiques.webapptraining.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.form.radioKashima.RadioKashimaDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.radioKashima.RadioKashimaInputForm;
import jp.co.futureantiques.webapptraining.model.form.radioKashima.RadioKashimaSearchForm;
import jp.co.futureantiques.webapptraining.model.radioKashima.KeystationKashima;
import jp.co.futureantiques.webapptraining.model.radioKashima.RadioMainKashima;
import jp.co.futureantiques.webapptraining.service.RadioKashimaService;

/* RadioKashimaのコントローラークラス
* @author kashima
*
*/
@Controller
@RequestMapping(value = "/radiokashima")
public class RadioKashimaController {

	 @Autowired
	  HttpSession session;

	/** ラジオ番組のサービス**/
	private final RadioKashimaService radioKashimaService;

	/**
	 * コンストラクタ
	 * @param RadioKashimaService radioKashimaService
	 */
	@Autowired
	public RadioKashimaController(final RadioKashimaService radioKashimaService) {
		this.radioKashimaService = radioKashimaService;
	}


	@ModelAttribute
	public List<KeystationKashima> getListkeystationKashima() {
		return radioKashimaService.getListKeystationKashima();
	}

	/**
	 * 放送局エンティティのリストを取得する
	 *
	 * @return Entitiyのリスト
	 */
	/**
	 * 検索画面に遷移する
	 *
	 * @param RadioKashimaSearchForm radioKashimaSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSeachRadioKashima(@ModelAttribute final RadioKashimaSearchForm radioKashimaSearchFrom) {
		session.setAttribute("user","新規");
		return "radiokashima/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param RadioKashimaSearchFrom form
	 * @param Model model
	 * @param Pageable Pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String seachRadioKashima(final RadioKashimaSearchForm form, final Model model,
				final  @PageableDefault(page = 0, value = 10 )Pageable pageable) {

		//入力された検索条件を元にレコードを取得する
		final Page<RadioMainKashima> radioList = radioKashimaService.getPageRadioKashima(form, pageable);
		if (radioList.getTotalElements() != 0) {

			//検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", radioList);
			model.addAttribute("radioList", radioList.getContent());
			model.addAttribute("url", "search");
		}
		return "radioKashima/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param RadioKashimaInputForm radioKashimaInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertRadioKashima(@ModelAttribute final RadioKashimaInputForm radioKashimaInputForm) {
		return "radiokashima/insert";
	}

	/**
	 *
	 *
	 * @param RadioKashimaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String inserRadioKashima(@ModelAttribute @Validated final RadioKashimaInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			//入力値エラーなら、自画面遷移
			return "radiokashima/insert";
		}

		//データを登録する
		final RadioMainKashima RadioMainKashima = radioKashimaService.insertRadioKashima(form);
		return "redirect:/radiokashima?result=insert&id=" + RadioMainKashima.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param RadioKashimaInputForm radioKashimaInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateRadioKashima(@RequestParam(name = "id") final long id,
			@ModelAttribute final RadioKashimaInputForm radioKashimaInputForm) {

		//IDをキーにRadioMainテーブルを検索
		RadioMainKashima RadioMainKashima = radioKashimaService.getRadioKashima(id);

		//フォームにレコードの値をセットする
		radioKashimaInputForm.iniWithradioMainKashima(RadioMainKashima);
		return "radiokashima/update";
	}

	/**
	 * RadioMainテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param RadioKashimaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合は検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateRadioKashima(@Validated final RadioKashimaInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {

			//入力エラーがある場合自画面に遷移
			return "radiokashima/update";
		}

		//データを更新する
		RadioMainKashima radioMainKashima = radioKashimaService.updateRadioKashima(form);
		if (radioMainKashima == null) {
			//	更新失敗で、検索画面にてメッセージ表示
			return "redirect:/radiokashima?result=updatefailed";
		}
		return "redirect:/radiokashima?result=update&id=" + radioMainKashima.getId();
	}

	/**
	 * RadioMainKashimaテーブルのレコードを論理削除し検索画面に遷移
	 * @param long id
	 * @return 検索画面のぱす
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteRadioKashima(@RequestParam(name = "id") final long id) {
		radioKashimaService.deleteRadioKashimaById(id);
		return "redirect:/radiokashima?result=delete&id=" + id;
	}

	/**
	 * 物理削除画面に遷移
	 *
	 * @param RadioKashimaSearchForm form
	 * @param RadioKashimaDeleteForm radioKashimaDeleteForm
	 * @param Model model
	 * @return 物理削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompRadioKashima(final RadioKashimaSearchForm form,
			@ModelAttribute final RadioKashimaDeleteForm radioKashimaDeleteForm, final Model model) {

		//RadioMainテーブルから削除フラグが1のレコードを検索する
		final List<RadioMainKashima> radioList = radioKashimaService.getListRadioKashima(form);

		//Modelに検索結果を格納
		model.addAttribute(radioList);
		return "radiokashima/deletecomp";
	}

	/**
	 * Radioテーブルのデータを完全削除して検索画面に遷移
	 *
	 * @param RadioKashimaDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合、完全削除画面、ない場合、検索画面のぱす
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompRadioKashima(@Validated final RadioKashimaDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasErrors()) {

			//入力値エラーの場合、再検索して自画面遷移
			RadioKashimaSearchForm radioKashimaSearchForm = new RadioKashimaSearchForm();
			radioKashimaSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<RadioMainKashima> radioList = radioKashimaService.getListRadioKashima(radioKashimaSearchForm);

			//Modelに検索結果を格納
			model.addAttribute(radioList);
			return "radiokashima/deletecomp";
		}
		//データを完全削除する
		radioKashimaService.deleteRadioKashimaComp(form.getDeleteIds());
		return "redirect:/radiokashima?result=deletecomp";
	}
}
