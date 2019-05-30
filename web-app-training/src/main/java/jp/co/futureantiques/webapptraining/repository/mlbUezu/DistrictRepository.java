package jp.co.futureantiques.webapptraining.repository.mlbUezu;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.mlbUezu.DistrictUezu;

/**
 * Districtリポジトリのインターフェース
 *
 * @author future
 */
public interface DistrictRepository extends JpaRepository<DistrictUezu, Long> {
}