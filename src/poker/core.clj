(ns poker
  (:gen-class))


(def deck
  (for [suite [:diamonds :hearts :clubs :spades]
        value (range 1 14)]
    [(case value
       1 :Ace
       11 :Jack
       12 :Queen
       13 :King)
     suite]))


