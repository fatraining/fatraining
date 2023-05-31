package jp.co.futureantiques.webapptraining.repository.mangaKawada;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.mangaKawada.AnimeKawada;

/**
 * AnimeKawadaリポジトリのインターフェース
 *
 * @author Kawada
 */
public interface AnimeKawadaRepository extends JpaRepository<AnimeKawada, Long> {

}
