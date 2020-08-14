package ConcurrencyProgramming.Sum;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SumParallelCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int numThread = 3;
        int N = 90000000;
//        parallel(N, numThread);
        Object o = new Object();
    }
    public static void parallel(int N, int numThread) throws ExecutionException, InterruptedException{
        //新建线程池
        ExecutorService executor = Executors.newFixedThreadPool(numThread);
        long start1 = System.currentTimeMillis();
        //使用Future记录返回值
        List<Future<Long>> ans = new ArrayList<>();
        List<Long> ansTask = new ArrayList<>();
        for (int i=0;i<numThread;i++){
            //使用submit向线程池提交线程，会有返回值
            //使用execute提交没有返回值
//            Future<Long> a = executor.submit(new SumThreadCallable(i*N/numThread, (i+1)*N/numThread));
            FutureTask<Long> task = new FutureTask<Long>(new SumThreadCallable(i*N/numThread, (i+1)*N/numThread));
            new Thread(task).start();
            Long a = task.get();
            ansTask.add(a);
//            ans.add(a);
        }
        long sum = 0;
        for (Long tmp : ansTask){
//            long tmp = i.get();
            System.out.println("线程"+"的结果是："+tmp);
            sum += tmp;
        }
        long end1 = System.currentTimeMillis();
        System.out.println("并行计算耗时："+(end1-start1)+"ms");
        System.out.println("并行计算结果："+sum);
    }
    public static class SumThreadCallable implements Callable<Long> {
        private long start;
        private long end;
        public SumThreadCallable(long start, long end){
            this.start = start;
            this.end = end;
        }
        //重写call方法，会有返回值
        @Override
        public Long call() throws Exception {
            long sum = 0;
            for (long i=start;i<end;i++){
                sum += i;
            }
            return sum;
        }
    }
}
