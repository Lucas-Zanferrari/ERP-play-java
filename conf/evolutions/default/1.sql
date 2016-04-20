# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table comanda (
  id                        integer not null,
  cpf_cliente               integer,
  data_hora_encerramento    timestamp,
  qtd_produtos              integer,
  preco_total               float,
  data_hora_abertura        timestamp,
  constraint pk_comanda primary key (id))
;

create table funcionario (
  id                        integer not null,
  nome                      varchar(255),
  usuario                   varchar(255),
  senha                     varchar(255),
  data_nascimento           timestamp,
  cpf                       varchar(255),
  rg                        varchar(255),
  carteira_trabalho         varchar(255),
  endereco                  varchar(255),
  numero                    integer,
  bairro                    varchar(255),
  cep                       varchar(255),
  data_contratacao          timestamp,
  nivel_acesso              varchar(255),
  cargo                     varchar(255),
  salario_base              float,
  turno                     varchar(255),
  telefone                  varchar(255),
  constraint pk_funcionario primary key (id))
;

create table produto (
  id                        integer not null,
  editado_em                timestamp,
  nome                      varchar(255),
  qtd_estoque               integer,
  descricao                 varchar(255),
  preco                     float,
  adicionado_em             timestamp,
  constraint pk_produto primary key (id))
;

create sequence comanda_seq;

create sequence funcionario_seq;

create sequence produto_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists comanda;

drop table if exists funcionario;

drop table if exists produto;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists comanda_seq;

drop sequence if exists funcionario_seq;

drop sequence if exists produto_seq;

