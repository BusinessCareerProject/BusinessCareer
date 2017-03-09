package jp.co.tad.Entity;

import java.util.Date;

/***
 * Entityの基底クラス
 */
public abstract class BaseEntity {

	private Date updateDatetime;

	private String updateNo;

	private Date createDatetime;

	private String createNo;


	public String getUpdateNo() {
		return updateNo;
	}

	public void setUpdateNo(String updateNo) {
		this.updateNo = updateNo;
	}

	public Date getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}

	public String getCreateNo() {
		return createNo;
	}

	public void setCreateNo(String createNo) {
		this.createNo = createNo;
	}

	public Date getUpdateDatetime() {
		return updateDatetime;
	}

	public void setUpdateDatetime(Date updateDatetime) {
		this.updateDatetime = updateDatetime;
	}




}
