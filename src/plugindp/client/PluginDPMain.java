package plugindp.client;

import plugindp.factory.PluginFactory;
import plugindp.plugin.Appearance;

/**
 * Created with IntelliJ IDEA.
 * User: gelu
 * Date: 9/14/13
 * Time: 11:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class PluginDPMain {

    public static void main(String[] args) {
        Appearance appearance = PluginFactory.getInstance("skype");

        System.out.println("Email: " + appearance.getEmail());
    }
}
