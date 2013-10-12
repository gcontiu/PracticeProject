package imutability;

public class Tier {

    private String name;

    private int season;

    public Tier(String name, int season) {
        this.name = name;
        this.season = season;
    }

    public String getName() {
        return name;
    }

    public int getSeason() {
        return season;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "Tier{" +
                "name='" + name + '\'' +
                ", season=" + season +
                '}';
    }
}
