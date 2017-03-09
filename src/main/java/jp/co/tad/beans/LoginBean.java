package jp.co.tad.beans;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;
import org.mybatis.cdi.Mapper;

import jp.co.tad.Utils.PropertyUtil;
import jp.co.tad.enums.MsgId;
import jp.co.tad.enums.ScreenId;
import jp.co.tad.mybatis.mapper.SqlShainMapper;

/***
 * ログインバッキングビーン
 * @author watanabek
 */
@Named
@RequestScoped
public class LoginBean extends BaseBean {
	private static final Logger logger = Logger.getLogger(LoginBean.class);

	private static final String ADMIN = "admin";

	@Inject @Mapper
	private SqlShainMapper mapper;

	@Inject
	private SessionInfo sessionInfo;

	@NotEmpty(message="ユーザーIDは必須です。")
	private String shainId;
	@NotEmpty(message="パスワードは必須です。")
	private String pw;

	public String getShainId() {
		return shainId;
	}
	public void setShainId(String shainId) {
		this.shainId = shainId;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}

	/***
	 * ログイン処理
	 * @return 遷移先
	 */
	public String login() {
		logger.debug("ログインボタン押下");

		if (isLogin() == true) {
			// ログインユーザー保持
			sessionInfo.setLoginShainNo(this.shainId);

			return ScreenId.G001.getURL();
		} else {
			facesErrorMsg(PropertyUtil.getProperty(MsgId.MSG001));
			return null;
		}
	}

	/***
	 * ログイン確認
	 * @return
	 */
	private boolean isLogin() {
		// TODO
		if (ADMIN.equals(this.shainId) == true) {
			logger.debug("管理者");
			return true;
		}

		// ユーザー情報取得パラメータ設定
		Map<String, Object> param = new HashMap<>();
		param.put("shainId", this.shainId);
		param.put("shainPw", this.pw);
		// ユーザー情報取得実行
		int ret = mapper.existShain(param);

		if(ret == 1){
			// ログイン成功
			return true;
		}

		return false;
	}
}
