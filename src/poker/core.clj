(ns poker
  (:gen-class))


(def deck
  (for [suite [:diamonds :hearts :clubs :spades]
        value (range 1 14)]
    [(case value
       1 :Ace
       11 :Jack
       12 :Queen
       13 :King
       value)
     suite]))

(def shuffled-deck
  (shuffle
   deck))


;; (def draw-hand [deck]
;;   {:hand (take 5 shuffled-deck)
;;    :deck (drop 5 shuffled-deck)})

;; (def make-round [deck]
;;   (let [first-hand-result (draw-hand deck)
;;         deck-after-first-hand (:deck first-hand-result)
;;         second-hand-result (draw-hand deck-after-first-hand)
;;         deck-after-second-hand (:hand second-hand-result)]
;;        ))



(def first-round
  (let [first (take 5 shuffled-deck)
      deck-after-first-hand (drop 5 shuffled-deck)
      second (take 5 deck-after-first-hand)
        deck-after-second-hand (drop 5 deck-after-first-hand)]
    {:player-1 first
     :player-2 second
     :deck deck-after-second-hand}))

(def second-round
  (let [shuffled-deck (:deck first-round);; I cant wrap my head arround this
        ;;calling :deck first-round how is it able to reference the deck
        ;;from the previous round(deck-after-second-hand)??
        ;;wouldnt the right way be :deck deck-after-second-hand?

        first (take 5 shuffled-deck)
        deck-after-first-hand (drop 5 shuffled-deck)
        second (take 5 deck-after-first-hand)
        deck-after-second-hand (drop 5 deck-after-first-hand)]
    {:player-1 first
     :player-2 second
     :deck deck-after-second-hand}
    ))




