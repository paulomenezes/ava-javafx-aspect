
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema ava
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ava` DEFAULT CHARACTER SET utf8 ;
USE `ava` ;

-- -----------------------------------------------------
-- Table `ava`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ava`.`usuario` (

	id	INT AUTO_INCREMENT , 	
  `cpf` VARCHAR(20) NOT NULL UNIQUE ,
  `nome` VARCHAR(25) NOT NULL COMMENT '',
  `foto` LONGBLOB NULL DEFAULT NULL COMMENT '',
  `email` VARCHAR(25) NOT NULL COMMENT '',
  `senha` VARCHAR(15) NOT NULL COMMENT '',
  PRIMARY KEY (id))
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ava`.`departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ava`.`departamento` (
	
  `nome` VARCHAR(20) NOT NULL COMMENT '',
  `idDepartamento` INT AUTO_INCREMENT NOT NULL COMMENT '',
  PRIMARY KEY (`idDepartamento`))
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ava`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ava`.`curso` (
  `codigo` INT AUTO_INCREMENT NOT NULL COMMENT '',
  `nome` VARCHAR(20) NOT NULL COMMENT '',
  limiteAluno INT(3) NOT NULL,
  `qtdAlunos` INT(3) NOT NULL COMMENT '',
  `grCurric` LONGTEXT NULL DEFAULT NULL COMMENT '',
  `idDepartamento` INT NOT NULL COMMENT '',
  PRIMARY KEY (`codigo`),
  INDEX `fk_departamento` (`idDepartamento` ASC)  COMMENT '',
  CONSTRAINT `fk_departamento`
    FOREIGN KEY (`idDepartamento`)
    REFERENCES `ava`.`departamento` (`idDepartamento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ava`.`aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ava`.`aluno` (
   idAluno INT NOT NULL,
  `codCurso` INT(4) NULL DEFAULT NULL COMMENT '',
  `tipo` VARCHAR(10) NOT NULL COMMENT '',
  PRIMARY KEY (idAluno),
    FOREIGN KEY (idAluno)
    REFERENCES `ava`.`usuario` (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (`codCurso`)
    REFERENCES `ava`.`curso` (`codigo`)
    ON DELETE SET NULL
    ON UPDATE SET NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ava`.`projetopesquisa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ava`.`projetopesquisa` (
  `id` INT AUTO_INCREMENT NOT NULL COMMENT '',
  `nome` VARCHAR(20) NOT NULL COMMENT '',
  `tipo` VARCHAR(10) NOT NULL COMMENT '',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ava`.`artigo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ava`.`artigo` (
  `id_projeto` INT NOT NULL DEFAULT '0' COMMENT '',
  id_artigo INT AUTO_INCREMENT NOT NULL,
  `tema` VARCHAR(20) NOT NULL COMMENT '',
  `objetivo` LONGTEXT NULL DEFAULT NULL COMMENT '',
  `area` VARCHAR(15) NOT NULL COMMENT '',
  PRIMARY KEY (id_artigo, id_projeto),
    FOREIGN KEY (id_projeto)
    REFERENCES `ava`.`projetopesquisa` (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ava`.`disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ava`.`disciplina` (
	id INT AUTO_INCREMENT NOT NULL COMMENT '',
  `idCurso` INT(4) NOT NULL COMMENT '',
  `nome` VARCHAR(20) NOT NULL COMMENT '',
  `tipo` VARCHAR(20) NOT NULL COMMENT '',
  `cargaHor` INT(4) NOT NULL COMMENT '',
  `nCreditos` INT(4) NOT NULL COMMENT '',
	PRIMARY KEY (`id`),
    FOREIGN KEY (`idCurso`)
    REFERENCES `ava`.`curso` (`codigo`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ava`.`ofertadisciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ava`.`ofertadisciplina` (
  `ano` INT NOT NULL COMMENT '',
  `horario` TIME NULL DEFAULT NULL COMMENT '',
  `qtdAlunos` INT(3) NOT NULL COMMENT '',
  limiteAluno INT(3) NOT NULL,
  `semestre` INT(11) NOT NULL COMMENT '',
  `periodo` INT(11) NOT NULL COMMENT '',
  id_disciplina INT NOT NULL COMMENT '',
  id	INT AUTO_INCREMENT NOT NULL,
  PRIMARY KEY (id,id_disciplina),
    FOREIGN KEY (`id_disciplina`)
    REFERENCES `ava`.`disciplina` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ava`.`atividade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ava`.`atividade` (
	id	INT AUTO_INCREMENT NOT NULL,
  `nome` VARCHAR(20) NOT NULL COMMENT '',
  `tipo` VARCHAR(11) NOT NULL COMMENT '',
  `idOferta` INT NOT NULL COMMENT '',
  `descricao` LONGTEXT NULL DEFAULT NULL COMMENT '',
  `dataEntrega` DATE NULL DEFAULT NULL COMMENT '',
	PRIMARY KEY (id),
    FOREIGN KEY (`idOferta`)
    REFERENCES `ava`.`ofertadisciplina` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ava`.`aviso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ava`.`aviso` (
  `titulo` VARCHAR(26) NOT NULL COMMENT '',
  `dataEnvio` DATE NULL DEFAULT NULL COMMENT '',
  `prioridade` INT(11) NOT NULL COMMENT '',
  `horaEnvio` TIME NULL DEFAULT NULL,
  idAviso INT(11) NOT NULL,
  descricao TEXT DEFAULT NULL,
  PRIMARY KEY (`idAviso`)  COMMENT '',
  UNIQUE INDEX `titulo` (`titulo` ASC)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ava`.`professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ava`.`professor` (
  `id` INT NOT NULL COMMENT '',
  `idDepartamento` INT NOT NULL COMMENT '',
	PRIMARY KEY (id),
    FOREIGN KEY (id)
    REFERENCES `ava`.`usuario` (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (`idDepartamento`)
    REFERENCES `ava`.`departamento` (idDepartamento))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ava`.`coordenador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ava`.`coordenador` (
  `id` INT NOT NULL,
  codCurso INT NOT NULL COMMENT '',
	PRIMARY KEY (id),
    FOREIGN KEY (`id`)
    REFERENCES `ava`.`professor` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (`codCurso`)
    REFERENCES `ava`.`curso` (`codigo`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ava`.`diadisciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ava`.`diadisciplina` (
  `dia` VARCHAR(10) NOT NULL COMMENT '',
  `idDisciplina` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idDisciplina`),
    FOREIGN KEY (`idDisciplina`)
    REFERENCES `ava`.`disciplina` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ava`.`historico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ava`.`historico` (
  `idAluno` INT NOT NULL COMMENT '',
	idOferta INT NOT NULL,
    periodo  INT NOT NULL,
    condicao BOOL NOT NULL,
  `mediaGeral` FLOAT  DEFAULT NULL COMMENT '',
	PRIMARY KEY (`idAluno`),
    FOREIGN KEY (`idAluno`)
    REFERENCES `ava`.`aluno` (`idAluno`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (idOferta)
    REFERENCES ava.ofertadisciplina(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `ava`.`disponibaviso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ava`.`disponibaviso` (
  `idUsuario` INT NOT NULL,
  `idOferta` INT NOT NULL COMMENT '',
  `idAviso` INT(11) NOT NULL COMMENT '',
	PRIMARY KEY (`idUsuario`, `idOferta`, `idAviso`),
    FOREIGN KEY (`idUsuario`)
    REFERENCES `ava`.`usuario` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `disponibaviso_ibfk_3`
    FOREIGN KEY (`idOferta`)
    REFERENCES `ava`.`ofertadisciplina` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `disponibaviso_ibfk_4`
    FOREIGN KEY (`idAviso`)
    REFERENCES `ava`.`aviso` (`idAviso`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ava`.`forum`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ava`.`forum` (
  `id` INT AUTO_INCREMENT NOT NULL COMMENT '',
  `titulo` VARCHAR(25) NOT NULL COMMENT '',
  `descricao` TEXT NOT NULL COMMENT '',
  `idCriador` INT DEFAULT NULL,
  PRIMARY KEY (`id`),
    FOREIGN KEY (`idCriador`)
    REFERENCES `ava`.`usuario` (`id`)
    ON DELETE SET NULL
    ON UPDATE SET NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ava`.`forumusuarioparticipar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ava`.`forumusuarioparticipar` (
  `idForum` INT NOT NULL COMMENT '',
  `idUsuario` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idForum`, `idUsuario`),
    FOREIGN KEY (`idForum`)
    REFERENCES `ava`.`forum` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `forumusuarioparticipar_ibfk_2`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `ava`.`usuario` (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ava`.`ministraroferta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ava`.`ministraroferta` (
  `idOferta` INT NOT NULL COMMENT '',
  `idProfessor` INT NOT NULL COMMENT '',
	PRIMARY KEY (`idOferta`, `idProfessor`),
    FOREIGN KEY (idOferta)
    REFERENCES `ava`.`ofertadisciplina` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `ministraroferta_ibfk_2`
    FOREIGN KEY (`idProfessor`)
    REFERENCES `ava`.`professor` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ava`.`materialdisciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ava`.`materialdisciplina` (
  `id` INT AUTO_INCREMENT NOT NULL COMMENT '',
  `fonte` VARCHAR(20) NOT NULL COMMENT '',
  `tipo` VARCHAR(20) NOT NULL COMMENT '',
  `arquivo` LONGBLOB NULL DEFAULT NULL COMMENT '',
  `idOferta` INT NOT NULL COMMENT '',
  `idProfessor` INT NOT NULL COMMENT '',
	PRIMARY KEY (`id`,`idOferta`, `idProfessor`),
    FOREIGN KEY (`idOferta` , `idProfessor`)
    REFERENCES `ava`.`ministraroferta` (`idOferta` , `idProfessor`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ava`.`matricular`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ava`.`matricular` (
  `dataMatr` DATE DEFAULT NULL COMMENT '',
  `numProtocolo` VARCHAR(10) NOT NULL COMMENT '',
  `idAluno` INT NOT NULL COMMENT '',
  `idOferta` INT NOT NULL COMMENT '',
	PRIMARY KEY (`idAluno`, `idOferta`),
    FOREIGN KEY (`idAluno`)
    REFERENCES `ava`.`aluno` (`idAluno`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `matricular_ibfk_2`
    FOREIGN KEY (`idOferta`)
    REFERENCES `ava`.`ofertadisciplina` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ava`.`nota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ava`.`nota` (
  `situacao` VARCHAR(15) NOT NULL COMMENT '',
  `nota1` INT(2) NOT NULL COMMENT '',
  `nota2` INT(2) NOT NULL COMMENT '',
  `nota3` INT(2) NOT NULL COMMENT '',
  `notaFinal` INT(2) NOT NULL COMMENT '',
  `idAluno` INT NOT NULL COMMENT '',
  `idOferta` INT(4) NOT NULL COMMENT '',
  `idNota` INT NOT NULL AUTO_INCREMENT COMMENT '',
  PRIMARY KEY (`idNota`,idAluno,idOferta),
  CONSTRAINT `nota_ibfk_1`
    FOREIGN KEY (`idAluno` , `idOferta`)
    REFERENCES `ava`.`matricular` (`idAluno` , `idOferta`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ava`.`participarprojeto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ava`.`participarprojeto` (
  `idProjeto` INT NOT NULL COMMENT '',
  `idAluno` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idProjeto`, `idAluno`),
    FOREIGN KEY (`idProjeto`)
    REFERENCES `ava`.`projetopesquisa` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `participarprojeto_ibfk_2`
    FOREIGN KEY (`idAluno`)
    REFERENCES `ava`.`aluno` (`idAluno`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ava`.`prerequesito`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ava`.`prerequesito` (
  `dependente` INT NOT NULL COMMENT '',
  `requesito` INT(4) DEFAULT NULL COMMENT '',
	PRIMARY KEY (`dependente`, `requesito`),
    FOREIGN KEY (`dependente`)
    REFERENCES `ava`.`disciplina` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `prerequesito_ibfk_2`
    FOREIGN KEY (`requesito`)
    REFERENCES `ava`.`disciplina` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ava`.`realizaratividade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ava`.`realizaratividade` (
	id INT NOT NULL AUTO_INCREMENT,
	idAtividade INT NOT NULL COMMENT '',
	idAluno INT NOT NULL COMMENT '',
  `nota` INT(2) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (id,idAtividade,idAluno),
    FOREIGN KEY (`idAluno`)
    REFERENCES `ava`.`aluno` (`idAluno`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (`idAtividade`)
    REFERENCES `ava`.`atividade` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ava`.`tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ava`.`tag` (
  `idForum` INT(4) NOT NULL COMMENT '',
  `nome` VARCHAR(20) NOT NULL COMMENT '',
  `tamanho` INT(2) NOT NULL COMMENT '',
  PRIMARY KEY (`idForum`)  COMMENT '',
  CONSTRAINT `tag_ibfk_1`
    FOREIGN KEY (`idForum`)
    REFERENCES `ava`.`forum` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ava`.`solicitacao_projeto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS ava.solicitacao_projeto(
	idSolicitacao INT NOT NULL AUTO_INCREMENT,
    idAluno		  INT NOT NULL,
    idProjeto     INT NOT NULL,
    estado 		  BOOL NOT NULL,
    PRIMARY KEY(idSolicitacao,idAluno,idProjeto),
    FOREIGN KEY(idAluno) REFERENCES ava.aluno(idAluno)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY(idProjeto) REFERENCES ava.projetopesquisa(id)
	ON DELETE CASCADE
    ON UPDATE CASCADE
);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
