package pap.lorinc.algos;

import java.util.function.Function;

import static java.lang.System.out;

/**
 * http://javaconceptoftheday.com/how-to-create-pyramid-of-numbers-in-java
 */
public class Pyramid {
    private static final int COUNT = 9;

    public static void main(String... args) {
        drawConstantPyramid();                       // pattern 1
        drawCountingPyramid();                       // pattern 2
        drawStarredPyramid();                        // pattern 3
        drawBackAndForthCountingPyramid();           // pattern 4
        drawUpsideDownBackAndForthCountingPyramid(); // pattern 5
        drawReverseBackAndForthCountingPyramid();    // pattern 6
    }

    private static void drawConstantPyramid() {
        for (int i = 0; i < COUNT; i++) {
            out.print(repeat(" ", COUNT - i));
            out.print(repeat((i + 1) + " ", i));
            out.println();
        }
    }

    private static void drawStarredPyramid() {
        for (int i = 0; i < COUNT; i++) {
            out.print(repeat(" ", COUNT - i));
            out.print(repeat("* ", i));
            out.println();
        }
    }

    private static void drawCountingPyramid() {
        for (int i = 0; i < COUNT; i++) {
            out.print(repeat(" ", COUNT - i));
            for (int j = 0; j <= i; j++)
                out.print((j + 1) + " ");
            out.println();
        }
    }

    private static void drawBackAndForthCountingPyramid() {
        for (int i = 0; i < COUNT; i++) {
            out.print(repeat("  ", COUNT - i));
            out.print(backAndForthIteration(j -> (j + 1) + " ", i));
            out.println();
        }
    }

    private static void drawUpsideDownBackAndForthCountingPyramid() {
        for (int i = COUNT - 1; i >= 0; i--) {
            out.print(repeat("  ", COUNT - i));
            out.print(backAndForthIteration(j -> (j + 1) + " ", i));
            out.println();
        }
    }

    private static void drawReverseBackAndForthCountingPyramid() {
        for (int i = 0; i < COUNT; i++) {
            int complement = COUNT - i;
            out.print(repeat("  ", complement));
            out.print(backAndForthIteration(j -> (complement + j) + " ", i));
            out.println();
        }
    }

    private static String backAndForthIteration(Function<Integer, String> repetition, int count) {
        StringBuilder result = new StringBuilder();

        int i = 0;
        for (; i < count; i++)
            result.append(repetition.apply(i));
        for (; i >= 0; i--)
            result.append(repetition.apply(i));

        return result.toString();
    }

    private static String repeat(String repetition, int count) {
        StringBuilder result = new StringBuilder(repetition.length() * count);

        for (int j = 0; j <= count; j++)
            result.append(repetition);

        return result.toString();
    }
}
