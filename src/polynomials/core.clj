(ns polynomials.core)


(defn shift-right
  "produces a vector from the argument collection with an extra 0 added at the left end"
  [v]
  (into [] (cons 0 v))
  )


(defn scale-poly
  "multiplies a polynomial (vector) by a numerical constant"
  [poly scale]
  (map (fn [x] (* scale x)) poly))


(defn shifted-versions
  "given two (polynomial) vectors, creates a collection of vectors; each element of the result is a copy of the first vector, shifted right (with leading 0 values), one for each element of the second vector. In other words, if the first argument vector has 3 elements and the second vector has 9 elements, there will be 9 items in the result, with 0..8 leading zeroes added to the first argument."
  [v1 v2]
  (let [c (dec (+ (count v1) (count v2)))]
    (reduce
      (fn [coll item]
        (conj coll (take c (shift-right (last coll)))))
      [(take c (concat v1 (repeat 0)))]
      (drop 1 v2))))


(defn multiply-corresponding
  "multiplies a collection of vectors by a (same-length) collection of numbers"
  [shifted-versions v2]
  (map scale-poly shifted-versions v2)
  )


(defn add-em-up
  "does element-wise addition to a collection of vectors, up to the LONGEST one's length"
  [vectors]
  (let [backwards (reverse (sort-by count vectors))]
    (reduce (fn [a b] (map + a (concat b (repeat 0)))) backwards)))



(defn polynomial-multiply
  "performs polynomial multiplication on two vectors"
  [v1 v2]
  (add-em-up (multiply-corresponding (shifted-versions v1 v2) v2)))
