package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

		//GenreテーブルのレコードをID順に取得する
		return genreSakoReposiory.findAll(new Sort(Sort.Direction.ASC, "genreId"));
	}

	@Override
	public List<MakerSako> getListMakerSako() {

		//MakerテーブルのレコードをID順に取得する
		return makerSakoRepository.findAll(new Sort(Sort.Direction.ASC, "makerId"));
	}

	@Override
	public Page<IcecreamMainSako> getPageIcecream(IcecreamSearchForm form, Pageable pageable) {
		//検索条件を生成しIcecreamMainテーブルのレコードを取得する
		return icecreamMainSakoRepository.findAll(IcecreamSakoSpecification.generateIcecreamSpecification(form), (Pageable) pageable);
	}

	@Override
	public List<IcecreamMainSako> getListIcecream(final IcecreamSearchForm form) {

		//検索条件を生成しIcecreamMainSakoテーブルのレコードを取得する
		return icecreamMainSakoRepository.findAll(IcecreamSakoSpecification.generateIcecreamSpecification(form));
	}

	@Override
	public IcecreamMainSako getIcecream(long id) {

		//IcecreamMainテーブルを主キー検索する
		return icecreamMainSakoRepository.findOne(id);
	}

	@Override
	public IcecreamMainSako insertIcecream(IcecreamInputForm form) {

		//IcecreamMainテーブルに新規でデータを登録する
		final IcecreamMainSako icecreamMainSako = form.convertToIcecreamMainForInsert();
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
				icecreamMainSako = form.convertToIcecreamMainForUpdate(icecreamMainSako);
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

		//対象のレコードを削除する
		icecreamMainSakoRepository.deleteComp(ids);
	}
}