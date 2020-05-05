
CREATE TABLE IF NOT EXISTS "event" (
    id       varchar(16) CONSTRAINT event_pk PRIMARY KEY,
    title       varchar(100) NOT NULL,
   );

CREATE TABLE IF NOT EXISTS "guest" (
    id       varchar(16) CONSTRAINT guest_pk PRIMARY KEY,
    email       varchar(100) NOT NULL,
   );

   CREATE TABLE IF NOT EXISTS "event_guest" (
   event_id FOREIGN KEY (event_fk) REFERENCES event(id),
   guest_id FOREIGN KEY (guest_fk) REFERENCES guest(id),
);