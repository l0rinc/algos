(ns multi_sum.rand_range)

(defn rand-range [min, max]
  (+ min (rand-int (- max min))))

(defn rand-symmetric-range [range]
  (let [half (quot range 2)]
    (rand-range (- half) half)))

(defn distinct-rand-ints [elems-count elems-range]
  (to-array (last
              (take-while #(<= (count %) elems-count)
                          (iterate #(conj % (rand-symmetric-range elems-range))
                                   #{})))))