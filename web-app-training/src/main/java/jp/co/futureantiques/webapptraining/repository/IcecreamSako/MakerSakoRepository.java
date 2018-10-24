package jp.co.futureantiques.webapptraining.repository.IcecreamSako;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.futureantiques.webapptraining.model.IcecreamSako.MakerSako;

/**
 * MakerSakoリポジトリのインターフェース
 *
 * @author MINAMI SAKO
 */
@Repository
public interface MakerSakoRepository extends JpaRepository<MakerSako, Long>{
}
