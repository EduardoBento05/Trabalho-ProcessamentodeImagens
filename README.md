# Lista de Atividades 1 — Processamento de Imagens

Este projeto implementa operações básicas de manipulação de imagens utilizando Java e bibliotecas de processamento de imagem. As atividades foram divididas em duas partes principais: aplicação de transparência (alfa) e leitura/exportação de arquivos no formato PNM.

## 📌 Atividades Desenvolvidas

### 1. Aplicação de Transparência (Alpha)

#### a) Transparência sobre fundo preto
- **Objetivo:** Carregar uma imagem RGB e aplicar transparência gradual à cor preta (RGB = 0, 0, 0), alterando o valor de alpha de 1 até 0.
- **Resultado esperado:** A imagem inicialmente coberta por preto vai, aos poucos, revelando seu conteúdo original.

#### b) Sobreposição de duas imagens RGB
- **Objetivo:** Carregar duas imagens RGB do mesmo tamanho e sobrepô-las com uma transição gradual usando alpha.
- **Fórmulas usadas para interpolação:**


- **Controle de Alpha:** A transição pode ser feita via menu, tecla de atalho ou utilizando a função `sleep()` para criar o efeito gradativo.

---

### 2. Leitura e Exportação de Arquivos PNM

- **Objetivo:** Criar um programa capaz de ler um dos formatos de imagem PNM e exibi-la na tela.
- **Exportação:** A imagem pode ser convertida para um dos seguintes formatos: GIF, BMP, JPG ou PNG.
- **Formatos PNM disponíveis para escolha:**
- PBM (P1)
- PBM (P4)
- PGM (P2)
- PGM (P5)
- PPM (P3)
- PPM (P6)



