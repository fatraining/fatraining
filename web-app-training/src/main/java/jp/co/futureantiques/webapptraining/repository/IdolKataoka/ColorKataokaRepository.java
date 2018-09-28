package jp.co.futureantiques.webapptraining.repository.IdolKataoka;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.futureantiques.webapptraining.model.IdolKataoka.ColorKataoka;

/**
 * ColorKataokaリポジトリのインターフェース
 *
 * @author Kataoka
 */
@Repository
public interface ColorKataokaRepository extends JpaRepository<ColorKataoka, Long> {
}
