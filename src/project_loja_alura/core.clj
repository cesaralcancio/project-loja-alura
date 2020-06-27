(ns project-loja-alura.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
(foo "Var")

(println "Soma só quando eh par")
(->> [2 2 5 5 4 1092891832 9]
     (map #(if (= (rem % 2) 0) % 0))
     (filter #(not (= % 0)))
     (reduce +)
     println)

; (-> 1 inc println)
; (-> (rem 10 9) println)