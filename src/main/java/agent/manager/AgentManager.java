package agent.manager;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import java.lang.instrument.Instrumentation;

public class AgentManager {
    public static void premain(String args, Instrumentation instrumentation) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        instrumentation.addTransformer(new MainTransformer());
    };

}
