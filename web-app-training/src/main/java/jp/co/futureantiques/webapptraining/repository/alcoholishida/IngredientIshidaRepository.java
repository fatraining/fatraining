package jp.co.futureantiques.webapptraining.repository.alcoholishida;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.alcoholishida.IngredientIshida;

/**
 * Ingredientリポジトリのインターフェース
 *
 *@author t.ishida
 */
public interface IngredientIshidaRepository extends JpaRepository<IngredientIshida, Long> {
}