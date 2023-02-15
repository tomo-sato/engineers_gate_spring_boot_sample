package jp.dcworks.engineersgate.egbbs.util;

import java.util.Objects;

/**
 * 文字列操作に関する機能を提供します。
 *
 * @author tomo-sato
 */
public class StringUtil {

	/** ブランク */
	public static final String BLANK = "";

	/**
	 * 引数のObjectに対する{@link #toString()}を返します。
	 * <p>
	 * ※{@link NullPointerException} 回避の為のユーティリティ。
	 * </p>
	 *
	 * @param obj toStringしたいオブジェクト
	 * @return toStringした結果。引数がnullの場合、nullを返します。
	 */
	public static String toString(Object obj) {
		if (obj == null) {
			return null;
		}
		return obj.toString();
	}

	/**
	 * 引数のObjectに対する{@link #toString()}を返します。
	 * <p>
	 * ※結果がnullの場合、{@code defaultValue} を返します。
	 * </p>
	 *
	 * @param obj toStringしたいオブジェクト
	 * @param defaultValue 結果がnullだった場合のデフォルト値
	 * @return toStringした結果。引数がnullの場合、defaultValueを返します。
	 */
	public static String toString(Object obj, String defaultValue) {
		if (obj == null) {
			return defaultValue;
		}
		return obj.toString();
	}

	/**
	 * 引数のObjectに対する{@link #toString()}を返します。
	 * <p>
	 * ※結果がnullの場合、ブランクを返します。
	 * </p>
	 *
	 * @param obj toStringしたいオブジェクト
	 * @return toStringした結果。引数がnullの場合、ブランクを返します。
	 */
	public static String toStringOrBlank(final Object obj) {
		return Objects.toString(obj, BLANK);
	}
}
