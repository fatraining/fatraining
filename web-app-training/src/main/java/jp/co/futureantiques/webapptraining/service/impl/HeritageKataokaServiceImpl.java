package jp.co.futureantiques.webapptraining.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.heritageKataoka.HeritageInputForm;
import jp.co.futureantiques.webapptraining.model.form.heritageKataoka.HeritageSearchForm;
import jp.co.futureantiques.webapptraining.model.heritagekataoka.GenreKataoka;
import jp.co.futureantiques.webapptraining.model.heritagekataoka.HeritageMainKataoka;
import jp.co.futureantiques.webapptraining.model.heritagekataoka.LocationKataoka;
import jp.co.futureantiques.webapptraining.repository.heritageKataoka.GenreKataokaRepository;
import jp.co.futureantiques.webapptraining.repository.heritageKataoka.HeritageMainKataokaRepository;
import jp.co.futureantiques.webapptraining.repository.heritageKataoka.LocationKataokaRepository;
import jp.co.futureantiques.webapptraining.repository.specification.HeritageKataokaSpecification;
import jp.co.futureantiques.webapptraining.service.HeritageKataokaService;

/**
 * Heritageのサービス実装クラス
 *
 * @author MIKI KATAOKA
 *
 */
@Service
public class HeritageKataokaServiceImpl implements HeritageKataokaService {

	/** HeritageMainリポジトリ */
	private final HeritageMainKataokaRepository heritageMainKataokaRepository;

	/**Genreレポジトリ */
	private final GenreKataokaRepository genreKataokaReposiory;

	/** Locationレポジトリ */
	private final LocationKataokaRepository locationKataokaRepository;

	/** 定数：所在地1~8 */
	private static final int LOCAION_NUMBER = 8;

	/**
	 * コンストラクタ
	 *
	 * @param HeritageMainKataokaRepository heritageMainKataokaRepository
	 * @param GenreKataokaRepository genreKataokaRepository
	 * @param LocationKataokaRepository locationRepository
	 */

	@Autowired
	public HeritageKataokaServiceImpl(HeritageMainKataokaRepository heritageMainKataokaRepository,
			GenreKataokaRepository genreKataokaReposiory, LocationKataokaRepository locationKataokaRepository) {
		this.heritageMainKataokaRepository = heritageMainKataokaRepository;
		this.genreKataokaReposiory = genreKataokaReposiory;
		this.locationKataokaRepository = locationKataokaRepository;
	}

	@Override
	public List<GenreKataoka> getListGenre() {

		//GenreテーブルのレコードをID順に取得する
		return genreKataokaReposiory.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<LocationKataoka> getListLocation() {

		//LocationテーブルのレコードをID順に取得する
		return locationKataokaRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<HeritageMainKataoka> getPageHeritage(final HeritageSearchForm form, final Pageable pageable) {

		//検索条件を生成しHeritageMainテーブルのレコードを取得する

		// 検索条件を生成しMainテーブルの該当都道府県を取得する
		Page<HeritageMainKataoka> page = heritageMainKataokaRepository.findAll(
				HeritageKataokaSpecification.generateHeritageSpecification(form), pageable);
		List<HeritageMainKataoka> list = page.getContent();
		//		List<HeritageMainKataoka> list = heritageMainKataokaRepository.findAll(HeritageKataokaSpecification.generateHeritageSpecification(form));
		//		List<HeritageMainKataoka> list = new ArrayList<>();
		//		list = page.getContent();

		//エンティティの調整、該当都道府県を / 区切りでリストに格納する.

		for (int j = 0; j < list.size(); j++) {
			HeritageMainKataoka main = list.get(j);
			String location = "";
			for (int i = 1; i <= LOCAION_NUMBER; i++) {
				try {

					Method method = main.getClass().getMethod("getLocationKataoka" + i);
					try {
						if (method.invoke(main) != null) {
							if (location.length() != 0) {

								LocationKataoka locationKataoka = (LocationKataoka) method.invoke(main);
								location = location + "/" + locationKataoka.getLocation();
							} else {
								LocationKataoka locationKataoka = (LocationKataoka) method.invoke(main);
								location = locationKataoka.getLocation();
							}
						} else {
							break;
						}
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
				main.setLocationDisp(location);

				// TODO: インデックスを利用して1~8までの名前があるプロパティのゲッターを使いたい

			}
			//	list.remove(0);
			//list.set(0,locationKataoka1);
			//list.add(main);
		}
		Page<HeritageMainKataoka> newPage = new PageImpl<HeritageMainKataoka>(list, pageable,
				page.getTotalElements());
		return newPage;

	}

	@Override
	public List<HeritageMainKataoka> getListHeritage(final HeritageSearchForm form) {

		//検索条件を生成しHeritagesMainテーブルのレコードを取得する
		return heritageMainKataokaRepository.findAll(HeritageKataokaSpecification.generateHeritageSpecification(form));
	}

	@Override
	public HeritageMainKataoka getHeritage(final long id) {

		//HeritageMainテーブルを主キー検索する
		return heritageMainKataokaRepository.findOne(id);
	}

	@Override
	public HeritageMainKataoka insertHeritage(final HeritageInputForm form) {

		//HeritageMainテーブルに新規でデータを登録する
		final HeritageMainKataoka heritageMainKataoka = form.convertToHeritageMainForInsert();
		return heritageMainKataokaRepository.save(heritageMainKataoka);
	}

	@Override
	public HeritageMainKataoka updateHeritage(final HeritageInputForm form) {

		//更新対象のレコードを取得する
		HeritageMainKataoka heritageMainKataoka = heritageMainKataokaRepository.findOne((long) form.getId());
		if (heritageMainKataoka != null) {

			//更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(heritageMainKataoka.getUpdateDate()))) {

				//チェックOKの場合、更新
				heritageMainKataoka = form.convertToHeritageMainForUpdate(heritageMainKataoka);
				return heritageMainKataokaRepository.saveAndFlush(heritageMainKataoka);
			}
		}
		return null;
	}

	@Override
	public void deleteHeritageById(final long id) {

		//更新対象のレコードを取得する
		HeritageMainKataoka heritageMainKataoka = heritageMainKataokaRepository.findOne(id);
		if (heritageMainKataoka != null) {

			//更新対象のレコードが存在する場合、削除フラグを1にする
			heritageMainKataokaRepository.delete(id);
		}
	}

	@Override
	public void deleteHeritageComp(final ArrayList<Long> ids) {

		//対象のレコードを削除する
		heritageMainKataokaRepository.deleteComp(ids);
	}

}
