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
import jp.co.futureantiques.webapptraining.model.flowerNakai.ColorNakai;
import jp.co.futureantiques.webapptraining.model.flowerNakai.FlowerMainNakai;
import jp.co.futureantiques.webapptraining.model.flowerNakai.MonthNakai;
import jp.co.futureantiques.webapptraining.model.form.flowerNakai.FlowerInputForm;
import jp.co.futureantiques.webapptraining.model.form.flowerNakai.FlowerSearchForm;
import jp.co.futureantiques.webapptraining.repository.flowerNakai.ColorNakaiRepository;
import jp.co.futureantiques.webapptraining.repository.flowerNakai.FlowerMainNakaiRepository;
import jp.co.futureantiques.webapptraining.repository.flowerNakai.MonthNakaiRepository;
import jp.co.futureantiques.webapptraining.repository.specification.FlowerNakaiSpecification;
import jp.co.futureantiques.webapptraining.service.FlowerNakaiService;

/**
 * FlowerNakaiServiceインターフェースの実装クラス
 * @author Rieko Nakai
 *
 */
@Service
public class FlowerNakaiServiceImpl implements FlowerNakaiService {

	/** FlowerMainNakaiリポジトリ */
	private final FlowerMainNakaiRepository flowerMainNakaiRepository;

	/** MonthNakaiリポジトリ */
	private final MonthNakaiRepository monthNakaiRepository;

	/** ColorNakaiリポジトリ */
	private final ColorNakaiRepository colorNakaiRepository;

	/**
	 * コンストラクタ
	 * @param FlowerMainNakaiRepository flowerMainNakaiRepository
	 * @param MonthNakaiRepository monthNakaiRepository
	 * @param ColorNakaiRepository colorNakaiRepository
	 */
	@Autowired
	public FlowerNakaiServiceImpl(FlowerMainNakaiRepository flowerMainNakaiRepository,
			MonthNakaiRepository monthNakaiRepository, ColorNakaiRepository colorNakaiRepository) {
		this.flowerMainNakaiRepository = flowerMainNakaiRepository;
		this.monthNakaiRepository = monthNakaiRepository;
		this.colorNakaiRepository = colorNakaiRepository;
	}

	@Override
	public List<MonthNakai> getListMonthNakai() {

		//month_nakaiテーブルのリストをID順に取得する
		return monthNakaiRepository.findAll(new Sort(Sort.Direction.ASC, "monthId"));
	}

	@Override
	public List<ColorNakai> getListColorNakai() {

		//color_nakaiテーブルのリストをID順番に取得する
		return colorNakaiRepository.findAll(new Sort(Sort.Direction.ASC, "colorId"));
	}

	@Override
	public Page<FlowerMainNakai> getPageFlower(final FlowerSearchForm form, final Pageable pageable) {

		//検索条件を生成し、flower_main_nakaiテーブルのリストを取得する(Paging)
		return flowerMainNakaiRepository.findAll(
				FlowerNakaiSpecification.generateFlowerNakaiSpecification(form), pageable);
	}

	@Override
	public List<FlowerMainNakai> getListFlower(final FlowerSearchForm form) {

		//検索条件を生成し、flower_main_nakaiテーブルのリストを取得する
		return flowerMainNakaiRepository.findAll(
				FlowerNakaiSpecification.generateFlowerNakaiSpecification(form));
	}

	@Override
	public FlowerMainNakai getFlower(final long id) {

		//flower_main_nakaiテーブルを主キー検索
		return flowerMainNakaiRepository.findOne(id);
	}

	@Override
	public FlowerMainNakai insertFlower(final FlowerInputForm form) {

		//flower_main_nakaiテーブルに新規でデータを登録する
		final FlowerMainNakai flowerMainNakai = form.convertToFlowerMainNakaiForInsert();

		// ファイルをアップロードする
		uploadFile(flowerMainNakai, form.getFlowerImage());

		return flowerMainNakaiRepository.save(flowerMainNakai);
	}

	@Override
	public FlowerMainNakai updateFlower(final FlowerInputForm form) {

		//更新対象のレコードを取得
		FlowerMainNakai flowerMainNakai = flowerMainNakaiRepository.findOne((long) form.getId());
		if (flowerMainNakai != null) {

			//更新対象のレコードをが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(flowerMainNakai.getUpdateDate()))) {

				//チェックOKの場合、更新
				flowerMainNakai = form.convertToFlowerMainNakaiForUpdate(flowerMainNakai);

				if (form.getFlowerImage().isEmpty()) {

					//今あるデータベースの画像パスを入れとく
					String imageTemp = flowerMainNakai.getFlowerImage();

					//エンティティに画像パスを入れなおす
					flowerMainNakai.setFlowerImage(imageTemp);

					return flowerMainNakaiRepository.saveAndFlush(flowerMainNakai);
				}

				// ファイルをアップロードする
				uploadFile(flowerMainNakai, form.getFlowerImage());

				return flowerMainNakaiRepository.saveAndFlush(flowerMainNakai);
			}
		}
		return null;
	}

	@Override
	public void deleteFlowerById(final long id) {

		//更新対象のレコードを取得
		FlowerMainNakai flowerMainNakai = flowerMainNakaiRepository.findOne(id);
		if (flowerMainNakai != null) {

			//更新対象のレコードが存在した場合、削除フラグを1にする
			flowerMainNakaiRepository.delete(id);
		}
	}

	@Override
	public void deleteFlowerComp(final ArrayList<Long> ids) {

		//対象のレコードを削除する
		flowerMainNakaiRepository.deleteComp(ids);
	}

	/**
	 * 選択したファイルを指定のパスにアップロードする
	 *
	 * @param flowerMainNakai
	 * @param flowerImage
	 */
	private void uploadFile(FlowerMainNakai flowerMainNakai, MultipartFile flowerImage) {

		//追加する画像ファイルのパス
		Path path = Paths.get(CommonConst.STATIC_PATH + "/FlowerNakai");

		// ファイル名をつけるため拡張子や現在日時を取得
		int dot = flowerImage.getOriginalFilename().lastIndexOf(".");
		String extention = "";
		if (dot > 0) {
			extention = flowerImage.getOriginalFilename().substring(dot).toLowerCase();
		}
		String filename = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now());

		//エンティティに画像の値を入れる
		flowerMainNakai.setFlowerImage("/FlowerNakai/" + filename + extention);

		// 指定した場所にファイルを書き込む
		path = path.resolve(filename + extention);
		try (OutputStream os = Files.newOutputStream(path, StandardOpenOption.CREATE)) {
			byte[] bytes = flowerImage.getBytes();
			os.write(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
