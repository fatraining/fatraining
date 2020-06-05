package jp.co.futureantiques.webapptraining.repository.comicYanai;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.comicYanai.GenreYanai;

/** Genre リポジトリのインターフェイス
 * @author yanai
 *
 */
public interface GenreYanaiRepository extends JpaRepository<GenreYanai, Long> {

}
