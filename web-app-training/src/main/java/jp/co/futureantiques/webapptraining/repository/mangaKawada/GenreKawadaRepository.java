package jp.co.futureantiques.webapptraining.repository.mangaKawada;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.mangaKawada.GenreKawada;

/**
 * GenreKawadaリポジトリのインターフェース
 *
 * @author Kawada
 */
public interface GenreKawadaRepository extends JpaRepository<GenreKawada, Long> {

}
