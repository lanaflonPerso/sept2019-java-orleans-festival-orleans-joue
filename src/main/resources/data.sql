/* INSERT INTO table (nom_colonne_1, nom_colonne_2, ...
 VALUES ('valeur 1', 'valeur 2', ...)
*/

INSERT INTO tasks (name ) VALUES('animation de jeux');
INSERT INTO tasks (name) VALUES('acceuil du public' );
INSERT INTO tasks (name) VALUES('buvette');
INSERT INTO event (name, 
				   tables, 
				   protozone_tables,
				   max_tables_per_editor, 
				   event_beginning_date, 
				   event_ending_date, 
				   editors_registration_begin_date, 
				   editors_registration_end_date,
				   shops_registration_begin_date,
				   shops_registration_end_date,
				   volunteers_registration_begin_date,
				   volunteers_registration_end_date,
				   registration_open,
				   registration_before,
				   agent_provided
				   )VALUES('Edition 2020 ouverte',200,20,20,'2020-2-1','2020-2-28','2019-10-1','2019-12-31','2019-10-1','2019-12-31','2019-10-1','2019-12-31',0,0,0);
INSERT INTO event (name, 
				   tables, 
				   protozone_tables,
				   max_tables_per_editor, 
				   event_beginning_date, 
				   event_ending_date, 
				   editors_registration_begin_date, 
				   editors_registration_end_date,
				   shops_registration_begin_date,
				   shops_registration_end_date,
				   volunteers_registration_begin_date,
				   volunteers_registration_end_date,
				   registration_open,
				   registration_before,
				   agent_provided
				   ) VALUES('Edition 2020 ouverte inscription fermée',200,20,20,'2020-2-1','2020-2-28','2019-12-10','2019-12-31','2019-10-1','2019-10-31','2019-10-1','2019-10-31',0,0,0);
INSERT INTO event (name, 
				   tables, 
				   protozone_tables,
				   max_tables_per_editor, 
				   event_beginning_date, 
				   event_ending_date, 
				   editors_registration_begin_date, 
				   editors_registration_end_date,
				   shops_registration_begin_date,
				   shops_registration_end_date,
				   volunteers_registration_begin_date,
				   volunteers_registration_end_date,
				   registration_open,
				   registration_before,
				   agent_provided
				   ) VALUES('Edition 2019',200,20,20,'2019-2-1','2019-2-28','2018-10-1','2018-10-31','2018-10-1','2018-10-31','2018-10-1','2018-10-31',0,0,0);
INSERT INTO address (wording,phone_number1,phone_number2, postal_code) VALUES('Adresse de toto',1234567891,1234567891,45000);
INSERT INTO address (wording,phone_number1,phone_number2, postal_code) VALUES('Adresse de la société de JM',1234567891,1234567891,45000);
INSERT INTO user_role (wording) VALUES('admin');
INSERT INTO user_role (wording) VALUES('editeur');
INSERT INTO user (email,password,firstname,lastname, address_id, user_role_id,profile_picture) VALUES('jeanmichel@editeur.fr','1234','Jean-Michel','Editeur',1,2,'pictures/profile/1.jpg');
INSERT INTO society (name,address_id) VALUES('Société de JM',2);
INSERT INTO event_tasks VALUES(1,1);
INSERT INTO event_tasks VALUES(1,2);
INSERT INTO event_tasks VALUES(1,3);
INSERT INTO event_tasks VALUES(2,1);
INSERT INTO event_tasks VALUES(2,1);
