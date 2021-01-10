(ns aoc20.core
  (:require [aoc20.day01]
            [aoc20.day02])
  (:gen-class))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (def program-table
    {"1" aoc20.day01/day01
     "2" aoc20.day02/day02})
  ((get program-table (first args))))


