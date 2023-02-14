package jp.dcworks.engineersgate.egbbs.core;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.log4j.Log4j2;

/**
 * アプリケーション例外ハンドリングクラス。
 *
 * ※独自の例外をハンドリングしたい場合や、例外処理をカスタマイズしたい場合に実装する。<br>
 * 特に処理を必要としない場合は、 {@code /mng/src/main/resources/templates/error/}
 * フォルダにステータスコードに合わせてファイルを用意するだけで参照される。
 *
 * @author tomo-sato
 * @see <a href="https://b1san-blog.com/post/spring/spring-error/">【Spring Boot】エラーハンドリング（REST
 *			API）</a>
 * @see <a href="https://dkssksk.com/springbootxceptionhandler/">SpringBootで例外処理を行う方法【丁寧に解説します】</a>
 */
@Log4j2
@ControllerAdvice
public class AppControllerAdvice extends ResponseEntityExceptionHandler {

	/**
	 * 例外ハンドリング。
	 */
	@ExceptionHandler(Exception.class)
	public String handleOtherException(Exception exception) {
		log.error(exception, exception);
		return "error/500";
	}

	/**
	 * 例外ハンドリング。
	 * ※404 NotFound
	 */
	@ExceptionHandler(AppNotFoundException.class)
	public String handleOtherException(AppNotFoundException exception) {
		log.error(exception, exception);
		return "error/404";
	}
}
