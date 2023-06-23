# JavaTest-locadoraVVS


## Trabalho vvs Final

[![Build Status](https://travis-ci.org/aguirre39/JavaTest-locadoraVVS.svg?branch=main)](https://travis-ci.org/aguirre39/JavaTest-locadoraVVS)


1) Vou explicar as entradas e saídas dos testes presentes na classe CalculadoraMockTest:

testShowDifferenceBetweenMockAndSpy(): Este teste mostra a diferença entre mocks e spyes. Ele configura um mock e um spy da classe Calculadora para retornar 5 quando o método somar é chamado com os argumentos 1 e 2. Em seguida, ele imprime o resultado da chamada do método somar no mock e no spy, além de chamar o método imprime no mock e no spy. A saída esperada é a impressão dos valores 5 e 0 (para o mock) e 5 e "imprimindo…" (para o spy).

testMock(): Este teste utiliza um mock da classe Calculadora com argumentos capturados. Ele configura o mock para retornar 5 quando o método somar é chamado com quaisquer argumentos. Em seguida, ele chama o método somar do mock com os argumentos 134345 e -234 e verifica se o resultado é igual a 5. A saída esperada é a impressão da lista de valores capturados pelo capturador de argumentos, que deve conter os valores 134345 e -234.
-----------------------------------------------------------------------------------------------------------------

2) Segue abaixo a explicação das entradas e saídas dos testes presentes na classe CalculadoraTest:

deveSomarDoisValores(): Este teste verifica se a soma de dois valores está correta. Ele define os valores a serem somados (5 e 3), chama o método somar da classe Calculadora e verifica se o resultado é igual a 8. A saída esperada é a impressão da mensagem "iniciando…" antes da execução do teste e nenhuma mensagem após a execução do teste.

deveSubtrairDoisValores(): Este teste verifica se a subtração de dois valores está correta. Ele define os valores a serem subtraídos (8 e 5), chama o método subtrair da classe Calculadora e verifica se o resultado é igual a 3. A saída esperada é a impressão da mensagem "iniciando…" antes da execução do teste e nenhuma mensagem após a execução do teste.

deveDividirDoisValores(): Este teste verifica se a divisão de dois valores está correta. Ele define os valores a serem divididos (6 e 3), chama o método divide da classe Calculadora e verifica se o resultado é igual a 2. A saída esperada é a impressão da mensagem "iniciando…" antes da execução do teste e nenhuma mensagem após a execução do teste.

deveLancarExcecaoAoDividirPorZero(): Este teste verifica se a exceção NaoPodeDividirPorZeroException é lançada ao tentar dividir por zero. Ele define os valores a serem divididos (10 e 0), chama o método divide da classe Calculadora e espera que a exceção seja lançada. A saída esperada é a impressão da mensagem "iniciando…" antes da execução do teste e nenhuma mensagem após a execução do teste.

deveDividir(): Este teste verifica se a divisão de dois valores representados como strings está correta. Ele define os valores a serem divididos (6 e 3, representados como strings), chama o método divide da classe Calculadora e verifica se o resultado é igual a 2. A saída esperada é a impressão da mensagem "iniciando…" antes da execução do teste e nenhuma mensagem após a execução do teste.
-----------------------------------------------------------------------------------------------------------------

3) Segue abaixo a explicação das entradas e saídas dos testes presentes na classe CalculoValorLocacaoTest, mostrando a descrição dos cenários:
getParametros(): Este método retorna uma coleção de parâmetros para o teste. Ele define diferentes cenários de locação, cada um com uma lista de filmes, um valor de locação esperado e uma descrição do cenário. As entradas são as seguintes:
Cenário 1: 2 filmes, sem desconto.
Cenário 2: 3 filmes, com desconto de 25%.
Cenário 3: 4 filmes, com desconto de 50%.
Cenário 4: 5 filmes, com desconto de 75%.
Cenário 5: 6 filmes, com desconto de 100%.
Cenário 6: 7 filmes, sem desconto.
A saída esperada é a impressão da descrição de cada cenário:
"2 Filmes: Sem Desconto"
"3 Filmes: 25%"
"4 Filmes: 50%"
"5 Filmes: 75%"
"6 Filmes: 100%"
"7 Filmes: Sem Desconto"
deveCalcularValorLocacaoConsiderandoDescontos(): Este teste verifica se o cálculo do valor de uma locação de filmes, considerando descontos, está correto. Ele utiliza os parâmetros definidos no método getParametros, cria uma instância de usuário utilizando o padrão de projeto Builder, chama o método alugarFilme da classe LocacaoService passando o usuário e a lista de filmes como parâmetros e verifica se o valor da locação é igual ao valor esperado utilizando o método assertThat da biblioteca Hamcrest. As entradas são as mesmas dos cenários definidos no método getParametros. A saída esperada é a impressão da descrição de cada cenário e nenhuma mensagem de erro.
-----------------------------------------------------------------------------------------------------------------

