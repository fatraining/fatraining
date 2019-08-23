package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.saizeriyaKurimoto.SaizeriyaKurimotoInputForm;
import jp.co.futureantiques.webapptraining.model.form.saizeriyaKurimoto.SaizeriyaKurimotoSearchForm;
import jp.co.futureantiques.webapptraining.model.saizeriyaKurimoto.CategoryKurimoto;
import jp.co.futureantiques.webapptraining.model.saizeriyaKurimoto.PriceKurimoto;
import jp.co.futureantiques.webapptraining.model.saizeriyaKurimoto.SaizeriyaMenuMainKurimoto;
import jp.co.futureantiques.webapptraining.repository.saizeriyaKurimoto.SaizeriyaCategoryKurimotoRepository;
import jp.co.futureantiques.webapptraining.repository.saizeriyaKurimoto.SaizeriyaMenuMainKurimotoRepository;
import jp.co.futureantiques.webapptraining.repository.saizeriyaKurimoto.SaizeriyaPriceKurimotoRepository;
import jp.co.futureantiques.webapptraining.repository.specification.SaizeriyaKurimotoSpecification;
import jp.co.futureantiques.webapptraining.service.SaizeriyaKurimotoService;

//SaizeriyaKurimotoのサービス実装クラス
//@author kurimoto

@Service
public class SaizeriyaKurimotoServiceImpl implements SaizeriyaKurimotoService {

	//MenuKurimomtoリポジトリ
	private final SaizeriyaMenuMainKurimotoRepository saizeriyaMenuMainKurimotoRepository;

	//CategoryKurimotoポジトリ
	private final SaizeriyaCategoryKurimotoRepository saizeriyaCategoryKurimotoRepository;

	//PriceKurimotoリポジトリ
	private final SaizeriyaPriceKurimotoRepository saizeriyaPriceKurimotoRepository;

	//コンストラクタ
	//@param MenuKurimotoRepository menuKurimotoRepository
	//@param CategoryKurimkotoRepository categoryKurimotoRepository
	//@param PriceKurimotoRepository priceKurimotoRepository

	@Autowired
	public SaizeriyaKurimotoServiceImpl(SaizeriyaMenuMainKurimotoRepository saizeriyaMenuMainKurimotoRepository, SaizeriyaCategoryKurimotoRepository saizeriyaCategoryKurimotoRepository,
			SaizeriyaPriceKurimotoRepository saizeriyaPriceKurimotoRepository) {
		this.saizeriyaMenuMainKurimotoRepository = saizeriyaMenuMainKurimotoRepository;
		this.saizeriyaCategoryKurimotoRepository = saizeriyaCategoryKurimotoRepository;
		this.saizeriyaPriceKurimotoRepository = saizeriyaPriceKurimotoRepository;
	}

	@Override
	public List<CategoryKurimoto> getListCategoryKurimoto() {

		// CategoryテーブルのレコードをID順に取得する
		return saizeriyaCategoryKurimotoRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<PriceKurimoto> getListPriceKurimoto() {

		// PriceテーブルのレコードをID順に取得する
		return saizeriyaPriceKurimotoRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<SaizeriyaMenuMainKurimoto> getPageSaizeriyaKurimoto(final SaizeriyaKurimotoSearchForm form, final Pageable pageable) {

		// 検索条件を生成しMenuテーブルのレコードを取得する
		return saizeriyaMenuMainKurimotoRepository.findAll(SaizeriyaKurimotoSpecification.generateSaizeriyaSpecification(form), pageable);
	}

	@Override
	public List<SaizeriyaMenuMainKurimoto> getListSaizeriyaKurimoto(final SaizeriyaKurimotoSearchForm form) {

		// 検索条件を生成しmenuKurimotoテーブルのレコードを取得する
		return saizeriyaMenuMainKurimotoRepository.findAll(SaizeriyaKurimotoSpecification.generateSaizeriyaSpecification(form));
	}

	@Override
	public SaizeriyaMenuMainKurimoto getSaizeriyaKurimoto(final long id) {

		// MenuKurimotoテーブルを主キー検索する
		return saizeriyaMenuMainKurimotoRepository.findOne(id);
	}

	@Override
	public SaizeriyaMenuMainKurimoto insertSaizeriyaKurimoto(final SaizeriyaKurimotoInputForm form) {

		// MenuKurimotoテーブルに新規でデータを登録する
		final SaizeriyaMenuMainKurimoto saizeriyaMenuMainKurimoto = form.convertToSaizeriyaMenuMainKurimotoForInsert();
		return saizeriyaMenuMainKurimotoRepository.save(saizeriyaMenuMainKurimoto);
	}

	@Override
	public SaizeriyaMenuMainKurimoto updateSaizeriyaKurimoto(final SaizeriyaKurimotoInputForm form) {

		// 更新対象のレコードを取得する
		SaizeriyaMenuMainKurimoto saizeriyaMenuMainKurimoto = saizeriyaMenuMainKurimotoRepository.findOne((long) form.getId());
		if (saizeriyaMenuMainKurimoto != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(saizeriyaMenuMainKurimoto.getUpdateDate()))) {

				// チェックOKの場合、更新
				saizeriyaMenuMainKurimoto = form.convertToSaizeriyaMenuMainKurimotoForUpdate(saizeriyaMenuMainKurimoto);
				return saizeriyaMenuMainKurimotoRepository.saveAndFlush(saizeriyaMenuMainKurimoto);
			}
		}
		return null;
	}

	@Override
	public void deleteSaizeriyaKurimotoById(final long id) {

		// 更新対象のレコードを取得する
		SaizeriyaMenuMainKurimoto saizeriyaMenuMainKurimoto = saizeriyaMenuMainKurimotoRepository.findOne(id);
		if (saizeriyaMenuMainKurimoto != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			saizeriyaMenuMainKurimotoRepository.delete(id);
		}
	}

	@Override
	public void deleteSaizeriyaKurimotoComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		saizeriyaMenuMainKurimotoRepository.deleteComp(ids);
	}
}