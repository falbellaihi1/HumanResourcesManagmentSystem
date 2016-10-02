-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 02, 2016 at 11:43 AM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `falbella_plant`
--

-- --------------------------------------------------------

--
-- Table structure for table `labels`
--

CREATE TABLE `labels` (
  `Plant_ID` int(10) NOT NULL,
  `Label_Name` varchar(35) NOT NULL,
  `Additional_Notes` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `plants`
--

CREATE TABLE `plants` (
  `Plant_ID` int(10) NOT NULL,
  `Genus` varchar(35) NOT NULL,
  `Species` varchar(35) NOT NULL,
  `Picture_ID` varchar(35) NOT NULL,
  `Table_Number` varchar(35) NOT NULL,
  `Table_Position` varchar(35) NOT NULL,
  `Other_Notes` text NOT NULL,
  `User_ID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `plants`
--

INSERT INTO `plants` (`Plant_ID`, `Genus`, `Species`, `Picture_ID`, `Table_Number`, `Table_Position`, `Other_Notes`, `User_ID`) VALUES
(15, 'a', 'a', 'a', 'a', 'a', 'a', 11),
(16, 'asss', 'ass', 'ass', 'ass', 'asssasd', 'asdsd', 11),
(20, 'smaple', 'sample', 'sample', 'sample', 'sample', 'othernotes', 30),
(21, 'dd', 'dd', 'dd', 'dd', 'dd', 'dd', 33);

-- --------------------------------------------------------

--
-- Table structure for table `resignation_request`
--

CREATE TABLE `resignation_request` (
  `ID` int(11) NOT NULL,
  `Name` varchar(35) CHARACTER SET utf16 COLLATE utf16_unicode_ci NOT NULL,
  `Employee_Num` varchar(35) NOT NULL,
  `National_ID` varchar(35) NOT NULL,
  `Notes` varchar(35) NOT NULL,
  `UserID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `resignation_request`
--

INSERT INTO `resignation_request` (`ID`, `Name`, `Employee_Num`, `National_ID`, `Notes`, `UserID`) VALUES
(14, '22', '44', '44', 'AWEDQWADE', 29);

-- --------------------------------------------------------

--
-- Table structure for table `tasks`
--

CREATE TABLE `tasks` (
  `Task_ID` int(10) NOT NULL,
  `Water_Amount` text NOT NULL,
  `Water_Time` date NOT NULL,
  `Fertilizer` text NOT NULL,
  `Start_Date` date NOT NULL,
  `End_Date` date NOT NULL,
  `Other_Notes` text NOT NULL,
  `Plant_ID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tasks`
--

INSERT INTO `tasks` (`Task_ID`, `Water_Amount`, `Water_Time`, `Fertilizer`, `Start_Date`, `End_Date`, `Other_Notes`, `Plant_ID`) VALUES
(21, 'sample', '1970-01-01', '12', '2016-04-04', '2016-04-04', 'othernotes', 20);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `ID` int(10) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(35) NOT NULL,
  `type` int(3) NOT NULL,
  `Picture_ID` varchar(35) NOT NULL,
  `Name` varchar(35) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Email` text NOT NULL,
  `Phone` text NOT NULL,
  `Employe_num` varchar(35) NOT NULL DEFAULT '0000',
  `Vacation_Balance` int(11) NOT NULL DEFAULT '0',
  `Leave_Permission_times` int(11) NOT NULL DEFAULT '0',
  `Notes` varchar(35) NOT NULL DEFAULT 'no thing set yet!',
  `Salary` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `username`, `password`, `type`, `Picture_ID`, `Name`, `Email`, `Phone`, `Employe_num`, `Vacation_Balance`, `Leave_Permission_times`, `Notes`, `Salary`) VALUES
(11, 'admin', '1234', 0, 'picture path', 'admin', 'admin@hotmail', '54564496', '12', 0, 0, '', ''),
(29, 'surya', 's', 0, 'Unknown', 'Surya', 'sur@', '3232323', '32323', 0, 0, '', ''),
(30, 'falbellaihi', '1234', 0, 'Unknown', 'Faisal Albellaihi', 'falbellaihi@hotmail.com', '5404295908', '32323', 0, 0, '', ''),
(33, 'BanderAlbellaihi', '1234', 0, 'Unknown', 'Bander Albellaihi', 'bn', '0555', '205', 20, 3, 'non', '14700'),
(34, 'ss', 'ss', 0, 'Unknown', 'ss', 'ss', 'ss', 'ss', 0, 0, 'ss', 'ss'),
(35, 'lklkl', 'kllk', 0, 'Unknown', 'klklkl', 'lklklkl', 'lklk', '3', 3, 0, 'dfew', '350');

-- --------------------------------------------------------

--
-- Table structure for table `worker`
--

CREATE TABLE `worker` (
  `ID` int(11) NOT NULL,
  `WorkerName` varchar(35) CHARACTER SET utf16 NOT NULL,
  `Nationality` varchar(35) CHARACTER SET utf16 NOT NULL,
  `ResidenceCardNumber` varchar(35) CHARACTER SET utf16 NOT NULL,
  `PassportNumber` varchar(35) CHARACTER SET utf16 NOT NULL,
  `BankAccountNumber` varchar(35) NOT NULL,
  `ResidenceCardExpiry` date NOT NULL,
  `PassportExpiry` date NOT NULL,
  `PassportPicture` varchar(35) NOT NULL,
  `ResidencyCardPicture` varchar(35) NOT NULL,
  `WorkerPicture` varchar(35) NOT NULL,
  `OtherAttachment` varchar(35) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `worker`
--

INSERT INTO `worker` (`ID`, `WorkerName`, `Nationality`, `ResidenceCardNumber`, `PassportNumber`, `BankAccountNumber`, `ResidenceCardExpiry`, `PassportExpiry`, `PassportPicture`, `ResidencyCardPicture`, `WorkerPicture`, `OtherAttachment`) VALUES
(1, 'sdsad', 'sdad', '4332432', '43423424', '2342342', '2016-09-13', '2016-09-20', 'Unknown', 'Unknown', 'Unknown', 'Unknown'),
(2, 'efefe', 'wdADaw', 'dwAWD', 'dwaWd', 'dwAWd', '2016-09-14', '2016-09-08', 'u', 'u', 'U', 'U'),
(3, '???', '????????', '1245454', '12021525', '154154512', '2016-09-21', '2016-09-22', 'Unknown', 'Unknown', 'Unknown', 'Unknown'),
(4, '???', '????????', '1245454', '12021525', '154154512', '2016-09-21', '2016-09-22', 'Unknown', 'Unknown', 'Unknown', 'Unknown'),
(5, 'sdsad', 'sdsad', '45345', '45353', '3545', '2016-09-11', '2016-09-19', 'Unknown', 'Unknown', 'Unknown', 'Unknown'),
(6, 'sdsad', 'sdsad', 'sdsad', 'sdsad', 'sdsad', '2016-09-12', '2016-09-22', 'Unknown', 'Unknown', 'Unknown', 'Unknown'),
(7, 'sdsad', 'sdsad', 'sdsad', 'sdsad', 'sdsad', '2016-09-12', '2016-09-22', 'Unknown', 'Unknown', 'Unknown', 'Unknown'),
(8, 'sdsad', 'sdsad', 'sdsad', 'sdsad', 'sdsad', '2016-09-22', '2016-09-14', 'Unknown', 'Unknown', 'Unknown', 'Unknown'),
(9, 'sdsad', 'sdsad', 'sdsad', 'sdsad', 'sdsad', '2016-09-08', '2016-09-15', 'Unknown', 'Unknown', 'Unknown', 'Unknown'),
(10, 'sdsad', 'sdsad', 'sdsad', 'sdsad', 'sdsad', '2016-09-12', '2016-09-15', 'Unknown', 'Unknown', 'Unknown', 'Unknown');

-- --------------------------------------------------------

--
-- Table structure for table `work_schedule`
--

CREATE TABLE `work_schedule` (
  `Time_in` date NOT NULL,
  `time_out` date NOT NULL,
  `Date` date NOT NULL,
  `Comments` text NOT NULL,
  `Task_ID` int(10) NOT NULL,
  `User_ID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `labels`
--
ALTER TABLE `labels`
  ADD PRIMARY KEY (`Plant_ID`);

--
-- Indexes for table `plants`
--
ALTER TABLE `plants`
  ADD PRIMARY KEY (`Plant_ID`),
  ADD KEY `Plant_ID` (`Plant_ID`),
  ADD KEY `User_ID` (`User_ID`);

--
-- Indexes for table `resignation_request`
--
ALTER TABLE `resignation_request`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `UserID` (`UserID`);

--
-- Indexes for table `tasks`
--
ALTER TABLE `tasks`
  ADD PRIMARY KEY (`Task_ID`),
  ADD KEY `Plant_ID` (`Plant_ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID` (`ID`),
  ADD KEY `ID_2` (`ID`);

--
-- Indexes for table `worker`
--
ALTER TABLE `worker`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `work_schedule`
--
ALTER TABLE `work_schedule`
  ADD PRIMARY KEY (`Task_ID`),
  ADD KEY `User_ID` (`User_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `plants`
--
ALTER TABLE `plants`
  MODIFY `Plant_ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `resignation_request`
--
ALTER TABLE `resignation_request`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `tasks`
--
ALTER TABLE `tasks`
  MODIFY `Task_ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
--
-- AUTO_INCREMENT for table `worker`
--
ALTER TABLE `worker`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `labels`
--
ALTER TABLE `labels`
  ADD CONSTRAINT `labels_ibfk_1` FOREIGN KEY (`Plant_ID`) REFERENCES `plants` (`Plant_ID`);

--
-- Constraints for table `plants`
--
ALTER TABLE `plants`
  ADD CONSTRAINT `plants_ibfk_1` FOREIGN KEY (`User_ID`) REFERENCES `users` (`ID`);

--
-- Constraints for table `resignation_request`
--
ALTER TABLE `resignation_request`
  ADD CONSTRAINT `resignation_request_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `users` (`ID`);

--
-- Constraints for table `tasks`
--
ALTER TABLE `tasks`
  ADD CONSTRAINT `tasks_ibfk_1` FOREIGN KEY (`Plant_ID`) REFERENCES `plants` (`Plant_ID`);

--
-- Constraints for table `work_schedule`
--
ALTER TABLE `work_schedule`
  ADD CONSTRAINT `work_schedule_ibfk_1` FOREIGN KEY (`Task_ID`) REFERENCES `tasks` (`Task_ID`),
  ADD CONSTRAINT `work_schedule_ibfk_2` FOREIGN KEY (`User_ID`) REFERENCES `users` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
