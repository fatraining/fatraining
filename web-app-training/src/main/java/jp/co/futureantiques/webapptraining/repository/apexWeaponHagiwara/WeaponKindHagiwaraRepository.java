package jp.co.futureantiques.webapptraining.repository.apexWeaponHagiwara;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.apexweaponHagiwara.WeaponKindHagiwara;

/**
 * WeaponKindHagiwaraリポジトリのインターフェース
 *
 * @author Hagiwara
 */
public interface WeaponKindHagiwaraRepository extends JpaRepository<WeaponKindHagiwara, Long> {
}