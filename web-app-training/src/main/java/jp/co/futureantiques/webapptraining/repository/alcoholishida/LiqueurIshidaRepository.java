package jp.co.futureantiques.webapptraining.repository.alcoholishida;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.alcoholishida.LiqueurIshida;

/**
 * liqueurレポジトリのインターフェイス
 *
 * @author t.ishida
 */

public interface LiqueurIshidaRepository extends JpaRepository<LiqueurIshida, Long> {
}
