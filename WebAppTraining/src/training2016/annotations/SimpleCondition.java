package training2016.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 検索条件モデルの各フィールドにつける。
 * 単一条件として使われるものにつけること。
 *
 * @author harasan
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SimpleCondition {
	public String name() default "";
	public String operator() default "";
	public boolean fuzzy() default false;
	public boolean from() default false; // 未使用
	public boolean to() default false; // 未使用
}
