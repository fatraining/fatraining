package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
//import java.awt.print.Pageable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.analogNoguchi.AnalogMainNoguchi;
import com.example.demo.model.analogNoguchi.Genre1Noguchi;
import com.example.demo.model.analogNoguchi.Genre2Noguchi;
import com.example.demo.model.analogNoguchi.TypeNoguchi;
import com.example.demo.model.form.analogNoguchi.AnalogNoguchiInputForm;
import com.example.demo.model.form.analogNoguchi.AnalogNoguchiSearchForm;
import com.example.demo.repository.analogNoguchi.AnalogMainNoguchiRepository;
import com.example.demo.repository.analogNoguchi.Genre1NoguchiRepository;
import com.example.demo.repository.analogNoguchi.Genre2NoguchiRepository;
import com.example.demo.repository.analogNoguchi.TypeNoguchiRepository;
import com.example.demo.repository.specification.AnalogNoguchiSpecification;
import com.example.demo.service.AnalogNoguchiService;

/**
 * Analogのサービス実装クラス
 * 
 * @author future
 */
@Service
public class AnalogNoguchiServiceImpl implements AnalogNoguchiService {

	/** AnalogMainリポジトリ */
	private final AnalogMainNoguchiRepository analogMainNoguchiRepository;

	/** Typeリポジトリ */
	private final TypeNoguchiRepository typeNoguchiRepository;

	/** Genre1リポジトリ */
	private final Genre1NoguchiRepository genre1NoguchiRepository;

	/** Genre2リポジトリ */
	private final Genre2NoguchiRepository genre2NoguchiRepository;

	/**
	 * コンストラクタ
	 *
	 * @param AnalogMainNoguchiRepository analogMainNoguchiRepository
	 * @param TypeRepository typeNoguchiRepository
	 * @param Genre1NoguchiRepository genre1NoguchiRepository
	 * @param Genre2NoguchiRepository genre2NoguchiRepository
	 */
	public AnalogNoguchiServiceImpl(AnalogMainNoguchiRepository analogMainNoguchiRepository,
			TypeNoguchiRepository typeNoguchiRepository, Genre1NoguchiRepository genre1NoguchiRepository,
			Genre2NoguchiRepository genre2NoguchiRepository) {
		this.analogMainNoguchiRepository = analogMainNoguchiRepository;
		this.typeNoguchiRepository = typeNoguchiRepository;
		this.genre1NoguchiRepository = genre1NoguchiRepository;
		this.genre2NoguchiRepository = genre2NoguchiRepository;
	}

	@Override
	public List<TypeNoguchi> getListType() {

		//TypeテーブルのレコードをID順に取得する TO:DO
		return typeNoguchiRepository.findAll();
	}

	@Override
	public List<Genre1Noguchi> getListGenre1() {

		//Genre1テーブルのレコードをID順に取得する TO:DO
		return genre1NoguchiRepository.findAll();
	}

	@Override
	public List<Genre2Noguchi> getListGenre2() {

		//Genre2テーブルのレコードをID順に取得する TO:DO
		return genre2NoguchiRepository.findAll();
	}

	@Override
	public List<Integer> getTargetYearsList() {

		//対象年齢（昇順）を取得する TO:DO
		return analogMainNoguchiRepository.findDistinctTargetYears();
	}

	@Override
	public Page<AnalogMainNoguchi> getPageAnalog(final AnalogNoguchiSearchForm form, final Pageable pageable) {

		//検索条件を生成し、AnalogMainテーブルのレコードを取得する
		return analogMainNoguchiRepository.findAll(AnalogNoguchiSpecification.genereteAnalogSpecification(form),
				pageable);
	}

	@Override
	public List<AnalogMainNoguchi> getListAnalog(final AnalogNoguchiSearchForm form) {

		//検索条件を生成し、AnalogMainテーブルのレコードを取得する
		return analogMainNoguchiRepository.findAll(AnalogNoguchiSpecification.genereteAnalogSpecification(form));
	}

	@Override
	public AnalogMainNoguchi getAnalog(final long id) {

		//AnalogMainテーブルを主キー検索する
		AnalogMainNoguchi analogMainNoguchi = analogMainNoguchiRepository.findById(id).get();
		return analogMainNoguchi;
	}

	@Override
	public AnalogMainNoguchi insertAnalog(final AnalogNoguchiInputForm form) {

		//AnalogMainテーブルに新規でデータを登録する
		final AnalogMainNoguchi analogMainNoguchi = form.convertToAnalogMainForInsert();
		return analogMainNoguchiRepository.saveAndFlush(analogMainNoguchi);
	}

	@Override
	public AnalogMainNoguchi updateAnalog(final AnalogNoguchiInputForm form) {

		//更新対象のレコードを取得する
		Optional<AnalogMainNoguchi> analogMainOp = analogMainNoguchiRepository.findById((long) form.getId());
		AnalogMainNoguchi analogMainNoguchi = analogMainOp.get();
		
		if (analogMainNoguchi != null) {

			//更新対象のレコードが存在する場合、排他チェック
			if (form.getUpdateDate().equals(String.valueOf(analogMainNoguchi.getUpdateDate()))) {

			                                     	// チェックOKの場合、更新
				analogMainNoguchi = form.convertToAnalogMainForUpdate(analogMainNoguchi);
				return analogMainNoguchiRepository.saveAndFlush(analogMainNoguchi);
				
			}
		}
		
		return null;
	}

	@Override
	public void deleteAnalogById(final long id) {

		//更新対象のレコードを取得する
		Optional<AnalogMainNoguchi> analogMainOp = analogMainNoguchiRepository.findById(id);
		AnalogMainNoguchi analogMainNoguchi = analogMainOp.get();
		
		if (analogMainNoguchi != null) {

			//更新対象のレコードが存在する場合、削除フラグを1にする
			analogMainNoguchiRepository.delete(id);
			
		}
	}

	@Override
	public void deleteAnalogComp(final ArrayList<Long> ids) {

		//対象のレコードを削除する
		analogMainNoguchiRepository.deleteComp(ids);
	}
}
