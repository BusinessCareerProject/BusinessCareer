package jp.co.tad.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/***
 * Beanの基底クラス
 */
public class BaseBean implements Serializable {


	/***
	 * ワーニングメッセージを作成しキューに入れる
	 * @param s エラーメッセージ
	 */
	public void facesWarnMsg(String s) {
		facesMessage(FacesMessage.SEVERITY_WARN, s);
	}

	/***
	 * エラーメッセージを作成しキューに入れる
	 * @param s エラーメッセージ
	 */
	public void facesErrorMsg(String s) {
		facesMessage(FacesMessage.SEVERITY_ERROR, s);
	}

	/***
	 * 致命的エラーメッセージを作成しキューに入れる
	 * @param s エラーメッセージ
	 */
	public void facesFatelMsg(String s) {
		facesMessage(FacesMessage.SEVERITY_FATAL, s);
	}

	/***
	 * メッセージを作成しキューに入れる
	 * @param severity エラーレベル
	 * @param s エラーメッセージ
	 */
	private void facesMessage(FacesMessage.Severity severity, String s) {
//		FacesMessage.SEVERITY_FATAL		致命的エラー(4)
//		FacesMessage.SEVERITY_ERROR		エラー(3)
//		FacesMessage.SEVERITY_WARN		警告(2)
//		FacesMessage.SEVERITY_INFO		情報(1)

		FacesMessage msg = new FacesMessage(s);
		msg.setSeverity(severity);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
