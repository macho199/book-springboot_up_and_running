DROP TABLE IF EXISTS aircraft;

CREATE TABLE aircraft
(
	id SERIAL PRIMARY KEY,
	callsign VARCHAR(200) NOT NULL,
	squawk VARCHAR(200) NOT NULL,
	reg VARCHAR(200) NOT NULL,
	flightno VARCHAR(200) NOT NULL,
	route VARCHAR(200) NOT NULL,
	type VARCHAR(200) NOT NULL,
	category VARCHAR(200) NOT NULL,
	altitude INT NOT NULL,
	heading INT NOT NULL,
	speed INT NOT NULL,
	vert_rate INT NOT NULL,
	selected_altitude INT NOT NULL,
	lat REAL NOT NULL,
	lon REAL NOT NULL,
	barometer REAL NOT NULL,
	polar_distance INT NOT NULL,
	polar_bearing INT NOT NULL,
	is_adsb BOOLEAN NOT NULL,
	is_on_ground BOOLEAN NOT NULL,
	last_seen_time TIMESTAMP NULL,
	pos_update_time TIMESTAMP NULL,
	bds40_seen_time TIMESTAMP NULL	
);