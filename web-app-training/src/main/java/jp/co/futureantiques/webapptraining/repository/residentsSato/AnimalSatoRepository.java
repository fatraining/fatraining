package jp.co.futureantiques.webapptraining.repository.residentsSato;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.futureantiques.webapptraining.model.residentsSato.AnimalSato;

/**
* AnimalSatoリポジトリのインターフェース
*
* @author future
*/
public interface AnimalSatoRepository extends JpaRepository<AnimalSato, Long> {
}
