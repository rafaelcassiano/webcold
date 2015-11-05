CREATE TABLE tecnico (
  tecnico_id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(200) NOT NULL,
  telefone VARCHAR(20) NOT NULL,
  PRIMARY KEY(tecnico_id)
);

CREATE TABLE cliente (
  cliente_id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(200) NOT NULL,
  email VARCHAR(100) NULL,
  telefone VARCHAR(20) NULL,
  PRIMARY KEY(cliente_id)
);

CREATE TABLE pedido (
  pedido_id BIGINT NOT NULL AUTO_INCREMENT,
  tecnico_id BIGINT NOT NULL,
  cliente_id BIGINT NOT NULL,
  descricao VARCHAR(500) NOT NULL,
  tipo VARCHAR(100) NOT NULL,
  nota_fiscal VARCHAR(100) NULL,
  PRIMARY KEY(pedido_id),
  INDEX pedido__cliente(cliente_id),
  INDEX pedido__tecnico(tecnico_id),
  FOREIGN KEY(cliente_id)
    REFERENCES cliente(cliente_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(tecnico_id)
    REFERENCES tecnico(tecnico_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

