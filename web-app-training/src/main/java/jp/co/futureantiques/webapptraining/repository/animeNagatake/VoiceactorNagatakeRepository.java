package jp.co.futureantiques.webapptraining.repository.animeNagatake;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.animeNagatake.VoiceactorNagatake;

/**
 * VoiceactorNagatakeリポジトリのインターフェイス
 *
 * @author future
 * */
public interface VoiceactorNagatakeRepository extends JpaRepository<VoiceactorNagatake, Long> {
}
