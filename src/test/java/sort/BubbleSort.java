package sort;

import org.junit.Test;

/**
 * Created by ChaoChao on 05/05/2018.
 */
public class BubbleSort {
    @Test
    public void testBubble(){
        int[] mess = {2,4,1,7};

        bubble(mess);

        print(mess);
    }

    private void bubble(int[] mess){
        for (int end = mess.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if(mess[i] > mess[i+1]) {
                    swap(mess,i,i+1);
                }
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
