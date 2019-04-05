package jp.co.futureantiques.webapptraining.repository.hamsterKobayashi;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.TypeKobayashi.TypeKobayashi;

//TypeKobayashiリポジトリのインターフェース

public interface TypeKobayashiRepository extends JpaRepository<TypeKobayashi,Long>  {

}
