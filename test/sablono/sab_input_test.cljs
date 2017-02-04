(ns sablono.sab-input-test
  (:require [devcards.core :refer-macros [defcard]]
            [sablono.core :as sab]))

(defcard controller-text-input
  "An input that has a :value and :on-change should be a controlled input.
  To test this, the input handler uppercases the input when editing. If the
  input doesn't get uppercased, it doesn't work."
  (fn [state _]
    (sab/html
      [:input
       {:value @state
        :on-change (fn [ev]
                     (reset! state
                             (.toUpperCase (aget ev "target" "value"))))}]))
  (atom "edit me!")
  {:inspect-data true :history true})

