(ns project_loja_alura.aula2)

(-> (range 10)
    seq?
    println)

(-> (range 10)
    seq
    println)

(-> (range 10)
    next
    println)

(-> (range 10)
    next
    println)

(-> (range 10)
    rest
    println)
; rest vs next, next = nil, rest = ()

(-> []
    rest
    println)

(defn conta
  ([elementos] (conta 0 elementos))
  ([total-ate-agora elementos]
  (if (seq? elementos)
    (recur (inc total-ate-agora) (next elementos))
    total-ate-agora)))

(->> (range 10)
    (conta)
    println)
(-> (range 10)
    count
    println)
(->> []
    (conta)
    println)

(defn conta
  [elementos]
  (loop [ltotal 0
         lelementos elementos]
    (if (seq lelementos)
      (recur (inc ltotal) (next lelementos))
      ltotal)))

; (-> (range 10) conta println)

(def algo ["a", "b", "c"])
(-> algo (conta) (println))
