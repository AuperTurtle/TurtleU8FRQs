public class ItemGrid
{
    private Item[][] grid;

    /** Constructor */
    public ItemGrid(Item[][] grid)
    {
        this.grid = grid;
    }

    /** Returns true if row is a valid row index and column is a valid
     *  column index and returns false otherwise.
     *  THIS CODE WAS NOT PROVIDED IN FRQ, but here is what you would have seen if it had been
     */
    public boolean isValid(int row, int column)
    {
        if (row < 0 || row >= grid.length)
        {
            return false;
        }
        if (column < 0 || column >= grid[0].length)
        {
            return false;
        }

        return true;
    }

    /** Compares the item in row r and column c to the items to its
     *  left and to its right. Returns the name of the item with
     *  the greatest value, as described in part (a).
     *
     *  Precondition: r and c are valid indices
     */
    public String mostValuableNeighbor(int r, int c) {
        int maxValue = 0;
        String tempString = "";
        if (isValid(r, c)) {
            tempString = grid[r][c].getName();
            maxValue = grid[r][c].getValue();
        }
        if (isValid(r, c + 1) && grid[r][c + 1].getValue() > maxValue) {
            tempString = grid[r][c + 1].getName();
            maxValue = grid[r][c + 1].getValue();
        }
        if (isValid(r, c - 1) && grid[r][c-1].getValue() > maxValue) {
            tempString = grid[r][c-1].getName();
        }
        return tempString;
    }

    /** Returns the average value of all the items in grid,
     *  as described in part (b).
     */
    public double findAverage() {
        double average = 0;
        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int z = 0; z < grid[0].length; z++) {
                average += grid[i][z].getValue();
                counter++;
            }
        }
        return average/counter;
    }
}