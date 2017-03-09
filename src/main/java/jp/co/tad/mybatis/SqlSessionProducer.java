package jp.co.tad.mybatis;

import java.io.IOException;
import java.io.InputStream;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

/***
 * MyBatisのSqlSessionFactoryを生成する
 * @author watanabek
 */
@Singleton
@Startup
public class SqlSessionProducer {
    private static final Logger logger = Logger.getLogger(SqlSessionProducer.class);

    /** myBatis config */
    private static final String BATIS_CNF = "/mybatis-config.xml";

	@Produces
	@ApplicationScoped
	public SqlSessionFactory createSqlSessionFactory() {
		SqlSessionFactory ssf = null;
		try (InputStream reader = Resources.getResourceAsStream(BATIS_CNF)) {
			ssf = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			logger.fatal(e);
		}

		return ssf;
	}
}
