(ns koans.14-recursion
  (:require [koan-engine.core :refer :all]))

;; (defn is-even? [n]
;;   (if (= n 0)
;;     __
;;     (___ (is-even? (dec n)))))
(defn is-even? [n]
  (if (= n 0)
    true
    (not (is-even? (dec n)))))

;; (defn is-even-bigint? [n]
;;   (loop [n   n
;;          acc true]
;;     (if (= n 0)
;;       __
;;       (recur (dec n) (not acc)))))
(defn is-even-bigint? [n]
  (loop [n   n
         acc true]
    (if (= n 0)
      acc
      (recur (dec n) (not acc)))))

;; (defn recursive-reverse [coll]
;;   __)
(defn recursive-reverse [coll]
  (loop [coll coll, reverse '()]
    (if (= coll '())
      reverse
      (recur (rest coll) (cons (first coll) reverse))))

;; (defn factorial [n]
;;   __)
  
; Trying to write this function really stumped me at first.
; Based on my reading, the loop/recur functions are an idiomatic,
; low-level form unique to Clojure.
;
; loop allows you to set symbols' initial values, for the
; purposes of a loop block of code. For example, [n n sum 1] can
; be understood as [n n, sum 1] where n is initialized with the
; same value as the external 'n' symbol, and sum is initialized
; to 1.
; 
; recur tells Clojure to re-call the function in the local-most
; loop block, with new values given. In this case, I am telling
; Clojure to restart the loop with n= (dec n) and sum = (* sum n).
(defn factorial [n]
  (loop [n n sum 1]
    (if (< n 1)
      sum
      (recur (dec n) (* sum n)))))

(meditations
 "Recursion ends with a base case"
 (= true (is-even? 0))

 "And starts by moving toward that base case"
 (= false (is-even? 1))

 "Having too many stack frames requires explicit tail calls with recur"
 (= false (is-even-bigint? 100003N))

 "Reversing directions is easy when you have not gone far"
 (= '(1) (recursive-reverse [1]))

 "Yet it becomes more difficult the more steps you take"
 (= '(6 5 4 3 2) (recursive-reverse [2 3 4 5 6]))

 "Simple things may appear simple."
 (= 1 (factorial 1))

 "They may require other simple steps."
 (= 2 (factorial 2))

 "Sometimes a slightly bigger step is necessary"
 (= 6 (factorial 3))

 "And eventually you must think harder"
 (= 24 (factorial 4))

 "You can even deal with very large numbers"
 (< 1000000000000000000000000N (factorial 1000N))

 "But what happens when the machine limits you?"
 (< 1000000000000000000000000N (factorial 100003N)))
