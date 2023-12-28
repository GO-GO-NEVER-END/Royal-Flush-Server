# 우선은 id, password로 구분, 이후 변경
create table if not exists royal_flush.user
(
    id            bigint auto_increment primary key,
    user_id       varchar(255) not null comment "유저 id",
    user_password varchar(255) not null comment "유저 password",
    name          varchar(255) not null comment "유저 닉네임",
    coin          int          not null default 0 comment "유저가 가지고 있는 코인 수",
    is_ssamulie   boolean      not null default 0 comment "싸믈리에 여부"
);

create table if not exists royal_flush.subway
(
    id bigint auto_increment primary key comment "지하철 역 id"
);

# 우선은 점수에 관한 데이터는 없이 정보만 제공
create table if not exists royal_flush.toilet
(
    id          bigint auto_increment primary key comment "화장실 id",
    name        varchar(255) not null comment "화장실 별칭",
    register_id bigint       not null comment "등록한 유저 id",
    latitude    bigint       not null comment "화장실 위도",
    longitude   bigint       not null comment "화장실 경도",
    address     varchar(255) null comment "화장실 주소",
    constraint FK_TOILET_TO_USER foreign key (register_id) references royal_flush.user (id)
);

create table if not exists royal_flush.subway_toilet_info
(
    tid      bigint  not null comment "화장실 id",
    sid      bigint  not null comment "지하철 id",
    is_outer boolean not null default false comment "화장실이 밖에 있는지 여부",
    primary key (tid, sid),
    constraint FK_INFO_TO_TOILET foreign key (tid) references royal_flush.toilet (id),
    constraint FK_INFO_TO_SUBWAY foreign key (sid) references royal_flush.subway (id)
);

create table if not exists royal_flush.teatime_article
(
    id    bigint auto_increment primary key comment "article id",
    url   varchar(255) not null comment "article url",
    title varchar(255) not null comment "article title",
    date  datetime     not null default now() comment "article date"
);

create table if not exists royal_flush.toilet_review
(
    id         bigint auto_increment primary key,
    tid        bigint       not null comment "화장실 id",
    uid        bigint       not null comment "유저 id",
    evaluation varchar(10)  not null comment "유저 평기(BAD / OK / GOOD)",
    comment    varchar(255) not null comment "댓글",
    time       datetime     not null default now() comment "댓글 제작 시간",
    UNIQUE (tid, uid)
);

create table if not exists royal_flush.toilet_review_tags
(
    id  bigint auto_increment primary key,
    rid bigint       not null comment "리뷰 id",
    tag varchar(255) not null comment "태그",
    UNIQUE (rid, tag),
    constraint FK_TAG_TO_REVIEW foreign key (rid) references royal_flush.toilet_review (id)
);

create table if not exists royal_flush.toilet_specific
(
    id                 bigint auto_increment primary key,
    tid                bigint  not null comment "화장실 id",
    size               int     not null comment "화장실 규모",
    disabled_available boolean not null default false comment "장애인용 시설 여부",
    child_available    boolean not null default false comment "어린이용 시설 여부",
    baby_available     boolean not null default false comment "기저귀 교환대 여부",
    UNIQUE (tid),
    constraint FK_SPECIFIC_TO_TOILET foreign key (tid) references royal_flush.toilet (id)
);