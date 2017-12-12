package io.roberthernandez;

import org.junit.Test;

import java.io.FileNotFoundException;
import static org.junit.Assert.assertEquals;



public class FileInputOutputTest {

    @Test
    public void readFileDataTest() {
        final int lines_to_read = 1;
        final int fields_count = 9;

        String[][] result = new String[lines_to_read][fields_count];

        try {
            result = Algo_Final.readDataFromFile(lines_to_read);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        assertEquals(result[0][0],"AO94DHGC771SJ");
        assertEquals(result[0][1],"0528881469");
        assertEquals(result[0][2],"amazdnu");
        assertEquals(result[0][3],"[0, 0]");
        assertEquals(result[0][4],"We got this GPS for my husband who is an (OTR) over the road trucker.  Very Impressed with the shipping time, it arrived a few days earlier than expected...  within a week of use however it started freezing up... could of just been a glitch in that unit.  Worked great when it worked!  Will work great for the normal person as well but does have the \\trucker\\ option. (the big truck routes - tells you when a scale is coming up ect...)  Love the bigger screen, the ease of use, the ease of putting addresses into memory.  Nothing really bad to say about the unit with the exception of it freezing which is probably one in a million and that's just my luck.  I contacted the seller and within minutes of my email I received a email back with instructions for an exchange! VERY impressed all the way around!");
        assertEquals(result[0][5],"5.0");
        assertEquals(result[0][6],"Gotta have GPS!");
        assertEquals(result[0][7],"1370131200");
        assertEquals(result[0][8],"06 2, 2013");
    }
}
