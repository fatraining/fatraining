package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.boowyWaki.BoowyMainWaki;
import jp.co.futureantiques.webapptraining.model.boowyWaki.GenreWaki;
import jp.co.futureantiques.webapptraining.model.boowyWaki.SongwriterWaki;
import jp.co.futureantiques.webapptraining.model.form.boowyWaki.BoowyWakiInputForm;
import jp.co.futureantiques.webapptraining.model.form.boowyWaki.BoowyWakiSearchForm;
import jp.co.futureantiques.webapptraining.repository.boowyWaki.BoowyMainWakiRepository;
import jp.co.futureantiques.webapptraining.repository.boowyWaki.GenreWakiRepository;
import jp.co.futureantiques.webapptraining.repository.boowyWaki.SongwriterWakiRepository;
import jp.co.futureantiques.webapptraining.repository.specification.BoowyWakiSpecification;
import jp.co.futureantiques.webapptraining.service.BoowyWakiService;

/**
 * BoowyWakiのサービス実装クラス
 *
 * リポジトリの上位
 *
 * @author WAKI
 */
@Service
public class BoowyWakiServiceImpl implements BoowyWakiService {

	/** BoowyMainリポジトリ */
	private final BoowyMainWakiRepository boowyMainWakiRepository;

	/** Genreリポジトリ */
	private final GenreWakiRepository genreWakiRepository;

	/** Songwriterリポジトリ */
	private final SongwriterWakiRepository songwriterWakiRepository;

	/**
	 * コンストラクタ
	 *
	 * @param BoowyMainWakiRepository boowyMainWakiRepository
	 * @param GenreWakiRepository genreWakiRepository
	 * @param SongwriterWakiRepository songwriterWakiRepository
	 */
	@Autowired
	public BoowyWakiServiceImpl(BoowyMainWakiRepository boowyMainWakiRepository,
			GenreWakiRepository genreWakiRepository, SongwriterWakiRepository songwriterWakiRepository) {
		this.boowyMainWakiRepository = boowyMainWakiRepository;
		this.genreWakiRepository = genreWakiRepository;
		this.songwriterWakiRepository = songwriterWakiRepository;
	}

	@Override
	public List<GenreWaki> getListGenreWaki() {

		//GenreテーブルのレコードをID順に取得する
		return genreWakiRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<SongwriterWaki> getListSongwriterWaki() {

		//SongwriterテーブルのレコードをID順に取得する
		return songwriterWakiRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<BoowyMainWaki> getPageBoowyMainWaki(final BoowyWakiSearchForm form, final Pageable pageable) {

		//検索条件を生成しBoowyMainWakiテーブルのレコードを取得する
		return boowyMainWakiRepository.findAll(BoowyWakiSpecification.generateBoowyWakiSpecification(form), pageable);
	}

	@Override
	public List<BoowyMainWaki> getListBoowyMainWaki(final BoowyWakiSearchForm form) {

		//検索条件を生成しBoowyMainWakiテーブルのレコードを取得
		return boowyMainWakiRepository.findAll(BoowyWakiSpecification.generateBoowyWakiSpecification(form));
	}

	@Override
	public BoowyMainWaki getBoowyMainWaki(final long id) {

		//BoowyMainテーブルを主キー検索する
		return boowyMainWakiRepository.findOne(id);
	}

	@Override
	public BoowyMainWaki insertBoowyMainWaki(final BoowyWakiInputForm form) {

		// BoowyMainWakiテーブルに新規でデータを登録する
		final BoowyMainWaki boowyMainWaki = form.convertToBoowyMainWakiForInsert();
		return boowyMainWakiRepository.save(boowyMainWaki);
	}

	@Override
	public BoowyMainWaki updateBoowyMainWaki(final BoowyWakiInputForm form) {

		// 更新対象のレコードを取得する
		BoowyMainWaki boowyMainWaki = boowyMainWakiRepository.findOne((long) form.getId());
		if (boowyMainWaki != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(boowyMainWaki.getUpdateDate()))) {

				// チェックOKの場合、更新
				boowyMainWaki = form.convertToBoowyMainWakiForUpdate(boowyMainWaki);
				return boowyMainWakiRepository.saveAndFlush(boowyMainWaki);
			}
		}
		return null;
	}

	@Override
	public void deleteBoowyMainWakiById(final long id) {

		//更新対象のレコードを取得する
		BoowyMainWaki boowyMainWaki = boowyMainWakiRepository.findOne(id);
		if (boowyMainWaki != null) {

			//更新対象のレコードが存在する場合、削除フラグを1にする
			boowyMainWakiRepository.delete(id);
		}
	}

	@Override
	public void deleteBoowyMainWakiComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		boowyMainWakiRepository.deleteComp(ids);
	}
}