package memedlyaev.ekrem.mbeanTest;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class My implements MyMBean {
private final String[] args;
    ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
    private ScheduledFuture<?> future;
    private final ArrayList<MemoryTask> task = new ArrayList<>();

    public My(String[] args) {
        this.args = args;
    }

    @Override
    public void submit(String name, String classpath, String mainClass, int period) {
        var Da = new tasks(name,classpath, mainClass, args);
           future = service.scheduleAtFixedRate(Da,0, period, TimeUnit.SECONDS);
        task.add(new MemoryTask(name, future, "running", Da, classpath, mainClass, args,false, period));

    }

    @Override
    public void cancel(String name) {
         }

    @Override
    public void StartProfiling(String name) {

            for (MemoryTask task1 : task) {
                if (task1.getName().equals(name)){
                    if (!task1.isProfiling()){
                        task1.getScheduledFuture().cancel(true);
                        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
                        var profiling = new tasks2(name,task1.getClasspath(),task1.getMainclass(),task1.getArgs());
                        ScheduledFuture<?> sf = service.scheduleAtFixedRate(profiling,0,task1.getPeriod(), TimeUnit.SECONDS);
                        task1.setProfiling();
                        task1.setScheduledFuture(sf);
                    }
                }
            }
    }

    @Override
    public void StopProfiling(String name) {

    }

}

