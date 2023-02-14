package jp.dcworks.engineersgate.egbbs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import jp.dcworks.engineersgate.egbbs.entity.Comments;

/**
 * コメント関連リポジトリインターフェース。
 *
 * @author tomo-sato
 */
public interface CommentsRepository extends PagingAndSortingRepository<Comments, Long>, CrudRepository<Comments, Long> {
}
