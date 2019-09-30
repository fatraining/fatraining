package jp.co.futureantiques.webapptraining.repository.animeNagatake;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.animeNagatake.SourceNagatake;

/**
 * SourceNagatakeリポジトリのインタフェイス
 *
 * @author future
 * */
public interface SourceNagatakeRepository extends JpaRepository<SourceNagatake, Long> {
}
