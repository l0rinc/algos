(ns multi_sum.logger
  (:import (java.util.concurrent TimeUnit)))

(defn current-nanos []
  (System/nanoTime))

(defn elapsed-time [start-time]
  (.toMillis TimeUnit/NANOSECONDS
             (- (current-nanos) start-time)))

(defn log [method params]
  (let [start-time (current-nanos)
        result (method params)
        count (count result)                                ; needed because of lazy traversal
        duration (elapsed-time start-time)]
    (println [(class method)                                ; TODO too much information
              duration "ms"
              count
              result])))
