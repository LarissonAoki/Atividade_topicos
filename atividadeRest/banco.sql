create database atividadejpa2;

use atividadejpa2;

create table carros(
carro_id bigint primary key auto_increment,
carro_modelo varchar(20),
carro_ano int,
carro_preco float,
carro_cor varchar(10) );

create table vendas(
venda_id bigint primary key auto_increment,
venda_quan int,
venda_total float,
venda_vendedor varchar(20),
venda_data date,
foreign key (carro_id)  references carros(carros_id));
