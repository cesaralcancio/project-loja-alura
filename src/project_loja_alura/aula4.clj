(ns project_loja_alura.aula4
  (:require [project_loja_alura.logic :as l.logic]
            [project_loja_alura.db :as l.db]))

(let [pedidos (l.db/todos-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "Resumo" resumo)
  (println "Ordenado" (sort-by :preco-total resumo))
  (println "Ordenado reverse" (reverse (sort-by :preco-total resumo)))
  (println "By Id" (reverse (sort-by :usuario-id resumo)))

  ; update-in, assoc-in
  (println (get-in pedidos [0 :itens :mochila :quantidade]))
)

(defn resumo-por-usuario-ordenado [pedidos]
  (->> pedidos
       l.logic/resumo-por-usuario
       (sort-by :preco-total)
       reverse))

(let [pedidos (l.db/todos-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "Resumo" resumo)
  (println "First" (first resumo))
  (println "Second" (second resumo))
  (println "Last" (last resumo))
  (println "Resto" (rest resumo))
  (println "Next" (next resumo))
  (println "Total" (count resumo))
  (println "Classe" (class resumo))
  (println "Nth 1" (nth resumo 1))
  (println "Get 1" (get resumo 1))
  (println "Get1 " (get ["a","b"] 1))
  (println "Take" (take 2 resumo))
)

(defn top-2 [resumo] (take 2 resumo))

(let [pedidos (l.db/todos-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "Resumo" resumo)
  (println "Top2" (top-2 resumo)))

(let [pedidos (l.db/todos-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "> 500" (filter #(> (:preco-total %) 500) resumo))
  (println "some" (some #(> (:preco-total %) 500) resumo))
  (println "> 500 not empty" (not (empty? (filter #(> (:preco-total %) 500) resumo))))
)







