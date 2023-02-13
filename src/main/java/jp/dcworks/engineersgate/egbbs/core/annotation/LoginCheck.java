package jp.dcworks.engineersgate.egbbs.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ログインチェックを行う場合に使用するマーカーアノテーション.
 * <p>
 * ※クラス、メソッドどちらでも設定可能。
 * </p>
 *
 * @author tomo-sato
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE, ElementType.METHOD})
public @interface LoginCheck {
}
