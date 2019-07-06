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


(defn draw-hand [deck]
  {:hand (take 5 deck)
   :deck (drop 5 deck)})

(defn make-round [deck]
  (let [first-hand-result (draw-hand deck)
        deck-after-first-hand (:deck first-hand-result)
        second-hand-result (draw-hand deck-after-first-hand)
        deck-after-second-hand (:deck second-hand-result)]
    {:player-1 (:hand first-hand-result)
     :player-2 (:hand second-hand-result)
     :deck deck-after-second-hand}))

(def frist-round
  (make-round shuffled-deck))
(def second-round
  (make-round (:deck first-round)))

(def hand
  (:player-1 first-round))


(def rules
  (let [values (map first hand)
      suits (map second hand)
      freq (frequencies values)]
  (cond
    (some #(= 3) (vals freq))
    :three-of-a-kind
    (some #(= 2) (vals freq))
    :two-of-a-kind))
  )

rules (:player-1 first-round)




;; (def first-round
;;   (let [first (take 5 shuffled-deck)
;;       deck-after-first-hand (drop 5 shuffled-deck)
;;       second (take 5 deck-after-first-hand)
;;         deck-after-second-hand (drop 5 deck-after-first-hand)]
;;     {:player-1 first
;;      :player-2 second
;;      :deck deck-after-second-hand}))

;; (def second-round
;;   (let [shuffled-deck (:deck first-round);; I cant wrap my head arround this
;;         ;;calling :deck first-round how is it able to reference the deck
;;         ;;from the previous round(deck-after-second-hand)??
;;         ;;wouldnt the right way be :deck deck-after-second-hand?

;;         first (take 5 shuffled-deck)
;;         deck-after-first-hand (drop 5 shuffled-deck)
;;         second (take 5 deck-after-first-hand)
;;         deck-after-second-hand (drop 5 deck-after-first-hand)]
;;     {:player-1 first
;;      :player-2 second
;;      :deck deck-after-second-hand}
;;     ))



