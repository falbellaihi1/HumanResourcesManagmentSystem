-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 02, 2017 at 10:53 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mits_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `brosteremp`
--

CREATE TABLE `brosteremp` (
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
-- Dumping data for table `brosteremp`
--

INSERT INTO `brosteremp` (`ID`, `username`, `password`, `type`, `Picture_ID`, `Name`, `Email`, `Phone`, `Employe_num`, `Vacation_Balance`, `Leave_Permission_times`, `Notes`, `Salary`) VALUES
(11, 'admin', '1234', 0, 'picture path', 'admin', 'admin@hotmail', '54564496', '12', 0, 0, '', ''),
(29, 'surya', 's', 0, 'Unknown', 'Surya', 'sur@', '3232323', '32323', 0, 0, '', ''),
(30, 'falbellaihi', '1234', 0, 'Unknown', 'Faisal Albellaihi', 'falbellaihi@hotmail.com', '5404295908', '32323', 0, 0, '', ''),
(33, 'BanderAlbellaihi', '1234', 0, 'Unknown', 'Bander Albellaihi', 'bn', '0555', '205', 20, 3, 'non', '14700'),
(34, 'ss', 'ss', 0, 'Unknown', 'ss', 'ss', 'ss', 'ss', 0, 0, 'ss', 'ss'),
(35, 'lklkl', 'kllk', 0, 'Unknown', 'klklkl', 'lklklkl', 'lklk', '3', 3, 0, 'dfew', '350');

-- --------------------------------------------------------

--
-- Table structure for table `bros_resignrequestarchive`
--

CREATE TABLE `bros_resignrequestarchive` (
  `ID` int(11) NOT NULL,
  `Username` varchar(35) NOT NULL,
  `DateofRequest` date NOT NULL,
  `Name of Employee` varchar(35) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `mafaheememp`
--

CREATE TABLE `mafaheememp` (
  `ID` int(10) NOT NULL,
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
-- Dumping data for table `mafaheememp`
--

INSERT INTO `mafaheememp` (`ID`, `type`, `Picture_ID`, `Name`, `Email`, `Phone`, `Employe_num`, `Vacation_Balance`, `Leave_Permission_times`, `Notes`, `Salary`) VALUES
(11, 0, 'picture path', 'admin', 'admin@hotmail', '54564496', '12', 0, 0, '', ''),
(29, 0, 'Unknown', 'Surya', 'sur@', '3232323', '32323', 0, 0, '', ''),
(30, 0, 'Unknown', 'Faisal Albellaihi', 'falbellaihi@hotmail.com', '5404295908', '32323', 0, 0, '', ''),
(33, 0, 'Unknown', 'Bander Albellaihi', 'bn', '0555', '205', 20, 3, 'non', '14700'),
(34, 0, 'Unknown', 'ss', 'ss', 'ss', 'ss', 0, 0, 'ss', 'ss'),
(35, 0, 'Unknown', 'klklkl', 'lklklkl', 'lklk', '3', 3, 0, 'dfew', '350');

-- --------------------------------------------------------

--
-- Table structure for table `maf_resignrequestarchive`
--

CREATE TABLE `maf_resignrequestarchive` (
  `ID` int(11) NOT NULL,
  `Username` varchar(35) NOT NULL,
  `DateofRequest` date NOT NULL,
  `Name of Employee` varchar(35) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE `messages` (
  `ID` int(11) NOT NULL,
  `NotificationMessage2` varchar(200) NOT NULL,
  `NotificationMessage3` varchar(200) NOT NULL,
  `NotificationMessage4` varchar(200) NOT NULL,
  `UserID` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `messages`
--

INSERT INTO `messages` (`ID`, `NotificationMessage2`, `NotificationMessage3`, `NotificationMessage4`, `UserID`) VALUES
(3, 'You got new task to do 22  has applied for resign his notes are  AWEDQWADE , please follow up with his request #14', 'You got new task to do 22  has applied for resign his notes are  AWEDQWADE , please follow up with his request #14', 'You got new task to do 22  has applied for resign his notes are  AWEDQWADE , please follow up with his request #14', 0),
(4, 'You got new task to do lkl  has applied for resign his notes are  klkl , please follow up with his request #15', 'You got new task to do lkl  has applied for resign his notes are  klkl , please follow up with his request #15', 'You got new task to do lkl  has applied for resign his notes are  klkl , please follow up with his request #15', 0),
(5, 'You got new task to do 22  has applied for resign his notes are  AWEDQWADE , please follow up with his request #14', 'You got new task to do 22  has applied for resign his notes are  AWEDQWADE , please follow up with his request #14', 'You got new task to do 22  has applied for resign his notes are  AWEDQWADE , please follow up with his request #14', 0);

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

-- --------------------------------------------------------

--
-- Table structure for table `saajemp`
--

CREATE TABLE `saajemp` (
  `ID` int(10) NOT NULL,
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
-- Dumping data for table `saajemp`
--

INSERT INTO `saajemp` (`ID`, `type`, `Picture_ID`, `Name`, `Email`, `Phone`, `Employe_num`, `Vacation_Balance`, `Leave_Permission_times`, `Notes`, `Salary`) VALUES
(11, 0, 'picture path', 'admin', 'admin@hotmail', '54564496', '12', 0, 0, '', ''),
(29, 0, 'Unknown', 'Surya', 'sur@', '3232323', '32323', 0, 0, '', ''),
(30, 0, 'Unknown', 'Faisal Albellaihi', 'falbellaihi@hotmail.com', '5404295908', '32323', 0, 0, '', ''),
(33, 0, 'Unknown', 'Bander Albellaihi', 'bn', '0555', '205', 20, 3, 'non', '14700'),
(34, 0, 'Unknown', 'ss', 'ss', 'ss', 'ss', 0, 0, 'ss', 'ss'),
(35, 0, 'Unknown', 'klklkl', 'lklklkl', 'lklk', '3', 3, 0, 'dfew', '350');

-- --------------------------------------------------------

--
-- Table structure for table `sadahemp`
--

CREATE TABLE `sadahemp` (
  `ID` int(10) NOT NULL,
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
-- Dumping data for table `sadahemp`
--

INSERT INTO `sadahemp` (`ID`, `type`, `Picture_ID`, `Name`, `Email`, `Phone`, `Employe_num`, `Vacation_Balance`, `Leave_Permission_times`, `Notes`, `Salary`) VALUES
(11, 0, 'picture path', 'admin', 'admin@hotmail', '54564496', '12', 0, 0, '', ''),
(29, 0, 'Unknown', 'Surya', 'sur@', '3232323', '32323', 0, 0, '', ''),
(30, 0, 'Unknown', 'Faisal Albellaihi', 'falbellaihi@hotmail.com', '5404295908', '32323', 0, 0, '', ''),
(33, 0, 'Unknown', 'Bander Albellaihi', 'bn', '0555', '205', 20, 3, 'non', '14700'),
(34, 0, 'Unknown', 'ss', 'ss', 'ss', 'ss', 0, 0, 'ss', 'ss'),
(35, 0, 'Unknown', 'klklkl', 'lklklkl', 'lklk', '3', 3, 0, 'dfew', '350');

-- --------------------------------------------------------

--
-- Table structure for table `sad_resignrequestarchive`
--

CREATE TABLE `sad_resignrequestarchive` (
  `ID` int(11) NOT NULL,
  `Username` varchar(35) NOT NULL,
  `DateofRequest` date NOT NULL,
  `Name of Employee` varchar(35) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `saj_resignrequestarchive`
--

CREATE TABLE `saj_resignrequestarchive` (
  `ID` int(11) NOT NULL,
  `Username` varchar(35) NOT NULL,
  `DateofRequest` date NOT NULL,
  `Name of Employee` varchar(35) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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
  `Employe_num` varchar(35) NOT NULL DEFAULT '0000'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `username`, `password`, `type`, `Picture_ID`, `Name`, `Email`, `Phone`, `Employe_num`) VALUES
(11, 'admin', '1234', 0, 'picture path', 'admin', 'dddd', '333333', '12'),
(29, 'surya', 's', 0, 'Unknown', 'Surya', 'sur@', '3232323', '32323'),
(30, 'falbellaihi', '1234', 0, 'Unknown', 'Faisal Albellaihi', 'falbellaihi@hotmail.com', '5404295908', '32323'),
(33, 'BanderAlbellaihi', '1234', 0, 'Unknown', 'Bander Albellaihi', 'bn', '0555', '205'),
(34, 'ss', 'ss', 0, 'Unknown', 'ss', 'ss', 'ss', 'ss'),
(35, 'lklkl', 'kllk', 0, 'Unknown', 'klklkl', 'lklklkl', 'lklk', '3');

-- --------------------------------------------------------

--
-- Table structure for table `worker`
--

CREATE TABLE `worker` (
  `ID` int(11) NOT NULL,
  `WorkerName` varchar(35) NOT NULL,
  `Nationality` varchar(35) NOT NULL,
  `ResidenceCardNumber` varchar(35) NOT NULL,
  `PassportNumber` varchar(35) NOT NULL,
  `BankAccountNumber` varchar(35) CHARACTER SET latin1 NOT NULL,
  `ResidenceCardExpiry` date NOT NULL,
  `PassportExpiry` date NOT NULL,
  `PassportPicture` varchar(35) CHARACTER SET latin1 NOT NULL,
  `ResidencyCardPicture` varchar(35) CHARACTER SET latin1 NOT NULL,
  `WorkerPicture` varchar(35) CHARACTER SET latin1 NOT NULL,
  `OtherAttachment` varchar(35) CHARACTER SET latin1 NOT NULL,
  `EnteryIDNumber` varchar(35) DEFAULT NULL,
  `InsuranceNumber` varchar(35) DEFAULT NULL,
  `EnteryDate` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf16;

--
-- Dumping data for table `worker`
--

INSERT INTO `worker` (`ID`, `WorkerName`, `Nationality`, `ResidenceCardNumber`, `PassportNumber`, `BankAccountNumber`, `ResidenceCardExpiry`, `PassportExpiry`, `PassportPicture`, `ResidencyCardPicture`, `WorkerPicture`, `OtherAttachment`, `EnteryIDNumber`, `InsuranceNumber`, `EnteryDate`) VALUES
(16, 'sdlk', 'lk;lk', ';lk;l', 'kl;k', 'l;l', '2016-10-05', '2016-10-12', 'Unknown', 'Unknown', 'Unknown', 'Unknown', 'kl;', NULL, NULL),
(12, 'sdas', 'asda', 'dad', 'add', 'adad', '2016-10-04', '2016-10-19', 'dsdsd', 'Unknowndsd', 'Unknowndssd', 'Unkdssdnown', 'sdsdsd', 'sddsd', NULL),
(13, 'sdas', 'asda', 'dad', 'add', 'adad', '2016-10-04', '2016-10-19', 'Unknowns', 'Unknownsdssd', 'Unknownsdsd', 'Unknowndssd', 'sdsd', 'dsds', NULL),
(14, 'sdas', 'asda', 'dad', 'add', 'adad', '2016-10-04', '2016-10-19', 'Unknownsdsd', 'Unknownsdd', 'Unknowndsd', 'Unknowndsd', 'sdsds', 'sdsds', NULL),
(15, 'sdas', 'asda', 'dad', 'add', 'adad', '2016-10-04', '2016-10-19', 'Unknowndsdsd', 'Unknownsdsd', 'Udssdnknown', 'sdsdsds', 'sadad', 'sdsd', NULL);

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

-- --------------------------------------------------------

--
-- Table structure for table `ورقة1`
--

CREATE TABLE `ورقة1` (
  `الاسم` varchar(24) DEFAULT NULL,
  `الرقم الوظيفي` int(4) DEFAULT NULL,
  `المسمى الوظيفي` varchar(22) DEFAULT NULL,
  `رقم الهوية` bigint(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ورقة1`
--

INSERT INTO `ورقة1` (`الاسم`, `الرقم الوظيفي`, `المسمى الوظيفي`, `رقم الهوية`) VALUES
('بندر بن عبدالله البليهي', 1000, 'مدير الموارد البشرية', 1077878534),
('زايد الدوسري', 1004, 'ممثل علاقات حكومية', 1033408673),
('محمد عبدالله التميمي', 1002, 'كاتب اداري عام', 1080199068),
('محمد الفراج', 1003, 'مدير اداري', 1069059358),
('سريع عبدالعزيز التويم', 1001, 'مدير شؤون الموظفين', 1072558123),
('فيصل حنتول', 1005, 'ضابط علاقات عامة', 1067742153),
('سليمان راشد الغنيم', 1006, 'مدير العلاقات الحكومية', 1032440081),
('عبدالله الدعيجي', 1007, 'ممثل علاقات حكومية', 1079247001),
('محمد راشد الغنيم', 1008, 'ممثل علاقات حكومية', 1063926206),
('خالد هوساوي', 1009, 'ممثل علاقات حكومية', 1014245425),
('احمد السليمان', 1010, 'ممثل علاقات حكومية', 1057313973),
('عبدالله بن محمد بن ثنيان', 1011, 'كاتب اداري عام', 1072990102),
('علي ابراهيم', 1012, 'محاسب', 2414693701),
('محمد علي القحطاني', 1013, 'كاتب اداري', 1067225175),
('عبدالعزيز المقرن', 1014, 'كاتب اداري عام', 1079920078),
('محمد السلوم', 1015, 'كاتب اداري', 1087028609),
('حسام عبيد', 1016, 'محاسب', 2404215200),
('ماجد النويصر', 1017, 'ممثل علاقات حكومية', 1058141357),
('مهند البليهي', 1018, 'كاتب اداري عام', 1084669215),
('كريم محمد', 1019, 'كاتب ادخال بيانات', 2407557699),
('احمد عسيري', 1020, 'كاتب اداري عام', 1058449321),
('حسام الفراج', 1021, 'كاتب اداري', 1085142261),
('عبدالله الطنطاوي', 1022, 'مدير المشاريع', 2032062685),
('سلمان المطيري', 1024, 'كاتب ادخال بيانات', 1074177351),
('محمود حسيب', 1025, 'محاسب', 2380577946),
('غازي الدوسري', 1026, 'ممثل علاقات حكومية', 1070868235),
('عبدالعزيز الخثعمي', 1028, 'مدير اداري', 1073998856),
('فيصل عبدالله البليهي', 1023, 'مبرمج حاسب الي', 1077878542),
('محمد سكر', 1027, 'التشغيل والصيانة', 2207434867),
('عمر الفراج', 2517, 'ضابط علاقات عامة', 1076953494),
('متعب عبدالمحسن القحطاني', 1029, 'كاتب اداري عام', 1083981488),
('سلمان يوسف البليهي', 1031, 'كاتب اجور', 1087520209);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `brosteremp`
--
ALTER TABLE `brosteremp`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID` (`ID`),
  ADD KEY `ID_2` (`ID`);

--
-- Indexes for table `bros_resignrequestarchive`
--
ALTER TABLE `bros_resignrequestarchive`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `mafaheememp`
--
ALTER TABLE `mafaheememp`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID` (`ID`),
  ADD KEY `ID_2` (`ID`);

--
-- Indexes for table `maf_resignrequestarchive`
--
ALTER TABLE `maf_resignrequestarchive`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `resignation_request`
--
ALTER TABLE `resignation_request`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `UserID` (`UserID`);

--
-- Indexes for table `saajemp`
--
ALTER TABLE `saajemp`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID` (`ID`),
  ADD KEY `ID_2` (`ID`);

--
-- Indexes for table `sadahemp`
--
ALTER TABLE `sadahemp`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID` (`ID`),
  ADD KEY `ID_2` (`ID`);

--
-- Indexes for table `sad_resignrequestarchive`
--
ALTER TABLE `sad_resignrequestarchive`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `saj_resignrequestarchive`
--
ALTER TABLE `saj_resignrequestarchive`
  ADD PRIMARY KEY (`ID`);

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
-- AUTO_INCREMENT for table `brosteremp`
--
ALTER TABLE `brosteremp`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
--
-- AUTO_INCREMENT for table `bros_resignrequestarchive`
--
ALTER TABLE `bros_resignrequestarchive`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `mafaheememp`
--
ALTER TABLE `mafaheememp`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
--
-- AUTO_INCREMENT for table `maf_resignrequestarchive`
--
ALTER TABLE `maf_resignrequestarchive`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `messages`
--
ALTER TABLE `messages`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `resignation_request`
--
ALTER TABLE `resignation_request`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `saajemp`
--
ALTER TABLE `saajemp`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
--
-- AUTO_INCREMENT for table `sadahemp`
--
ALTER TABLE `sadahemp`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
--
-- AUTO_INCREMENT for table `sad_resignrequestarchive`
--
ALTER TABLE `sad_resignrequestarchive`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `saj_resignrequestarchive`
--
ALTER TABLE `saj_resignrequestarchive`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
--
-- AUTO_INCREMENT for table `worker`
--
ALTER TABLE `worker`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `resignation_request`
--
ALTER TABLE `resignation_request`
  ADD CONSTRAINT `resignation_request_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `users` (`ID`);

--
-- Constraints for table `work_schedule`
--
ALTER TABLE `work_schedule`
  ADD CONSTRAINT `work_schedule_ibfk_1` FOREIGN KEY (`Task_ID`) REFERENCES `tasks` (`Task_ID`),
  ADD CONSTRAINT `work_schedule_ibfk_2` FOREIGN KEY (`User_ID`) REFERENCES `users` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
