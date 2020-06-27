(ns project_loja_alura.aula1)

(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (funcao primeiro)
        (meu-mapa funcao (rest sequencia))))))

(meu-mapa println ["cesar", "paula", nil, "chico", "bento"])
(map println ["cesar", "paula", nil, "chico", "bento"])
; (meu-mapa println (range 5000)) StackOverflowError

; tail recursive
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (funcao primeiro)
        (recur funcao (rest sequencia))))))

(meu-mapa println ["cesar", "paula", nil, "chico", "bento"])
(map println ["cesar", "paula", nil, "chico", "bento"])
(meu-mapa println (range 5000))