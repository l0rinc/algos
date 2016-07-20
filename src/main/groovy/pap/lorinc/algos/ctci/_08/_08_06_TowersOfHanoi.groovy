package pap.lorinc.algos.ctci._08

/** You have 3 stacks with n numbers in the first, in ascending order.
 * Move them to another stack, while keeping them sorted */
class _08_06_TowersOfHanoi {
    /** Complexity: O(2**(disk.size)) - 1) */
    static move(List disks) {
        recurse(disks.size(), disks.toList(), [], [])
    }

    private static recurse(int n, List<Integer> source, List<Integer> buffer, List<Integer> destination) {
        if (n == 1) {
            destination.add(source.pop())
        } else {
            recurse(n - 1, source, destination, buffer)
            destination.add(source.pop())
            recurse(n - 1, buffer, source, destination)
        }
        destination
    }
}