package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.catNihonyanagi.CatMainNihonyanagi;
import jp.co.futureantiques.webapptraining.model.catNihonyanagi.CharacterNihonyanagi;
import jp.co.futureantiques.webapptraining.model.catNihonyanagi.HairNihonyanagi;
import jp.co.futureantiques.webapptraining.model.catNihonyanagi.SizeNihonyanagi;
import jp.co.futureantiques.webapptraining.model.form.catNihonyanagi.CatInputForm;
import jp.co.futureantiques.webapptraining.model.form.catNihonyanagi.CatSearchForm;
import jp.co.futureantiques.webapptraining.repository.catNihonyanagi.CatMainNihonyanagiRepository;
import jp.co.futureantiques.webapptraining.repository.catNihonyanagi.CharacterNihonyanagiRepository;
import jp.co.futureantiques.webapptraining.repository.catNihonyanagi.HairNihonyanagiRepository;
import jp.co.futureantiques.webapptraining.repository.catNihonyanagi.SizeNihonyanagiRepository;
import jp.co.futureantiques.webapptraining.repository.specification.CatNihonyanagiSpecification;
import jp.co.futureantiques.webapptraining.service.CatNihonyanagiService;

/**
 * Catのサービス実装クラス
 *
 * @author Nihonyanagi
 *
 */
@Service
public class CatNihonyanagiServiceImpl implements CatNihonyanagiService{

	/** CatMainリポジトリ */
	private final CatMainNihonyanagiRepository catMainNihonyanagiRepository;

	/** Hairリポジトリ */
	private final HairNihonyanagiRepository hairNihonyanagiRepository;

	/** Sizeリポジトリ */
	private final SizeNihonyanagiRepository sizeNihonyanagiRepository;

	/** Characterリポジトリ */
	private final CharacterNihonyanagiRepository characterNihonyanagiRepository;

	/**
	 * コンストラクタ
	 *
	 * @param CatMainNihonyanagi catMainNihonyanagi
	 * @psrsm HearNihonyanagiRepository hearNihonyanagiRepository
	 * @param SizeNihonyanagiRepository sizeNihonyanagiRepository
	 * @param CharacterNihonyanagiRepository characterNihonyanagiRepository
	 */

	@Autowired
	public CatNihonyanagiServiceImpl(CatMainNihonyanagiRepository catMainNihonyanagiRepository,HairNihonyanagiRepository hairNihonyanagiRepository,
			SizeNihonyanagiRepository sizeNihonyanagiRepository, CharacterNihonyanagiRepository characterNihonyanagiRepository) {
		this.catMainNihonyanagiRepository = catMainNihonyanagiRepository;
		this.hairNihonyanagiRepository = hairNihonyanagiRepository;
		this.sizeNihonyanagiRepository = sizeNihonyanagiRepository;
		this.characterNihonyanagiRepository = characterNihonyanagiRepository;
	}

	@Override
	public List<HairNihonyanagi> getListHairNihonyanagi(){

		//HairテーブルのレコードをID順に取得する
		return hairNihonyanagiRepository.findAll(new Sort(Sort.Direction.ASC,"id"));
	}

	@Override
	public List<SizeNihonyanagi> getListSizeNihonyanagi(){
		return sizeNihonyanagiRepository.findAll(new Sort(Sort.Direction.ASC,"id"));
	}

	@Override
	public List<CharacterNihonyanagi> getListCharacterNihonyanagi(){
		return characterNihonyanagiRepository.findAll(new Sort(Sort.Direction.ASC,"id"));
	}

	@Override
	public Page<CatMainNihonyanagi> getPageCat(final CatSearchForm form,final Pageable pageable){

		//検索条件を生成しCatMainテーブルのレコードを取得する
		return catMainNihonyanagiRepository.findAll(CatNihonyanagiSpecification.generateCatNihonyanagiSpecification(form),pageable);
	}

	@Override
	public List<CatMainNihonyanagi> getListCat(final CatSearchForm form){

		//検索条件を生成しCatMainテーブルのレコードを取得する
		return catMainNihonyanagiRepository.findAll(CatNihonyanagiSpecification.generateCatNihonyanagiSpecification(form));

	}

	@Override
	public CatMainNihonyanagi getCat(final long id) {

		//CatMainテーブルを主キー検索する
		return catMainNihonyanagiRepository.findOne(id);
	}

	@Override
	public CatMainNihonyanagi insertCat(final CatInputForm form) {

		//CatMainテーブルに新規でデータを登録する
		final CatMainNihonyanagi catMainNihonyanagi = form.convertToCatMainNihonyanagiForInsert();
		return catMainNihonyanagiRepository.save(catMainNihonyanagi);
	}

	@Override
	public CatMainNihonyanagi updateCat(final CatInputForm form) {

		//更新対象のレコードを取得する
		CatMainNihonyanagi catMainNihonyanagi = catMainNihonyanagiRepository.findOne((long) form.getId());
		if(catMainNihonyanagi != null) {

			//更新対象のレコードが存在する場合排他チェック
			if(form.getUpdateDate().equals(String.valueOf(catMainNihonyanagi.getUpdateDate()))) {

				//チェックOKの場合、更新
				catMainNihonyanagi = form.convertToCatMainNihonyanagiForUpdate(catMainNihonyanagi);
				return catMainNihonyanagiRepository.saveAndFlush(catMainNihonyanagi);
			}
		}
		return null;
	}

	@Override
	public void deleteCatById(final long id) {

		//更新対象のレコードを取得する
		CatMainNihonyanagi catMainNihonyanagi = catMainNihonyanagiRepository.findOne(id);
		if(catMainNihonyanagi != null) {

			//更新対象のレコードが存在する場合、削除フラグを1にする
			catMainNihonyanagiRepository.delete(id);
		}
	}

	@Override
	public void deleteCatComp(final ArrayList<Long> ids) {

		//対象のレコードを削除する
		catMainNihonyanagiRepository.deleteComp(ids);
	}

}
