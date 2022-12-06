package hello.zip.hello.hello;//remove package name before submission

public class Percolation {

    private final int[][] grid;
    private int numberOfOpenSites = 0;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {

        if (n <= 0) {
            throw new IllegalArgumentException("Invalid value of n");
        }
        grid = new int[n][n];
        //by default initialized to 0, representing disconnected.
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (!isOpen(row, col)) {
            grid[row][col] = 1;
            numberOfOpenSites++;
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < grid.length && row >= 0 && col < grid[row].length && col >= 0) {
            return grid[row][col] == 1;
        } else {
            throw new IllegalArgumentException("Out of bound");
        }
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        return numberOfOpenSites == grid.length* grid[0].length;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return false;
    }

    // test client (optional)
    public static void main(String[] args) {
    }
}