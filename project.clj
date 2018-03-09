(defproject npm-deps-demo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojurescript "1.9.946"]
                 [reagent "0.7.0"]]

  :exclusions [[org.clojure/clojure]
               [org.clojure/clojurescript]]

  :plugins [[lein-auto "0.1.2"]
            [lein-cljsbuild "1.1.7"]
            [lein-figwheel "0.5.14"]]

  :min-lein-version "2.5.3"

  :source-paths ["src"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  :figwheel {:server-port 4000
             :css-dirs ["resources/public/css"]}

  :profiles {:dev {:dependencies [[org.clojure/clojure "1.8.0"]
                                  [binaryage/devtools "0.9.7"]
                                  [com.cemerick/piggieback "0.2.2"]
                                  [figwheel-sidecar "0.5.14"]
                                  [org.clojure/tools.nrepl "0.2.13"]]
                   :source-paths ["dev" "src"]
                   :resource-paths ["resources"]}}

  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src"]
                        :figwheel {:on-jsload "app.core/mount-root"}
                        :compiler {:main "app.core"
                                   :output-to "resources/public/js/compiled/app.js"
                                   :output-dir "resources/public/js/compiled/out"
                                   :asset-path "js/compiled/out"
                                   :source-map-timestamp true
                                   :optimizations :none
                                   :closure-defines {goog.DEBUG true}
                                   :install-deps true
                                   :npm-deps {"@0xproject/connect" "0.6.2"
                                              :react "16.0.0"
                                              :react-helmet "5.2.0"}}}

                       {:id "min"
                        :source-paths ["src"]
                        :compiler {:main "app.core"
                                   :output-to "resources/public/js/compiled/app.js"
                                   :optimizations :advanced
                                   :closure-defines {goog.DEBUG false}
                                   ;; :pretty-print false
                                   ;; :pseudo-names false
                                   :pseudo-names true
                                   :pretty-print true
                                   :install-deps true
                                   ;;:externs ["libs/externs.js"]
                                   :npm-deps {:express "4.16.2"
                                              :react "16.0.0"
                                              :react-helmet "5.2.0" }}}]})
