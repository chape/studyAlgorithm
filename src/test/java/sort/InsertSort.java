package sort;

import org.junit.Test;

/**
 * Created by ChaoChao on 05/05/2018.
 */
public class InsertSort {
    @Test
    public void testBubble(){
        int[] mess = {2,4,1,7};

        insert1(mess);

        print(mess);
    }

    private void insert1(int[] mess){
        for (int i = 1; i < mess.length; i++) {
            int temp = mess[i];
            int j;
            for (j = i; j > 0; j--) {
                if(temp < mess[j-1]) {
                    mess[j] = mess[j-1];
                }else {
                    break;
                }
            }
            mess[j] = temp;
        }
    }

    private void insert(int[] mess){
        for (int i = 1; i < mess.length; i++) {
            for (int j = i - 1; j >= 0 && mess[j] > mess[j+1]; j--) {
                swap(mess,j,j+1);
            }
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
