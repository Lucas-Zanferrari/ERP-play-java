# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table funcionario (
  id                        integer not null,
  nome                      varchar(255),
  data_nascimento           timestamp,
  cpf                       integer,
  rg                        varchar(255),
  carteira_trabalho         integer,
  endereco                  varchar(255),
  numero                    integer,
  bairro                    varchar(255),
  cep                       integer,
  data_contratacao          timestamp,
  nivel_acesso              varchar(255),
  cargo                     varchar(255),
  salario_base              float,
  usuario                   varchar(255),
  senha                     varchar(255),
  turno                     varchar(255),
  constraint pk_funcionario primary key (id))
;

create table produto (
  id                        integer not null,
  nome                      varchar(255),
  editado_em                timestamp,
  qtd_estoque               integer,
  descricao                 varchar(255),
  preco                     float,
  constraint pk_produto primary key (id))
;

create sequence funcionario_seq;

create sequence produto_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists funcionario;

drop table if exists produto;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists funcionario_seq;

drop sequence if exists produto_seq;

