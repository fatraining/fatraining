package jp.co.futureantiques.webapptraining.repository.jojoShirasaka;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.jojoShirasaka.JojoAppearanceShirasaka;


/**
 * @author user
 * JojoAppearanceリポジトリのインターフェース
 *
 */
public interface JojoAppearanceRepository extends JpaRepository<JojoAppearanceShirasaka, Long> {
}