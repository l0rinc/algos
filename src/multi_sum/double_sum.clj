(ns multi_sum.double_sum)

; Given distinct integers, how many doubles sum to exactly zero?

(defn double-sum-squared
  ([elems] (double-sum-squared elems 0))
  ([elems sum]
   (let [count (count elems)]
     (for [i' (range 0 count)
           j' (range (inc i') count)
           :let [i (nth elems i')
                 j (nth elems j')]
           :when (= sum (+ i j))]
       [i j]))))

(defn binary-search
  ([elems elem] (binary-search elems elem 0 (dec (count elems))))
  ([elems elem start end]
   (if (>= end start)
     (let [mid (+ start (bit-shift-right (- end start) 1)),
           mid-elem (nth elems mid)]
       (cond (< elem mid-elem) (recur elems elem start (dec mid))
             (= elem mid-elem) mid
             (> elem mid-elem) (recur elems elem (inc mid) end)))
     -1)))

(defn double-sum-linearithmic
  ([elems] (double-sum-linearithmic elems 0))
  ([elems sum]
   (let [elems (sort elems)]
     (for [i' (range 0 (count elems))
           :let [i (nth elems i')]
           :when (< i' (binary-search elems (- sum i)))]
       [i (- i)]))))

(defn double-sum-linear
  ([elems] (double-sum-linear elems 0))
  ([elems sum] (double-sum-linear elems sum #{} []))
  ([elems sum visited results]
   (if (seq elems)
     (let [elem (first elems)
           complement (- sum elem)]
       (recur (rest elems)
              sum
              (conj visited elem)
              (if (contains? visited complement)
                (conj results [elem complement])
                results)))
     results)))