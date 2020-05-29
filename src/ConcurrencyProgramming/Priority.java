package ConcurrencyProgramming;

import org.omg.CORBA.TIMEOUT;

import java.lang.management.ThreadInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Priority {
    private static volatile boolean notStart = true;
    private static volatile boolean notEnd = true;
    public static void main(String[] args) throws Exception{
        List<Job> jobs = new ArrayList<Job>();
        for (int i=0;i<10;i++){
            //线程优先级高的线程，分配的时间多于优先级低的线程
            int priority = i<5 ? Thread.MAX_PRIORITY : Thread.MIN_PRIORITY;
            Job job = new Job(priority);
            jobs.add(job);
            Thread thread = new Thread(job, "Thread"+i);
            thread.setPriority(priority);
            thread.start();
        }
        notStart = false;
        TimeUnit.SECONDS.sleep(10);
        notEnd = false;
        for (Job job : jobs){
            System.out.println("Job Priority:"+job.priority+", count:"+job.jobCount);
        }
    }
    public static class Job implements Runnable{
        private int priority;
        private long jobCount;
        public Job(int priority){
            this.priority = priority;
        }
        public void run(){
            while (notStart){
                Thread.yield();
            }
            while (notEnd){
                Thread.yield();
                jobCount++;
            }
        }
    }
}
