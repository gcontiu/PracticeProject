package dependency.model;

/**
 * Created with IntelliJ IDEA.
 * User: gelu
 * Date: 10/13/13
 * Time: 1:37 PM
 * To change this template use File | Settings | File Templates.
 */
public enum Elvis {
    INSTANCE;
    private int age;

    public int getAge() {
        return INSTANCE.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
