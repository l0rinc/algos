(ns multi_sum.multi_sum
  (:import (java.util Collections))
  (:use multi_sum.rand_range))

; Given N distinct integers, how many triples sum to exactly zero?

(def debug false)
(def elems-count 100)
(def elems-range 1000)
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
    #{i j}))
(println ["double-sum-squared"                              ; TODO get name of method from reference
          (count (double-sum-squared elems))                ; TODO extract print to method
          (double-sum-squared elems)])                      ; TODO print time also and run it only once


(defn double-sum-linearithmic [elems]
  (let [sorted-elems (sort elems)]
    (for [i' (range 0 elems-count)
          :let [i (nth elems i')]
          :when (<= i' (Collections/binarySearch sorted-elems (- i)))] ; TODO custom Clojure binary search?
      #{i (- i)})))
(println ["double-sum-linearithmic"
          (count (double-sum-linearithmic elems))
          (double-sum-linearithmic elems)])


(defn double-sum-linear [elems]                             ; TODO the set should be generated on the fly, to avoid duplicates and 0s
  (let [existing (set elems)]                               ; TODO unify with linearithmic?
    (for [i elems
          :when (contains? existing (- i))]
      #{i (- i)})))
(println ["double-sum-linear"
          (count (double-sum-linear elems))
          (double-sum-linear elems)])


(defn triple-sum-cubic [elems]                              ; TODO with binary search? With hashing?
  (for [i' (range 0 elems-count)
        j' (range (inc i') elems-count)
        k' (range (inc j') elems-count)
        :let [i (nth elems i')
              j (nth elems j')
              k (nth elems k')]
        :when (zero? (+ i j k))]
    #{i j k}))
(println ["triple-sum-cubic"
          (count (triple-sum-cubic elems))
          (triple-sum-cubic elems)])