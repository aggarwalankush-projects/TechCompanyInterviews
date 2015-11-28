package Zenefits;

public class FlipBits {

    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 1, 1, 1};
        System.out.println(findMax(array));

    }

    private static Integer findMax(int[] arr) {
        if (arr == null || arr.length < 1)
            return 0;
        boolean flag = false;
        for (int i : arr) {
            if (i == 0) {
                flag = true;
                break;
            }
        }
        if (!flag)
            return arr.length;
        int sum = 0, max = 0, start = 0, end = 0, cur_start = 0;
        for (int i = 0; i < arr.length; i++) {
            int elem = arr[i] == 1 ? -1 : 1;
            sum += elem;
            if (max < sum) {
                max = sum;
                start = cur_start;
                end = i;
            } else if (sum <= 0) {
                sum = 0;
                cur_start = i + 1;
            }
        }

        return countOne(arr, 0, start - 1) + countZero(arr, start, end) + countOne(arr, end + 1, arr.length - 1);
    }

    public static int countOne(int[] array, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (array[i] == 1)
                count++;
        }

        return count;
    }

    public static int countZero(int[] array, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (array[i] == 0)
                count++;
        }

        return count;
    }
}
