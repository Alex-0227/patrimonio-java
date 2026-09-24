# Sistema de Gerenciamento Patrimonial
Sistema desenvolvido em Java para gerenciamento e controle de patrimônios de uma instituição de educação profissional.

O projeto tem como objetivo centralizar o cadastro, organização, movimentação e controle dos bens patrimoniais da instituição, proporcionando uma estrutura organizada para o gerenciamento dessas informações.

A aplicação utiliza Java como linguagem de programação e MySQL como sistema gerenciador de banco de dados. A estrutura do código foi organizada buscando aplicar os princípios SOLID, favorecendo a separação de responsabilidades, manutenção e evolução do sistema.

## 📋 Sumário
Sobre o projeto

Objetivos

Tecnologias utilizadas

Princípios e conceitos utilizados

Arquitetura do projeto

Estrutura de pacotes

Banco de dados

Tabelas do sistema

Fluxo geral do sistema

Pré-requisitos

Configuração do banco de dados

Configuração do projeto

Execução

Organização do código

Boas práticas

Possíveis funcionalidades

Contribuição

Licença

Autor

## 📌 Sobre o projeto
O Sistema de Gerenciamento Patrimonial foi desenvolvido com a finalidade de auxiliar uma instituição de educação profissional no controle e gerenciamento de seus patrimônios.

O sistema busca oferecer uma estrutura para organizar informações relacionadas aos bens da instituição, suas categorias, locais, cursos, movimentações, baixas patrimoniais e usuários.

A aplicação foi estruturada utilizando uma separação de responsabilidades entre os componentes do sistema, utilizando principalmente os conceitos de:

POJO para representação dos dados;

DAO para acesso e persistência das informações;

Janela para as interfaces da aplicação;

Imagens para os recursos visuais utilizados pelo sistema.

## 🎯 Objetivos
Objetivo geral
Desenvolver um sistema capaz de auxiliar no gerenciamento dos patrimônios de uma instituição de educação profissional, permitindo organizar e controlar os bens cadastrados no sistema.

Objetivos específicos
Organizar o cadastro dos patrimônios;

Categorizar os bens patrimoniais;

Controlar os locais relacionados aos patrimônios;

Registrar movimentações patrimoniais;

Registrar baixas patrimoniais;

Relacionar informações patrimoniais aos cursos da instituição;

Controlar os usuários do sistema;

Centralizar as informações em um banco de dados MySQL;

Facilitar a manutenção e evolução do código;

Aplicar princípios de desenvolvimento de software, especialmente os princípios SOLID.

## 💻 Tecnologias utilizadas
As principais tecnologias utilizadas no desenvolvimento do projeto são:

Tecnologia	Utilização
Java	Linguagem principal da aplicação
MySQL	Sistema gerenciador de banco de dados
JDBC	Comunicação entre a aplicação Java e o banco de dados
Git	Controle de versão
GitHub	Hospedagem e gerenciamento do código-fonte

As tecnologias acima representam a estrutura principal conhecida do projeto. Dependências adicionais podem ser incluídas conforme a evolução da aplicação.

## 🧠 Princípios e conceitos utilizados
O projeto busca utilizar os princípios SOLID como referência para a organização e desenvolvimento do código.

S — Single Responsibility Principle
Princípio da Responsabilidade Única

Cada classe deve possuir uma responsabilidade bem definida.

No projeto, essa separação pode ser observada na divisão entre classes responsáveis pela representação dos dados, acesso ao banco de dados e interface da aplicação.

O — Open/Closed Principle
Princípio Aberto/Fechado

As estruturas do sistema devem permitir extensão sem que seja necessário modificar excessivamente funcionalidades já existentes.

Essa abordagem facilita a inclusão de novas funcionalidades ao sistema.

L — Liskov Substitution Principle
Princípio da Substituição de Liskov

Classes derivadas devem poder substituir suas classes base sem alterar o comportamento esperado do sistema.

Esse princípio deve ser considerado principalmente quando forem utilizadas hierarquias de classes ou interfaces.

I — Interface Segregation Principle
Princípio da Segregação de Interfaces

