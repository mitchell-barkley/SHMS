CREATE TABLE recommendations (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    recommendation_text TEXT NOT NULL,
    date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
)

CREATE TABLE public.recommendations
(
    id serial NOT NULL,
    user_id integer NOT NULL,
    recommendation_text text NOT NULL,
    date date NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT user_id FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS public.recommendations
    OWNER to postgres;