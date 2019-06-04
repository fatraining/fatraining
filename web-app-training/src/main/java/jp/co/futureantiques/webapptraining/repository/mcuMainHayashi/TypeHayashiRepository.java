package jp.co.futureantiques.webapptraining.repository.mcuMainHayashi;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.mcuHayashi.TypeHayashi;

/**
 * typeHayashiリポジトリのインターフェース
 *
 * @author 林 重樹
 */
public interface TypeHayashiRepository extends JpaRepository<TypeHayashi, Long> {
}