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
import jp.co.futureantiques.webapptraining.model.crKawanaka.CategoryKawanaka;
import jp.co.futureantiques.webapptraining.model.crKawanaka.CrMainKawanaka;
import jp.co.futureantiques.webapptraining.model.crKawanaka.DistributionKawanaka;
import jp.co.futureantiques.webapptraining.model.form.crKawanaka.CrInputForm;
import jp.co.futureantiques.webapptraining.model.form.crKawanaka.CrSearchForm;
import jp.co.futureantiques.webapptraining.repository.crKawanaka.CategoryKawanakaRepository;
import jp.co.futureantiques.webapptraining.repository.crKawanaka.CrMainKawanakaRepository;
import jp.co.futureantiques.webapptraining.repository.crKawanaka.DistributionKawanakaRepository;
import jp.co.futureantiques.webapptraining.repository.specification.CrKawanakaSpecification;
import jp.co.futureantiques.webapptraining.service.CrKawanakaService;

/*
 * CrKawanakaServiseインターフェースの実装クラス
 * @author Misato Kawanaka
 */
@Service
public class CrKawanakaServicelmpl implements CrKawanakaService {
	/*CrMainKawanakaリポジトリ*/
	private final CrMainKawanakaRepository crMainKawanakaRepository;

	/*Cotegoryリポジトリ*/
	private final CategoryKawanakaRepository categoryKawanakaRepository;
	/*Distributionリポジトリ*/

	private final DistributionKawanakaRepository distributionKawanakaRepository;
	/*
	 * コンストラクタ
	 * @param CrMainKawanakaReopsitory crMainKawanakaRepository
	 * @param CategoryKawanakaRepository categoryKawanakaRepository
	 * @param DistributionKawanakaRepository distrybutionKawanakaRepository
	 */

	@Autowired
	public CrKawanakaServicelmpl(CrMainKawanakaRepository crMainKawanakaRepository,
			CategoryKawanakaRepository categoryKawanakaRepository,
			DistributionKawanakaRepository distributionKawanakaRepository) {
		this.crMainKawanakaRepository = crMainKawanakaRepository;
		this.categoryKawanakaRepository = categoryKawanakaRepository;
		this.distributionKawanakaRepository = distributionKawanakaRepository;
	}

	@Override
	public List<CategoryKawanaka> getListCategoryKawanaka() {
		//カテゴリーテーブルのリストをID順に取得する
		return categoryKawanakaRepository.findAll(new Sort(Sort.Direction.ASC, "categoryId"));
	}

	@Override
	public List<DistributionKawanaka> getListDistributionKawanaka() {
		//分布テーブルのリストをID順に取得する
		return distributionKawanakaRepository.findAll(new Sort(Sort.Direction.ASC, "distributionId"));
	}

	@Override
	public Page<CrMainKawanaka> getPageCr(final CrSearchForm form, final Pageable pageable) {
		//検索条件を生成し、cr_main_kawanakaテーブルのリストを取得する
		return crMainKawanakaRepository.findAll(
				CrKawanakaSpecification.generateCrKawanakaSpecification(form), pageable);
	}

	@Override
	public List<CrMainKawanaka> getListCr(final CrSearchForm form) {

		//検索条件を生成し、flower_main_nakaiテーブルのリストを取得する
		return crMainKawanakaRepository.findAll(
				CrKawanakaSpecification.generateCrKawanakaSpecification(form));
	}

	@Override
	public CrMainKawanaka getCr(final long id) {

		//flower_main_nakaiテーブルを主キー検索
		return crMainKawanakaRepository.findOne(id);
	}

	@Override
	public CrMainKawanaka insertCr(final CrInputForm form) {

		//cr?main/kawanakaテーブルに新規でデータを登録する
		final CrMainKawanaka crMainKawanaka = form.convertToCrMainKawanakaForInsert();

		// ファイルをアップロードする
		uploadFile(crMainKawanaka, form.getImage());

		return crMainKawanakaRepository.save(crMainKawanaka);
	}

	@Override
	public CrMainKawanaka updateCr(final CrInputForm form) {

		//更新対象のレコードを取得
		CrMainKawanaka crMainKawanaka = crMainKawanakaRepository.findOne((long) form.getId());
		if (crMainKawanaka != null) {

			//更新対象のレコードをが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(crMainKawanaka.getUpdateDate()))) {

				//チェックOKの場合、更新
				crMainKawanaka = form.convertToCrMainKawanakaForUpdate(crMainKawanaka);

				if (form.getImage().isEmpty()) {

					//今あるデータベースの画像パスを入れとく
					String imageTemp = crMainKawanaka.getImage();

					//エンティティに画像パスを入れなおす
					crMainKawanaka.setImage(imageTemp);

					return crMainKawanakaRepository.saveAndFlush(crMainKawanaka);
				}

				// ファイルをアップロードする
				uploadFile(crMainKawanaka, form.getImage());

				return crMainKawanakaRepository.saveAndFlush(crMainKawanaka);
			}
		}
		return null;
	}

	@Override
	public void deleteCrById(final long id) {
		//更新対象のレコードを取得
		CrMainKawanaka crMainKawanaka = crMainKawanakaRepository.findOne(id);
		if (crMainKawanaka != null) {
			//削除フラグを1にする
			crMainKawanakaRepository.delete(id);
		}
	}

	@Override
	public void deleteCrComp(final ArrayList<Long> ids) {
		//対象のレコードを削除
		crMainKawanakaRepository.deleteComp(ids);
	}

	/**
	 * 選択したファイルを指定のパスにアップロードする
	 *
	 * @param crMianKawanaka
	 * @param Image
	 * @param
	 */
	private void uploadFile(CrMainKawanaka crMainKawanaka, MultipartFile Image) {
		//追加する画像パス
		Path path = Paths.get(CommonConst.STATIC_PATH + "/CrKawanaka");

		//ファイル名を付けるため拡張子や現在日時を取得
		int dot = Image.getOriginalFilename().lastIndexOf(".");
		String extention = "";
		if (dot > 0) {
			extention = Image.getOriginalFilename().substring(dot).toLowerCase();
		}
		String filename = DateTimeFormatter.ofPattern("yyyyMMddHHmmSSS").format(LocalDateTime.now());

		//エンティティに画像の値を入れる
		crMainKawanaka.setImage("/CrKawanaka/" + filename + extention);

		//指定した場所にファイルを書き込む
		path = path.resolve(filename + extention);
		try (OutputStream os = Files.newOutputStream(path, StandardOpenOption.CREATE)) {
			byte[] bytes = Image.getBytes();
			os.write(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
