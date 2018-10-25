package jp.co.futureantiques.webapptraining.repository.amecomiishida;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.futureantiques.webapptraining.model.amecomiishida.CompanyIshida;

/**
 * CompanyIshidaリポジトリのインターフェース
 * @author ishida
 */
@Repository
public interface CompanyIshidaRepository extends JpaRepository<CompanyIshida,Long>{

}
