package basics.task2;

public class MegaBytesConverter {
    public static String printMegaBytesAndKiloBytes(int kiloBytes) {
        if (kiloBytes < 0)
            throw new IllegalArgumentException("Input must be non-negative");
        return String.format("%d KB = %d MB and %d KB", kiloBytes, kiloBytes / 1024, kiloBytes % 1024);
    }
}