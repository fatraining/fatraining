package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.IdolKataoka.ColorKataoka;
import jp.co.futureantiques.webapptraining.model.IdolKataoka.GroupKataoka;
import jp.co.futureantiques.webapptraining.model.IdolKataoka.IdolMainKataoka;
import jp.co.futureantiques.webapptraining.model.form.IdolKataoka.IdolInputForm;
import jp.co.futureantiques.webapptraining.model.form.IdolKataoka.IdolSearchForm;
import jp.co.futureantiques.webapptraining.repository.IdolKataoka.ColorKataokaRepository;
import jp.co.futureantiques.webapptraining.repository.IdolKataoka.GroupKataokaRepository;
import jp.co.futureantiques.webapptraining.repository.IdolKataoka.IdolMainKataokaRepository;
import jp.co.futureantiques.webapptraining.repository.specification.IdolKataokaSpecification;
import jp.co.futureantiques.webapptraining.service.IdolKataokaService;


/**
 * IdolMainKataokaのサービス実装クラス
 *
 * @author skataoka
 *
 */
@Service
public class IdolKataokaServiceImpl implements IdolKataokaService{

	/** IdolMainKataokaリポジトリ */
	private final IdolMainKataokaRepository idolMainKataokaRepository;

	/**Colorレポジトリ */
	private final ColorKataokaRepository colorKataokaReposiory;

	/** Groupレポジトリ */
	private final GroupKataokaRepository groupKataokaRepository;

	/**
	 * コンストラクタ
	 *
	 * @param IdolMainKataokaRepository idolMainKataokaReopository
	 * @param ColorKataokaRepository colorKataokaRepository
	 * @param GroupKataokaRepository groupKataokaRepository
	 */

	@Autowired
	public IdolKataokaServiceImpl(IdolMainKataokaRepository idolMainKataokaRepository,
			ColorKataokaRepository colorKataokaRepository, GroupKataokaRepository groupKataokaRepository) {
		this.idolMainKataokaRepository = idolMainKataokaRepository;
		this.colorKataokaReposiory = colorKataokaRepository;
		this.groupKataokaRepository = groupKataokaRepository;
	}

	@Override
	public List<ColorKataoka> getListColorKataoka(){

		//ColorテーブルのレコードをID順に取得する
		return colorKataokaReposiory.findAll(new Sort(Sort.Direction.ASC, "colorId"));
	}

	@Override
	public List<GroupKataoka> getListGroupKataoka(){

		//GroupテーブルのレコードをID順に取得する
		return groupKataokaRepository.findAll(new Sort(Sort.Direction.ASC, "groupId"));
	}


	@Override
	public Page<IdolMainKataoka> getPageIdol(final IdolSearchForm form, final Pageable pageable) {

		//検索条件を生成しIdolMainKataokaテーブルのレコードを取得する
		return idolMainKataokaRepository.findAll(IdolKataokaSpecification.generateIdolSpecification(form), pageable);
	}

	@Override
	public List<IdolMainKataoka> getListIdol(final IdolSearchForm form) {

		//検索条件を生成しIdolMainKataokaテーブルのレコードを取得する
		return idolMainKataokaRepository.findAll(IdolKataokaSpecification.generateIdolSpecification(form));
	}

//	@Override
//	public ElectronicsMainIto getProduct(final long id) {
//
//		//ElectronicsMainテーブルを主キー検索する
//		return null;
//		//return electronicsMainItoRepository.findOne(id);
//	}
//
//	@Override
//	public ElectronicsMainIto insertProduct(final ElectronicsInputForm form) {
//
//		//ElectronicsMainテーブルに新規でデータを登録する
//		final ElectronicsMainIto electronicsMainIto = form.convertToElectronicsMainForInsert();
//		return electronicsMainItoRepository.save(electronicsMainIto);
//	}
//
//	@Override
//	public ElectronicsMainIto updateProduct(final ElectronicsInputForm form) {
//
//		//更新対象のレコードを取得する
//		ElectronicsMainIto electronicsMainIto = electronicsMainItoRepository.findOne((long) form.getId());
//		if (electronicsMainIto != null) {
//
//			//更新対象のレコードが存在する場合排他チェック
//			if (form.getUpdateDate().equals(String.valueOf(electronicsMainIto.getUpdateDate()))) {
//
//				//チェックOKの場合、更新
//				electronicsMainIto = form.convertToElectronicsMainForUpdate(electronicsMainIto);
//				return electronicsMainItoRepository.saveAndFlush(electronicsMainIto);
//			}
//		}
//		return null;
//	}
//
//	@Override
//	public void deleteProductById(final long id) {
//
//		//更新対象のレコードを取得する
//		ElectronicsMainIto electronicsMainIto = electronicsMainItoRepository.findOne(id);
//		if (electronicsMainIto != null) {
//
//			//更新対象のレコードが存在する場合、削除フラグを1にする
//			electronicsMainItoRepository.delete(id);
//		}
//	}


	@Override
	public Page<IdolMainKataoka> getPageIdol(IdolSearchForm form, java.awt.print.Pageable pageable) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}


	@Override
	public IdolMainKataoka getIdol(long idol_id) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public IdolMainKataoka insertIdol(IdolInputForm form) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public IdolMainKataoka updateIdol(IdolInputForm form) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void deleteIdolById(long idol_id) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void deleteIdolComp(ArrayList<Long> ids) {
		// TODO 自動生成されたメソッド・スタブ

	}


}
