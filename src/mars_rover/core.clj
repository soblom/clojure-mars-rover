(ns mars-rover.core
  (:require mars-rover.rover :as rv)
  (:gen-class))

(def sample-input-parsed 
  {:rectangle [5 5]
   :rovers    [{:start    [1 2 :N]
                :commands [:L :M :L :M :L :M :L :M :M]}
               {:start    [3 3 :E]
                :commands [:M :M :R :M :M :R :M :R :R :M]}]})

(defn -main
  []
  (println "Running the sample input")
  (println (rv/drive-rover-fleet sample-input-parsed)))
