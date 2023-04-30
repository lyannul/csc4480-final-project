/* populating data for greenhouse schema */
INSERT INTO LOCATION VALUES(1,'Desert Plants', '0', '90');
INSERT INTO LOCATION VALUES(2,'Lawn Plants', '60', '70');
INSERT INTO LOCATION VALUES(3,'Jungle Plants', '90', '80');
INSERT INTO LOCATION VALUES(4,'Temperate Plants', '50', '60');
INSERT INTO LOCATION VALUES(5,'Savannah Plants', '20', '70');

INSERT INTO CUSTOMER VALUES 
  ('Lucas','E','White','70844465','LWhite7', 'B4TbtxG');
INSERT INTO CUSTOMER VALUES 
  ('Bettie','T','Mals','60665443','BMals60','wIMr=Xe}');
INSERT INTO CUSTOMER VALUES 
  ('Mandy','S','Wallace','55079372','MWal55','S:`=slWi');
INSERT INTO CUSTOMER VALUES
  ('Jared','D','James','65465615','JJam65','m0WnZP\}');
INSERT INTO CUSTOMER VALUES
  ('Alex','J','Freeman','96251650','AFree96', 'WE;7uoP8');

INSERT INTO EMPLOYEE VALUES 
  ('James','E','Borg','888665555',4);
INSERT INTO EMPLOYEE VALUES 
  ('Sam','H','Moskowitz','333445555',2);
INSERT INTO EMPLOYEE VALUES 
  ('Alex','S','Wallace','987654321',5);
INSERT INTO EMPLOYEE VALUES
  ('Susan','D','James','111111100',3);
INSERT INTO EMPLOYEE VALUES
  ('Michael','B','Jordan', '444444400',2);
INSERT INTO EMPLOYEE VALUES
  ('John','C','James','555555500',1);

INSERT INTO plant_type VALUES 
  ('Orchid','DESCRIPTION','3.99','purple',2,'WEEKLY',
  'REGULAR');
INSERT INTO plant_type VALUES 
  ('Cactus','DESCRIPTION','5.99','green',1,'BIWEEKLY',
  'SAND');
INSERT INTO plant_type VALUES 
  ('Sunflower','DESCRIPTION','6.99','yellow',5,'DAILY',
  'ORGANIC');
INSERT INTO plant_type VALUES 
  ('Daffodil','DESCRIPTION','5.99','yellow',4,'DAILY',
  'ACIDIC');
INSERT INTO plant_type VALUES 
  ('Tulip','DESCRIPTION','4.99','orange',3,'MONTHLY',
  'REGULAR');

INSERT INTO plant VALUES 
  ('123456','70844465','Orchid',10, 0, 0);
INSERT INTO plant VALUES 
  ('789101','60665443','Cactus',35, 0, 0);
INSERT INTO plant VALUES 
  ('157884','55079372','Sunflower',16, 0, 0);
INSERT INTO plant VALUES 
  ('603674','65465615','Daffodil',42, 0, 0);
INSERT INTO plant VALUES 
  ('882346','96251650','Tulip',26, 0, 0);

  
  

    

  
  

  
  