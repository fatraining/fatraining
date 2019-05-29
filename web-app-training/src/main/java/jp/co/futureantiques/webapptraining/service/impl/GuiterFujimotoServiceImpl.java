package jp.co.futureantiques.webapptraining.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.GuiterFujimoto.CompanyFujimoto;
import jp.co.futureantiques.webapptraining.model.GuiterFujimoto.GuiterMainFujimoto;
import jp.co.futureantiques.webapptraining.model.GuiterFujimoto.WoodFujimoto;
import jp.co.futureantiques.webapptraining.model.form.guiterFujimoto.GuiterSearchForm;
import jp.co.futureantiques.webapptraining.repository.guiterFujimoto.CompanyFujimotoRepository;
import jp.co.futureantiques.webapptraining.repository.guiterFujimoto.GuiterMainFujimotoRepository;
import jp.co.futureantiques.webapptraining.repository.guiterFujimoto.WoodFujimotoRepository;
import jp.co.futureantiques.webapptraining.repository.specification.GuiterFujimotoSpecification;
import jp.co.futureantiques.webapptraining.service.GuiterFujimotoService;


/**
 * GuiterMainFujimotoのサービス実装クラス
 * @author futureFUJIMOTO
 *
 */
@Service
public class GuiterFujimotoServiceImpl implements GuiterFujimotoService {

		/**GuiterMainFujimotoリポジトリ*/
		private final GuiterMainFujimotoRepository guiterMainFujimotoRepository;

		/**Companyリポジトリ*/
		private final CompanyFujimotoRepository companyFujimotoRepository;

		/**Woodレポジトリ
		 * private final */
		private final WoodFujimotoRepository woodFujimotoRepository;

		/**
		 * コンストラクタ
		 *
		 * @param GuiterMainFujimotoRepository guiter
		 * @param CompanyFujimotoRepository companyFujimotoRepository
		 * @param WoodFujimotoRepository woodFujimotoRepository
		 */
		@Autowired
		public GuiterFujimotoServiceImpl(GuiterMainFujimotoRepository guiterMainFujimotoRepository,
				CompanyFujimotoRepository companyFujimotoRepository, WoodFujimotoRepository woodFujimotoRepository) {
			this.guiterMainFujimotoRepository=guiterMainFujimotoRepository;
			this.companyFujimotoRepository=companyFujimotoRepository;
			this.woodFujimotoRepository=woodFujimotoRepository;
		}

		@Override
		public List<CompanyFujimoto>getListCompanyFujimoto(){
			//company_fujimotoテ－ブルノレコードをID順に取得する。
			return companyFujimotoRepository.findAll(new Sort(Sort.Direction.ASC,"id"));
		}

		@Override
		public List<WoodFujimoto> getListWoodFujimoto(){

			//wood_fujimotoテーブルのレコードをID順に取得する
			return woodFujimotoRepository.findAll(new Sort(Sort.Direction.ASC,"id"));
		}

		@Override
		public Page<GuiterMainFujimoto> getPageGuiter(GuiterSearchForm form,Pageable pageable )
		{//検索条件を生成しguiter_main_fujimotoテーブルのレコードを取得する。
			return guiterMainFujimotoRepository.findAll(GuiterFujimotoSpecification.generateGuiterSpecification(form),
				(Pageable) pageable);
		}

		@Override
		public List<GuiterMainFujimoto> getListGuiter(final GuiterSearchForm form) {

			//検索条件を生成しguiter_main_fujimotoテーブルのレコードを取得する
			return guiterMainFujimotoRepository.findAll(GuiterFujimotoSpecification.generateGuiterSpecification(form));
		}

		@Override
		public GuiterMainFujimoto getGuiter(long id) {

			//guiter_main_fujimotoテーブルを主キー検索する
			return guiterMainFujimotoRepository.findOne(id);
		}


}
