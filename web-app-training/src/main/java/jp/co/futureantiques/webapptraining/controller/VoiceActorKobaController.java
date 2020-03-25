package jp.co.futureantiques.webapptraining.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.futureantiques.webapptraining.model.form.voiceActorKoba.VoiceActorKobaOperateForm;
import jp.co.futureantiques.webapptraining.model.form.voiceActorKoba.VoiceActorKobaSearchForm;
import jp.co.futureantiques.webapptraining.model.voiceActorKoba.AnimeKoba;
import jp.co.futureantiques.webapptraining.model.voiceActorKoba.CharacterKoba;
import jp.co.futureantiques.webapptraining.model.voiceActorKoba.OfficeKoba;
import jp.co.futureantiques.webapptraining.model.voiceActorKoba.VoiceActorMainKoba;
import jp.co.futureantiques.webapptraining.repository.voiceActorKoba.CharacterKobaRepository;
import jp.co.futureantiques.webapptraining.service.VoiceActorKobaService;

/**
 * @author Created by Koba on 2020/3/23.
 * @since 2020-03-23 12:41
 */

@Controller
@RequestMapping(value = "/voiceActorKoba")
// localhost:8080/voiceActorKoba
public class VoiceActorKobaController {

	private final VoiceActorKobaService voiceActorKobaService;

	@Autowired
	public VoiceActorKobaController(final VoiceActorKobaService voiceActorKobaService) {
		this.voiceActorKobaService = voiceActorKobaService;
	}

	// 後ろの方法を動く前に、先ずはこの方法を呼び出し、モデル.voiceActorKobaの中に、リストをセットする
	@ModelAttribute
	public List<OfficeKoba> listOfficeKoba() {
		return voiceActorKobaService.listOfficeKoba();
	}

	public List<AnimeKoba> listAnimeKoba() {
		return voiceActorKobaService.listAnimeKoba();
	}

	// URL -> localhost:8080/voiceActorKoba
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchVoiceActorKoba(@ModelAttribute final VoiceActorKobaSearchForm voiceActorKobaSearchForm) {
		return "voiceActorKoba/search";
	}

	// URL -> localhost:8080/voiceActorKoba/search?actorName=&officeId=&animeTitle=
	// OR -> localhost:8080/voiceActorKoba/search?id=
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String searchVoiceActorKoba(final VoiceActorKobaSearchForm form, final Model model) {
		final List<VoiceActorMainKoba> voiceActorMainKobaList = voiceActorKobaService.listVoiceActorMainKoba(form);
		model.addAttribute(voiceActorMainKobaList);

		return "voiceActorKoba/search";
	}

	// URL -> localhost:8080/voiceActorKoba/delete?id=
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteVoiceActorKoba(@RequestParam(name = "id") final Long id) {
		voiceActorKobaService.deleteVoiceActorKobaById(id);
		return "redirect:/voiceActorKoba?result=delete";
	}
	//endregion

	// URL -> localhost:8080/voiceActorKoba/insert
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertVoiceActorKoba(@ModelAttribute final VoiceActorKobaOperateForm VoiceActorKobaOperateForm) {
		VoiceActorKobaOperateForm.setInsert(true);

		return "voiceActorKoba/operation";
	}

	// URL -> localhost:8080/voiceActorKoba/insert (*POST)
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertVoiceActorKoba(@ModelAttribute @Validated final VoiceActorKobaOperateForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {
			return "voiceActorKoba/operation";
		}

		final VoiceActorMainKoba voiceActorMainKoba = voiceActorKobaService.insertVoiceActorKoba(form);
		return "redirect:/voiceActorKoba/search?result=insert&id=" + voiceActorMainKoba.getId();
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateVoiceActorKoba(@RequestParam(name = "id") final Long id,
			@ModelAttribute final VoiceActorKobaOperateForm voiceActorKobaOperateForm) {
		VoiceActorMainKoba voiceActorKoba = voiceActorKobaService.getVoiceActorMainKoba(id);
		voiceActorKobaOperateForm.initWithVoiceActorKoba(voiceActorKoba);
		voiceActorKobaOperateForm.setInsert(false);

		return "voiceActorKoba/operation";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateVoiceActorKoba(@Validated final VoiceActorKobaOperateForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {
			return "voiceActorKoba/operation";
		}
		VoiceActorMainKoba voiceActorMainKoba = voiceActorKobaService.updateVoiceActorKoba(form);
		return "redirect:/voiceActorKoba/search?result=update&id=" + voiceActorMainKoba.getId();
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String showDetail(@RequestParam(value = "id") final Long id,
			final Model model) {
		final VoiceActorMainKoba voiceActorMainKoba = voiceActorKobaService.getVoiceActorMainKoba(id);
		if (voiceActorMainKoba != null) {
			model.addAttribute(voiceActorMainKoba);
			return "voiceActorKoba/detail";
		}
		return "error";
	}

	// CharacterKobaテーブルの複合主キー用ココカラ
	@Autowired
    CharacterKobaRepository repository;

    @RequestMapping(value = "characterName", method = RequestMethod.GET)
    public String search(Model model) {
        CharacterKoba entity = repository.findByCompositePrimaryKey(0, 0);
        model.addAttribute("entity", entity);
        return "search";
    }
	// CharacterKobaテーブルの複合主キー用ココマデ
}
