package jp.co.tad.Utils;

import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import jp.co.tad.enums.MsgId;

/***
 * メッセージプロパティファイル管理ユーティリティ
 */
public class PropertyUtil {
	private static final Logger logger = Logger.getLogger(PropertyUtil.class);

	private static Properties conf;

	/*** メッセージプロパティファイル **/
	private static final String MSG_FILE = "/messages.properties";

	/*** リソースバンドルの名称 **/
	private static final String RS_MSG = "msgConfig";


	static {
		logger.debug("★★★★★PropertyUtil★★★★★");
		conf = new Properties();
		try {
			conf.load(PropertyUtil.class.getResourceAsStream(MSG_FILE));
		} catch (IOException e) {
			// TODO どうしようかな
			logger.fatal(e);
		}
	}

	/***
	 * メッセージ取得
	 * @param key
	 * @return メッセージ
	 * @deprecated 引数がenum版を使ってください。
	 */
	public static String getProperty(String key) {
		return conf.getProperty(key);
	}

	/***
	 * メッセージ取得
	 * リソースバンドル版
	 * @param id
	 * @return メッセージ
	 */
	public static String getProperty(MsgId id) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ResourceBundle bundle = facesContext.getApplication().getResourceBundle(facesContext, RS_MSG);
		return bundle.getString(id.getValue());
	}
}
