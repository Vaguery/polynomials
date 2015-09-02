(ns polynomials.core)


(defn shift-right
  "produces a vector with 0 at the left end"
  [v]
  (into [] (cons 0 v))
  )


(defn scale-poly
  [poly scale]
  (map (fn [x] (* scale x)) poly))


(defn shifted
  [v1 v2]
  (let [c (dec (+ (count v1) (count v2)))]
    (reduce
      (fn [coll item]
        (conj coll (take c (shift-right (last coll)))))
      [(take c (concat v1 (repeat 0)))]
      (drop 1 v2))))


; (map + [1 2 3] [4 5 6])
(defn multiply-corresponding
  [shifted v2]
  (map scale-poly shifted v2)
  )

(defn add-em-up
  [vectors]
  (reduce (fn [a b] (map + a b)) vectors))


(defn other-add-em-up
  [vectors]
  (let [backwards (reverse vectors)]
    (reduce (fn [a b] (map + a (concat b (repeat 0)))) backwards)))



(defn do-it-all
  [v1 v2]
  (add-em-up (multiply-corresponding (shifted v1 v2) v2)))
