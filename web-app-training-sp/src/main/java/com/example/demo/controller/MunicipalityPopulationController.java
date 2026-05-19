package com.example.demo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.MunicipalityIkebe;
import com.example.demo.model.MunicipalityPopulationIkebeMain;
import com.example.demo.model.PopulationIkebe;
import com.example.demo.model.form.MunicipalityPopulationSearchForm;
import com.example.demo.service.MunicipalityPopulationService;

/**
 * MunicipalityPopulationIkebeMainのコントローラークラス
 * 
 * @author FUTURE2024
 */

@Controller
@RequestMapping(value = "municipalityPopulation")
public class MunicipalityPopulationController {
	
	/** 映画のサービス */
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
	

}
