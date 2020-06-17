package jp.co.futureantiques.webapptraining.repository.disneyIto;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.disneyIto.DisneyParkIto;

/**
 * DisneyParkItoリポジトリのインターフェース
 *
 * @author Ayaka Ito
 */
public interface DisneyParkItoRepository extends JpaRepository<DisneyParkIto, Long>  {
}
