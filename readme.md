## Polynomial arithmetic in Clojure

"Just" a little coding kata, possibly for use later in certain `ReQ` problem sets, in which we try to write decent Clojure functions to multiply, add, subtract and maybe even divide polynomials.

A "polynomial" in this sense is a vector of numeric elements, representing the numerical coefficients of a single-variable polynomial expression. So `y = 8 + 2x - 3 x^2 - 4 x^3 + 5 x^5` is represented as `[8 2 -3 -4 0 5]` in Clojure. The 0-th order coefficient is always first, and any missing coefficients (that is, zero-valued ones) are 0 in the vector. A fifth-order polynomial will always have 6 numbers in the vector.