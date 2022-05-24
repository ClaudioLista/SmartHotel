create table camera
(
    idCAMERA    varchar(10)  not null
        primary key,
    numStanza   int          not null,
    prenotabile tinyint(1)   not null,
    tipo        varchar(45)  not null,
    numPosti    int          not null,
    dimensione  int          not null,
    descrizione varchar(500) not null,
    prezzo      double       not null,
    constraint CAMERA_idCAMERA_uindex
        unique (idCAMERA),
    constraint CAMERA_numStanza_uindex
        unique (numStanza)
);

create table utente
(
    idUTENTE    varchar(10)  not null
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
    idPRENOTAZIONE   varchar(10) not null
        primary key,
    dataPrenotazione datetime    not null,
    checkIn          date        not null,
    checkOut         date        not null,
    camera           varchar(10) not null,
    intestatario     varchar(10) not null,
    constraint PRENOTAZIONE_idPRENOTAZIONE_uindex
        unique (idPRENOTAZIONE),
    constraint PRENOTAZIONE_camera_idCAMERA_fk
        foreign key (camera) references camera (idCAMERA),
    constraint PRENOTAZIONE_utente_idUTENTE_fk
        foreign key (intestatario) references utente (idUTENTE)
);


