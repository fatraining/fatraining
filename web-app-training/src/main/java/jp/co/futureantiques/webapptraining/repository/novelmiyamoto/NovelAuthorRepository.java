package jp.co.futureantiques.webapptraining.repository.novelmiyamoto;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.novelmiyamoto.AuthorMiyamoto;

/**
 * NovelAuthorリポジトリのインターフェース
 */
public interface NovelAuthorRepository extends JpaRepository<AuthorMiyamoto, Long> {
}