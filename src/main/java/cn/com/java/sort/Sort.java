package cn.com.java.sort;

public class Sort {

    /**
     * 冒泡排序法：
     *      比较两个相邻数的大小，若前面一个数大于后面一个数，则：交换位置
     *      即：每次循环一次都选举出当前一次最大的数并放到最后一位。
     * @param arry
     */
    public void bubbleSort(int[] arry){
        for (int i=0;i<arry.length-1;i++){
            int temp = arry[i];
            for (int j=0;j<arry.length-1;j++){
                if (arry[j]>arry[j+1]){
                    temp = arry[j];
                    arry[j] = arry[j+1];
                    arry[j+1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序法：
     *      即：每一次循环，先选出最小的数放到排序序列的数组的最后一位
     *      比如：第一次循环，先选出最小的数，放到数组的第一位，然后将第一位的数与最小数为的数交换
     * @param arry
     */
    public void selectSort(int[] arry){
        for (int i=0;i<arry.length-1;i++){
            int min = arry[i];
            int index = i;
            for (int j=i+1;j<arry.length;j++){
                if (min>arry[j]){
                    min = arry[j];
                    index = j;
                }
            }
            arry[index] = arry[i];
            arry[i] = min;
        }
    }

    public void insertSort(int[] arry){
        for (int i=1;i<arry.length;i++){
            int preIndex = i-1;
            int current = arry[i];
            while (preIndex>=0 && arry[preIndex]>current){
                arry[preIndex+1] = arry[preIndex];
                preIndex--;
            }
            arry[preIndex+1] = current;
        }
    }

    public static void main(String[] args) {
        int[] arry = new int[]{-1,3,2,4,56,7,8,9,13,24,34,45,12,47,32};
        new Sort().bubbleSort(arry);
        System.out.println("------bubbleSort------------");
        println(arry);

        System.out.println("-----------selectSort");
        arry = new int[]{10,3,2,4,56,7,8,9,13,24,34,45,12,47,32};
        new Sort().selectSort(arry);
        println(arry);

        System.out.println("-----------insertSort");
        arry = new int[]{10,3,2,4,56,7,8,9,13,24,34,45,12,47,32};
        new Sort().insertSort(arry);
        println(arry);
    }

    private static void println(int[] arry){
        for (int i=0;i<arry.length;i++){
            if (i==0){
                System.out.print(arry[i]);
            }else {
                System.out.print(","+arry[i]);
            }
        }
        System.out.println();
    }

}
