(ns koans.04-vectors
  (:require [koan-engine.core :refer :all]))

(meditations
 "You can use vectors in clojure as array-like structures"
  ;; (= __ (count [42]))
 (= 1 (count [42])) ; vector length is 1

 "You can create a vector from a list"
  ;; (= __ (vec '(1)))
 (= [1] (vec '(1))) ; '(1) also evaluates as equal lol

 "Or from some elements"
  ;; (= __ (vector nil nil))
 (= '(nil nil) (vector nil nil))

 "But you can populate it with any number of elements at once"
  ;; (= [1 __] (vec '(1 2)))
 (= [1 2] (vec '(1 2)))

 "Conjoining to a vector is different than to a list"
  ;; (= __ (conj [111 222] 333))
 (= [111 222 333] (conj [111 222] 333))

 "You can get the first element of a vector like so"
  ;; (= __ (first [:peanut :butter :and :jelly]))
 (=  :peanut (first [:peanut :butter :and :jelly]))

 "And the last in a similar fashion"
  ;; (= __ (last [:peanut :butter :and :jelly]))
 (= :jelly (last [:peanut :butter :and :jelly]))

 "Or any index if you wish"
  ;; (= __ (nth [:peanut :butter :and :jelly] 3))
 (= :jelly (nth [:peanut :butter :and :jelly] 3))

 "You can also slice a vector"
  ;; (= __ (subvec [:peanut :butter :and :jelly] 1 3))
 (= [:butter :and] (subvec [:peanut :butter :and :jelly] 1 3))

 "Equality with collections is in terms of values"
  ;; (= (list 1 2 3) (vector 1 2 __)))
 (= (list 1 2 3) (vector 1 2 3)))
