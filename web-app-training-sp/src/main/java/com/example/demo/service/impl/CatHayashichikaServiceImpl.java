package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.catHayashichika.CatMainHayashichika;
import com.example.demo.model.catHayashichika.FromHayashichika;
import com.example.demo.model.catHayashichika.SizeHayashichika;
import com.example.demo.model.catHayashichika.TypeHayashichika;
import com.example.demo.model.form.catHayashichika.CatHayashichikaInputForm;
import com.example.demo.model.form.catHayashichika.CatHayashichikaSearchForm;
import com.example.demo.repository.catHayashichika.CatMainRepository;
import com.example.demo.repository.catHayashichika.FromHayashichikaRepository;
import com.example.demo.repository.catHayashichika.SizeHayashichikaRepository;
import com.example.demo.repository.catHayashichika.TypeHayashichikaRepository;
import com.example.demo.repository.specification.CatHayashichikaSpecification;
import com.example.demo.service.CatHayashichikaService;

/**
 * CatHayashichikaのサービス実装クラス
 * @author future
 */
@Service
public class CatHayashichikaServiceImpl implements CatHayashichikaService {

	/** CatMainのリポジトリ*/
	private final CatMainRepository catMainRepository;

	/**TypeHayashichikaのリポジトリ*/
	private final TypeHayashichikaRepository typeHayashichikaRepository;

	/**CatSizeのリポジトリ*/
	private final SizeHayashichikaRepository sizeHayashichikaRepository;

	/**CatFromのリポジトリ*/
	private final FromHayashichikaRepository fromHayashichikaRepository;

	/**
	 * コンストラクタ
	 * @param CatMainRepository catMainRepository
	 * @param TypeHayashichikaRepository typeHayashichikaRepository
	 * @param CatSizeRepository catSizeRepository
	 * @param CatFromRepository catFromRepository
	 */
	public CatHayashichikaServiceImpl(CatMainRepository catMainRepository, TypeHayashichikaRepository typeHayashichikaRepository,
			SizeHayashichikaRepository sizeHayashichikaRepository, FromHayashichikaRepository fromHayashichikaRepository ) {
		this.catMainRepository = catMainRepository;
		this.typeHayashichikaRepository=typeHayashichikaRepository;
		this.sizeHayashichikaRepository=sizeHayashichikaRepository;
		this.fromHayashichikaRepository=fromHayashichikaRepository;
	}

	@Override
	public List<TypeHayashichika> getListTypeHayashichika() {
		//typeHayashichikaテーブルのレコードをID順に取得する
		return typeHayashichikaRepository.findAll();
	}

	@Override
	public List<SizeHayashichika> getListSizeHayashichika() {
		//CatSizeのテーブルのレコードをID順に取得する
		return sizeHayashichikaRepository.findAll();
	}

	@Override
	public List<FromHayashichika> getListFromHayashichika() {
		//CatFromテーブルのレコードをID順に取得する
		return fromHayashichikaRepository.findAll();
	}

	@Override
	public Page<CatMainHayashichika> getPageCat(final CatHayashichikaSearchForm form, final Pageable pageable) {

		//検索条件を生成しCatMainテーブルのレコードを取得する
		return catMainRepository.findAll(CatHayashichikaSpecification.generateCatSpecification(form), pageable);
	}

	@Override
	public List<CatMainHayashichika> getListCat(final CatHayashichikaSearchForm form) {

		//検索条件を生成し、CatMainテーブルのレコードを取得する
		return catMainRepository.findAll(CatHayashichikaSpecification.generateCatSpecification(form));
	}

	@Override
	public CatMainHayashichika getCat(final long id) {

		//CatMainテーブルを主キー検索する
		CatMainHayashichika catMain = catMainRepository.findById(id).get();
		return catMain;
	}

	@Override
	public CatMainHayashichika insertCat(final CatHayashichikaInputForm form) {
		//CatMainテーブルに新規でデータを登録する
		final CatMainHayashichika catMain = form.convertToCatMainForInsert();
		return catMainRepository.saveAndFlush(catMain);
	}

	@Override
	public CatMainHayashichika updateCat(final CatHayashichikaInputForm form) {

		//更新対象のレコードを取得する
		Optional<CatMainHayashichika> catMainOp = catMainRepository.findById((long) form.getId());

		CatMainHayashichika catMain = catMainOp.get();
		if (catMain != null) {

			//更新対象のレコードが存在する場合は排他チェック
			if (form.getUpdateDate().equals(String.valueOf(catMain.getUpdateDate()))) {

				//チェックOKの場合、更新
				catMain = form.convertToCatMainForUpdate(catMain);
				return catMainRepository.saveAndFlush(catMain);
			}
		}
		return null;
	}

	@Override
	public void deleteCatById(final long id) {

		//更新対象のレコードを取得する
		Optional<CatMainHayashichika> catMainOp = catMainRepository.findById(id);
		CatMainHayashichika catMain = catMainOp.get();
		if (catMain != null) {

			//更新対象のレコードが存在する場合、削除フラグを1にする
			catMainRepository.delete(id);
		}
	}

	@Override
	public void deleteCatComp(final ArrayList<Long> ids) {

		//対象のレコードを削除する
		catMainRepository.deletecomp(ids);
	}


}
