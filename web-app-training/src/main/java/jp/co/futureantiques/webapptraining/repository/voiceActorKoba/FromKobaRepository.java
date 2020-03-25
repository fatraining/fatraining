package jp.co.futureantiques.webapptraining.repository.voiceActorKoba;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.voiceActorKoba.FromKoba;

public interface FromKobaRepository extends JpaRepository<FromKoba, Integer> {
    FromKoba findByFromName(String FromName);
}
