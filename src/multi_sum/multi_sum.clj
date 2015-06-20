(ns multi_sum.multi_sum
  (:use multi_sum.rand_range)
  (:use multi_sum.double_sum)
  (:use multi_sum.triple_sum)
  (:use multi_sum.logger))

(def debug false)
(def elems-count 300)
(def elems-range 500)
(assert (<= elems-count elems-range))

; ---------------------------------------------------- ;

(def elems (distinct-rand-ints elems-count elems-range))
(assert (= elems-count (count elems)))

(if debug (println (seq elems)))

(log double-sum-squared elems)
(log double-sum-linearithmic elems)
(log double-sum-linear elems)

(log triple-sum-cubic elems)