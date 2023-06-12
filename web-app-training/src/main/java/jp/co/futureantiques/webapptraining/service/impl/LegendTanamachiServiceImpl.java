package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.apexLegendsLegendTanamachi.ClassTanamachi;
import jp.co.futureantiques.webapptraining.model.apexLegendsLegendTanamachi.FromTanamachi;
import jp.co.futureantiques.webapptraining.model.apexLegendsLegendTanamachi.LegendMainTanamachi;
import jp.co.futureantiques.webapptraining.model.form.apexLegendsLegendTanamachi.LegendInputForm;
import jp.co.futureantiques.webapptraining.model.form.apexLegendsLegendTanamachi.LegendSearchForm;
import jp.co.futureantiques.webapptraining.repository.legendTanamachi.ClassTanamachiRepository;
import jp.co.futureantiques.webapptraining.repository.legendTanamachi.FromTanamachiRepository;
import jp.co.futureantiques.webapptraining.repository.legendTanamachi.LegendMainTanamachiRepository;
import jp.co.futureantiques.webapptraining.repository.specification.LegendTanamachiSpecification;
import jp.co.futureantiques.webapptraining.service.LegendTanamachiService;

/**
 * LegendTanamachiのサービス実装クラス
 *
 * @author future
 */
@Service
public class LegendTanamachiServiceImpl implements LegendTanamachiService {

	/** LegendMainTanamachiリポジトリ */
	private final LegendMainTanamachiRepository legendMainTanamachiRepository;

	/** FromTanamachiリポジトリ */
	private final FromTanamachiRepository fromTanamachiRepository;

	/** ClassTanamachiリポジトリ */
	private final ClassTanamachiRepository classTanamachiRepository;

	/**
	 * コンストラクタ
	 *
	 * @param LegendMainTanamachiRepository legendMainTanamachiRepository
	 * @param FromTanamachiRepository fromTanamachiRepository
	 * @param ClassTanamachiRepository  classTanamachiRepository
	 */
	@Autowired
	public LegendTanamachiServiceImpl(LegendMainTanamachiRepository legendMainTanamachiRepository,
			FromTanamachiRepository fromTanamachiRepository,
			ClassTanamachiRepository classTanamachiRepository) {
		this.legendMainTanamachiRepository = legendMainTanamachiRepository;
		this.fromTanamachiRepository = fromTanamachiRepository;
		this.classTanamachiRepository = classTanamachiRepository;
	}

	@Override
	public List<FromTanamachi> getListFromTanamachi() {
		// FromTanamachiテーブルのレコードをID順に取得する
		return fromTanamachiRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<ClassTanamachi> getListClassTanamachi() {
		// ClassTanamachiテーブルのレコードをID順に取得する
		return classTanamachiRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<LegendMainTanamachi> getPageLegend(LegendSearchForm form, Pageable pageable) {
		// 検索条件を生成しLegendMainTanamachiのテーブルのレコードを取得する
		return legendMainTanamachiRepository.findAll(LegendTanamachiSpecification.genarateLegendSpecification(form),
				pageable);
	}

	@Override
	public List<LegendMainTanamachi> getListLegend(final LegendSearchForm form) {

		// 検索条件を生成しLegendMainTanamachiのテーブルのレコードを取得する
		return legendMainTanamachiRepository.findAll(LegendTanamachiSpecification.genarateLegendSpecification(form));

	}

	@Override
	public LegendMainTanamachi getLegend(long legendId) {

		// LegendMainTanamachiテーブルを主キー検索する
		return legendMainTanamachiRepository.findOne(legendId);
	}

	@Override
	public LegendMainTanamachi insertLegend(LegendInputForm form) {

		// LegendMainTanamachiテーブルに新規でデータを登録する
		final LegendMainTanamachi legendMainTanamachi = form.convertToLegendMainTanamachiForInsert();
		return legendMainTanamachiRepository.save(legendMainTanamachi);
	}

	@Override
	public void deleteLegendById(long legendId) {

		//更新対象のレコードを取得する
		LegendMainTanamachi legendMainTanamachi = legendMainTanamachiRepository.findOne(legendId);
		if (legendMainTanamachi != null) {

			//更新対象のレコードが存在する場合削除フラグを1にする
			legendMainTanamachiRepository.delete(legendId);
		}
	}

	@Override
	public LegendMainTanamachi updateLegend(final LegendInputForm form) {

		// 更新対象のレコードを取得する
		LegendMainTanamachi legendMainTanamachi = legendMainTanamachiRepository.findOne((long) form.getLegendId());
		if (legendMainTanamachi != null) {

			//更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(legendMainTanamachi.getUpdateDate()))) {

				//チェックOKの場合、更新
				legendMainTanamachi = form.convertToLegendMainTanamachiForUpdate(legendMainTanamachi);
				return legendMainTanamachiRepository.saveAndFlush(legendMainTanamachi);
			}
		}
		return null;
	}

	@Override
	public List<Long> restoreLegend(ArrayList<Long> ids) {
		//復元失敗レコードのidを格納するリスト
		List<Long> failedIds = new ArrayList<>();

		//idをもとにレコードを取得する
		List<LegendMainTanamachi> legendMainTanamachis = legendMainTanamachiRepository.findAll(ids);

		//レコードの削除フラグが１のとき復元
		for (LegendMainTanamachi legendMainTanamachi : legendMainTanamachis) {
			if (legendMainTanamachi.getDelFlg() == 1) {

				// 対象の論理削除済みレコードを復元する
				legendMainTanamachiRepository.restore(ids);
			} else {

				//復元不可のレコードのIDを返す
				failedIds.add(legendMainTanamachi.getId());
			}
		}

		//復元に失敗したレコードのidリストを返す
		return failedIds;

	}

	@Override
	public boolean deleteLegendComp(ArrayList<Long> ids) {
		//物理削除成功・失敗の指標
		boolean found = false;

		//取り出したレコードのidを格納する用のリスト
		ArrayList<Long> hitIds = new ArrayList<>();

		//削除対象のレコードを取得する
		List<LegendMainTanamachi> legendMainTanamachis = legendMainTanamachiRepository.findAll(ids);

		//削除対象のレコードが存在するとき
		if (!legendMainTanamachis.isEmpty()) {

			//レコードを一つずつ取り出し、idをhitIdsに格納
			for (LegendMainTanamachi legendMainTanamachi : legendMainTanamachis) {

				hitIds.add(legendMainTanamachi.getId());
			}

			//取得できたレコードを削除
			legendMainTanamachiRepository.deleteComp(hitIds);

			found = true;
		}

		return found;
	}

}
