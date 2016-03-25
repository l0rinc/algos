package pap.lorinc.algos.ctci._08

import groovy.transform.*

/** Find a path between two points. You can only move down or right and some cells are forbidden. */
class _08_02_RobotInGrid {
    /** Complexity: O(grid.width * grid.height) */
    static path(List<List<Boolean>> grid, Point start = Point.of(0, 0), Point finish = Point.of(grid.size() - 1, grid[0].size() - 1)) {
        def path = []
        while (start != null) {
            path += start
            start = next(grid, start, finish)
        }
        path
    }
    @Memoized private static next(List<List<Boolean>> grid, Point start, Point finish) {
        [start.right(), start.down()].find { isConnected(grid, it, finish) }
    }
    private static isConnected(List<List<Boolean>> grid, Point start, Point finish) {
        (((start.row <= finish.row) && (start.col <= finish.col) && grid[start.row][start.col])
        && ((start == finish) || (next(grid, start, finish) != null)))
    }
}

@Canonical class Point {
    int row, col
    static of(int row, int col) { new Point(row, col) }

    def down() { of(row + 1, col) }
    def right() { of(row, col + 1) }

    @Override String toString() { "($row,$col)" }
}
