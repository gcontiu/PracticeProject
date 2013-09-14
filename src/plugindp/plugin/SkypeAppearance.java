package plugindp.plugin;

/**
 * Created with IntelliJ IDEA.
 * User: gelu
 * Date: 9/14/13
 * Time: 11:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class SkypeAppearance implements Appearance {
    @Override
    public String getFont() {
        return "skype-font";
    }

    @Override
    public String getEmail() {
        return "office@skype.com";
    }

    @Override
    public String getImage() {
        return "skype.jpg";
    }
}
