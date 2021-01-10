(ns aoc20.aoclib-test
  (:require [clojure.test :refer :all]
            [aoc20.aoclib :refer :all]))

(deftest read-numbers-test
  (testing "works"
    (with-in-str "1\n2\n\n3\n4\n\n" (is (= (list 1 2 3 4) (read-numbers))))))
