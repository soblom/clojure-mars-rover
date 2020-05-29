(ns mars-rover.core-test
  (:require [clojure.test :refer :all]
            [mars-rover.core :as c]))
  
(def rover1 (first (:rovers c/sample-input-parsed)))
(def rover2 (second (:rovers c/sample-input-parsed)))

(deftest rover-step-test
  (is (= (c/rover-step 3 5 :E :L)
         [3 5 :N]))
  (is (= (c/rover-step 3 5 :E :R)
         [3 5 :S]))
  (is (= (c/rover-step 3 5 :E :M)
         [4 5 :E])))

(deftest drive-rover-test
  (is (= (c/drive-rover rover1)
         [1 3 :N]))
  (is (= (c/drive-rover rover2)
         [5 1 :E])))

(deftest drive-all-rover-test
  (is (= (c/drive-all-rovers c/sample-input-parsed)
         [[1 3 :N][5 1 :E]])))
