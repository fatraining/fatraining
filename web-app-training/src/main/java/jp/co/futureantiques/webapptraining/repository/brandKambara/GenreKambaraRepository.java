package jp.co.futureantiques.webapptraining.repository.brandKambara;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.brandkambara.GenreKambara;

/**
 * GenreKambaraリポジトリのインターフェース
 *
 * @author Yuki Kambara
 */
public interface GenreKambaraRepository extends JpaRepository<GenreKambara, Long> {

}
