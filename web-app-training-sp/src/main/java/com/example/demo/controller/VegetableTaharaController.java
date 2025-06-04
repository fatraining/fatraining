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
import com.example.demo.model.form.vegetabletahara.VegetableTaharaDeleteForm;
import com.example.demo.model.form.vegetabletahara.VegetableTaharaInputForm;
import com.example.demo.model.form.vegetabletahara.VegetableTaharaSearchForm;
import com.example.demo.model.vegetabletahara.AreaTahara;
import com.example.demo.model.vegetabletahara.CategoryTahara;
import com.example.demo.model.vegetabletahara.VegetableMainTahara;
import com.example.demo.service.VegetableTaharaService;

/**
 * VegetableTaharaのコントローラークラス
 * 
 * 　↓は、作成者名を指定
 * @author future
 * */
 @Controller
                          //「vegetabletahara」を参照
 @RequestMapping(value = "/vegetabletahara")
public class VegetableTaharaController {
	 
	 /**
	  * 使用するサービスの実装？（野菜のサービス）
	  * */
	 private final VegetableTaharaService vegetableTaharaService;
	 
	 /**
	  * コンストラクタ
	  * 
	  * @param VegetableTaharaService vegetableTaharaService
	  * */
	 public VegetableTaharaController(final VegetableTaharaService vegetableTaharaService) {
		 this.vegetableTaharaService = vegetableTaharaService;
	 }
	 
	 /**
	  * カテゴリーエンティティのリストを取得
	  * 
	  * @return CategoryEntityのリスト
	  * */
	 //↓この「@ModelAttribute」は、自動で値をとってきて、「Model」に格納してくれている
	     //更に、「リストの型＋List」というルールに則って命名された変数を用意し、値を取り出してくれてもいる
	 @ModelAttribute
	 public List<CategoryTahara> getListCategory(){
		 return vegetableTaharaService.getListCategory();
	 }
	 
	 /**
	  * 国内最大生産地エンティティのリストを取得
	  * 
	  * @return AreaEntityのリスト
	  * */
	 @ModelAttribute
	 public List<AreaTahara> getListArea(){
		 return vegetableTaharaService.getListArea();		 
	 }
	 
//以下、検索機能	 
	 /**
		 * 検索画面に遷移する　？→つまり初期表示画面のこと
		 *
		 * @param VegetableTaharaSearchForm　form
		 * @return 検索画面のパス
		 */
	                       //↓はつまり、「/vegetabletahara」の後になにも続かないということ
		@GetMapping(value = "")
		public String showSearchVegetable(@ModelAttribute final VegetableTaharaSearchForm vegetableTaharaSearchForm) {
			return "vegetabletahara/search";
		}

		/**
		 * 検索結果を取得して検索画面に遷移する　？
		 *
		 * @param VegetableTaharaSearchForm form
		 * @param Model model
		 * @param Pageable pageable
		 * @return 検索画面のパス
		 */
		@PostMapping(value = "search")
		public String searchVegetable(final VegetableTaharaSearchForm form, final Model model, final Pageable pageable) {

			// 入力された検索条件を元にレコードを取得する
			final Page<VegetableMainTahara> vegetableList = vegetableTaharaService.getPageVegetable(form, pageable);
			if (vegetableList.getTotalElements() != 0) {

				// 検索結果がある場合、Modelに結果をセットする
				model.addAttribute("page", vegetableList);
				model.addAttribute("vegetableList", vegetableList.getContent());
				model.addAttribute("url", "search");
			}
			return "vegetabletahara/search";
		}
	
//以下、追加機能 
	 /**
	  * 追加画面に遷移
	  * 
	  * @param VegetableTaharaInputForm vegetableTaharaInputForm
	  * @return 追加画面の＠パス
	  * */
	 @GetMapping(value = "insert")
	 public String showInsertVegetable(@ModelAttribute final VegetableTaharaInputForm vegetableTaharaInputForm) {
		 return "vegetabletahara/insert";
	 }
	 
	 /**
	  * VegetableMainTaharaテーブルにデータを登録して検索画面に遷移する
	  * 
	  * @param VegetableTaharaInputForm form
	  * @param BindingResult bindingResult
	  * @return 入力エラーがある場合は追加画面、ない場合は検索画面のパス
	  * */
	 @PostMapping(value = "insert")
	 public String insertVegetable(@ModelAttribute @Validated final VegetableTaharaInputForm form, final BindingResult bingResult) {
		 if(bingResult.hasFieldErrors()) {
			 
			 //入力エラーがある場合、自画面に戻る
			 return "vegetabletahara/insert";
		 }
		 
		 //データを登録
		 final VegetableMainTahara vegetableMainTahara = vegetableTaharaService.insertVegetable(form);
		 return "redirect:/vegetabletahara?result=insert&id=" + vegetableMainTahara.getId();
	 }
	 
//以下、更新機能
	 /**
	  * 更新画面に遷移
	  * 
	  * @param long id
	  * @param VegetableTaharaInputForm vegetableTaharaInputForm
	  * @return 更新画面のパス
	  * */
	 @GetMapping(value = "update")
	 public String showUpdateVegetable(@RequestParam(name = "id") final long id,
			 @ModelAttribute final VegetableTaharaInputForm vegetableTaharaInputForm) {
		 
		 //IDをキーにVegetableMainTaharaの値をセット
		 VegetableMainTahara vegetableMainTahara = vegetableTaharaService.getVegetable(id);
		 
		 //フォームにレコードの値をセット
		 vegetableTaharaInputForm.initWithVegetableMainTahara(vegetableMainTahara);
		 return "vegetabletahara/update";
	 }
	 
