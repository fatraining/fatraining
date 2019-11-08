package jp.co.futureantiques.webapptraining.repository.novelOkudaira;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.novelOkudaira.GenreOkudaira;

/**
 * Genreリポジトリのインターフェース
 *
 * @author future
 */
public interface GenreOkudairaRepository extends JpaRepository<GenreOkudaira, Long> {
}