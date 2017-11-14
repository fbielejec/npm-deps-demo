(ns app.views
  (:require [reagent.core :as reagent]
            [react-helmet]))

(def meta-tags* (reagent/adapt-react-class (aget react-helmet "default")))

(defn meta-tags [{:keys [:title :description]
                  :or {title "Some title"
                       description "some description"}}]
  [meta-tags* {:id "app-meta-tags"}
   [:title {:id "title" :title title}]
   [:meta {:id "description" :content description}]])

(defn main-panel []
  (fn []
    [:div.container
     [meta-tags]
     [:h1 "Check for the meta-tags presence"]]))
