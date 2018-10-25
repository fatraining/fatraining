package jp.co.futureantiques.webapptraining.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.musicalpieceSearch.MusicalpieceSearchMainForm;
import jp.co.futureantiques.webapptraining.model.musicalpieceSearch.AlbumRuike;
import jp.co.futureantiques.webapptraining.model.musicalpieceSearch.ArianaMainRuike;
import jp.co.futureantiques.webapptraining.model.musicalpieceSearch.ColaboRuike;
import jp.co.futureantiques.webapptraining.repository.MusicalpieceSearch.AlbumNameRepository;
import jp.co.futureantiques.webapptraining.repository.MusicalpieceSearch.ArianaMainRepository;
import jp.co.futureantiques.webapptraining.repository.MusicalpieceSearch.ColaboNameRepository;
import jp.co.futureantiques.webapptraining.repository.specification.MusicalpieceSpecification;
import jp.co.futureantiques.webapptraining.service.MusicalpieceSearchService;

/**
 * MusicalpieceSearchのサービスの実装クラス
 *
 * @author future
 */
@Service
public class MusicalpieceSearchServiceImpl implements MusicalpieceSearchService {

	/** ArianaMainRepository */
	private final ArianaMainRepository arianaMainRepository;
	/** AlbumNameRepository */
	private final AlbumNameRepository albumNameRepository;
	/** ColaboNameRepository */
	private final ColaboNameRepository colaboNameRepository;

	/**
	 * コンストラクター
	 *
	 * @param arianaMainRepository arianaMainRepository
	 * @param albumRuikeRepository albumNameRepository
	 * @param colaboNameRepository colaboNameRepository
	 */
	@Autowired
	public MusicalpieceSearchServiceImpl(ArianaMainRepository arianaMainRepository,
			AlbumNameRepository albumRuikeRepository, ColaboNameRepository colaboNameRepository) {
		this.arianaMainRepository = arianaMainRepository;
		this.albumNameRepository = albumRuikeRepository;
		this.colaboNameRepository = colaboNameRepository;
	}

	@Override
	public List<AlbumRuike> getListAlbumRuike() {

		//albumruikeテーブルのレコードをID順に取得
		return albumNameRepository.findAll(new Sort(Sort.Direction.ASC, "albumId"));
	}

	@Override
	public List<ColaboRuike> getListColaboRuike() {

		//colaboruikeテーブルのレコードをID順に取得
		return colaboNameRepository.findAll(new Sort(Sort.Direction.ASC, "colaboId"));
	}

	@Override
	public Page<ArianaMainRuike> getPageArianaMainRuike(final MusicalpieceSearchMainForm form,

			//検索条件を生成しarianaMainRuikeのレコードを取得する
			final Pageable pageable) {
		return arianaMainRepository.findAll(MusicalpieceSpecification.generateArianaSpecification(form), pageable);

	}

	@Override
	public List<ArianaMainRuike> getListAriana(final MusicalpieceSearchMainForm form) {

		//検索条件を生成し、ArianaMainRuikeのレコードを取得する
		return arianaMainRepository.findAll(MusicalpieceSpecification.generateArianaSpecification(form));
	}

	@Override
	public ArianaMainRuike getAriana(final long single_Id) {

		//ArianaMainRuikeテーブルを主キーにして検索する
		return arianaMainRepository.findOne(single_Id);
	}
}

//
//	@Override
//	public MovieMain insertMovie(final MovieSampleInputForm form) {
//
//		// MovieMainテーブルに新規でデータを登録する
//		final MovieMain movieMain = form.convertToMovieMainForInsert();
//		return movieMainRepository.save(movieMain);
//	}
//
//	@Override
//	public MovieMain updateMovie(final MovieSampleInputForm form) {
//
//		// 更新対象のレコードを取得する
//		MovieMain movieMain = movieMainRepository.findOne((long) form.getId());
//		if (movieMain != null) {
//
//			// 更新対象のレコードが存在する場合排他チェック
//			if (form.getUpdateDate().equals(String.valueOf(movieMain.getUpdateDate()))) {
//
//				// チェックOKの場合、更新
//				movieMain = form.convertToMovieMainForUpdate(movieMain);
//				return movieMainRepository.saveAndFlush(movieMain);
//			}
//		}
//		return null;
//	}
//
//	@Override
//	public void deleteMovieById(final long id) {
//
//		// 更新対象のレコードを取得する
//		MovieMain movieMain = movieMainRepository.findOne(id);
//		if (movieMain != null) {
//
//			// 更新対象のレコードが存在する場合、削除フラグを1にする
//			movieMainRepository.delete(id);
//		}
//	}
//
//	@Override
//	public void deleteMovieComp(final ArrayList<Long> ids) {
//
//		// 対象のレコードを削除する
//		movieMainRepository.deleteComp(ids);
//	}
//
//}
//
//
//
