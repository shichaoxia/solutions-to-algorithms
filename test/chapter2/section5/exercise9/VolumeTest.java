package chapter2.section5.exercise9;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class VolumeTest {

    @Test
    void volume() {
        String input = """
                 3-Jan-00  931800000
                 4-Jan-00 1009000000
                 5-Jan-00 1085500032
                23-Jun-42     210000
                15-Jul-02 2574799872
                15-Jul-03 2574799872
                15-Jul-04 2574799872
                17-Jul-02 2566500096
                19-Jul-02 2654099968
                23-Jul-02 2441019904
                24-Jul-02 2775559936
                24-Jul-40     200000
                10-Aug-42     210000
                19-Aug-40     130000
                26-Aug-40     160000
                 1-Oct-28    3500000
                 2-Oct-28    3850000
                 3-Oct-28    4060000
                 4-Oct-28    4330000
                 5-Oct-28    4360000
                30-Dec-99  554680000
                31-Dec-99  374049984""";

        String[] lines = input.split("\\n");
        Volume[] volumes = new Volume[lines.length];

        int i = 0;
        for (String line : lines) {
            String trimmedLine = line.trim();
            volumes[i++] = new Volume(trimmedLine);
        }

        Arrays.sort(volumes, new Volume.AmountOrder());

        String expected = """
                19-Aug-40 130000
                26-Aug-40 160000
                24-Jul-40 200000
                23-Jun-42 210000
                10-Aug-42 210000
                01-Oct-28 3500000
                02-Oct-28 3850000
                03-Oct-28 4060000
                04-Oct-28 4330000
                05-Oct-28 4360000
                31-Dec-99 374049984
                30-Dec-99 554680000
                03-Jan-0 931800000
                04-Jan-0 1009000000
                05-Jan-0 1085500032
                23-Jul-2 2441019904
                17-Jul-2 2566500096
                15-Jul-2 2574799872
                15-Jul-3 2574799872
                15-Jul-4 2574799872
                19-Jul-2 2654099968
                24-Jul-2 2775559936
                """;

        StringBuilder actual = new StringBuilder();
        for (Volume volume : volumes) {
            actual.append(volume).append("\n");
        }

        assertEquals(expected, actual.toString());
    }
}