package sort;

/**
 * Created by HunJin on 2016-09-26.
 *
 * sort.SleepSort Algorithm
 */
public class SleepSort {
    public static void main(String[] args) {
        new SleepSort().solve();
    }

    /**
     * 슬립소트 : 스레드를 돌려 정해진 수의 시간만큼 잠들어 있다가 깨어나는 정렬법
     * @param nums
     */
    void sleepSort(int[] nums) {
//        final CountDownLatch doneSignal = new CountDownLatch(nums.length);
        for (final int num : nums) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
//                        doneSignal.await();
                        Thread.sleep(num*100);  // 숫자의 크기 * 0.1초의 시간만큼 대기
                        System.out.print(num + " ");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    void solve() {
        int[] nums = new int[(int)(Math.random()*10)+1]; // 사이즈 랜덤
        initialization(nums);
        sleepSort(nums);
    }

    /**
     * 값 랜덤
     * @param nums
     */
    void initialization(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            nums[i] = (int)(Math.random()*10)+1;
        }
    }
}
