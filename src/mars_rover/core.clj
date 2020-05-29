(ns mars-rover.core
  (:gen-class))

(defn turn-left [direction]
  (case direction
    :N :W
    :W :S
    :S :E
    :E :N))

(defn turn-right [direction]
  (case direction
    :N :E
    :E :S
    :S :W
    :W :N))

(defn move-rover [x y direction]
  (case direction
    :N [x (+ y 1)]
    :S [x (- y 1)]
    :E [(+ x 1) y]
    :W [(- x 1) y]))

(defn rover-step [x y direction command]
  (case command
    :L [x y (turn-left direction)]
    :R [x y (turn-right direction)]
    :M (conj (move-rover x y direction) direction)))

(defn drive-rover [{start :start commands :commands}]
  (loop [[x y direction] start
         [next-step & rest] commands]
    (if (nil? next-step)
      [x y direction]
      (recur (rover-step x y direction next-step) rest))))

(defn drive-all-rovers [{:keys [_ rovers]}]
  (map drive-rover rovers))

(def sample-input-parsed
  {:rectangle [5 5]
   :rovers [{:start [1 2 :N]
             :commands [:L :M :L :M :L :M :L :M :M]}
            {:start [3 3 :E]
             :commands [:M :M :R :M :M :R :M :R :R :M]}]})

(defn -main
  []
  (println "Running the sample input")
  (println (drive-all-rovers sample-input-parsed)))
