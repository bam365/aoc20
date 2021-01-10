(ns aoc20.day02-test
  (:require  [clojure.test :as t]
             [aoc20.day02 :as sut])
  (:import  [aoc20.day02 PasswordSpec]))

(defn assert-all
  [f table]
  (doseq [[assertval val] table]
    (t/is (= assertval (f val)))))

(t/deftest count-char-test
  (t/testing "count-char works"
    (t/is (= 3 (sut/count-char "abccc" \c)))))

(t/deftest pw-spec-valid-test
  (t/testing "pw-spec-valid? works"
    (assert-all sut/pw-spec-valid?
                [[true (PasswordSpec. 1 3 \c "abccc")]
                 [true (PasswordSpec. 1 3 \c "abc")]
                 [false (PasswordSpec. 1 3 \c "ab")]])))

(t/deftest parse-pw-spec-test
  (t/testing "parse-pw-spec works"
    (assert-all sut/parse-pw-spec
                [[(PasswordSpec. 1 3 \c "abccc") "1-3 c: abccc"]
                 [(PasswordSpec. 11 14 \v "abccc") "11-14 v: abccc"]])))

(defn long-str [& strings] (clojure.string/join "\n" strings))

(def test-input (long-str "1-3 a: abcde"
                          "1-3 b: cdefg"
                          "2-9 c: ccccccccc"))

(t/deftest day02-test
  (t/testing "day02 works"
    (with-in-str test-input
      (t/is (= "2"
               (with-out-str (sut/day02)))))))
