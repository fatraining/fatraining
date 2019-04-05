package jp.co.futureantiques.webapptraining.repository.bandSasaki;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import jp.co.futureantiques.webapptraining.model.bandSasaki.BandMainSasaki;

public interface BandMainSasakiRepository extends JpaRepository<BandMainSasaki, Long>, JpaSpecificationExecutor<BandMainSasaki>{

	@Transactional
	@Modifying
	@Query("UPDATE BandMainSasaki SET delFlg=1 WHERE id=:id")
	void delete(@Param("id") final long id);

	@Transactional
	@Modifying
	@Query("DELETE FROM BandMainSasaki WHERE id IN(:ids)")
	void deleteComp(@Param("ids") final ArrayList<Long> ids);
}
