package jp.co.futureantiques.webapptraining.repository.resipeishikawa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import jp.co.futureantiques.webapptraining.model.resipeishikawa.ResipeMainIshikawa;

/**
 * ResipeIshikawaMainリポジトリのインターフェース
 *
 *@author t.ishikawa
 */
public interface ResipeIshikawaMainRepository extends JpaRepository<ResipeMainIshikawa,Long>,JpaSpecificationExecutor<ResipeMainIshikawa>{
}