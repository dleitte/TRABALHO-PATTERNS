Avaliação III - Padrões de Projeto (IFBA)
Questão I: Composite + Builder
Nome do Padrão: Composite e Builder.

Justificativa: Utilizamos o Composite para permitir a criação de pacotes de conteúdo hierárquicos, onde um pacote pode conter filmes ou outros pacotes de forma transparente. O Builder foi utilizado para resolver a complexidade na instanciação desses pacotes aninhados, permitindo uma construção fluente e legível.

Participantes:

ComponenteComercial (Component): Interface comum para todos os itens.

Filme, Episodio (Leaf): Objetos primitivos da estrutura.

Pacote, Serie (Composite): Objetos que contêm outros componentes.

PacoteBuilder (Builder): Classe responsável pela construção passo a passo do objeto complexo.

Questão II: Adapter + Visitor
Nome do Padrão: Adapter e Visitor.

Justificativa: O Adapter foi essencial para integrar elementos externos (MP3, Video) ao sistema sem alterar suas classes originais, respeitando o princípio de não modificar código de terceiros. O Visitor foi fundamental para realizar operações analíticas (XML e Largura de Banda) sem que as classes de modelo precisassem conter lógica de negócio, mantendo o princípio Aberto/Fechado (Open/Closed).

Participantes:

PlaylistVisitor (Visitor): Interface de visita.

XMLVisitor, BandwidthVisitor (ConcreteVisitor): Implementações das operações analíticas.

PlaylistItem (Element): Interface que aceita visitantes.

MP3Adapter, VideoAdapter (Adapter): Conectores entre o código externo e o sistema.
