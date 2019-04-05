package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.bandSasaki.BandMainSasaki;
import jp.co.futureantiques.webapptraining.model.bandSasaki.BirthplaceSasaki;
import jp.co.futureantiques.webapptraining.model.bandSasaki.MemberSasaki;
import jp.co.futureantiques.webapptraining.model.form.bandSasaki.BandSasakiInputForm;
import jp.co.futureantiques.webapptraining.model.form.bandSasaki.BandSasakiSearchForm;
import jp.co.futureantiques.webapptraining.repository.bandSasaki.BandMainSasakiRepository;
import jp.co.futureantiques.webapptraining.repository.bandSasaki.BirthplaceSasakiRepository;
import jp.co.futureantiques.webapptraining.repository.bandSasaki.MemberSasakiRepository;
import jp.co.futureantiques.webapptraining.repository.specification.BandSasakiSpecification;
import jp.co.futureantiques.webapptraining.service.BandSasakiService;

@Service
public class BandSasakiServiceImpl implements BandSasakiService{
	private final BandMainSasakiRepository bandMainSasakiRepository;
	private final MemberSasakiRepository memberSasakiRepository;
	private final BirthplaceSasakiRepository birthplaceSasakiRepository;

	@Autowired
	public BandSasakiServiceImpl(BandMainSasakiRepository bandMainSasakiRepository, MemberSasakiRepository memberSasakiRepository,
			BirthplaceSasakiRepository birthplaceSasakiRepository) {
		this.bandMainSasakiRepository=bandMainSasakiRepository;
		this.memberSasakiRepository=memberSasakiRepository;
		this.birthplaceSasakiRepository=birthplaceSasakiRepository;
	}

	@Override
	public List<MemberSasaki> getListMember(){
		return memberSasakiRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<BirthplaceSasaki> getListBirthplace(){
		return birthplaceSasakiRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<BandMainSasaki> getPageBand(final BandSasakiSearchForm form, final Pageable pageable){
		return bandMainSasakiRepository.findAll(BandSasakiSpecification.generateBandSpecification(form), pageable);
	}

	@Override
	public List<BandMainSasaki> getListBand(final BandSasakiSearchForm form){
		return bandMainSasakiRepository.findAll(BandSasakiSpecification.generateBandSpecification(form));
	}

	@Override
	public BandMainSasaki getBand(final long id) {
		return bandMainSasakiRepository.findOne(id);
	}

	@Override
	public BandMainSasaki insertBand(final BandSasakiInputForm form) {
		final BandMainSasaki bandMainSasaki=form.convertToBandMainSasakiForInsert();
		return bandMainSasakiRepository.save(bandMainSasaki);
	}

	@Override
	public BandMainSasaki updateBand(final BandSasakiInputForm form) {
		BandMainSasaki bandMainSasaki=bandMainSasakiRepository.findOne((long) form.getId());
		if(bandMainSasaki!=null) {
			if(form.getUpdateDate().equals(String.valueOf(bandMainSasaki.getUpdateDate()))) {
				bandMainSasaki=form.convertToBandMainSasakiForInsert();
				return bandMainSasakiRepository.saveAndFlush(bandMainSasaki);
			}
		}
		return null;
	}

	@Override
	public void deleteBandById(final long id) {
		BandMainSasaki bandMainSasaki=bandMainSasakiRepository.findOne(id);
		if(bandMainSasaki!=null) {
			bandMainSasakiRepository.delete(id);
		}
	}
@Override
public void deleteBandComp(final ArrayList<Long> ids) {
	bandMainSasakiRepository.deleteComp(ids);
}
}
