(defproject mars-rover "0.1.0-SNAPSHOT"
  :description "Sample Problem to play around with Clojure"
  :dependencies [[org.clojure/clojure "1.10.1"]]
  :main ^:skip-aot mars-rover.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
