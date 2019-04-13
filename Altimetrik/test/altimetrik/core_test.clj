(ns altimetrik.core-test
  (use altimetrik.core)
  (:require [clojure.test :refer :all]
            [altimetrik.core :refer :all]))

(deftest sqrt-range-test
  (testing
    (is (not= (sqrt-range 0) 0))
    (is (not= (sqrt-range 2) 2))
    (is (= (sqrt-range 2) '()))
    (is (= (sqrt-range 7) '(2)))
    (is (= (sqrt-range 49)'(2 3 4 5 6 7)))))

(deftest prime-number-test
  (testing 
    (is (= (is-prime? 2) true))
    (is (= (is-prime? 4) false))))