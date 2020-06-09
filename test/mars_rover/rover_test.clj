(ns mars-rover.rover_test
  (:require [clojure.test :refer :all]
            [mars-rover.rover :as r]))
  
(def sample-input-parsed 
  {:rectangle [5 5]
   :rovers    [{:start    [1 2 :N]
                :commands [:L :M :L :M :L :M :L :M :M]}
               {:start    [3 3 :E]
                :commands [:M :M :R :M :M :R :M :R :R :M]}]})

(def rover1 (first (:rovers sample-input-parsed)))
(def rover2 (second (:rovers sample-input-parsed)))

(deftest drive-rover-test
  (is (= (r/drive-rover rover1)
         [1 3 :N]))
  (is (= (r/drive-rover rover2)
         [5 1 :E])))

(deftest drive-all-rover-test
  (is (= (r/drive-rover-fleet sample-input-parsed)
         [[1 3 :N][5 1 :E]])))