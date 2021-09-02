create database pedidos;
use pedidos;

create table cliente
(
   idcliente            int not null auto_increment,
   dnicliente           numeric(10,0),
   nombrecliente        varchar(30),
   primary key (idcliente)
);

create table pedido
(
   idpedido             int not null auto_increment,
   idcliente            int not null,
   codigopedido         varchar(20),
   fechapedido          date,
   primary key (idpedido)
);

alter table pedido add constraint fk_cliente_pedido foreign key (idcliente)
      references cliente (idcliente) on delete restrict on update restrict;

