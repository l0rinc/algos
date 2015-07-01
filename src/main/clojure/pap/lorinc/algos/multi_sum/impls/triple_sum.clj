(ns pap.lorinc.algos.multi_sum.impls.triple_sum
  (:use pap.lorinc.algos.multi_sum.impls.double_sum))

; Given distinct integers, how many triples sum to exactly zero?

(defn triple-sum-cubic-reference
  ([elems] (triple-sum-cubic-reference elems 0))
  ([elems sum]
   (let [count (count elems)]
     (for [i' (range 0 count)
           j' (range (inc i') count)
           k' (range (inc j') count)
           :let [i (nth elems i')
                 j (nth elems j')
                 k (nth elems k')]
           :when (= sum (+ i j k))]
       [i j k]))))

(defn triple-sum
  ([elems] (triple-sum elems double-sum-linear 0))
  ([elems double-sum-function sum]
   (loop [[first & rest] elems
          results '()]
     (if rest
       (let [delegate (double-sum-function rest (- sum first))
             results (if (empty? delegate)
                       results
                       (concat results (map #(conj % first) delegate)))]
         (recur rest results))
       results))))

(defn triple-sum-cubic
  ([elems] (triple-sum-cubic elems 0))
  ([elems sum] (triple-sum elems double-sum-squared sum)))

(defn triple-sum-squared-linear
  ([elems] (triple-sum-squared-linear elems 0))
  ([elems sum] (triple-sum elems double-sum-linearithmic sum)))

(defn triple-sum-squared
  ([elems] (triple-sum-squared elems 0))
  ([elems sum] (triple-sum elems double-sum-linear sum)))