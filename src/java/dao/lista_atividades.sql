-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 27-Maio-2021 às 14:26
-- Versão do servidor: 10.4.18-MariaDB
-- versão do PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `lista_atividades`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `atividades`
--

CREATE TABLE `atividades` (
  `id` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `finalizada` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `atividades`
--

INSERT INTO `atividades` (`id`, `id_usuario`, `titulo`, `finalizada`) VALUES
(3, 7, 'Estudar JAVA', b'0'),
(4, 7, 'Dormir', b'0'),
(5, 7, 'Dormir', b'0'),
(6, 7, 'Dormir', b'0'),
(7, 7, 'Dormir', b'0'),
(8, 7, 'comer', b'0'),
(9, 7, 'Dormir', b'0'),
(11, 14, 'Estudar JAVA', b'0'),
(12, 14, 'Dormir', b'0'),
(14, 14, 'comer', b'0'),
(16, 14, 'estudar intenso', b'1'),
(18, 20, 'Estudar JAVA', b'1'),
(19, 20, 'Dormir', b'1');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `email` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `email`, `senha`) VALUES
(2, 'luiznaotaoloco@gmail.com', 'esqueciasenha'),
(3, 'luizloco@gmail.com', '123'),
(5, 'tiopatinhas@tiopatinhas.com', 'irmaosmetralha'),
(6, 'tatiltadoxd@xd.com', 'shacoloco'),
(7, 'luiz@luiz.com', 'luiz'),
(8, 'luiz@luiz.com.br', 'luiz'),
(9, 'luizfenapo@gmail.com', 'sss'),
(10, 'luizfenapo@gmail.com', 'sss'),
(11, 'luizfenapo@gmail.com', 'sss'),
(12, 'luizfenapo@gmail.com', 'sss'),
(13, 'luizfenapo@gmail.com', 'sss'),
(14, 'luizfernando.jobs12@gmail.com', '123'),
(15, 'novoemail@email.com', 'luizfernan3'),
(16, 'novoemail@email.com', 'luizfernan3'),
(17, 'novoemail@email.com', 'luizfernan3'),
(18, 'cabecadenoistodos@gmail.com', 'cabeca'),
(19, 'luizfernando.jobs12@gmail.com', '123'),
(20, 'tads@tads', 'tads');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `atividades`
--
ALTER TABLE `atividades`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `atividades`
--
ALTER TABLE `atividades`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
