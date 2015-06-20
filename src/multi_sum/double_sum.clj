(ns multi_sum.double_sum
  (:import (java.util Collections)))

; Given distinct integers, how many doubles sum to exactly zero?

(defn double-sum-squared [elems]
  (let [count (count elems)]
    (for [i' (range 0 count)
          j' (range (inc i') count)
          :let [i (nth elems i')
                j (nth elems j')]
          :when (zero? (+ i j))]
      [i j])))

(defn double-sum-linearithmic [elems]
  (let [sorted-elems (sort elems)]
    (for [i' (range 0 (count elems))
          :let [i (nth elems i')]
          :when (< i' (Collections/binarySearch sorted-elems (- i)))] ; TODO custom Clojure binary search?
      [i (- i)])))

(defn double-sum-linear
  ([elems] (double-sum-linear elems #{} []))
  ([elems visited results]
   (if (seq elems)
     (let [elem (first elems)
           inverse (- elem)]
       (recur (rest elems)
              (conj visited elem)
              (if (contains? visited inverse)
                (conj results [elem inverse])
                results)))
     results)))