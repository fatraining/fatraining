package jp.co.futureantiques.webapptraining.repository.soccerteamMatsuda;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.soccerteamMatsuda.TeamColorMatsuda;

/**
 * 	TeamColorリポジトリのインターフェース
 *
 * @author future
 */
public interface TeamColorMatsudaRepository extends JpaRepository<TeamColorMatsuda, Long> {
}