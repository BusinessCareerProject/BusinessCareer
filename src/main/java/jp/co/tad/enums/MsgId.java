package jp.co.tad.enums;

/***
 * メッセージID列挙型
 */
public enum MsgId implements BaseEnum {
	MSG001("MSG001"),
	MSG002("MSG002"),
	MSG003("MSG003"),
	MSG004("MSG004");

	private final String value;

	private MsgId(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

}