package jp.dcworks.engineersgate.egbbs.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * トピックコメントDTOクラス。
 *
 * @author tomo-sato
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RequestTopicComment extends DtoBase {

	/** ID */
	private Long id;

	/** 本文 */
	@NotBlank(message = "コメント本文を入力してください。")
	@Size(max = 2000, message = "コメント本文は最大2000文字です。")
	private String body;
}
