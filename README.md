
Tipos de Amortização
Amortização vencida (END)
 O [Módulo de Cálculo Parcelado Brasil], ao receber a identificação de tipo de amortização vencida, considera a série de pagamentos de termos vencidos, em que os pagamentos das parcelas ocorrem no fim de cada período e não no ato da contratação.  
Este tipo de amortização é aplicável para contratação de parcelados com entrada diferente da parcela ou sem entrada, com incidência de juro sobre a primeira parcela. 
Amortização antecipada (BEGIN)
O [Módulo de Cálculo Parcelado Brasil], ao receber a identificação do tipo de produto parcelado e identificar que o parcelamento é total, o valor da entrada será igual às demais parcelas. 
Neste caso, o conceito a ser aplicado é série de pagamentos de termos antecipados, quando os pagamentos ou recebimentos ocorrem no início de cada período unitário. Logo, a primeira parcela é sempre paga ou recebida na data da compra ou assinatura do contrato de financiamento, sem a incidência de juros sobre a primeira parcela.  
Este tipo de amortização é aplicável para parcelados com pagamento da primeira parcela, que corresponde ao valor definido para efetivação do plano.   
Conceitos econômicos não financiá veis
Cálculo de Tarifa
Se produto financeiro parcelado possuir parametrização para cobrança de tarifa (conceito econômico associado à tarifa), o valor deve ser calculado e não deve compor o capital financiado.
O detalhamento do cálculo da tarifa consta no REQ05 – Cálculo de tarifa.
Quando a tarifa a ser cobrada se referir a um percentual sobre o valor financiado a ser aplicado, deve ser calculado o valor correspondente à tarifa utilizando a alíquota correspondente:


 Caso seja determinado que é um valor fixo, deve ser utilizado o valor informado na requisição. 
:

Conceitos econômicos financiáveis
Antes da aplicação de juros, deverão ser apurados os valores que irão ser acrescidos ao valor financiado, como é o caso do seguro prestamista e tributos.
Cálculo de Seguro Prestamista
Quando a contratação do parcelado indicar que será contratado o seguro prestamista, o valor de seguro será incorporado ao capital financiado.  
Para o cálculo do prêmio de seguro, o percentual de prêmio de seguro prestamista deve ser informado na lista de conceitos econômicos no acionamento do [Cálculo de Plano Parcelado Brasil] para que seja apurado o valor de seguro, conforme detalhado no REQ06 - Cálculo de seguro prestamista:

Se não fornecida a informação de percentual de prêmio de seguro, o valor do seguro a ser considerado na apuração do plano será zero.
Cálculo de Tributos
 Na apuração dos planos de financiamento em cartão, há incidência de IOF (imposto sobre operações financeiras).
Para os planos de parcelados com juros no cartão de crédito, há incidência de IOF diário (base) e IOF adicional, descritos a seguir. 
Apuração do IOF financiado (diário) 
Para apuração do IOF financiado (diário), o cálculo é efetuado sobre o valor financiado, calculado linearmente por dias corridos, limitado a 365 dias.  
Este valor deve ser apurado para cada parcela, considerando o intervalo de 1 até o total de parcelas (t), onde:

Valor de IOFfinanciado n = valor do IOF a ser financiado (diário) da parcelan
Valor de Capital Financiadon = Valor do capital financiadon, com arredondamento de 2 casas decimais. O detalhamento consta no 3.1.4  - Apuração do valor de capital total financiado.
Alíquota de IOF financiado = alíquota de IOF financiado (taxa na base diária).
n = número da parcela
tp = total de parcelas
tn = diferença de dias entre a data do vencimento da parcela e a data de referência da contratação, limitado a 365 dias.
IMPORTANTE: A taxa de juros e o tempo devem se referir à mesma unidade de tempo. 
Ex.: taxa ao mês, o tempo tem que ser expresso em meses, se taxa ao ano, tempo em ano, taxa ao dia, tempo deve ser expresso em dias. 
A limitação de 365 dias para a cobrança de IOF é regulatória sendo que parcelas com prazo decorrido desde a contratação superior a 365 devem ter cobrança limitada a 365 dias.
O detalhamento do cálculo do vencimento das parcelas consta no REQ02 – Calcular vencimento das parcelas e o cálculo do IOF financiado no REQ09 – Cálculo de IOF diário.
O valor total de IOF financiado (diário) referente ao IOF financiado do período de financiamento será apurado a partir da somatória dos valores apurados por parcela.  

       

Para a apuração do valor do plano, o IOF financiado é calculado em 2 passagens, sendo que a primeira para apurar o valor de IOF diário ser financiado e posteriormente o valor de IOF diário do plano sobre o valor total do capital financiado.
Apuração do IOF adicional financiado
Além do IOF base, há incidência de IOF adicional sobre o valor financiado, de acordo com a composição do saldo financiado, incidindo sobre as operações de crédito à alíquota adicional vigente, independentemente do prazo da operação, conforme descrito no REQ10 – Cálculo de IOF adicional. 
Importante: O valor de IOF adicional financiado não deve incidir em duplicidade sobre o principal que ficou em atraso pois já houve tributação sobre este valor. Sendo assim, no acionamento do [Motor de Cálculo] o valor base para cálculo do IOF adicional financiado deve ser apurado pelos respectivos módulos origem e repassado ao motor.
Exemplificando a situação para não cobrança em duplicidade, no caso de contratação em atraso, para operações parceladas classificadas como Renegociação de Dívida tais como parcelamento automático, parcelamento de fatura em atraso, total parcelado ou Renegociação (REORG), o valor base para apuração do IOF adicional financiado deve desconsiderar o saldo inicial vencido. Para estas situações, o valor do ajuste referente à contratação do plano será com a data da geração da proposta e não com a data da efetivação do plano. 
Contratações entre corte e vencimento deverão ter o ajuste referente à contratação postado com a data da efetivação do plano.
Para as contratações de parcelamento automático, o valor base para apuração do IOF adicional financiado é zero, uma vez que incidiu a cobrança sobre o saldo do rotativo.
Tabela 1 – Base de cálculo de IOF adicional financiado
CLASSIFICAÇÃO PRODUTO PARCELADO	SALDO INICIAL VENCIDO	BASE DE CÁLCULO      IOF ADICIONAL FINANCIADO
Bandeirado 
(parcelado emissor, Crediário)	N/A.  	Valor financiado. 
Não há compensação.
Empréstimo (Supercrédito, Saque parcelado)	N/A	Valor financiado. 
Não há compensação.
Renegociação – Parcelamento automático	N/A	Zeros pois já houve incidência de IOF sobre valor que está sendo financiado referente ao saldo vencido (rotativo) 
Renegociação – demais
(Reorganização, Parcelamento de fatura) 

Valor financiado maior ou igual ao saldo inicial vencido	Valor Financiado menos (-) Valor do Saldo Inicial Vencido 
	Valor do saldo vencido maior que valor financiado	Zeros pois já houve incidência de IOF sobre valor que está sendo financiado referente ao saldo vencido 
