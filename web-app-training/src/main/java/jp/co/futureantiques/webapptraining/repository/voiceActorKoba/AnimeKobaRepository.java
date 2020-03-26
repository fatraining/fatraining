package jp.co.futureantiques.webapptraining.repository.voiceActorKoba;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.voiceActorKoba.AnimeKoba;

public interface AnimeKobaRepository extends JpaRepository<AnimeKoba, Integer> {
    AnimeKoba findByAnimeTitle(String AnimeTitle);
}