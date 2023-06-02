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
INSERT INTO public.activity_type (id, name) VALUES (DEFAULT, 'Jooga');
INSERT INTO public.activity_type (id, name) VALUES (DEFAULT, 'Saunatamine');
INSERT INTO public.activity_type (id, name) VALUES (DEFAULT, 'Tants');
INSERT INTO public.activity_type (id, name) VALUES (DEFAULT, 'Motosport');
INSERT INTO public.activity_type (id, name) VALUES (DEFAULT, 'Korilus');


INSERT INTO public.address (id, description, addressxcoordinate, addressycoordinate) VALUES (DEFAULT, 'Kihnu tuletorni all', null, null);
INSERT INTO public.address (id, description, addressxcoordinate, addressycoordinate) VALUES (DEFAULT, 'Linnu tee 21', null, null);
INSERT INTO public.address (id, description, addressxcoordinate, addressycoordinate) VALUES (DEFAULT,  'Siili tee 34-2', null, null);
INSERT INTO public.address (id, description, addressxcoordinate, addressycoordinate) VALUES (DEFAULT, 'Muti tee 23-4', null, null);
INSERT INTO public.address (id, description, addressxcoordinate, addressycoordinate) VALUES (DEFAULT, 'Karu tee 2-4', null, null);
INSERT INTO public.address (id, description, addressxcoordinate, addressycoordinate) VALUES (DEFAULT, 'Pirita rannamaja juures', null, null);
INSERT INTO public.address (id, description, addressxcoordinate, addressycoordinate) VALUES (DEFAULT, 'Pirita rannahoone all', null, null);
INSERT INTO public.address (id, description, addressxcoordinate, addressycoordinate) VALUES (DEFAULT, 'Tallinn, Aia 10, II korrus', null, null);
INSERT INTO public.address (id, description, addressxcoordinate, addressycoordinate) VALUES (DEFAULT, 'Pirita rannahoone juures', null, null);
INSERT INTO public.address (id, description, addressxcoordinate, addressycoordinate) VALUES (DEFAULT, 'Sõõriksoo raba', null, null);
INSERT INTO public.address (id, description, addressxcoordinate, addressycoordinate) VALUES (DEFAULT, 'Kusagil Harjumaal', null, null);
INSERT INTO public.address (id, description, addressxcoordinate, addressycoordinate) VALUES (DEFAULT, 'Tallinn, Vegan tee 21-11', null, null);
INSERT INTO public.address (id, description, addressxcoordinate, addressycoordinate) VALUES (DEFAULT, 'Suure Munamäe vaatetorn', null, null);
INSERT INTO public.address (id, description, addressxcoordinate, addressycoordinate) VALUES (DEFAULT, 'Tallinn, Vaarika tee 22-22', null, null);


INSERT INTO public.location (id, name) VALUES (DEFAULT, 'Tallinn');
INSERT INTO public.location (id, name) VALUES (DEFAULT, 'Viljandi');
INSERT INTO public.location (id, name) VALUES (DEFAULT, 'Pärnu');
INSERT INTO public.location (id, name) VALUES (DEFAULT, 'Haapsalu');
INSERT INTO public.location (id, name) VALUES (DEFAULT, 'Pirita rand');
INSERT INTO public.location (id, name) VALUES (DEFAULT, 'Kihnu saar');
INSERT INTO public.location (id, name) VALUES (DEFAULT, 'Harjumaa');
INSERT INTO public.location (id, name) VALUES (DEFAULT, 'Võrumaa');


INSERT INTO public.spots (id, min, max, available, taken) VALUES (DEFAULT, 3, 12, 9, 3);
INSERT INTO public.spots (id, min, max, available, taken) VALUES (DEFAULT, 2, 6, 4, 2);
INSERT INTO public.spots (id, min, max, available, taken) VALUES (DEFAULT, 12, 30, 28, 2);
INSERT INTO public.spots (id, min, max, available, taken) VALUES (DEFAULT, 4, 8, 7, 1);
INSERT INTO public.spots (id, min, max, available, taken) VALUES (DEFAULT, 4, 8, 8, 0);
INSERT INTO public.spots (id, min, max, available, taken) VALUES (DEFAULT, 1, 11, 9, 2);
INSERT INTO public.spots (id, min, max, available, taken) VALUES (DEFAULT, 5, 11, 11, 0);
INSERT INTO public.spots (id, min, max, available, taken) VALUES (DEFAULT, 1, 2, 1, 1);
INSERT INTO public.spots (id, min, max, available, taken) VALUES (DEFAULT, 7, 77, 11, 66);
INSERT INTO public.spots (id, min, max, available, taken) VALUES (DEFAULT, 4, 17, 14, 3);
INSERT INTO public.spots (id, min, max, available, taken) VALUES (DEFAULT, 2, 12, 9, 3);
INSERT INTO public.spots (id, min, max, available, taken) VALUES (DEFAULT, 2, 20, 20, 0);
INSERT INTO public.spots (id, min, max, available, taken) VALUES (DEFAULT, 2, 22, 22, 0);
INSERT INTO public.spots (id, min, max, available, taken) VALUES (DEFAULT, 2, 22, 22, 0);


