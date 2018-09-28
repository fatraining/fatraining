package jp.co.futureantiques.webapptraining.repository.IdolKataoka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.futureantiques.webapptraining.model.IdolKataoka.GroupKataoka;


/**
 * GroupKataokaリポジトリのインターフェース
 *
 * @author skataoka
 */
@Repository
public interface GroupKataokaRepository extends JpaRepository<GroupKataoka, Long>{

}
