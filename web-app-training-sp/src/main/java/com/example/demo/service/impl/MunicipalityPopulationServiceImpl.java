package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.MunicipalityIkebe;
import com.example.demo.model.MunicipalityPopulationIkebeMain;
import com.example.demo.model.PopulationIkebe;
import com.example.demo.model.form.MunicipalityPopulationSearchForm;
import com.example.demo.repository.MunicipalityIkebeRepository;
import com.example.demo.repository.MunicipalityPopulationIkebeMainRepository;
import com.example.demo.repository.PopulationIkebeRepository;
import com.example.demo.repository.specification.MunicipalityPopulationSpecification;
import com.example.demo.service.MunicipalityPopulationService;

/**
 * MovieSampleのサービス実装クラス
 *
 * @author future
 */
@Service
public class MunicipalityPopulationServiceImpl implements MunicipalityPopulationService {

	/** MunicipalityPopulationIkebeMainリポジトリ */
	private final MunicipalityPopulationIkebeMainRepository municipalityPopulationIkebeMainRepository;

	/** Municipalityリポジトリ */
	private final MunicipalityIkebeRepository municipalityIkebeRepository;

	/** Populationリポジトリ */
	private final PopulationIkebeRepository populationIkebeRepository;

	/**
	 * コンストラクタ
	 *
	 * @param MunicipalityPopulationIkebeMainRepository municipalityPopulationIkebeMainRepository
	 * @param MunicipalityIkebeRepository MunicipalityIkebeRepository
	 * @param PopulationIkebeRepository populationIkebeRepository
	 */
	public MunicipalityPopulationServiceImpl(
			MunicipalityPopulationIkebeMainRepository municipalityPopulationikebeMainRepository,
			MunicipalityIkebeRepository municipalityIkebeRepository,
			PopulationIkebeRepository populationIkebeRepository) {
		this.municipalityPopulationIkebeMainRepository = municipalityPopulationikebeMainRepository;
		this.municipalityIkebeRepository = municipalityIkebeRepository;
		this.populationIkebeRepository = populationIkebeRepository;
	}

	@Override
	public List<MunicipalityIkebe> getListMunicipality() {

		// MunicipalityテーブルのレコードをID順に取得する TO:DO
		return municipalityIkebeRepository.findAll();
	}

	@Override
	public List<PopulationIkebe> getListPopulation() {

		// PopulationテーブルのレコードをID順に取得するTO:DO
		return populationIkebeRepository.findAll();
	}

	@Override
	public Page<MunicipalityPopulationIkebeMain> getPageMunicipalityPopulation(
			final MunicipalityPopulationSearchForm form, final Pageable pageable) {

		// 検索条件を生成しMunicipalityPopulationIkebeMainテーブルのレコードを取得する
		return municipalityPopulationIkebeMainRepository.findAll(
				MunicipalityPopulationSpecification.generatemunicipalityPopulationSpecification(form), pageable);
	}

	@Override
	public List<MunicipalityPopulationIkebeMain> getListMunicipalityPopulationIkebeMain(
			final MunicipalityPopulationSearchForm form) {

		// 検索条件を生成しMunicipalityPopulationIkebeMainテーブルのレコードを取得する
		return municipalityPopulationIkebeMainRepository
				.findAll(MunicipalityPopulationSpecification.generatemunicipalityPopulationSpecification(form));
	}

	@Override
	public MunicipalityPopulationIkebeMain getMunicipalityIkebe(final long id) {

		// MunicipalityPopulationIkebeMainテーブルを主キー検索する
		MunicipalityPopulationIkebeMain municipalityPopulationIkebeMain = municipalityPopulationIkebeMainRepository
				.findById(id).get();
		return municipalityPopulationIkebeMain;
	}

	@Override
	public void deleteMunicipalityPopulationIkebeById(long id) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void deleteMunicipaalityPopulationIkebeComp(ArrayList<Long> ids) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}