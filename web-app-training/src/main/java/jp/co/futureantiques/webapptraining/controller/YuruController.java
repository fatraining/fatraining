package jp.co.futureantiques.webapptraining.controller;

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.form.yuruYokoyama.YuruDeleteFrom;
import jp.co.futureantiques.webapptraining.model.form.yuruYokoyama.YuruInputForm;
import jp.co.futureantiques.webapptraining.model.form.yuruYokoyama.YuruSearchFrom;
import jp.co.futureantiques.webapptraining.model.yuruYokoyama.YuruBelongYokoyama;
import jp.co.futureantiques.webapptraining.model.yuruYokoyama.YuruDataYokoyama;
import jp.co.futureantiques.webapptraining.model.yuruYokoyama.YuruFromYokoyama;
import jp.co.futureantiques.webapptraining.service.YuruYokoyamaService;

	/**
	 * MovieSampleのコントローラークラス
	 *
	 * @author future
	 */
	@Controller
	@RequestMapping(value = "/yuruYokoyama")
	public class YuruController {

		/** ゆるキャラのサービス */
		private final YuruYokoyamaService yuruYokoyamaService;

		/**
		 * コンストラクタ
		 *
		 * @param YuruYokoyamaService yuruYokoyamaService
		 */
		@Autowired
		public YuruController(final YuruYokoyamaService yuruYokoyamaService) {
			this. yuruYokoyamaService =  yuruYokoyamaService;
		}

		/**
		 * 所属エンティティのリストを取得する
		 *
		 * @return BelongEntityのリスト
		 */
		@ModelAttribute
		public List<YuruBelongYokoyama> getListYuruBelong() {
			return yuruYokoyamaService.getListYuruBelong();
		}

		/**
		 * 出身エンティティのリストを取得する
		 *
		 * @return 出身Entityのリスト
		 */
		@ModelAttribute
		public List<YuruFromYokoyama> getListYuruFrom() {
			return yuruYokoyamaService.getListYuruFrom();
		}

		/**
		 * 検索画面に遷移する
		 *
		 * @param YuruSearchForm yuruSearchForm
		 * @return 検索画面のパス
		 */
		@RequestMapping(value = "", method = RequestMethod.GET)
		public String showSearchYuru(@ModelAttribute final YuruSearchFrom yuruSerchFrom) {
			return "yuruYokoyama/search";
		}

		/**
		 * 検索結果を取得して検索画面に遷移する
		 *
		 * @param YuruSearchFrom
		 * @param Model model
		 * @param Pageable pageable
		 * @return 検索画面のパス
		 */
		@RequestMapping(value = "search", method = RequestMethod.POST)
		public String searchYuru(final YuruSearchFrom form, final Model model, final Pageable pageable) {

			// 入力された検索条件を元にレコードを取得する
			final Page<YuruDataYokoyama> yuruList = yuruYokoyamaService.getPageYuru(form, pageable);
			if (yuruList.getTotalElements() != 0) {

				// 検索結果がある場合、Modelに結果をセットする
				model.addAttribute("page", yuruList);
				model.addAttribute("movieList", yuruList.getContent());
				model.addAttribute("url", "search");
			}
			return "yuruYokoyama/search";
		}

		/**
		 * 追加画面に遷移する
		 *
		 * @param YuruInputForm yuruInputForm
		 * @return 追加画面のパス
		 */
		@RequestMapping(value = "insert", method = RequestMethod.GET)
		public String showInsertYuru(@ModelAttribute final YuruInputForm yuruInputForm) {
			return "yuruYokoyama/insert";
		}

		/**
		 * YuruDataテーブルにデータを登録して検索画面に遷移する
		 *
		 * @param YuruInputForm form
		 * @param BindingResult bindingResult
		 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
		 */
		@RequestMapping(value = "insert", method = RequestMethod.POST)
		public String insertYuru(@ModelAttribute @Validated final YuruInputForm form,
				final BindingResult bindingResult) {
			if (bindingResult.hasFieldErrors()) {

				// 入力エラーがある場合自画面に戻る
				return "yuruYokoyama/insert";
			}

			// データを登録する
			final YuruDataYokoyama yuruData  = yuruYokoyamaService.insertYuru(form);
			return "redirect:/yuruYokoyama?result=insert&id=" + yuruData.getId();
		}

		/**
		 * 更新画面に遷移する
		 *
		 * @param long id
		 * @param YuruInputForm yuruInputForm
		 * @return 更新画面のパス
		 */
		@RequestMapping(value = "update", method = RequestMethod.GET)
		public String showUpdateMovie(@RequestParam(name = "id") final long id,
				@ModelAttribute final YuruInputForm yuruInputForm) {

			// IDをキーにYuruDataテーブルを検索する
			YuruDataYokoyama yuruData = yuruYokoyamaService.getYuru(id);

			// フォームにレコードの値をセットする
			yuruInputForm.initWithMovieMain(yuruData);
			return "yuruYokoyama/update";
		}

		/**
		 * YuruDatanテーブルのデータを更新して検索画面に遷移する
		 *
		 * @param YuruInputForm form
		 * @param BindingResult bindingResult
		 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
		 */
		@RequestMapping(value = "update", method = RequestMethod.POST)
		public String updateYuru(@Validated final YuruInputForm form,
				final BindingResult bindingResult) {
			if (bindingResult.hasFieldErrors()) {

				// 入力エラーがある場合自画面に戻る
				return "yuruYokoyama/update";
			}

			// データを更新する
			YuruDataYokoyama yuruData = yuruYokoyamaService.updateYuru(form);
			if (yuruData == null) {

				// 更新が失敗した場合、検索画面にメッセージを表示する
				return "redirect:/yuruYokoyama?result=updatefailed";
			}
			return "redirect:/yuruYokoyama?result=update&id=" + yuruData.getId();
		}

		/**
		 * YuruDataテーブルのレコードを論理削除して検索画面に遷移する
		 *
		 * @param long id
		 * @return 検索画面のパス
		 */
		@RequestMapping(value = "delete", method = RequestMethod.GET)
		public String deleteYuru(@RequestParam(name = "id") final long id) {

			// IDをキーにレコードを論理削除する
			yuruYokoyamaService.deleteYuruById(id);
			return "redirect:/yuruYokoyama?result=delete&id=" + id;
		}

		/**
		 * 完全削除画面に遷移する
		 *
		 * @param YuruSearchFrom form
		 * @param YuruSearchFrom yuruSerchFrom
		 * @param Model model
		 * @return 完全削除画面のパス
		 */
		@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
		public String showDeleteCompYuru(final YuruSearchFrom form,
				@ModelAttribute final YuruDeleteFrom yuruDeleteForm, final Model model) {

			// MovieMainテーブルから削除フラグが1のレコードを検索する
			final List<YuruDataYokoyama> yuruList = yuruYokoyamaService.getListYuru(form);

			// Modelに検索結果を格納する
			model.addAttribute(yuruList);
			return "yuruYokoyama/deletecomp";
		}

		/**
		 * YuruDataテーブルのデータを完全削除して検索画面に遷移する
		 *
		 * @param YuruDeleteFrom form
		 * @param BindingResult bindingResult
		 * @param Model model
		 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
		 */
		@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
		public String deleteCompYuru(@Validated final YuruDeleteFrom form,
				final BindingResult bindingResult, final Model model) {
			if (bindingResult.hasFieldErrors()) {

				// 入力エラーがある場合、再検索して自画面に戻る
				YuruSearchFrom yuruSerchFrom = new YuruSearchFrom();
				yuruSerchFrom.setIsDelete(CommonConst.DELETE_FLG_ON);
				final List<YuruDataYokoyama> YuruList = yuruYokoyamaService.getListYuru(yuruSerchFrom);

				// Modelに検索結果を格納する
				model.addAttribute(YuruList);
				return "yuruYokoyama/deletecomp";
			}

			// データを完全削除する
			yuruYokoyamaService.deleteYuruComp(form.getDeleteIds());
			return "redirect:/yuruYokoyama?result=deletecomp";
		}
	}
