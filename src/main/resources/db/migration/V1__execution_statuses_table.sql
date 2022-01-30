create table execution_statuses
(
    id   varchar(25) not null,
    name varchar(30) not null,

    constraint execution_statuses_pkey primary key (id)
);

comment on table execution_statuses is 'Contains execution statuses';
comment on column execution_statuses.name is 'Status display name';

insert into execution_statuses (id, name)
values ('PASSED', 'Passed'),
       ('FAILED', 'Failed');
