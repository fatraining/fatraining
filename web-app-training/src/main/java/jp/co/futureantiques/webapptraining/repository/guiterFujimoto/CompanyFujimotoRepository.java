package jp.co.futureantiques.webapptraining.repository.guiterFujimoto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.futureantiques.webapptraining.model.GuiterFujimoto.CompanyFujimoto;

/**
 * Companyリポジトリのインターフェース
 *
 * @author future　FUJIMOTO
 *
 */
@Repository
public interface CompanyFujimotoRepository extends JpaRepository<CompanyFujimoto,Long> {

}
