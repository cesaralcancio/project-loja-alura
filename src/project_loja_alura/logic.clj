(ns project_loja_alura.logic)

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
  ;(println)
  ;(println "pedidos:" pedidos)
  {
   :usuario-id       usuario
   :total-pedidos (count pedidos)
   :preco-total   (total-dos-pedidos pedidos)
   })

(defn resumo-por-usuario
  [todos-pedidos]
  (->> todos-pedidos
       (group-by :usuario)
       (map quantidade-de-pedidos-e-gasto-total-por-usuario)))