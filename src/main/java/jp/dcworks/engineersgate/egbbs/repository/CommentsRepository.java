package jp.dcworks.engineersgate.egbbs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import jp.dcworks.engineersgate.egbbs.entity.Comments;

/**
 * コメント関連リポジトリインターフェース。
 *
 * @author tomo-sato
 */
public interface CommentsRepository extends PagingAndSortingRepository<Comments, Long>, CrudRepository<Comments, Long> {

	/**
	 * コメントの削除処理を行う。
	 * ※物理削除（データが完全に消える。）
	 *
	 * @param id コメントID
	 * @param usersId ユーザーID
	 * @param topicsId トピックID
	 */
	@Transactional
	void deleteByIdAndUsersIdAndTopicsId(Long id, Long usersId, Long topicsId);
}
