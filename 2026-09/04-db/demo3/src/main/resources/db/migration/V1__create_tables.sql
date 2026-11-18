create table projects (
    id   bigserial primary key,
    name varchar(100) not null
);

create table tasks (
    id         bigserial primary key,
    title      varchar(100) not null,
    done       boolean      not null default false,
    project_id bigint references projects (id)
);
