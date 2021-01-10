(ns aoc20.day01
  (:require [aoc20.aoclib :refer :all]))

(defn pair-prod [[x y]] (* x y))

(defn find-pair-sum
  [numbers sum]
  (first (for [x numbers
               y numbers
               :when (= sum (+ x y))]
           [x y])))

(defn day01
  []
  (print (pair-prod (find-pair-sum (read-numbers) 2020))))