Tabela1:  Valor base de IOF adicional financiado 
Já para os produtos classificados como bandeirados, empréstimo financeiro como o Supercrédito e outros como o parcelamento de transação, não há dedução de valores na base de cálculo do IOF adicional financiado, independentemente se o grupo de fatura estiver ou não em atraso, uma vez que não engloba valores vencidos em sua composição.
Para a apuração do valor do plano, o IOF adicional é calculado em 2 passagens, sendo que a primeira para apurar o valor adicional a ser financiado e posteriormente o valor de IOF adicional do plano, considerando a incorporação dos tributos financiáveis na base de cálculo. 
Apuração do valor de capital total financiado
Após a apuração dos valores referentes aos conceitos econômicos aplicáveis ao produto parcelado, deve ser apurado o valor de capital financiado da operação parcelada. 
Considerando que os valores de IOF serão financiados, deve ser apurado o valor de IOF financiado do plano conforme detalhado no REQ08 – Cálculo do IOF do plano, considerando o valor do capital total financiado.
Já para o IOF adicional do plano, o valor base de cálculo de IOF adicional do plano será calculado conforme descrito no REQ09 a partir do novo valor base:
Deve ser apurado o fator de cálculo de parcela (PMT) e fator de juros compostos para determinar o valor das parcelas e consequentemente o valor total do plano.
Cálculo de juros compostos
Para cálculo de juros do plano, é necessário calcular o fator de cálculo de parcela (PMT) e de juros compostos.
Fator de cálculo de parcela (PMT)
Assim como nos cálculos envolvendo juros simples e juros compostos, no caso do cálculo de prestações tanto a taxa de financiamento quanto o período devem estar na mesma unidade de tempo. Considerando que as parcelas são cobradas mensalmente, seguindo a regra de faturamento, a taxa de juros também deverá ser expressa ao mês. 
A taxa a ser utilizada deve corresponder à atribuída ao conceito econômico de juros.


O fator de cálculo de PMT representa o coeficiente de financiamento, já as variáveis i e n representam respectivamente a taxa de juros cobrada pelo financiamento e o período ou parcelas. O fator deve ser apurado com 8 casas decimais
O período (período_pmt) é resultado da diferença entre a data do início da operação e a data do vencimento de cada parcela.
Todos os valores de fator de cálculo de PMT das parcelas do plano devem ser sumarizadas para cálculo do valor das parcelas:

Exemplo:
i = 4,20  a.m	= 0,042
Data de início: 15/03/2023 
	Amortização Antecipada
Para a apuração de fator de cálculo de PMT, para amortização antecipada, considera a data de início do plano vencimento da primeira parcela.
n = parcela  01  
	Data de vencimento1: 15/03/2023 
	Período_pmt = 0 dias 

n = parcela  02  
Data de início: 15/03/2023
	Data de vencimento2: 05/4/2023 
Como a taxa foi expressa ao mês, deve ser aplicada a proporcionalidade para a base, dividindo por 30 (apuração diária)	
Período_pmt = 21 / 30 = 0,70000000
	  
	Amortização vencida
i = 4,20  a.m	= 0,042
n = parcela  01  	tp= 2 parcelas
	Data de início: 15/03/2023
	Data de vencimento1: 05/4/2023 
	Período_pmt = 21 dias 
	Como a taxa foi expressa ao mês, deve ser aplicada a proporcionalidade para a base, dividindo por 30 (apuração diária)
	Período_pmt= 21 / 30 = 0,70000000
  

n = parcela  02  
Data de início: 15/03/2023
	Data de vencimento2: 05/5/2023 
	Período_pmt = 51 dias 
	Como a taxa foi expressa ao mês, deve ser aplicada a proporcionalidade para a base, dividindo por 30 (apuração diária)
	Período_pmt = 51 / 30 = 1,70000000
  

	Fator de cálculo de juros 
Para apuração dos juros por parcela, deve ser apurado o fator de cálculo de juros. 
O valor de juros de cada parcela será calculado utilizando este fator, onde o período de juros a ser utilizado no cálculo deve ser apurado a partir da diferença entre a data do vencimento da parcela que está sendo calculada e o vencimento da parcela anterior ou a data início do plano quando for a primeira parcela. Tomando como premissa a compatibilização mensal, a diferença apurada deve ser dividida por 30 (equivalente ao mês comercial), para cálculo pro-rata.


Exemplo:
i = 4,20  a.m.	= 0,042
Data de início: 15/03/2023 
O fator de cálculo de juros deve ser calculado com 8 casas decimais, utilizando o critério de arredondamento, aumentando em 1 sempre que o dígito mais significativo do excesso for igual ou maior que 5.

	Amortização Antecipada
Para a apuração de fator de cálculo de juros, para amortização antecipada, considera a data de início do plano vencimento da primeira parcela.
n = parcela 01  
	Data de vencimento1: 15/03/2023 
	Período_juros = 0 dias 

n = parcela 02  
Data de início: 15/03/2023
	Data de vencimento2: 05/04/2023 
Considerando que a taxa foi expressa ao mês, deve ser aplicada a proporcionalidade para a base, dividindo por 30 (apuração diária).  	
Período_juros  = 21 / 30 = 0,70000000
	  
	Amortização vencida
Com base na premissa de equivalência, segue exemplo da aplicação da fórmula a ser considerada para apuração deste fator para período em meses e taxa ao mês.
i = 4,20  a.m	= 0,042
n = parcela  01  
	Data de início: 15/03/2023
	Data de vencimento1: 05/04/2023 
	Período1 = 21 dias 
	Como a taxa foi expressa ao mês, deve ser aplicada a proporcionalidade para a base, dividindo por 30 (apuração diária)
	Período_juros1 = 21 / 30 = 0,70000000
  
n = parcela 02  
Data de início: 05/04/2023
	Data de vencimento2: 05/5/2023 
	Período2= 30 dias 
	Como a taxa foi expressa ao mês, deve ser aplicada a proporcionalidade para a base, dividindo por 30 (apuração diária)
	Período_juros2 = 30 / 30 = 1 

	Saldo do capital pendente 
Para a primeira parcela, o saldo do capital pendente é igual ao valor do capital total financiado.
 
Importante: na primeira apuração, o valor do capital a ser considerado é o valor do capital financiado e para a segunda apuração, referente ao plano, será o valor de capital total financiado.
Para as demais parcelas, o valor do saldo do capital pendente deve ser atualizado amortizando o valor do capital de cada parcela apurada.
 
