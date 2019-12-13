package jp.co.futureantiques.webapptraining.repository.liveMainKawada;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.liveMainKawada.AlbumKawada;

/**
 * Albumkawadaリポジトリのインターフェース
 * @author future
 *
 */
public interface AlbumKawadaRepository extends JpaRepository<AlbumKawada, Long> {
}
