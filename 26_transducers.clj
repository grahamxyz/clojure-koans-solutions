(ns koans.26-transducers
  (:require [koan-engine.core :refer :all]))

(def example-transducer
  (map inc))

(def transforms
  (comp (map inc)
        (filter even?)))

; Koan 26, transducers didn't really teach me much about transducers.
; I would recommend independent study to understand what is actually
; going on under the hood, because these problems don't really require
; any understanding of the fundamentals!

(meditations
 "A sequence operation with only one argument often returns a transducer"
;;  (= __
 (= [2 3 4]
    (sequence example-transducer [1 2 3]))

 "Consider that sequence operations can be composed as transducers"
;;  (= __
 (= [2 4]
    (transduce transforms conj [1 2 3]))

 "We can do this eagerly"
;;  (= __
 (= [2 4]
    (into [] transforms [1 2 3]))

 "Or lazily"
;;  (= __
 (= [2 4]
    (sequence transforms [1 2 3]))

 "The transduce function can combine mapping and reduction"
;;  (= __
 (= 6
    (transduce transforms + [1 2 3])))
