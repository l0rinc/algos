(ns multi_sum.triple_sum)

; Given distinct integers, how many triples sum to exactly zero?

(defn triple-sum-cubic [elems]                              ; TODO with binary search? With hashing?
  (let [count (count elems)]
    (for [i' (range 0 count)
          j' (range (inc i') count)
          k' (range (inc j') count)
          :let [i (nth elems i')
                j (nth elems j')
                k (nth elems k')]
          :when (zero? (+ i j k))]
      [i j k])))