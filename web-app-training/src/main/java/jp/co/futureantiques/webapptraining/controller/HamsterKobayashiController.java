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
import jp.co.futureantiques.webapptraining.model.TypeKobayashi.GraduateKobayashi;
import jp.co.futureantiques.webapptraining.model.TypeKobayashi.HamsterMainKobayashi;
import jp.co.futureantiques.webapptraining.model.TypeKobayashi.TypeKobayashi;
import jp.co.futureantiques.webapptraining.model.form.hamsterKobayashi.HamsterKobayashiDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.hamsterKobayashi.HamsterKobayashiInputForm;
import jp.co.futureantiques.webapptraining.model.form.hamsterKobayashi.HamsterKobayashiSearchForm;
import jp.co.futureantiques.webapptraining.service.HamsterKobayashiService;

//Hamsterkobayashiのコントローラークラス

@Controller
@RequestMapping(value = "/hamsterKobayashi")
public class HamsterKobayashiController {

	private final HamsterKobayashiService hamsterKobayashiService;

	//コンストラクタ

	@Autowired
	public HamsterKobayashiController(final HamsterKobayashiService hamsterKobayashiService) {
		this.hamsterKobayashiService = hamsterKobayashiService;
	}

	//種類エンティティのリストを取得する

	@ModelAttribute
	public List<TypeKobayashi> getListTypeKobayashi(){
		return hamsterKobayashiService.getListTypeKobayashi();
	}

	//出身エンティティのリストを取得する

	@ModelAttribute
	public List<GraduateKobayashi> getListGraduateKobayashi(){
		return hamsterKobayashiService.getListGraduateKobayashi();
	}

	//検索画面に遷移する

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchHamster(@ModelAttribute final HamsterKobayashiSearchForm hamsterKobayashiSearchForm) {
		return "HamsterKobayashi/search";
	}

	//検索結果を取得して検索画面に遷移する

	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchHamster(final HamsterKobayashiSearchForm form, final Model model, final Pageable pageable) {

		//入力された検索条件を元にレコードを取得する
		final Page<HamsterMainKobayashi>hamsterList = hamsterKobayashiService.getPageHamster(form,pageable);
		if(hamsterList.getTotalElements() != 0) {

			//検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", hamsterList);
			model.addAttribute("hamsterList", hamsterList.getContent());
			model.addAttribute("url", "search");
		}
		return "hamsterKobayashi/search";
	}

		//追加画面に遷移する

		@RequestMapping(value = "insert", method = RequestMethod.GET)
		public String showInsertHamster(@ModelAttribute final HamsterKobayashiInputForm hamsterKobayashiInputForm) {
			return "hamsterKobayashi/insert";
		}

		//HamsterMainKobayashiテーブルにデータを登録して検索画面に遷移する

		@RequestMapping(value = "insert", method = RequestMethod.POST)
		public String insertHamster(@ModelAttribute @Validated final HamsterKobayashiInputForm form,
				final BindingResult bindingResult) {
			if(bindingResult.hasFieldErrors()) {

				//入力エラーがある場合自画面に戻る
				return "hamsterKobayashi/insert";
			}
			//データを登録する
			final HamsterMainKobayashi hamsterMainKobayashi = hamsterKobayashiService.insertHamster(form);
			return "redirect:/hamsterKobayashi?result=insert&id=" + hamsterMainKobayashi.getId();
		}

		//更新画面に遷移する

		@RequestMapping(value = "updaate", method = RequestMethod.GET)
		public String showUpdateHamster(@RequestParam(name = "id")final long id,
				@ModelAttribute final HamsterKobayashiInputForm hamsterKobayashiInputForm) {

			//IDをキーにHamsterMainKobayashiテーブルを検索する
			HamsterMainKobayashi hamsterMainKobayashi = hamsterKobayashiService.getHamster(id);

			//フォームにレコードの値をセットする
			hamsterKobayashiInputForm.initWithHamsterMainKobayashi(hamsterMainKobayashi);
			return "hamsterKobayashi/update";
		}

		//HamsterMainKobayashiテーブルのデータを更新して検索画面に遷移する

		@RequestMapping(value = "update", method = RequestMethod.POST)
		public String updateHamster(@Validated final HamsterKobayashiInputForm form,
				final BindingResult bindingResult) {
			if(bindingResult.hasFieldErrors()) {

				//入力エラーがある場合自画面に戻る
				return "hamsterKobayashi/update";
			}
			//データを更新する
			HamsterMainKobayashi hamsterMainKobayashi = hamsterKobayashiService.updateHamster(form);
			if(hamsterMainKobayashi == null) {

				//更新が失敗した場合、検索画面にメッセージを表示する
				return "redirect:/hamsterKobayashi?result=updatefailed";
			}
			return "redirect:/hamsterKobayashi?result=update&id=" + hamsterMainKobayashi.getId();
		}

		//HamsterMainKobayashiテーブルのレコードを論理削除して検索画面に遷移する

		@RequestMapping(value = "delete",method = RequestMethod.GET)
		public String deleteHamster(@RequestParam(name = "id")final long id) {

			//IDをキーにレコードを論理削除する
			hamsterKobayashiService.deleteHamsterById(id);
			return "redirect:/hamsterKobayashi?result=delete&id=" + id;

		}

		//完全削除画面に遷移する

		@RequestMapping(value = "deletecomp", method =RequestMethod.GET)
		public String showDeleteCompHamster(final HamsterKobayashiSearchForm form,
				@ModelAttribute final HamsterKobayashiDeleteForm hamsterKobayashiDeleteForm,final Model model) {


				//HamsterMainKobayashiテーブルから削除フラグが1のレコードを検索する
		final List<HamsterMainKobayashi> hamsterList = hamsterKobayashiService.getListHamster(form);

				//Modelに検索結果を格納する
				model.addAttribute(hamsterList);
				return "hamsterKobayashi/deletecomp";

	}


		//HamsterMainKobayashiテーブルのデータを完全削除して検索画面に遷移する

		@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
		public String deleteCompHamster(@Validated final HamsterKobayashiDeleteForm form,
				final BindingResult bindingResult, final Model model) {
			if(bindingResult.hasFieldErrors()) {

				//入力エラーがある場合、再検索して自画面に戻る
				HamsterKobayashiSearchForm hamsterKobayashiSearchForm = new HamsterKobayashiSearchForm();
				hamsterKobayashiSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
				final List<HamsterMainKobayashi> hamsterList = hamsterKobayashiService.getListHamster(hamsterKobayashiSearchForm);

				//Modelに検索結果を格納する
				model.addAttribute(hamsterList);
				return "hamsterKobayashi/deletecomp";
}

			//データを完全削除する
			hamsterKobayashiService.deleteHamsterComp(form.getDeleteIds());
			return "redirect:/hamsterKobayashi?result=deietecomp";

		}

}
