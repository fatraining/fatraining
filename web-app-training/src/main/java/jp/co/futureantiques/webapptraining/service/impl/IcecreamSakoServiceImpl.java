package jp.co.futureantiques.webapptraining.service.impl;

import java.io.File;
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
import jp.co.futureantiques.webapptraining.model.IcecreamSako.GenreSako;
import jp.co.futureantiques.webapptraining.model.IcecreamSako.IcecreamMainSako;
import jp.co.futureantiques.webapptraining.model.IcecreamSako.MakerSako;
import jp.co.futureantiques.webapptraining.model.form.icecreamSako.IcecreamInputForm;
import jp.co.futureantiques.webapptraining.model.form.icecreamSako.IcecreamSearchForm;
import jp.co.futureantiques.webapptraining.repository.IcecreamSako.GenreSakoRepository;
import jp.co.futureantiques.webapptraining.repository.IcecreamSako.IcecreamMainSakoRepository;
import jp.co.futureantiques.webapptraining.repository.IcecreamSako.MakerSakoRepository;
import jp.co.futureantiques.webapptraining.repository.specification.IcecreamSakoSpecification;
import jp.co.futureantiques.webapptraining.service.IcecreamSakoService;

/**
 * IcecreamMainSakoのサービス実装クラス
 *
 * @author MINAMI SAKO
 */
@Service
public class IcecreamSakoServiceImpl implements IcecreamSakoService {

	/** IcecreamMainSakoリポジトリ */
	private final IcecreamMainSakoRepository icecreamMainSakoRepository;

	/**Genreレポジトリ */
	private final GenreSakoRepository genreSakoReposiory;

	/** Makerレポジトリ */
	private final MakerSakoRepository makerSakoRepository;

	/**
	 * コンストラクタ
	 *
	 * @param IcecreamMainSakoRepository icecreamMainSakoReopository
	 * @param GenreSakoRepository genreSakoRepository
	 * @param MakerSakoRepository makerSakoRepository
	 */
	@Autowired
	public IcecreamSakoServiceImpl(IcecreamMainSakoRepository icecreamMainSakoRepository,
			GenreSakoRepository genreSakoRepository, MakerSakoRepository makerSakoRepository) {
		this.icecreamMainSakoRepository = icecreamMainSakoRepository;
		this.genreSakoReposiory = genreSakoRepository;
		this.makerSakoRepository = makerSakoRepository;
	}

	@Override
	public List<GenreSako> getListGenreSako() {

		//genre_sakoテーブルのレコードをID順に取得する
		return genreSakoReposiory.findAll(new Sort(Sort.Direction.ASC, "genreId"));
	}

	@Override
	public List<MakerSako> getListMakerSako() {

		//maker_sakoテーブルのレコードをID順に取得する
		return makerSakoRepository.findAll(new Sort(Sort.Direction.ASC, "makerId"));
	}

	@Override
	public Page<IcecreamMainSako> getPageIcecream(IcecreamSearchForm form, Pageable pageable) {
		//検索条件を生成しicecream_main_sakoテーブルのレコードを取得する
		return icecreamMainSakoRepository.findAll(IcecreamSakoSpecification.generateIcecreamSpecification(form),
				(Pageable) pageable);
	}

	@Override
	public List<IcecreamMainSako> getListIcecream(final IcecreamSearchForm form) {

		//検索条件を生成しicecream_main_sakoテーブルのレコードを取得する
		return icecreamMainSakoRepository.findAll(IcecreamSakoSpecification.generateIcecreamSpecification(form));
	}

	@Override
	public IcecreamMainSako getIcecream(long id) {

		//icecream_main_sakoテーブルを主キー検索する
		return icecreamMainSakoRepository.findOne(id);
	}

	@Override
	public IcecreamMainSako insertIcecream(IcecreamInputForm form) {

		//icecream_main_sakoテーブルに新規でデータを登録する
		final IcecreamMainSako icecreamMainSako = form.convertToIcecreamMainSakoForInsert();

		//ファイルをアップロードする
		uploadFile(icecreamMainSako , form.getPhoto());

		return icecreamMainSakoRepository.save(icecreamMainSako);
	}

	@Override
	public IcecreamMainSako updateIcecream(IcecreamInputForm form) {

		//更新対象のレコードを取得する
		IcecreamMainSako icecreamMainSako = icecreamMainSakoRepository.findOne((long) form.getId());
		if (icecreamMainSako != null) {

			//更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(icecreamMainSako.getUpdateDate()))) {

				//チェックOKの場合、更新
				icecreamMainSako = form.convertToIcecreamMainSakoForUpdate(icecreamMainSako);

				if (form.getPhoto().isEmpty()) {

					//今あるデータベースの画像パスを入れとく
					String imageTemp = icecreamMainSako.getPhoto();

					//エンティティに画像パスを入れなおす
					icecreamMainSako.setPhoto(imageTemp);

					return icecreamMainSakoRepository.saveAndFlush(icecreamMainSako);
				}
				//ファイルをアップロードする
				uploadFile(icecreamMainSako, form.getPhoto());

				return icecreamMainSakoRepository.saveAndFlush(icecreamMainSako);
			}
		}
		return null;
	}

	@Override
	public void deleteIcecreamById(final long id) {

		//更新対象のレコードを取得する
		IcecreamMainSako icecreamMainSako = icecreamMainSakoRepository.findOne(id);
		if (icecreamMainSako != null) {

			//更新対象のレコードが存在する場合、削除フラグを1にする
			icecreamMainSakoRepository.delete(id);
		}
	}

	@Override
	public void deleteIcecreamComp(ArrayList<Long> ids) {

		//対象のレコードの画像を削除する
		for(long id : ids) {
			File f = new File(CommonConst.STATIC_PATH + icecreamMainSakoRepository.findOne(id).getPhoto());
			if(f.exists()) {

				//ファイルが存在する場合削除
				f.delete();
			}
		}

		//対象のレコードを削除する
		icecreamMainSakoRepository.deleteComp(ids);
	}

	/**
	 * 選択したファイルを指定のパスにアップロードする
	 *
	 * @param icecreamMainSako
	 * @param Photo
	 */
	private void uploadFile(IcecreamMainSako icecreamMainSako , MultipartFile photo) {

		//追加する画像ファイルのパス
		Path path = Paths.get(CommonConst.STATIC_PATH + "/icecreamSako");

		//ファイル名をつけるため拡張子や現在日時を取得
		int dot = photo.getOriginalFilename().lastIndexOf(".");
		String extention = "";
		if(dot > 0) {
			extention =photo.getOriginalFilename().substring(dot).toLowerCase();
		}
		String filename = DateTimeFormatter.ofPattern("yyyyMMddHHmmSSS").format(LocalDateTime.now());

		//エンティティに画像の値を入れる
		icecreamMainSako.setPhoto("/icecreamSako/" + filename + extention);

		//指定した場所にファイルを書き込む
		path = path.resolve(filename + extention);
		try(OutputStream os = Files.newOutputStream(path,StandardOpenOption.CREATE)){
			byte[]bytes = photo.getBytes();
			os.write(bytes);
		}catch(IOException e) {
			e.printStackTrace();

			}
		}
	}

