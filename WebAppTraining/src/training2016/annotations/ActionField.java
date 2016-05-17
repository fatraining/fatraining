package training2016.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Actionの各フィールドにつけると画面遷移時に一時保存しておいてくれるかも
 *
 * @author harasan
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ActionField {
	public String name() default "";
}
