create table camera
(
    idCAMERA    int auto_increment
        primary key,
    numCamera   int          not null,
    prenotabile tinyint(1)   not null,
    tipo        varchar(45)  not null,
    numPosti    int          not null,
    dimensione  int          not null,
    descrizione varchar(500) not null,
    prezzo      double       not null,
    constraint CAMERA_idCAMERA_uindex
        unique (idCAMERA),
    constraint CAMERA_numStanza_uindex
        unique (numCamera)
);

create table utente
(
    idUTENTE    int auto_increment
        primary key,
    email       varchar(60)  not null,
    password    varchar(45)  not null,
    nome        varchar(70)  not null,
    cognome     varchar(70)  not null,
    dataNascita date         not null,
    telefono    varchar(15)  not null,
    indirizzo   varchar(100) not null,
    tipoUtente  int          not null,
    constraint UTENTE_email_uindex
        unique (email),
    constraint UTENTE_idUTENTE_uindex
        unique (idUTENTE)
);

create table prenotazione
(
    idPRENOTAZIONE     int auto_increment
        primary key,
    dataPrenotazione   datetime             not null,
    checkIn            date                 not null,
    checkOut           date                 not null,
    camera             int                  not null,
    intestatario       varchar(60)          not null,
    numOspiti          int                  not null,
    prezzo             double               not null,
    checkInEffettuato  tinyint(1) default 0 not null,
    checkOutEffettuato tinyint(1) default 0 not null,
    PINCamera          int                  not null,
    Saldo              int        default 0 null,
    constraint PRENOTAZIONE_idPRENOTAZIONE_uindex
        unique (idPRENOTAZIONE),
    constraint prenotazione_utente_email_fk
        foreign key (intestatario) references utente (email)
);

create index prenotazione_camera_numStanza_fk
    on prenotazione (camera);


