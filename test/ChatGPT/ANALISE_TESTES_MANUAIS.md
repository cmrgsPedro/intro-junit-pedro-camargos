# Análise dos testes criados manualmente

## Metodologia

Para cada classe, foram enviados ao ChatGPT o código de produção e o teste criado manualmente, junto com cada uma das três perguntas sugeridas na atividade.

Arquivos analisados:

- [`Calculadora.java`](../../src/calculadora/Calculadora.java) e [`CalculadoraTest.java`](../calculadora/CalculadoraTest.java);
- [`Carrinho.java`](../../src/carrinho/Carrinho.java) e [`CarrinhoTest.java`](../carrinho/CarrinhoTest.java);
- [`Main.java`](../../src/Main.java) e [`MainTest.java`](../MainTest.java), como parte opcional do Jokenpô.

Os testes originais não foram alterados.

## Calculadora

### Prompt 1 — Os testes são suficientes?

> Você é um testador experimente de testes unitários. Abaixo estão o código Java e o código de teste. A classe CalculadoraTest foi criada manualmente por mim para a classe Calculadora. Esses testes são suficientes?

### Resposta

Os 11 testes são suficientes para uma atividade introdutória. Todos os métodos públicos de `Calculadora` são executados pelo menos uma vez. Também são verificados os três resultados possíveis de `compara` e a exceção da divisão por zero.

O conjunto não é exaustivo. Para uma cobertura mais completa, poderiam ser incluídos:

- divisão inteira com resto, como `5 / 2`;
- zero em `ehPositivo`, pois a implementação considera zero positivo;
- zero e números negativos em `somatoria`;
- números negativos e zero nas operações aritméticas.

Conclusão: os testes atendem ao objetivo da primeira aula, mas ainda existem casos de limite que podem aumentar a confiança no comportamento da classe.

### Prompt 2 — Há testes redundantes?

> Você é um testador experimente de testes unitários. Abaixo estão o código Java e o código de teste. A classe CalculadoraTest foi criada manualmente por mim para a classe Calculadora. Há testes redundantes?

### Resposta

Não há testes verdadeiramente redundantes. Os três testes de `compara` parecem semelhantes, mas cada um verifica um caminho diferente: números iguais, primeiro número maior e primeiro número menor. Da mesma forma, os testes de número positivo e negativo verificam resultados booleanos diferentes.

Cada método de teste possui um objetivo próprio. Portanto, remover algum deles reduziria a variedade de comportamentos verificados.

### Prompt 3 — Os testes seguem boas práticas?

> Você é um testador experimente de testes unitários. Abaixo estão o código Java e o código de teste. A classe CalculadoraTest foi criada manualmente por mim para a classe Calculadora. Os testes que criei seguem boas práticas para criação de testes?

### Resposta

Sim. Os testes seguem boas práticas importantes:

- nomes que descrevem o comportamento esperado;
- uma nova instância criada no `@BeforeEach`;
- testes independentes, sem depender da ordem de execução;
- uso de `assertEquals`, `assertTrue`, `assertFalse` e `assertThrows` de acordo com o resultado esperado;
- um comportamento principal verificado em cada teste.

Como melhoria, os casos de limite citados na primeira resposta poderiam ser adicionados. Também seria possível separar visualmente preparação, execução e verificação em todos os métodos, embora os testes atuais sejam curtos e continuem fáceis de entender.

## Carrinho

### Prompt 1 — Os testes são suficientes?

> Você é um testador experimente de testes unitários. Abaixo estão o código Java e o código de teste. A classe CarrinhoTest foi criada manualmente por mim para a classe Carrinho. Esses testes são suficientes?

### Resposta

Os seis testes são suficientes para o objetivo introdutório. Eles verificam o estado inicial, a adição de produto, o valor total, a remoção, a exceção ao remover um produto inexistente e o esvaziamento. Assim, todos os métodos públicos de `Carrinho` são utilizados.

Para uma cobertura mais completa, poderiam ser acrescentados:

- valor total depois da remoção de um produto;
- remoção de apenas um item de um carrinho com vários produtos;
- adição do mesmo produto mais de uma vez;
- comportamento ao remover outro objeto com o mesmo nome, pois `Produto.equals` compara somente o nome;
- verificação de que o carrinho permanece vazio após uma tentativa de remoção inválida.

