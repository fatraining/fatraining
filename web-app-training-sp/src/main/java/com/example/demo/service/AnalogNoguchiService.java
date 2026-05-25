package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.analogNoguchi.AnalogMainNoguchi;
import com.example.demo.model.analogNoguchi.Genre1Noguchi;
import com.example.demo.model.analogNoguchi.Genre2Noguchi;
import com.example.demo.model.analogNoguchi.TypeNoguchi;
import com.example.demo.model.form.analogNoguchi.AnalogNoguchiInputForm;
import com.example.demo.model.form.analogNoguchi.AnalogNoguchiSearchForm;

/**
 * Analogのサービスインターフェース 
 *@author future
 */

public interface AnalogNoguchiService {

	/**
	 * 種類のエンティティのリストを取得する
	 * @return TypeEntityのリスト
	 */
	List<TypeNoguchi> getListType();

	/**
	 * ジャンル1のエンティティのリストを取得する
	 * @return Genre1Entityのリスト
	 */
	List<Genre1Noguchi> getListGenre1();

	/**
	 * ジャンル2のエンティティのリストを取得する
	 * @return Genre2Entityのリスト
	 */
	List<Genre2Noguchi> getListGenre2();
	
	/**
	 * 新たに作成
	 * メインテーブルの対象年齢を一覧化する
	 * 
	 */
	List<Integer> getTargetYearsList();

	/**
	 * 検索条件を元にAnalogMainのレコードのリストを取得する(Paging)
	 *
	 * @param AnalogNoguchiSearchForm form
	 * @param Pageable pageable
	 * @return Mainのリスト
	 */
	Page<AnalogMainNoguchi> getPageAnalog(final AnalogNoguchiSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にAnalogMainのレコードのリストを取得する
	 *
	 * @param AnalogNoguchiSearchForm form
	 * @return AnalogMainのリスト
	 */
	List<AnalogMainNoguchi> getListAnalog(final AnalogNoguchiSearchForm form);

	/**
	 * IDをキーにAnalogMainのレコードを取得する。
	 * 
	 * @param long id
	 * @return AnalogMainのレコード
	 */
	AnalogMainNoguchi getAnalog(final long id);

	/**
	 * AnalogMainにレコードを新規登録する
	 * 
	 * @param AnalogNoguchiInputForm form
	 * @return AnalogMain
	 */
	AnalogMainNoguchi insertAnalog(final AnalogNoguchiInputForm form);

	/**
	 * AnalogMainのレコードを更新する
	 * 
	 * @param AnalogNoguchiInputForm form
	 * @return AnalogMain
	 */
	AnalogMainNoguchi updateAnalog(final AnalogNoguchiInputForm form);

	/**
	 * AnalogMainのレコードを論理削除する
	 * @param long id
	 */
	void deleteAnalogById(final long id);

	/**
	 * AnalogMainのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteAnalogComp(final ArrayList<Long> ids);

}
