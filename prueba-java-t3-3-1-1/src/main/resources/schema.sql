create table prices (
    id integer not null,
    brand_id integer,
    start_date varchar(30),
    end_date varchar(30),
    price_list integer,
    product_id integer,
    priority integer,
    price decimal(6,2),
    curr varchar(6),
    primary key (id)
);