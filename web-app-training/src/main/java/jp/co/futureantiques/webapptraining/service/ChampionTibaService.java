package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.championTiba.ChampionMainTiba;
import jp.co.futureantiques.webapptraining.model.championTiba.ClassTiba;
import jp.co.futureantiques.webapptraining.model.championTiba.CountryTiba;
import jp.co.futureantiques.webapptraining.model.form.championTiba.ChampionTibaSearchForm;

public interface ChampionTibaService {

	List<ClassTiba> getListClass();
	List<CountryTiba> getListCountry();


	ChampionMainTiba getChampion(final long id);


	void deleteChampionById(final long id);

	void deleteChampionComp(final ArrayList<Long> ids);
	Page<ChampionMainTiba> getPageChampion(ChampionTibaSearchForm form, Pageable pageable);
	List<ChampionMainTiba> getListChampion(ChampionTibaSearchForm form);
}