As classes não devem ser obrigadas a depender de métodos que não utilizam.

A utilização de interfaces menores e específicas pode contribuir para uma arquitetura mais organizada.

D — Dependency Inversion Principle
Princípio da Inversão de Dependência

Os componentes de alto nível não devem depender diretamente de implementações de baixo nível.

Sempre que aplicável, o projeto pode utilizar abstrações para reduzir o acoplamento entre os componentes.

## 🏗️ Arquitetura do projeto
A aplicação foi organizada buscando separar as responsabilidades de acordo com a função desempenhada por cada componente.

Uma representação simplificada da arquitetura é:
```
┌─────────────────────────────┐
│           Janela            │
│      Interface gráfica      │
└──────────────┬──────────────┘
               │
               ▼
┌─────────────────────────────┐
│            DAO              │
│   Acesso aos dados / SQL    │
└──────────────┬──────────────┘
               │
               ▼
┌─────────────────────────────┐
│           MySQL             │
│          hakodb             │
└─────────────────────────────┘

             ▲
             │
┌─────────────────────────────┐
│            POJO             │
│  Representação dos dados    │
└─────────────────────────────┘

┌─────────────────────────────┐
│          imagens            │
│    Recursos visuais         │
└─────────────────────────────┘
```
Essa divisão tem como objetivo evitar que a interface gráfica, a lógica de acesso ao banco e a representação dos dados fiquem concentradas em uma mesma classe.

## 📦 Estrutura de pacotes
O projeto está organizado nos seguintes pacotes principais:
```
src/
├── POJO/
├── DAO/
├── Janela/
└── imagens/
```
## 📦 POJO
O pacote POJO contém as classes responsáveis por representar os dados utilizados pela aplicação.

As classes desse pacote normalmente possuem atributos, construtores, getters e setters relacionados às entidades do sistema.

Exemplo conceitual:
```
POJO
├── Patrimonio
├── Categoria
├── Curso
├── Local
├── Movimentacao
├── BaixaPatrimonial
└── Usuario
```
A relação acima representa uma organização conceitual. Os nomes reais das classes podem variar de acordo com a implementação do projeto.

## 📦 DAO
O pacote DAO concentra as classes responsáveis pelo acesso ao banco de dados.

O padrão DAO — Data Access Object tem como objetivo separar a lógica de persistência dos demais componentes da aplicação.

Exemplo conceitual:

DAO
├── PatrimonioDAO
├── CategoriaDAO
├── CursoDAO
├── LocalDAO
├── MovimentacaoDAO
├── BaixaPatrimonialDAO
└── UsuarioDAO

Entre as responsabilidades dos DAOs podem estar:

Inserção de registros;

Consulta de registros;

Atualização de registros;

Exclusão de registros;

Execução de consultas SQL;

Comunicação com o banco de dados.

## 📦 Janela
O pacote Janela contém as estruturas relacionadas às interfaces da aplicação.

Essas classes são responsáveis pela interação do usuário com o sistema.

Entre as possíveis responsabilidades estão:

Apresentação das telas;

Formulários;

Botões e controles;

Navegação entre telas;

Entrada de dados;

Apresentação de informações.

A separação da interface em um pacote específico ajuda a manter as responsabilidades do projeto organizadas.

## 📦 imagens
O pacote imagens contém os recursos visuais utilizados pela aplicação.

Podem fazer parte desse pacote, por exemplo:

Ícones;

Imagens de botões;

Logotipos;

Elementos gráficos;

Outros recursos visuais.

## 🗄️ Banco de dados
O sistema utiliza o MySQL como banco de dados.

O banco de dados utilizado pela aplicação possui o nome:

hakodb

Atualmente, as tabelas identificadas são:
```
hakodb
│
├── baixas_patrimoniais
├── categorias
├── cursos
├── locais
├── movimentações
├── patrimônios
└── usuarios
```
## 📊 Tabelas do sistema
Como a estrutura detalhada das colunas, chaves primárias e estrangeiras não foi informada neste momento, a documentação abaixo descreve a finalidade geral de cada tabela sem assumir nomes ou relacionamentos de campos que ainda não foram especificados.

