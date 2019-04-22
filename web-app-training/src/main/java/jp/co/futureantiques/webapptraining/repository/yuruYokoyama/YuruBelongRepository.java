package jp.co.futureantiques.webapptraining.repository.yuruYokoyama;


import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.yuruYokoyama.YuruBelongYokoyama;

/**
 * Genreリポジトリのインターフェース
 *
 * @author future
 */
public interface YuruBelongRepository extends JpaRepository<YuruBelongYokoyama, Long> {
}