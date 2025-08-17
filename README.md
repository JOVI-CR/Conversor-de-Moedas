# 🪙 Conversor de Moedas - Challenge ONE

## 📖 Sobre o Projeto

Este é um conversor de moedas interativo que funciona via console, desenvolvido como parte do Challenge ONE - Java - Back-end da Oracle Next Education em parceria com a Alura. A aplicação permite ao usuário escolher uma moeda de origem, uma de destino e um valor, e então consulta uma API em tempo real para realizar a conversão com as taxas de câmbio mais recentes.

---

## ✨ Funcionalidades

- **Conversão em Tempo Real:** Utiliza a API [ExchangeRate-API](https://www.exchangerate-api.com/) para obter as taxas de câmbio atualizadas.
- **Menu Interativo:** Interface de console amigável que guia o usuário através do processo de conversão.
- **Variedade de Moedas:** Suporte para conversão entre as principais moedas da América Latina e o Dólar Americano (ARS, BOB, BRL, CLP, COP, USD).
- **Loop de Execução:** Permite que o usuário realize múltiplas conversões sem precisar reiniciar o programa.

---

## 🛠️ Tecnologias Utilizadas

- **Java 17:** Linguagem principal do projeto.
- **Java HTTP Client:** Para realizar as requisições à API de forma nativa e moderna.
- **Gson (Google):** Biblioteca para converter a resposta JSON da API em objetos Java de forma simples e eficiente.

---

## 🏗️ Estrutura e Resolução do Projeto

O projeto foi estruturado em várias classes, seguindo o princípio de responsabilidade única para manter o código organizado, legível e de fácil manutenção.

1.  **`Main.java`:**
    -   É o ponto de entrada da aplicação (`main`).
    -   Responsável por toda a interação com o usuário: exibe o menu, captura as opções de moeda e o valor a ser convertido.
    -   Orquestra a chamada das outras classes para executar o fluxo de conversão.
    -   Controla o loop de execução, perguntando ao usuário se deseja realizar uma nova conversão.

2.  **`ConectorApi.java`:**
    -   Classe dedicada a se comunicar com a ExchangeRate-API.
    -   Utiliza o `HttpClient` do Java para construir e enviar uma requisição GET para a API.
    -   Recebe a resposta da API, que vem em formato de String JSON, e a retorna para a classe `Main`.

3.  **`Moeda.java` (Record):**
    -   Modela os dados recebidos da API. Foi implementado como um `record` Java para representar de forma concisa e imutável a estrutura do JSON, focando nos campos essenciais: `base_code` (moeda base) e `conversion_rates` (um mapa com as taxas de conversão).

4.  **`AnalisadorJson.java`:**
    -   Recebe a String JSON vinda do `ConectorApi`.
    -   Utiliza a biblioteca `Gson` para "traduzir" a String JSON para um objeto do tipo `Moeda`. Esse processo é conhecido como desserialização.

5.  **`CalcularConversao.java`:**
    -   Contém a lógica de negócio da conversão.
    -   Recebe o objeto `Moeda` (já com as taxas), a moeda de destino e o valor.
    -   Acessa o mapa de taxas, encontra a cotação correta e realiza o cálculo de multiplicação para obter o valor final convertido.

### Fluxo da Aplicação

```
Usuário -> Main -> ConectorApi -> API Externa
                                       |
API Externa -> ConectorApi -> Main -> AnalisadorJson -> Moeda (Objeto)
                                                            |
Moeda (Objeto) -> Main -> CalcularConversao -> Resultado -> Usuário
```

---

## 🚀 Como Executar

1.  **Pré-requisitos:**
    -   Java 17 ou superior.
    -   Biblioteca Gson adicionada ao projeto (via Maven/Gradle ou importando o .jar).
    -   Uma chave de API da [ExchangeRate-API](https://www.exchangerate-api.com/).

2.  **Configuração:**
    -   Clone o repositório.
    -   Na classe `ConectorApi.java`, substitua o placeholder `"SUA_CHAVE_API_AQUI"` pela sua chave pessoal.

3.  **Execução:**
    -   Compile todas as classes `.java`.
    -   Execute a classe `Main`.

---

## 👨‍💻 Autor

-   **João Vítor C. Rocha**
-   [LinkedIn](https://www.linkedin.com/in/joao-vitor-carlos-da-rocha/)
-   [GitHub](https://github.com/JOVI-CR)
