package sort;

import org.junit.Test;

/**
 * Created by ChaoChao on 05/05/2018.
 * 归并排序 NlogN
 */
public class MergeSort {
    @Test
    public void testMerge(){
        int[] mess = {2,4,1,7};

        sort(mess,0, mess.length-1);
        print(mess);
    }

    private void sort(int[] mess, int left, int right){
        if(left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        sort(mess,left,mid);
        sort(mess,mid+1,right);

        merge(mess,left,right);
    }

    private void merge(int[] mess, int left, int right) {
        int[] temp = new int[right - left + 1];
        int p1 = left;
        int mid = left + ((right - left) >> 1);
        int p2 = mid + 1;

        // 左右俩哨兵比较 谁小谁排前
        int i = 0;
        while (p1 <= mid && p2 <= right) {
            temp[i++] = mess[p1] < mess[p2] ? mess[p1++] : mess[p2++];
        }

        // 左右俩哨兵比较剩下的直接赋值
        while (p1 <= mid) {
            temp[i++] = mess[p1++];
        }

        while (p2 <= right) {
            temp[i++] = mess[p2++];
        }
        //拷贝到原有数组中
        for (int j = 0; j < temp.length; j++) {
            mess[left+j] = temp[j];
        }

    }

    private void print(int[] mess){
        System.out.println("");
        for (int i = 0; i < mess.length; i++) {
            System.out.printf(mess[i]+"");
        }
    }
}
