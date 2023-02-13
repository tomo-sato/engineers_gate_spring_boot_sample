package jp.dcworks.engineersgate.egbbs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import jp.dcworks.engineersgate.egbbs.entity.Users;

/**
 * ユーザー関連リポジトリインターフェース。
 *
 * @author tomo-sato
 */
public interface UsersRepository extends PagingAndSortingRepository<Users, Long>, CrudRepository<Users, Long> {

	/**
	 * ユーザー検索を行う。
	 * ログインIDを指定し、ユーザーを検索する。
	 *
	 * @param loginId ログインID
	 * @return ユーザー情報を返す。
	 */
	Users findByLoginId(String loginId);

	/**
	 * ユーザー検索を行う。
	 * ログインID、パスワードを指定し、ユーザーを検索する。
	 *
	 * @param loginId ログインID
	 * @param password パスワード
	 * @return ユーザー情報を返す。
	 */
	Users findByLoginIdAndPassword(String loginId, String password);
}
