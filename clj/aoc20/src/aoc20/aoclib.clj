(ns aoc20.aoclib)

(defn read-lines
  "Reads lines from stdin"
  []
  (for [line (line-seq (java.io.BufferedReader. *in*)) :when (not (clojure.string/blank? line))]
    line))

(defn read-numbers
  "Reads a list of numbers from stdin"
  []
  (for [line (read-lines)] (Integer/parseInt line)))

(defn count-pred
  "Counts number of elements in a sequence that match a predicate"
  [pred coll]
  (count (filter pred coll)))
