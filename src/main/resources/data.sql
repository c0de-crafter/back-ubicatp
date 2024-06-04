-- Insertar datos en la tabla user_data
INSERT INTO `back-ubicatp`.user_data (email, password, first_name, last_name, profile_picture, role) VALUES
                                                                                                         ('john.doe@example.com', 'password1', 'John', 'Doe', 'john.png', 'USER'),
                                                                                                         ('jane.doe@example.com', 'password2', 'Jane', 'Doe', 'jane.png', 'USER'),
                                                                                                         ('admin@example.com', 'admin123', 'Admin', 'User', 'admin.png', 'ADMIN'),
                                                                                                         ('landlord1@example.com', 'landlord123', 'Landlord1', 'Example', 'landlord1.png', 'LANDLORD'),
                                                                                                         ('landlord2@example.com', 'landlord456', 'Landlord2', 'Example', 'landlord2.png', 'LANDLORD');

-- Insertar datos en la tabla property
INSERT INTO `back-ubicatp`.property (property_name, description, location, benefits, id_landlord) VALUES
                                                                                                      ('Sunset Villa', 'A beautiful villa with sea view', '123 Ocean Drive', 'Pool, Wifi, Breakfast', 4),
                                                                                                      ('Mountain Retreat', 'Cozy cabin in the mountains', '456 Mountain Road', 'Hiking, Fireplace', 4),
                                                                                                      ('City Apartment', 'Modern apartment in the city center', '789 City Ave', 'Gym, Wifi, Parking', 5),
                                                                                                      ('Beach House', 'Spacious house near the beach', '101 Beach Blvd', 'Pool, BBQ, Sea view', 5),
                                                                                                      ('Country Cottage', 'Charming cottage in the countryside', '202 Country Lane', 'Garden, Fireplace', 4);

-- Insertar datos en la tabla booking
INSERT INTO `back-ubicatp`.booking (start_date, end_date, number_of_people, price, id_property, id_user) VALUES
                                                                                                             ('2024-06-01', '2024-06-07', 4, 1200.00, 1, 1),
                                                                                                             ('2024-07-15', '2024-07-20', 2, 800.00, 2, 2),
                                                                                                             ('2024-08-05', '2024-08-12', 3, 900.00, 3, 1),
                                                                                                             ('2024-09-01', '2024-09-07', 5, 1500.00, 4, 2),
                                                                                                             ('2024-10-10', '2024-10-15', 4, 1100.00, 5, 1);

-- Insertar datos en la tabla booking_detail
INSERT INTO `back-ubicatp`.booking_detail (rental_name, address, area, description, reference, benefits, id_booking) VALUES
                                                                                                                         ('Sunset Villa', '123 Ocean Drive', '120 sqm', 'A beautiful villa with sea view', 'Near the lighthouse', 'Pool, Wifi, Breakfast', 1),
                                                                                                                         ('Mountain Retreat', '456 Mountain Road', '80 sqm', 'Cozy cabin in the mountains', 'Next to the hiking trail', 'Hiking, Fireplace', 2),
                                                                                                                         ('City Apartment', '789 City Ave', '100 sqm', 'Modern apartment in the city center', 'Above the mall', 'Gym, Wifi, Parking', 3),
                                                                                                                         ('Beach House', '101 Beach Blvd', '150 sqm', 'Spacious house near the beach', 'Close to the pier', 'Pool, BBQ, Sea view', 4),
                                                                                                                         ('Country Cottage', '202 Country Lane', '90 sqm', 'Charming cottage in the countryside', 'Next to the farm', 'Garden, Fireplace', 5);
