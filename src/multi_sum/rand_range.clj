(ns multi_sum.rand_range)

(defn rand-range [min, max]
  (+ min (rand-int (- max min))))

(defn rand-symmetric-range [range]
  (let [half (quot range 2)]
    (rand-range (- half) half)))

(defn distinct-rand-ints [count range]
  (to-array
    (take count
          (distinct
            (repeatedly #(rand-symmetric-range range))))))