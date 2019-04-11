CREATE TABLE "user"
(
	"id" SERIAL NOT NULL,
	"username"	VARCHAR(50) NOT NULL,
	"email"	VARCHAR(512) NOT NULL,
	"password"	VARCHAR(50) NOT NULL,
	"first_name" VARCHAR(20) NOT NULL,
	"last_name"  VARCHAR(20) NOT NULL,
	"city"	VARCHAR(20) NOT NULL,
	"phone" VARCHAR(11) NOT NULL,
	"is_active"	BOOLEAN NOT NULL,
	CONSTRAINT pk_user_id PRIMARY KEY ("id"),
	CONSTRAINT uk_email UNIQUE ("email"),
	CONSTRAINT uk_phone UNIQUE ("phone")
)