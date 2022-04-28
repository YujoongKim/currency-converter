BEGIN TRANSACTION;
DROP TABLE IF EXISTS currency CASCADE;

CREATE TABLE currency (
	starting_currency char(50) NOT NULL,
	amount Decimal(50) NOT NULL,
	ending_currency char(50) NOT NULL,
	exchange_rate Decimal(50) NOT NULL,
	date timestamp NOT NULL
);

COMMIT TRANSACTION;
