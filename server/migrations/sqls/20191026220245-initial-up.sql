
CREATE TABLE driver (
    driverId INT AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(128),
    last_name VARCHAR(128),
    username  VARCHAR(128),
    pwd VARCHAR(128),
    mobile_number VARCHAR(128),
    driving_license_number VARCHAR(128),
    license_expiry_date date,
    birth_date DATE,
    working   boolean,
    info_changed boolean,
    balance VARCHAR(128),
    driver_status VARCHAR(128),
    review_count VARCHAR(128),
    rating VARCHAR(128),
    driver_image VARCHAR(128),
    car_image VARCHAR(128),
    credit VARCHAR(128),
    account_number VARCHAR(128),
    PRIMARY KEY (driverId)
);

CREATE TABLE rider (
    id INT AUTO_INCREMENT NOT NULL,
    firstName VARCHAR(128),
    media_id int,
    lastName VARCHAR(128),
    username  VARCHAR(128),
    pwd VARCHAR(128),
    info_changed VARCHAR(128),
    mobile_number VARCHAR(128),
    balance VARCHAR(128),
    balance_amount VARCHAR(128),
    PRIMARY KEY (id)
);

CREATE TABLE driver_review (
    id INT AUTO_INCREMENT NOT NULL,
    fk_rider int,
    fk_driver int,
    review VARCHAR(128),
    score VARCHAR(128),
    PRIMARY KEY (id),
    FOREIGN KEY (fk_rider) REFERENCES rider(id),
    FOREIGN KEY (fk_driver) REFERENCES driver(driverId)
);

CREATE TABLE driver_service (
    id INT AUTO_INCREMENT NOT NULL,
    driver_id int,
    service_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (driver_id) REFERENCES driver(driverId)
);

CREATE TABLE driver_transaction (
    id INT AUTO_INCREMENT NOT NULL,
    content text,
    PRIMARY KEY (id)
);


CREATE TABLE service_category (
    id INT AUTO_INCREMENT NOT NULL,
    title VARCHAR(128),
    PRIMARY KEY (id)
);

CREATE TABLE service_tbl (
    id INT AUTO_INCREMENT NOT NULL,
    service_category_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (service_category_id) REFERENCES service_category(id)
);

CREATE TABLE car_model (
    id INT AUTO_INCREMENT NOT NULL,
    model_name VARCHAR(64),
    model_description text,
    PRIMARY KEY (id)
);

CREATE TABLE payment_request (
    id INT AUTO_INCREMENT NOT NULL,
    fk_driver int,
    amount VARCHAR(128),
    account_number VARCHAR(128),
    payment_status VARCHAR(128),
    paid_date TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (fk_driver) REFERENCES driver(driverId)
);

CREATE TABLE cab (
    id INT AUTO_INCREMENT NOT NULL,
    license_plate VARCHAR(128),
    cab_model_id int,
    driver_id int,
    manufacture_year int,
    owned_id int,
    active boolean,
    PRIMARY KEY (id),
    FOREIGN KEY (cab_model_id) REFERENCES car_model(id),
    FOREIGN KEY (driver_id) REFERENCES driver(driverId)
);



CREATE TABLE shift (
    id INT AUTO_INCREMENT NOT NULL,
    driver_id int,
    cab_id int,
    shift_start_time timestamp,
    shift_end_time timestamp,
    login_time timestamp,
    logout_time timestamp,
    PRIMARY KEY (id),
    FOREIGN KEY (driver_id) REFERENCES driver(driverId),
    FOREIGN KEY (cab_id) REFERENCES cab(id)
);


-- Section 2: Rides



CREATE TABLE rider_address (
    id INT AUTO_INCREMENT NOT NULL,
    rider_id int,
    title VARCHAR(128),
    rider_address VARCHAR(128),
    rider_location VARCHAR(128),
    PRIMARY KEY (id),
    FOREIGN KEY (rider_id) REFERENCES rider(id)
);

CREATE TABLE payment_type (
    id INT AUTO_INCREMENT NOT NULL,
    payment_type_name VARCHAR(128),
    PRIMARY KEY (id)
);

CREATE TABLE travel (
    id INT AUTO_INCREMENT NOT NULL,
    shift_id int,
    fk_rider int,
    fk_driver int,
    is_hidden boolean,
    rider_id int,
    payment_type_id int,
    ride_start_time TIMESTAMP,
    ride_end_time TIMESTAMP,
    pickup_address text,
    pickup_poin text,
    destination_point text,
    distance_best text,
    duration_best text,
    cost_best text,
    travel_status VARCHAR(128),
    duration_real VARCHAR(128),
    distance_real VARCHAR(128),
    travel_log text,
    request_time TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (shift_id) REFERENCES shift(id),
    FOREIGN KEY (payment_type_id) REFERENCES payment_type(id),
    FOREIGN KEY (fk_rider) REFERENCES rider(id),
    FOREIGN KEY (fk_driver) REFERENCES driver(driverId)
);

CREATE TABLE travel_complaint (
  id INT AUTO_INCREMENT NOT NULL,
  fk_travel_id int,
  fk_complaint_type_driver_id int,
  complaint_subject VARCHAR(128),
  content VARCHAR(128),
  is_reviewed boolean,
  time_review TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (fk_complaint_type_driver_id) REFERENCES driver(driverId),
  FOREIGN KEY (fk_travel_id) REFERENCES travel(id)
);

CREATE TABLE media (
    id INT AUTO_INCREMENT NOT NULL,
    media_type VARCHAR(128),
    privacy_level VARCHAR(128),
    media_address VARCHAR(128),
    path_type VARCHAR(128),
    info_changed VARCHAR(128),
    mobile_number VARCHAR(128),
    balance VARCHAR(128),
    balance_amount VARCHAR(128),
    PRIMARY KEY (id)
);


CREATE TABLE operator (
    id INT AUTO_INCREMENT NOT NULL,
    username  VARCHAR(128),
    pwd VARCHAR(128),
    oprt_status VARCHAR(128),
    PRIMARY KEY (id)
);



-- In the cab_status table, we’ll store a list of all possible statuses that we could assign to a ride. 
-- Some values include “new ride”, “ride assigned to driver”, “ride started”, “ride ended”, or “ride canceled”

CREATE TABLE cab_status (
    id INT AUTO_INCREMENT NOT NULL,
    status_name VARCHAR(128),
    PRIMARY KEY (id)
);



-- Uncategorized Tables
-- The cc_agent table contains a list of
--  call center agents or dispatchers that can add new records in the cab_ride and cab_ride_status tables.



CREATE TABLE cc_agent (
    cc_agent_id INT AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(128),
    last_name VARCHAR(128),
    PRIMARY KEY (cc_agent_id)
);


CREATE TABLE travel_ride_status (
    id INT AUTO_INCREMENT NOT NULL,
    travel_ride_id int,
    cab_status_id int,
    status_time TIMESTAMP,
    cc_agent_id int,
    shift_id int,
    status_details text,
    PRIMARY KEY (id),
    FOREIGN KEY (travel_ride_id) REFERENCES travel(id),
    FOREIGN KEY (cab_status_id) REFERENCES cab_status(id),
    FOREIGN KEY (cc_agent_id) REFERENCES cc_agent(cc_agent_id),
    FOREIGN KEY (shift_id) REFERENCES shift(id)
);








