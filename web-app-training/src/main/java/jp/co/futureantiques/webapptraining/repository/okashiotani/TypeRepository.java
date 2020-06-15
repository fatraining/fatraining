package jp.co.futureantiques.webapptraining.repository.okashiotani;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.okashiotani.TypeOtani;

/**
 * Typeリポジトリのインターフェース
 *
 * @author future
 */
public interface TypeRepository extends JpaRepository<TypeOtani,Long>{

}