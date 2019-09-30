package jp.co.futureantiques.webapptraining.repository.animeNagatake;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.animeNagatake.GenreNagatake;

/**
 * GenreNagatakeリポジトリのインターフェイス
 *
 * @author future
 * */
public interface GenreNagatakeRepository extends JpaRepository<GenreNagatake, Long> {
}