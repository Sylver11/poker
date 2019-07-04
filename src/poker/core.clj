(ns poker
  (:gen-class))
[{:suit :diamond...}]

(def deck
  (for [value (range 0 14)
        suite [:diamonds :hearts :clubs :spades]]
    [value suite]))
