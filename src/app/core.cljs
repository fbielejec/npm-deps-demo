(ns app.core
  (:require [reagent.core :as reagent]
            [app.views :as views]))

(enable-console-print!)

(defn mount-root []
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (mount-root))
