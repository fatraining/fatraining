package jp.co.futureantiques.webapptraining.repository.kpoptateishi;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.kpoptateishi.Office;

/**
 * Officeリポジトリのインターフェース
 *
 * @author future
 */
public interface OfficeRepository extends JpaRepository<Office, Long> {

}
