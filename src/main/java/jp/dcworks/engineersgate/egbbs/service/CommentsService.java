package jp.dcworks.engineersgate.egbbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.dcworks.engineersgate.egbbs.dto.RequestTopicComment;
import jp.dcworks.engineersgate.egbbs.entity.Comments;
import jp.dcworks.engineersgate.egbbs.repository.CommentsRepository;
import lombok.extern.log4j.Log4j2;

/**
 * コメント関連サービスクラス。
 *
 * @author tomo-sato
 */
@Log4j2
@Service
public class CommentsService {

	/** リポジトリインターフェース。 */
	@Autowired
	private CommentsRepository repository;

	/**
	 * コメント登録処理を行う。
	 *
	 * @param requestTopicComment コメントDTO
	 * @param usersId ユーザーID
	 * @param topicsId トピックID
	 */
	public Comments save(RequestTopicComment requestTopicComment, Long usersId, Long topicsId) {
		Comments topics = new Comments();
		topics.setUsersId(usersId);
		topics.setTopicsId(topicsId);
		topics.setBody(requestTopicComment.getBody());
		return repository.save(topics);
	}
}
