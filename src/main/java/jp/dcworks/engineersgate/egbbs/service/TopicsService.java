package jp.dcworks.engineersgate.egbbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.dcworks.engineersgate.egbbs.dto.RequestTopic;
import jp.dcworks.engineersgate.egbbs.entity.Topics;
import jp.dcworks.engineersgate.egbbs.repository.TopicsRepository;
import lombok.extern.log4j.Log4j2;

/**
 * トピック関連サービスクラス。
 *
 * @author tomo-sato
 */
@Log4j2
@Service
public class TopicsService {

	/** リポジトリインターフェース。 */
	@Autowired
	private TopicsRepository repository;

	/**
	 * トピック全件取得する。
	 *
	 * @return トピックを全件取得する。
	 */
	public List<Topics> findAllTopics() {
		return (List<Topics>) repository.findAll();
	}

	/**
	 * トピック検索を行う。
	 * トピックIDと、ログインIDを指定し、トピックを検索する。
	 *
	 * @param id トピックID
	 * @return トピック情報を返す。
	 */
	public Topics findTopics(Long id) {
		log.info("トピックを検索します。：id={}", id);

		Topics topics = repository.findById(id).orElse(null);
		log.info("ユーザー検索結果。：id={}, topics={}", id, topics);

		return topics;
	}

	/**
	 * トピック登録処理を行う。
	 *
	 * @param requestTopic トピックDTO
	 * @param usersId ユーザーID
	 */
	public Topics save(RequestTopic requestTopic, Long usersId) {
		Topics topics = new Topics();
		topics.setUsersId(usersId);
		topics.setTitle(requestTopic.getTitle());
		topics.setBody(requestTopic.getBody());
		return repository.save(topics);
	}
}