4) Segue abaixo a explicação das entradas e saídas dos testes presentes na classe LocacaoServiceTest, mostrando a descrição dos cenários:
deveAlugarFilme(): Este teste verifica se é possível alugar um filme com sucesso. Ele cria um usuário e uma lista de filmes utilizando o padrão de projeto Builder, define a data de locação como 28/04/2017 utilizando o método do Returndo Mockito, chama o método alugarFilme da classe LocacaoService passando o usuário e a lista de filmes como parâmetros e verifica se o valor da locação, a data de locação e a data de retorno estão corretos utilizando o método assertThat da biblioteca Hamcrest. A saída esperada é a impressão da mensagem "finalizando 2…" no console.
naoDeveAlugarFilmeSemEstoque(): Este teste verifica se é lançada uma exceção do tipo FilmeSemEstoqueException ao tentar alugar um filme sem estoque. Ele cria um usuário e uma lista de filmes sem estoque utilizando o padrão de projeto Builder, chama o método alugarFilme da classe LocacaoService passando o usuário e a lista de filmes como parâmetros e espera que seja lançada uma exceção do tipo FilmeSemEstoqueException. A saída esperada é a impressão da mensagem "finalizando 2…" no console.
naoDeveAlugarFilmeSemUsuario(): Este teste verifica se é lançada uma exceção do tipo 
LocadoraException ao tentar alugar um filme sem usuário. Ele cria uma lista de filmes utilizando o padrão de projeto Builder, chama o método alugarFilme da classe LocacaoService passando null como usuário e a lista de filmes como parâmetros e espera que seja lançada uma exceção do tipo LocadoraException com a mensagem "Usuario vazio". A saída esperada é a impressão da mensagem "finalizando 2…" no console.
naoDeveAlugarFilmeSemFilme(): Este teste verifica se é lançada uma exceção do tipo LocadoraException ao tentar alugar um filme sem filmes. Ele cria um usuário utilizando o padrão de projeto Builder, chama o método alugarFilme da classe LocacaoService passando o usuário como parâmetro e null como lista de filmes e espera que seja lançada uma exceção do tipo LocadoraException com a mensagem "Filme vazio". A saída esperada é a impressão da mensagem "finalizando 2…" no console.
deveDevolverNaSegundaAoAlugarNoSabado(): Este teste verifica se a data de retorno de uma locação é na segunda-feira seguinte ao alugar um filme no sábado. Ele cria um usuário e uma lista de filmes utilizando o padrão de projeto Builder, define a data de locação como 29/04/2017 utilizando o método doReturn do Mockito, chama o método alugarFilme da classe LocacaoService passando o usuário e a lista de filmes como parâmetros e verifica se a data de retorno está correta utilizando o método assertThat da biblioteca Hamcrest e o matcher caiNumaSegunda definido na classe MatchersProprios. A saída esperada é a impressão da mensagem "finalizando 2…" no console.
naoDeveAlugarFilmeParaNegativadoSPC(): Este teste verifica se é lançada uma exceção do tipo LocadoraException ao tentar alugar um filme para um usuário negativado no SPC. Ele cria um usuário e uma lista de filmes utilizando o padrão de projeto Builder, define que o usuário possui negativação no SPC utilizando o método when do Mockito, chama o método alugarFilme da classe LocacaoService passando o usuário e a lista de filmes como parâmetros e espera que seja lançada uma exceção do tipo LocadoraException com a mensagem "Usuário Negativado". A saída esperada é a impressão da mensagem "finalizando 2…" no console.
deveEnviarEmailParaLocacoesAtrasadas(): Este teste verifica se o método notificarAtraso da classe EmailService é chamado corretamente para as locações atrasadas. Ele cria três usuários utilizando o padrão de projeto Builder e uma lista de locações utilizando o padrão de projeto Builder, define que o método obterLocacoesPendentes do DAO retorna a lista de locações criada anteriormente utilizando o método when do Mockito, chama o método notificarAtrasos da classe LocacaoService e verifica se o método  notificarAtraso da classe EmailService é chamado corretamente utilizando os métodos verify e atLeastOnce do Mockito. A saída esperada é a impressão da mensagem "finalizando 2…" no console.
deveTratarErronoSPC(): Este teste verifica se é lançada uma exceção do tipo LocadoraException ao ocorrer um erro no SPC. Ele cria um usuário e uma lista de filmes utilizando o padrão de projeto Builder, define que o método possuiNegativacao do SPCService lança uma exceção utilizando o método thenThrow do Mockito, chama o método alugarFilme da classe LocacaoService passando o usuário e a lista de filmes como parâmetros e espera que seja lançada uma exceção do tipo LocadoraException com a mensagem "Problemas com SPC, tente novamente". A saída esperada é a impressão da mensagem "finalizando 2…" no console.
deveProrrogarUmaLocacao(): Este teste verifica se é possível prorrogar uma locação com sucesso. Ele cria uma locação utilizando o padrão de projeto Builder, chama o método prorrogarLocacao da classe LocacaoService passando a locação e o número de dias a serem prorrogados como parâmetros, verifica se a locação foi salva corretamente utilizando o método verify do Mockito e verifica se o valor, a data de locação e a data de retorno da locação estão corretos utilizando o método error. checkThat da biblioteca Hamcrest e os matchers is,  ehHoje e ehHojeComDiferencaDias definidos na classe MatchersProprios. A saída esperada é a impressão da mensagem "finalizando 2…" no console.
deveCalcularValorLocacao(): Este teste verifica se o método calcularValorLocacao da classe LocacaoService está calculando o valor da locação corretamente. Ele cria uma lista de filmes utilizando o padrão de projeto Builder, utiliza reflection para chamar o método calcularValorLocacao da classe LocacaoService passando a lista de filmes como parâmetro, e verifica se o valor retornado está correto utilizando o método assertThat da biblioteca Hamcrest. A saída esperada é a impressão da mensagem "finalizando 2…" no console.



