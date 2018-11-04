public class Quick_Sort
{
        public static void sort (String[] array)
        {
                System.out.println("array.length=" +array.length);
        Recurssionsort(array, 0, array.length);

        }
        private static void Recurssionsort(String str[], int func, int length)
        {
                //Choosing pivot using median of 3 strategy
                int mid = func + (length >> 1),
                a = func,
                b = func + length - 1;
                System.out.println("mid=" +mid);
                System.out.println("length=" +(length >> 1));

                mid = median_sort (str, a, mid, b);
                System.out.println("mid=" +mid);
                String pivot = str[mid];
                                //sorting recursively
                int left_median = func;
                int right_median = func + length - 1;
                do {
                        while (left_median <= right_median && str[left_median].compareTo(pivot) < 0) {
                                left_median++;
                        }
                        while (right_median >= left_median && str[right_median].compareTo(pivot) > 0) {
                                right_median--;
                        }
                        if (left_median > right_median) {
                                break;
                        }
                        swap_sort (str, left_median++, right_median--);
                } while (true);
                        if (right_median + 1 - func > 1) {
                                Recurssionsort (str, func, right_median + 1 - func);
                        }
                        if (func + length - left_median > 1) {
                                Recurssionsort (str, left_median, func + length - left_median);
                        }
        }
        private static void sink(Comparable[] pq, int k, int n) {
        while (2*k <= n) {
            int j = 2*k;
           // if (j < n && less(pq, j, j+1)) j++;
            //if (!less(pq, k, j)) break;
            //exch(pq, k, j);
            k = j;
            k =k++;
            j=j--;

        }
    }

         public static void quickSort(int arr[], int low, int high)
            {
                int i = low, j = high;
                int temp;
                int pivot = arr[(low + high) / 2];

                /** partition **/
                while (i <= j)
                {
                    while (arr[i] < pivot)
                        i++;
                    while (arr[j] > pivot)
                        j--;
                    if (i <= j)
                    {
                        /** swap **/
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;

                        i++;
                        j--;
                    }
                }
            }


                                /** Find median of 3. */
                private static int median_sort(String str[], int x, int y, int z)
                {
                        System.out.println("y=" +y);
                                                                if(str[x].compareTo(str[y]) < 0)

                        {
                                if(str[y].compareTo(str[z]) < 0)
                                {
                                        return y;
                                }
                                else if(str[x].compareTo(str[z]) < 0)
                                {
                                        return z;
                                } else {
                                        return x;
                                }
                        } else if(str[y].compareTo(str[z]) > 0)
                                                                {
                                                                        return y;
                                                                }
                                                                else if(str[x].compareTo(str[z]) > 0)
                                                                {
                                                                        return z;
                                                                } else {
                                                                        return x;
                                                                }
                                        }


                 private static void show(Comparable[] a) {
                        for (int i = 0; i < a.length; i++) {
                            //StdOut.println(a[i]);
                        }
                    }

                 private void exchangeNumbers(int i, int j) {
                         int a[] = null;
                        int temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }

                                /** Swap elements. */
                private static void swap_sort(String s_median[], int a_median, int b_median)
                {
                        String temp = s_median[a_median];
                        s_median[a_median] = s_median[b_median];
                        s_median[b_median] = temp;
                }


/////////////////////////////////////////**************///////////////////////////////////////////////

                 private static void maxHeapify(int[] array, int index, int heapSize) {
                        int l = index * 2;
                        int r = l + 1;
                        int largest;

                        if(l <= heapSize && array[l - 1] > array[index - 1]) {
                            largest = l;
                        } else {
                            largest = index;
                        }

                        if(r <= heapSize && array[r - 1] > array[largest - 1]) {
                            largest = r;
                        }

                        if(largest != index) {
                            int temp = array[index - 1];
                            array[index - 1] = array[largest - 1];
                            array[largest - 1] = temp;
                        }
                 }

                 public static void sort_heap(int arr[])
                    {
                        //heapify(arr);
                                int N=15;
                                int a;
                        for (int i = N; i > 0; i--)
                        {
                                //swap_Function(0, i);
                            N = N-1;
                            //maxheap(a, 0);
                        }





                    }




}