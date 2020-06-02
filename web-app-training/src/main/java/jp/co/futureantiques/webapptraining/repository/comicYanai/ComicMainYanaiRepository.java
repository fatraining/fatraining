package jp.co.futureantiques.webapptraining.repository.comicYanai;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import jp.co.futureantiques.webapptraining.model.comicYanai.ComicMainYanai;

public interface ComicMainYanaiRepository extends JpaRepository<ComicMainYanai,Long>,
														JpaSpecificationExecutor<ComicMainYanai>{

	@Transactional
	@Modifying
	@Query("UPDATE ComicMainYanai SET delFlg = 1 WHERE id = :id")
	void delete(@Param("id") final long id);

	@Transactional
	@Modifying
	@Query("DELETE FROM ComicMainYanai WHERE id IN(:ids)")
	void deleteComp(@Param("ids") final ArrayList<Long> ids);


}
