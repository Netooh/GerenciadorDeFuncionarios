-- V2: Migrations para adicionar a coluna de Estado Civil na tabela de cadastros

ALTER TABLE tb_cadastro
ADD COLUMN estadoCivil VARCHAR(255);