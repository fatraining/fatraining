package jp.co.futureantiques.webapptraining.repository.electronicsito;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.futureantiques.webapptraining.model.Electronics.BrandIto;

/**
 * Electronicsリポジトリのインターフェース
 *
 * @author AIRI ITO
 */
@Repository
public interface BrandItoRepository extends JpaRepository<BrandIto, Long>{

}
