(ns koans.15-destructuring
  (:require [koan-engine.core :refer :all]))

(def test-address
  {:street-address "123 Test Lane"
   :city "Testerville"
   :state "TX"})

(meditations
 "Destructuring is an arbiter: it breaks up arguments"
  ;; (= __ ((fn [[a b]] (str b a))
 (= ":bar:foo" ((fn [[a b]] (str b a)) ; Feels like a trick answer! lol
                [:foo :bar]))

 "Whether in function definitions"
;;  (= (str "An Oxford comma list of apples, " "oranges, " "and pears.")
    ;;  ((fn [[a b c]] __)
 (= (str "An Oxford comma list of apples, " "oranges, " "and pears.")
    ((fn [[a b c]] (str "An Oxford comma list of " a ", " b ", and " c "."))
     ["apples" "oranges" "pears"]))

 "Or in let expressions"
 (= "Rich Hickey aka The Clojurer aka Go Time aka Lambda Guru"
    (let [[first-name last-name & aliases]
          (list "Rich" "Hickey" "The Clojurer" "Go Time" "Lambda Guru")]
      ;;  __))
      (str first-name " " last-name
           (apply str (map #(str " aka " %) aliases)))))
; This function was tricky. I got most of the answer independently,
; but I didn't realize that I needed to use (apply str (...)) until
; I looked for another solution to this problem set.

 "You can regain the full argument if you like arguing"
 (= {:original-parts ["Stephen" "Hawking"] :named-parts {:first "Stephen" :last "Hawking"}}
    (let [[first-name last-name :as full-name] ["Stephen" "Hawking"]]
      ;;  __))
      {:original-parts full-name :named-parts {:first first-name :last last-name}}))

 "Break up maps by key"
 (= "123 Test Lane, Testerville, TX"
    (let [{street-address :street-address, city :city, state :state} test-address]
      ;;  __))
      (str (:street-address test-address) ", " (:city test-address) ", " (:state test-address))))

 "Or more succinctly"
;;  (= "123 Test Lane, Testerville, TX"
;;     (let [{:keys [street-address __ __]} test-address]
;;        __))
 (= "123 Test Lane, Testerville, TX"
    (let [{:keys [street-address city state]} test-address]
      (str street-address, ", " city ", " state)))

 "All together now!"
 (= "Test Testerson, 123 Test Lane, Testerville, TX"
    ;;  (___ ["Test" "Testerson"] test-address)))
    ((fn [[first-name last-name] {:keys [street-address city state]}]
       (str first-name " " last-name ", " street-address ", " city ", " state)) ["Test" "Testerson"] test-address)))