baixas_patrimoniais
Tabela destinada ao registro das baixas de patrimônios.

Uma baixa patrimonial representa a retirada de determinado bem do conjunto de patrimônios ativos da instituição.

Possíveis situações relacionadas a uma baixa incluem:

Descarte;

Danificação;

Obsolescência;

Perda;

Outros motivos administrativos.

Os motivos e campos efetivamente utilizados dependem da implementação do banco de dados.

categorias
Tabela destinada à organização dos patrimônios por categorias.

A utilização de categorias permite agrupar bens que possuem características semelhantes, facilitando sua organização e consulta.

Exemplos conceituais:

Mobiliário
Equipamentos
Informática
Eletrônicos
Ferramentas

Os valores efetivamente utilizados no sistema dependem do cadastro realizado pela instituição.

cursos
Tabela destinada ao cadastro dos cursos existentes na instituição de educação profissional.

Essa informação pode ser utilizada para relacionar determinados patrimônios ou locais às atividades educacionais da instituição.

locais
Tabela destinada ao cadastro dos locais existentes na instituição.

Os locais permitem identificar onde determinado patrimônio está alocado.

Exemplos conceituais:

Sala de aula
Laboratório
Oficina
Almoxarifado
Biblioteca
Setor administrativo

movimentações
Tabela destinada ao registro das movimentações dos patrimônios.

As movimentações permitem manter um histórico das alterações de localização ou transferência dos bens dentro da instituição.

Um fluxo conceitual pode ser representado por:

Local A
   │
   │ movimentação
   ▼
Local B

O histórico de movimentações pode ser utilizado para auxiliar na rastreabilidade dos patrimônios.

patrimônios
Tabela principal relacionada aos bens patrimoniais cadastrados no sistema.

Essa tabela representa o núcleo do sistema de gerenciamento patrimonial.

Um patrimônio pode estar associado conceitualmente a informações como:

Categoria;

Local;

Situação;

Histórico de movimentações;

Registro de baixa.

Os campos e relacionamentos exatos dependem da estrutura implementada no banco de dados.

usuarios
Tabela destinada ao cadastro dos usuários que possuem acesso ao sistema.

Os usuários podem ser utilizados para controle de acesso e identificação das pessoas responsáveis pelas operações realizadas na aplicação.

Dependendo da implementação, essa estrutura pode futuramente ser utilizada para:

Autenticação;

Controle de permissões;

Identificação do usuário responsável por operações;

Controle de acesso às funcionalidades.

## 🔄 Fluxo geral do sistema
O fluxo geral da aplicação pode ser representado da seguinte maneira:
```
                    ┌──────────────┐
                    │    Usuário   │
                    └──────┬───────┘
                           │
                           ▼
                    ┌──────────────┐
                    │    Janela    │
                    │ Interface    │
                    └──────┬───────┘
                           │
                           ▼
                    ┌──────────────┐
                    │     DAO      │
                    │ Persistência │
                    └──────┬───────┘
                           │
                           ▼
                    ┌──────────────┐
                    │    MySQL     │
                    │    hakodb    │
                    └──────────────┘
```
As classes POJO são utilizadas como representação dos dados manipulados durante esse processo.

## ⚙️ Pré-requisitos
Antes de executar o projeto, é necessário possuir um ambiente configurado com os recursos necessários.

Requisitos
Java JDK

MySQL Server

Git

Uma IDE compatível com projetos Java

Algumas opções de IDE:

IntelliJ IDEA

Eclipse

Apache NetBeans

Visual Studio Code com suporte para Java

## 🗄️ Configuração do banco de dados
Primeiramente, é necessário possuir uma instalação funcional do MySQL.

Crie o banco de dados:

CREATE DATABASE hakodb;

Depois, selecione o banco:

USE hakodb;

As tabelas necessárias devem ser criadas utilizando o script SQL correspondente ao projeto.

O script completo de criação das tabelas deve ser mantido preferencialmente dentro do repositório, por exemplo:

database/
└── hakodb.sql

Caso o projeto ainda não possua esse arquivo, recomenda-se adicioná-lo ao repositório para facilitar a instalação por novos desenvolvedores.


