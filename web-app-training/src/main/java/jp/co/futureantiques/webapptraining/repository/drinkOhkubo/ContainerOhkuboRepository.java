package jp.co.futureantiques.webapptraining.repository.drinkOhkubo;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.drinkOhkubo.ContainerOhkubo;

/**
 * Containerリポジトリのインターフェース
 *
 * @author future
 */
public interface ContainerOhkuboRepository extends JpaRepository<ContainerOhkubo,Long>{
}
