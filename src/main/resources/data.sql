/* INSERT INTO table (nom_colonne_1, nom_colonne_2, ...
 VALUES ('valeur 1', 'valeur 2', ...)
*/

INSERT INTO tasks (name ) VALUES('animation de jeux');
INSERT INTO tasks (name) VALUES('accueil du public' );
INSERT INTO tasks (name) VALUES('buvette');
INSERT INTO event (name,
				description, 
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
				price_per_table,
				sale_option_price,
				discount
				   )VALUES('Festival Orléans joue 2020',
'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.',
200,20,20,'2020-2-1','2020-2-28','2019-10-1','2019-12-31','2019-10-1','2019-12-31','2019-10-1','2019-12-31',0,0,65,100,3);
INSERT INTO event (name,
				description, 
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
				price_per_table,
				sale_option_price,
				discount
				   ) VALUES('Printemps des éditeurs', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.',200,20,20,'2020-2-1','2020-2-28','2019-12-25','2019-12-31','2019-10-1','2019-10-31','2019-10-1','2019-10-31',0,0,65,100,3);
INSERT INTO event (name,
				description,
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
				price_per_table,
				sale_option_price,
				discount
				   ) VALUES('Edition 2019','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.',200,20,20,'2019-2-1','2019-2-28','2018-10-1','2018-10-31','2018-10-1','2018-10-31','2018-10-1','2018-10-31',0,0,65,100,3);
INSERT INTO address (wording,phone_number1,phone_number2, postal_code) VALUES('Adresse de toto',1234567891,1234567891,45000);
INSERT INTO address (wording,phone_number1,phone_number2, postal_code) VALUES('Adresse de la société de JM',1234567891,1234567891,45000);
INSERT INTO user_role (wording) VALUES('admin');
INSERT INTO user_role (wording) VALUES('editeur');
INSERT INTO society (name,address_id) VALUES('Société de JM',2);
INSERT INTO user (email,password,firstname,lastname, address_id, user_role_id,profile_picture,society_id) VALUES('jeanmichel@editeur.fr','1234','Jean-Michel','Editeur',1,2,'pictures/profile/1.jpg',1);
INSERT INTO event_tasks VALUES(1,1);
INSERT INTO event_tasks VALUES(1,2);
INSERT INTO event_tasks VALUES(1,3);
INSERT INTO event_tasks VALUES(2,1);
INSERT INTO event_tasks VALUES(2,1);
INSERT INTO `registration` (`agent_provided`, `comments`, `electrical_supply_need`, `registration_cost`, `sale_option`, `state`, `subscription_date`, `tables_quantity`, `volunteers_need`, `event_id`, `society_id`) VALUES (b'1', 'Besoin de 2 t-shirt supplémentaires.', b'1', '360', b'1', 'pending', '2019-12-16 15:09:22', '5', b'1', '1', '1');
