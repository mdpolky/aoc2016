(ns aoc2016.day03
  (:require [clojure.string :as cs]))

(def input (slurp "resources/day03.txt"))
(def puzzle (partition 3
                       (map #(Integer/parseInt %)
                            (-> input
                                (cs/split #"\s+")
                                (#(remove empty? %))))))

(defn valid?
  [[a b c]]
  (and
    (> (+ a b) c)
    (> (+ a c) b)
    (> (+ b c) a)))

(comment
  (count (filter valid? puzzle))
  ;; => 1050
  )

(def puzzle2 (partition 3
                        (concat (map #(nth % 0) puzzle)
                                (map #(nth % 1) puzzle)
                                (map #(nth % 2) puzzle))))

(comment
  (count (filter valid? puzzle2))
  ;; => 1921
  )
