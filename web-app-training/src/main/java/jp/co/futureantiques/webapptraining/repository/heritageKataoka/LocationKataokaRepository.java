package jp.co.futureantiques.webapptraining.repository.heritageKataoka;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.futureantiques.webapptraining.model.heritagekataoka.LocationKataoka;



/**
 * locationリポジトリのインターフェース
 *
 * @author MIKI KATAOKA
 *
 */
@Repository
public interface LocationKataokaRepository extends JpaRepository<LocationKataoka, Long>{

}




