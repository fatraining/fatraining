package jp.co.futureantiques.webapptraining.repository.drinkOhkubo;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.drinkOhkubo.MakerOhkubo;

/**
 * Makerリポジトリのインターフェース
 *
 * @author future
 */
public interface MakerOhkuboRepository extends JpaRepository<MakerOhkubo,Long> {
}
