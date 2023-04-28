/* populating data for greenhouse schema */
INSERT INTO LOCATION VALUES(seqOID.nextVal,'Desert Plants', '0', '90');
INSERT INTO LOCATION VALUES(seqOID.nextVal,'Lawn Plants', '60', '70');
INSERT INTO LOCATION VALUES(seqOID.nextVal,'Jungle Plants', '90', '80');
INSERT INTO LOCATION VALUES(seqOID.nextVal,'Temperate Plants', '50', '60');
INSERT INTO LOCATION VALUES(seqOID.nextVal,'Savannah Plants', '20', '70');

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
  ('Orchid','DESCRIPTION','3.99','purple',3,'Water weekly',
  'Commercial growing mix');
INSERT INTO plant_type VALUES 
  ('Cactus','DESCRIPTION','5.99','green',1,'Water every 10 days in summer',
  'Fast draining soil');
INSERT INTO plant_type VALUES 
  ('Sunflower','DESCRIPTION','6.99','yellow',2,'Water regularly',
  'Well-drained soil with organic matter');
INSERT INTO plant_type VALUES 
  ('Daffodil','DESCRIPTION','5.99','yellow', 2,'Water regularly in spring and fall',
  'Well-drained slightly acidic soil');
INSERT INTO plant_type VALUES 
  ('Tulip','DESCRIPTION','4.99','orange',2,'Water rarely except immediately after planting and in dry regions',
  'Rich, neutral well-draining soil');

INSERT INTO plant VALUES 
  ('123456','70844465','orchid','3-24 in','0','0');
INSERT INTO plant VALUES 
  ('789101','60665443','cactus','1-96 in','0','0');
INSERT INTO plant VALUES 
  ('157884','55079372','sunflower','3-10 ft','0','0');
INSERT INTO plant VALUES 
  ('603674','65465615','daffodil','6-30 in','0','0');
INSERT INTO plant VALUES 
  ('882346','96251650','tulip','9-24 in','0','0');

INSERT INTO plant VALUES 
  ('orchid',3,'10');
INSERT INTO plant VALUES 
  ('cactus',1,'35');
INSERT INTO plant VALUES 
  ('sunflower',2,'16');
INSERT INTO plant VALUES 
  ('daffodil',2,'42');
INSERT INTO plant VALUES  
  ('tulip',2,'26');

  
  

    

  
  

  
  