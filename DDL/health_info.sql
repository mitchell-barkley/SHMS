CREATE TABLE health_info (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    weight DECIMAL(5,2) NOT NULL,
    height DECIMAL(5,2) NOT NULL,
    age INT,
    steps INT NOT NULL,
    heart_rate INT NOT NULL,
    blood_pressure VARCHAR(10) NOT NULL,
    date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
)

CREATE TABLE public.health_info
(
    id serial NOT NULL,
    user_id integer NOT NULL,
    weight double precision NOT NULL,
    height double precision NOT NULL,
    age integer NOT NULL,
    steps integer NOT NULL,
    heart_rate integer NOT NULL,
    blood_pressure character varying(32) NOT NULL,
    date date NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT user_id FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS public.health_info
    OWNER to postgres;