package jp.co.futureantiques.webapptraining.repository.okashiotani;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.okashiotani.MakerOtani;

/**
 * Makerリポジトリのインターフェース
 *
 * @author otani
 */
public interface MakerRepository extends JpaRepository<MakerOtani, Long> {
}