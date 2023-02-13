package jp.dcworks.engineersgate.egbbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.dcworks.engineersgate.egbbs.dto.RequestAccount;
import jp.dcworks.engineersgate.egbbs.entity.Users;
import jp.dcworks.engineersgate.egbbs.repository.UsersRepository;
import lombok.extern.log4j.Log4j2;

/**
 * ユーザー関連サービスクラス.
 *
 * @author tomo-sato
 */
@Log4j2
@Service
public class UsersService {

	/** リポジトリインターフェース. */
	@Autowired
	private UsersRepository repository;

	/**
	 * ユーザー検索を行う。
	 * ログインIDを指定し、ユーザーを検索する。
	 *
	 * @param loginId ログインID
	 * @return ユーザー情報を返す。
	 */
	public Users findUsers(String loginId) {
		log.info("ユーザーを検索します。：loginId={}", loginId);

		Users users = repository.findByLoginId(loginId);
		log.info("ユーザー検索結果。：loginId={}, users={}", loginId, users);

		return users;
	}

	/**
	 * ユーザー登録処理を行う。
	 *
	 * @param requestAccount ユーザーDTO
	 */
	public void save(RequestAccount requestAccount) {
		Users users = new Users();
		users.setLoginId(requestAccount.getLoginId());
		users.setPassword(requestAccount.getPassword());
		users.setName(requestAccount.getName());
		repository.save(users);
	}
}