Capital das parcelas 
Para a primeira parcela, o capital da parcela será igual ao valor do capital financiado. Para a primeira apuração, este valor será o valor do capital financiado e na segunda apuração, o valor de capital total financiado. 
O valor do saldo do capital pendente deve ser atualizado amortizando o valor do capital de cada parcela apurada, exceto para a última, onde o capital deve ser igual ao saldo do capital pendente.
Valor de Juros parcela  
O valor de juros de cada parcela será calculado conforme abaixo:          
n = número da parcela
Saldo capital pendenten = valor do capital pendente para parcelan
Importante: ajustar o valor de juros para a última parcela, de forma que se o saldo não for zeros, o valor deve ser compensado no valor de juros nesta parcela.
Quando a diferença entre o valor da parcela e o principal da respectiva parcela for maior que o valor de juros apurado, o valor de juros amortizado da parcela será igual ao valor de juros desta parcela. Caso contrário, será o valor da diferença do valor da parcela e o respectivo valor principal.
Apuração do plano 
A partir dos cálculos anteriores, o plano de parcelamento é apurado, onde:
 
           
O valor das parcelas deve ser calculado com 2 casas decimais, utilizando o critério de arredondamento, aumentando em 1 sempre que o dígito mais significativo do excesso for igual ou maior que 5.

Requisitos Detalhados 
ID REQ 	Requisito	Detalhe
REQ01	Avaliar dados da requisição	Faz validação dos campos da requisição
REQ02	Calcular vencimento das parcelas	Apurar os vencimentos das parcelas do plano e a quantidade de dias de intervalo entre as a data da contratação e vencimento das parcelas 
REQ03	Cálculo de índices de PMT	Calcular os índices para apuração das parcelas
REQ04	Cálculo de índices de juros	Calcular os índices de juros referente à cada parcela, para apuração da composição das parcelas
REQ05	Cálculo de tarifa	Calcular o valor correspondente à tarifa de contratação do parcelamento, se aplicável 
REQ06	Cálculo de seguro prestamista	Calcular o valor correspondente ao valor de seguro, se aplicável
REQ07	Cálculo do IOF a ser financiado	Calcular o IOF a ser financiado para incorporar ao capital total financiado
REQ08	Cálculo do IOF do plano	Calcular o IOF do plano financiado, considerando o valor total do capital após a inclusão dos encargos financiáveis
REQ09	Cálculo de IOF diário	Calcular o valor de IOF diário, de acordo com o valor base recebido.
REQ10	Cálculo de IOF adicional	Calcular o valor de IOF adicional, de acordo com o valor base recebido.
REQ11	Cálculo do Plano	Calcular os valores do plano 
REQ12	Calcular composição das parcelas	Calcular a composição dos valores de cada parcela
REQ13	Calcular IOF e Seguro da parcela	Calcular o IOF e seguro de cada parcela
REQ14	Calcular custo efetivo total	Calcular o custo efetivo total do plano de parcelamento
REQ15	Calcular equivalência de taxas	Efetuar o cálculo de equivalência de taxas
REQ16	Retornar dados calculados	Retornar os dados apurados referente ao cálculo do plano
REQ17	Registrar log de processos	Registrar o log de retorno no acionamento de serviços para efeito de rastreabilidade
REQ01 - Avaliar dados da requisição
Para calcular um plano de parcelado com juros, as informações de requisição deverão ser validadas conforme regras descritas a seguir:
Identificação do grupo de fatura
	Código do Grupo de fatura (invoiceGroupCode): código do grupo de fatura que será vinculado ao plano de parcelado. Obrigatório.
	Código da moeda(currencyCode): código da moeda que será vinculado ao plano de parcelado. Se moeda diferente de “986”, retornar mensagem de erro e encerrar o fluxo. 
	Módulo origem (nstallmentModuleCode): módulo origem do acionamento do cálculo
	Produto financeiro: código do produto financeiro - Obrigatório 
Dados do cálculo
	Indicador tipo amortização: Campo obrigatório, com domínios esperados: BEGIN-antecipado (para contratação de parcelamento total (entrada = primeira parcela) e END=Vencido, para contratação com entrada diferente da primeira parcela). Se domínio informado, retornar mensagem de erro correspondente e encerrar o fluxo. 
	Quantidade de parcelas (installmentQuantity): quantidade de parcelas para cálculo do plano. Campo obrigatório, maior que zeros. Se não informado ou zerado, retornar mensagem de erro correspondente e encerrar o fluxo.  
	Valor financiado (principalValue) : informar o valor base referente ao cálculo do plano a ser realizado, de acordo com as definições para cada produto financeiro; Valor obrigatório, maior que zeros. Se não informado ou zerado, retornar mensagem de erro correspondente e encerrar o fluxo.
	Tipo fórmula de cálculo (calculateFormulaId): informar o tipo de cálculo a ser efetuado equivalente ao PRO-RATA BR.  
	Indicador de retorno de detalhamento das parcelas (installmentsListIndicator): Informar verdadeiro para retorno do detalhamento dos valores por parcela e falso  para não retornar o detalhamento.  
	Indicativo de cálculo de seguro (insuranceIndicator): deve ser informado se o cálculo deve ou não ser calculado com o valor de seguro prestamista. Verdadeiro para cálculo com seguro e falso se sem seguro. 
	Dia de vencimento (due_day): dia de vencimento da fatura. Obrigatório e deve estar entre 01 e 30. Caso contrário, retornar mensagem de erro.
	Data da operação(operationDate): data da operação. Campo obrigatório e válido para formato data. Caso contrário, retornar mensagem de erro correspondente e encerrar o fluxo.
	Data de vencimento da primeira parcela (dueDateFirstInstallment): data de vencimento da primeira parcela. Se houver carência, será a data de vencimento da parcela considerando fim do ciclo de carência. Campo obrigatório e válido para formato data e não pode ser menor que a data da contratação. Caso contrário, retornar mensagem de erro correspondente e encerrar o fluxo.    
	Valor base IOF adicional original: valor base de IOF adicional, de acordo com a regra de compensação de saldos que incidiram cobrança
