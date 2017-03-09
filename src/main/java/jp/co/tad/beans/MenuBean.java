package jp.co.tad.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.apache.log4j.Logger;

import jp.co.tad.enums.ScreenId;

/***
 * メニューBean<br>
 * メニューに追加が発生した場合、ここに遷移先を追加すること
 */
@Named
@RequestScoped
public class MenuBean extends BaseBean {
	private static final Logger logger = Logger.getLogger(MenuBean.class);

	public String save() {
		logger.debug("/shainInsert.xhtml");
		return ScreenId.G001.getURL();
	}

	public String update() {
		logger.debug("/shainUpdate.xhtml");
		return ScreenId.G002.getURL();
	}

	public String delete() {
//		logger.debug("/contentDelete.xhtml");
//		return "/contentDelete.xhtml";
		return "";
	}

	public String downLoadCSV() {
//		logger.debug("/contentDownLoad.xhtml");
//		return "/contentDownLoad.xhtml";
		return "";
	}

	public String upload() {
//		logger.debug("/contentUpload.xhtml");
//		return "/contentUpload.xhtml";
		return "";
	}

}
