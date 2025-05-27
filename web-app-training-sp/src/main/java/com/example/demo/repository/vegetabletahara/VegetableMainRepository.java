package com.example.demo.repository.vegetabletahara;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.vegetabletahara.VegetableMainTahara;

/**
 * VegetableMainTaharaリポジトリのインターフェース
 *
 * @author future
 */                                              //↓よく使われるSQL文を自動的に使うメソッド？
public interface VegetableMainRepository extends JpaRepository<VegetableMainTahara, Long>, JpaSpecificationExecutor<VegetableMainTahara>{
	//このインターフェースには、JpaRepositoryで対応していない（よく使われないような、複雑な）SQLを書く
	/**
	 * 対象のレコードの削除フラグを1にする
	 *
	 * @param long id
	 */
	@Transactional  //「下のメソッドを呼び出したときに、トランザクションをかける」の意
	@Modifying  //「更新・削除・挿入」するためのqueryを実行するために必要なもの
	@Query("UPDATE VegetableMainTahara SET delFlg = 1 WHERE id = :id")
	void delete(@Param("id") final long id);
	//

	/**
	 * 対象のレコードを削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	@Transactional
	@Modifying
	@Query("DELETE FROM VegetableMainTahara WHERE id IN(:ids)")
	void deleteComp(@Param("ids") final ArrayList<Long> ids);
}
//トランザクション処理：プログラムからデータベースに送信する1つ以上のSQL要求を、1つのグループとして扱う処理
//トランザクション制御：トランザクション処理の実行時、複数あるSQLファイルがすべて成功した場合に処理結果を確定（コミット）し、
//　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　途中で失敗した場合に実行前の状態に戻す（ロールバック）する動き
