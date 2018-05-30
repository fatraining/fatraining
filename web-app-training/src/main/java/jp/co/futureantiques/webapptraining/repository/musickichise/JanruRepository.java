package jp.co.futureantiques.webapptraining.repository.musickichise;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.musickichise.Janru;

/**
 * Janruリポジトリのインターフェース
 * @author future
 *
 */
public interface JanruRepository extends JpaRepository<Janru, Long> {

}
