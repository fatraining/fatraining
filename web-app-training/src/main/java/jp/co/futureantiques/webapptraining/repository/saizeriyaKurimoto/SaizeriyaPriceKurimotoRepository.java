package jp.co.futureantiques.webapptraining.repository.saizeriyaKurimoto;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.saizeriyaKurimoto.PriceKurimoto;

//PriceKurimotoリポジトリのインターフェース
//@author Kurimoto

public interface SaizeriyaPriceKurimotoRepository extends JpaRepository<PriceKurimoto, Long> {
}