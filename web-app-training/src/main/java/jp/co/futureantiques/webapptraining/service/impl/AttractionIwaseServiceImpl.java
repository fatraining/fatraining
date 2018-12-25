package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.attractioniwase.AttractionMainIwase;
import jp.co.futureantiques.webapptraining.model.attractioniwase.ThemeparkIwase;
import jp.co.futureantiques.webapptraining.model.form.attractioniwase.AttractionIwaseInputForm;
import jp.co.futureantiques.webapptraining.model.form.attractioniwase.AttractionIwaseSearchForm;
import jp.co.futureantiques.webapptraining.repository.attractioniwase.AttractionMainRepositoryIwase;
import jp.co.futureantiques.webapptraining.repository.attractioniwase.ThemeparkRepositoryIwase;
import jp.co.futureantiques.webapptraining.repository.specification.AttractionIwaseSpecification;
import jp.co.futureantiques.webapptraining.service.AttractionIwaseService;

/**
 * AttractionIwaseのサービス実装クラス
 *
 * @author future
 */
@Service
public class AttractionIwaseServiceImpl implements AttractionIwaseService {

	/** AttractionMainリポジトリ */
	private final AttractionMainRepositoryIwase attractionMainRepositoryIwase;

	/** Themeparkリポジトリ */
	private final ThemeparkRepositoryIwase themeparkRepositoryIwase;

	/**
	 * コンストラクタ
	 *
	 * @param AttractionMainRepositoryIwase attractionMainRepositoryIwase
	 * @param ThemeparkRepositoryIwase themeparkRepositoryIwase
	 */
	@Autowired
	public AttractionIwaseServiceImpl(AttractionMainRepositoryIwase attractionMainRepositoryIwase, ThemeparkRepositoryIwase themeparkRepositoryIwase
			) {
		this.attractionMainRepositoryIwase = attractionMainRepositoryIwase;
		this.themeparkRepositoryIwase = themeparkRepositoryIwase;
	}

	@Override
	public List<ThemeparkIwase> getListThemepark() {

		// ThemeparkテーブルのレコードをID順に取得する
		return themeparkRepositoryIwase.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<AttractionMainIwase> getPageAttraction(final AttractionIwaseSearchForm form, final Pageable pageable) {

		// 検索条件を生成しAttractionMainIwaseテーブルのレコードを取得する
		return attractionMainRepositoryIwase.findAll(AttractionIwaseSpecification.generateAttractionSpecification(form), pageable);
	}

	@Override
	public List<AttractionMainIwase> getListAttraction(final AttractionIwaseSearchForm form) {

		// 検索条件を生成しAttractionMainIwaseテーブルのレコードを取得する
		return attractionMainRepositoryIwase.findAll(AttractionIwaseSpecification.generateAttractionSpecification(form));
	}

	@Override
	public AttractionMainIwase getAttraction(final long id) {

		// AttractionMainIwaseテーブルを主キー検索する
		return attractionMainRepositoryIwase.findOne(id);
	}

	@Override
	public AttractionMainIwase insertAttraction(final AttractionIwaseInputForm form) {

		// AttractionMainIwaseテーブルに新規でデータを登録する
		final AttractionMainIwase attractionMainIwase = form.convertToAttractionMainForInsert();
		return attractionMainRepositoryIwase.save(attractionMainIwase);
	}

	@Override
	public AttractionMainIwase updateAttraction(final AttractionIwaseInputForm form) {

		// 更新対象のレコードを取得する
		AttractionMainIwase attractionMainIwase = attractionMainRepositoryIwase.findOne((long) form.getId());
		if (attractionMainIwase != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(attractionMainIwase.getUpdateDate()))) {

				// チェックOKの場合、更新
				attractionMainIwase = form.convertToAttractionMainForUpdate(attractionMainIwase);
				return attractionMainRepositoryIwase.saveAndFlush(attractionMainIwase);
			}
		}
		return null;
	}

	@Override
	public void deleteAttractionById(final long id) {

		// 更新対象のレコードを取得する
		AttractionMainIwase attractionMainIwase = attractionMainRepositoryIwase.findOne(id);
		if (attractionMainIwase != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			attractionMainRepositoryIwase.delete(id);
		}
	}

	@Override
	public void deleteAttractionComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		attractionMainRepositoryIwase.deleteComp(ids);
	}
}