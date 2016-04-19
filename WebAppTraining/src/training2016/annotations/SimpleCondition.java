package training2016.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 検索条件モデルの各フィールドにつける。
 * DB上では数値で扱われるフィールドにつけること。
 *
 * @author harasan
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SimpleCondition {
	public String name() default "";
	public boolean from() default false; // 未使用
	public boolean to() default false; // 未使用
}
