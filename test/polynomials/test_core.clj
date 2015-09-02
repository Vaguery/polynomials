(ns polynomials.test-core
  (:use midje.sweet)           
  (:use polynomials.core))


(fact "add zeroes"
  (shift-right [2 3 4]) => [0 2 3 4]
  )


(fact "shifted-versions components"
  (shifted-versions [2 3 4] [1 2 3]) => [[2 3 4 0 0] [0 2 3 4 0] [0 0 2 3 4]]
  (shifted-versions [2 3 4] [0 1 1]) => [[2 3 4 0 0] [0 2 3 4 0] [0 0 2 3 4]]
  (shifted-versions [0 1 1] [0 1])   => [[0 1 1 0] [0 0 1 1]]
  )


(fact "multiply corresponding works"
  (multiply-corresponding [[1 2] [0 1 2]] [2 3]) => [[2 4] [0 3 6]]
  (multiply-corresponding [[1 2] [0 1 2]] [-2 -3]) => [[-2 -4] [0 -3 -6]]
  (multiply-corresponding (shifted-versions [1 2] [3 4]) [3 4]) => [[3 6 0] [0 4 8]]
  )


(fact "add-em-up"
  (add-em-up [[1 2 3 4] [5 6]]) => [6 8 3 4]
  (add-em-up [[5 6] [1 2 3 4]]) => [6 8 3 4]
  )


(fact "we can multiply a 0-order polynomial times a polynomial"
  (scale-poly [1 1] 2) => [2 2]
  (scale-poly [2 3] 3) => [6 9]
  )
  

(fact "easy peasy"
  (polynomial-multiply [1 2] [3 4 5]) => [3 10 13 10]
  (polynomial-multiply [1 1] [-1 1]) => [-1 0 1]
  (polynomial-multiply [1 1 1 1] [1 1 1 1]) => [1 2 3 4 3 2 1]
  (polynomial-multiply [1 1 1 1] [-1 1 -1 1]) => [-1 0 -1 0 1 0 1]
  (polynomial-multiply [2 3 4] [0 0 0 0 0 0 0 0 0 1]) => [0 0 0 0 0 0 0 0 0 2 3 4]
  (polynomial-multiply [0 0 0 0 0 0 0 0 0 1] [2 3 4] ) => [0 0 0 0 0 0 0 0 0 2 3 4]
  )
