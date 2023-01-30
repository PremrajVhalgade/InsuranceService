CREATE TABLE IF NOT EXISTS `insurance` (

   insurance_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
   company_name varchar(50),
    insurance_type varchar(50),
    plan_name varchar(50),
    sum_assured int,
    monthly_premium int,
    annual_premium int
);

INSERT INTO insurance (insurance_id,company_name,insurance_type,plan_name,sum_assured,monthly_premium,annual_premium) VALUES 
(1,'Religare','Health Insurance','Starplan',500000,1067,12800),
(2,'Digit','Health Insurance','MasterPlan',500000,1267,15200),
(3,'Star Health','Health Insurance','BuddyPlan',500000,1150,13800),
(4,'Aditya Birla','Health Insurance','FamilyPlan',600000,1067,12800),
(5,'Manipla cigna','Health Insurance','NewAgePlan',500000,1000,12000),
(6,'HDFC ergo','Health Insurance','GoldPlan',500000,936,11230),
(7,'Care','Health Insurance','CarePlan',500000,1168,14010),
(8,'Reliance','Health Insurance','SuperPlan',800000,1283,15400),
(9,'The new India','Health Insurance','TricolorPlan',500000,1100,13200),
(10,'Max Bupa','Health Insurance','MaxPlan',800000,1075,12900);

								
