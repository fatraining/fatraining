package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.bandSasaki.BandMainSasaki;
import jp.co.futureantiques.webapptraining.model.bandSasaki.BirthplaceSasaki;
import jp.co.futureantiques.webapptraining.model.bandSasaki.MemberSasaki;
import jp.co.futureantiques.webapptraining.model.form.bandSasaki.BandSasakiInputForm;
import jp.co.futureantiques.webapptraining.model.form.bandSasaki.BandSasakiSearchForm;

public interface BandSasakiService {

	List<MemberSasaki> getListMember();
	List<BirthplaceSasaki> getListBirthplace();

	Page<BandMainSasaki> getPageBand(final BandSasakiSearchForm form, final Pageable pageable);

	List<BandMainSasaki> getListBand(final BandSasakiSearchForm form);

	BandMainSasaki getBand(final long id);

	BandMainSasaki insertBand(final BandSasakiInputForm form);

	BandMainSasaki updateBand(final BandSasakiInputForm form);

	void deleteBandById(final long id);

	void deleteBandComp(final ArrayList<Long> ids);
}
