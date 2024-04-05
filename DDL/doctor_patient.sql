CREATE TABLE doctor_patient (
    doctor_id INT NOT NULL,
    patient_id INT NOT NULL,
    PRIMARY KEY(doctor_id, patient_id),
    FOREIGN KEY(doctor_id) REFERENCES users(id),
    FOREIGN KEY(patient_id) REFERENCES users(id)
);

CREATE TABLE public.doctor_patient
(
    user_id integer NOT NULL,
    doctor_id integer NOT NULL,
    patient_id integer NOT NULL,
    CONSTRAINT user_id PRIMARY KEY (user_id)
);

ALTER TABLE IF EXISTS public.doctor_patient
    OWNER to postgres;