package jp.co.futureantiques.webapptraining.repository.musicKaji;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.musicKaji.ComposerKaji;;

/**
 * Composerリポジトリのインターフェース
 *
 * @author futute
 *
 */
public interface ComposerKajiRepository extends JpaRepository<ComposerKaji, Long>{

}
