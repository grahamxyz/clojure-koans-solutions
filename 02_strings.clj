(ns koans.02-strings
  (:require [koan-engine.core :refer :all]
            [clojure.string :as string]))

(meditations
 "A string is nothing more than text surrounded by double quotes"
  ;; (= __ "hello")
 (= "hello" "hello")

 "But double quotes are just magic on top of something deeper"
  ;; (= __ (str 'world))
 (= "world" (str 'world))

 "You can do more than create strings, you can put them together"
  ;; (= "Cool right?" (str __ __))
 (= "Cool right?" (str "Cool" "right?"))

 "You can even get certain characters"
  ;; (= \C (get "Characters" __))
 (= \C (get "Characters" 0))

 "Or even count the characters"
  ;; (= __ (count "Hello World"))
 (= 11 (count "Hello World"))

 "But strings and characters are not the same"
  ;; (= __ (= \c "c"))
 (= false (= \c "c"))

 "What if you only wanted to get part of a string?"
  ;; (= "World" (subs "Hello World" __ __))
 (= "World" (subs "Hello World" 6 11))

 "How about joining together elements in a list?"
  ;; (= __ (string/join '(1 2 3)))
 (= "123" (string/join '(1 2 3)))

 "What if you wanted to separate them out?"
  ;; (= "1, 2, 3" (string/join __ '(1 2 3)))
 (= "1, 2, 3" (string/join __ '(1 2 3)))

 "Maybe you want to separate out all your lines"
  ;; (= [__ __ __] (string/split-lines "1\n2\n3"))
 (= ["1" "2" "3"] (string/split-lines "1\n2\n3"))

 "You may want to make sure your words are backwards"
  ;; (= __ (string/reverse "hello"))
 (= (str 'olleh) (string/reverse "hello")) ; "olleh" works too, of course

 "Maybe you want to find the index of the first occurrence of a substring"
  ;; (= 0 (string/index-of "hello world" __))
 (= 0 (string/index-of "hello world" \h))

 "Or maybe the last index of the same"
  ;; (= __ (string/last-index-of "hello world, hello" "hello"))
 (= 13 (string/last-index-of "hello world, hello" "hello"))
 ;; Counting from first character of the last match of "hello", index 13


 "But when something doesn't exist, nothing is found"
  ;; (= __ (string/index-of "hello world" "bob"))
 (= nil (string/index-of "hello world" "bob"))

 "Sometimes you don't want whitespace cluttering the front and back"
  ;; (= __ (string/trim "  \nhello world \t \n"))
 (= "hello world" (string/trim "  \nhello world \t \n"))

 "You can check if something is a char"
  ;; (= __ (char? \c))
 (= true (char? \c))

 "But it may not be"
  ;; (= __ (char? "a"))
 (= false (char? "a"))

 "But chars aren't strings"
  ;; (= __ (string? \b))
 (= false (string? \b))

 "Strings are strings"
  ;; (= true (string? __))
 (= true (string? "__"))

 "Some strings may be blank"
  ;; (= __ (string/blank? ""))
 (= true (string/blank? ""))

 "Even if at first glance they aren't"
  ;; (= __ (string/blank? " \n \t  "))
 (= true (string/blank? " \n \t  "))

 "However, most strings aren't blank"
  ;; (= __ (string/blank? "hello?\nare you out there?")))
 (= false (string/blank? "hello?\nare you out there?")))
