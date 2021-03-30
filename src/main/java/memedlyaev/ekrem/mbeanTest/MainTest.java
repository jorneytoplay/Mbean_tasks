package memedlyaev.ekrem.mbeanTest;

import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

public class MainTest {
    public static void main(String[] args) throws NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException, MalformedObjectNameException {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("memedlyaev.ekrem.mbeanTest:type=My");
        My mbean = new My(args);
        mbs.registerMBean(mbean, name);
        Class personClass = plus.class;

//Get the methods
        Method[] methods = personClass.getDeclaredMethods();

//Loop through the methods and print out their names
        for (Method method : methods)
        {
            System.out.println(method.getName());
        }

        System.out.println("Waiting forever...");
        Thread.sleep(Long.MAX_VALUE);
    }
}