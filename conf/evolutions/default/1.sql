# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table comanda (
  id                        integer not null,
  cpf_cliente               varchar(255),
  data_hora_abertura        timestamp,
  preco_total               double,
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

create table produto_adicionado (
  comanda_id                integer,
  quantidade                integer,
  id                        integer)
;

create table venda (
  data_hora_encerramento    timestamp)
;

create sequence comanda_seq;

create sequence funcionario_seq;

create sequence produto_seq;

alter table produto_adicionado add constraint fk_produto_adicionado_comanda_1 foreign key (comanda_id) references comanda (id) on delete restrict on update restrict;
create index ix_produto_adicionado_comanda_1 on produto_adicionado (comanda_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists comanda;

drop table if exists funcionario;

drop table if exists produto;

drop table if exists produto_adicionado;

drop table if exists venda;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists comanda_seq;

drop sequence if exists funcionario_seq;

drop sequence if exists produto_seq;

