(defproject mars-rover "0.1.0-SNAPSHOT"
  :description "Simulating rovers driving on mars via simple commands"
  :dependencies [[org.clojure/clojure "1.10.1"]]
  :main ^:skip-aot mars-rover.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :plugins [[lein-codox "0.10.7"]])

