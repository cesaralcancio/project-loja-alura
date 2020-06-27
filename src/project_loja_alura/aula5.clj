(ns project_loja_alura.aula5
  (:require [project_loja_alura.logic :as l.logic]
            [project_loja_alura.db :as l.db]))

(defn gastou-bastante [info-usuario]
  (if (> (:preco-total info-usuario) 500) info-usuario nil))

(let [pedidos (l.db/todos-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
    (println "Filter" (filter gastou-bastante resumo))
    (println "Map" (map gastou-bastante resumo))
    (println "Keep" (keep gastou-bastante resumo))
)

(println "---")

(defn gastou-bastante [info-usuario]
  (println "gastou-bastante?" (:usuario-id info-usuario))
       (-> info-usuario
            :preco-total
            (> 500)))

(let [pedidos (l.db/todos-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "Keep" (keep gastou-bastante resumo)))

(println "Vamos isolar...")
(println (range 10))
(println (take 2 (range 10000000000000)))
; IT IS LAZY NOT EAGER, ou seja, quando executa o "take 2" ainda nao executou t_odo o range

(defn filtro1 [x]
  (println "filtro1" x) x)

(defn filtro2 [x]
  (println "filtro2" x) x)

(println (map filtro2 (map filtro1 (range 10))))

(println "threading")
; CHUNKS 32/32
(->> (range 50)
     (map filtro1)
     (map filtro2)
     println)

(println "100% eager mapv")
; SEM CHUNKS
(->> (range 50)
     (mapv filtro1)
     (mapv filtro2)
     println)

(println "Vetor lazy & eager (chunks)")
; CHUNKS
(->> [1 8 8 9 7 6 9 7  0 8 7 121 12 1 1 2 3 3 1 2 1 2 12 1 2 2 3 1 121 3 3 12 1 212 12 1 12 ]
     (map filtro1)
     (map filtro2)
     println)

(println "Lista ligada lazy 100%")
(->> '(0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9)
     (map filtro1)
     (map filtro2)
     println)

