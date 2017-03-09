package jp.co.tad.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;
import org.mybatis.cdi.Mapper;
import org.mybatis.cdi.Transactional;
import org.primefaces.context.RequestContext;

import jp.co.tad.Entity.ShainEntity;
import jp.co.tad.Utils.PropertyUtil;
import jp.co.tad.enums.MsgId;
import jp.co.tad.mybatis.mapper.SqlShainMapper;

/***
 * 社員テーブル更新登録BackingBean
 * @author watanabek
 */
@Named
@RequestScoped
public class ShainUpdateViewBean extends BaseBean{
	private static final Logger logger = LogManager.getLogger(ShainUpdateViewBean.class);

	@Inject @Mapper
	private SqlShainMapper mapper;

	@Inject
	private SessionInfo sessionInfo;

	@NotEmpty(message="社員番号は必須です。")
	private String shainId;

	private String shainPw;

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

	public Date getShainBirth() {
		return shainBirth;
	}
	public void setShainBirth(Date shainBirth) {
		this.shainBirth = shainBirth;
	}

	public String getShainPw() {
		return shainPw;
	}
	public void setShainPw(String shainPw) {
		this.shainPw = shainPw;
	}

	public SessionInfo getSessionInfo() {
		return sessionInfo;
	}

	/***
	 * 初期処理
	 */
	@PostConstruct
    public void init() {
		logger.debug("ShainUpdateViewBean-PostConstruct");

		if (FacesContext.getCurrentInstance().isPostback() == true) {
			logger.debug("ShainUpdateViewBean-PostBack");
			return;
		}

		 Map<String,String> params =
				 FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		  String shainId = params.get("shainId");

		ShainEntity entity = mapper.getShainByKey(shainId);

		// 値設定
		setForm(entity);
	}

	/***
	 * 値設定
	 * @param entity 社員テーブルEntity
	 */
	private void setForm(ShainEntity entity) {
		this.shainId = entity.getShainId();
		this.shainPw = entity.getShainPw();
		this.shainMei_s = entity.getShainSei();
		this.shainMei_m = entity.getShainMei();
		this.shainKana_s = entity.getShainKanaSei();
		this.shainKana_m = entity.getShainKanaMei();
		this.shainGender = entity.getShainGender();
		this.shainBirth = entity.getShainBirth();
		this.shainAddress = entity.getShainAddress();
		this.shainSchool = entity.getShainSchool();
	}

	/***
	 * 「登録」押下時の実行メソッド
	 */
	@Transactional
	public void update() {
		logger.info("ShainUpdateViewBean-登録ボタン押下");

		// 登録内容を新規登録用のパラメータオブジェクトにつめる
		ShainEntity u = ShainEntity.convertShain(this);
		int ret = mapper.updateShain(u);

		if (ret != 1) {
			String msg = String.format(PropertyUtil.getProperty(MsgId.MSG004));
			facesWarnMsg(msg);
			return;
		}

		// 画面を閉じる
		RequestContext.getCurrentInstance().closeDialog(this.getShainId());
	}
}
