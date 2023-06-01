package jp.co.futureantiques.webapptraining.repository.kpoptateishi;
import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.kpoptateishi.Idol;

/**
 * Idolリポジトリのインターフェース
 *
 * @author future
 */
public interface IdolRepository extends JpaRepository<Idol, Long> {

}
