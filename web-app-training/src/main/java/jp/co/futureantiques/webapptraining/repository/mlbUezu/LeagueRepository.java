package jp.co.futureantiques.webapptraining.repository.mlbUezu;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.mlbUezu.LeagueUezu;

/**
 * Leagueリポジトリのインターフェース
 *
 * @author future
 */
public interface LeagueRepository extends JpaRepository<LeagueUezu, Long> {
}