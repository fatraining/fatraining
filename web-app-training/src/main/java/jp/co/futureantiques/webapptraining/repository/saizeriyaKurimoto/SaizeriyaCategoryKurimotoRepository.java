package jp.co.futureantiques.webapptraining.repository.saizeriyaKurimoto;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.saizeriyaKurimoto.CategoryKurimoto;

//CategoryKurimotoリポジトリのインターフェース
//@author Kurimoto

public interface SaizeriyaCategoryKurimotoRepository extends JpaRepository<CategoryKurimoto, Long> {
}