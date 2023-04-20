DROP TABLE CUSTOMER CASCADE CONSTRAINTS;
DROP TABLE EMPLOYEE CASCADE CONSTRAINTS;
DROP TABLE LOCATION CASCADE CONSTRAINTS;
DROP TABLE PLANT CASCADE CONSTRAINTS;
DROP TABLE PLANT_TYPE CASCADE CONSTRAINTS;
DROP TABLE NUMBER_OF CASCADE CONSTRAINTS;

CREATE TABLE CUSTOMER(
	FirstName               varchar2(15)        NOT NULL, 
    MInit                   varchar2(1),
    LastName                varchar2(15)        NOT NULL,
    CustomerID			    Int			        NOT NULL,
	UserName			    varchar2(50)	    NOT NULL,
	WebPassword			    varchar2(50)	    NOT NULL,
    PRIMARY KEY(CustomerID)
	);
    
CREATE TABLE LOCATION(
	LocationID               Int                 NOT NULL,
    LocationSector			 varchar2(50)	     NOT NULL,
    Humidity                 Int                 NOT NULL, 
    Temperature              Int                 NOT NULL,
    PRIMARY KEY(LocationID)
	);


CREATE TABLE EMPLOYEE(
	FirstName               varchar2(15)        NOT NULL, 
    MInit                   varchar2(1),
    LastName                varchar2(15)        NOT NULL,
    EmployeeID			    Int			        NOT NULL,
	LocationID			    Int         	    NOT NULL,
    PRIMARY KEY(EmployeeID),
	CONSTRAINT			    EMPLOYEE_FK	        FOREIGN KEY(LocationID)
							REFERENCES LOCATION(LocationID)
    );
    
CREATE TABLE PLANT_TYPE(
	TypeName                varchar2(50)        NOT NULL,
    Description             varchar2(50)        NOT NULL,
    Price			        Int			        NOT NULL,
    Color                   varchar2(15)        NOT NULL, 
    LocationID              Int                 NOT NULL,
    WaterNeeds              varchar2(15)        NOT NULL,
    SoilType                varchar2(15)        NOT NULL,
    PRIMARY KEY(TypeName),
    CONSTRAINT			    PLANT_TYPE_FK	    FOREIGN KEY(LocationID)
							REFERENCES LOCATION(LocationID)
	);
    
CREATE TABLE PLANT(
	PlantID                 Int                 NOT NULL,
    CustomerID			    Int			        NOT NULL,
    PlantType               varchar2(50)        NOT NULL,
    Height                  Int                 NOT NULL, 
    Hydrated                Int                 DEFAULT 0, --where 0 is false/not hydrated
    SunlightStatus          Int                 DEFAULT 0, --where 0 is false/no sunlight
    PRIMARY KEY(PlantID),
    CONSTRAINT			    PLANT_CUST_FK	    FOREIGN KEY(CustomerID)
							REFERENCES CUSTOMER(CustomerID),
    CONSTRAINT			    PLANT_FK	        FOREIGN KEY(PlantType)
							REFERENCES PLANT_TYPE(TypeName)
	);

CREATE TABLE NUMBER_OF(
	PlantType                varchar2(50)        NOT NULL,
    LocationID               Int                 NOT NULL,
    Quantity                 Int                 NOT NULL,
    PRIMARY KEY(PlantType,LocationID)
	);    
