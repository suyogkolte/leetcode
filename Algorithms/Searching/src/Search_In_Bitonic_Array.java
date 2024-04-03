// Source : https://www.interviewbit.com/problems/search-in-bitonic-array/

public class Search_In_Bitonic_Array {
    public static void main(String[] args) {
        int[] A = {3, 9, 10, 20, 17, 5, 1};
        int B = 17;

        int bitonicPoint = findBitonicPoint(A);
        System.out.println("The element " + B + " can be found at input array index " + searchBitonicArray(A, B, bitonicPoint));
    }

    public static int findBitonicPoint(int[] A){
        int l = 0;
        int r = A.length - 1;

        while(l < r){
            int mid = l + (r - l) / 2;

            if(A[mid] > A[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    public static int searchBitonicArray(int[] A, int B, int bitonicPt){
        if(B > A[bitonicPt])
            return -1;
        else if (B == A[bitonicPt])
            return bitonicPt;
        else{
            int temp = ascendingBinarySearch(A, B, 0, bitonicPt - 1);

            if(temp != -1)
                return temp;
        }

        return descendingBinarySearch(A, B, bitonicPt + 1, A.length - 1);

    }

    private static int ascendingBinarySearch(int[] A, int B, int lo, int hi) {
        int l = lo;
        int r = hi;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if(B == A[mid])
                return mid;

            if(B < A[mid])
                r = mid - 1;
            else
                l = mid + 1;
        }
        return  -1;
    }

    private static int descendingBinarySearch(int[] A, int B, int lo, int hi) {
        int l = lo;
        int r= hi;

        while(l <= r){
            int mid = l + (r - l)/2;
            if(B == A[mid])
                return mid;

            if(B < A[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }
}
