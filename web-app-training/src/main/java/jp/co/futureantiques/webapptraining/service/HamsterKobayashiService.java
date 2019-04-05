package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.TypeKobayashi.GraduateKobayashi;
import jp.co.futureantiques.webapptraining.model.TypeKobayashi.HamsterMainKobayashi;
import jp.co.futureantiques.webapptraining.model.TypeKobayashi.TypeKobayashi;
import jp.co.futureantiques.webapptraining.model.form.hamsterKobayashi.HamsterKobayashiInputForm;
import jp.co.futureantiques.webapptraining.model.form.hamsterKobayashi.HamsterKobayashiSearchForm;

//HamsterKobayashiのサービスインターフェース

public interface HamsterKobayashiService {

	//種類エンティティのリストを取得する

	List<TypeKobayashi> getListTypeKobayashi();

	//出身エンティティのリストを取得する

	List<GraduateKobayashi> getListGraduateKobayashi();

	//検索条件を元にHamsterMainKobayashiのレコードリストを取得する（Paging)

	Page<HamsterMainKobayashi> getPageHamster(final HamsterKobayashiSearchForm form, final Pageable pageable);

	//検索条件を元にMovieMainのレコードのリストを取得する

	List<HamsterMainKobayashi> getListHamster(final HamsterKobayashiSearchForm form);

	// IDをキーにHamsterMainKobayashiのレコードを取得する

	HamsterMainKobayashi getHamster(final long id);

	HamsterMainKobayashi insertHamster(final HamsterKobayashiInputForm form);

	HamsterMainKobayashi updateHamster(final HamsterKobayashiInputForm form);

	void deleteHamsterById(final long id);

	void deleteHamsterComp(final ArrayList<Long> ids);

}
