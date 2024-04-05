// Source : https://leetcode.com/problems/first-bad-version/description/

class VersionControl {
    private static int[] versionQuality = {1, 1, 1, 0, 0};

    public static boolean isBadVersion(int version){
        return versionQuality[version - 1] == 0;
    }
}

public class First_Bad_Version extends VersionControl{
    public static void main(String[] args) {
        int n = 5;
        int lo = 1;
        int hi = n;

        System.out.println("First bad version is: " + findFirstBadVer(lo, hi));
    }

    public static int findFirstBadVer(int lo, int hi){
        while(lo < hi){
            int mid = lo + (hi - lo)/2;

            if(isBadVersion(mid))
                hi = mid;
            else
                lo = mid + 1;
        }
        return lo;
    }
}
