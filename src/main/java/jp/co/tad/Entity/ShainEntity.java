package jp.co.tad.Entity;

import java.util.Date;

import jp.co.tad.beans.ShainInsertBean;
import jp.co.tad.beans.ShainUpdateViewBean;

/***
 * 社員テーブルEntity
 * @author watanabek
 */
public class ShainEntity extends BaseEntity {
	private String shainId;
	private String shainPw;
	private String shainSei;
	private String shainMei;
	private String shainKanaSei;
	private String shainKanaMei;
	private String shainGender;
	private Date shainBirth;
	private String shainAddress;
	private String shainSchool;


	public String getShainId() {
		return shainId;
	}
	public void setShainId(String shainId) {
		this.shainId = shainId;
	}
	public String getShainPw() {
		return shainPw;
	}
	public void setShainPw(String shainPw) {
		this.shainPw = shainPw;
	}
	public String getShainSei() {
		return shainSei;
	}
	public void setShainSei(String shainSei) {
		this.shainSei = shainSei;
	}
	public String getShainMei() {
		return shainMei;
	}
	public void setShainMei(String shainMei) {
		this.shainMei = shainMei;
	}
	public String getShainKanaSei() {
		return shainKanaSei;
	}
	public void setShainKanaSei(String shainKanaSei) {
		this.shainKanaSei = shainKanaSei;
	}
	public String getShainKanaMei() {
		return shainKanaMei;
	}
	public void setShainKanaMei(String shainKanaMei) {
		this.shainKanaMei = shainKanaMei;
	}
	public String getShainGender() {
		return shainGender;
	}
	public void setShainGender(String shainGender) {
		this.shainGender = shainGender;
	}
	public Date getShainBirth() {
		return shainBirth;
	}
	public void setShainBirth(Date shainBirth) {
		this.shainBirth = shainBirth;
	}
	public String getShainAddress() {
		return shainAddress;
	}
	public void setShainAddress(String shainAddress) {
		this.shainAddress = shainAddress;
	}
	public String getShainSchool() {
		return shainSchool;
	}
	public void setShainSchool(String shainSchool) {
		this.shainSchool = shainSchool;
	}

	/***
	 * 社員テーブル新規登録バッキングビーンを社員テーブルEntityに変換する
	 * @param ui 社員テーブル新規登録バッキングビーン
	 * @return 社員テーブルEntity
	 */
	public  static ShainEntity convertShain(ShainInsertBean ui) {
		ShainEntity u = new ShainEntity();
		u.setShainId(ui.getShainId());
		u.setShainPw(ui.getShainPw());
		u.setShainSei(ui.getShainMei_s());
		u.setShainMei(ui.getShainMei_m());
		u.setShainKanaSei(ui.getShainKana_s());
		u.setShainKanaMei(ui.getShainKana_m());
		u.setShainGender(ui.getShainGender());
		u.setShainBirth(ui.getShainBirth());
		u.setShainAddress(ui.getShainAddress());
		u.setShainSchool(ui.getShainSchool());
		u.setCreateNo(ui.getSessionInfo().getLoginShainNo());
		u.setUpdateNo(ui.getSessionInfo().getLoginShainNo());
		return u;
	}

	/***
	 * 社員テーブル更新登録バッキングビーンを社員テーブルEntityに変換する
	 * @param ui 社員テーブル更新登録バッキングビーン
	 * @return 社員テーブルEntity
	 */
	public static ShainEntity convertShain(ShainUpdateViewBean ui) {
		ShainEntity u = new ShainEntity();
		u.setShainId(ui.getShainId());
		u.setShainPw(ui.getShainPw());
		u.setShainSei(ui.getShainMei_s());
		u.setShainMei(ui.getShainMei_m());
		u.setShainKanaSei(ui.getShainKana_s());
		u.setShainKanaMei(ui.getShainKana_m());
		u.setShainGender(ui.getShainGender());
		u.setShainBirth(ui.getShainBirth());
		u.setShainAddress(ui.getShainAddress());
		u.setShainSchool(ui.getShainSchool());
		u.setUpdateNo(ui.getSessionInfo().getLoginShainNo());
		return u;
	}

}
