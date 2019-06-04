package jp.co.futureantiques.webapptraining.service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
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
public class BandSasakiServiceImpl implements BandSasakiService {
	private final BandMainSasakiRepository bandMainSasakiRepository;
	private final MemberSasakiRepository memberSasakiRepository;
	private final BirthplaceSasakiRepository birthplaceSasakiRepository;

	@Autowired
	public BandSasakiServiceImpl(BandMainSasakiRepository bandMainSasakiRepository,
			MemberSasakiRepository memberSasakiRepository,
			BirthplaceSasakiRepository birthplaceSasakiRepository) {
		this.bandMainSasakiRepository = bandMainSasakiRepository;
		this.memberSasakiRepository = memberSasakiRepository;
		this.birthplaceSasakiRepository = birthplaceSasakiRepository;
	}

	@Override
	public List<MemberSasaki> getListMember() {
		return memberSasakiRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<BirthplaceSasaki> getListBirthplace() {
		return birthplaceSasakiRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<BandMainSasaki> getPageBand(final BandSasakiSearchForm form, final Pageable pageable) {
		return bandMainSasakiRepository.findAll(BandSasakiSpecification.generateBandSpecification(form), pageable);
	}

	@Override
	public List<BandMainSasaki> getListBand(final BandSasakiSearchForm form) {
		return bandMainSasakiRepository.findAll(BandSasakiSpecification.generateBandSpecification(form));
	}

	@Override
	public BandMainSasaki getBand(final long id) {
		return bandMainSasakiRepository.findOne(id);
	}

	@Override
	public BandMainSasaki insertBand(final BandSasakiInputForm form) {
		final BandMainSasaki bandMainSasaki = form.convertToBandMainSasakiForInsert();
		uploadFile(bandMainSasaki, form.getPhoto());
		return bandMainSasakiRepository.save(bandMainSasaki);
	}

	@Override
	public BandMainSasaki updateBand(final BandSasakiInputForm form) {
		BandMainSasaki bandMainSasaki = bandMainSasakiRepository.findOne((long) form.getId());
		if (bandMainSasaki != null) {
			if (form.getUpdateDate().equals(String.valueOf(bandMainSasaki.getUpdateDate()))) {
				bandMainSasaki = form.convertToBandMainSasakiForUpdate(bandMainSasaki);
				if (form.getPhoto().isEmpty()) {

					//今あるデータベースの画像パスを入れとく
					String imageTemp = bandMainSasaki.getPhoto();

					//エンティティに画像パスを入れなおす
					bandMainSasaki.setPhoto(imageTemp);

					return bandMainSasakiRepository.saveAndFlush(bandMainSasaki);
				}
				//ファイルをアップロードする
				uploadFile(bandMainSasaki, form.getPhoto());
				return bandMainSasakiRepository.saveAndFlush(bandMainSasaki);
			}
		}
		return null;
	}

	@Override
	public void deleteBandById(final long id) {
		BandMainSasaki bandMainSasaki = bandMainSasakiRepository.findOne(id);
		if (bandMainSasaki != null) {
			bandMainSasakiRepository.delete(id);
		}
	}

	@Override
	public void deleteBandComp(final ArrayList<Long> ids) {
		bandMainSasakiRepository.deleteComp(ids);
	}

	
	
	
	private void uploadFile(BandMainSasaki bandMainSasaki, MultipartFile photo) {

		//追加する画像ファイルのパス
		Path path = Paths.get(CommonConst.STATIC_PATH + "/bandimage");

		//ファイル名をつけるため拡張子や現在日時を取得
		int dot = photo.getOriginalFilename().lastIndexOf(".");
		String extention = "";
		if (dot > 0) {
			extention = photo.getOriginalFilename().substring(dot).toLowerCase();
		}
		String filename = DateTimeFormatter.ofPattern("yyyyMMddHHmmSSS").format(LocalDateTime.now());

		//エンティティに画像の値を入れる
		bandMainSasaki.setPhoto("/bandimage/" + filename + extention);

		//指定した場所にファイルを書き込む
		path = path.resolve(filename + extention);
		try (OutputStream os = Files.newOutputStream(path, StandardOpenOption.CREATE)) {
			byte[] bytes = photo.getBytes();
			os.write(bytes);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
}
