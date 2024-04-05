CREATE TABLE med_remind (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    med_name VARCHAR(255) NOT NULL,
    med_dose VARCHAR(255) NOT NULL,
    med_schedule VARCHAR(255) NOT NULL,
    med_start_date DATE NOT NULL,
    med_end_date DATE NOT NULL,
    med_notes TEXT,
    FOREIGN KEY (user_id) REFERENCES users(id)
)

CREATE TABLE public.med_remind
(
    id serial NOT NULL,
    user_id integer NOT NULL,
    med_name character varying(255) NOT NULL,
    med_dose character varying(255) NOT NULL,
    med_schedule character varying(255) NOT NULL,
    med_start_date date NOT NULL,
    med_end_date date NOT NULL,
    med_notes text,
    PRIMARY KEY (id),
    CONSTRAINT user_id FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS public.med_remind
    OWNER to postgres;