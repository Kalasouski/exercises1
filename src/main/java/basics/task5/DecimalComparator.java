package basics.task5;

public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double x, double y) {
        String strX = String.valueOf(x);
        String strY = String.valueOf(y);
        int dotX = strX.indexOf('.'), dotY = strY.indexOf('.');
        if (dotX == -1 || dotY == -1)
            return x == y;
        if (dotX + 4 <= strX.length())
            strX = strX.substring(0, dotX + 4);
        if (dotY + 4 <= strY.length())
            strY = strY.substring(0, dotY + 4);
        return strX.equals(strY);
    }
}
