create sequence tests_seq;

create table tests
(
    id     bigint       not null default nextval('tests_seq'),
    name   varchar(255) not null,
    status varchar(20),

    constraint tests_pk primary key (id),
    constraint tests_status_fk foreign key (status) references execution_statuses (id)
);

comment on table tests is 'Contains test details';
comment on column tests.name is 'Name of test';
comment on column tests.status is 'Test execution status';

insert into tests (name)
values ('My test 1'),
       ('My test 2'),
       ('My test 3');