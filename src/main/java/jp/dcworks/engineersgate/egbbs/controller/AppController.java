package jp.dcworks.engineersgate.egbbs.controller;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.servlet.http.HttpSession;
import jp.dcworks.engineersgate.egbbs.core.AppConst;
import jp.dcworks.engineersgate.egbbs.entity.Users;
import lombok.extern.log4j.Log4j2;

/**
 * コントローラ基底クラス。
 *
 * @author tomo-sato
 */
@Log4j2
public class AppController {

	/** セッション情報。 */
	@Autowired
	private HttpSession session;

	/**
	 * セッションに格納しているユーザーIDを取得する。
	 *
	 * @return ユーザーID（※セッション情報が取得出来ない場合は、nullを返す。）
	 */
	protected Long getUsersId() {
		// ユーザー情報の取得。
		Users users = (Users) session.getAttribute(AppConst.SESSION_KEY_LOGIN_INFO);

		if (users == null) {
			log.info("セッションにユーザー情報は保存されていません。");
			return null;
		}

		return users.getId();
	}
}
