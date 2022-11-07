package readConfig;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig(){
        return ConfigFactory.load("application.conf");
    }
    String BASE = readConfig().getString("baseUri");
    String TOKEN = readConfig().getString("token");


}
