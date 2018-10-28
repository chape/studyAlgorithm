package sort;

import org.junit.Test;

/**
 * Created by ChaoChao on 2018/8/9.
 */
public class ShellSort {

    @Test
    public void testShell(){
        int[] mess = {2,4,5,1,7};

        shell(mess);

        print(mess);
    }



    private void shellsort2(int a[], int n) {

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int j = gap; j < n; j++) {//从数组第gap个元素开始
                if (a[j] < a[j - gap])//每个元素与自己组内的数据进行直接插入排序
                {
                    int temp = a[j];
                    int k = j - gap;
                    while (k >= 0 && a[k] > temp) {
                        a[k + gap] = a[k];
                        k -= gap;
                    }
                    a[k + gap] = temp;
                }
            }
        }
    }
    private void shell(int[] mess){
        int gap = mess.length / 2;

        while (gap > 0) {
            for (int i = gap; i < mess.length; i++) {
                for (int j = i-gap; j >= 0; j-=gap) {
                    if(mess[j+gap] < mess[j]) {
                        swap(mess, j+gap, j);
                    }else {
                        break;
                    }
                }
            }
            gap = gap / 2;
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        if(index1 == index2) {
            return;
        }
        arr[index1] = arr[index1]^arr[index2];
        arr[index2] = arr[index1]^arr[index2];
        arr[index1] = arr[index1]^arr[index2];
    }

    private void print(int[] mess){
        System.out.println("");
        for (int i = 0; i < mess.length; i++) {
            System.out.printf(mess[i]+"");
        }
    }
}
