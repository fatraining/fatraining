package jp.co.futureantiques.webapptraining.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
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
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.bandSasaki.BandMainSasaki;
import jp.co.futureantiques.webapptraining.model.bandSasaki.BirthplaceSasaki;
import jp.co.futureantiques.webapptraining.model.bandSasaki.MemberSasaki;
import jp.co.futureantiques.webapptraining.model.form.bandSasaki.BandSasakiDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.bandSasaki.BandSasakiInputForm;
import jp.co.futureantiques.webapptraining.model.form.bandSasaki.BandSasakiSearchForm;
import jp.co.futureantiques.webapptraining.service.BandSasakiService;

@Controller
@RequestMapping(value = "/bandsasaki")
public class BandSasakiController {
	private final BandSasakiService bandSasakiService;

	@Autowired
	public BandSasakiController(final BandSasakiService bandSasakiService) {
		this.bandSasakiService = bandSasakiService;
	}

	@ModelAttribute
	public List<MemberSasaki> getListMember() {
		return bandSasakiService.getListMember();
	}

	@ModelAttribute
	public List<BirthplaceSasaki> getListBirthplace() {
		return bandSasakiService.getListBirthplace();
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchBand(@ModelAttribute final BandSasakiSearchForm bandSasakiSearchForm) {
		return "bandsasaki/search";
	}

	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String showSearchBand(final BandSasakiSearchForm form, final Model model, final Pageable pageable) {
		final Page<BandMainSasaki> bandList = bandSasakiService.getPageBand(form, pageable);
		if (bandList.getTotalElements() != 0) {

			model.addAttribute("page", bandList);
			model.addAttribute("bandList", bandList.getContent());
			model.addAttribute("url", "search");
		}
		return "bandsasaki/search";
	}

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertBand(@ModelAttribute final BandSasakiInputForm bandSasakiInputForm) {
		return "bandsasaki/insert";
	}

	@Autowired
	ResourceLoader resourceLoader;
	@Autowired
	ServletContext context;
	@Autowired
	WebApplicationContext wac;

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertBand(@ModelAttribute @Validated final BandSasakiInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {
			return "bandsasaki/insert";
		}

		final BandMainSasaki bandMainSasaki = bandSasakiService.insertBand(form);
		return "redirect:/bandsasaki?result=insert&id=" + bandMainSasaki.getId();
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateBand(@RequestParam(name = "id") final long id,
			@ModelAttribute final BandSasakiInputForm bandSasakiInputForm) {
		BandMainSasaki bandMainSasaki = bandSasakiService.getBand(id);
		bandSasakiInputForm.initWithBandMainSasaki(bandMainSasaki);
		return "bandsasaki/update";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateBand(@Validated final BandSasakiInputForm form,
			final BindingResult bindingResult, MultipartFile photo) {
		if (bindingResult.hasFieldErrors()) {
			return "bandsasaki/update";
		}
		if (CommonConst.UPLOAD_ALLOWABLE_FILE_SIZE < photo.getSize()) {
			if (bindingResult.hasErrors()) {
				return "bandsasaki/insert";
			}
		}

		BandMainSasaki bandMainSasaki = bandSasakiService.updateBand(form);
		if (bandMainSasaki == null) {
			return "redirect:/bandsasaki?result=updatefailed";
		}
		return "redirect:/bandsasaki?result=update&id=" + bandMainSasaki.getId();
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteBand(@RequestParam(name = "id") final long id) {
		bandSasakiService.deleteBandById(id);
		return "redirect:/bandsasaki?result=delete&id=" + id;
	}

	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompBand(final BandSasakiSearchForm form,
			@ModelAttribute final BandSasakiDeleteForm bandSasakiDeleteForm, final Model model) {
		final List<BandMainSasaki> bandList = bandSasakiService.getListBand(form);
		model.addAttribute(bandList);
		return "bandsasaki/deletecomp";
	}

	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompBand(@Validated final BandSasakiDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {
			BandSasakiSearchForm bandSasakiSearchForm = new BandSasakiSearchForm();
			bandSasakiSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<BandMainSasaki> bandList = bandSasakiService.getListBand(bandSasakiSearchForm);

			model.addAttribute(bandList);
			return "bandsasaki/deletecomp";
		}

		bandSasakiService.deleteBandComp(form.getDeleteIds());
		return "redirect:/bandsasaki?result=deletecomp";
	}

}
