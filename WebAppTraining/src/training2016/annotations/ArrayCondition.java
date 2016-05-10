package training2016.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 検索条件モデルの各フィールドにつける。
 * 単一のカラムに対して複数の値を条件とするもの(=in句)につけること。
 *
 * @author harasan
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ArrayCondition {
	public String name() default "";
	public String operator() default "";
	public boolean from() default false; // 未使用
	public boolean to() default false; // 未使用
}
