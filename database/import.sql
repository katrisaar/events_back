INSERT INTO public.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'customer');

INSERT INTO public.contact (id, first_name, last_name, email, image_id) VALUES (DEFAULT, 'Juss', 'Jänku', 'juss@jänku.ee', null);
INSERT INTO public.contact (id, first_name, last_name, email, image_id) VALUES (DEFAULT, 'Admin', 'Kõikvõimas', 'admin@admin.admin', null);
INSERT INTO public.contact (id, first_name, last_name, email, image_id) VALUES (DEFAULT, 'Mari', 'Maasikas', 'mari@maasikas.ee', null);
INSERT INTO public.contact (id, first_name, last_name, email, image_id) VALUES (DEFAULT, 'Mati', 'Mutikas', 'mati@muti.ee', null);
INSERT INTO public.contact (id, first_name, last_name, email, image_id) VALUES (DEFAULT, 'Meelis', 'Meeletu', 'mell@meel.ee', null);

INSERT INTO public."user" (id, username, password, role_id, status, contact_id) VALUES (DEFAULT, 'juss', '123', 2, 'A', 1);
INSERT INTO public."user" (id, username, password, role_id, status, contact_id) VALUES (DEFAULT, 'admin', '123', 1, 'A', 2);
INSERT INTO public."user" (id, username, password, role_id, status, contact_id) VALUES (DEFAULT, 'mari', '123', 2, 'D', 3);
INSERT INTO public."user" (id, username, password, role_id, status, contact_id) VALUES (DEFAULT, 'mati', '123', 2, 'A', 4);
INSERT INTO public."user" (id, username, password, role_id, status, contact_id) VALUES (DEFAULT, 'meelis', '123', 2, 'A', 5);

INSERT INTO public.activity_type (id, name) VALUES (DEFAULT, 'Kokkamine');
INSERT INTO public.activity_type (id, name) VALUES (DEFAULT, 'Pallimängud');
INSERT INTO public.activity_type (id, name) VALUES (DEFAULT, 'Grillimine');
INSERT INTO public.activity_type (id, name) VALUES (DEFAULT, 'Matkamine');
INSERT INTO public.activity_type (id, name) VALUES (DEFAULT, 'Sportimine');
INSERT INTO public.activity_type (id, name) VALUES (DEFAULT, 'Muud lahedat');

INSERT INTO public.address (id, description, addressxcoordinate, addressycoordinate) VALUES (DEFAULT, 'Mustamäe tee 1-2', null, null);
INSERT INTO public.address (id, description, addressxcoordinate, addressycoordinate) VALUES (DEFAULT, 'Linnu tee 21', null, null);
INSERT INTO public.address (id, description, addressxcoordinate, addressycoordinate) VALUES (DEFAULT, 'Siili tee 34-2', null, null);
INSERT INTO public.address (id, description, addressxcoordinate, addressycoordinate) VALUES (DEFAULT, 'Muti tee 23-4', null, null);
INSERT INTO public.address (id, description, addressxcoordinate, addressycoordinate) VALUES (DEFAULT, 'Karu tee 2-4', null, null);

INSERT INTO public.location (id, name) VALUES (DEFAULT, 'Tallinn');
INSERT INTO public.location (id, name) VALUES (DEFAULT, 'Viljandi');
INSERT INTO public.location (id, name) VALUES (DEFAULT, 'Pärnu');
INSERT INTO public.location (id, name) VALUES (DEFAULT, 'Haapsalu');

INSERT INTO public.spots (id, min, max, available, taken) VALUES (DEFAULT, 3, 12, 10, 2);
INSERT INTO public.spots (id, min, max, available, taken) VALUES (DEFAULT, 2, 6, 6, 0);
INSERT INTO public.spots (id, min, max, available, taken) VALUES (DEFAULT, 12, 30, 29, 1);
INSERT INTO public.spots (id, min, max, available, taken) VALUES (DEFAULT, 4, 8, 8, 0);
INSERT INTO public.spots (id, min, max, available, taken) VALUES (DEFAULT, 4, 8, 8, 0);

INSERT INTO public.time (id, date_created, registration_date, start_date, start_time, end_date, end_time) VALUES (DEFAULT, '2023-05-22 14:09:42.000000', '2023-06-21', '2023-06-23', '14:00:00', '2023-06-23', '21:00:00');
INSERT INTO public.time (id, date_created, registration_date, start_date, start_time, end_date, end_time) VALUES (DEFAULT, '2023-05-22 14:11:18.000000', '2023-05-30', '2023-05-31', '10:00:00', '2023-05-31', '18:00:00');
INSERT INTO public.time (id, date_created, registration_date, start_date, start_time, end_date, end_time) VALUES (DEFAULT, '2023-05-22 14:12:06.000000', '2023-06-02', '2023-06-04', '12:00:00', '2023-06-05', '17:00:00');
INSERT INTO public.time (id, date_created, registration_date, start_date, start_time, end_date, end_time) VALUES (DEFAULT, '2023-05-22 14:13:01.000000', '2023-06-13', '2023-06-15', '11:00:00', '2023-06-16', '15:00:00');
INSERT INTO public.time (id, date_created, registration_date, start_date, start_time, end_date, end_time) VALUES (DEFAULT, '2023-05-22 14:39:44.000000', '2023-05-15', '2023-05-16', '06:00:00', '2023-05-16', '11:00:00');

INSERT INTO public.event (id, name, description, fee, status, image_id, activity_type_id, location_id, spots_id, address_id, time_id) VALUES (DEFAULT, 'Saunapidu', 'pidu saunas', 5, 'A', null, 6, 4, 1, 1, 1);
INSERT INTO public.event (id, name, description, fee, status, image_id, activity_type_id, location_id, spots_id, address_id, time_id) VALUES (DEFAULT, 'Võrkpall Petsiga', 'lähme võrkpalli mängima', 0, 'A', null, 2, 2, 2, 2, 2);
INSERT INTO public.event (id, name, description, fee, status, image_id, activity_type_id, location_id, spots_id, address_id, time_id) VALUES (DEFAULT, 'Metsamatk', 'loodusega ühendusse', 0, 'A', null, 4, 1, 3, 3, 3);
INSERT INTO public.event (id, name, description, fee, status, image_id, activity_type_id, location_id, spots_id, address_id, time_id) VALUES (DEFAULT, 'Küpsetame pannkooke', 'magusad pannkoogid', 3, 'A', null, 1, 3, 4, 4, 4);
INSERT INTO public.event (id, name, description, fee, status, image_id, activity_type_id, location_id, spots_id, address_id, time_id) VALUES (DEFAULT, 'Kalale minek', 'Matiga kalale', 0, 'D', null, 6, 4, 5, 5, 5);

INSERT INTO public.connection_type (id, name) VALUES (DEFAULT, 'korraldaja');
INSERT INTO public.connection_type (id, name) VALUES (DEFAULT, 'osaleja');
INSERT INTO public.connection_type (id, name) VALUES (DEFAULT, 'huvitatud');

INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 1, 1, 1, 'A');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 1, 1, 2, 'A');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 1, 4, 3, 'A');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 1, 4, 4, 'A');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 1, 4, 5, 'A');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 2, 4, 1, 'A');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 2, 5, 1, 'A');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 2, 1, 3, 'A');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 3, 5, 3, 'A');



