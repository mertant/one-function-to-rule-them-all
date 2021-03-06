(ns one-function-to-rule-them-all)

(defn concat-elements [a-seq]
  (reduce concat [] a-seq)
  )

(defn str-cat [a-seq]
  (if (empty? a-seq)
    ""
    (let [f (fn [a b]
              (str a " " b))]
    (reduce f (first a-seq) (rest a-seq)))
  ))

(defn my-interpose [x a-seq]
  (if (empty? a-seq)
      []
      (let [f (fn [acc b]
                (concat acc [x b]))]
      (concat [(first a-seq)] (reduce f [] (rest a-seq)))
    )))


(defn my-count [a-seq]
  (let [f (fn [a b ] (inc a ))]
    (reduce f 0 a-seq)))

(defn my-reverse [a-seq]
  (let [f (fn [a b] (cons b a))]
    (reduce f [] a-seq)))

(defn min-max-element [a-seq]
  (let [f (fn [minmax x] (if (> (first minmax) x)
                           [x (second minmax)]
                           (if (< (second minmax) x)
                             [(first minmax) x]
                             minmax)
                           ))]
    (reduce f [(first a-seq) (first a-seq)] a-seq)
    ))


(defn insert [sorted-seq n]
  (let [pred (fn [a] (> n a))
        i (count (take-while pred sorted-seq))]
    (concat (take i sorted-seq) [n] (drop i sorted-seq))
  ))



(defn insertion-sort [a-seq]
  (reduce insert [] a-seq))



(defn toggle [a-set elem]
  (if (contains? a-set elem)
    (disj a-set elem)
    (conj a-set elem)))

(defn parity [a-seq]
  (let [f (fn [acc x] (toggle acc x))]
  (reduce f #{} a-seq)
  ))



(defn minus
  ([x] (- x))
  ([x y] (- x y)
  ))


(defn count-params [& more]
  (count more))

(defn my-*
  ([] 1)
  ([x] x)
  ([x y] (* x y))
  ([x y & more] (reduce * (* x y) more))
  )


(defn pred-and
  ([] (fn [x] true))
  ([p] (fn [x] (p x)))
  ([p q] (fn [x] (and (p x) (q x))))
  ([p q & more] (pred-and (reduce pred-and (pred-and q p) more)))
  )

(filter (pred-and) [1 0 -2])                    ;=> (1 0 -2)
(filter (pred-and pos? odd?) [1 2 -4 0 6 7 -3]) ;=> (1 7)
(filter (pred-and number? integer? pos? even?)
        [1 0 -2 :a 7 "a" 2])                    ;=> (0 2)


(defn my-map [f a-seq]
  [:-])
