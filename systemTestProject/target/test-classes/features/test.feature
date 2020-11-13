@pesquisarAluguel
Feature: Funcionalidade de pesquisar carros para aluguel no site Rental Cars

  Background:
    Given que um navegador da Web está na página inicial do Rental Cars

  @validarLocalPesquisado
  Scenario: Pesquisar Fortaleza como local de retirada
    Given que um navegador da Web está na página inicial do Rental Cars
    When o usuário digita Fortaleza na barra de pesquisa do local de retirada
    Then sugestões relacionadas com Fortaleza são exibidas logo abaixo do campo de pesquisa

  Scenario: Selecionar como local de retirada o Aeroporto de Fortaleza
    Given que os resultados de pesquisa do Rental Cars para o local Fortaleza são exibidos
    When o usuário clica sobre a primeira sugestão que é o resultado desejado Aeroporto de Fortaleza
    Then o campo de local de retirada é preenchido automaticamente com a opção desejada

  Scenario: Realizar a pesquisa de carros para aluguel no Aeroporto de Fortaleza
    Given que o campo de local de retirada está preenchido
    When o usuário clica na opção pesquisar
    Then os resultados da pesquisa são apresentados pelo site

  Scenario: Encontrar na página o local de retirada que foi dado como parâmetro
    Given que os resultados da pesquisa foram apresentados na página
    Then o sistema exibe o local de retirada
    And o local de devolução

  Scenario: Checar se o local informado é o mesmo que está exibindo
    Given que o local de retirada
    And o local de devolução foram exibidos
    Then o local deve ser o mesmo informado no campo de pesquisa