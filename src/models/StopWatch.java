package models;

public class StopWatch extends Thread 
{
	//INSTANCE VARIABLES
    private long startTime;
    private boolean started;

    /*
     * This method starts the stopwatch/timer thread after setting the 
     * elapsed time to 0 minutes and 0 seconds (sets started to true).
     */
    public void startThread()
    {
        this.startTime = System.currentTimeMillis();
        this.started = true;
        this.start();
    }
    
    /*
     * This method creates a 1-D int array with 4 elements that represents 
     * the time elapsed in terms of (in order) the number of hours elapsed, 
     * the number of minutes elapsed, the number of seconds elapsed, and
     * the number of milliseconds elapsed. It then returns the 1-D array.
     */
    public int[] getTime()
    {
        long milliTime = System.currentTimeMillis() - this.startTime;
        int[] out = new int[]{0, 0, 0, 0};
        out[0] = (int)(milliTime / 3600000      );
        out[1] = (int)(milliTime / 60000        ) % 60;
        out[2] = (int)(milliTime / 1000         ) % 60;
        out[3] = (int)(milliTime)                 % 1000;

        return out;
    }

    /*
     * This method stops the stopwatch/timer thread (sets started to false).
     */
    public void stopThread()
    {
        this.started = false;
    }
}