package memedlyaev.ekrem.mbeanTest;

import java.net.MalformedURLException;

public interface MyMBean {

    void submit(String name, String classpath, String mainClass, int period)
            throws MalformedURLException, ClassNotFoundException;
    void cancel(String name);
    void StartProfiling(String name);
    void StopProfiling(String name);
}
