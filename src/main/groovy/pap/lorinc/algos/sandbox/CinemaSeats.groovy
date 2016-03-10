package pap.lorinc.algos.sandbox

import static pap.lorinc.algos.helpers.Numbers.isEven

/* The couples' seats in a cinema have been mixed up randomly. Reunite the couples, by swapping everyone at most one time. */
class CinemaSeats {
    /** Complexity: O(seats.size()), with same space usage */
    static sort(List seats) {
        def finalSeats = [] as Set /* used for validation only */
        def seatRegistry = computeRegistry(seats)

        for (def seat = 0; seat != null;) {
            def couple = seats[seat]
            def partnerSeat = partnerSeat(seat)
            def targetSeat = targetSeat(seatRegistry, couple, seat)

            updateRegistry(seatRegistry, couple, seats, partnerSeat)

            swap(finalSeats, seats, partnerSeat, targetSeat)
            seat = (partnerSeat != targetSeat) ? targetSeat
                                               : anySeat(seatRegistry)
        }
        seats
    }
    private static computeRegistry(List seats) {
        def results = [:].withDefault { [] }
        seats.eachWithIndex { couple, seat -> results[couple] += seat }
        assert results.every { it.value.size() == 2 }
        results
    }
    private static partnerSeat(int seat) {
        def offset = isEven(seat) ? 1 : -1
        seat + offset
    }
    private static targetSeat(Map seatRegistry, Object couple, int seat) {
        def seats = seatRegistry[couple]
        (seats - seat)[0] as int
    }
    private static updateRegistry(Map<?, List<Integer>> seatRegistry, Object couple, List seats, int partnerSeat) {
        seatRegistry.remove(couple)

        couple = seats[partnerSeat]
        seatRegistry[couple].remove((Object) partnerSeat)
    }
    private static swap(Set finalSeats, List seats, int source, int target) {
        assert finalSeats.addAll(source, target)
        seats.swap(source, target)
    }
    private static anySeat(Map seatRegistry) { seatRegistry.values()[0][0] }
}
