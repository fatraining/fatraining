package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.championTiba.ChampionMainTiba;
import jp.co.futureantiques.webapptraining.model.championTiba.ClassTiba;
import jp.co.futureantiques.webapptraining.model.championTiba.CountryTiba;
import jp.co.futureantiques.webapptraining.model.form.championTiba.ChampionTibaSearchForm;
import jp.co.futureantiques.webapptraining.repository.championTiba.ChampionMainTibaRepository;
import jp.co.futureantiques.webapptraining.repository.championTiba.ClassTibaRepository;
import jp.co.futureantiques.webapptraining.repository.championTiba.CountryTibaRepository;
import jp.co.futureantiques.webapptraining.repository.specification.ChampionTibaSpecification;
import jp.co.futureantiques.webapptraining.service.ChampionTibaService;

@Service
public class ChampionTibaServiceImpl implements ChampionTibaService {
	private final ChampionMainTibaRepository championMainTibaRepository;
	private final ClassTibaRepository classTibaRepository;
	private final CountryTibaRepository countryTibaRepository;

	@Autowired
	public ChampionTibaServiceImpl(ChampionMainTibaRepository championMainTibaRepository,
			ClassTibaRepository classTibaRepository,
			CountryTibaRepository countryTibaRepository) {
		this.championMainTibaRepository = championMainTibaRepository;
		this.classTibaRepository = classTibaRepository;
		this.countryTibaRepository = countryTibaRepository;
	}

	@Override
	public List<ClassTiba> getListClass() {
		return classTibaRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<CountryTiba> getListCountry() {
		return countryTibaRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}


	@Override
	public Page<ChampionMainTiba> getPageChampion(final ChampionTibaSearchForm form, final Pageable pageable) {
		return championMainTibaRepository.findAll(ChampionTibaSpecification.generateChampionSpecification(form), pageable);
	}

	@Override
	public List<ChampionMainTiba> getListChampion(final ChampionTibaSearchForm form) {
		return championMainTibaRepository.findAll(ChampionTibaSpecification.generateChampionSpecification(form));
	}


	@Override
	public ChampionMainTiba getChampion(final long id) {
		return championMainTibaRepository.findOne(id);
	}
	//Override
	//public ChampionMainTiba updateChampion(final ChampionTibaInputForm form) {
		//ChampionMainTiba championMainTiba = championMainTibaRepository.findOne((long) form.getId());
		//if (championMainTiba != null) {
		//	if (form.getUpdateDate().equals(String.valueOf(championMainTiba.getUpdateDate()))) {
		//		championMainTiba = form.convertToChampionMainTibaForUpdate(championMainTiba);
			//	if (form.getPhoto().isEmpty()) {

			//		return championMainTibaRepository.saveAndFlush(championMainTiba);
			//	}
				//ファイルをアップロードする
			//	uploadFile(championMainTiba, form.getPhoto());
			//	return championMainTibaRepository.saveAndFlush(championMainTiba);
			//}
		//}
	//	return null;
	//}

	@Override
	public void deleteChampionById(final long id) {
		ChampionMainTiba championMainTiba = championMainTibaRepository.findOne(id);
		if (championMainTiba != null) {
			championMainTibaRepository.delete(id);
		}
	}

	@Override
	public void deleteChampionComp(final ArrayList<Long> ids) {
		championMainTibaRepository.deleteComp(ids);
	}

}

//}