INSERT INTO public.time (id, date_created, registration_date, start_date, start_time, end_date, end_time) VALUES (DEFAULT, '2023-05-22 14:09:42.000000', '2023-06-03', '2023-06-23', '14:00:00', '2023-06-25', '21:00:00');
INSERT INTO public.time (id, date_created, registration_date, start_date, start_time, end_date, end_time) VALUES (DEFAULT, '2023-05-22 14:11:18.000000', '2023-05-29', '2023-05-31', '10:00:00', '2023-05-31', '18:00:00');
INSERT INTO public.time (id, date_created, registration_date, start_date, start_time, end_date, end_time) VALUES (DEFAULT, '2023-05-22 14:12:06.000000', '2023-06-02', '2023-06-04', '12:00:00', '2023-06-05', '17:00:00');
INSERT INTO public.time (id, date_created, registration_date, start_date, start_time, end_date, end_time) VALUES (DEFAULT, '2023-05-22 14:13:01.000000', '2023-06-13', '2023-06-15', '11:00:00', '2023-06-16', '15:00:00');
INSERT INTO public.time (id, date_created, registration_date, start_date, start_time, end_date, end_time) VALUES (DEFAULT, '2023-05-22 14:39:44.000000', '2023-06-06', '2023-06-16', '06:00:00', '2023-06-16', '11:00:00');
INSERT INTO public.time (id, date_created, registration_date, start_date, start_time, end_date, end_time) VALUES (DEFAULT, '2023-06-01 14:42:58.315116', '2023-06-08', '2023-06-10', '06:06:00', '2023-06-10', '11:11:00');
INSERT INTO public.time (id, date_created, registration_date, start_date, start_time, end_date, end_time) VALUES (DEFAULT, '2023-06-01 14:49:49.103005', '2023-06-03', '2023-06-04', '05:05:00', '2023-06-04', '10:10:00');
INSERT INTO public.time (id, date_created, registration_date, start_date, start_time, end_date, end_time) VALUES (DEFAULT, '2023-06-01 15:00:41.379399', '2023-06-06', '2023-06-08', '17:17:00', '2023-06-08', '19:19:00');
INSERT INTO public.time (id, date_created, registration_date, start_date, start_time, end_date, end_time) VALUES (DEFAULT, '2023-06-01 15:05:39.362865', '2023-05-03', '2023-05-05', '15:15:00', '2023-05-05', '22:22:00');
INSERT INTO public.time (id, date_created, registration_date, start_date, start_time, end_date, end_time) VALUES (DEFAULT, '2023-06-01 15:19:35.221286', '2023-05-15', '2023-05-20', '10:10:00', '2023-05-20', '15:15:00');
INSERT INTO public.time (id, date_created, registration_date, start_date, start_time, end_date, end_time) VALUES (DEFAULT, '2023-06-01 15:21:28.826530', '2023-05-01', '2023-05-06', '12:21:00', '2023-05-06', '20:20:00');
INSERT INTO public.time (id, date_created, registration_date, start_date, start_time, end_date, end_time) VALUES (DEFAULT, '2023-06-01 15:31:21.757917', '2023-06-15', '2023-06-17', '17:17:00', '2023-06-17', '21:21:00');
INSERT INTO public.time (id, date_created, registration_date, start_date, start_time, end_date, end_time) VALUES (DEFAULT, '2023-06-01 15:35:32.076702', '2023-06-29', '2023-07-01', '11:11:00', '2023-07-01', '15:15:00');
INSERT INTO public.time (id, date_created, registration_date, start_date, start_time, end_date, end_time) VALUES (DEFAULT, '2023-06-01 15:43:37.625474', '2023-06-08', '2023-06-10', '12:12:00', '2023-06-10', '15:15:00');

