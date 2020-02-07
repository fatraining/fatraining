package jp.co.futureantiques.webapptraining.repository.riderSaito;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.riderSaito.AgeSaito;

/**
 * AgeSaitoリポジトリのインターフェイス
 *
 * @author future
 * */
public interface AgeSaitoRepository extends JpaRepository<AgeSaito, Long> {
}