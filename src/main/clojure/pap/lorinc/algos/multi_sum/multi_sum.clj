(ns pap.lorinc.algos.multi_sum.multi_sum
  (:use pap.lorinc.algos.multi_sum.helpers.rand_range)
  (:use pap.lorinc.algos.multi_sum.helpers.logger)
  (:use pap.lorinc.algos.multi_sum.impls.double_sum)
  (:use pap.lorinc.algos.multi_sum.impls.triple_sum))

(def debug false)
(def elems-count 200)
(def elems-range 500)
(assert (<= elems-count elems-range))

; ---------------------------------------------------- ;

(def elems (distinct-rand-ints elems-count elems-range))
(assert (= elems-count (count elems)))

(if debug (println (seq elems)))

(log double-sum-squared elems)
(log double-sum-linearithmic elems)
(log double-sum-linear elems)

(println)

(log triple-sum-cubic-reference elems)
(log triple-sum-cubic elems)
(log triple-sum-squared-linear elems)
(log triple-sum-squared elems)
