
# Estruturas de Dados e Algoritmos — Material do Curso

Bem-vindas e bem-vindos! Este repositório contém exemplos, implementações e exercícios usados nas aulas de Estruturas de Dados e Algoritmos.

Links úteis:

- Curso (opcional): https://www.udemy.com/course/fundamentos-de-estruturas-de-dados-em-java/
- Material de apoio: https://drive.google.com/drive/folders/1TFtRn02bPpLaf0Lv8xzpOm9nLIU86i0u

**Objetivo**: fornecer implementações didáticas e exercícios que ajudem a entender conceitos fundamentais (listas, pilhas, filas, árvores, tabelas hash, complexidade, etc.).

**Pré-requisitos**

- JDK 20 (recomenda-se usar a mesma versão do curso)
- Maven

## Como usar este repositório

1. Clone o repositório:

```bash
git clone https://github.com/matheusphalves/java-data-structures-algorithms.git
cd java-data-structures-algorithms
```

2. Compilar com Maven:

```bash
mvn clean package
```

3. Executar uma classe Main compilada (ex.: pacote principal):

```bash
java -cp target/classes com.basics.datastructures.Main
```

4. Rodar testes:

```bash
mvn test
```

## Estrutura do repositório

- `src/main/java/com/basics/datatypes` — tipos primitivos e classes wrapper.
- `src/main/java/com/basics/generics` — exemplos com generics e wrappers genéricos.
- `src/main/java/com/basics/objects` — exemplos com objetos e classes simples.
- `src/main/java/com/basics/recursion` — exemplos recursivos (fibonacci, exercícios).
- `src/main/java/com/basics/datastructures` — implementações de listas, pilhas, filas, árvores e tabelas hash.

Dentro de `datastructures` você encontrará:

- `collection/api` — interfaces das estruturas (List, Map, Set, Stack, Queue, Tree, Graph).
- `collection/impl` — implementações estáticas e dinâmicas (LinkedListImpl, StackImpl, HashMapOpenAddressingImpl, etc.).
- `collection/internal` — classes auxiliares (nós, entradas, etc.).
- `playground` — classes de teste/uso rápido para experimentar implementações.

## Sugestões de uso em aula

- Leia e execute as classes em `playground` para ver exemplos simples de uso.
- Faça alterações nas implementações e rode os testes para validar comportamento.
- Use `mvn test` frequentemente ao implementar soluções.

## Como contribuir

- Abra uma issue descrevendo a sugestão ou bug.
- Envie PRs com uma descrição clara e testes quando aplicável.

---

Se tiver dúvidas, traga-as para a aula ou abra uma issue no repositório.


