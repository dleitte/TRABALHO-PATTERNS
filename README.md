# Avaliação III - Padrões de Projeto (IFBA)

Este projeto implementa soluções arquiteturais para o ecossistema de streaming, aplicando padrões de projeto para resolver problemas de hierarquia, construção de objetos e extensibilidade de funcionalidades.

---

## 1. Questão I: Composite + Builder

*   **Nome dos Padrões:** `Composite` e `Builder`.
*   **Justificativa:** 
    *   O **Composite** foi adotado para permitir a criação de pacotes de conteúdo hierárquicos, tratando itens avulsos (Filmes, Séries) e agrupamentos (Pacotes) de forma polimórfica, permitindo que um pacote contenha outros pacotes de forma transparente. 
    *   O **Builder** foi utilizado para resolver a complexidade na instanciação de objetos aninhados, permitindo uma construção fluente, legível e desacoplada dos construtores complexos.

### Participantes:
*   **`ComponenteComercial`** (Component): Interface comum para todos os itens.
*   **`Filme`, `Episodio`** (Leaf): Objetos primitivos da estrutura.
*   **`Pacote`, `Serie`** (Composite): Objetos que contêm outros componentes.
*   **`PacoteBuilder`** (Builder): Classe responsável pela construção passo a passo do objeto complexo.

---

## 2. Questão II: Adapter + Visitor

*   **Nome dos Padrões:** `Adapter` e `Visitor`.
*   **Justificativa:** 
    *   O **Adapter** foi essencial para integrar elementos externos (`MP3`, `Video`) ao sistema sem alterar suas classes originais, respeitando o princípio de não modificar código de terceiros. 
    *   O **Visitor** foi fundamental para realizar operações analíticas (exportação XML e cálculo de Largura de Banda) sem que as classes de modelo precisassem conter lógica de negócio, mantendo o princípio Aberto/Fechado (Open/Closed).

### Participantes:
*   **`PlaylistVisitor`** (Visitor): Interface de visita para os itens da playlist.
*   **`XMLVisitor`, `BandwidthVisitor`** (ConcreteVisitor): Implementações concretas das operações analíticas.
*   **`PlaylistItem`** (Element): Interface que declara o método `accept` para visitantes.
*   **`MP3Adapter`, `VideoAdapter`** (Adapter): Conectores que adaptam os elementos externos para o padrão exigido pelo sistema.

---

**Nota Técnica:** Adicionalmente, a arquitetura permite a extensão funcional futura através do padrão **Decorator** (já presente no framework base), que pode ser combinado com o **Composite** para adicionar comportamentos dinâmicos aos componentes da árvore.
