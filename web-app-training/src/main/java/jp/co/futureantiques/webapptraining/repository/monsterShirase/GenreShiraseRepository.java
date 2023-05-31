package jp.co.futureantiques.webapptraining.repository.monsterShirase;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.monsterShirase.GenreShirase;

/**
 * GenreShiraseリポジトリのインターフェース
 * @author Shirase
 *
 */
public interface GenreShiraseRepository extends JpaRepository<GenreShirase, Long> {
}
