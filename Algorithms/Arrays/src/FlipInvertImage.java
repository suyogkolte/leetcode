// Source : https://leetcode.com/problems/flipping-an-image/description/

class FlipInvertImage {
    public int[][] flipAndInvertImage(int[][] image) {
        int rows = image.length;
        int cols = image[0].length;

        // Flip horizontally
        for(int i = 0; i < rows; i++)
        {
            int j = 0;
            int k = cols-1;

            while(j <= k)
            {
                int tmp = image[i][j];
                image[i][j] = image[i][k];
                image[i][k] = tmp;
                j++;
                k--;
            }
        }

        // Invert
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                image[i][j] = (image[i][j] == 0) ? 1 : 0;
            }
        }
        return image;
    }
}