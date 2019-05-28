package jp.co.futureantiques.webapptraining.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.castleMinami.CastleMainMinami;
import jp.co.futureantiques.webapptraining.model.castleMinami.PrefectureMinami;
import jp.co.futureantiques.webapptraining.model.castleMinami.TenshuMinami;
import jp.co.futureantiques.webapptraining.model.form.castleMinami.CastleSearchForm;
import jp.co.futureantiques.webapptraining.repository.castleMinami.CastleMainMinamiRepository;
import jp.co.futureantiques.webapptraining.repository.castleMinami.PrefectureMinamiRepository;
import jp.co.futureantiques.webapptraining.repository.castleMinami.TenshuMinamiRepository;
import jp.co.futureantiques.webapptraining.repository.specification.CastleMinamiSpecification;
import jp.co.futureantiques.webapptraining.service.CastleMinamiService;

/**
 * Castleのサービス実装クラス
 *
 * @author Minami
 *
 */
@Service
public class CastleMinamiServiceImpl implements CastleMinamiService {

	/** CastleMainリポジトリ */
	private final CastleMainMinamiRepository castleMainMinamiRepository;

	/** Prefectureリポジトリ */
	private final PrefectureMinamiRepository prefectureMinamiRepository;

	/** Tenshuリポジトリ */
	private final TenshuMinamiRepository tenshuMinamiRepository;

	/**
	 * コンストラクタ
	 *
	 * @param CastleMainMinamiRepository castleMainRepository
	 * @param PrefectureMinamiRepository prefectureRepository
	 * @param TenshuMinamiRepository tenshuRepository
	 */
	@Autowired
	public CastleMinamiServiceImpl(CastleMainMinamiRepository castleMainMinamiRepository, PrefectureMinamiRepository prefectureMinamiRepository,
			TenshuMinamiRepository tenshuMinamiRepository) {
		this.castleMainMinamiRepository = castleMainMinamiRepository;
		this.prefectureMinamiRepository = prefectureMinamiRepository;
		this.tenshuMinamiRepository = tenshuMinamiRepository;
	}

	@Override
	public List<PrefectureMinami> getListPrefectureMinami(){

		//PrefectureテーブルのレコードをID順に取得する
		return prefectureMinamiRepository.findAll(new Sort(Sort.Direction.ASC,"id"));
	}

	@Override
	public List<TenshuMinami> getListTenshuMinami(){

		//TenshuテーブルのレコードをID順に取得する
		return tenshuMinamiRepository.findAll(new Sort(Sort.Direction.ASC,"id"));
	}

	@Override
	public Page<CastleMainMinami> getPageCastle(final CastleSearchForm form, final Pageable pageable){

		//検索条件を生成しCastleMainテーブルのレコードを取得する
		return castleMainMinamiRepository.findAll(CastleMinamiSpecification.generateCastleMinamiSpecification(form), pageable);
	}

	@Override
	public List<CastleMainMinami> getListCastle(final CastleSearchForm form){

		//検索条件を生成しCastleMainテーブルのレコードを取得
		return castleMainMinamiRepository.findAll(CastleMinamiSpecification.generateCastleMinamiSpecification(form));
	}

	@Override
	public CastleMainMinami getCastle(final long id) {

		//CastleMainテーブルを主キー検索する
		return castleMainMinamiRepository.findOne(id);
	}

	@Override
	public void deleteCastleById(final long id) {

		//更新対象のレコードを取得する
		CastleMainMinami castleMainMinami = castleMainMinamiRepository.findOne(id);
		if(castleMainMinami != null) {

			//更新対象のレコードが存在する場合、削除フラグを1にする
			castleMainMinamiRepository.delete(id);
		}
	}
}
