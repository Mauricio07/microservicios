create table public.cuenta
(
    id            bigint generated by default as identity primary key,
    saldo_inicial numeric(38, 2) not null,
    numero        varchar(100)   not null,
    estado        varchar(255)   not null,
    tipo      varchar(255) not null,
    clienteId bigint       not null
);


create table public.movimiento
(
    id        bigint generated by default as identity primary key,
    fecha     date           not null,
    saldo     numeric(38, 2) not null,
    valor     numeric(38, 2) not null,
    tipo      varchar(255)   not null,
    observacion varchar(255) not null,
    cuenta_id bigint
        constraint fk_cuenta_movimiento
            references public.cuenta
);
