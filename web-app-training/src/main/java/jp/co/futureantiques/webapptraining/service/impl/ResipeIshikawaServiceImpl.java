package jp.co.futureantiques.webapptraining.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.resipeishikawa.ResipeIshikawaSearchForm;
import jp.co.futureantiques.webapptraining.model.resipeishikawa.GenreIshikawa;
import jp.co.futureantiques.webapptraining.model.resipeishikawa.ResipeMainIshikawa;
import jp.co.futureantiques.webapptraining.model.resipeishikawa.VegetableIshikawa;
import jp.co.futureantiques.webapptraining.repository.resipeishikawa.GenreIshikawaRepository;
import jp.co.futureantiques.webapptraining.repository.resipeishikawa.ResipeIshikawaMainRepository;
import jp.co.futureantiques.webapptraining.repository.resipeishikawa.VegetableIshikawaRepository;
import jp.co.futureantiques.webapptraining.repository.specification.ResipeIshikawaSpecification;
import jp.co.futureantiques.webapptraining.service.ResipeIshikawaService;

/**
 *ResipeIshikawaのサービス実装クラス
 *
 * @author t.ishikawa
 */
@Service
public class ResipeIshikawaServiceImpl implements ResipeIshikawaService {

	/**ResipeMainリポジトリ*/
	private final ResipeIshikawaMainRepository resipeIshikawaMainRepository;

	/**Vegetableリポジトリ*/
	private final VegetableIshikawaRepository vegetableIshikawaRepository;

	/**Genreリポジトリ*/
	private final GenreIshikawaRepository genreIshikawaRepository;

	/**
	 * コンストラクタ
	 *
	 * @param ResipeIshikawaMainRepository resipeIshikawaMainRepository
	 * @param VegetableIshikawaMainRepository vegetableIshikawaMainRepository
	 * @param GenreIshikawaMainRepository genreIshikawaMainRepository
	 */
	@Autowired
	public ResipeIshikawaServiceImpl(ResipeIshikawaMainRepository resipeIshikawaMainRepository,
			VegetableIshikawaRepository vegetableIshikawaRepository,GenreIshikawaRepository genreIshikawaRepository) {
		this.resipeIshikawaMainRepository = resipeIshikawaMainRepository;
		this.vegetableIshikawaRepository = vegetableIshikawaRepository;
		this.genreIshikawaRepository = genreIshikawaRepository;
	}

	@Override
	public List<VegetableIshikawa> getListVegetable(){

		//VegetableテーブルをID順に取得する
		return vegetableIshikawaRepository.findAll(new Sort(Sort.Direction.ASC,"id"));
	}

	@Override
	public List<GenreIshikawa> getListGenre(){

		//GenreテーブルをID順に取得する
		return genreIshikawaRepository.findAll(new Sort(Sort.Direction.ASC,"id"));
	}

	@Override
	public Page<ResipeMainIshikawa> getPageResipe(ResipeIshikawaSearchForm form, Pageable pageable) {

		//検索条件を生成しResipeIsikawaMainテーブルのレコードを取得する
		return resipeIshikawaMainRepository.findAll(ResipeIshikawaSpecification.generateResipeIshiawaSpecification(form),pageable);
	}

	@Override
	public List<ResipeMainIshikawa> getListResipe(final ResipeIshikawaSearchForm form){

		//検索条件を生成しResipeIsikawaMainテーブルのレコードを取得する
		return resipeIshikawaMainRepository.findAll(ResipeIshikawaSpecification.generateResipeIshiawaSpecification(form));
	}

	@Override
	public ResipeMainIshikawa getResipe(final long id) {

		//ResipeIshikawaMainテーブルを主キー検索する
		return resipeIshikawaMainRepository.findOne(id);
	}
}