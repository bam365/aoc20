(ns aoc20.aoclib-test
  (:require [clojure.test :refer :all]
            [aoc20.aoclib :refer :all]))

(deftest read-lines-test
  (testing "read-lines works"
    (with-in-str "hi\nthere\n\nsir\n\n" (is (= (list "hi" "there" "sir") (read-lines))))))

(deftest read-numbers-test
  (testing "works"
    (with-in-str "1\n2\n\n3\n4\n\n" (is (= (list 1 2 3 4) (read-numbers))))))

(deftest count-pred-test
  (testing "cound-pred works"
    (is (= 3 (count-pred #(>= % 3) [1 2 3 4 5])))))
