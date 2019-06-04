package jp.co.futureantiques.webapptraining.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.futureantiques.webapptraining.model.championTiba.ChampionMainTiba;
import jp.co.futureantiques.webapptraining.model.championTiba.ClassTiba;
import jp.co.futureantiques.webapptraining.model.championTiba.CountryTiba;
import jp.co.futureantiques.webapptraining.model.form.championTiba.ChampionTibaSearchForm;
import jp.co.futureantiques.webapptraining.service.ChampionTibaService;

@Controller
@RequestMapping(value = "/championtiba")
public class ChampionTibaController {
	private final ChampionTibaService championTibaService;

	@Autowired
	public ChampionTibaController(final ChampionTibaService championTibaService) {
		this.championTibaService = championTibaService;
	}

	@ModelAttribute
	public List<ClassTiba> getListClass() {
		return championTibaService.getListClass();
	}

	@ModelAttribute
	public List<CountryTiba> getListCountry() {
		return championTibaService.getListCountry();
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchChampion(@ModelAttribute final ChampionTibaSearchForm championTibaSearchForm) {
		return "championtiba/search";
	}

@RequestMapping(value = "search", method = RequestMethod.POST)
public String showSearchTiba(final ChampionTibaSearchForm form, final Model model, final Pageable pageable) {
	final Page<ChampionMainTiba> championList = championTibaService.getPageChampion(form, pageable);
	if (championList.getTotalElements() != 0) {

		model.addAttribute("page", championList);
		model.addAttribute("championList", championList.getContent());
		model.addAttribute("url", "search");
	}
	return "championtiba/search";
}

@RequestMapping(value = "delete", method = RequestMethod.GET)
public String deleteChampion(@RequestParam(name = "id") final long id) {

	championTibaService.deleteChampionById(id);
	return "redirect:/championtiba?result=delete&id=" + id;
}



}

