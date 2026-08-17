# Prompts utilizados

## Calculadora

Você é um testador experimente de testes unitários. Gere casos de testes para a classe Java abaixo em um único arquivo Java com imports usando JUnit 5 e Java 8.

```java
package calculadora;

public class Calculadora {

    public int soma(int a, int b) {
        return a + b;
    }

    public int subtracao(int a, int b) {
        return a - b;
    }

    public int multiplicacao(int a, int b) {
        return a * b;
    }

    public int divisao(int a, int b) {
        return a / b;
    }

    public int somatoria(int n) {
        int somatorio = 0;
        while (n >= 0) {
            somatorio += n;
            n--;
        }
        return somatorio;
    }

    public boolean ehPositivo(int n) {
        return n >= 0;
    }

    public int compara(int a, int b) {
        int retorno = 0;
        if (a == b) {
            retorno = 0;
        } else if (a > b) {
            retorno = 1;
        } else {
            retorno = -1;
        }
        return retorno;
    }
}
```

## Carrinho

Você é um testador experimente de testes unitários. Gere casos de testes para a classe Java abaixo em um único arquivo Java com imports usando JUnit 5 e Java 8.

```java
package carrinho;

import java.util.ArrayList;
import java.util.Iterator;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class Carrinho {

    private ArrayList items;

    public Carrinho() {
        items = new ArrayList();
    }

    public double getValorTotal() {
        double valorTotal = 0.0;

        for (Iterator i = items.iterator(); i.hasNext();) {
            Produto item = (Produto) i.next();
            valorTotal += item.getPreco();
        }

        return valorTotal;
    }

    public void addItem(Produto item) {
        items.add(item);
    }

    public void removeItem(Produto item) throws ProdutoNaoEncontradoException {
        if (!items.remove(item)) {
            throw new ProdutoNaoEncontradoException();
        }
    }

    public int getQtdeItems() {
        return items.size();
    }

    public void esvazia() {
        items.clear();
    }
}
```

## Jokenpo

Você é um testador experimente de testes unitários. Gere casos de testes para a classe Java abaixo em um único arquivo Java com imports usando JUnit 5 e Java 8.

```java
public class Main {

    public int jogar(int jogador1, int jogador2) {
        int retorno = 0;
        if ((jogador1 > 0) && (jogador1 <= 3) && (jogador2 > 0) && (jogador2 <= 3)) {
            if (jogador1 != jogador2) {
                if ((jogador1 - jogador2) == -1 || (jogador1 - jogador2 == 2)) {
                    retorno = 1;
                } else {
                    retorno = 2;
                }
            }
        } else {
            retorno = -1;
        }
        return retorno;
    }
}
```
