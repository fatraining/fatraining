package jp.co.futureantiques.webapptraining.repository.bandTaneichi;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.bandTaneichi.GenreTaneichi;

/**
 * Genre リポジトリのインターフェース
 * @author future
 *
 */
public interface GenreTaneichiRepository extends JpaRepository<GenreTaneichi, Long> {
}
