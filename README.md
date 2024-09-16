Projeto Java Escritório de Advocacia

Desafio:

- Criar um programa na linguagem java, utilizando os temas, polimorfismo, e scanner. 

- O sistema será de um escritório de advocacia.

- Nas linhas de código deve ter;

- Áreas de atuação;

- Quantos advogados por área de atuação; 

- Clientes, sendo que clientes pode ser uma pessoa física ou jurídica.
- Honorários advocatícios;

- Processos; 

- Tribunais vinculados aos processos.

1. Requisitos Funcionais

1. Cadastro de Áreas de Atuação:
    * Descrição: O sistema deve permitir o cadastro de diferentes áreas de atuação dos advogados.
    * 
    * Requisitos:
        * O sistema deve armazenar e listar as áreas de atuação.
        * Deve ser possível adicionar novas áreas de atuação.
        * 
2. Cadastro de Advogados:
    * Descrição: O sistema deve permitir o cadastro de advogados e associá-los a áreas de atuação.
    * 
    * Requisitos:
        * O sistema deve permitir a entrada de dados como nome e área de atuação do advogado.
        * 
        * Deve ser possível listar advogados e a quantidade de advogados por área de atuação.
        * 
3. Cadastro de Clientes:
    * Descrição: O sistema deve permitir o cadastro de clientes, que podem ser pessoas físicas ou jurídicas.
    * 
    * Requisitos:
        * O sistema deve diferenciar entre clientes pessoa física e pessoa jurídica.
        * Deve ser possível armazenar informações básicas como nome e tipo de cliente.
        * 
4. Cadastro de Processos:
    * Descrição: O sistema deve permitir o cadastro de processos associados a clientes e tribunais.
    * 
    * Requisitos:
        * O sistema deve permitir a entrada de dados como descrição do processo, tribunal e cliente.
        * Deve ser possível listar os processos com seus detalhes.
        * 
5. Associar Advogados a Processos (Opcional):
    * Descrição: O sistema pode permitir a associação de advogados a processos específicos.
    * 
    * Requisitos:
        * O sistema deve permitir a seleção de advogados para cada processo.
        * 
6. Relatórios e Consultas:
    * Descrição: O sistema deve fornecer relatórios e consultas sobre advogados e processos.
    * 
    * Requisitos:
        * Deve ser possível consultar a quantidade de advogados em cada área de atuação.
        * Deve ser possível listar todos os processos e seus detalhes.


2. Casos de Uso

1. Adicionar Advogado:
    * Ator: Administrador
    * Descrição: O administrador insere os dados de um novo advogado, incluindo nome e área de atuação.
    * 
2. Adicionar Cliente:
    * Ator: Administrador
    * Descrição: O administrador insere os dados de um novo cliente, especificando se é pessoa física ou jurídica.
    * 
3. Adicionar Processo:
    * Ator: Administrador
    * Descrição: O administrador insere os detalhes de um novo processo, associando-o a um cliente e a um tribunal.
    * 
4. Listar Áreas de Atuação:
    * Ator: Administrador
    * Descrição: O administrador solicita uma lista de todas as áreas de atuação cadastradas.
    * 
5. Listar Advogados por Área de Atuação:
    * Ator: Administrador
    * Descrição: O administrador solicita a quantidade de advogados por uma área específica de atuação.
    * 
6. Listar Processos:
    * Ator: Administrador
    * Descrição: O administrador solicita uma lista de todos os processos cadastrados, incluindo suas descrições e tribunais.



