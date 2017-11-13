drop table agendamento;
drop table conta;

create table conta (
    numero INT,
    agencia INT,
    titular VARCHAR(50),
    saldo FLOAT,
    senha VARCHAR(20),
    primary key(numero)
);

create table agendamento (
    codPagamento INT AUTO_INCREMENT,
    valor FLOAT,
    dataAgendada DATE,
    contaOrigem INT,
    contaDestino INT,
    primary key(codPagamento),
    foreign key(contaOrigem) references conta(numero)
);