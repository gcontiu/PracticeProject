package plugindp.plugin;

/**
 * Created with IntelliJ IDEA.
 * User: gelu
 * Date: 9/14/13
 * Time: 11:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class EmagAppearance implements Appearance {
    @Override
    public String getFont() {
        return "emagFont";
    }

    @Override
    public String getEmail() {
        return "mail@emag.ro";
    }

    @Override
    public String getImage() {
        return "emag.jpg";
    }
}