	 /**
	  * VegetableMainTaharaテーブルのデータを更新して検索画面に遷移
	  * 
	  * @param VegetableTaharaInputForm form
	  * @oaram BindingResult bindingResult
	  * @return 入力エラーがある場合は更新画面、ない場合は検索画面のパス
	  * */
	               //↓のvalue値は、「/vegetabletahara」以降に続くURLを指定している
	 @PostMapping(value = "update")
	 public String updateVegetable(@Validated final VegetableTaharaInputForm form, final BindingResult bindingResult) {
		 if(bindingResult.hasFieldErrors()) {
			 
			 //入力エラーがある場合、自画面に戻る
			 return "vegetabletahara/update";
		 }
		 
		 //データを更新
		 VegetableMainTahara vegetableMainTahara = vegetableTaharaService.updateVegetable(form);
		 if(vegetableMainTahara == null) {
			 
			 //更新が失敗した場合、検索画面にメッセージを表示
			 return "redirect:/vegetabletahara?result=updatefailed";
		 }
		         //↓で、直接URLに飛ぶ    ↓この?以降がパラメータであり、「result」はいわゆる変数名である。また、=以降の「update」は「value値」である
		 return "redirect:/vegetabletahara?result=update&id=" + vegetableMainTahara.getId();
		                                           //なお、↑の＝がなければ、値の代入がなされず、HTML側で参照ができないのでエラーが発生する
	 }
	 
//以下、削除機能
	 /**
	  * VegetableMainTaharaテーブルのレコードを論理削除(ユーザーには消したように見える状態)して検索画面に遷移する
	  * 
	  * @param long id
	  * @return 検索画面のパス
	  * */
	 @GetMapping("delete")                   //「long id = request.getParameter("id")」の意
	 public String deleteVegetable(@RequestParam(name = "id") final long id) {
		 
		 //IDをキーにレコードを論理削除する
		 vegetableTaharaService.deleteVegetableTaharaById(id);
		 return "redirect:/vegetabletahara?result=delete&id=" + id;
	 }
	 
	 /**
	  * 完全削除(DBからも完全に消去する)画面に遷移
	  * 
	  * @param VegetableTaharaSearchForm form
	  * @param VegetableTaharaDeleteForm vegetableTaharaDeleteForm
	  * @param Model model
	  * @return 完全削除画面のパス
	  * */
	 @GetMapping(value = "deletecomp")
	 public String showDeleteCompVegetable(VegetableTaharaSearchForm form,
			 @ModelAttribute final VegetableTaharaDeleteForm vegetableTaharaDeleteForm, final Model model) {
		 
		 //VegetableMainTaharaテーブルから削除フラグの削除がフラグが1のレコードを検索する
		 final List<VegetableMainTahara> vegetableList = vegetableTaharaService.getListVegetable(form);
		 
		 //Modelに検索結果を格納する
		 model.addAttribute(vegetableList);
		 return "vegetabletahara/deletecomp";
	 }
	 
	 /**
	  * VegetableMainテーブルのデータを完全削除して検索画面に遷移
	  * 
	  * @param VegetableTaharaDeleteForm form
	  * param VindingResult bindingResult
	  * @param Model model
	  * @return 入力エラーがある場合は完全削除画面、ない場合は検索画面のパス
	  * */
	 @PostMapping(value = "deletecomp")
	 public String deleteCompVegetable(@Validated final VegetableTaharaDeleteForm form,
			 final BindingResult bindingResult, final Model model) {
		 if(bindingResult.hasFieldErrors()) {
			 
			 //入力エラーがある場合、再検索して自画面に戻る
			 VegetableTaharaSearchForm vegetableTaharaSearchForm = new VegetableTaharaSearchForm();
			 vegetableTaharaSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			 final List<VegetableMainTahara> vegetableList = vegetableTaharaService.getListVegetable(vegetableTaharaSearchForm);
			 
			 //Modelに検索結果を格納する
			 model.addAttribute(vegetableList);
			 return "vegetabletahara/deletecomp";
		 }
		 
		 //データを完全削除する
		 vegetableTaharaService.deleteVegetableTaharaComp(form.getDeleteIds());
		 return "redirect:/vegetabletahara?result=deletecomp";
	 }
}
