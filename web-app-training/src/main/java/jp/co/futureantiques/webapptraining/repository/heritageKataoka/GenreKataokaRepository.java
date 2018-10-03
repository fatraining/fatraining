package jp.co.futureantiques.webapptraining.repository.heritageKataoka;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.futureantiques.webapptraining.model.heritagekataoka.GenreKataoka;



	/**
	 * Genreリポジトリのインターフェース
	 *
	 * @author MIKI KATAOKA
	 *
	 */
	@Repository
	public interface GenreKataokaRepository extends JpaRepository<GenreKataoka, Long> {
	}

