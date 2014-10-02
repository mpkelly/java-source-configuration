package config;

import java.io.File;
import java.lang.reflect.Method;

public class DefaultSystemConfiguration implements SystemConfiguration {

    protected void sanityCheck()  {
        for (Method method : getClass().getMethods()) {
            try {
                String name = method.getName();

                if ("main".equals(name)) continue;
                if (method.getDeclaringClass() == Object.class) continue;

                System.out.println( getClass().getSimpleName() + "#" + name);
                method.invoke(this);
            } catch (Exception e) {
                throw new Defect("Configuration failed sanity check", e);
            }
        }
    }

    @Override
    public int getPort() {
        return 7777;
    }

    @Override
    public File getLogDir() {
        return new File("default/log");
    }
}
