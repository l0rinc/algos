(ns multi_sum.multi_sum
  (:import (java.util Arrays))
  (:use multi_sum.rand_range))

; Given N distinct integers, how many triples sum to exactly zero?

(def debug false)
(def elems-count 100)
(def elems-range 1000)
(assert (<= elems-count elems-range))

; ------------------------------------------------------------------- ;

(def elems (distinct-rand-ints elems-count elems-range))
(assert (= elems-count (count elems)))

(defn triple-sum-cubic [elems]
  (for [i' (range 0 elems-count)
        j' (range (inc i') elems-count)
        k' (range (inc j') elems-count)
        :let [i (nth elems i')
              j (nth elems j')
              k (nth elems k')]
        :when (zero? (+ i j k))]
    #{i j k}))

(println (count (triple-sum-cubic elems)))

(if debug
  [(println (Arrays/toString elems))
   (time (triple-sum-cubic elems))])