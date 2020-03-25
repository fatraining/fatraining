package jp.co.futureantiques.webapptraining.repository.voiceActorKoba;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import jp.co.futureantiques.webapptraining.model.voiceActorKoba.VoiceActorMainKoba;

public interface VoiceActorMainKobaRepository extends JpaRepository<VoiceActorMainKoba, Long>, JpaSpecificationExecutor<VoiceActorMainKoba> {}