Dados de conceitos econômicos aplicáveis ao produto parcelado (lista – enviar de acordo com a relação obtida no [Módulo de taxas]
	Código do conceito econômico (conceptEconomicCode): código do conceito econômico. Se informado, todos os demais campos da estrutura para o item da lista devem ser informados de acordo com a regra de formatação de cada campo.
	Quantidade de casas decimais (decimalPlacesNumber): de acordo com a lista obtida no módulo de taxas. O campo deve ser numérico se o código do conceito econômico for informado. Caso contrário, retornar mensagem de erro correspondente e encerrar o fluxo. 
	Tipo (rateType): configuração do conceito econômico. "P" para percentual ou “F” para valor fixo. Se valor diferente dos domínios aguardados para item de lista com conceito econômico informado, deve ser retornada mensagem correspondente e o fluxo encerrado.
	Percentual (ratePercentual): informar o percentual, quando aplicável. Se tipo for igual a Percentual, campo deve ser numérico Caso contrário, retornar mensagem de erro correspondente e encerrar o fluxo.
	Tipo de conceito (economicConceptValueType): tipo do conceito econômico.
	Valor fixo (FixedValue):  informar o valor fixo, quando aplicável. Se tipo for igual a Valor fixo, campo deve ser numérico. Caso contrário, retornar mensagem de erro correspondente e encerrar o fluxo.

REQ02 – Calcular vencimento das parcelas
Para apuração do valor do plano é necessário determinar as datas de vencimentos das parcelas tendo como base o dia do vencimento atribuído ao grupo de fatura no dia do cálculo do plano e a data de início para apuração. 
O número de parcelas deve corresponder à quantidade de parcelas recebida na  requisição. 
Para a primeira parcela, a data de vencimento será a data de vencimento da primeira parcela recebida na requisição – REQ01 – Avaliar dados da requisição.
Para as parcelas subsequentes, o cálculo do vencimento das parcelas deve considerar o dia de vencimento (DUE_DAY) do grupo de fatura e moeda associado ao plano de parcelamento, para o dia de vencimento no mês subsequente à parcela anterior, considerando somente data com vencimento válido no calendário.   
Ponto de atenção: se dia de vencimento for 29, deve ser avaliado o critério de ano bissexto para considerar vencimento de 29/02 como válido. Caso contrário, a data de vencimento a ser assumida é 01/03. Já para o vencimento 30, independente se o ano for bissexto ou não, o dia 30/02 é inválido, devendo assumir como data de vencimento fixo o dia 01/03.
 
Segue quadro demonstrativo para a regra de cálculo de vencimento:
 Vencimento
(due day) 	29	29	29	30	30	Menor que 29
Parcela	Vencimento 
não bissexto	Vencimento 
bissexto	Bissexto ou não	Bissexto ou não
1	29/01/2023	01/03/2023	29/12/2023	30/01/2023	01/03/2023	DD/01/2023
2	01/03/2023	29/04/2023	29/01/2024	01/03/2023	30/03/2023	DD/02/2023
3	29/03/2023	29/05/2023	29/02/2024	30/03/2023	30/04/2/2023	DD/03/2023
4	29/04/2023	29/06/2023	29/03/2024	30/04/2023	30/05/2023	DD/04/2023
DD = due_day  informado no REQ01- Avaliar dados da requisição.
A data de vencimento de cada parcela será utilizada para apuração dos índices de PMT e juros do plano, conforme descrito no REQ03 - Cálculo de índices de PMT e REQ04 – Cálculo de índices de juros, respectivamente.
A partir do vencimento da última parcela será determinado o prazo total de financiamento da operação.
IMPORTANTE:
A data início, para produtos de renegociação (REORG) ou financiamento de saldo (Parcelamento de fatura, total parcelado, Parcelamento automático), se a data da contratação for pós-vencimento do último extrato faturado, a data início a ser informada será a data da contratação. Caso contrário, será a data do vencimento da fatura. Para os demais produtos, a data início a ser considerada será sempre a data da contratação.
Este detalhamento deve constar na DDR de cada um dos produtos parcelados e a regra aplicada no acionamento do [Cálculo de Plano Parcelado Brasil] 
REQ03 – Cálculo de índices de PMT
Para apuração do valor do plano é necessário determinar os índices a serem aplicados apuração do PMT, que são os valores de pagamentos periódicos e constantes para o financiamento. 
Para o cálculo de PMT, a taxa a ser utilizada é referente ao conceito econômico do tipo .  15 – percentual de juros parcelado.
Antes de iniciar o processo de cálculo, a taxa de juros (rate_percentual) deve estar definida como  percentual  e expressa na base mensal (a.m.). sobre o valor financiado (rateType = “P”), o percentual referente ao conceito econômico deve estar ajustado com o número de casas decimais informado na requisição (decimalPlacesNumber). O percentual (ratePercentual) deve ser adequado com a 2 casas decimais além da quantidade de casas decimais informado na requisição.  
 
Exemplo:  percentual -> 65000 	 quantidade de casas decimais informada = 4, que correspondente a 6,5000%. O acréscimo de 2 casas deve-se ao fato de transformar a taxa em percentual.
Percentual padronizado deve ser gerado com 6 casas decimais
 
Caso a frequência informada para a referida taxa não esteja como mensal (ao mês), deve ser aplicada a equiivalência de taxas, conforme descrito no REQ15  - Calcular equivalência de taxas para então seguir com os demais cálculos.
Se parcelamento com amortização antecipada (Indicador tipo amortização igual a “A”), não há incidência de juros na primeira parcela. Sendo assim, o fator de cálculo do PMT1 será igual a 1 e a aplicação da regra de cálculo do fator inicia-se a partir da segunda parcela.
A quantidade de dias a cobrar para cada parcela deve ser calculada a partir da diferença de dias entre a data de vencimento da parcelan e a data de início do período(n-1).   O período 0 será igual a data de contratação informada no REQ01 – Avaliar dados da requisição.
No cálculo do PMT da parcela deve ser considerado prazo decorrido entre a data início da operação e a data de vencimento de cada parcela. Este valor corresponde à variável período de juros PMT em dias da tabela (j) e também será utilizado no REQ14 – Calcular custo efetivo total.
 
No exemplo abaixo, para uma operação de 12 parcelas, com início em 15/03/23 e vencimento no dia 05. 
O fator de cálculo de PMT da parcelan será calculado considerando a fórmula acima, lembrando que é necessário efetuar a equivalência de taxas e período. 
O fator de cálculo de PMT da parcela deve ser calculado com 8 casas decimais, utilizando o critério de arredondamento, aumentando em 1 sempre que o dígito mais significativo do excesso for igual ou maior que 5.

Exemplo amortização vencida
Considerando que a taxa está expressa ao mês, o período de juros de PMT deve ter a sua equivalência em meses, portanto o período de juros a ser considerado em meses é obtido dividindo o período de juros em dias por 30, conforme exemplo abaixo:
Tabela 1: Cálculo de Fator de juros PMT
Prazo (parcela)	Data	Período de juros PMT (dias)	Período de juros PMT (meses)	Fator de cálculo juros índice de PMT
					
0	15/03/2023	 -	 	 	
1	05/04/2023	21	0,70000000	0,97161139	
2	05/05/2023	51	1,70000000	0,93244855	
3	05/06/2023	82	2,73333333	0,89363788	
4	05/07/2023	112	3,73333333	0,85761792	
5	05/08/2023	143	4,76666667	0,82192188	
6	05/09/2023	174	5,80000000	0,78771158	
7	05/10/2023	204	6,80000000	0,75596121	
8	05/11/2023	235	7,83333333	0,72449635	
9	05/12/2023	265	8,83333333	0,69529400	
10	05/01/2024	296	9,86666667	0,66635425	
11	05/02/2024	327	10,90000000	0,63861904	
12	05/03/2024	356	11,86666667	0,61371923	
 	 	 	Total	9,35939328	
Ao final da apuração dos índices de PMT de todas as parcelas, os índices devem ser sumarizados para apuração do valor do valor da parcela, que será utilizado conforme descrito no REQ11 – Cálculo do Plano.
 
REQ04 – Cálculo de índices de juros
Para calcular o fator para cálculo de juros referente à cada parcela, deve ser apurado o fator correspondente.
 

Prazo (parcela)	Data	Período de juros PMT (dias)	Período de juros (dias)	Período de juros 	Fator de cálculo juros
				(meses)	(taxa = 4,2% a.m.)
0	15/03/2023	 -	 -	 	 
1	05/04/2023	21	21	0,70000000	0,02921807
2	05/05/2023	30	51	1,70000000	0,07244523
3	05/06/2023	31	82	2,73333333	0,11902150
4	05/07/2023	30	112	3,73333333	0,16602041
5	05/08/2023	31	143	4,76666667	0,21666065
6	05/09/2023	31	174	5,80000000	0,26950019
7	05/10/2023	30	204	6,80000000	0,32281920
8	05/11/2023	31	235	7,83333333	0,38026920
9	05/12/2023	30	265	8,83333333	0,43824051
10	05/01/2024	31	296	9,86666667	0,50070326
11	05/02/2024	31	327	10,90000000	0,56587877
12	05/03/2024	29	356	11,86666667	0,62940958
Para o exemplo acima, o fator de cálculo de juros para a parcela 1 será 
〖Fator de cálculo de juros〗_1  =〖(1+0,042)〗^((21/30))-1= 0,02921807
REQ05 – Cálculo de tarifa
Se na lista de conceitos econômicos for informado um conceito econômico cujo  tipo de conceito (economicConceptValueType) se referir a uma tarifa financiada (18– TARIFA FINANCIADA).
Caso contrário, o valor da tarifa a ser retornado será zero.
Percentual
Se tarifa for um percentual sobre o valor financiado (rateType = “P”), o percentual referente ao conceito econômico deve estar ajustado com o número de casas decimais informado na requisição (decimalPlacesNumber). O percentual (ratePercentual) deve ser adequado com a 2 casas decimais além da quantidade de casas decimais informado na requisição.
 
Exemplo:  percentual -> 25123 	 quantidade de casas decimais informada = 4
Percentual padronizado deve ser gerado com 6 casas decimais
 
Após a adequação do percentual, apurar o valor referente ao conceito econômico de Tarifa, gerando um valor com 2 casas decimais.
 
O valor do capital financiado a ser considerado é o Valor financiado recebido na requisição.
Para o exemplo anterior, considerando capital de R$ 200,00, teremos o valor de tarifa apurado de R$ 5,02.
Neste caso, não há necessidade tratar a frequência para validar se há necessidade de efetuar  equivalência de taxa 
Valor Fixo
Se valor fixo (rateType = “F”), o valor da tarifa a ser considerada será o valor fixo (rateFixedValue) ajustado com o número de casas decimais informado na requisição(decimalPlacesNumber), gerando um valor de tarifa com 2 casas decimais.
 
REQ06 – Cálculo de seguro prestamista
Quando informando na lista de conceitos econômicos um conceito econômico cujo tipo de conceito (economicConceptValueType) se referir a um seguro prestamista financiado (19- SEGURO PRESTAMISTA FINANCIADO), serão apurados os valores referentes ao seguro, desde que o Indicativo de seguro prestamista seja igual a “S”.
Caso o conceito econômico de seguro prestamista não seja informado e o indicativo de seguro prestamista seja igual a “S”, deve ser retornada mensagem de erro correspondente.
Se o indicativo de seguro prestamista for igual a “N”, os valores de seguro do plano (alíquota e valor de seguro) devem ser considerados no cálculo do plano como zeros.
Percentual
Para operações com seguro prestamista, se o cálculo for por percentual (rateType = “P”), o prêmio de seguro deve ser apurado após ajuste do percentual correspondente com a 2 casas decimais além da quantidade de casas decimais (decimalPlacesNumber) estabelecida na atribuição do percentual.
 
 Após a padronização do percentual de seguro, apurar o valor referente ao conceito econômico de seguro, gerando um valor com 2 casas decimais.
Para este conceito, não há necessidade tratar a frequência para validar se há necessidade de efetuar  equivalência de taxa.
Valor Fixo
 Se o indicador para o conceito econômico indicar que é um valor fixo (rateType = “F”), o valor do seguro será o valor fixo (rateFixedValue) ajustado com o número de casas decimais informado na requisição(decimalPlacesNumber).

REQ07 – Cálculo do IOF a financiar
Os valores apurados de IOF, tanto o diário quanto o adicional, são financiados, isto é, são acrescidos ao valor do financiamento para apuração do plano final de parcelamento.
Apuração do IOF financiado(diário)  
 
Para apuração da base de financiamento a ser considerado no cálculo de IOF financiado deve ser apurado a partir da soma do valor original da operação (Valor financiado) com valor de seguro do plano. 
Este será o saldo do capital pendente para início do plano de financiamento.
O valor das parcelas, para utilização no cálculo do IOF diário financiado, deve ser calculado com base na fórmula, considerando o critério de arredondamento na segunda casa decimal:
 
Com valor base no valor base deve ser apurado o valor do IOF diário, por parcela, conforme descrito no REQ09 – Cálculo de IOF diário, sendo que o valor da somatória deve ser considerado como valor de IOF financiado. 
O valor de IOF das parcelas deve ser calculado com 2 casas decimais, utilizando o critério de arredondamento, aumentando em 1 sempre que o dígito mais significativo do excesso for igual ou maior que 5.
 Cálculo de IOF adicional financiado 
Da mesma forma que o IOF diário, deve ser apurado o valor de IOF adicional a ser financiado. 
O valor base de cálculo de IOF adicional deve levar em consideração a classificação do produto parcelado e se há saldo remanescente no valor financiado em que houve incidência de IOF adicional.  
Este valor apurado deve ser considerado como capital financiado no cálculo do referido IOF.
 
O valor base IOF adicional original deve ser o  Valor base de IOF adicional recebido na requisição.
A regra de cálculo está descrita no REQ10 – Cálculo de IOF adicional. 
O valor apurado no cálculo será considerado o valor de IOF adicional financiável.
Na sequência, deve ser apurado o valor total do plano, conforme descrito no REQ11 – cálculo do plano.
REQ08 – Cálculo do IOF do plano
Após o cálculo do valor de IOF diário de financiamento e do IOF adicionado financiado, deve ser apurado os valores de IOF correspondentes ao plano.
Cálculo de IOF diário do plano 
 Deve ser apurado o valor de IOF diário do plano considerando como valor base de cálculo o valor de financiamento.
Este valor apurado deve ser considerado como capital financiado no cálculo do referido IOF.
O valor das parcelas, para utilização no cálculo do IOF diário do plano, deve ser calculado com base na fórmula, considerando o critério de arredondamento na segunda casa decimal:
 
O valor de IOF das parcelas desta passagem deve ser calculado com 2 casas decimais, utilizando o critério de arredondamento, aumentando em 1 sempre que o dígito mais significativo do excesso for igual ou maior que 5.

A regra de cálculo está descrita no REQ09– Cálculo de IOF diário e o valor referente à somatória deve ser considerado como valor de IOF diário do plano.
Cálculo de IOF adicional do plano 
Após o cálculo do valor de IOF diário de financiamento e do IOF adicionado financiado, deve ser apurado o valor de IOF adicional do plano, considerando como valor base de IOF adicional do plano o valor base de IOF adicional recebido no acionamento do cálculo acrescido dos valores de seguro, valor de tarifa e valor de IOF financiado e Valor de IOF adicional financiado.
A regra de cálculo está descrita no REQ10 – Cálculo de IOF adicional.
O valor apurado no cálculo será considerado o valor de IOF adicional do plano.
A soma dos valores de IOF adicional do plano e Valor de IOF diário do plano resultam no valor de IOF total do plano.
REQ09 – Cálculo de IOF diário
Para apuração do valor de IOF, o cálculo a ser aplicado é obtido a partir da aplicação do percentual de IOF base correspondente sobre o valor base de cálculo e pelo período referência.
A alíquota correspondente ao conceito econômico de IOF diário é pelo tipo de conceito (economicConceptValueType) de IOF de parcelado (16 - IOF FINANCIADO PARCELADO).
O tipo de conceito econômico neste caso deve ser percentual (rateType = “P”). Caso não seja, retornar mensagem de erro e finalizar o fluxo.
Deve ser efetuada a normalização do percentual correspondente à alíquota de IOF diário. O percentual deve ser ajustado com a 2 casas decimais além da quantidade de casas decimais(decimalPlacesNumber) informado na requisição, para utilização do valor na forma percentual.
 
Atenção: Se o percentual informado for expresso na base mensal, o valor apurado deve ser divido por 30 para se chegar à alíquota diária.  



O IOF diário (básico) só incide sobre o financiamento ou empréstimo nos primeiros 365 dias (calendário civil), contados a partir da data de liberação do valor pela instituição financeira, sendo assim, para parcelas cujo prazo entre a data da contratação e a data do vencimento da parcela exceda este limite, o cálculo deve se ser efetuado considerando o prazo máximo.
É necessário efetuar a composição de cada parcela conforme descrito no REQ12 – Calcular composição das parcelas e obter o capital financiado de cada parcela para apuração do IOF diário.  
 

IOFparcela n = valor do IOF base para a parcela n
Valor do Capital financiado parcela n = Valor do capital financiado para a parcelan
Alíquota de IOF diário padronizada= alíquota de IOF diário   
n = número da parcela
tp = total de parcelas
tn = diferença de dias entre a data do vencimento da parcela e a data de referência da contratação, limitado a 365 dias.
O valor total de IOF diário para este cálculo será apurado através da somatória referente ao IOF diário do período de financiamento. 
 
REQ10 – Cálculo de IOF adicional  
Para apuração do valor de IOF adicional, o cálculo a ser aplicado é obtido a partir da aplicação do percentual de IOF adicional sobre o valor base de cálculo.
Para efetuar o cálculo, deve ser utilizada a alíquota a ser aplicada para o conceito econômico do tipo 17 - IOF ADICIONAL FINANCIADO (PARCELADO). 
O tipo de conceito econômico deve ser percentual (rateType = “P”). Caso não seja, retornar mensagem de erro e finalizar o fluxo.
De posse da alíquota correspondente ao conceito econômico de IOF adicional, deve ser efetuada a normalização do percentual correspondente à alíquota de IOF adicional. O percentual deve ser ajustado com a 2 casas decimais além da quantidade de casas decimais (decimalPlacesNumber) informado na requisição, para utilização do valor na forma percentual.
 
O valor base de IOF adicional será calculado considerando como valor base o valor de IOF adicional financiado (primeira apuração) ou valor de IOF adicional plano (segunda apuração), de acordo com o processo origem de acionamento do cálculo do IOF adicional.  
 
O valor de IOF adicional deve ser calculado com 2 casas decimais, utilizando o critério de arredondamento, aumentando em 1 sempre que o dígito mais significativo do excesso for igual ou maior que 5.

REQ11 – Cálculo do Plano
O capital total será apurado considerando a somatória do valor financiado original, acrescido do valor de IOF total, seguro prestamista.

O valor das parcelas deve ser calculado com 2 casas decimais, utilizando o critério de arredondamento, aumentando em 1 sempre que o dígito mais significativo do excesso for igual ou maior que 5.
 
A partir do cálculo do valor das parcelas, deve ser efetuado o cálculo de composição das parcelas do plano para calcular o plano de financiamento conforme descrito no REQ12 – Calcular composição das parcelas, tomando como base de saldo de capital pendente o valor apurado de Capital Total.
O valor total do plano é calculado é resultante da somatória abaixo:
 
REQ12 – Calcular composição das parcelas
Deve ser apurado o valor individual de cada parcela para então efetuar a composição do plano de financiamento.
Para a apuração do valor total de juros do plano, os valores de juros de cada parcela devem ser sumarizados.
O capital de cada parcela deve ser deduzido do saldo de capital pendente, que será utilizado para cálculo das parcelas subsequentes. 
Para a primeira parcela, o capital pendente é referente ao Capital financiado, de acordo com o processo que a apuração se refere, sendo: 
	apuração de IOF diário financiado:
	Capital financiado = valor REQ diário 
	Valor da parcela = Valor das parcelas IOF1
	apuração do IOF diário do plano:
	Capital financiado =  valor Base IOF diário plano
	Valor da parcela = Valor das parcelas IOF2

Última parcela
Para a última parcela, o valor de juros será apurado considerando o valor residual de juros em relação ao montante de juros apurados nas demais parcelas. 
Nesta situação, o valor do capital da parcela será igual ao saldo do capital pendente e o valor de juros da parcela deve ser calculado a partir da subtração do valor da parcela menos o valor do capital da parcela.
O valor de juros da última parcela deve ser acrescido ao valor acumulado de juros do plano.
Demais parcelas
Exceto para última parcela, o cálculo deve ser apurado os valores de juros conforme abaixo, considerando o arredondamento na 3ª casa decimal.

Deve ser apurado o saldo de juros remanescente a cada parcela calculada:

A partir dos cálculos efetuados, serão avaliadas as situações:
Saldo remanescente de juros maior que parcela
Quando o saldo remanescente de juros exceder o valor da parcela, o valor de juros residual deve ser acrescido da diferença entre o valor de juros da parcelan e o valor da parcela.
 Neste caso, o valor de juros da parcela será igual ao valor da parcela, não havendo capital a ser amortizado nesta parcela.
 
 
Saldo remanescente de juros menor ou igual à parcela
Qaundo o saldo remanescente de juros é igual ou inferior ao valor da parcela, o capital a ser amortizado na parcela será apurado conforme abaixo:
 
 Neste caso o valor de juros residual deve ser incorporado ao valor total de juros do plano.
 
 
Na sequência, o valor de juros residual deve ser zerado.
Independentemente da tratativa do saldo remanescente,  o  valor de juros apurado por parcela deve ser acumulado para composição do plano.
 
REQ13 – Calcular IOF e Seguro da parcela
Para apuração do IOF da parcela e o seguro associado, quando houver, deve ser efetuado o cálculo descrito a seguir:
Cálculo do IOF adicional parcela
Para a última parcela, o respectivo IOF adicional corresponde à diferença do IOF adicional total menos a somatória dos valores de IOF adicional das parcelas anteriores.
 
tp: total de parcelas
Para demais as parcelas, o valor de IOF adicional da parcela deve ser  calculado através da fórmula:
 
 
Cálculo do valor de seguro da parcela
Para a última parcela, o valor do seguro da parcela será obtido através do cálculo da diferença do valor total de seguro menos a somatória dos valores de seguro das parcelas anteriores.
 
Caso contrário, o valor de seguro das demais parcelas corresponde ao valor de seguro proporcional ao percentual correspondente ao valor do capital da parcela sobre o capital total, considerando a fórmula:
 
O valor de juros de seguro de cada parcela deve ser calculado considerando a aplicação do índice de juros da parcela, conforme cálculo descrito a seguir.
  
Os valores apurados de juros de seguro das parcelas devem ser acumulados para compor o total de juros de seguro do plano. 
  
REQ14 – Calcular custo efetivo total
Para apuração do custo efetivo total, deverá ser aplicada a fórmula para Cálculo do CET.

onde: 
	FC0 = valor do crédito concedido, deduzido, se for o caso, das despesas e tarifas pagas antecipadamente, o equivalente o valor financiado recebido no REQ01 – Avaliar dados da requisição.  
	FC1 = valores cobrados pela instituição, periódicos ou não, incluindo as amortizações, juros, prêmio de seguro e tarifa de cadastro ou de renovação de cadastro, quando for o caso, bem como qualquer outro custo ou encargo cobrado em decorrência da operação
	j = j-ésimo intervalo existente entre a data do pagamento dos valores periódicos e a data do desembolso inicial, expresso em dias corridos. Este intervalo foi apurado por parcela (período de juros PMT expresso na base de dias), conforme descrito no REQ03 – Cálculo de índices de PMT.   
p = prazo do contrato, expresso em dias corridos, que correspondente ao período de juros  PMT referente à última parcela; 
dj = data do pagamento dos valores cobrados, periódicos ou não (FC~), que correspondente `data de vencimento da parcelan, conforme apurado no REQ02 – Calcular vencimento das parcelas.  
d0 = data da liberação do crédito pela instituição (FC0), que corresponde à data da contratação do plano parcelado. 
O CET deve ser expresso na forma de taxa percentual anual, incluindo todos os encargos e despesas das operações, isto é, o CET deve englobar não apenas a taxa de juros, mas também tarifas, tributos, seguros e outras despesas cobradas do cliente, representando as condições vigentes na data do cálculo.
Exemplo:  
Valor Financiado - R$ 4.042,76
Taxa de juros - 14,6400 % ao mês
Data da contratação: 22/06/2023
Data de vencimento das parcelas: 22
Prazo da operação - 5 meses
Prestação mensal - R$ 1.128,03 
De acordo com a fórmula, o FCo (valor do crédito concedido) e o FCj (valores cobrados pela instituição), seriam
os seguintes:
FCo = R$ 4042,76
FCj = R$ 1.128,03 
Considerando as prestações pagas de acordo com o intervalo de período da contratação e vencimento das parcelas, temos:  
CET = 796,4500% ao ano ou 19,7500% ao mês.
Prazo	Data	Saldo 	Saldo Juros	Saldo Principal	Principal	Juros	Pagamento Juros	PMT	IOF	Dias cobrados de juros	aux_pmt	altera	Seguro
0	22/06/2023	 R$         4.355,51 	 	 R$              4.355,51 	 	 	 	 	 	 	 	R$ 0,00	 
1	22/06/2023	 R$         3.227,48 	 R$                           -   	 R$              3.227,48 	 R$          1.128,03 	 R$                   -   	 R$                          0,000 	 R$      1.128,03 	 R$                1,08 	0	                          1,0000 	       1.128,03 	 R$                 74,34 
2	22/07/2023	 R$         2.571,95 	 R$                           -   	 R$              2.571,95 	 R$             655,53 	 R$         472,50 	 R$                        472,50 	 R$      1.128,03 	 R$                2,24 	30	                          0,8723 	           941,96 	 R$                 43,20 
3	22/08/2023	 R$         1.833,91 	 R$                           -   	 R$              1.833,91 	 R$             738,04 	 R$         389,99 	 R$                        389,99 	 R$      1.128,03 	 R$                4,39 	31	                          0,7574 	           781,86 	 R$                 48,64 
4	22/09/2023	 R$             983,96 	 R$                           -   	 R$                 983,96 	 R$             849,95 	 R$         278,08 	 R$                        278,08 	 R$      1.128,03 	 R$                7,22 	31	                          0,6577 	           648,98 	 R$                 56,01 
5	22/10/2023	 R$                      -   	 R$                           -   	 R$                           -   	 R$             983,96 	 R$         144,07 	 R$                        144,07 	 R$      1.128,03 	 R$              10,78 	30	                          0,5737 	           541,93 	 R$                 64,84 
O cálculo do  custo efetivo total  deve considerar o critério de arredondamento com 7 casas decimais. Ao final do cálculo, o custo efetivo deve ser apresentado com 2 casas decimais.
 

Também deve ser apurado o custo efetivo total ao ano, tomando como taxa base mensal (CET) e aplicando regra de equivalência de taxas conforme descrito no REQ15 – Calcular equivalência de taxas.
Ao término da apuração do custo efetivo total, os valores do plano devem ser retornados como resposta, conforme descrito no REQ16 – Retornar dados calculados.
REQ15 – Calcular equivalência de taxas
Para calcular o plano de parcelamento, considerando o período entre os vencimentos com frequência mensal:
 
 
Segue abaixo alguns exemplos de equivalência de taxas:
Taxa de juros ao mês para ao ano 
Considerando i a taxa de juros padronizada na forma percentual, conforme descrito no REQ03 – Cálculo de índices PMT, sendo a taxa informada expressa ao mês, temos que considerar o período de 12 meses, o equivalente a um ano, aplicando a fórmula:
 
Considerando o exemplo de taxa de 8,5000% a.m e 4 casas decimais, temos: 
Como a taxa deve ser retornada com o mesmo número de casas decimais recebido, deve ser formatado somente com a parte inteira, retornando 1661686, que corresponde a taxa de 166,1686% ao ano. 
Taxa de juros ao dia para ao mês
Considerando i a taxa de juros padronizada na forma percentual, conforme descrito no REQ03 – Cálculo de índices PMT, sendo a taxa informada expressa ao dia, temos que considerar o período de 365, o equivalente a um ano, aplicando a fórmula:
 
Considerando o exemplo de taxa de 0,1000% a.d. e 4 casas decimais., temos:
 
Como a taxa deve ser retornada com o mesmo número de casas decimais recebido, deve ser formatado somente com a parte inteira, retornando 30439, equivalente à taxa de 3,0439 % ao mês. 
Taxa de juros ao ano para ao mês
Considerando i a taxa de juros padronizada na forma percentual, conforme descrito no REQ03 – Cálculo de índices PMT, sendo a taxa informada expressa ao ano, temos que considerar o período de 1/12, o equivalente a um mês, aplicando a fórmula:
 
Considerando o exemplo de taxa de 12% a.a. e 4 casas decimais., temos:
 
Como a taxa deve ser retornada com o mesmo número de casas decimais recebido, deve ser formatado somente com a parte inteira, retornando 9358, equivalente à taxa de 0,9358 % ao mês. 

REQ16 – Retornar dados calculados
Após o cálculo dos dados o plano, devem ser retornados como resposta
Dados de resposta - Plano
	Valor da parcela(installmentValue): valor das parcelas
	Data da primeira parcela (dueDateFirstInstallment): data de vencimento da  primeira parcela pós-contratação.
	Taxa de juros ao mês(interestRateMonthly): será retornada a taxa de juros ao mês utilizado no cálculo do plano de parcelamento, de acordo com o padronizado para o número de casas decimais no REQ03 – Cálculo de índices de PMT.
	Taxa de juros ao ano (interestRateYearly): deve ser retornada a taxa de juros equivalente na base anual, tomando como taxa base mensal o valor atribuído no campo taxa de juros ao mês, conforme regra de equivalência definida no REQ15 – Calcular equivalência de taxas.
	Valor do capital original(originalCapitalValue): valor do capital financiado original, ou seja, o valor financiado recebido no REQ01 – Avaliar dados da requisição.  
	Valor do capital financiado (valueCapitalFinanced): valor total do capital financiado acrescido dos demais encargos, que corresponde ao Valor base IOF diário plano apurado no REQ08 – cálculo do IOF do plano.
	Valor de juros de Seguro(insuranceInterestAmount): formatar com valor juros seguro plano, conforme calculado no REQ13 – Cálculo IOF e seguro das parcelas não associar ao conceito econômico)
	Valor total da operação(totalValueOperation): valor total da operação de crédito, conforme calculado no REQ11 – Cálculo do Plano, que corresponderá ao 100% da composição do CET.
Dados adicionais:
	Custo efetivo total ao mês(totalEffectiveCostPerMonth): custo efetivo total ao mês apurado REQ14 – Calcular Custo efetivo total 
	Código do conceito econômico referente ao custo efetivo total ao mês(valueTypeTotalEffectiveCostPerMonth): 9119 
	Tipo do conceito referente ao custo efetivo total ao mês (valueTypeTotalEffectiveCostPerMonth): 99
	Custo efetivo total ao ano (totalEffectiveCostPerYear): custo efetivo total ao ano apurado com base no custo efetivo total ao mês no REQ14 – Calcular Custo efetivo total, pelo critério de equivalência de taxas, conforme exemplificado no REQ15 – Calcular equivalência de taxas.
	Código do conceito econômico referente ao custo efetivo total ao mês(valueTypeTotalEffectiveCostPerYear): 9120 
	Tipo do conceito referente ao custo efetivo total ao ano(valueTypeTotalEffectiveCostPerYear) : 99
	Percentual do capital original na composição de CET(capitalPercentageComposeTotalEffectiveCost): percentual do valor do capital original operação, considerando a composição de CET.

	Dados de calculados por conceito econômico (lista – 10 ocorrências) enviar de de acordo com os valores calculados para os conceitos econômicos recebidos)
	Código do conceito econômico (conceptEconomicCode): código do conceito econômico referente à composição do plano.
	Tipo de conceito(economicConceptValueType): tipo de importe do conceito econômico.
	Quantidade de casas decimais(decimalPlacesNumber): número de casas decimais definida para o conceito econômico. 
	Frequência da taxa(rateFrequency): informar a frequência de taxa (base de taxa), de acordo, com o recebido na requisição.
	Percentual (ratePercentual): informar o percentual, quando aplicável, na mesma base que foi informado na requisição.  Se conceito for valor fixo, retornar zero.
	Valor calculado(calculatedValueRespective):  informar o apurado, de acordo com o conceito econômico. 
Se tarifa, retornar o valor tarifa apurado conforme REQ05 – Cálculo de tarifa.
Para juros, atribuir o valor total de juros conforme REQ12 – Calcular composição das parcelas
Se valor de seguro prestamista, retornar o valor  apurado no REQ06 – Cálculo de seguro prestamista.
Se IOF diário, retornar o valor apurado conforme REQ08 -  Cálculo de IOF do plano, para o IOF diário.
Se Valor de IOF adicional, atribuir o  valor apurado no REQ08 – Cálculo de IOF do plano, para o IOF adicional.
	Percentual do valor do conceito na composição de CET(totalEffectiveCostPercentage): percentual do valor apurado em relação ao valor total da operação, considerando a composição de CET.

	Composição por Parcela (lista com quantidade igual ao número total de parcelas). Deve ser formatado de acordo com a quantidade de parcelas do plano calculado e processos de apuração, somente se Indicador de retorno de detalhamento das parcelas for  “S” - sim   
	Número da Parcela(installmentNumber):  número da parcela, de 1 até total de parcelas.
	Quantidade de dias(daysQuantityBetweenDueDates): Quantidade de dias a decorrer até o vencimento da parcela correspondente 
	Data de vencimento da parcela(installmentDueDate): data de vencimento da parcela  
	Valor da parcela(installmentValue): valor da parcela.
	Valor de Capital da parcela(principalBalanceAmount): valor do capital da parcela
	Valor de juros de seguro: (insuranceInterestValue): valor de juros relativo ao seguro da parcela
	Valores dos  conceitos econômicos apurados por parcela (10 ocorrências):
	Código do conceito econômico (economicConceptCode): código do conceito econômico referente à composição do plano.
	Valor calculado(calculatedValue): informar de acordo com o conceito apurado no REQ12 – Calcular composição das parcelas   

Importante: os percentuais relativos à composição dos valores em relação ao custo efetivo total devem ser calculados na forma decimal utilizando o critério de arredondamento com 4 casas decimais e na sequência efetuar a conversão para a forma percentual, resultando em 2 casas decimais. 
REQ17 – Registrar log de processos
Os processos devem registrar as logs de erro e sucesso nas integrações com serviços / tópicos com o objetivo de rastreabilidade, contendo as informações que possibilitem identificar o processo, os dados de requisição e o código de resposta e descritivo referente ao fato motivador (sucesso, erro ou alerta). 
