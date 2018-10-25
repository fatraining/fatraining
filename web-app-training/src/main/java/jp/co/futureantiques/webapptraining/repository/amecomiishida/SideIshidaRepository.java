package jp.co.futureantiques.webapptraining.repository.amecomiishida;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.futureantiques.webapptraining.model.amecomiishida.SideIshida;

/**
 * SideIshidaレポジトリのインターフェース
 * @author ishida
 *
 */
@Repository
public interface SideIshidaRepository extends JpaRepository<SideIshida,Long>{

}
