
create table course (
                        id int generated by default as identity primary key ,
                        name varchar unique not null ,
                        related_id int references "user"(id) on delete set null
);