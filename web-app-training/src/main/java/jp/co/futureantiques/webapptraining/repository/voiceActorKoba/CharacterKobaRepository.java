package jp.co.futureantiques.webapptraining.repository.voiceActorKoba;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jp.co.futureantiques.webapptraining.model.voiceActorKoba.CharacterKoba;
import jp.co.futureantiques.webapptraining.model.voiceActorKoba.CharacterKobaPK;

public interface CharacterKobaRepository extends JpaRepository<CharacterKoba, CharacterKobaPK>{
	@Query("SELECT o FROM CharacterKoba o where o.id = :id and o.anime_id = :animeId")
	CharacterKoba findByCompositePrimaryKey(@Param("id")long id,@Param("animeId")Integer animeId);
}