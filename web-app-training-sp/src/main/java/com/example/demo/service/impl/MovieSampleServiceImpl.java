package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
//import java.awt.print.Pageable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.form.moviesample.MovieSampleInputForm;
import com.example.demo.model.form.moviesample.MovieSampleSearchForm;
import com.example.demo.model.moviesample.Genre;
import com.example.demo.model.moviesample.MovieActor;
import com.example.demo.model.moviesample.MovieMain;
import com.example.demo.repository.moviesample.GenreRepository;
import com.example.demo.repository.moviesample.MovieActorRepository;
import com.example.demo.repository.moviesample.MovieMainRepository;
import com.example.demo.repository.specification.MovieSampleSpecification;
import com.example.demo.service.MovieSampleService;

/**
 * MovieSampleのサービス実装クラス
 *
 * @author future
 */
@Service
public class MovieSampleServiceImpl implements MovieSampleService {

	/** MovieMainリポジトリ */
	private final MovieMainRepository movieMainRepository;

	/** Genreリポジトリ */
	private final GenreRepository genreRepository;

	/** MovieActorリポジトリ */
	private final MovieActorRepository movieActorRepository;

	/**
	 * コンストラクタ
	 *
	 * @param MovieMainRepository movieMainRepository
	 * @param GenreRepository genreRepository
	 * @param MovieActorRepository movieActorRepository
	 */
	public MovieSampleServiceImpl(MovieMainRepository movieMainRepository, GenreRepository genreRepository,
			MovieActorRepository movieActorRepository) {
		this.movieMainRepository = movieMainRepository;
		this.genreRepository = genreRepository;
		this.movieActorRepository = movieActorRepository;
	}

	@Override
	public List<Genre> getListGenre() {

		// GenreテーブルのレコードをID順に取得する TO:DO
		return genreRepository.findAll();
	}

	@Override
	public List<MovieActor> getListMovieActor() {

		// MovieActorテーブルのレコードをID順に取得するTO:DO
		return movieActorRepository.findAll();
	}

	@Override
	public Page<MovieMain> getPageMovie(final MovieSampleSearchForm form, final Pageable pageable) {

		// 検索条件を生成しMovieMainテーブルのレコードを取得する
		return movieMainRepository.findAll(MovieSampleSpecification.generateMovieSpecification(form), pageable);
	}

	@Override
	public List<MovieMain> getListMovie(final MovieSampleSearchForm form) {

		// 検索条件を生成しMovieMainテーブルのレコードを取得する
		return movieMainRepository.findAll(MovieSampleSpecification.generateMovieSpecification(form));
	}

	@Override
	public MovieMain getMovie(final long id) {

		// MovieMainテーブルを主キー検索する
		MovieMain movieMain = movieMainRepository.findById(id).get();
		return movieMain;
	}

	@Override
	public MovieMain insertMovie(final MovieSampleInputForm form) {

		// MovieMainテーブルに新規でデータを登録する
		final MovieMain movieMain = form.convertToMovieMainForInsert();
		return movieMainRepository.saveAndFlush(movieMain);
	}

	@Override
	public MovieMain updateMovie(final MovieSampleInputForm form) {

		// 更新対象のレコードを取得する
		Optional<MovieMain> movieMainOp = movieMainRepository.findById((long) form.getId());
		
		MovieMain movieMain = movieMainOp.get();
		if (movieMain != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(movieMain.getUpdateDate()))) {

				// チェックOKの場合、更新
				movieMain = form.convertToMovieMainForUpdate(movieMain);
				return movieMainRepository.saveAndFlush(movieMain);
			}
		}
		return null;
	}

	@Override
	public void deleteMovieById(final long id) {

		// 更新対象のレコードを取得する
		Optional<MovieMain> movieMainOp = movieMainRepository.findById(id);
		MovieMain movieMain = movieMainOp.get();
		if (movieMain != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			movieMainRepository.delete(id);
		}
	}

	@Override
	public void deleteMovieComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		movieMainRepository.deleteComp(ids);
	}
}