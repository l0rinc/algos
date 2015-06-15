(ns binary-search.search)

; Given N distinct integers, how many triples sum to exactly zero?
(def elemsCount 1000)
(def elemsRange 10000)

(defn rand-range [min, max]
  (+ min (rand-int (- max min))))
(defn symmetric-rand-range [range]
  (let [half (quot range 2)]
    (rand-range (- half) half)))

(def elems (last
             (take-while #(<= (count %) elemsCount)
                         (iterate #(conj % (symmetric-rand-range elemsRange))
                                  #{}))))
(println (count elems))
(println elems)
