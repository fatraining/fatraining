package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.ringoTakizawa.RingoTakizawaInputForm;
import jp.co.futureantiques.webapptraining.model.form.ringoTakizawa.RingoTakizawaSearchForm;
import jp.co.futureantiques.webapptraining.model.ringoTakizawa.RingoCdTitleTakizawa;
import jp.co.futureantiques.webapptraining.model.ringoTakizawa.RingoMainTakizawa;
import jp.co.futureantiques.webapptraining.model.ringoTakizawa.RingoSongImageTakizawa;
import jp.co.futureantiques.webapptraining.repository.ringoTakizawa.RingoCdTitleTakizawaRepository;
import jp.co.futureantiques.webapptraining.repository.ringoTakizawa.RingoMainTakizawaRepository;
import jp.co.futureantiques.webapptraining.repository.ringoTakizawa.RingoSongImageTakizawaRepository;
import jp.co.futureantiques.webapptraining.repository.specification.RingoTakizawaSpecification;
import jp.co.futureantiques.webapptraining.service.RingoTakizawaService;

/**
 * RingoTakizawaのサービス実装クラス
 *
 * @author Mai Takizawa　
 */
@Service

public class RingoTakizawaServiceImpl implements RingoTakizawaService {

	/** RingoMainTakizawaリポジトリ */
	private final RingoMainTakizawaRepository ringoMainTakizawaRepository;

	/** RingoCdTitleTakizawaリポジトリ */
	private final RingoCdTitleTakizawaRepository ringoCdTitleTakizawaRepository;

	/** RingoSongImageTakizawaリポジトリ */
	private final RingoSongImageTakizawaRepository ringoSongImageTakizawaRepository;

	/**
	 * コンストラクタ
	 *
	 * @param RingoMainTakizawaRepository ringoMainTakizawaRepository
	 * @param RingoCdTitleTakizawaRepository ringoCdTitleTakizawaRepository
	 * @param RingoSongImageTakizawaRepository ringoSongImageTakizawa
	 */
	@Autowired
	public RingoTakizawaServiceImpl(RingoMainTakizawaRepository ringoMainTakizawaRepository, RingoCdTitleTakizawaRepository ringoCdTitleTakizawaRepository,
			RingoSongImageTakizawaRepository ringoSongImageTakizawaRepository) {
		this.ringoMainTakizawaRepository = ringoMainTakizawaRepository;
		this.ringoCdTitleTakizawaRepository = ringoCdTitleTakizawaRepository;
		this.ringoSongImageTakizawaRepository = ringoSongImageTakizawaRepository;
	}

	//サービスの下に変更有
	@Override
	public List<RingoCdTitleTakizawa> getListRingoCdTitleTakizawa() {

		// RingoCdTitleTakizawaテーブルのレコードをID順に取得する
		return ringoCdTitleTakizawaRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	//サービスの下の方に変更有
	@Override
	public List<RingoSongImageTakizawa> getListRingoSongImageTakizawa() {

		// RingoSongImageTakizawaテーブルのレコードをID順に取得する
		return ringoSongImageTakizawaRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<RingoMainTakizawa> getPageRingo(final RingoTakizawaSearchForm form, final Pageable pageable) {

		// 検索条件を生成しRingoMainTakizawaテーブルのレコードを取得する
		return ringoMainTakizawaRepository.findAll(RingoTakizawaSpecification.generateRingoTakizawaSpecification(form), pageable);
	}

	@Override
	public List<RingoMainTakizawa> getListRingoMainTakizawa(final RingoTakizawaSearchForm form) {

		// 検索条件を生成しRingoMainTakizawaテーブルのレコードを取得する
		return ringoMainTakizawaRepository.findAll(RingoTakizawaSpecification.generateRingoTakizawaSpecification(form));
	}

	@Override
	public  RingoMainTakizawa getRingoMainTakizawa(final long id) {

		// RingoMainTakizawaテーブルを主キー検索する
		return ringoMainTakizawaRepository.findOne(id);
	}

	@Override
	public RingoMainTakizawa insertRingo(final RingoTakizawaInputForm form) {

		// RingoMainTakizawaテーブルに新規でデータを登録する
		final RingoMainTakizawa ringoMainTakizawa = form.convertToRingoMainTakizawaForInsert();
		return ringoMainTakizawaRepository.save(ringoMainTakizawa);
	}

	@Override
	public RingoMainTakizawa updateRingo(final RingoTakizawaInputForm form) {

		// 更新対象のレコードを取得する
		RingoMainTakizawa ringoMainTakizawa = ringoMainTakizawaRepository.findOne((long) form.getId());
		if (ringoMainTakizawa != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(ringoMainTakizawa.getUpdateDate()))) {

				// チェックOKの場合、更新
				ringoMainTakizawa = form.convertToRingoMainTakizawaForUpdate(ringoMainTakizawa);
				return ringoMainTakizawaRepository.saveAndFlush(ringoMainTakizawa);
			}
		}
		return null;
	}

	@Override
	public void deleteRingoById(final long id) {

		// 更新対象のレコードを取得する
		RingoMainTakizawa ringoMainTakizawa = ringoMainTakizawaRepository.findOne(id);
		if (ringoMainTakizawa != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			ringoMainTakizawaRepository.delete(id);
		}
	}

	@Override
	public void deleteRingoComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		ringoMainTakizawaRepository.deleteComp(ids);
	}


	@Override
	public List<RingoCdTitleTakizawa> getRingoCdTitleTakizawa() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public List<RingoSongImageTakizawa> getRingoSongImageTakizawa() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}


}
