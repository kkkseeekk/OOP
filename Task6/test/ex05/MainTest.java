package ex05;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ex02.ViewResult;

public class MainTest {

    private final static int N = 1000;
    private static ViewResult view = new ViewResult(N);

    private static MaxCommand max1 = new MaxCommand(view);
    private static MaxCommand max2 = new MaxCommand(view);
    private static AvgCommand avg1 = new AvgCommand(view);
    private static AvgCommand avg2 = new AvgCommand(view);
    private static MinMaxCommand min1 = new MinMaxCommand(view);
    private static MinMaxCommand min2 = new MinMaxCommand(view);

    private static CommandQueue queue = new CommandQueue();
    private static Thread worker;

    @BeforeClass
    public static void setUpBeforeClass() {
        view.viewInit();
        assertEquals(N, view.getItems().size());

        worker = new Thread(queue);
        worker.start();
    }

    @AfterClass
    public static void tearDownAfterClass() throws InterruptedException {

        TimeUnit.SECONDS.sleep(5);

        assertEquals(max1.getResult(), max2.getResult(), 0.1);
        assertEquals(avg1.getResult(), avg2.getResult(), 0.1);
        assertEquals(min1.getResultMax(), min2.getResultMax(), 0.1);
        assertEquals(min1.getResultMin(), min2.getResultMin(), 0.1);

        queue.shutdown();
    }

    @Test
    public void testMax() {
        max1.execute();
        assertTrue(max1.getResult() >= 0);
    }

    @Test
    public void testAvg() {
        avg1.execute();
        assertTrue(avg1.getResult() >= 0);
    }

    @Test
    public void testMin() {
        min1.execute();
        assertTrue(min1.getResultMin() >= 0);
    }

    @Test
    public void testMaxQueue() {
        queue.put(max2);
    }

    @Test
    public void testAvgQueue() {
        queue.put(avg2);
    }

    @Test
    public void testMinQueue() {
        queue.put(min2);
    }
}
