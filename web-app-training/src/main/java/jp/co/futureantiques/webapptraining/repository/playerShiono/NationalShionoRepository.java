package jp.co.futureantiques.webapptraining.repository.playerShiono;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.playerShiono.NationalShiono;

/**
 * NationalShionoリポジトリのインターフェース
 *
 * @author Shiono
 */
public interface NationalShionoRepository extends JpaRepository<NationalShiono, Integer> {
}
