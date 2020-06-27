(ns project_loja_alura.db)

(def pedido1 {
              :usuario 10
              :itens   {:mochila  {:id :mochila :quantidade 2 :preco-unitario 80}
                        :camiseta {:id :camiseta :quantidade 3 :preco-unitario 40}
                        :tenis    {:id :tenis :quantidade 1}}})

(def pedido2 {
              :usuario 10
              :itens   {:mochila  {:id :mochila :quantidade 2 :preco-unitario 80}
                        :camiseta {:id :camiseta :quantidade 3 :preco-unitario 40}
                        :tenis    {:id :tenis :quantidade 1}}})

(def pedido3 {
              :usuario 20
              :itens   {:mochila  {:id :mochila :quantidade 2 :preco-unitario 60}
                        :camiseta {:id :camiseta :quantidade 3 :preco-unitario 40}
                        :tenis    {:id :tenis :quantidade 1}}})

(def pedido4 {
              :usuario 20
              :itens   {:mochila  {:id :mochila :quantidade 2 :preco-unitario 60}
                        :camiseta {:id :camiseta :quantidade 3 :preco-unitario 40}
                        :tenis    {:id :tenis :quantidade 1}}})

(def pedido5 {
              :usuario 30
              :itens   {:mochila  {:id :mochila :quantidade 2 :preco-unitario 30}
                        :camiseta {:id :camiseta :quantidade 3 :preco-unitario 40}
                        :tenis    {:id :tenis :quantidade 1}}})

(def pedido6 {
              :usuario 30
              :itens   {:mochila  {:id :mochila :quantidade 2 :preco-unitario 30}
                        :camiseta {:id :camiseta :quantidade 3 :preco-unitario 40}
                        :tenis    {:id :tenis :quantidade 1}}})

(defn todos-pedidos []
  [pedido1, pedido2, pedido3, pedido4, pedido5, pedido6])