INSERT INTO public.event (id, name, description, fee, status, image_id, activity_type_id, location_id, spots_id, address_id, time_id) VALUES (DEFAULT, 'Saunapidu', 'jaanipäeva pidu saunas (mitte-nii-üksikul) saarel', 5, 'A', null, 8, 6, 1, 1, 1);
INSERT INTO public.event (id, name, description, fee, status, image_id, activity_type_id, location_id, spots_id, address_id, time_id) VALUES (DEFAULT, 'Võrkpall Petsiga', 'lähme võrkpalli mängima', 0, 'A', null, 2, 2, 2, 2, 2);
INSERT INTO public.event (id, name, description, fee, status, image_id, activity_type_id, location_id, spots_id, address_id, time_id) VALUES (DEFAULT, 'Metsamatk', 'loodusega ühendusse', 0, 'A', null, 4, 1, 3, 3, 3);
INSERT INTO public.event (id, name, description, fee, status, image_id, activity_type_id, location_id, spots_id, address_id, time_id) VALUES (DEFAULT, 'Küpsetame pannkooke', 'magusad pannkoogid', 3, 'A', null, 1, 3, 4, 4, 4);
INSERT INTO public.event (id, name, description, fee, status, image_id, activity_type_id, location_id, spots_id, address_id, time_id) VALUES (DEFAULT, 'Kalale minek', 'Matiga kalale', 0, 'A', null, 6, 4, 5, 5, 5);
INSERT INTO public.event (id, name, description, fee, status, image_id, activity_type_id, location_id, spots_id, address_id, time_id) VALUES (DEFAULT, 'Õuejooga', 'Alustame hommikut värskendava joogaga mererannas. Kaasa võtta oma joogamatt ja soe pleed.', 11, 'A', null, 7, 5, 6, 6, 6);
INSERT INTO public.event (id, name, description, fee, status, image_id, activity_type_id, location_id, spots_id, address_id, time_id) VALUES (DEFAULT, 'Päikesetõusu jooga', 'Teeme ergastava alguse päevale alustades päikesetõusuga koos rannas joogaga.', 20, 'A', null, 7, 5, 7, 7, 7);
INSERT INTO public.event (id, name, description, fee, status, image_id, activity_type_id, location_id, spots_id, address_id, time_id) VALUES (DEFAULT, 'Bachata intensiivtund', 'Kas ühele inimesele või ühele paarile intensiivtund bachatas. Sobib nii täiesti algajale kui ka juba kogenud bachata tantsijale, kes soovib oma oskusi lihvida.', 44, 'A', null, 9, 1, 8, 8, 8);
INSERT INTO public.event (id, name, description, fee, status, image_id, activity_type_id, location_id, spots_id, address_id, time_id) VALUES (DEFAULT, 'Bachata õuepidu', 'Teeme ühe korraliku bachata tantsujämmi mererannal', 7, 'H', null, 9, 5, 9, 9, 9);
INSERT INTO public.event (id, name, description, fee, status, image_id, activity_type_id, location_id, spots_id, address_id, time_id) VALUES (DEFAULT, 'Rabamatk Sõõriksoos', 'Matkame rabas', 0, 'H', null, 4, 7, 10, 10, 10);
INSERT INTO public.event (id, name, description, fee, status, image_id, activity_type_id, location_id, spots_id, address_id, time_id) VALUES (DEFAULT, 'Offroad sõit', 'Sõidame offroadi', 22, 'H', null, 10, 7, 11, 11, 11);
INSERT INTO public.event (id, name, description, fee, status, image_id, activity_type_id, location_id, spots_id, address_id, time_id) VALUES (DEFAULT, 'Grillime juurikaid', 'Teeme lihavaba grilliõhtu. Baasasjad on olemas. Igaüks võiks kaasa haarata midagi enda lemmikut, mida grilli peal katsetada.', 10, 'A', null, 3, 1, 12, 12, 12);
INSERT INTO public.event (id, name, description, fee, status, image_id, activity_type_id, location_id, spots_id, address_id, time_id) VALUES (DEFAULT, 'Korjame metsmaasikaid', 'Saame kokku Suure Munamäe vaatetorni all ja läheme koos kohalikele maasikaväljadele värskeid metsmaasikaid korjama', 0, 'A', null, 11, 8, 13, 13, 13);
INSERT INTO public.event (id, name, description, fee, status, image_id, activity_type_id, location_id, spots_id, address_id, time_id) VALUES (DEFAULT, 'Valmistame toortorti', 'Teeme koos ülimaitsva, ilusa ja tervisliku toortordi. Kõik vajalikud koostisosad on kohapeal olemas. Kaasa tuleb võtta hea tuju, uudishimu ja avatud meel.', 22, 'A', null, 1, 1, 14, 14, 14);

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
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 1, 1, 6, 'A');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 1, 1, 7, 'A');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 1, 2, 8, 'A');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 1, 2, 9, 'H');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 2, 2, 2, 'A');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 2, 2, 1, 'A');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 2, 2, 3, 'A');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 3, 2, 4, 'A');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 1, 4, 10, 'H');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 1, 4, 11, 'H');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 2, 2, 11, 'H');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 2, 2, 10, 'H');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 2, 1, 10, 'H');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 2, 1, 11, 'H');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 2, 5, 11, 'H');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 2, 5, 10, 'H');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 1, 5, 12, 'A');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 1, 5, 13, 'A');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 1, 5, 14, 'A');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 2, 5, 2, 'A');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 2, 5, 6, 'A');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 2, 5, 4, 'A');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 2, 5, 8, 'A');
INSERT INTO public.event_user (id, connection_type_id, user_id, event_id, status) VALUES (DEFAULT, 2, 2, 6, 'A');




