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

import jp.co.futureantiques.webapptraining.model.bandSasaki.BandMain;
import jp.co.futureantiques.webapptraining.model.bandSasaki.Birthplace;
import jp.co.futureantiques.webapptraining.model.bandSasaki.Member;
import jp.co.futureantiques.webapptraining.model.form.bandSasaki.BandSasakiDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.bandSasaki.BandSasakiInputForm;
import jp.co.futureantiques.webapptraining.model.form.bandSasaki.BandSasakiSearchForm;
import jp.co.futureantiques.webapptraining.service.BandSasakiService;


@Controller
@RequestMapping(value="/bandsasaki")
public class BandSasakiController{
	private final BandSasakiService bandSasakiService;

	@Autowired
	public BandSasakiController(final BandSasakiService bandSasakiService) {
		this.bandSasakiService=bandSasakiService;
	}

	@ModelAttribute
	public List<Member> getListMember(){
		return bandSasakiService.getListMember();
	}

	@ModelAttribute
	public List<Birthplace> getListBirthplace(){
		return bandSasakiService.getListBirthplace();
	}

	@RequestMapping(value="", method=RequestMethod.GET)
	public String showSearchBand(@ModelAttribute final BandSasakiSearchForm bandSasakiSearchForm) {
		return "bandsasaki/search";
	}

	@RequestMapping(value="search", method=RequestMethod.POST)
	public String showSearchBand(final BandSasakiSearchForm form, final Model model, final Pageable pageable) {
		final Page<BandMain> bandList=bandSasakiService.getPageBand(form, pageable);
		if(bandList.getTotalElements()!=0){

			model.addAttribute("page", bandList);
			model.addAttribute("bandList", bandList.getContent());
			model.addAttribute("url", "search");
		}
		return "bandsasaki/search";
	}

	@RequestMapping(value="insert", method=RequestMethod.GET)
	public String showInsertBand(@ModelAttribute final BandSasakiInputForm bandSasakiInputForm) {
		return "bandsasaki/insert";
	}

	@RequestMapping(value="insert", method=RequestMethod.POST)
	public String insertBand(@ModelAttribute @Validated final BandSasakiInputForm form,
			final BindingResult bindingResult) {
		if(bindingResult.hasFieldErrors()) {
			return "bandsasaki/insert";
		}

		final BandMain bandMain=bandSasakiService.insertBand(form);
		return "redirect:/bandsasaki?result=insert&id="+bandMain.getId();
	}

	@RequestMapping(value="update", method=RequestMethod.GET)
	public String showUpdateBand(@RequestParam(name="id")final long id,
			@ModelAttribute final BandSasakiInputForm bandSasakiInputForm) {
		BandMain bandMain=bandSasakiService.getBand(id);
		bandSasakiInputForm.initWithBandMain(bandMain);
		return "bandsasaki/update";
	}

	@RequestMapping(value="update", method=RequestMethod.POST)
	public String updateBand(@Validated final BandSasakiInputForm form,
			final BindingResult bindingResult) {
		if(bindingResult.hasFieldErrors()) {
			return "bandsasaki/update";
		}

		BandMain bandMain=bandSasakiService.updateBand(form);
		if(bandMain==null) {
			return "redirect:/bandsasaki?result=updatefailed";
		}
		return "redirect:/bandsasaki?result=update&id="+bandMain.getId();
	}

	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String deleteBand(@RequestParam(name="id")final long id) {
		bandSasakiService.deleteBandById(id);
		return "redirect:/bandsasaki?result=delete&id="+id;
	}

	@RequestMapping(value="deletecomp", method=RequestMethod.GET)
	public String showDeleteCompBand(final BandSasakiSearchForm form,
			@ModelAttribute final BandSasakiDeleteForm bandSasakiDeleteForm, final Model model) {
		final List<BandMain> bandList=bandSasakiService.getListBand(form);
		model.addAttribute(bandList);
		return "bandsasaki/deletecomp";
	}

	@RequestMapping(value="deletecomp", method=RequestMethod.POST)
	public String deleteCompBand(@Validated final BandSasakiDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if(bindingResult.hasFieldErrors()) {
			BandSasakiSearchForm bandSasakiSearchForm=new BandSasakiSearchForm();
			bandSasakiSearchForm.setIsDelete(1);
			final List<BandMain> bandList=bandSasakiService.getListBand(bandSasakiSearchForm);

			model.addAttribute(bandList);
			return "bandsasaki/deletecomp";
		}

		bandSasakiService.deleteBandComp(form.getDeleteIds());
		return "redirect:/bandsasaki?result=deletecomp";
	}

}
