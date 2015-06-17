(ns multi_sum.multi_sum
  (:import (java.util Collections))
  (:use multi_sum.rand_range)
  (:use multi_sum.logger))

; Given N distinct integers, how many triples sum to exactly zero?

(def debug false)
(def elems-count 300)
(def elems-range 500)
(assert (<= elems-count elems-range))

; ------------------------------------------------------- ;

(def elems (distinct-rand-ints elems-count elems-range))
(assert (= elems-count (count elems)))

(if debug (println (seq elems)))

(defn double-sum-squared [elems]
  (for [i' (range 0 elems-count)
        j' (range (inc i') elems-count)
        :let [i (nth elems i')
              j (nth elems j')]
        :when (zero? (+ i j))]
    [i j]))
(log double-sum-squared elems)

(defn double-sum-linearithmic [elems]
  (let [sorted-elems (sort elems)]
    (for [i' (range 0 elems-count)
          :let [i (nth elems i')]
          :when (<= i' (Collections/binarySearch sorted-elems (- i)))] ; TODO custom Clojure binary search?
      [i (- i)])))
(log double-sum-linearithmic elems)


(defn double-sum-linear [elems]                             ; TODO the set should be generated on the fly, to avoid duplicates and 0s
  (let [existing (set elems)]                               ; TODO unify with linearithmic?
    (for [i elems
          :when (contains? existing (- i))]
      [i (- i)])))
(log double-sum-linear elems)


(defn triple-sum-cubic [elems]                              ; TODO with binary search? With hashing?
  (for [i' (range 0 elems-count)
        j' (range (inc i') elems-count)
        k' (range (inc j') elems-count)
        :let [i (nth elems i')
              j (nth elems j')
              k (nth elems k')]
        :when (zero? (+ i j k))]
    [i j k]))
(log triple-sum-cubic elems)