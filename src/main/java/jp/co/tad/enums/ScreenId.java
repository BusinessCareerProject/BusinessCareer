package jp.co.tad.enums;

/***
 * 画面ID列挙型
 */
public enum ScreenId implements BaseEnum {

	/** 社員新規登録 */
	G001("shainInsert"),
	/** 社員更新登録 */
	G002("shainUpdate");

	private final String value;

	private ScreenId(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public String getURL() {
		return "/" + this.value + ".xhtm?faces-redirect=true";
	}

}