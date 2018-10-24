package jp.co.futureantiques.webapptraining.repository.IcecreamSako;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.futureantiques.webapptraining.model.IcecreamSako.GenreSako;

/**
 * GenreSakoリポジトリのインターフェース
 *
 * @author MINAMI SAKO
 */
@Repository
public interface GenreSakoRepository extends JpaRepository<GenreSako, Long> {
}