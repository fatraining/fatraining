package jp.co.futureantiques.webapptraining.repository.novelOkudaira;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.novelOkudaira.WriterOkudaira;

/**
 * WriterOkudairaリポジトリのインターフェース
 *
 * @author future
 */
public interface WriterOkudairaRepository extends JpaRepository<WriterOkudaira, Long> {
}