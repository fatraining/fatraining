package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.yugiohOkugawa.YugiohOkugawaInputForm;
import jp.co.futureantiques.webapptraining.model.form.yugiohOkugawa.YugiohOkugawaSearchForm;
import jp.co.futureantiques.webapptraining.model.yugiohOkugawa.DeckOkugawa;
import jp.co.futureantiques.webapptraining.model.yugiohOkugawa.SeriesOkugawa;
import jp.co.futureantiques.webapptraining.model.yugiohOkugawa.YugiohMainOkugawa;
import jp.co.futureantiques.webapptraining.repository.specification.YugiohOkugawaSpecification;
import jp.co.futureantiques.webapptraining.repository.yugiohOkugawa.DeckOkugawaRepository;
import jp.co.futureantiques.webapptraining.repository.yugiohOkugawa.SeriesOkugawaRepository;
import jp.co.futureantiques.webapptraining.repository.yugiohOkugawa.YugiohMainOkugawaRepository;
import jp.co.futureantiques.webapptraining.service.YugiohOkugawaService;

/** YugiohOkugawaのサービス実装クラス */

@Service
public class YugiohOkugawaServiceImpl implements YugiohOkugawaService {

	/** YugiohMainOkugawaのリポジトリ*/
	private final YugiohMainOkugawaRepository yugiohMainOkugawaRepository;

	/** SeriesOkugawaのリポジトリ */
	private final SeriesOkugawaRepository seriesOkugawaRepository;

	/** DeckOkugawaのリポジトリ */
	private final DeckOkugawaRepository deckOkugawaRepository;

	/**
	 * コンストラクタ
	 *
	 * @param YugiohMainOkugawaRepository yugiohMainOkugawaRepository
	 * @param SeriesOkugawaRepository seriesOkugawa
	 * @param DeckOkugawa deckOkugawa
	 */
	@Autowired
	public YugiohOkugawaServiceImpl(YugiohMainOkugawaRepository yugiohMainOkugawaRepository,
			SeriesOkugawaRepository seriesOkugawaRepository,
			DeckOkugawaRepository deckOkugawaRepository) {
		this.yugiohMainOkugawaRepository = yugiohMainOkugawaRepository;
		this.seriesOkugawaRepository = seriesOkugawaRepository;
		this.deckOkugawaRepository = deckOkugawaRepository;
	}

	@Override
	public List<SeriesOkugawa> getListSeriesOkugawa() {

		//SeriesテーブルのレコードをID順に取得
		return seriesOkugawaRepository.findAll(new Sort(Sort.Direction.ASC, "id"));

	}

	@Override
	public List<DeckOkugawa> getListDeckOkugawa() {

		//DeckテーブルのレコードをID順に取得
		return deckOkugawaRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<YugiohMainOkugawa> getPageYugiohOkugawa(final YugiohOkugawaSearchForm form, final Pageable pageable) {

		//検索条件を生成し、YugiohMainOkugawaのテーブルのレコードを取得
		return yugiohMainOkugawaRepository.findAll(YugiohOkugawaSpecification.generateYugiohSpecification(form),
				pageable);
	}

	@Override
	public List<YugiohMainOkugawa> getListYugiohOkugawa(final YugiohOkugawaSearchForm form) {

		//検索条件を生成しYugiohMainOkugawaのテーブルレコードを取得
		return yugiohMainOkugawaRepository.findAll(YugiohOkugawaSpecification.generateYugiohSpecification(form));
	}

	@Override
	public YugiohMainOkugawa getYugiohOkugawa(final long id) {

		//YugiohMainOkgawaテーブルを主キー検索
		return yugiohMainOkugawaRepository.findOne(id);
	}

	@Override
	public YugiohMainOkugawa insertYugiohOkugawa(final YugiohOkugawaInputForm form) {

		//YugiohOkugawaテーブルで新規でデータを登録する
		final YugiohMainOkugawa yugiohMainOkugawa = form.convertToYugiohMainOkugawaForInsert();
		return yugiohMainOkugawaRepository.save(yugiohMainOkugawa);
	}

	@Override
	public YugiohMainOkugawa updateYugiohOkugawa(final YugiohOkugawaInputForm form) {

		//更新対象のレコードを取得する
		YugiohMainOkugawa yugiohMainOkugawa = yugiohMainOkugawaRepository.findOne((long) form.getId());
		if (yugiohMainOkugawa != null) {

			//更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(yugiohMainOkugawa.getUpdateDate()))) {

				//チェックOKの場合、更新
				yugiohMainOkugawa = form.convertToYugiohMainOkugawaForUpdate(yugiohMainOkugawa);
				return yugiohMainOkugawaRepository.saveAndFlush(yugiohMainOkugawa);
			}
		}
		return null;
	}

	@Override
	public void deleteYugiohOkugawaById(final long id) {

		//更新対象のレコードを取得する
		YugiohMainOkugawa yugiohMainOkugawa = yugiohMainOkugawaRepository.findOne(id);
		if (yugiohMainOkugawa != null) {

			//更新対象のレコードが存在する場合削除フラグを1にする
			yugiohMainOkugawaRepository.delete(id);
		}
	}

	@Override
	public void deleteYugiohOkugawaComp(final ArrayList<Long> ids) {
		//対象のレコードを削除する
		yugiohMainOkugawaRepository.deleteComp(ids);
	}
}
