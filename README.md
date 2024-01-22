Autor: Jaderson Barrozo Nascimento Descrição: Projeto realizado como teste para empresa Tokio Marine

Utilizei Angular 16, pois a versão 17 ainda tem muitas imcompatilibilidades com bibliotecas que gosto de utilizar e isso acaba sendo normal por ser uma versão recente. NgBootstrap ainda não tem versão para Angular 17 e gosto de NgBootstrap.

Anotações: Estou a assumir que o banco para o qual trabalho só tem uma agência e vou trabalhar só com as contas. Ex: Nubank

Back-end

Coloquei as regras das taxas no banco de dados para serem mais fáceis de serem mudadas caso hajam alterações no negócio
Fiz a instalação do checkstyle para manter padronização de código
Estou a realizar todos os cálculos mais importantes no back-end, pois não confio na precisão matemática do javascript kkk
Vou utilizar uma simples implementação de MVC para criação da api rest
Adicionei o Lombok para aumentar a eficiência na produção de código diminuindo a quantidade de linhas -Preferi colocar o nome do campo que se refere ao dia em que aconteceu o agendamento como data_criacao e o dia que a transferencia aconteceu como data_transferencia para ter mais sentido, pois tentei usar data_agendamento e data_transferencia e acabei julgando redundante demais.
Escolhi angular, pois já trabalho com ele tem 8 anos e gosto muito da estrutura e coerência que tem.
Gosto de pré-processadores de css e tenho costume de usar SASS, mas não quis usar nesse projeto.
Escolhi utilizar Ng-bootstrap como biblioteca de componentes para agilizar o projeto
Tentei implementar os toasts da biblioteca só que acabei tendo dificuldade então fiz algo genérico para poder ter as notificações
Acabei deixando alguns detalhes para trás, mas acredito que este projeto já prova o conhecimento que tenho
Instruções back-end

Para rodar o projeto basta baixar na sua máquina tendo java 17 configurado ou abrir o projeto no intellij
Após isso basta rodar mvn spring-boot:run
O projeto irá rodar na porta 8080 no endereço http://localhost:8080
Instruções para rodar o projeto front-end

O link para o projeto front-end

https://github.com/jaderdev/tokio.marine-front

Primeiro basta baixar o projeto em sua máquina e rodar npm install para poder ter todas as dependências necessárias. Depois npm start --open e o projeto já deve funcionar ele roda na porta 4200 e será aberto na url

http://localhost:4200
