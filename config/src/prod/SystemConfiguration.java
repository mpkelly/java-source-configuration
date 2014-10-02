package prod;

import config.DefaultSystemConfiguration;

public class SystemConfiguration extends DefaultSystemConfiguration {

    @Override
    public int getPort() {
        return 9999;
    }
}
