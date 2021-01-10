(ns aoc20.aoclib)


(defn read-numbers
  "Reads a list of numbers from stdin"
  []
  (for [line (line-seq (java.io.BufferedReader. *in*)) :when (not (clojure.string/blank? line))]
    (Integer/parseInt line)))
