(ns project_loja_alura.aula3
  (:require
    [project_loja_alura.db :as l.db]))

(defn minha-funcao
  [elemento]
  (:usuario elemento))

(println (group-by minha-funcao (l.db/todos-pedidos)))

(->> (l.db/todos-pedidos)
     (group-by minha-funcao)
     (map count)
     (println))

(defn conta-total-por-usuario
  [[usuario pedidos]]
  [usuario (count pedidos)])

(println "PEDIDOS")
(defn total-do-item
  [[item-id detalhes]]
  (* (:quantidade detalhes) (:preco-unitario detalhes 0)))

(defn total-do-pedido
  [pedido]
  (->> pedido
       (map total-do-item)
       (reduce +)))

(defn total-dos-pedidos
  [pedidos]
  (->> pedidos
       (map :itens pedidos)
       (map total-do-pedido)
       (reduce +)))

(defn quantidade-de-pedidos-e-gasto-total-por-usuario
  [[usuario pedidos]]
  (println)
  (println "pedidos:" pedidos)
  {
   :usuario       usuario
   :total-pedidos (count pedidos)
   :preco-total   (total-dos-pedidos pedidos)
   })

(->> (l.db/todos-pedidos)
     (group-by minha-funcao)
     (map quantidade-de-pedidos-e-gasto-total-por-usuario))

; FIM

(println (l.db/todos-pedidos))

(defn conta-itens-pedido-usuario
  [usuario]
  (count usuario))

(println (group-by conta-itens-pedido-usuario (l.db/todos-pedidos)))
(println (group-by (fn [u] (count (:itens u))) (l.db/todos-pedidos)))
(println (group-by #(count (:itens %)) (l.db/todos-pedidos)))