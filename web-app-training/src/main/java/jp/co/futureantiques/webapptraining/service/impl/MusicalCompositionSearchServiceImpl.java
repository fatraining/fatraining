package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.from.musicalcomposition.takei.MusicalCompositionInputForm;
import jp.co.futureantiques.webapptraining.model.from.musicalcomposition.takei.MusicalCompositionSearchMainForm;
import jp.co.futureantiques.webapptraining.model.musicalcomposition.takei.AlbumTakei;
import jp.co.futureantiques.webapptraining.model.musicalcomposition.takei.GenreTakei;
import jp.co.futureantiques.webapptraining.model.musicalcomposition.takei.MusicalCompositionMainTakei;
import jp.co.futureantiques.webapptraining.repository.MusicaleCompositionSearch.AlbumTakeiRepository;
import jp.co.futureantiques.webapptraining.repository.MusicaleCompositionSearch.GenreTakeiRepository;
import jp.co.futureantiques.webapptraining.repository.MusicaleCompositionSearch.MusicalCompositionMainTakeiRepository;
import jp.co.futureantiques.webapptraining.service.MusicalCompositionSearchService;


@Service
public class MusicalCompositionSearchServiceImpl implements MusicalCompositionSearchService{


	//private static final Sort MusicalCompositionSpecification = null;

	/**  MusicalCompositionSearchMainリポジトリ */
	private final MusicalCompositionMainTakeiRepository  musicalCompositionMainTakeiRepository;

	/**  GenreTakeiリポジトリ */
	private final GenreTakeiRepository genreTakeiRepository;

	/**  AlbumTakeiリポジトリ */
	private final AlbumTakeiRepository  albumTakeiRepository;



	/**
	 * コンストラクタ
	 *
	 * @param MusicalCompositionMainTakeiRepository musicalCompositionSearchMainRepository
	 * @param GenreRepository genreRepository
	 * @param AlbumTakeiRepository  albumTakeiRepository
	 */

	@Autowired
	public MusicalCompositionSearchServiceImpl (MusicalCompositionMainTakeiRepository musicalCompositionMainTakeiRepository,
	          GenreTakeiRepository genreTakeiRepository,AlbumTakeiRepository  albumTakeiRepository){

		this.musicalCompositionMainTakeiRepository=musicalCompositionMainTakeiRepository;
		this.genreTakeiRepository=genreTakeiRepository;
		this.albumTakeiRepository=albumTakeiRepository;
	}



	@Override
	public List<GenreTakei> getListGenreTakei() {
		//genretakeiテーブルにID取得
		return genreTakeiRepository.findAll(new Sort(Sort.Direction.ASC, "genreId"));
	}

	@Override
	public List<AlbumTakei> getListAlbumTakei(){
		//albumtakeiテーブルにID取得
		return albumTakeiRepository.findAll(new Sort(Sort.Direction.ASC,"albumId"));

	}
	@Override
	public Page<MusicalCompositionMainTakei> getPageMusicalComposition
    (final MusicalCompositionSearchMainForm form, final Pageable pageable){

		// 検索条件を生成しMusicalCompositionSearchMainテーブルのレコードを取得する
		//return musicalCompositionSearchMainRepository.findAll(MusicalCompositionSpecification.generateMusicalCompositionSpecification(form), pageable);
		return musicalCompositionMainTakeiRepository.findAll(jp.co.futureantiques.webapptraining.repository.specification.MusicalCompositionSpecification.generateMusicalCompositionSpecification(form), pageable);

	}

	@Override
	public List<MusicalCompositionMainTakei> getListMusicalComposition
	    (final MusicalCompositionSearchMainForm form){

		// 検索条件を生成しMusicalCompositionSearchMainテーブルのレコードを取得する
		return musicalCompositionMainTakeiRepository.findAll(jp.co.futureantiques.webapptraining.repository.specification.MusicalCompositionSpecification.generateMusicalCompositionSpecification(form));
	}

	@Override
	public MusicalCompositionMainTakei getMusicalComposition(final long id) {
		// MusicalCompositionSearchMainテーブルを主キー検索する
		return musicalCompositionMainTakeiRepository.findOne(id);

	}
	@Override
	public MusicalCompositionMainTakei insertMusicalComposition(final MusicalCompositionInputForm form) {

		// MovieMainテーブルに新規でデータを登録する
	final MusicalCompositionMainTakei musicalCompositionSearchMain
	               =form.convertToMusicalCompositionSearchMainForInsert();

	return musicalCompositionMainTakeiRepository.save(musicalCompositionSearchMain);
	}

	@Override
	public MusicalCompositionMainTakei updateMusicalComposition
	                                     (final  MusicalCompositionInputForm form) {
		// 更新対象のレコードを取得する
		MusicalCompositionMainTakei musicalCompositionSearchMain=
				musicalCompositionMainTakeiRepository.findOne((long) form.getId());

		if(musicalCompositionSearchMain!=null) {

			// 更新対象のレコードが存在する場合排他チェック
			if(form.getUpdateDate().equals(String.valueOf(musicalCompositionSearchMain.getUpdateDate()))) {

				musicalCompositionSearchMain=form.convertToMusicalCompositionSearchMainForUpdate(musicalCompositionSearchMain);

				return musicalCompositionMainTakeiRepository.saveAndFlush(musicalCompositionSearchMain);
			}
		}

		return null;


	}
	@Override
	public void deleteMusicalCompositionById(final long id) {

		// 更新対象のレコードを取得する
		MusicalCompositionMainTakei musicalCompositionSearchMain
		                            =musicalCompositionMainTakeiRepository.findOne(id);
		// 更新対象のレコードが存在する場合、削除フラグを1にする
		if(musicalCompositionSearchMain!=null) {

		}
	}
	@Override
	public void deleteMusicalCompositionComp(final ArrayList<Long> ids) {
		musicalCompositionMainTakeiRepository.deleteComp(ids);

	}



}
