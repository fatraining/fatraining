package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.bandSasaki.BandMain;
import jp.co.futureantiques.webapptraining.model.bandSasaki.Birthplace;
import jp.co.futureantiques.webapptraining.model.bandSasaki.Member;
import jp.co.futureantiques.webapptraining.model.form.bandSasaki.BandSasakiInputForm;
import jp.co.futureantiques.webapptraining.model.form.bandSasaki.BandSasakiSearchForm;

public interface BandSasakiService {

	List<Member> getListMember();
	List<Birthplace> getListBirthplace();

	Page<BandMain> getPageBand(final BandSasakiSearchForm form, final Pageable pageable);

	List<BandMain> getListBand(final BandSasakiSearchForm form);

	BandMain getBand(final long id);

	BandMain insertBand(final BandSasakiInputForm form);

	BandMain updateBand(final BandSasakiInputForm form);

	void deleteBandById(final long id);

	void deleteBandComp(final ArrayList<Long> ids);
}
