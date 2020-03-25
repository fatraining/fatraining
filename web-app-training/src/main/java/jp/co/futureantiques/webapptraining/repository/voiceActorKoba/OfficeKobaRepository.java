package jp.co.futureantiques.webapptraining.repository.voiceActorKoba;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.voiceActorKoba.OfficeKoba;

public interface OfficeKobaRepository extends JpaRepository<OfficeKoba, Integer> {
    OfficeKoba findByOfficeName(String OfficeName);
}
