package jp.co.tad.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;
import org.mybatis.cdi.Mapper;
import org.mybatis.cdi.Transactional;

import jp.co.tad.Entity.ShainEntity;
import jp.co.tad.Utils.PropertyUtil;
import jp.co.tad.enums.MsgId;
import jp.co.tad.mybatis.mapper.SqlShainMapper;
/***
 * 社員テーブル新規登録
 * @author watanabek
 */
@Named
@RequestScoped
public class ShainInsertBean extends BaseBean{
	private static final Logger logger = Logger.getLogger(ShainInsertBean.class);

	@Inject @Mapper
	private SqlShainMapper mapper;

	@Inject
	private SessionInfo sessionInfo;

	@NotEmpty(message="社員番号は必須です。")
	private String shainId;

	@NotEmpty(message="パスワードは必須です。")
	private String shainPw;

	//パスワード確認用
	private String shainPk;

	@NotEmpty(message="社員名(性)は必須です。")
	private String shainMei_s;

	@NotEmpty(message="社員名(名)は必須です。")
	private String shainMei_m;

	@NotEmpty(message="フリガナ(性)は必須です。")
	private String shainKana_s;

	@NotEmpty(message="フリガナ(名)は必須です。")
	private String shainKana_m;

	private String shainGender;

	@NotNull(message="生年月日は必須です。")
	private Date shainBirth;

	@NotEmpty(message="現住所(最寄駅)は必須です。")
	private String shainAddress;

	private String shainSchool;

	private static List<SelectItem> shainSchoolSelectItems = new ArrayList<SelectItem>();

	public List<SelectItem> getShainSchoolSelectItems() {
		return shainSchoolSelectItems;
	}

	public String getShainMei_s() {
		return shainMei_s;
	}
	public void setShainMei_s(String shainMei_s) {
		this.shainMei_s = shainMei_s;
	}
	public String getShainMei_m() {
		return shainMei_m;
	}
	public void setShainMei_m(String shainMei_m) {
		this.shainMei_m = shainMei_m;
	}
	public String getShainKana_s() {
		return shainKana_s;
	}
	public void setShainKana_s(String shainKana_s) {
		this.shainKana_s = shainKana_s;
	}
	public String getShainKana_m() {
		return shainKana_m;
	}
	public void setShainKana_m(String shainKana_m) {
		this.shainKana_m = shainKana_m;
	}
	public String getShainGender() {
		return shainGender;
	}
	public void setShainGender(String shainGender) {
		this.shainGender = shainGender;
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

	public String getShainPk() {
		return shainPk;
	}
	public void setShainPk(String shainPk) {
		this.shainPk = shainPk;
	}
	public Date getShainBirth() {
		return shainBirth;
	}
	public void setShainBirth(Date shainBirth) {
		this.shainBirth = shainBirth;
	}

	public SessionInfo getSessionInfo() {
		return sessionInfo;
	}

	/***
	 * 初期処理
	 */
	@PostConstruct
    public void init() {
		logger.debug("ShainInsertBean-PostConstruct");

		 // ポストバックでない場合
		if (FacesContext.getCurrentInstance().isPostback() == false) {
			// 性別の初期値設定
			this.shainGender = "0";
		}

	}

	/***
	 * 「登録」押下時の実行メソッド
	 */
	@Transactional
	public void insert() {
		logger.info("ShainInsertBean-登録ボタン押下");

		// チェック
		if (this.isRelationCheck() == true) {
			logger.debug("エラー!!!");
			return;
		}

		// 登録内容を新規登録用のパラメータオブジェクトにつめる
		ShainEntity u = ShainEntity.convertShain(this);
		// 登録処理実行
		mapper.insertShain(u);

		// 画面クリア
		this.clear();
	}

	/***
	 * 画面クリア
	 */
	private void clear() {
		shainId = null;
		shainPw = null;
		shainPk = null;
		shainMei_s = null;
		shainMei_m = null;
		shainKana_s = null;
		shainKana_m = null;
		shainGender = "0";
		shainBirth = null;
		shainAddress = null;
		shainSchool = "0";
	}

	/***
	 * 相関チェック
	 * @return true:エラーあり／false:エラーなし
	 */
	private boolean isRelationCheck() {

		boolean ret = false;

		ret = this.isPass();

		if (this.isDuplication() == true) {
			ret = true;
		}

		return ret;
	}

	/***
	 * パスワードとパスワード（確認用）が同じかどうか確認
	 * @return true:重複あり／false:重複無し
	 */
	private boolean isPass() {
		logger.debug("パスワード確認");

		if (this.shainPw.equals(this.shainPk) == false) {
			String msg = String.format(PropertyUtil.getProperty(MsgId.MSG003));
			facesWarnMsg(msg);
			return true;
		}

		return false;
	}

	/***
	 * 社員番号重複確認
	 * @return true:重複あり／false:重複無し
	 */
	private boolean isDuplication() {
		logger.debug("社員番号重複確認");

		ShainEntity entity = mapper.getShainByKey(this.getShainId());

		if (entity != null) {
			String msg = String.format(PropertyUtil.getProperty(MsgId.MSG002));
			facesWarnMsg(msg);
			return true;
		}

		return false;
	}

}
