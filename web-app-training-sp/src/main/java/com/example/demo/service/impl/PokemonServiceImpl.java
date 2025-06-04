package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
//import java.awt.print.Pageable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.form.pokemon.PokemonInputForm;
import com.example.demo.model.form.pokemon.PokemonSearchForm;
import com.example.demo.model.pokemon.AppearanceSatoyoshi;
import com.example.demo.model.pokemon.PokemonMainSatoyoshi;
import com.example.demo.model.pokemon.Type1Satoyoshi;
import com.example.demo.model.pokemon.Type2Satoyoshi;
import com.example.demo.repository.pokemon.AppearanceSatoyoshiRepository;
import com.example.demo.repository.pokemon.PokemonMainSatoyoshiRepository;
import com.example.demo.repository.pokemon.Type1SatoyoshiRepository;
import com.example.demo.repository.pokemon.Type2SatoyoshiRepository;
import com.example.demo.repository.specification.PokemonSpecification;
import com.example.demo.service.PokemonService;

/**
 * Pokemonのサービス実装クラス
 *
 * @author satoyoshi
 */
@Service
public class PokemonServiceImpl implements PokemonService {

	/** PokemonMainSatoyoshiリポジトリ */
	private final PokemonMainSatoyoshiRepository pokemonMainRepository;

	/** Type1リポジトリ */
	private final Type1SatoyoshiRepository type1Repository;

	/** Type2リポジトリ */
	private final Type2SatoyoshiRepository type2Repository;

	/** Appearanceリポジトリ */
	private final AppearanceSatoyoshiRepository appearanceRepository;

	/**
	 * コンストラクタ
	 *
	 * @param PokemonMainSatoyoshiRepository pokemonMainRepository
	 * @param Type1Repository Type1Repository
	 * @param Type2SatoyoshiRepository Type2Repository
	 * @param AppearanceSatoyoshiRepository appearanceRepository
	 */
	public PokemonServiceImpl(PokemonMainSatoyoshiRepository pokemonMainRepository, Type1SatoyoshiRepository type1Repository,
			Type2SatoyoshiRepository type2Repository, AppearanceSatoyoshiRepository appearanceRepository) {
		this.pokemonMainRepository = pokemonMainRepository;
		this.type1Repository = type1Repository;
		this.type2Repository = type2Repository;
		this.appearanceRepository = appearanceRepository;
	}

	@Override
	public List<Type1Satoyoshi> getListType1() {

		// Type1テーブルのレコードをID順に取得する TO:DO
		return type1Repository.findAll();
	}

	@Override
	public List<Type2Satoyoshi> getListType2() {

		// Type1テーブルのレコードをID順に取得する TO:DO
		return type2Repository.findAll();
	}

	@Override
	public List<AppearanceSatoyoshi> getListAppearance() {

		// 初登場シリーズテーブルのレコードをID順に取得するTO:DO
		return appearanceRepository.findAll();
	}

	@Override
	public Page<PokemonMainSatoyoshi> getPagePokemon(final PokemonSearchForm form, final Pageable pageable) {

		// 検索条件を生成しPokemonMainテーブルのレコードを取得する
		return pokemonMainRepository.findAll(PokemonSpecification.generatePokemonSpecification(form), pageable);
	}

	@Override
	public List<PokemonMainSatoyoshi> getListPokemon(final PokemonSearchForm form) {

		// 検索条件を生成しPokemonMainテーブルのレコードを取得する
		return pokemonMainRepository.findAll(PokemonSpecification.generatePokemonSpecification(form));
	}

	@Override
	public PokemonMainSatoyoshi getPokemon(final long id) {

		// PokemonMainテーブルを主キー検索する
		PokemonMainSatoyoshi pokemonMain = pokemonMainRepository.findById(id).get();
		return pokemonMain;
	}

	@Override
	public PokemonMainSatoyoshi insertPokemon(final PokemonInputForm form) {

		// PokemonMainテーブルに新規でデータを登録する
		final PokemonMainSatoyoshi pokemonMain = form.convertToPokemonMainForInsert();
		return pokemonMainRepository.saveAndFlush(pokemonMain);
	}

	@Override
	public PokemonMainSatoyoshi updatePokemon(final PokemonInputForm form) {

		// 更新対象のレコードを取得する
		Optional<PokemonMainSatoyoshi> pokemonMainOp = pokemonMainRepository.findById((long) form.getPokemonId());

		PokemonMainSatoyoshi pokemonMain = pokemonMainOp.get();
		if (pokemonMain != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(pokemonMain.getUpdateDate()))) {

				// チェックOKの場合、更新
				pokemonMain = form.convertToPokemonMainForUpdate(pokemonMain);
				return pokemonMainRepository.saveAndFlush(pokemonMain);
			}
		}
		return null;
	}

	@Override
	public void deletePokemonBypokemonId(final long id) {

		// 更新対象のレコードを取得する
		Optional<PokemonMainSatoyoshi> pokemonMainOp = pokemonMainRepository.findById(id);
		PokemonMainSatoyoshi pokemonMain = pokemonMainOp.get();
		if (pokemonMain != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			pokemonMainRepository.delete(id);
		}
	}

	@Override
	public void deletePokemonComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		pokemonMainRepository.deleteComp(ids);
	}

}
