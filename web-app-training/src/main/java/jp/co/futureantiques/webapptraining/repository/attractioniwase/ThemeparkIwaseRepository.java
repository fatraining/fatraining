package jp.co.futureantiques.webapptraining.repository.attractioniwase;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.attractioniwase.ThemeparkIwase;


/**
 * Themeparkリポジトリのインターフェース
 *
 * @author future
 */
public interface ThemeparkIwaseRepository extends JpaRepository<ThemeparkIwase, Long> {
}
