package kr.co.redcore.conf;

public class ConfigPath {
	private static ConfigPath instance = new ConfigPath();

	private String PATH_CONFIG_DBP;
	private String PATH_CONFIG_ENV;

	public static ConfigPath getInstance() {
		return instance;
	}

	public String getPATH_CONFIG_DBP() {
		return PATH_CONFIG_DBP;
	}

	public void setPATH_CONFIG_DBP(String path_config_dbp) {
		PATH_CONFIG_DBP = path_config_dbp;
	}

	public String getPATH_CONFIG_ENV() {
		return PATH_CONFIG_ENV;
	}

	public void setPATH_CONFIG_ENV(String path_config_env) {
		PATH_CONFIG_ENV = path_config_env;
	}
}
