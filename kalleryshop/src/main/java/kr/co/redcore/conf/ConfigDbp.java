package kr.co.redcore.conf;

import java.util.Enumeration;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.NamingException;
import org.apache.commons.configuration.*;
import org.apache.commons.configuration.tree.DefaultExpressionEngine;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.*;
import kr.co.redcore.conf.domain.DbProperty;

public class ConfigDbp {
	private static Log log = LogFactory.getLog(ConfigDbp.class);

	private static ConfigDbp instance = new ConfigDbp();
	private Properties datasourceProp = new Properties();

	private ConfigDbp() {
		try {
			XMLConfiguration config = new XMLConfiguration();
			config.setExpressionEngine(new DefaultExpressionEngine());
			config.load(ConfigPath.getInstance().getPATH_CONFIG_DBP());
			
			log.debug("====================================");
			for (int i = 0; i < config.getInt("count"); i++) {
				log.debug(config.getString("datasource(" + i + ")[@name]") + " >>>>>>>>>>>> ");
				log.debug("jndiName : " + config.getString("datasource(" + i + ").jndiName"));
				log.debug("driverClassName : " + config.getString("datasource(" + i + ").driverClassName"));
				log.debug("connectURI : " + config.getString("datasource(" + i + ").connectURI"));
				log.debug("schema : " + config.getString("datasource(" + i + ").schema"));
				log.debug("username : " + config.getString("datasource(" + i + ").username"));
				log.debug("password : " + config.getString("datasource(" + i + ").password"));
				log.debug("initialSize : " + config.getString("datasource(" + i + ").initialSize"));
				log.debug("maxActive : " + config.getString("datasource(" + i + ").maxActive"));
				log.debug("maxIdle : " + config.getString("datasource(" + i + ").maxIdle"));
				log.debug("validationQuery : " + config.getString("datasource(" + i + ").validationQuery"));
				log.debug("testOnBorrow : " + config.getString("datasource(" + i + ").testOnBorrow"));
				log.debug("removeAbandoned : " + config.getString("datasource(" + i + ").removeAbandoned"));
				log.debug("removeAbandonedTimeout : " + config.getString("datasource(" + i + ").removeAbandonedTimeout"));
				log.debug("logAbandoned : " + config.getString("datasource(" + i + ").logAbandoned"));

				DbProperty dbProperty = new DbProperty();
				dbProperty.setJndiName(config.getString("datasource(" + i + ").jndiName"));
				dbProperty.setDriverClassName(config.getString("datasource(" + i + ").driverClassName"));
				dbProperty.setConnectURI(config.getString("datasource(" + i + ").connectURI"));
				dbProperty.setSchema(config.getString("datasource(" + i + ").schema"));
				dbProperty.setUsername(config.getString("datasource(" + i + ").username"));
				dbProperty.setPassword(config.getString("datasource(" + i + ").password"));
				dbProperty.setInitialSize(config.getInt("datasource(" + i + ").initialSize"));
				dbProperty.setMaxActive(config.getInt("datasource(" + i + ").maxActive"));
				dbProperty.setMaxIdle(config.getInt("datasource(" + i + ").maxIdle"));
				dbProperty.setValidationQuery(config.getString("datasource(" + i + ").validationQuery"));
				dbProperty.setTestOnBorrow(config.getBoolean("datasource(" + i + ").testOnBorrow"));
				dbProperty.setRemoveAbandoned(config.getBoolean("datasource(" + i + ").removeAbandoned"));
				dbProperty.setRemoveAbandonedTimeout(config.getInt("datasource(" + i + ").removeAbandonedTimeout"));
				dbProperty.setLogAbandoned(config.getBoolean("datasource(" + i + ").logAbandoned"));
				datasourceProp.put(config.getString("datasource(" + i + ")[@name]"), dbProperty);
			}
			log.debug("====================================");
		} catch (ConfigurationException ex) {
			log.error(this, ex);
		}
	}

	public static ConfigDbp getInstance() {
		return instance;
	}

	public BasicDataSource getBasicDataSource(String key) {
		DbProperty dbProperty = (DbProperty) datasourceProp.get(key);

		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(dbProperty.getDriverClassName());
		basicDataSource.setUrl(dbProperty.getConnectURI());
		basicDataSource.setUsername(dbProperty.getUsername());
		basicDataSource.setPassword(dbProperty.getPassword());
		basicDataSource.setInitialSize(dbProperty.getInitialSize());
		basicDataSource.setMaxActive(dbProperty.getMaxActive());
		basicDataSource.setMaxIdle(dbProperty.getMaxIdle());
		basicDataSource.setValidationQuery(dbProperty.getValidationQuery());
		basicDataSource.setTestOnBorrow(dbProperty.isTestOnBorrow());
		basicDataSource.setRemoveAbandoned(dbProperty.isRemoveAbandoned());
		basicDataSource.setRemoveAbandonedTimeout(dbProperty.getRemoveAbandonedTimeout());
		basicDataSource.setLogAbandoned(dbProperty.isLogAbandoned());

		return basicDataSource;
	}

	public void bindingByAll(Context jdbc) throws NamingException {
		Enumeration enums = datasourceProp.keys();
		while (enums.hasMoreElements()) {
			String key = (String) enums.nextElement();
			DbProperty dbProperty = (DbProperty) datasourceProp.get(key);
			String jndiName = dbProperty.getJndiName().split("/")[1];			
			jdbc.bind(jndiName, getBasicDataSource(key));
			log.debug("DataSource binding..... >>>> " + key);
		}
	}

	public void bindingByKey(Context jdbc, String key) throws NamingException {
		DbProperty dbProperty = (DbProperty) datasourceProp.get(key);
		String jndiName = dbProperty.getJndiName().split("/")[1];
		jdbc.bind(jndiName, getBasicDataSource(key));
		log.debug("DataSource binding..... >>>> " + key + "_" + jndiName);
	}

	public Properties getDatasourceProp() {
		return datasourceProp;
	}

	public void setDatasourceProp(Properties datasourceProp) {
		this.datasourceProp = datasourceProp;
	}
}