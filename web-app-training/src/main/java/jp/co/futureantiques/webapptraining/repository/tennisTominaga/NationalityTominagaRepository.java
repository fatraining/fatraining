package jp.co.futureantiques.webapptraining.repository.tennisTominaga;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.tennisTominaga.NationalityTominaga;

/**
 * Nationalityリポジトリのインターフェース
 *
 * @author future
 */
public interface NationalityTominagaRepository extends JpaRepository<NationalityTominaga, Long> {
}