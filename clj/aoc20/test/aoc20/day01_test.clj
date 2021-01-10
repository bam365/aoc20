(ns aoc20.day01-test
 (:require [aoc20.day01 :as sut]
            [clojure.test :as t]))

(t/deftest pair-prod-test
  (t/testing "pair-prod works"
    (t/is (= 15 (sut/pair-prod [3 5])))))


(t/deftest day01-test
  (t/testing "day01 works"
    (with-in-str "1721\n979\n366\n299\n675\n1456"
      (t/is (= "514579"
               (with-out-str (sut/day01)))))))
