package jp.co.futureantiques.webapptraining.service.impl;

	import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.yuruYokoyama.YuruInputForm;
import jp.co.futureantiques.webapptraining.model.form.yuruYokoyama.YuruSearchForm;
import jp.co.futureantiques.webapptraining.model.yuruYokoyama.YuruBelongYokoyama;
import jp.co.futureantiques.webapptraining.model.yuruYokoyama.YuruDataYokoyama;
import jp.co.futureantiques.webapptraining.model.yuruYokoyama.YuruFromYokoyama;
import jp.co.futureantiques.webapptraining.repository.specification.YuruYokoyamaSpecification;
import jp.co.futureantiques.webapptraining.repository.yuruYokoyama.YuruBelongRepository;
import jp.co.futureantiques.webapptraining.repository.yuruYokoyama.YuruDataRepository;
import jp.co.futureantiques.webapptraining.repository.yuruYokoyama.YuruFromRepository;
import jp.co.futureantiques.webapptraining.service.YuruYokoyamaService;

	/**
	 * YuruDataのサービス実装クラス
	 *
	 * @author future
	 */
	@Service
	public class YuruYokoyamaServiceImpl implements YuruYokoyamaService {

		/** YuruDataリポジトリ */
		private final YuruDataRepository yuruDataRepository;

		/** YuruBelongリポジトリ */
		private final YuruBelongRepository yuruBelongRepository;

		/** YuruFromリポジトリ */
		private final YuruFromRepository yuruFromRepository;

		/**
		 * コンストラクタ
		 *
		 * @param YuruFromRepository yuruFromRepository
		 * @param YuruBelongRepository yuruBelongRepository
		 * @param YuruDataRepository yuruDataRepository
		 */
		@Autowired
		public YuruYokoyamaServiceImpl(YuruDataRepository yuruDataRepository, YuruBelongRepository yuruBelongRepository,
				YuruFromRepository yuruFromRepository) {
			this.yuruDataRepository = yuruDataRepository;
			this.yuruBelongRepository = yuruBelongRepository;
			this.yuruFromRepository = yuruFromRepository;
		}

		@Override
		public List<YuruBelongYokoyama> getListYuruBelongYokoyama() {

			// YuruBelongテーブルのレコードをID順に取得する
			return yuruBelongRepository.findAll(new Sort(Sort.Direction.ASC, "belongId"));
		}

		@Override
		public List<YuruFromYokoyama> getListYuruFromYokoyama() {

			// YuruFromテーブルのレコードをID順に取得する
			return yuruFromRepository.findAll(new Sort(Sort.Direction.ASC, "fromId"));
		}

		@Override
		public Page<YuruDataYokoyama> getPageYuru(final YuruSearchForm form, final Pageable pageable) {

			// 検索条件を生成しYuruDataテーブルのレコードを取得する
			return yuruDataRepository.findAll(YuruYokoyamaSpecification.generateYuruSpecification(form), pageable);
		}

		@Override
		public List<YuruDataYokoyama> getListYuruDataYokoyama(final YuruSearchForm form) {

			// 検索条件を生成しYuruDataテーブルのレコードを取得する
			return yuruDataRepository.findAll(YuruYokoyamaSpecification.generateYuruSpecification(form));
		}

		@Override
		public YuruDataYokoyama getYuruDataYokoyama(final long id) {

			// MovieMainテーブルを主キー検索する
			return yuruDataRepository.findOne(id);
		}

		@Override
		public YuruDataYokoyama insertYuru(final YuruInputForm form) {

			// YuruDataテーブルに新規でデータを登録する
			final YuruDataYokoyama yuruData = form.convertToYuruDataForInsert();
			return yuruDataRepository.save(yuruData);
		}

		@Override
		public YuruDataYokoyama updateYuru(final YuruInputForm form) {

			// 更新対象のレコードを取得する
			YuruDataYokoyama yuruData = yuruDataRepository.findOne((long) form.getId());
			if (yuruData != null) {

				// 更新対象のレコードが存在する場合排他チェック
				if (form.getUpdateDate().equals(String.valueOf(yuruData.getUpdateDate()))) {

					// チェックOKの場合、更新
					yuruData = form.convertToYuruDataForUpdate(yuruData);
					return yuruDataRepository.saveAndFlush(yuruData);
				}
			}
			return null;
		}

		@Override
		public void deleteYuruById(final long id) {

			// 更新対象のレコードを取得する
			YuruDataYokoyama movieMain = yuruDataRepository.findOne(id);
			if (movieMain != null) {

				// 更新対象のレコードが存在する場合、削除フラグを1にする
				yuruDataRepository.delete(id);
			}
		}

		@Override
		public void deleteYuruComp(final ArrayList<Long> ids) {

			// 対象のレコードを削除する
			yuruDataRepository.deleteComp(ids);
		}
	}