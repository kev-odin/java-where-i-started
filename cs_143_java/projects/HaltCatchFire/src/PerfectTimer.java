import java.util.Timer;
import java.util.TimerTask;

    public class PerfectTimer {

        public static void main(String args[]) {
            Timer timer = new Timer();
            TimerTask x = new TimerTask() {
                int start = 10;

                    public void run() {
                        System.out.println("Seconds remaining to answer the question:");
                        start = start - 1;
                        for (int i = 1; i < 2; i++) {
                            System.out.println(start);
                                if (start <= 0) {
                                    System.out.println("Time's up!");
                                    timer.cancel();
                                    break;
                                }
                            }
                        }
                };
                timer.schedule(x,0, 1000);
            }
        }