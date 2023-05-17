INSERT INTO public.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'customer');

INSERT INTO public.contact (id, first_name, last_name, email, image_id) VALUES (DEFAULT, 'Juss', 'Jänku', 'juss@jänku.ee', null);
INSERT INTO public.contact (id, first_name, last_name, email, image_id) VALUES (DEFAULT, 'Admin', 'Kõikvõimas', 'admin@admin.admin', null);
INSERT INTO public.contact (id, first_name, last_name, email, image_id) VALUES (DEFAULT, 'Mari', 'Maasikas', 'mari@maasikas.ee', null);

INSERT INTO public."user" (id, username, password, role_id, status, contact_id) VALUES (DEFAULT, 'juss', '123', 2, 'A', 1);
INSERT INTO public."user" (id, username, password, role_id, status, contact_id) VALUES (DEFAULT, 'admin', '123', 1, 'A', 2);
INSERT INTO public."user" (id, username, password, role_id, status, contact_id) VALUES (DEFAULT, 'mari', '123', 2, 'D', 3);
