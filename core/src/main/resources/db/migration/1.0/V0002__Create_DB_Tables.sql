-- Leave a large ID space reserved for master-data and test-data
    create table game (
        id bigint not null,
        modificationCounter integer not null,
        complexity decimal(19,2),
        cost decimal(19,2),
        extension boolean not null,
        name varchar(255),
        primary key (id)
    );

    create table game_play (
        id bigint not null,
        modificationCounter integer not null,
        duration decimal(19,2),
        game_id bigint,
        primary key (id),
        foreign key(game_id) references game(id)
    );

    create table player (
        id bigint not null,
        modificationCounter integer not null,
        name varchar(255),
        primary key (id)
    );

    create table game_play_player (
        game_play_id bigint not null,
        player_id bigint not null,
        foreign key(game_play_id) references game_play(id),
        foreign key(player_id) references player(id)
    );


