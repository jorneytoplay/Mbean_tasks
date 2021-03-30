package memedlyaev.ekrem.mbeanTest;

import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;

public class tasks2 implements Runnable{
    private final String mainClass;
    private final String classpath;
    private final String[] args;
    private final String name;
    private ClassLoader loader;



    public static Thread.State valueOf(String name) {
        return null;
    }

    public tasks2(String name,String classpath, String mainClass, String[] args) {
        this.mainClass = mainClass;
        this.classpath = classpath; //ссылка на класс
        this.args = args;
        this.name = name;
    }

    private ClassLoader newLoader(String dir) throws Exception {
        var path = Path.of(dir);
        if (!Files.isDirectory(path))
            throw new RuntimeException();
        return new URLClassLoader(new URL[] { path.toUri().toURL() }); //берём класс
    }

    @Override
    public void run() {
        try {
            System.out.println("Начал работу:" +  Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getState());
            loader = newLoader(classpath);
            var clazz = loader.loadClass(mainClass);
            clazz.getMethod(name).invoke(null); //берём метод
        }
        catch (Exception e) {
            e.printStackTrace();
        } }
}
