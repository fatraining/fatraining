package jp.co.futureantiques.webapptraining.repository.doramasample;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.doramasample.TvStation;

/**
 * TvStationリポジトリのインターフェース
 *
 * @author hiraoka
 */
public interface TvStationRepository extends JpaRepository<TvStation, Long> {
}