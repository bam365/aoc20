(ns aoc20.day02
  (:require [aoc20.aoclib :refer :all]))


(defn count-char
  [s c]
  (count (filter #(= c %) s)))

(defrecord PasswordSpec [min max c pw])

(defn pw-spec-valid?
  [pw-spec]
  (let [ccount (count-char (:pw pw-spec) (:c pw-spec))]
    (and (<= (:min pw-spec) ccount)
         (>= (:max pw-spec) ccount))))

(defn parse-pw-spec
  [line]
  (let [regex #"^([0-9]+)-([0-9]+) ([a-z]): (.*)$"
        matches (re-matches regex line)]
    (PasswordSpec. (Integer/parseInt (get matches 1))
                   (Integer/parseInt (get matches 2))
                   (get (get matches 3) 0)
                   (get matches 4))))

(defn day02
  []
  (print (count-pred pw-spec-valid? (map parse-pw-spec (read-lines)))))
