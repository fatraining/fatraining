package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.comicYanai.ComicMainYanai;
import jp.co.futureantiques.webapptraining.model.comicYanai.GenreYanai;
import jp.co.futureantiques.webapptraining.model.comicYanai.PubcoYanai;
import jp.co.futureantiques.webapptraining.model.form.comicYanai.ComicYanaiInputForm;
import jp.co.futureantiques.webapptraining.model.form.comicYanai.ComicYanaiSearchForm;
import jp.co.futureantiques.webapptraining.repository.comicYanai.ComicMainYanaiRepository;
import jp.co.futureantiques.webapptraining.repository.comicYanai.GenreYanaiRepository;
import jp.co.futureantiques.webapptraining.repository.comicYanai.PubcoYanaiRepository;
import jp.co.futureantiques.webapptraining.repository.specification.ComicYanaiSpecification;
import jp.co.futureantiques.webapptraining.service.ComicYanaiService;
@Service
public class ComicYanaiServiceImpl implements ComicYanaiService {

	//リポジトリ
	private final ComicMainYanaiRepository comicMainYanaiRepository;
	private final GenreYanaiRepository genreYanaiRepository;
	private final PubcoYanaiRepository pubcoYanaiRepository;

	//コンストラクタ
	ComicYanaiServiceImpl(ComicMainYanaiRepository comicMainYanaiRepository, GenreYanaiRepository genreYanaiRepository,
								PubcoYanaiRepository pubcoYanaiRepository){
		this.comicMainYanaiRepository = comicMainYanaiRepository;
		this.genreYanaiRepository = genreYanaiRepository;
		this.pubcoYanaiRepository = pubcoYanaiRepository;
	}

	@Override
	public List<GenreYanai> getListGenre() {
		// TODO 自動生成されたメソッド・スタブ
		return  genreYanaiRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<PubcoYanai> getListPubco() {
		// TODO 自動生成されたメソッド・スタブ
		return  pubcoYanaiRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<ComicMainYanai> getPageComic(ComicYanaiSearchForm form, Pageable pageable) {
		// TODO 自動生成されたメソッド・スタブ
		 // 検索条件を生成しConicMainYanaiテーブルのレコードを取得する
		return comicMainYanaiRepository.findAll(ComicYanaiSpecification.generateComicYanaiSpecification(form), pageable);
	}

	@Override
	public List<ComicMainYanai> getListComic(ComicYanaiSearchForm form) {
		// TODO 自動生成されたメソッド・スタブ
		return comicMainYanaiRepository.findAll(ComicYanaiSpecification.generateComicYanaiSpecification(form));
	}


	@Override
	public ComicMainYanai getComic(long id) {
		// TODO 自動生成されたメソッド・スタブ
		return comicMainYanaiRepository.findOne(id);
	}

	@Override
	public ComicMainYanai insertComic(ComicYanaiInputForm form) {
		// TODO 自動生成されたメソッド・スタブ
		final ComicMainYanai comicMainYanai = form.convertToComicMainYanaiForInsert();
		return comicMainYanaiRepository.save(comicMainYanai);
	}

	@Override
	public ComicMainYanai updateComic(ComicYanaiInputForm form) {
		// TODO 自動生成されたメソッド・スタブ
		ComicMainYanai comicMainYanai= comicMainYanaiRepository.findOne((long) form.getId());
		if (comicMainYanai != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(comicMainYanai.getUpdateDate()))) {

				// チェックOKの場合、更新
				comicMainYanai= form.convertToComicMainYanaiForUpdate(comicMainYanai);
				return comicMainYanaiRepository.saveAndFlush(comicMainYanai);
			}
		}

		return null;
	}

	@Override
	public void deleteComicById(long id) {
		// TODO 自動生成されたメソッド・スタブ
		ComicMainYanai comicMainYanai = comicMainYanaiRepository.findOne(id);
		if (comicMainYanai != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			comicMainYanaiRepository.delete(id);}
	}

	@Override
	public void deleteComicComp(ArrayList<Long> ids) {
		// TODO 自動生成されたメソッド・スタブ
		comicMainYanaiRepository.deleteComp(ids);
	}

}
