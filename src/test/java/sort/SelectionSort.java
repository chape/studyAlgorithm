package sort;

import org.junit.Test;

/**
 * Created by ChaoChao on 05/05/2018.
 */
public class SelectionSort {
    @Test
    public void testSelect1(){
        int[] mess = {2,4,1,7};

        select1(mess);

        print(mess);
    }

    @Test
    public void testSelect2(){
        int[] mess = {2,4,1,7};

        select2(mess);

        print(mess);
    }

    private void select1(int[] mess){
        for (int i = 0; i < mess.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < mess.length; j++) {
                minIndex = mess[j] > mess[minIndex] ? minIndex : j;
            }
            swap(mess,minIndex,i);
        }
    }

    private void select2(int[] mess){
        for (int i = 0; i < mess.length - 1; i++) {
            for (int j = i + 1; j < mess.length; j++) {
                if(mess[i] > mess[j]) {
                    swap(mess,i,j);
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
