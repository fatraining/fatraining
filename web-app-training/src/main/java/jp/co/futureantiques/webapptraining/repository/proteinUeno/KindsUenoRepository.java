package jp.co.futureantiques.webapptraining.repository.proteinUeno;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.proteinUeno.KindsUeno;

/**
 * KindsUenoレポジトリのインターフェイス
 *
 * @author ueno
 *
 */
public interface KindsUenoRepository extends JpaRepository<KindsUeno, Long> {

}