Conclusão: o conjunto cobre as funções principais, mas pode explorar mais mudanças de estado do carrinho.

### Prompt 2 — Há testes redundantes?

> Você é um testador experimente de testes unitários. Abaixo estão o código Java e o código de teste. A classe CarrinhoTest foi criada manualmente por mim para a classe Carrinho. Há testes redundantes?

### Resposta

Não há testes redundantes. `deveIniciarVazio` e `deveEsvaziarCarrinho` terminam com o mesmo estado, mas verificam situações diferentes. O primeiro testa a criação do objeto; o segundo testa uma mudança de estado depois que produtos foram adicionados.

As duas asserções usadas nesses testes também não são redundantes: uma verifica a quantidade e a outra verifica o valor total.

### Prompt 3 — Os testes seguem boas práticas?

> Você é um testador experimente de testes unitários. Abaixo estão o código Java e o código de teste. A classe CarrinhoTest foi criada manualmente por mim para a classe Carrinho. Os testes que criei seguem boas práticas para criação de testes?

### Resposta

Sim. Os principais pontos positivos são:

- nomes descritivos;
- preparação comum no `@BeforeEach`;
- separação visual entre preparação, execução e verificação;
- uso de margem na comparação de valores `double`;
- uso de `assertThrows` para a exceção esperada;
- testes independentes.

Como melhoria, `deveAdicionarProduto` poderia verificar também o valor total, e `deveRemoverProduto` poderia verificar que o total voltou a zero. Também seria útil verificar o estado do carrinho depois da exceção. Essas adições tornariam as pós-condições mais completas sem mudar a estrutura simples dos testes.

## Jokenpô — opcional

### Prompt 1 — Os testes são suficientes?

> Você é um testador experimente de testes unitários. Abaixo estão o código Java e o código de teste. A classe MainTest foi criada manualmente por mim para a classe Main. Esses testes são suficientes?

### Resposta

Sim. O conjunto é suficiente para o contrato atual de `jogar`. Ele verifica as nove combinações válidas: três empates, três vitórias do jogador 1 e três vitórias do jogador 2. Também verifica valores inválidos abaixo e acima do intervalo permitido para os dois jogadores.

Poderiam ser adicionados números negativos e um caso em que as duas escolhas sejam inválidas ao mesmo tempo. Porém, esses valores percorrem a mesma validação já exercitada por zero e quatro. Portanto, seriam casos complementares, não lacunas importantes.

### Prompt 2 — Há testes redundantes?

> Você é um testador experimente de testes unitários. Abaixo estão o código Java e o código de teste. A classe MainTest foi criada manualmente por mim para a classe Main. Há testes redundantes?

### Resposta

Não há redundância em relação às regras do jogo, pois cada combinação válida representa uma situação diferente. Os testes com zero e quatro também representam os dois lados do intervalo aceito.

Alguns testes percorrem o mesmo caminho interno da implementação, mas mantê-los separados deixa a tabela do Jokenpô completa e fácil de conferir. Uma alternativa mais avançada seria usar testes parametrizados, mas a repetição atual favorece a leitura em uma atividade inicial.

### Prompt 3 — Os testes seguem boas práticas?

> Você é um testador experimente de testes unitários. Abaixo estão o código Java e o código de teste. A classe MainTest foi criada manualmente por mim para a classe Main. Os testes que criei seguem boas práticas para criação de testes?

### Resposta

Sim. Os testes possuem nomes claros, são independentes, criam o objeto no `@BeforeEach` e usam uma asserção direta por cenário. A cobertura das combinações do jogo também facilita identificar qual regra falhou.

Como melhoria futura, os cenários poderiam ser transformados em testes parametrizados para diminuir a repetição. Para o nível introdutório, a forma atual é mais simples e adequada.

## Conclusão geral

| Classe de teste | Suficiente para a atividade inicial? | Testes redundantes? | Segue boas práticas? |
|---|---|---|---|
| `CalculadoraTest` | Sim, com casos de limite ainda possíveis | Não | Sim |
| `CarrinhoTest` | Sim, com transições de estado ainda possíveis | Não | Sim |
| `MainTest` | Sim, com cobertura ampla das combinações | Não | Sim |

Os testes manuais cumprem bem a proposta da primeira aula. As melhorias sugeridas aumentariam a cobertura, mas não invalidam o conjunto original.
