(ns multi_sum.logger
  (:import (java.util.concurrent TimeUnit))
  (:use [clojure.string :only (replace-first)]))

(defn current-nanos []
  (System/nanoTime))

(defn elapsed-time [start-time]
  (.toMillis TimeUnit/NANOSECONDS
             (- (current-nanos) start-time)))

(defn method-name [method]
  (replace-first (class method)
                 #"^.+?([^$]+)$" "$1"))

(defn log [method & params]
  (let [start-time (current-nanos)
        result (apply method params)
        count (count result)                                ; needed because of lazy traversal
        duration (elapsed-time start-time)]
    (println [(method-name method)
              (str duration "ms")
              count
              result])))