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

import com.example.demo.model.form.municipalityPopulationIkebe.MunicipalityPopulationInputForm;
import com.example.demo.model.form.municipalityPopulationIkebe.MunicipalityPopulationSearchForm;
import com.example.demo.model.municipalityPopulationIkebe.MunicipalityIkebe;
import com.example.demo.model.municipalityPopulationIkebe.MunicipalityPopulationIkebeMain;
import com.example.demo.model.municipalityPopulationIkebe.PopulationIkebe;
import com.example.demo.service.MunicipalityPopulationService;

/**
 * MunicipalityPopulationIkebeMainのコントローラークラス
 * 
 * @author FUTURE2024
 */

@Controller
@RequestMapping(value = "/municipalityPopulation")
public class MunicipalityPopulationController {
	
	/** 人口検索のサービス */
	private final MunicipalityPopulationService municipalityPopulationService;
	
	/**municipalityPopulation
	 * コンストラクタ
	 * 
	 */
	public MunicipalityPopulationController(final MunicipalityPopulationService municipalityPopulationService) {
		this.municipalityPopulationService = municipalityPopulationService;
	}
	
	/**
	 * 市区町村エンティティのリストを取得する
	 */
	@ModelAttribute
	public List<MunicipalityIkebe> getListMunicipality(){
		return municipalityPopulationService.getListMunicipality();
	}
	
	/*
	 * 人口エンティティのリストを取得する
	 */
	@ModelAttribute
	public List<PopulationIkebe> getListPopulation() {
		return municipalityPopulationService.getListPopulation();
	}
	
	/**
	 * 検索画面に遷移する
	 */
	@GetMapping(value = "")
	public String showSearchMunicipalityPopulation(@ModelAttribute final MunicipalityPopulationSearchForm municipalityPopulationSearchForm) {
		return "municipalityPopulation/search";
	}
	
	/**
	 * 検索結果を取得して検索画面に遷移する
	 */
	@PostMapping(value = "search")
	public String searchMunicipalityPopulation(final MunicipalityPopulationSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<MunicipalityPopulationIkebeMain> municipalityPopulationList = municipalityPopulationService.getPageMunicipalityPopulation(form, pageable);
		if (municipalityPopulationList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", municipalityPopulationList);
			model.addAttribute("municipalityPopulationList", municipalityPopulationList.getContent());
			model.addAttribute("url", "search");
		}
		return "municipalityPopulation/search";
		
	}
	
	/**
	 * 追加画面に遷移する
	 *
	 * @param MunicipalityPopulationInputForm municipalityPopulationInputForm
	 * @return 追加画面のパス
	 */
	@GetMapping(value = "insert")
	public String showInsertMunicipalityPopulation(@ModelAttribute final MunicipalityPopulationInputForm municipalityPopulationInputForm) {
		return "municipalityPopulation/insert";
	}
	
	/**
	 * MovieMainテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param MovieSampleInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@PostMapping(value = "insert")
	public String insertMovie(@ModelAttribute @Validated final MunicipalityPopulationInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "municipalityPopulation/insert";
		}

		// データを登録する
		final MunicipalityPopulationIkebeMain municipalityPopulationIkebeMain  = municipalityPopulationService.insertMunicipalityPopulation(form);
		return "redirect:/municipalityPopulation?result=insert&id=" + municipalityPopulationIkebeMain.getId();
	}

	

}
