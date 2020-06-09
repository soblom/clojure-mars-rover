(ns mars-rover.rover
  "Models a rover that can drive based on a sequence of commands."
  (:gen-class))

(defn- turn-left [direction]
  (case direction
    :N :W
    :W :S
    :S :E
    :E :N))

(defn- turn-right [direction]
  (case direction
    :N :E
    :E :S
    :S :W
    :W :N))

(defn- move-rover [x y direction]
  (case direction
    :N [x (+ y 1)]
    :S [x (- y 1)]
    :E [(+ x 1) y]
    :W [(- x 1) y]))

(defn- rover-step [x y direction command]
  (case command
    :L [x y (turn-left direction)]
    :R [x y (turn-right direction)]
    :M (conj (move-rover x y direction) direction)))

(defn drive-rover 
  "takes a staring position and commands for the rover and executes
   the commands relative to that starting position.
   
   start is a triple of an x and y coordinate together with a direction
   the rover is facing (:N :S :E :W)"
  [{start :start commands :commands}]
  (loop [[x y direction] start
         [next-step & rest] commands]
    (if (nil? next-step)
      [x y direction]
      (recur (rover-step x y direction next-step) rest))))

(defn 
  drive-rover-fleet 
  "Given a sequence of rover configs this will drive them one after the other"
  [{:keys [_ rovers]}]
  (map drive-rover rovers))