package jp.co.futureantiques.webapptraining.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.amecomiishida.AmecomiCharIshida;
import jp.co.futureantiques.webapptraining.model.amecomiishida.CompanyIshida;
import jp.co.futureantiques.webapptraining.model.amecomiishida.SideIshida;
import jp.co.futureantiques.webapptraining.model.form.amecomiIshida.AmecomiIshidaSearchForm;
import jp.co.futureantiques.webapptraining.repository.amecomiishida.AmecomiCharIshidaRepository;
import jp.co.futureantiques.webapptraining.repository.amecomiishida.CompanyIshidaRepository;
import jp.co.futureantiques.webapptraining.repository.amecomiishida.SideIshidaRepository;
import jp.co.futureantiques.webapptraining.repository.specification.AmecomiIshidaSpecification;
import jp.co.futureantiques.webapptraining.service.AmecomiIshidaService;

/**
 * AmecomiIshidaのサービス実装クラス
 * @author ishida
 */
@Service
public class AmecomiIshidaServiceImpl implements AmecomiIshidaService {

	/** AmecomiCharIshidaのリポジトリ */
	private final AmecomiCharIshidaRepository amecomiCharIshidaRepository;

	/** CompanyIshidaのリポジトリ */
	private final CompanyIshidaRepository companyIshidaRepository;

	/** SideIshidaのリポジトリ */
	private final SideIshidaRepository sideIshidaRepository;

	/**
	 * コンストラクタ
	 * @param AmecomiCharIshidaRepository amecomiCharIshidaRepository
	 * @param CompanyIshidaRepository  companyIshidaRepository
	 * @param SideIshidaRepository sideIshidaRepository
	 */
	@Autowired
	public AmecomiIshidaServiceImpl(AmecomiCharIshidaRepository amecomiCharIshidaRepository,
			CompanyIshidaRepository companyIshidaRepository,
			SideIshidaRepository sideIshidaRepository) {
		this.amecomiCharIshidaRepository = amecomiCharIshidaRepository;
		this.companyIshidaRepository = companyIshidaRepository;
		this.sideIshidaRepository = sideIshidaRepository;
	}

	@Override
	public List<CompanyIshida> getListCompanyIshida(){

		// CompanyIshidaテーブルのレコードをID順に取得する
		return companyIshidaRepository.findAll(new Sort(Sort.Direction.ASC,"id"));
	}

	@Override
	public List<SideIshida> getListSideIshida(){

		// SideIshidaテーブルのレコードをID順に取得する
		return sideIshidaRepository.findAll(new Sort(Sort.Direction.ASC,"id"));
	}

	@Override
	public Page<AmecomiCharIshida> getPageAmecomiIshida(final AmecomiIshidaSearchForm form,final Pageable pageable){

		// 検索条件を生成しAmecomiCharIshidaテーブルのレコードを取得する
		return amecomiCharIshidaRepository.findAll(AmecomiIshidaSpecification.generateAmecomiIshidaSpecification(form), pageable);
	}

	@Override
	public List<AmecomiCharIshida> getListAmecomiIshida(final AmecomiIshidaSearchForm form){

		// 検索条件を生成しAmecomiCharIshidaテーブルのレコードを取得する
		return amecomiCharIshidaRepository.findAll(AmecomiIshidaSpecification.generateAmecomiIshidaSpecification(form));
	}

	@Override
	public AmecomiCharIshida getAmecomiIshida(final long id) {

		// AmecomiCharIshidaテーブルを主キー検索する
		return amecomiCharIshidaRepository.findOne(id);
	}

//	@Override
//	public void deleteAmecomiCharIshidaById(final long id) {
//		// 更新対象のレコードを取得する
//		AmecomiCharIshida amecomiCharIshida=amecomiCharIshidaRepository.findOne(id);
//
//		// 更新対象のレコードが存在する場合、削除フラグを1にする
//		if(amecomiCharIshida !=null) {
//			amecomiCharIshidaRepository.delete(id);
//		}
//	}
}
