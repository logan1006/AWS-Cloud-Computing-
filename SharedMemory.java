import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SharedMemory
{
        public static int thread_count;
        public static int split_chunk_count;
        public static String inputloc = null;
        public static String outputloc = null;
        public static long begin_time;
        public static long end_time;

                        public static void main(String[] args) throws IOException, InterruptedException
        {
                Scanner sc = new Scanner(System.in);
                System.out.println("input file location : ");
                inputloc = sc.nextLine();
                //System.out.println(inputloc);
                System.out.println(" output file location : ");
                outputloc = sc.nextLine();
                System.out.println("Enter number of Threads");
                thread_count = Integer.parseInt(sc.nextLine());
                sc.close();
                begin_time = System.nanoTime();

                splitter(inputloc);
                //System.out.println(split_chunk_count);
                thread_controller[] array_thread = new thread_controller[thread_count];
                for(int x = 0; x< array_thread.length; x++)
                {
                        array_thread[x] = new thread_controller();
                }
                for(int x = 0; x< array_thread.length; x++)
                        {
                        array_thread[x].start();
                        }
                for(int x = 0; x< array_thread.length; x++)
                {
                        array_thread[x].join();
                }
                file_merger();

                end_time = System.nanoTime();

                System.out.println("File which is inputed : " + inputloc);
                //System.out.println("Resulted file : " + outputloc + "/sortedFile");
                System.out.println("Number of Threads : " + thread_count);
                System.out.println("Time consumed while sorting : " + (end_time-begin_time) / 1000000000.000 + " seconds");
        }

                        public static void Extractor_1() {
                                int a = 11;
                              int b = 6;
                              int c = min_Function(a, b);

                                }

                        public static int min_Function(int n1, int n2) {
                                   int min;
                                   if (n1 > n2)
                                      min = n2;
                                   else
                                      min = n1;

                                   return min;
                                }
        public static void splitter(String f_name) throws IOException
        {
                int split_chunk_size = 1024*1024*10;
                BufferedReader reader = new BufferedReader(new FileReader(new File(inputloc)));
                String str = reader.readLine();
                while(str != null)
                {
                        //System.out.println(outputloc +"/part"+split_chunk_count+".txt");
                        File f = new File(outputloc +"/part"+split_chunk_count);
                        FileWriter writer = new FileWriter(f);
                        int i = 0;
                        while(i< split_chunk_size) {
                                writer.write(str);
                                writer.write("\n");
                                str = reader.readLine();
                                if (str == null) {
                                        break;
                                }
                        i++;
                        }

                        split_chunk_count++;
                }
        }
                /** Merging individual sorted files. */
        public static void file_merger() throws IOException
        {
                String[] firstLines = new String[split_chunk_count];
                                //Initializing array of buffer reader for all the split files
                BufferedReader[] reader = new BufferedReader[split_chunk_count];
                for(int i = 0; i < split_chunk_count; i++)
                {
                        reader[i] = new BufferedReader(new FileReader(new File(outputloc+"/part" +i)));
                        firstLines[i] = reader[i].readLine();
                }
                                //Initialize buffer writer for output file
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(outputloc +"/Sorted_file.txt")));
                                        //get the smallest value, place it in output file, remove from split file and read next line from file where data was removed
                String newLine = null;
                                do {
                                        int index = returnNonNullIndex(firstLines);
                                        if(index == -1) {
                                                break;
                                        }
                                        String smallest = firstLines[index];
                                        for(int j = 1; j < firstLines.length; j++)
                                        {
                                                if(firstLines[j] != null && smallest.compareTo(firstLines[j]) >= 0) {
                                                        smallest = firstLines[j];
                                                        index = j;
                                                }
                                                                                                                }
                                                                writer.write(firstLines[index] + " \n"); //write in output file
                                                                //read new line from file at which previous smallest value was present
                                        firstLines[index] = reader[index].readLine();
                                                        } while (true);
                                                                writer.close(); //close output file
                                                                //close buffer readers and delete temporary split files
                for(int i  = 0;i < reader.length; i++)
                {
                        reader[i].close();
                        new File(outputloc+"/part" +i).delete();
                }
        }

        private static void buildMaxHeap(int[] array, int heapSize) {
        if(array == null) {
            throw new NullPointerException("null");
        }
        if(array.length <=0 || heapSize <= 0) {
            throw new IllegalArgumentException("illegal");
        }
        if(heapSize > array.length) {
            heapSize = array.length;
        }

        for(int i = heapSize/2; i > 0; i--) {
           // maxHeapify(array, i, heapSize);
        }

    }
          // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
          //  StdOut.println(a[i]);
        }
    }

                        /** Finds index of 1st occurring non-null value. */
        public static int returnNonNullIndex(String[] input)
        {
                                for(int i = 0; i < input.length; i++)
                {
                        if(input[i]!= null) {
                                return i;
                        }
                }
                return -1;
        }


        //////////////////////****************************************??????????????????


        public static void swap_Function(int a, int b) {
              //System.out.println("Before swapping(Inside), a = " + a + " b = " + b);

              // Swap n1 with n2
              int c = a;
              a = b;
              b = c;
        }

        public static void sort_heap(int arr[])
    {
        //heapify(arr);
                int N=15;
                int a;
        for (int i = N; i > 0; i--)
        {
                swap_Function(0, i);
            N = N-1;
            //maxheap(a, 0);
        }





    }


        private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    private static void exch(Object[] pq, int i, int j) {
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }


}