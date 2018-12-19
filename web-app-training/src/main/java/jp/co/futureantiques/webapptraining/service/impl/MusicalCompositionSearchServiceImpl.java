package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.musicalcompositiontakei.MusicalCompositionInputForm;
import jp.co.futureantiques.webapptraining.model.form.musicalcompositiontakei.MusicalCompositionSearchMainForm;
import jp.co.futureantiques.webapptraining.model.musicalcomposition.takei.AlbumTakei;
import jp.co.futureantiques.webapptraining.model.musicalcomposition.takei.GenreTakei;
import jp.co.futureantiques.webapptraining.model.musicalcomposition.takei.MusicalCompositionMainTakei;
import jp.co.futureantiques.webapptraining.repository.MusicaleCompositionSearch.AlbumTakeiRepository;
import jp.co.futureantiques.webapptraining.repository.MusicaleCompositionSearch.GenreTakeiRepository;
import jp.co.futureantiques.webapptraining.repository.MusicaleCompositionSearch.MusicalCompositionMainTakeiRepository;
import jp.co.futureantiques.webapptraining.service.MusicalCompositionSearchService;

/**
 * MusicalCompositionSearchのサービス実装クラス
 *
 * @author takei
 */
@Service
public class MusicalCompositionSearchServiceImpl implements MusicalCompositionSearchService {

	/**  MusicalCompositionMainTakeiリポジトリ */
	private final MusicalCompositionMainTakeiRepository musicalCompositionMainTakeiRepository;

	/**  GenreTakeiリポジトリ */
	private final GenreTakeiRepository genreTakeiRepository;

	/**  AlbumTakeiリポジトリ */
	private final AlbumTakeiRepository albumTakeiRepository;

	/**
	 * コンストラクタ
	 *
	 * @param MusicalCompositionMainTakeiRepository musicalCompositionMainTakeiRepository
	 * @param GenreRepository genreRepository
	 * @param AlbumTakeiRepository  albumTakeiRepository
	 */
	@Autowired
	public MusicalCompositionSearchServiceImpl(
			MusicalCompositionMainTakeiRepository musicalCompositionMainTakeiRepository,
			GenreTakeiRepository genreTakeiRepository, AlbumTakeiRepository albumTakeiRepository) {
		this.musicalCompositionMainTakeiRepository = musicalCompositionMainTakeiRepository;
		this.genreTakeiRepository = genreTakeiRepository;
		this.albumTakeiRepository = albumTakeiRepository;
	}

	@Override
	public List<GenreTakei> getListGenreTakei() {

		//GenreTakeiテーブルにID取得
		return genreTakeiRepository.findAll(new Sort(Sort.Direction.ASC, "genreId"));
	}

	@Override
	public List<AlbumTakei> getListAlbumTakei() {

		//AlbumTakeiテーブルにID取得
		return albumTakeiRepository.findAll(new Sort(Sort.Direction.ASC, "albumId"));
	}

	@Override
	public Page<MusicalCompositionMainTakei> getPageMusicalComposition(final MusicalCompositionSearchMainForm form,
			final Pageable pageable) {

		// 検索条件を生成しMusicalCompositionMainTakeiテーブルのレコードを取得する
		return musicalCompositionMainTakeiRepository
				.findAll(jp.co.futureantiques.webapptraining.repository.specification.MusicalCompositionSpecification
						.generateMusicalCompositionSpecification(form), pageable);
	}

	@Override
	public List<MusicalCompositionMainTakei> getListMusicalComposition(final MusicalCompositionSearchMainForm form) {

		// 検索条件を生成しMusicalCompositionMainTakeiテーブルのレコードを取得する
		return musicalCompositionMainTakeiRepository
				.findAll(jp.co.futureantiques.webapptraining.repository.specification.MusicalCompositionSpecification
						.generateMusicalCompositionSpecification(form));
	}

	@Override
	public MusicalCompositionMainTakei getMusicalComposition(final long id) {

		// MusicalCompositionMainTakeiテーブルを主キー検索する
		return musicalCompositionMainTakeiRepository.findOne(id);
	}

	@Override
	public MusicalCompositionMainTakei insertMusicalComposition(final MusicalCompositionInputForm form) {

		// MusicalCompositionMainTakeiテーブルに新規でデータを登録する
		final MusicalCompositionMainTakei musicalCompositionMainTakei = form
				.convertToMusicalCompositionSearchMainForInsert();
		return musicalCompositionMainTakeiRepository.save(musicalCompositionMainTakei);
	}

	@Override
	public MusicalCompositionMainTakei updateMusicalComposition(final MusicalCompositionInputForm form) {

		// 更新対象のレコードを取得する
		MusicalCompositionMainTakei musicalCompositionMainTakei = musicalCompositionMainTakeiRepository
				.findOne((long) form.getId());
		if (musicalCompositionMainTakei != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(musicalCompositionMainTakei.getUpdateDate()))) {

				// チェックOKの場合、更新
				musicalCompositionMainTakei = form
						.convertTomusicalCompositionMainTakeiForUpdate(musicalCompositionMainTakei);
				return musicalCompositionMainTakeiRepository.saveAndFlush(musicalCompositionMainTakei);
			}
		}
		return null;
	}

	@Override
	public void deleteMusicalCompositionById(final long id) {

		// 更新対象のレコードを取得する
		MusicalCompositionMainTakei musicalCompositionMainTakei = musicalCompositionMainTakeiRepository.findOne(id);
		if (musicalCompositionMainTakei != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			musicalCompositionMainTakeiRepository.delete(id);
		}
	}

	@Override
	public void deleteMusicalCompositionComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		musicalCompositionMainTakeiRepository.deleteComp(ids);
	}
}