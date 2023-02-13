package jp.dcworks.engineersgate.egbbs.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * トピックDTOクラス。
 *
 * @author tomo-sato
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RequestTopic extends DtoBase {

	/** ID */
	private Long id;

	/** タイトル */
	@NotBlank(message = "タイトルを入力してください。")
	@Size(max = 128, message = "タイトルは最大128文字です。")
	private String title;

	/** 本文 */
	@NotBlank(message = "本文を入力してください。")
	@Size(max = 2000, message = "本文は最大2000文字です。")
	private String body;
}
