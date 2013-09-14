package plugindp.factory;

import plugindp.plugin.Appearance;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: gelu
 * Date: 9/14/13
 * Time: 11:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class PluginFactory {

    private static Appearance instance;

    private static Properties properties = new Properties();

    private PluginFactory() {
    }

    public static Appearance getInstance(String runningCustomerName) {
        if (instance != null) {
            return instance;
        }

        loadProperties();

        Object className = properties.get(runningCustomerName);
        if (className != null) {
            System.out.println("Found class name: " + className + "in properties file for " + runningCustomerName);
        } else {
            throw new RuntimeException("Could not load class name from properties file for " + runningCustomerName);
        }


        Object appearance = null;
        try {

            appearance =  Class.forName(className.toString()).newInstance();
            System.out.println("Loaded class: " + appearance.getClass().getName());

        } catch (ClassNotFoundException e) {
            System.out.println("Class " + className + " was not found.");
        } catch (InstantiationException e) {
            System.out.println("Class " + className + " Could not be instantiated.");
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            System.out.println("Illegal access to class " + className + "");
            throw new RuntimeException(e);
        }

        return (Appearance) appearance;
    }

    private static void loadProperties() {
        InputStream is = null;
        try {
            is = PluginFactory.class.getClass().getResourceAsStream("/plugindp/config/plugins.properties");
            properties.load(is);

        } catch (IOException ioex) {
            System.out.println("IOEx on loading input stream to properties object.");
            throw new RuntimeException(ioex);
        } finally {
            closeInputStream(is);
        }
    }



    private static void closeInputStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
