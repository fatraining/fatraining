package jp.co.futureantiques.webapptraining.repository.animeNagatake;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.animeNagatake.StudioNagatake;

/**
 * StudioNagatakeリポジトリのインターフェイス
 *
 * @author future
 * */
public interface StudioNagatakeRepository extends JpaRepository<StudioNagatake, Long> {
}
