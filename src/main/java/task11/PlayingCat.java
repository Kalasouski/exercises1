package task11;

public class PlayingCat {
    public static boolean isCatPlaying(boolean summer, int temperature) {
        return temperature >= 25 && (summer && temperature <= 45) || (!summer && temperature <= 35);
    }
}
