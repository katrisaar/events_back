-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-05-17 07:14:02.797

-- tables
-- Table: activity_type
CREATE TABLE activity_type (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    CONSTRAINT activity_type_pk PRIMARY KEY (id)
);

-- Table: address
CREATE TABLE address (
    id serial  NOT NULL,
    description varchar(255)  NOT NULL,
    addressXcoordinate real  NULL,
    addressYcoordinate real  NULL,
    CONSTRAINT address_pk PRIMARY KEY (id)
);

-- Table: connection_type
CREATE TABLE connection_type (
    id serial  NOT NULL,
    name varchar(50)  NOT NULL,
    CONSTRAINT connection_type_pk PRIMARY KEY (id)
);

-- Table: contact
CREATE TABLE contact (
    id serial  NOT NULL,
    first_name varchar(50)  NOT NULL,
    last_name varchar(50)  NOT NULL,
    email varchar(50)  NOT NULL,
    image_id int  NULL,
    CONSTRAINT contact_pk PRIMARY KEY (id)
);

-- Table: event
CREATE TABLE event (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    description varchar(3000)  NOT NULL,
    fee int  NULL,
    status char(1)  NOT NULL,
    image_id int  NULL,
    activity_type_id int  NOT NULL,
    location_id int  NOT NULL,
    spots_id int  NOT NULL,
    address_id int  NOT NULL,
    time_id int  NOT NULL,
    CONSTRAINT event_pk PRIMARY KEY (id)
);

-- Table: event_user
CREATE TABLE event_user (
    id serial  NOT NULL,
    connection_type_id int  NOT NULL,
    user_id int  NOT NULL,
    event_id int  NOT NULL,
    status char(1)  NOT NULL,
    CONSTRAINT event_user_pk PRIMARY KEY (id)
);

-- Table: image
CREATE TABLE image (
    id serial  NOT NULL,
    data bytea  NOT NULL,
    CONSTRAINT image_pk PRIMARY KEY (id)
);

-- Table: location
CREATE TABLE location (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    CONSTRAINT location_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
    id serial  NOT NULL,
    name varchar(50)  NOT NULL,
    CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: spots
CREATE TABLE spots (
    id serial  NOT NULL,
    min int  NOT NULL,
    max int  NOT NULL,
    available int  NOT NULL,
    taken int  NOT NULL,
    CONSTRAINT spots_pk PRIMARY KEY (id)
);

-- Table: time
CREATE TABLE time (
    id serial  NOT NULL,
    date_created timestamp  NOT NULL,
    registration_date date  NOT NULL,
    start_date date  NOT NULL,
    start_time time  NOT NULL,
    end_date date  NULL,
    end_time time  NULL,
    CONSTRAINT time_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
    id serial  NOT NULL,
    username varchar(50)  NOT NULL,
    password varchar(50)  NOT NULL,
    role_id int  NOT NULL,
    status char(1)  NOT NULL,
    contact_id int  NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: contact_image (table: contact)
ALTER TABLE contact ADD CONSTRAINT contact_image
    FOREIGN KEY (image_id)
    REFERENCES image (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: event_activity_type (table: event)
ALTER TABLE event ADD CONSTRAINT event_activity_type
    FOREIGN KEY (activity_type_id)
    REFERENCES activity_type (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: event_address (table: event)
ALTER TABLE event ADD CONSTRAINT event_address
    FOREIGN KEY (address_id)
    REFERENCES address (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: event_image (table: event)
ALTER TABLE event ADD CONSTRAINT event_image
    FOREIGN KEY (image_id)
    REFERENCES image (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: event_location (table: event)
ALTER TABLE event ADD CONSTRAINT event_location
    FOREIGN KEY (location_id)
    REFERENCES location (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: event_spots (table: event)
ALTER TABLE event ADD CONSTRAINT event_spots
    FOREIGN KEY (spots_id)
    REFERENCES spots (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: event_time (table: event)
ALTER TABLE event ADD CONSTRAINT event_time
    FOREIGN KEY (time_id)
    REFERENCES time (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: event_user_connection_type (table: event_user)
ALTER TABLE event_user ADD CONSTRAINT event_user_connection_type
    FOREIGN KEY (connection_type_id)
    REFERENCES connection_type (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: event_user_event (table: event_user)
ALTER TABLE event_user ADD CONSTRAINT event_user_event
    FOREIGN KEY (event_id)
    REFERENCES event (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: event_user_user (table: event_user)
ALTER TABLE event_user ADD CONSTRAINT event_user_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_contact (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_contact
    FOREIGN KEY (contact_id)
    REFERENCES contact (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_role
    FOREIGN KEY (role_id)
    REFERENCES role (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

