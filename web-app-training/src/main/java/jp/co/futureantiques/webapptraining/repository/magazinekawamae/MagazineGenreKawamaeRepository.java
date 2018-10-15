package jp.co.futureantiques.webapptraining.repository.magazinekawamae;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.magazinekawamae.MagazineGenreKawamae;

/**
 * Genreリポジトリのインターフェース
 *
 * @author kawamae
 */
public interface MagazineGenreKawamaeRepository extends JpaRepository<MagazineGenreKawamae, Long> {
}