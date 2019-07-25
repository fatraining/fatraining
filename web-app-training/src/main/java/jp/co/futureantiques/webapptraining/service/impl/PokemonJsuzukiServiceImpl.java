package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.pokemonJsuzuki.PokemonJsuzukiInputForm;
import jp.co.futureantiques.webapptraining.model.form.pokemonJsuzuki.PokemonJsuzukiSearchForm;
import jp.co.futureantiques.webapptraining.model.pokemonJsuzuki.AreaIdJsuzuki;
import jp.co.futureantiques.webapptraining.model.pokemonJsuzuki.PokemonMainJsuzuki;
import jp.co.futureantiques.webapptraining.model.pokemonJsuzuki.TypeIdJsuzuki;
import jp.co.futureantiques.webapptraining.repository.pokemonJsuzuki.AreaIdJsuzukiRepository;
import jp.co.futureantiques.webapptraining.repository.pokemonJsuzuki.PokemonMainJsuzukiRepository;
import jp.co.futureantiques.webapptraining.repository.pokemonJsuzuki.TypeIdJsuzukiRepository;
import jp.co.futureantiques.webapptraining.repository.specification.PokemonJsuzukiSpecification;
import jp.co.futureantiques.webapptraining.service.PokemonJsuzukiService;

@Service
public class PokemonJsuzukiServiceImpl implements PokemonJsuzukiService {
	/**PokemonMainJsuzukiリポジトリ*/
	private final PokemonMainJsuzukiRepository pokemonMainJsuzukiRepository;

	/**AreaIdJsuzukiリポジトリ*/
	private final AreaIdJsuzukiRepository areaIdJsuzukiRepository;

	/**TypeIdリポジトリ*/
	private final TypeIdJsuzukiRepository typeIdJsuzukiRepository;

	/**
	 * コンストラクタ
	 *
	 * @param PokekmonMainJsuzukiRepository pokemonMainJsuzukiRepository
	 * @param AreaIdJsuzukiMainRepository areaIdJsuzukiMainRepository
	 * @param TypeIdJsuzukiMainRepository typeIdJsuzukiMainRepository
	 */
	@Autowired
	public PokemonJsuzukiServiceImpl(PokemonMainJsuzukiRepository pokemonMainJsuzukiRepository,
			AreaIdJsuzukiRepository areaIdJsuzukiRepository,TypeIdJsuzukiRepository typeIdJsuzukiRepository) {
		this.pokemonMainJsuzukiRepository = pokemonMainJsuzukiRepository;
		this.areaIdJsuzukiRepository = areaIdJsuzukiRepository;
		this.typeIdJsuzukiRepository = typeIdJsuzukiRepository;
	}

	@Override
	public List<AreaIdJsuzuki> getListAreaId(){

		//AreaIdテーブルをID順に取得する
		return areaIdJsuzukiRepository.findAll(new Sort(Sort.Direction.ASC,"id"));
	}

	@Override
	public List<TypeIdJsuzuki> getListTypeId(){

		//TypeIdテーブルをID順に取得する
		return typeIdJsuzukiRepository.findAll(new Sort(Sort.Direction.ASC,"id"));
	}

	@Override
	public Page<PokemonMainJsuzuki> getPagePokemon(final PokemonJsuzukiSearchForm form, Pageable pageable) {

		//検索条件を生成しPokemonMainJsuzukiテーブルのレコードを取得する
		return pokemonMainJsuzukiRepository.findAll(PokemonJsuzukiSpecification.generatePokemonJsuzukiSpecification(form),pageable);
	}

	@Override
	public List<PokemonMainJsuzuki> getListPokemon(final PokemonJsuzukiSearchForm form){

		//検索条件を生成しPokemonMainJsuzukiテーブルのレコードを取得する
		return pokemonMainJsuzukiRepository.findAll(PokemonJsuzukiSpecification.generatePokemonJsuzukiSpecification(form));
	}

	@Override
	public PokemonMainJsuzuki getPokemon(final long id) {

		//PokemonMainJsuzukiテーブルを主キー検索する
		return pokemonMainJsuzukiRepository.findOne(id);
	}

	@Override
	public PokemonMainJsuzuki insertPokemon(final PokemonJsuzukiInputForm form) {

		//PokemonJsuzukiテーブルに新規でデータを登録する
		final PokemonMainJsuzuki pokemonMainJsuzuki = form.convertToPokemonMainJsuzukiForInsert();
		return pokemonMainJsuzukiRepository.save(pokemonMainJsuzuki);
	}

	@Override
	public PokemonMainJsuzuki updatePokemon(final PokemonJsuzukiInputForm form) {

		//更新対象のレコードを取得する
		PokemonMainJsuzuki pokemonMainJsuzuki  = pokemonMainJsuzukiRepository.findOne((long)form.getId());
		if(pokemonMainJsuzuki != null) {

			//更新対象のレコードが存在する場合排他チェック
			if(form.getUpdateDate().equals(String.valueOf(pokemonMainJsuzuki.getUpdateDate()))) {

				//チェックOKの場合、更新
				pokemonMainJsuzuki = form.convertToPokemonMainJsuzukiForUpdate(pokemonMainJsuzuki);
				return pokemonMainJsuzukiRepository.saveAndFlush(pokemonMainJsuzuki);
			}
		}
		return null;
	}
	@Override
	public void deletePokemonById(final long id) {

		//更新対象のレコードを取得する
		PokemonMainJsuzuki pokemonMainJsuzuki = pokemonMainJsuzukiRepository.findOne(id);
		if(pokemonMainJsuzuki != null) {

			//更新対象のレコードが存在する場合、削除フラグを1にする
			pokemonMainJsuzukiRepository.delete(id);
		}
	}

	@Override
	public void deletePokemonComp(final ArrayList<Long> ids) {

		//対象のレコードを削除する
		pokemonMainJsuzukiRepository.deleteComp(ids);
	}
}