```

CREATE DATABASE  IF NOT EXISTS `hakodb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hakodb`;
-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hakodb
-- ------------------------------------------------------
-- Server version	26.7.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '54d20701-a089-11f1-97ef-62b4655335da:1-87';

--
-- Table structure for table `baixas_patrimoniais`
--

DROP TABLE IF EXISTS `baixas_patrimoniais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `baixas_patrimoniais` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patrimonio_id` int NOT NULL,
  `usuario_registro_id` int NOT NULL,
  `tipo_baixa` enum('Descarte','Venda','Doação','Furto/Roubo','Extravio') NOT NULL,
  `motivo` text NOT NULL,
  `valor_recuperado` decimal(10,2) DEFAULT '0.00',
  `documento_comprobatorio` varchar(100) DEFAULT NULL,
  `data_baixa` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `patrimonio_id` (`patrimonio_id`),
  KEY `usuario_registro_id` (`usuario_registro_id`),
  CONSTRAINT `baixas_patrimoniais_ibfk_1` FOREIGN KEY (`patrimonio_id`) REFERENCES `patrimonios` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `baixas_patrimoniais_ibfk_2` FOREIGN KEY (`usuario_registro_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baixas_patrimoniais`
--

LOCK TABLES `baixas_patrimoniais` WRITE;
/*!40000 ALTER TABLE `baixas_patrimoniais` DISABLE KEYS */;
INSERT INTO `baixas_patrimoniais` VALUES (1,1,1,'Venda','Patrimônio colocado para venda.',500.00,'venda_001.pdf','2026-08-27 11:34:11'),(2,3,3,'Descarte','Patrimônio danificado e sem possibilidade de recuperação.',0.00,'laudo_001.pdf','2026-08-27 11:39:37'),(53,52,1,'Doação','MINHA RTX, NAAAAAAAAAAAO',0.00,'RTX5090.PDF','2026-09-22 00:00:00'),(56,2,1,'Doação','yeah',0.00,'yeah','2026-09-22 00:00:00');
/*!40000 ALTER TABLE `baixas_patrimoniais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Informática e Tecnologia','Equipamentos e materiais de informática e tecnologia'),(2,'Quimica','Equipamentos e materiais de Quimica'),(52,'Portugues','A+A'),(103,'pipis','pipis'),(104,'pratos','merenda');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `sigla` varchar(10) NOT NULL,
  `criado_por` int DEFAULT NULL,
  `criado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `criado_por` (`criado_por`),
  CONSTRAINT `cursos_ibfk_1` FOREIGN KEY (`criado_por`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` VALUES (1,'Tecnico em Informática','TI',1,'2026-08-26 13:12:06'),(2,'Contabilidade Geral','CG',3,'2026-08-26 13:53:57'),(52,'Tecnico em Informatica','TI',1,'2026-09-09 13:06:33'),(103,'Estetica','EST',104,'2026-09-21 13:04:26'),(104,'Enfermagem','ENF',104,'2026-09-21 13:05:49'),(105,'istética','tec',1,'2026-09-21 13:08:07'),(106,'Segurança do Trabalho','TST',105,'2026-09-21 13:39:44'),(107,'','',1,'2026-09-21 13:43:29'),(108,'Técnico em Informatica','TI',1,'2026-09-21 13:43:59'),(109,'Enfermagem','ENF',104,'2026-09-21 13:48:21');
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locais`
--

DROP TABLE IF EXISTS `locais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locais` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `criado_por` int DEFAULT NULL,
  `criado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `criado_por` (`criado_por`),
  CONSTRAINT `locais_ibfk_1` FOREIGN KEY (`criado_por`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locais`
--

LOCK TABLES `locais` WRITE;
/*!40000 ALTER TABLE `locais` DISABLE KEYS */;
INSERT INTO `locais` VALUES (1,'Lab TI 01','Laboratório principal de Informatica atualizado',1,'2026-08-26 14:08:59'),(2,'Lab QM 01','Laboratório principal de Quimica atualizado',1,'2026-08-26 14:09:51'),(3,'Ref 01','Refeitorio',1,'2026-08-26 14:17:18'),(52,'refeitorio02','',1,'2026-09-10 11:39:56'),(53,'Sala de pacto','local para fazer pacto com Deus. amém',3,'2026-09-10 11:41:59'),(54,'Matematica','1+1',NULL,'2026-09-10 12:22:54'),(103,'Praça','aa',53,'2026-09-22 12:52:12');
/*!40000 ALTER TABLE `locais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimentacoes`
--

DROP TABLE IF EXISTS `movimentacoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimentacoes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patrimonio_id` int NOT NULL,
  `usuario_registro_id` int NOT NULL,
  `tipo_movimentacao` enum('Empréstimo','Devolução','Envio Manutenção','Retorno Manutenção','Transferência de Local','Baixa') NOT NULL,
  `responsavel_destino` varchar(150) DEFAULT NULL,
  `documento_responsavel` varchar(50) DEFAULT NULL,
  `data_saida` datetime DEFAULT CURRENT_TIMESTAMP,
  `data_prevista_retorno` datetime DEFAULT NULL,
  `data_retorno_efetivo` datetime DEFAULT NULL,
  `observacoes` text,
  PRIMARY KEY (`id`),
  KEY `patrimonio_id` (`patrimonio_id`),
  KEY `usuario_registro_id` (`usuario_registro_id`),
  CONSTRAINT `movimentacoes_ibfk_1` FOREIGN KEY (`patrimonio_id`) REFERENCES `patrimonios` (`id`) ON DELETE CASCADE,
  CONSTRAINT `movimentacoes_ibfk_2` FOREIGN KEY (`usuario_registro_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimentacoes`
--

LOCK TABLES `movimentacoes` WRITE;
/*!40000 ALTER TABLE `movimentacoes` DISABLE KEYS */;
INSERT INTO `movimentacoes` VALUES (1,1,1,'Empréstimo','Everton PCs',NULL,'2026-09-21 00:00:00','1997-12-12 00:00:00','1998-12-12 00:00:00',''),(2,52,205,'Empréstimo','XiqueXiqueBahiaPCs',NULL,'2026-09-21 00:00:00','2050-12-12 00:00:00','2060-12-12 00:00:00','GAMERS ONLY');
/*!40000 ALTER TABLE `movimentacoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patrimonios`
--

DROP TABLE IF EXISTS `patrimonios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patrimonios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numero_tombamento` varchar(50) NOT NULL,
  `nome` varchar(150) NOT NULL,
  `descricao` text,
  `curso_id` int DEFAULT NULL,
  `local_id` int DEFAULT NULL,
  `categoria_id` int DEFAULT NULL,
  `status` enum('Disponível','Emprestado','Em Manutenção','Baixado/Inativo') DEFAULT 'Disponível',
  `valor_aquisicao` decimal(10,2) DEFAULT NULL,
  `data_aquisicao` date DEFAULT NULL,
  `criado_por` int NOT NULL,
  `atualizado_por` int DEFAULT NULL,
  `criado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `atualizado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `numero_tombamento` (`numero_tombamento`),
  KEY `curso_id` (`curso_id`),
  KEY `local_id` (`local_id`),
  KEY `categoria_id` (`categoria_id`),
  KEY `criado_por` (`criado_por`),
  KEY `atualizado_por` (`atualizado_por`),
  CONSTRAINT `patrimonios_ibfk_1` FOREIGN KEY (`curso_id`) REFERENCES `cursos` (`id`) ON DELETE SET NULL,
  CONSTRAINT `patrimonios_ibfk_2` FOREIGN KEY (`local_id`) REFERENCES `locais` (`id`) ON DELETE SET NULL,
  CONSTRAINT `patrimonios_ibfk_3` FOREIGN KEY (`categoria_id`) REFERENCES `categorias` (`id`) ON DELETE SET NULL,
  CONSTRAINT `patrimonios_ibfk_4` FOREIGN KEY (`criado_por`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `patrimonios_ibfk_5` FOREIGN KEY (`atualizado_por`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patrimonios`
--

LOCK TABLES `patrimonios` WRITE;
/*!40000 ALTER TABLE `patrimonios` DISABLE KEYS */;
INSERT INTO `patrimonios` VALUES (1,'TOMB-0001','Computador Dell','Computador do laboratório de informática',2,1,1,'Disponível',3500.00,'2026-08-26',1,NULL,'2026-08-26 14:25:45','2026-08-26 14:25:45'),(2,'TOMB-0002','Computador Positivo','Computador do laboratório de informática',1,1,1,'Disponível',3500.00,'2026-08-26',1,NULL,'2026-08-26 14:27:49','2026-08-26 14:27:49'),(3,'TOMB-0003','Cadeira','Cadeira do refeitório',1,3,1,'Disponível',3500.00,'2026-08-26',1,NULL,'2026-08-26 14:29:08','2026-08-26 14:29:08'),(52,'19','RTX 5090','True Gamer',2,2,1,'Disponível',5000.00,'1997-12-25',1,NULL,'2026-09-16 11:27:38','2026-09-16 11:27:38');
/*!40000 ALTER TABLE `patrimonios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome_usuarios` varchar(100) NOT NULL,
  `email_usuarios` varchar(100) NOT NULL,
  `senha_hash_usuarios` varchar(255) NOT NULL,
  `perfil_usuarios` enum('Administrador','Coordenador','Assistente') DEFAULT 'Assistente',
  `ativo_usuarios` tinyint(1) DEFAULT '1',
  `criado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `atualizado_em` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email_usuarios`)
) ENGINE=InnoDB AUTO_INCREMENT=307 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'João da Silva','joao@email.com','hash_da_senha','Administrador',1,'2026-08-26 12:10:21','2026-08-26 12:10:21'),(2,'João da Silva','joao11@email.com','hash_da_senha','Coordenador',1,'2026-08-26 12:28:03','2026-08-26 12:28:03'),(3,'Julio Cezar','juxbacon@email.com','hash_da_senha','Administrador',1,'2026-08-26 12:37:24','2026-08-26 12:37:24'),(52,'Guilherme','percy@email.com','hash_da_senha','Administrador',1,'2026-08-27 11:19:06','2026-08-27 11:19:06'),(53,'Isabelle','isinha@email.com','hash_da_senha','Administrador',1,'2026-08-27 11:19:40','2026-08-27 11:19:40'),(103,'matheus','','','Administrador',0,'2026-09-04 12:47:04','2026-09-04 12:47:04'),(104,'gabriel','gabriel@Gmail.com','123senac','Administrador',1,'2026-09-04 12:47:22','2026-09-04 12:47:22'),(105,'andreia','andreia@Gmail.com','123senac','Coordenador',1,'2026-09-04 12:49:32','2026-09-04 12:49:32'),(155,'Julio','Jux@Bacon','123senac','Administrador',1,'2026-09-08 14:30:57','2026-09-08 14:30:57'),(205,'igor','igor@elliam','123456','Administrador',1,'2026-09-21 13:52:59','2026-09-21 13:52:59'),(207,'garibaldo','gari@gmail.com','123123','Coordenador',1,'2026-09-21 13:55:47','2026-09-21 13:55:47'),(208,'antedeguemon','ant@egmon','123123','Assistente',1,'2026-09-21 13:57:21','2026-09-21 13:57:21'),(209,'aa','a','a','Administrador',1,'2026-09-21 14:00:30','2026-09-21 14:00:30'),(210,'b','b','b','Assistente',1,'2026-09-21 14:02:29','2026-09-21 14:02:29'),(211,'Stenio','Stenio@Stenio','123123','Coordenador',1,'2026-09-21 14:21:03','2026-09-21 14:21:03'),(212,'Amongus','Amongus@email','123123','Assistente',1,'2026-09-21 14:24:07','2026-09-21 14:24:07'),(213,'Jux','Bacon@Jux','123123','Administrador',1,'2026-09-21 14:40:07','2026-09-21 14:40:07'),(256,'pedro','pedro@pedro','pedro','Assistente',1,'2026-09-22 13:11:05','2026-09-22 13:11:05');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-09-24  9:32:03


```

## 🔐 Configuração da conexão com o MySQL
A aplicação Java precisa possuir uma configuração de conexão com o banco de dados.

Uma conexão JDBC possui conceitualmente a seguinte estrutura:

jdbc:mysql://localhost:3306/hakodb

Os dados de conexão normalmente envolvem:

Host: localhost
Porta: 3306
Banco: hakodb
Usuário: seu_usuario
Senha: sua_senha

## ⚠️ Segurança
Não coloque senhas reais do banco de dados diretamente no código-fonte ou no GitHub.

Evite:

String senha = "minhaSenha123";

Prefira utilizar arquivos de configuração, variáveis de ambiente ou outro mecanismo adequado para gerenciamento de credenciais.

Também é importante garantir que arquivos contendo credenciais não sejam enviados ao repositório.

## 📥 Configuração do projeto
Clone o repositório:

git clone URL_DO_REPOSITORIO

Entre no diretório:

cd NOME_DO_PROJETO

Depois, abra o projeto utilizando sua IDE Java.

Configure:

O JDK;

A conexão com o MySQL;

O banco hakodb;

As dependências necessárias;

O ponto de entrada da aplicação.

## ▶️ Execução
Após configurar o ambiente e o banco de dados:

Inicie o MySQL;

Verifique se o banco hakodb está disponível;

Confirme as credenciais de acesso;

Abra o projeto na IDE;

Compile o projeto;

Execute a classe principal da aplicação.

Exemplo conceitual:

```
MySQL
  │
  └── hakodb
        │
        ▼
     Aplicação Java
        │
        ▼
      Janela
        │
        ▼
      Usuário
```
## 📁 Organização sugerida do projeto
Uma estrutura possível para o projeto é:

```
projeto/
│
├── src/
│   │
│   ├── POJO/
│   │   ├── ...
│   │   └── ...
│   │
│   ├── DAO/
│   │   ├── ...
│   │   └── ...
│   │
│   ├── Janela/
│   │   ├── ...
│   │   └── ...
│   │
│   └── imagens/
│       ├── ...
│       └── ...
│
├── database/
│   └── hakodb.sql
│
├── .gitignore
├── README.md
└── ...
```
A estrutura real do projeto pode variar conforme a IDE, o sistema de build e a evolução da aplicação.

## 🧩 Responsabilidades dos principais componentes
Componente	Responsabilidade
POJO	Representar os dados e entidades do sistema
DAO	Realizar operações de persistência e comunicação com o banco
Janela	Fornecer a interface de interação com o usuário
imagens	Armazenar recursos gráficos da aplicação
MySQL	Armazenar os dados persistentes da aplicação

A separação dessas responsabilidades contribui para diminuir o acoplamento e facilitar a manutenção do sistema.

## 🔎 Exemplo conceitual de operação
Um exemplo de cadastro de patrimônio pode seguir o fluxo:

```
Usuário
   │
   ▼
Janela de cadastro
   │
   ▼
Objeto Patrimonio (POJO)
   │
   ▼
PatrimonioDAO
   │
   ▼
MySQL
   │
   ▼
Tabela patrimonios
```
Esse fluxo mantém a interface separada da responsabilidade de persistência dos dados.

## 🛡️ Boas práticas
Durante o desenvolvimento e manutenção do projeto, recomenda-se seguir algumas boas práticas.

Código
Utilizar nomes de classes e métodos claros;

Evitar métodos excessivamente grandes;

Manter cada classe com uma responsabilidade bem definida;

Evitar duplicação de código;

Utilizar constantes quando apropriado;

Manter o código organizado.

Banco de dados
Utilizar chaves primárias adequadamente;

Definir relacionamentos utilizando chaves estrangeiras quando necessário;

Evitar duplicação desnecessária de dados;

Realizar backups periódicos;

Documentar alterações na estrutura do banco.

Git
Utilizar commits objetivos e descritivos.

Exemplos:

feat: adiciona cadastro de patrimônios
fix: corrige consulta de movimentações
refactor: reorganiza classes DAO
docs: atualiza documentação

## 🚧 Possíveis funcionalidades
A arquitetura do projeto permite que novas funcionalidades sejam incorporadas conforme as necessidades da instituição.

Entre as funcionalidades que podem fazer parte da evolução do sistema estão:

Cadastro de patrimônios;

Edição de patrimônios;

Consulta de patrimônios;

Exclusão ou inativação de patrimônios;

Cadastro de categorias;

Cadastro de locais;

Cadastro de cursos;

Registro de movimentações;

Histórico de movimentações;

Registro de baixas patrimoniais;

Gerenciamento de usuários;

Controle de acesso;

Pesquisa e filtros;

Relatórios;

Exportação de dados;

Dashboard de informações patrimoniais.

Essas funcionalidades representam possibilidades de evolução e não necessariamente fazem parte da versão atual do sistema.

## 🔮 Evolução da arquitetura
Conforme o projeto crescer, a estrutura atual poderá ser expandida para uma arquitetura mais segmentada.

Uma possível evolução seria:
```
src/
│
├── model/
│
├── dao/
│
├── service/
│
├── controller/
│
├── view/
│
├── util/
│
└── resources/
```
Nesse cenário, uma camada de Service poderia concentrar regras de negócio, evitando que essas regras sejam colocadas diretamente nas interfaces ou nos DAOs.

A adoção dessa estrutura deve ocorrer de acordo com a necessidade real do projeto, evitando complexidade desnecessária.

## 🤝 Contribuição
Contribuições são bem-vindas.

Para contribuir:

1. Faça um fork do projeto
git fork

2. Crie uma branch
git checkout -b feature/minha-funcionalidade

3. Realize as alterações
Implemente a funcionalidade ou correção mantendo os padrões utilizados no projeto.

4. Faça o commit
git add .
git commit -m "feat: adiciona nova funcionalidade"

5. Envie a branch
git push origin feature/minha-funcionalidade

6. Abra um Pull Request
Descreva de forma clara:

O que foi alterado;

Qual problema foi resolvido;

Como a alteração foi testada;

Se houve alteração no banco de dados.

## 📝 Convenção de commits
Como sugestão, o projeto pode utilizar uma convenção semelhante ao Conventional Commits.

Tipo	Utilização
feat	Nova funcionalidade
fix	Correção de problema
refactor	Refatoração do código
docs	Alterações na documentação
style	Alterações de formatação
test	Inclusão ou alteração de testes
chore	Tarefas de manutenção

Exemplos:

git commit -m "feat: adiciona cadastro de categorias"

git commit -m "fix: corrige consulta de patrimônios"

git commit -m "refactor: reorganiza camada DAO"

## 🧪 Testes
À medida que o projeto evoluir, recomenda-se implementar testes automatizados para validar as principais regras e operações do sistema.

Os testes podem abranger:

Cadastro de patrimônios;

Consulta de patrimônios;

Atualização de registros;

Movimentações;

Baixas patrimoniais;

Validação de dados;

Regras de negócio;

Acesso ao banco de dados.

A adoção de testes automatizados contribui para reduzir regressões durante a evolução do sistema.

# 📌 Status do projeto
### 🚧 Em desenvolvimento

O projeto está em fase de desenvolvimento e sua estrutura e funcionalidades poderão sofrer alterações conforme os requisitos da instituição forem definidos e implementados.

### 📄 Licença
A licença do projeto ainda não foi definida.

Caso seja necessário disponibilizar o código publicamente, recomenda-se definir uma licença de software adequada às necessidades da instituição e às regras aplicáveis ao projeto.

### 👨‍💻 Autor
Projeto desenvolvido para gerenciamento patrimonial de uma instituição de educação profissional.

Projeto: Sistema de Gerenciamento Patrimonial
Linguagem: Java
Banco de dados: MySQL
Database: hakodb

### 📚 Documentação complementar
Conforme o projeto evoluir, recomenda-se adicionar ao repositório documentos complementares, como:
```
docs/
├── arquitetura.md
├── banco-de-dados.md
├── regras-de-negocio.md
└── contribuicao.md

Também é recomendável manter o script de banco de dados versionado:

database/
└── hakodb.sql
```
Dessa forma, novos desenvolvedores poderão configurar o ambiente de desenvolvimento com maior facilidade.