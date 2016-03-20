package pap.lorinc.algos.ctci._08

import groovy.transform.*

/** Find a path between two points. You can only move down or right and some cells are forbidden. */
class _08_02_RobotInGrid {
    /** Complexity: O(grid.width * grid.height) */
    static path(List<List<Boolean>> grid, Point start = Point.of(0, 0), Point finish = Point.of(grid.size() - 1, grid[0].size() - 1)) {
        def path = []
        while (isConnected(grid, start, finish)) {
            path += start
            start = [start.right(), start.down()].find { isConnected(grid, it, finish) }
        }
        path
    }
    @Memoized private static isConnected(List<List<Boolean>> grid, Point start, Point finish) {
        (((start != null) && (start.row <= finish.row) && (start.column <= finish.column) && grid[start.row][start.column])
        && ((start == finish) || [start.right(), start.down()].any { isConnected(grid, it, finish) }))
    }
}

@Canonical class Point {
    int row, column
    static of(int row, int column) { new Point(row, column) }

    def down() { Point.of(row + 1, column) }
    def right() { Point.of(row, column + 1) }

    @Override String toString() { "($row,$column)" }
}
