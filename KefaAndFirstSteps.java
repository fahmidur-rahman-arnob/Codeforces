import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class KefaAndFirstSteps {

    public static void main(String[] args) throws IOException {
        // Fast input reader
        FastScanner fs = new FastScanner();

        // Fast output writer
        PrintWriter out = new PrintWriter(System.out);

        StringBuilder sb = new StringBuilder();

        //scanner class to use the nextLine() method ONLY;

        
        int n = fs.nextInt();
        int[] arr = fs.readArray(n);
        int max = 1;
        int crr = 1;

        for (int i = 0; i < n - 1; i++) {
            if(arr[i] <= arr[i + 1]){
                crr++;
                max = Math.max(max, crr);
            }
            else {
                crr = 1;
            }
        }
        System.out.println(max);







        // you must flush, or else you might miss an output... 
        //out.flush();
    }

    static boolean checkElements(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            // An empty list can be considered as satisfying the condition, or handle as needed
            return true;
        }

        // Check if all elements are 0
        boolean allZeros = true;
        for (Integer element : list) {
            if (element != 0) {
                allZeros = false;
                break;
            }
        }
        if (allZeros) {
            return true;
        }

//         Check if all elements are equal to the first element
        Integer firstElement = list.get(0);
        for (Integer element : list) {
            if (!element.equals(firstElement)) {
                return false; // Found an element that is not equal to the first
            }
        }
        return true; // All elements are equal to the first element
    }


    // Direct & efficient sorting (Arrays.sort)
    static void sort(int[] a) {
        Arrays.sort(a);
    }

    static void sort(long[] a) {
        Arrays.sort(a);
    }
    static boolean isPrime(long n){
        if(n < 2)return false;
        if(n == 2 || n == 3) return true;
        if(n % 2 == 0 || n % 3 == 0) return false;

        long sqrtN = (long)Math.sqrt(n) + 1;
        for(long i = 6L; i <= sqrtN; i+=6){
            if(n % (i - 1) == 0 || n % (i + 1) == 0){
                return false;
            }
        }
        return true;
    }

    static long gcd(long a, long b){
        if(a > b){
            a = (a + b) - (b = a);
        }
        if(a == 0L){
            return b;
        }
        return gcd(b %a, a);
    }

    static long power(long x, long y, long p){
        long res = 1L;
        x = x % p;

        while(y > 0){
            if((y & 1) == 1){
                res = (res * x) % p;
            }
            y >>= 1;
            x = (x * x) % p;
        }
        return res;
    }

    // Custom fast scanner class
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null; // if null then safe return
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }
    }
}
 