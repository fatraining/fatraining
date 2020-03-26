package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import jp.co.futureantiques.webapptraining.model.form.voiceActorKoba.VoiceActorKobaSearchForm;
import jp.co.futureantiques.webapptraining.model.voiceActorKoba.VoiceActorMainKoba;

public class VoiceActorKobaSpecification {

    public static Specification<VoiceActorMainKoba> generateVoiceActorKobaSpecification(VoiceActorKobaSearchForm form) {
        return new Specification<VoiceActorMainKoba>() {
            @Override
            public Predicate toPredicate(Root<VoiceActorMainKoba> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// 検索条件
                Predicate condition = null;

				// 条件が入力されている場合条件追加

                if (form.getId() != null) {
                // IDを条件に追加
                    Predicate newCondition = cb.equal(root.get("id"), form.getId());
                    condition = getPredicate(cb, condition, newCondition);
                }

				if(!StringUtils.isEmpty(form.getActorName())) {
					// 声優名を条件に追加
					// form.setActorName(form.getActorName().trim());
					Predicate newCondition = cb.like(root.get("actorName"),"%" + form.getActorName() + "%");
					condition = getPredicate(cb,condition,newCondition);
				}

				if (form.getOfficeId() != null && form.getOfficeId() != 0) {
                    Predicate newCondition = cb.equal(root.get("officeId"), form.getOfficeId());
                    condition = getPredicate(cb, condition, newCondition);
                }

                if (!StringUtils.isEmpty(form.getAnimeTitle())) {
                	// アニメタイトルを条件に追加
                    Predicate newCondition = cb.and(
                            cb.like(root.get("animeTitle"), "%"+form.getAnimeTitle()+"%"),
                            cb.notEqual(root.get("animeTitle"), "unknown")
                    );
                    condition = getPredicate(cb, condition, newCondition);
                }

                return condition;
            }

            private Predicate getPredicate(CriteriaBuilder cb, Predicate condition,@NotNull Predicate newCondition) {
                if (condition != null) {
                // すでに条件がある場合ANDで結合する
                    condition = cb.and(condition, newCondition);
                } else {
                // 条件がまだ無い場合先頭の条件になる
                    condition = newCondition;
                }
                return condition;
            }
        };
    }
}
