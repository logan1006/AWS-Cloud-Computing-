import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;

public class thread_controller extends Thread
{
        public static int fileNumber;
        public void run()
        {
                try
                {
                        do {
                                int filenum = getFileNumber();
                                if(filenum >= SharedMemory.split_chunk_count) {
                                        break;
                                } else {
                                        System.out.println("inside else");
                                        sortFile(SharedMemory.inputloc);
                                }
                                                        } while (true);
                                        }
                catch (IOException e)
                {
                        e.printStackTrace();
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


                /** Get file number. */

         private static void sink_tita(Comparable[] pq, int k, int n) {
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



        public static synchronized int getFileNumber()
        {
                return fileNumber++;
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
                        /** Sort individual file. */
        public static void sortFile(String file) throws IOException
        {
                //Count number of lines in file
                //System.out.println(file);
                //file = "C:/Users/amitc/Desktop/a.txt";
                LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file));
                while (lineNumberReader.readLine()!= null)
                {}
                int lineCount = lineNumberReader.getLineNumber();
                System.out.println("line count"+lineCount);
                lineNumberReader.close();
                                                //Read input file
                String[] fileData = new String[lineCount];
                BufferedReader reader = new BufferedReader(new FileReader(new File(file)));
                String str = reader.readLine(); //read line from buffer
                int i=0;
                //write data into Array
                while(str != null)
                {
                        fileData[i] = str;
                        str = reader.readLine();
                        i++;
                }
                reader.close();
                                        //sort Array
                System.out.println("File length=" +fileData.length);
                Quick_Sort.sort(fileData);
                                        //store sorted array in file
                FileWriter writer = new FileWriter(new File(SharedMemory.outputloc+"/sorted.txt"));
                BufferedWriter buffer = new BufferedWriter(writer);
                for (int j = 0; j < fileData.length; j++)
                {
                        buffer.write(fileData[j]);
                        buffer.newLine();
                }
                        buffer.close();

        }

        ///////////////////////////////***********//////////////////////////////////////////////



        private static void exch(Object[] pq, int i, int j) {
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }

        private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
          //  StdOut.println(a[i]);
        }
    }


        private static boolean less_value(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

         private void exchange_Numbers(int i, int j) {
                 int a[] = null;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }


}