CREATE DATABASE IF NOT EXISTS `mysqldb`;
USE `mysqldb`;



CREATE TABLE `employeelogregistry` (
  `PersonalNumber` varchar(20) NOT NULL,
  `EntryTime` varchar(70) NOT NULL,
  `ExitTime` varchar(70) DEFAULT NULL
);

CREATE TABLE `employeetable` (
  `PersonalNumber` varchar(20) NOT NULL,
  `FirstName` varchar(30) NOT NULL,
  `LastName` varchar(30) NOT NULL
);

INSERT INTO `employeetable` (`PersonalNumber`, `FirstName`, `LastName`) VALUES
('1234567890', 'test', 'testing'),
('9204287511', 'Ranjith', 'Vuppala'),
('9311137971', 'Rohith', 'Raju');


CREATE TABLE `visitorlogregistry` (
  `VisitorName` varchar(60) NOT NULL,
  `HostID` varchar(20) NOT NULL,
  `EntryTime` varchar(70) NOT NULL,
  `ExitTime` varchar(70) DEFAULT NULL
);
