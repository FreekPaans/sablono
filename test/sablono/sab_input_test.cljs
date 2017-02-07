(ns sablono.sab-input-test
  (:require [devcards.core :refer-macros [defcard]]
            [sablono.core :as sab]))

(defcard text-input-with-value-should-be-controlled
  "An input with just a :value should be a controlled component. In this case
  the input shouldn't be editable."
  (fn [state _]
    (sab/html
      [:input
       {:value @state}]))
  (atom "hello world!"))


(defcard text-input-with-value-and-on-change-should-be-controlled
  "An input that has a :value and :on-change should be a controlled input.
  To test this, the input handler uppercases the input when editing. If the
  input doesn't get uppercased, it doesn't work."
  (fn [state _]
    (sab/html
      [:input
       {:value @state
        :on-change (fn [ev]
                     (println ":on-change")
                     (reset! state
                             (.toUpperCase (aget ev "target" "value"))))}]))
  (atom "edit me!")
  {:inspect-data true :history true})

