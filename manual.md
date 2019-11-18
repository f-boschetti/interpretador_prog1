---
title: "Documentação da linguagem BrasilianWay"
author: "Felipe Boschetti, Lucas Tissotti e Mateus Cazarotto"
date: "17/11/2019"
---
\
\ 

### Conhecimentos basicos sobre BrasilianWay
  A linguagem BrasilianWay, assim como todo brasileirinho almeja o alto nivel, sendo assim ela é muito inspirada em Python.
  Tendo isso em vista **não** se deve usar qualquer pontuação ao final de **nenhuma** linha e **não** precisa declarar o tipo da variavel.

#### Comandos basicos da linguagem
\ 
\ 

##### Atribuições

Atribuiçoes são feitas usado os caracteres reservados `:=`.
E o caracter reservado `'` é usado para declarar Strings.

##### Exemplo:
```
a := 10
felipe := 'Lindão'
```

##### **Operadores matematicos**
São os mesmos dos demais linguagens
**Porém só se pode ter dois operandos por vez**

* Soma `+`

* Subtração `-`

* Divisão `/`

* Multiplicação `*`

* Resto da divisão `%`

##### Exemplos:

```
b := 10 + 2
c := b - 3 
d := c / 3 
e := c * 9 
f := d % 3
```
#### **Operadors lógicos**
**Só se pode ter dois operandos por vez**


* Igual `#`

* Diferente `$`

* Menor `<`

* Maior `>`

* Maior ou igual `>#`

* Menor ou igual `<#`

##### Exemplos:


Comando             | Resposta
--------------------|-----------
booleano1 := a # b  |false
booleano2 := a $ b  |true
booleano3 := a < b  |true
booleano4 := a > b  |false
booleano5 := a <# b |true
booleano6 := a ># b |false




#### Impressão na tela

A impressão na tela é feita pelo comando `imprime:` **no inicio da linha, e é impresso somente uma variavel ou texto por vez, sem quebra de linha**, para cabra de linha usa-se os caracteres `|m`.

##### Exemplo:

Comando           |Resposta
------------------|---------
imprime: felipe   |lindão
imprime: 'fe\|mlipe'|fe\\nlipe (\\n é uma quebra de linha)
imprime: booleano1|false
imprime: a        |10.0

