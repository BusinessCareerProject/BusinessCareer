package jp.co.tad.beans;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.cdi.Mapper;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import jp.co.tad.Entity.ShainEntity;
import jp.co.tad.mybatis.mapper.SqlShainMapper;

/***
 * 社員テーブル更新登録BackingBean
 * @author watanabek
 */
@Named
@RequestScoped
public class ShainUpdateBean extends BaseBean{
	private static final Logger logger = LogManager.getLogger(ShainUpdateBean.class);

	@Inject @Mapper
	private SqlShainMapper mapper;

	private List<ShainEntity> shainList;

	public List<ShainEntity> getShainList() {
		return shainList;
	}

	public void setShainList(List<ShainEntity> shainList) {
		this.shainList = shainList;
	}

	/***
	 * 初期処理
	 */
	@PostConstruct
    public void init() {
		logger.debug("ShainUpdateBean-PostConstruct");

//		if (FacesContext.getCurrentInstance().isPostback() == true) {
//			logger.debug("ShainUpdateBean-postback");
//			return;
//		}

		List<ShainEntity> list = mapper.selectAll();
		setShainList(list);
	}

	/***
	 * 社員更新画面OPEN
	 * @param shainId
	 */
	 public void chooseShain(String shainId) {
		 logger.debug("shainUpdateBean-chooseShain");
		 logger.debug("shainId:[" + shainId + "]");

		 // ポストバックでない場合、以降の処理スキップ
		 if (FacesContext.getCurrentInstance().isPostback() == false) {
			 logger.debug("shainUpdateBean-postbackじゃない");
			 return;
		 }

		 // Dialogに引き渡すパラメータ作成
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("resizable", false);
		options.put("modal", true);
		Map<String, List<String>> params = new HashMap<>();
		params.put("shainId", Collections.singletonList(shainId));
		// 社員更新画面をDialogで開く
		RequestContext.getCurrentInstance().openDialog("shainUpdateView", options, params);
	 }

	 /***
	  * 社員更新Dialogが閉じたときに動く
	  * @param event
	  */
	public void handleReturn(SelectEvent event) {
		logger.debug("shainUpdateBean-handleReturn");

		// Dialogから戻り値もとれる
		String shinId = (String) event.getObject();
		logger.debug("社員ID:" + shinId);

		// 再検索
		List<ShainEntity> list = mapper.selectAll();
		setShainList(list);
	}
}
