CREATE TABLE "user"
(
	"user_id" SERIAL NOT NULL
	"first_name" VARCHAR(20)
	"last_name"  VARCHAR(20)
	"username"	VARCHAR(50)
	"email"	VARCHAR(512)
	"password"	VARCHAR(50)
	"city"	VARCHAR(20)
	"phone" VARCHAR(11)
	"is_active"	BOOLEAN NOT NULL
	CONSTRAINT pk_user_id PRIMARY KEY ("id")
)