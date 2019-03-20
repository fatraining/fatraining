package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.bandSasaki.BandMain;
import jp.co.futureantiques.webapptraining.model.bandSasaki.Birthplace;
import jp.co.futureantiques.webapptraining.model.bandSasaki.Member;
import jp.co.futureantiques.webapptraining.model.form.bandSasaki.BandSasakiInputForm;
import jp.co.futureantiques.webapptraining.model.form.bandSasaki.BandSasakiSearchForm;
import jp.co.futureantiques.webapptraining.repository.bandSasaki.BandMainRepository;
import jp.co.futureantiques.webapptraining.repository.bandSasaki.BirthplaceRepository;
import jp.co.futureantiques.webapptraining.repository.bandSasaki.MemberRepository;
import jp.co.futureantiques.webapptraining.repository.specification.BandSasakiSpecification;
import jp.co.futureantiques.webapptraining.service.BandSasakiService;

@Service
public class BandSasakiServiceImpl implements BandSasakiService{
	private final BandMainRepository bandMainRepository;
	private final MemberRepository memberRepository;
	private final BirthplaceRepository birthplaceRepository;

	@Autowired
	public BandSasakiServiceImpl(BandMainRepository bandMainRepository, MemberRepository memberRepository,
			BirthplaceRepository birthplaceRepository) {
		this.bandMainRepository=bandMainRepository;
		this.memberRepository=memberRepository;
		this.birthplaceRepository=birthplaceRepository;
	}

	@Override
	public List<Member> getListMember(){
		return memberRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<Birthplace> getListBirthplace(){
		return birthplaceRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<BandMain> getPageBand(final BandSasakiSearchForm form, final Pageable pageable){
		return bandMainRepository.findAll(BandSasakiSpecification.generateBandSpecification(form), pageable);
	}

	@Override
	public List<BandMain> getListBand(final BandSasakiSearchForm form){
		return bandMainRepository.findAll(BandSasakiSpecification.generateBandSpecification(form));
	}

	@Override
	public BandMain getBand(final long id) {
		return bandMainRepository.findOne(id);
	}

	@Override
	public BandMain insertBand(final BandSasakiInputForm form) {
		final BandMain bandMain=form.convertToBandMainForInsert();
		return bandMainRepository.save(bandMain);
	}

	@Override
	public BandMain updateBand(final BandSasakiInputForm form) {
		BandMain bandMain=bandMainRepository.findOne((long) form.getId());
		if(bandMain!=null) {
			if(form.getUpdateDate().equals(String.valueOf(bandMain.getUpdateDate()))) {
				bandMain=form.convertToBandMainForInsert();
				return bandMainRepository.saveAndFlush(bandMain);
			}
		}
		return null;
	}

	@Override
	public void deleteBandById(final long id) {
		BandMain bandMain=bandMainRepository.findOne(id);
		if(bandMain!=null) {
			bandMainRepository.delete(id);
		}
	}
@Override
public void deleteBandComp(final ArrayList<Long> ids) {
	bandMainRepository.deleteComp(ids);
}
}
