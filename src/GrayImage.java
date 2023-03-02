public class GrayImage
{
    public static final int BLACK = 0;
    public static final int WHITE = 255;

    /** The 2-dimensional representation of this image. Guaranteed not to be null.
     *  All values in the array are within the range [BLACK, WHITE], inclusive.
     */
    private int[][] pixelValues;

    /** constructor that takes a 2D array */
    public GrayImage(int[][] theArray)
    {
        pixelValues = theArray;
    }

    /** @return the total number of white pixels in this image.
     *  Postcondition: this image has not been changed.
     */
    public int countWhitePixels() {
        int counter = 0;
        for (int i = 0; i < pixelValues.length; i++) {
            for (int z = 0; z < pixelValues[0].length; z++) {
                if (pixelValues[i][z] == 255) {
                    counter++;
                }
            }
        }
        return counter;
    }

    /** Processes this image in row-major order and decreases the value of each pixel at
     *  position (row, col) by the value of the pixel at position (row + 2, col + 2) if it exists.
     *  Resulting values that would be less than BLACK are replaced by BLACK.
     *  Pixels for which there is no pixel at position (row + 2, col + 2) are unchanged.
     */
    public void processImage() {
        int tempNum = 0;
        for (int i = 0; i < pixelValues.length - 2; i++) {
            for (int z = 0; z < pixelValues[0].length - 2; z++) {
                tempNum = pixelValues[i][z] - pixelValues[i + 2][z + 2];
                if (tempNum <= 0) {
                    pixelValues[i][z] = 0;
                }   else   {
                    pixelValues[i][z] = tempNum;
                }
            }
        }
    }

    public void printValues()
    {
        for (int r = 0; r < pixelValues.length; r++)
        {
            for (int c = 0; c < pixelValues[0].length; c++)
            {
                System.out.print(pixelValues[r][c] + ", ");
            }
            System.out.println();
        }
    }
}