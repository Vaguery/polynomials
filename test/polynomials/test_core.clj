(ns polynomials.test-core
  (:use midje.sweet)           
  (:use polynomials.core))


(fact "add zeroes"
  (shift-right [2 3 4]) => [0 2 3 4]
  )


(fact "shifted components"
  (shifted [2 3 4] [1 2 3]) => [[2 3 4 0 0] [0 2 3 4 0] [0 0 2 3 4]]
  (shifted [2 3 4] [0 1 1]) => [[2 3 4 0 0] [0 2 3 4 0] [0 0 2 3 4]]
  (shifted [0 1 1] [0 1])   => [[0 1 1 0] [0 0 1 1]]
  )


(fact "multiply corresponding works"
  (multiply-corresponding [[1 2] [0 1 2]] [2 3]) => [[2 4] [0 3 6]]
  (multiply-corresponding [[1 2] [0 1 2]] [-2 -3]) => [[-2 -4] [0 -3 -6]]
  (multiply-corresponding (shifted [1 2] [3 4]) [3 4]) => [[3 6 0] [0 4 8]]
  )


(fact "add-em-up"
  (add-em-up [[1 2 3 4] [5 6]]) => [6 8]
  )


(fact "we can multiply a 0-order polynomial times a polynomial"
  (scale-poly [1 1] 2) => [2 2]
  (scale-poly [2 3] 3) => [6 9]
  )
  

(fact "easy peasy"
  (do-it-all [1 2] [3 4 5]) => [3 10 13 10]
  )
