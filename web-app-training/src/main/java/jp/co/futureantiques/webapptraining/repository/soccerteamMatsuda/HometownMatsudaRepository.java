package jp.co.futureantiques.webapptraining.repository.soccerteamMatsuda;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.soccerteamMatsuda.HometownMatsuda;

/**
 * Hometownリポジトリのインターフェース
 *
 * @author future
 */
public interface HometownMatsudaRepository extends JpaRepository<HometownMatsuda, Long> {
}