package jp.dcworks.engineersgate.egbbs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * コメントEntityクラス。
 *
 * @author tomo-sato
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "comments")
public class Comments extends EntityBase {

	/** ID */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** ユーザーID */
	@Column(name = "users_id", nullable = false)
	private Long usersId;

	/** トピックID */
	@Column(name = "topics_id", nullable = false)
	private Long topicsId;

	/** コメント本文 */
	@Column(name = "body", nullable = false)
	private String body;
}
