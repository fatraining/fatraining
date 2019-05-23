package jp.co.futureantiques.webapptraining.repository.jojoShirasaka;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.jojoShirasaka.JojoSexShirasaka;


/**
 * @author user
 * JojoSexリポジトリのインターフェース
 *
 */
public interface JojoSexRepository extends JpaRepository<JojoSexShirasaka, Long> {
}