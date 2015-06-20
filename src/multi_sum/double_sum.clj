(ns multi_sum.double_sum)

; Given distinct integers, how many doubles sum to exactly zero?

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
          :when (< i' (binary-search sorted-elems (- i)))]
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