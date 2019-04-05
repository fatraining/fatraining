package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.TypeKobayashi.GraduateKobayashi;
import jp.co.futureantiques.webapptraining.model.TypeKobayashi.HamsterMainKobayashi;
import jp.co.futureantiques.webapptraining.model.TypeKobayashi.TypeKobayashi;
import jp.co.futureantiques.webapptraining.model.form.hamsterKobayashi.HamsterKobayashiInputForm;
import jp.co.futureantiques.webapptraining.model.form.hamsterKobayashi.HamsterKobayashiSearchForm;
import jp.co.futureantiques.webapptraining.repository.hamsterKobayashi.GraduateKobayashiRepository;
import jp.co.futureantiques.webapptraining.repository.hamsterKobayashi.HamsterMainKobayashiRepository;
import jp.co.futureantiques.webapptraining.repository.hamsterKobayashi.TypeKobayashiRepository;
import jp.co.futureantiques.webapptraining.repository.specification.HamsterKobayashiSpecification;
import jp.co.futureantiques.webapptraining.service.HamsterKobayashiService;



//HamsterKobayashiのサービス実装クラス

@Service
public class HamsterKobayashiServiceImpl implements HamsterKobayashiService {

	//HamsterMainKobayashiリポジトリ
	private final HamsterMainKobayashiRepository hamsterMainKobayashiRepository;

	//TypeKobayashiリポジトリ
	private final TypeKobayashiRepository typeKobayashiRepository;

	//GraduateKobayashiリポジトリ
	private final GraduateKobayashiRepository graduateKobayashiRepository;

	@Autowired
	public HamsterKobayashiServiceImpl(HamsterMainKobayashiRepository hamsterMainKobayashiRepository,TypeKobayashiRepository typeKobayashiRepository,
			GraduateKobayashiRepository graduateKobayashiRepository) {
		this.hamsterMainKobayashiRepository = hamsterMainKobayashiRepository;
		this.typeKobayashiRepository = typeKobayashiRepository;
		this.graduateKobayashiRepository = graduateKobayashiRepository;
	}

	@Override
	public List<TypeKobayashi> getListTypeKobayashi(){

		//TypeKobayashiテーブルのレコードをId順に取得する
		return typeKobayashiRepository.findAll(new Sort(Sort.Direction.ASC,"id"));
	}
	@Override
	public List<GraduateKobayashi> getListGraduateKobayashi(){
		return graduateKobayashiRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}
	@Override
	public Page<HamsterMainKobayashi> getPageHamster(final HamsterKobayashiSearchForm form, final Pageable pageable){

		//検索条件を生成しHamsterMainKobayashiテーブルのレコードを取得する
		return hamsterMainKobayashiRepository.findAll(HamsterKobayashiSpecification.generateHamsterSpecification(form), pageable);
	}
	@Override
	public List<HamsterMainKobayashi> getListHamster(final HamsterKobayashiSearchForm form){
		return hamsterMainKobayashiRepository.findAll(HamsterKobayashiSpecification.generateHamsterSpecification(form));

	}
	@Override
	public HamsterMainKobayashi getHamster(final long id) {

		//HamsterMainKobayashiテーブルを主キー検索する
		return hamsterMainKobayashiRepository.findOne(id);
	}
	@Override
	public HamsterMainKobayashi insertHamster(final HamsterKobayashiInputForm form) {

		//HamsterMainKobayashiテーブルに新規データを登録する
		final HamsterMainKobayashi hamsterMainKobayashi = form.convertToHamsterMainKobayashiForInsert();
		return hamsterMainKobayashiRepository.save(hamsterMainKobayashi);
	}
	@Override
	public HamsterMainKobayashi updateHamster(final HamsterKobayashiInputForm form) {

		//更新対象のレコードを取得する
		HamsterMainKobayashi hamsterMainKobayashi = hamsterMainKobayashiRepository.findOne((long) form.getId());
		if(hamsterMainKobayashi != null) {

			//更新対象のレコードが存在する場合排他チェック
			if(form.getUpdateDate().equals(String.valueOf(hamsterMainKobayashi.getUpdateDate()))) {

				//チェックOKの場合、更新
				hamsterMainKobayashi = form.convertToHamsterMainKobayashiForUPdate(hamsterMainKobayashi);
				return hamsterMainKobayashiRepository.saveAndFlush(hamsterMainKobayashi);
			}
		}
		return null;
	}
	@Override
	public void deleteHamsterById(final long id) {

		//更新対象のレコードを取得する
		HamsterMainKobayashi hamsterMainKobayashi = hamsterMainKobayashiRepository.findOne(id);
		if(hamsterMainKobayashi != null) {

			//更新対象のレコードが存在する場合、削除フラグを1にする
			hamsterMainKobayashiRepository.delete(id);

		}
	}
	@Override
	public void deleteHamsterComp(final ArrayList<Long> ids) {

		//対象のレコードを削除する
		hamsterMainKobayashiRepository.deleteComp(ids);
	}


}
