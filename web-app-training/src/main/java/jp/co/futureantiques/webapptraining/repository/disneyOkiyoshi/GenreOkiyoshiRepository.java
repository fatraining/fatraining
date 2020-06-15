package jp.co.futureantiques.webapptraining.repository.disneyOkiyoshi;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.disneyOkiyoshi.GenreOkiyoshi;

/**
 * Genreリポジトリのインターフェース
 *
 * @author future
 */
public interface GenreOkiyoshiRepository extends JpaRepository<GenreOkiyoshi, Long> {
}