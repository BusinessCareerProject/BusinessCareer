package jp.co.tad.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * ログイン情報保持
 * @author watanabek
 */
@Named
@SessionScoped
public class SessionInfo implements Serializable {

	private String loginShainNo;

	public String getLoginShainNo() {
		return loginShainNo;
	}

	public void setLoginShainNo(String loginShainNo) {
		this.loginShainNo = loginShainNo;
	}

	public boolean isLogin() {
		boolean result = false;
		if(this.loginShainNo != null) {
			result = true;
		}
		return result;
	}

}
