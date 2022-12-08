-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Dec 08, 2022 at 09:35 AM
-- Server version: 5.7.34
-- PHP Version: 7.4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `catering`
--

-- --------------------------------------------------------

--
-- Table structure for table `Events`
--

CREATE TABLE `Events` (
  `id` int(11) NOT NULL,
  `name` varchar(128) DEFAULT NULL,
  `date_start` date DEFAULT NULL,
  `date_end` date DEFAULT NULL,
  `expected_participants` int(11) DEFAULT NULL,
  `organizer_id` int(11) NOT NULL,
  `chef_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Events`
--

INSERT INTO `Events` (`id`, `name`, `date_start`, `date_end`, `expected_participants`, `organizer_id`, `chef_id`) VALUES
(1, 'Convegno Agile Community', '2020-09-25', '2020-09-25', 100, 2, 2),
(2, 'Compleanno di Manuela', '2020-08-13', '2020-08-13', 25, 2, 2),
(3, 'Fiera del Sedano Rapa', '2020-10-02', '2020-10-04', 400, 1, 4);

-- --------------------------------------------------------

--
-- Table structure for table `KitchenSheets`
--

CREATE TABLE `KitchenSheets` (
  `id` int(11) NOT NULL,
  `title` char(64) DEFAULT NULL,
  `service_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `KitchenSheets`
--

INSERT INTO `KitchenSheets` (`id`, `title`, `service_id`) VALUES
(56, 'Primo foglio di prova', 1);

-- --------------------------------------------------------

--
-- Table structure for table `KitchenTasks`
--

CREATE TABLE `KitchenTasks` (
  `id` int(11) NOT NULL,
  `position` int(11) DEFAULT NULL,
  `minutes` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `completed` int(11) DEFAULT NULL,
  `shift_when` char(64) DEFAULT NULL,
  `cook_id` int(11) DEFAULT NULL,
  `kitchen_sheet_id` int(11) DEFAULT NULL,
  `preparation_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `KitchenTasks`
--

INSERT INTO `KitchenTasks` (`id`, `position`, `minutes`, `quantity`, `completed`, `shift_when`, `cook_id`, `kitchen_sheet_id`, `preparation_id`) VALUES
(382, 0, 50, 6, 1, 'Giovedi ore 16:00', 4, 23, 3),
(383, 1, 50, 6, 0, 'Giovedi ore 16:00', NULL, 23, 3),
(384, 2, 0, 0, 0, 'Giovedi ore 16:00', NULL, 23, 3),
(385, 3, NULL, NULL, 0, NULL, NULL, 23, 20),
(386, 4, NULL, NULL, 0, NULL, NULL, 23, 20),
(387, 5, NULL, NULL, 0, NULL, NULL, 23, 8),
(388, 6, NULL, NULL, 0, NULL, NULL, 23, 19),
(389, 7, NULL, NULL, 0, NULL, NULL, 23, 19),
(392, 8, NULL, NULL, 0, NULL, NULL, 23, 15),
(393, 0, NULL, NULL, 0, NULL, NULL, 24, 0),
(394, 1, NULL, NULL, 0, NULL, NULL, 24, 0),
(395, 2, NULL, NULL, 0, NULL, NULL, 24, 0),
(396, 3, NULL, NULL, 0, NULL, NULL, 24, 0),
(397, 4, NULL, NULL, 0, NULL, NULL, 24, 0),
(398, 5, NULL, NULL, 0, NULL, NULL, 24, 0),
(399, 6, NULL, NULL, 0, NULL, NULL, 24, 0),
(400, 7, NULL, NULL, 0, NULL, NULL, 24, 0),
(401, 0, 50, 6, 1, 'Giovedi ore 16:00', 4, 25, 3),
(402, 1, 50, 6, 0, 'Giovedi ore 16:00', NULL, 25, 3),
(403, 2, 0, 0, 0, 'Giovedi ore 16:00', NULL, 25, 3),
(404, 3, NULL, NULL, 0, NULL, NULL, 25, 20),
(405, 4, NULL, NULL, 0, NULL, NULL, 25, 20),
(406, 5, NULL, NULL, 0, NULL, NULL, 25, 8),
(407, 6, NULL, NULL, 0, NULL, NULL, 25, 19),
(408, 7, NULL, NULL, 0, NULL, NULL, 25, 19),
(411, 8, NULL, NULL, 0, NULL, NULL, 25, 15),
(412, 0, 50, 6, 1, 'Giovedi ore 16:00', 4, 26, 3),
(413, 1, 50, 6, 0, 'Giovedi ore 16:00', NULL, 26, 3),
(414, 2, 0, 0, 0, 'Giovedi ore 16:00', NULL, 26, 3),
(415, 3, NULL, NULL, 0, NULL, NULL, 26, 20),
(416, 4, NULL, NULL, 0, NULL, NULL, 26, 20),
(417, 5, NULL, NULL, 0, NULL, NULL, 26, 8),
(418, 6, NULL, NULL, 0, NULL, NULL, 26, 19),
(419, 7, NULL, NULL, 0, NULL, NULL, 26, 19),
(422, 8, NULL, NULL, 0, NULL, NULL, 26, 15),
(423, 0, 50, 6, 1, 'Giovedi ore 16:00', 4, 27, 3),
(424, 1, 50, 6, 0, 'Giovedi ore 16:00', NULL, 27, 3),
(425, 2, 0, 0, 0, 'Giovedi ore 16:00', NULL, 27, 3),
(426, 3, NULL, NULL, 0, NULL, NULL, 27, 20),
(427, 4, NULL, NULL, 0, NULL, NULL, 27, 20),
(428, 5, NULL, NULL, 0, NULL, NULL, 27, 8),
(429, 6, NULL, NULL, 0, NULL, NULL, 27, 19),
(430, 7, NULL, NULL, 0, NULL, NULL, 27, 19),
(433, 8, NULL, NULL, 0, NULL, NULL, 27, 15),
(434, 0, 50, 6, 1, 'Giovedi ore 16:00', 4, 28, 3),
(435, 1, 50, 6, 0, 'Giovedi ore 16:00', NULL, 28, 3),
(436, 2, 0, 0, 0, 'Giovedi ore 16:00', NULL, 28, 3),
(437, 3, NULL, NULL, 0, NULL, NULL, 28, 20),
(438, 4, NULL, NULL, 0, NULL, NULL, 28, 20),
(439, 5, NULL, NULL, 0, NULL, NULL, 28, 8),
(440, 6, NULL, NULL, 0, NULL, NULL, 28, 19),
(441, 7, NULL, NULL, 0, NULL, NULL, 28, 19),
(444, 8, NULL, NULL, 0, NULL, NULL, 28, 15),
(445, 0, 50, 6, 1, 'Giovedi ore 16:00', 4, 29, 3),
(446, 1, 50, 6, 0, 'Giovedi ore 16:00', NULL, 29, 3),
(447, 2, 0, 0, 0, 'Giovedi ore 16:00', NULL, 29, 3),
(448, 3, NULL, NULL, 0, NULL, NULL, 29, 20),
(449, 4, NULL, NULL, 0, NULL, NULL, 29, 20),
(450, 5, NULL, NULL, 0, NULL, NULL, 29, 8),
(451, 6, NULL, NULL, 0, NULL, NULL, 29, 19),
(452, 7, NULL, NULL, 0, NULL, NULL, 29, 19),
(454, 8, NULL, NULL, 0, NULL, NULL, 29, 14),
(456, 0, NULL, NULL, 0, NULL, NULL, 30, 3),
(457, 1, NULL, NULL, 0, NULL, NULL, 30, 3),
(458, 2, NULL, NULL, 0, NULL, NULL, 30, 3),
(459, 3, NULL, NULL, 0, NULL, NULL, 30, 20),
(460, 4, NULL, NULL, 0, NULL, NULL, 30, 20),
(461, 5, NULL, NULL, 0, NULL, NULL, 30, 8),
(462, 6, NULL, NULL, 0, NULL, NULL, 30, 19),
(463, 7, NULL, NULL, 0, NULL, NULL, 30, 19),
(465, 9, NULL, NULL, 0, NULL, NULL, 30, 14),
(467, 5, NULL, NULL, 0, NULL, NULL, 31, 3),
(468, 0, NULL, NULL, 0, NULL, NULL, 31, 3),
(469, 1, NULL, NULL, 0, NULL, NULL, 31, 3),
(470, 2, NULL, NULL, 0, NULL, NULL, 31, 20),
(471, 3, NULL, NULL, 0, NULL, NULL, 31, 20),
(472, 4, NULL, NULL, 0, NULL, NULL, 31, 8),
(473, 6, NULL, NULL, 0, NULL, NULL, 31, 19),
(474, 7, NULL, NULL, 0, NULL, NULL, 31, 19),
(476, 8, NULL, NULL, 0, NULL, NULL, 31, 14),
(478, 5, NULL, NULL, 0, NULL, NULL, 32, 3),
(479, 0, NULL, NULL, 0, NULL, NULL, 32, 3),
(480, 1, NULL, NULL, 0, NULL, NULL, 32, 3),
(481, 2, NULL, NULL, 0, NULL, NULL, 32, 20),
(482, 3, NULL, NULL, 0, NULL, NULL, 32, 20),
(483, 4, NULL, NULL, 0, NULL, NULL, 32, 8),
(484, 6, NULL, NULL, 0, NULL, NULL, 32, 19),
(485, 7, NULL, NULL, 0, NULL, NULL, 32, 19),
(487, 8, NULL, NULL, 0, NULL, NULL, 32, 14),
(489, 5, NULL, NULL, 0, NULL, NULL, 33, 3),
(490, 0, NULL, NULL, 0, NULL, NULL, 33, 3),
(491, 1, NULL, NULL, 0, NULL, NULL, 33, 3),
(492, 2, NULL, NULL, 0, NULL, NULL, 33, 20),
(493, 3, NULL, NULL, 0, NULL, NULL, 33, 20),
(494, 4, NULL, NULL, 0, NULL, NULL, 33, 8),
(495, 6, NULL, NULL, 0, NULL, NULL, 33, 19),
(496, 7, NULL, NULL, 0, NULL, NULL, 33, 19),
(498, 8, NULL, NULL, 0, NULL, NULL, 33, 14),
(500, 5, NULL, NULL, 0, NULL, NULL, 34, 3),
(501, 0, 50, 6, 0, 'Giovedi ore 16:00', 4, 34, 3),
(502, 1, NULL, NULL, 0, NULL, NULL, 34, 3),
(503, 2, NULL, NULL, 0, NULL, NULL, 34, 20),
(504, 3, NULL, NULL, 0, NULL, NULL, 34, 20),
(505, 4, NULL, NULL, 0, NULL, NULL, 34, 8),
(506, 6, NULL, NULL, 0, NULL, NULL, 34, 19),
(507, 7, NULL, NULL, 0, NULL, NULL, 34, 19),
(509, 8, NULL, NULL, 0, NULL, NULL, 34, 14),
(511, 5, NULL, NULL, 0, NULL, NULL, 35, 3),
(512, 0, 50, 6, 0, 'Giovedi ore 16:00', 4, 35, 3),
(513, 1, NULL, NULL, 0, NULL, NULL, 35, 3),
(514, 2, NULL, NULL, 0, NULL, NULL, 35, 20),
(515, 3, NULL, NULL, 0, NULL, NULL, 35, 20),
(516, 4, NULL, NULL, 0, NULL, NULL, 35, 8),
(517, 6, NULL, NULL, 0, NULL, NULL, 35, 19),
(518, 7, NULL, NULL, 0, NULL, NULL, 35, 19),
(520, 8, NULL, NULL, 0, NULL, NULL, 35, 14),
(522, 5, NULL, NULL, 0, NULL, NULL, 36, 3),
(523, 0, NULL, NULL, 0, NULL, NULL, 36, 3),
(524, 1, NULL, NULL, 0, NULL, NULL, 36, 3),
(525, 2, NULL, NULL, 0, NULL, NULL, 36, 20),
(526, 3, NULL, NULL, 0, NULL, NULL, 36, 20),
(527, 4, NULL, NULL, 0, NULL, NULL, 36, 8),
(528, 6, NULL, NULL, 0, NULL, NULL, 36, 19),
(529, 7, NULL, NULL, 0, NULL, NULL, 36, 19),
(531, 8, NULL, NULL, 0, NULL, NULL, 36, 14),
(533, 5, NULL, NULL, 0, NULL, NULL, 37, 3),
(534, 0, NULL, NULL, 0, NULL, NULL, 37, 3),
(535, 1, NULL, NULL, 0, NULL, NULL, 37, 3),
(536, 2, NULL, NULL, 0, NULL, NULL, 37, 20),
(537, 3, NULL, NULL, 0, NULL, NULL, 37, 20),
(538, 4, NULL, NULL, 0, NULL, NULL, 37, 8),
(539, 6, NULL, NULL, 0, NULL, NULL, 37, 19),
(540, 7, NULL, NULL, 0, NULL, NULL, 37, 19),
(542, 8, NULL, NULL, 0, NULL, NULL, 37, 14),
(544, 5, NULL, NULL, 0, NULL, NULL, 38, 3),
(545, 0, 50, 6, 1, 'Giovedi ore 16:00', 4, 38, 3),
(546, 1, 50, 6, 0, 'Giovedi ore 16:00', NULL, 38, 3),
(547, 2, 0, 0, 0, 'Giovedi ore 16:00', NULL, 38, 20),
(548, 3, NULL, NULL, 0, NULL, NULL, 38, 20),
(549, 4, NULL, NULL, 0, NULL, NULL, 38, 8),
(550, 6, NULL, NULL, 0, NULL, NULL, 38, 19),
(551, 7, NULL, NULL, 0, NULL, NULL, 38, 19),
(553, 8, NULL, NULL, 0, NULL, NULL, 38, 14),
(555, 5, NULL, NULL, 0, NULL, NULL, 39, 3),
(556, 0, 50, 6, 1, 'Giovedi ore 16:00', 4, 39, 3),
(557, 1, 50, 6, 0, 'Giovedi ore 16:00', NULL, 39, 3),
(558, 2, 0, 0, 0, 'Giovedi ore 16:00', NULL, 39, 20),
(559, 3, NULL, NULL, 0, NULL, NULL, 39, 20),
(560, 4, NULL, NULL, 0, NULL, NULL, 39, 8),
(561, 6, NULL, NULL, 0, NULL, NULL, 39, 19),
(562, 7, NULL, NULL, 0, NULL, NULL, 39, 19),
(564, 8, NULL, NULL, 0, NULL, NULL, 39, 14),
(566, 5, NULL, NULL, 0, NULL, NULL, 40, 3),
(567, 0, 50, 6, 1, 'Giovedi ore 16:00', 4, 40, 3),
(568, 1, 50, 6, 0, 'Giovedi ore 16:00', NULL, 40, 3),
(569, 2, 0, 0, 0, 'Giovedi ore 16:00', NULL, 40, 20),
(570, 3, NULL, NULL, 0, NULL, NULL, 40, 20),
(571, 4, NULL, NULL, 0, NULL, NULL, 40, 8),
(572, 6, NULL, NULL, 0, NULL, NULL, 40, 19),
(573, 7, NULL, NULL, 0, NULL, NULL, 40, 19),
(575, 8, NULL, NULL, 0, NULL, NULL, 40, 14),
(577, 0, NULL, NULL, 0, NULL, NULL, 41, 3),
(578, 1, NULL, NULL, 0, NULL, NULL, 41, 3),
(579, 2, NULL, NULL, 0, NULL, NULL, 41, 3),
(580, 3, NULL, NULL, 0, NULL, NULL, 41, 20),
(581, 4, NULL, NULL, 0, NULL, NULL, 41, 20),
(582, 5, NULL, NULL, 0, NULL, NULL, 41, 8),
(583, 6, NULL, NULL, 0, NULL, NULL, 41, 19),
(584, 7, NULL, NULL, 0, NULL, NULL, 41, 19),
(587, 10, NULL, NULL, 0, NULL, NULL, 41, 15),
(599, 0, NULL, NULL, 0, NULL, NULL, 42, 3),
(600, 1, NULL, NULL, 0, NULL, NULL, 42, 3),
(601, 2, NULL, NULL, 0, NULL, NULL, 42, 3),
(602, 3, NULL, NULL, 0, NULL, NULL, 42, 20),
(603, 4, NULL, NULL, 0, NULL, NULL, 42, 20),
(604, 5, NULL, NULL, 0, NULL, NULL, 42, 8),
(605, 6, NULL, NULL, 0, NULL, NULL, 42, 19),
(606, 7, NULL, NULL, 0, NULL, NULL, 42, 19),
(607, 8, NULL, NULL, 0, NULL, NULL, 42, 15),
(608, 9, NULL, NULL, 0, NULL, NULL, 42, 3),
(609, 10, NULL, NULL, 0, NULL, NULL, 42, 3),
(610, 11, NULL, NULL, 0, NULL, NULL, 42, 3),
(611, 12, NULL, NULL, 0, NULL, NULL, 42, 20),
(612, 13, NULL, NULL, 0, NULL, NULL, 42, 20),
(613, 14, NULL, NULL, 0, NULL, NULL, 42, 8),
(614, 15, NULL, NULL, 0, NULL, NULL, 42, 19),
(615, 16, NULL, NULL, 0, NULL, NULL, 42, 19),
(627, 0, NULL, NULL, 0, NULL, NULL, 43, 3),
(628, 1, NULL, NULL, 0, NULL, NULL, 43, 3),
(629, 2, NULL, NULL, 0, NULL, NULL, 43, 3),
(630, 3, NULL, NULL, 0, NULL, NULL, 43, 20),
(631, 4, NULL, NULL, 0, NULL, NULL, 43, 20),
(632, 5, NULL, NULL, 0, NULL, NULL, 43, 8),
(633, 6, NULL, NULL, 0, NULL, NULL, 43, 19),
(634, 7, NULL, NULL, 0, NULL, NULL, 43, 19),
(635, 8, NULL, NULL, 0, NULL, NULL, 43, 14),
(636, 9, NULL, NULL, 0, NULL, NULL, 43, 3),
(637, 10, NULL, NULL, 0, NULL, NULL, 43, 3),
(638, 11, NULL, NULL, 0, NULL, NULL, 43, 3),
(639, 12, NULL, NULL, 0, NULL, NULL, 43, 20),
(640, 13, NULL, NULL, 0, NULL, NULL, 43, 20),
(641, 14, NULL, NULL, 0, NULL, NULL, 43, 8),
(642, 15, NULL, NULL, 0, NULL, NULL, 43, 19),
(643, 16, NULL, NULL, 0, NULL, NULL, 43, 19),
(644, 0, NULL, NULL, 0, NULL, NULL, 44, 3),
(645, 1, NULL, NULL, 0, NULL, NULL, 44, 3),
(646, 2, NULL, NULL, 0, NULL, NULL, 44, 3),
(647, 3, NULL, NULL, 0, NULL, NULL, 44, 20),
(648, 4, NULL, NULL, 0, NULL, NULL, 44, 20),
(649, 5, NULL, NULL, 0, NULL, NULL, 44, 8),
(650, 6, NULL, NULL, 0, NULL, NULL, 44, 19),
(651, 7, NULL, NULL, 0, NULL, NULL, 44, 19),
(653, 9, NULL, NULL, 0, NULL, NULL, 44, 14),
(655, 0, NULL, NULL, 0, NULL, NULL, 44, 3),
(656, 1, NULL, NULL, 0, NULL, NULL, 44, 3),
(657, 2, NULL, NULL, 0, NULL, NULL, 44, 3),
(658, 3, NULL, NULL, 0, NULL, NULL, 44, 20),
(659, 4, NULL, NULL, 0, NULL, NULL, 44, 20),
(660, 5, NULL, NULL, 0, NULL, NULL, 44, 8),
(661, 6, NULL, NULL, 0, NULL, NULL, 44, 19),
(662, 7, NULL, NULL, 0, NULL, NULL, 44, 19),
(663, 0, NULL, NULL, 0, NULL, NULL, 45, 3),
(664, 1, NULL, NULL, 0, NULL, NULL, 45, 3),
(665, 2, NULL, NULL, 0, NULL, NULL, 45, 3),
(666, 3, NULL, NULL, 0, NULL, NULL, 45, 20),
(667, 4, NULL, NULL, 0, NULL, NULL, 45, 20),
(668, 5, NULL, NULL, 0, NULL, NULL, 45, 8),
(669, 6, NULL, NULL, 0, NULL, NULL, 45, 19),
(670, 7, NULL, NULL, 0, NULL, NULL, 45, 19),
(671, 5, NULL, NULL, 0, NULL, NULL, 46, 3),
(672, 0, 50, 6, 1, 'Giovedi ore 16:00', 4, 46, 3),
(673, 1, 50, 6, 0, 'Giovedi ore 16:00', NULL, 46, 3),
(674, 2, 0, 0, 0, 'Giovedi ore 16:00', NULL, 46, 20),
(675, 3, NULL, NULL, 0, NULL, NULL, 46, 20),
(676, 4, NULL, NULL, 0, NULL, NULL, 46, 8),
(677, 6, NULL, NULL, 0, NULL, NULL, 46, 19),
(678, 7, NULL, NULL, 0, NULL, NULL, 46, 19),
(680, 8, NULL, NULL, 0, NULL, NULL, 46, 14),
(682, 0, NULL, NULL, 0, NULL, NULL, 48, 3),
(683, 1, NULL, NULL, 0, NULL, NULL, 48, 3),
(684, 2, NULL, NULL, 0, NULL, NULL, 48, 3),
(685, 3, NULL, NULL, 0, NULL, NULL, 48, 20),
(686, 4, NULL, NULL, 0, NULL, NULL, 48, 20),
(687, 5, NULL, NULL, 0, NULL, NULL, 48, 8),
(688, 6, NULL, NULL, 0, NULL, NULL, 48, 19),
(689, 7, NULL, NULL, 0, NULL, NULL, 48, 19),
(690, 2, NULL, NULL, 0, NULL, NULL, 49, 3),
(691, 0, NULL, NULL, 0, NULL, NULL, 49, 3),
(692, 1, NULL, NULL, 0, NULL, NULL, 49, 3),
(693, 3, NULL, NULL, 0, NULL, NULL, 49, 20),
(694, 4, NULL, NULL, 0, NULL, NULL, 49, 20),
(695, 5, NULL, NULL, 0, NULL, NULL, 49, 8),
(696, 6, NULL, NULL, 0, NULL, NULL, 49, 19),
(697, 7, NULL, NULL, 0, NULL, NULL, 49, 19),
(698, 8, NULL, NULL, 0, NULL, NULL, 49, 0),
(699, 9, NULL, NULL, 0, NULL, NULL, 49, 0),
(700, 10, NULL, NULL, 0, NULL, NULL, 49, 0),
(701, 11, NULL, NULL, 0, NULL, NULL, 49, 0),
(703, 2, NULL, NULL, 0, NULL, NULL, 50, 3),
(704, 0, NULL, NULL, 0, NULL, NULL, 50, 3),
(705, 1, NULL, NULL, 0, NULL, NULL, 50, 3),
(706, 3, NULL, NULL, 0, NULL, NULL, 50, 20),
(707, 4, NULL, NULL, 0, NULL, NULL, 50, 20),
(708, 5, NULL, NULL, 0, NULL, NULL, 50, 8),
(709, 6, NULL, NULL, 0, NULL, NULL, 50, 19),
(710, 7, NULL, NULL, 0, NULL, NULL, 50, 19),
(711, 8, NULL, NULL, 0, NULL, NULL, 50, 0),
(712, 9, NULL, NULL, 0, NULL, NULL, 50, 0),
(713, 10, NULL, NULL, 0, NULL, NULL, 50, 0),
(714, 11, NULL, NULL, 0, NULL, NULL, 50, 0),
(716, 2, NULL, NULL, 0, NULL, NULL, 51, 3),
(717, 0, 50, 6, 1, 'Martedi ore 09:00', 4, 51, 3),
(718, 1, NULL, NULL, 0, NULL, NULL, 51, 3),
(719, 3, NULL, NULL, 0, NULL, NULL, 51, 20),
(720, 4, NULL, NULL, 0, NULL, NULL, 51, 20),
(721, 5, NULL, NULL, 0, NULL, NULL, 51, 8),
(722, 6, NULL, NULL, 0, NULL, NULL, 51, 19),
(723, 7, NULL, NULL, 0, NULL, NULL, 51, 19),
(724, 8, NULL, NULL, 0, NULL, NULL, 51, 0),
(725, 9, NULL, NULL, 0, NULL, NULL, 51, 0),
(726, 10, NULL, NULL, 0, NULL, NULL, 51, 0),
(727, 11, NULL, NULL, 0, NULL, NULL, 51, 0),
(729, 2, NULL, NULL, 0, NULL, NULL, 52, 3),
(730, 0, 50, 6, 1, 'Martedi ore 09:00', 4, 52, 3),
(731, 1, NULL, NULL, 0, NULL, NULL, 52, 3),
(732, 3, NULL, NULL, 0, NULL, NULL, 52, 20),
(733, 4, NULL, NULL, 0, NULL, NULL, 52, 20),
(734, 5, NULL, NULL, 0, NULL, NULL, 52, 8),
(735, 6, NULL, NULL, 0, NULL, NULL, 52, 19),
(736, 7, NULL, NULL, 0, NULL, NULL, 52, 19),
(738, 2, NULL, NULL, 0, NULL, NULL, 53, 3),
(739, 0, 50, 6, 1, 'Martedi ore 09:00', 4, 53, 3),
(740, 1, NULL, NULL, 0, NULL, NULL, 53, 3),
(741, 3, NULL, NULL, 0, NULL, NULL, 53, 20),
(742, 4, NULL, NULL, 0, NULL, NULL, 53, 20),
(743, 5, NULL, NULL, 0, NULL, NULL, 53, 8),
(744, 6, NULL, NULL, 0, NULL, NULL, 53, 19),
(745, 7, NULL, NULL, 0, NULL, NULL, 53, 19),
(750, 2, NULL, NULL, 0, NULL, NULL, 54, 3),
(751, 0, 50, 6, 1, 'Martedi ore 09:00', 4, 54, 3),
(752, 1, NULL, NULL, 0, NULL, NULL, 54, 3),
(753, 3, NULL, NULL, 0, NULL, NULL, 54, 20),
(754, 4, NULL, NULL, 0, NULL, NULL, 54, 20),
(755, 5, NULL, NULL, 0, NULL, NULL, 54, 8),
(756, 6, NULL, NULL, 0, NULL, NULL, 54, 19),
(757, 7, NULL, NULL, 0, NULL, NULL, 54, 19),
(759, 2, NULL, NULL, 0, NULL, NULL, 55, 3),
(760, 0, 50, 6, 1, 'Martedi ore 09:00', 4, 55, 3),
(761, 1, NULL, NULL, 0, NULL, NULL, 55, 3),
(762, 3, NULL, NULL, 0, NULL, NULL, 55, 20),
(763, 4, NULL, NULL, 0, NULL, NULL, 55, 20),
(764, 5, NULL, NULL, 0, NULL, NULL, 55, 8),
(765, 6, NULL, NULL, 0, NULL, NULL, 55, 19),
(766, 7, NULL, NULL, 0, NULL, NULL, 55, 19),
(769, 2, NULL, NULL, 0, NULL, NULL, 55, 0),
(770, 0, 50, 6, 1, 'Martedi ore 09:00', 4, 55, 0),
(771, 1, NULL, NULL, 0, NULL, NULL, 55, 0),
(772, 3, NULL, NULL, 0, NULL, NULL, 55, 0),
(774, 0, NULL, NULL, 0, NULL, NULL, 56, 3),
(775, 1, NULL, NULL, 0, NULL, NULL, 56, 3),
(776, 2, NULL, NULL, 0, NULL, NULL, 56, 3),
(777, 3, NULL, NULL, 0, NULL, NULL, 56, 20),
(778, 4, NULL, NULL, 0, NULL, NULL, 56, 20),
(779, 5, NULL, NULL, 0, NULL, NULL, 56, 8),
(780, 6, NULL, NULL, 0, NULL, NULL, 56, 19),
(781, 7, NULL, NULL, 0, NULL, NULL, 56, 19),
(783, 9, NULL, NULL, 0, NULL, NULL, 56, 14),
(785, 0, NULL, NULL, 0, NULL, NULL, 56, 3),
(786, 1, NULL, NULL, 0, NULL, NULL, 56, 3),
(787, 2, NULL, NULL, 0, NULL, NULL, 56, 3),
(788, 3, NULL, NULL, 0, NULL, NULL, 56, 20),
(789, 4, NULL, NULL, 0, NULL, NULL, 56, 20),
(790, 5, NULL, NULL, 0, NULL, NULL, 56, 8),
(791, 6, NULL, NULL, 0, NULL, NULL, 56, 19),
(792, 7, NULL, NULL, 0, NULL, NULL, 56, 19);

-- --------------------------------------------------------

--
-- Table structure for table `MenuFeatures`
--

CREATE TABLE `MenuFeatures` (
  `menu_id` int(11) NOT NULL,
  `name` varchar(128) NOT NULL DEFAULT '',
  `value` tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `MenuFeatures`
--

INSERT INTO `MenuFeatures` (`menu_id`, `name`, `value`) VALUES
(80, 'Richiede cuoco', 0),
(80, 'Buffet', 0),
(80, 'Richiede cucina', 0),
(80, 'Finger food', 0),
(80, 'Piatti caldi', 0),
(82, 'Richiede cuoco', 0),
(82, 'Buffet', 0),
(82, 'Richiede cucina', 0),
(82, 'Finger food', 0),
(82, 'Piatti caldi', 0),
(86, 'Richiede cuoco', 0),
(86, 'Buffet', 0),
(86, 'Richiede cucina', 0),
(86, 'Finger food', 0),
(86, 'Piatti caldi', 0),
(93, 'Richiede cuoco', 0),
(93, 'Buffet', 0),
(93, 'Richiede cucina', 0),
(93, 'Finger food', 0),
(93, 'Piatti caldi', 0),
(94, 'Richiede cuoco', 1),
(94, 'Buffet', 1),
(94, 'Richiede cucina', 1),
(94, 'Finger food', 1),
(94, 'Piatti caldi', 1),
(95, 'Richiede cuoco', 0),
(95, 'Buffet', 0),
(95, 'Richiede cucina', 0),
(95, 'Finger food', 0),
(95, 'Piatti caldi', 0),
(96, 'Richiede cuoco', 0),
(96, 'Buffet', 0),
(96, 'Richiede cucina', 0),
(96, 'Finger food', 0),
(96, 'Piatti caldi', 0),
(97, 'Richiede cuoco', 1),
(97, 'Buffet', 1),
(97, 'Richiede cucina', 1),
(97, 'Finger food', 1),
(97, 'Piatti caldi', 1),
(98, 'Richiede cuoco', 1),
(98, 'Buffet', 1),
(98, 'Richiede cucina', 1),
(98, 'Finger food', 1),
(98, 'Piatti caldi', 1);

-- --------------------------------------------------------

--
-- Table structure for table `MenuItems`
--

CREATE TABLE `MenuItems` (
  `id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  `section_id` int(11) DEFAULT NULL,
  `description` tinytext,
  `recipe_id` int(11) NOT NULL,
  `position` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `MenuItems`
--

INSERT INTO `MenuItems` (`id`, `menu_id`, `section_id`, `description`, `recipe_id`, `position`) VALUES
(96, 80, 0, 'Croissant vuoti', 9, 0),
(97, 80, 0, 'Croissant alla marmellata', 9, 1),
(98, 80, 0, 'Pane al cioccolato mignon', 10, 2),
(99, 80, 0, 'Panini al latte con prosciutto crudo', 12, 4),
(100, 80, 0, 'Panini al latte con prosciutto cotto', 12, 5),
(101, 80, 0, 'Panini al latte con formaggio spalmabile alle erbe', 12, 6),
(102, 80, 0, 'Girelle all\'uvetta mignon', 11, 3),
(103, 82, 0, 'Biscotti', 13, 1),
(104, 82, 0, 'Lingue di gatto', 14, 2),
(105, 82, 0, 'Bigné alla crema', 15, 3),
(106, 82, 0, 'Bigné al caffè', 15, 4),
(107, 82, 0, 'Pizzette', 16, 5),
(108, 82, 0, 'Croissant al prosciutto crudo mignon', 9, 6),
(109, 82, 0, 'Tramezzini tonno e carciofini mignon', 17, 7),
(112, 86, 41, 'Vitello tonnato', 1, 0),
(113, 86, 41, 'Carpaccio di spada', 2, 1),
(114, 86, 41, 'Alici marinate', 3, 2),
(115, 86, 42, 'Penne alla messinese', 5, 0),
(116, 86, 42, 'Risotto alla zucca', 20, 1),
(117, 86, 43, 'Salmone al forno', 8, 0),
(118, 86, 44, 'Sorbetto al limone', 18, 0),
(119, 86, 44, 'Torta Saint Honoré', 19, 1),
(133, 93, 52, 'Vitello tonnato', 1, 0),
(134, 93, 52, 'Insalatina fresca', 7, 1),
(136, 94, 53, 'Vitello tonnato', 1, 0),
(137, 94, 53, 'Carpaccio di spada', 2, 1),
(138, 94, 53, 'Alici marinate', 3, 2),
(139, 94, 55, 'Hamburger con bacon e cipolla caramellata', 7, 0),
(140, 94, 55, 'Salmone al forno', 8, 1),
(141, 94, 0, 'Insalata di riso', 4, 0),
(142, 94, 0, 'Penne al sugo di baccalà', 5, 1),
(143, 97, 61, 'Vitello tonnato', 1, 0),
(144, 97, 61, 'Carpaccio di spada', 2, 1),
(145, 97, 61, 'Alici marinate', 3, 2),
(146, 97, 63, 'Salmone al forno', 8, 0),
(147, 97, 63, 'Croissant', 9, 1),
(148, 97, 0, 'Insalata di riso', 4, 0),
(149, 97, 0, 'Penne al sugo di baccalà', 5, 1),
(150, 98, 64, 'Risotto alla zucca', 20, 0),
(151, 98, 64, 'Vitello tonnato', 1, 1),
(152, 98, 64, 'Carpaccio di spada', 2, 2),
(153, 98, 66, 'Pappa al pomodoro', 6, 0),
(154, 98, 66, 'Hamburger con bacon e cipolla caramellata', 7, 1),
(155, 98, 0, 'Alici marinate', 3, 0),
(156, 98, 0, 'Insalata di riso', 4, 1);

-- --------------------------------------------------------

--
-- Table structure for table `Menus`
--

CREATE TABLE `Menus` (
  `id` int(11) NOT NULL,
  `title` tinytext,
  `owner_id` int(11) DEFAULT NULL,
  `published` tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Menus`
--

INSERT INTO `Menus` (`id`, `title`, `owner_id`, `published`) VALUES
(80, 'Coffee break mattutino', 2, 1),
(82, 'Coffee break pomeridiano', 2, 1),
(86, 'Cena di compleanno pesce', 3, 1),
(93, 'Pranzo', 2, 1),
(94, 'Titolo Nuovo', 2, 1),
(95, 'Menu Pinco Pallino', 2, 0),
(96, 'Menu Pinco Pallino', 2, 0),
(97, 'Titolo Nuovo', 2, 1),
(98, 'Titolo Nuovo', 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `MenuSections`
--

CREATE TABLE `MenuSections` (
  `id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  `name` tinytext,
  `position` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `MenuSections`
--

INSERT INTO `MenuSections` (`id`, `menu_id`, `name`, `position`) VALUES
(41, 86, 'Antipasti', 0),
(42, 86, 'Primi', 1),
(43, 86, 'Secondi', 2),
(44, 86, 'Dessert', 3),
(45, 87, 'Antipasti', 0),
(52, 93, 'nfhfjfjf', 0),
(53, 94, 'Antipasti', 0),
(54, 94, 'Primi', 1),
(55, 94, 'Secondi', 2),
(56, 95, 'Antipasti', 0),
(57, 95, 'Primi', 1),
(58, 96, 'Antipasti', 0),
(59, 96, 'Primi', 1),
(60, 96, 'Secondi', 2),
(61, 97, 'Antipasti', 0),
(62, 97, 'Primi', 1),
(63, 97, 'Secondi', 2),
(64, 98, 'Antipasti', 0),
(65, 98, 'Primi', 1),
(66, 98, 'Secondi', 2);

-- --------------------------------------------------------

--
-- Table structure for table `Procedures`
--

CREATE TABLE `Procedures` (
  `id` int(11) NOT NULL,
  `title` tinytext,
  `procedure_type` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Procedures`
--

INSERT INTO `Procedures` (`id`, `title`, `procedure_type`) VALUES
(1, 'Vitello tonnato', 'r'),
(2, 'Carpaccio di spada', 'r'),
(3, 'Alici marinate', 'r'),
(4, 'Insalata di riso', 'r'),
(5, 'Penne al sugo di baccalà', 'r'),
(6, 'Pappa al pomodoro', 'r'),
(7, 'Hamburger con bacon e cipolla caramellata', 'r'),
(8, 'Salmone al forno', 'r'),
(9, 'Croissant', 'r'),
(10, 'Pane al cioccolato', 'r'),
(11, 'Girelle all\'uvetta', 'r'),
(12, 'Panini al latte', 'r'),
(13, 'Biscotti di pasta frolla', 'r'),
(14, 'Lingue di gatto', 'r'),
(15, 'Bigné farciti', 'r'),
(16, 'Pizzette', 'r'),
(17, 'Tramezzini', 'r'),
(18, 'Sorbetto al limone', 'r'),
(19, 'Torta Saint Honoré', 'r'),
(20, 'Risotto alla zucca', 'r');

-- --------------------------------------------------------

--
-- Table structure for table `Roles`
--

CREATE TABLE `Roles` (
  `id` char(1) NOT NULL,
  `role` varchar(128) NOT NULL DEFAULT 'servizio'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Roles`
--

INSERT INTO `Roles` (`id`, `role`) VALUES
('c', 'cuoco'),
('h', 'chef'),
('o', 'organizzatore'),
('s', 'servizio');

-- --------------------------------------------------------

--
-- Table structure for table `Services`
--

CREATE TABLE `Services` (
  `id` int(11) NOT NULL,
  `event_id` int(11) NOT NULL,
  `name` varchar(128) DEFAULT NULL,
  `proposed_menu_id` int(11) NOT NULL DEFAULT '0',
  `approved_menu_id` int(11) DEFAULT '0',
  `service_date` date DEFAULT NULL,
  `time_start` time DEFAULT NULL,
  `time_end` time DEFAULT NULL,
  `expected_participants` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Services`
--

INSERT INTO `Services` (`id`, `event_id`, `name`, `proposed_menu_id`, `approved_menu_id`, `service_date`, `time_start`, `time_end`, `expected_participants`) VALUES
(1, 2, 'Cena', 86, 0, '2020-08-13', '20:00:00', '23:30:00', 25),
(2, 1, 'Coffee break mattino', 0, 80, '2020-09-25', '10:30:00', '11:30:00', 100),
(3, 1, 'Colazione di lavoro', 0, 0, '2020-09-25', '13:00:00', '14:00:00', 80),
(4, 1, 'Coffee break pomeriggio', 0, 82, '2020-09-25', '16:00:00', '16:30:00', 100),
(5, 1, 'Cena sociale', 0, 0, '2020-09-25', '20:00:00', '22:30:00', 40),
(6, 3, 'Pranzo giorno 1', 0, 0, '2020-10-02', '12:00:00', '15:00:00', 200),
(7, 3, 'Pranzo giorno 2', 0, 0, '2020-10-03', '12:00:00', '15:00:00', 300),
(8, 3, 'Pranzo giorno 3', 0, 0, '2020-10-04', '12:00:00', '15:00:00', 400);

-- --------------------------------------------------------

--
-- Table structure for table `Shifts`
--

CREATE TABLE `Shifts` (
  `when` varchar(20) NOT NULL,
  `completed` tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Shifts`
--

INSERT INTO `Shifts` (`when`, `completed`) VALUES
('Lunedi ore 15:00', 1),
('Martedi ore 16:00', 0),
('Martedi ore 17:00', 0),
('Mercoledi ore 15:00', 0),
('Mercoledi ore 16:00', 0),
('Venerdi ore 15:00', 0);

-- --------------------------------------------------------

--
-- Table structure for table `UserRoles`
--

CREATE TABLE `UserRoles` (
  `user_id` int(11) NOT NULL,
  `role_id` char(1) NOT NULL DEFAULT 's'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `UserRoles`
--

INSERT INTO `UserRoles` (`user_id`, `role_id`) VALUES
(1, 'o'),
(2, 'o'),
(2, 'h'),
(3, 'h'),
(4, 'h'),
(4, 'c'),
(5, 'c'),
(6, 'c'),
(7, 'c'),
(8, 's'),
(9, 's'),
(10, 's'),
(7, 's');

-- --------------------------------------------------------

--
-- Table structure for table `Users`
--

CREATE TABLE `Users` (
  `id` int(11) NOT NULL,
  `username` varchar(128) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Users`
--

INSERT INTO `Users` (`id`, `username`) VALUES
(1, 'Carlin'),
(2, 'Lidia'),
(3, 'Tony'),
(4, 'Marinella'),
(5, 'Guido'),
(6, 'Antonietta'),
(7, 'Paola'),
(8, 'Silvia'),
(9, 'Marco'),
(10, 'Piergiorgio');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Events`
--
ALTER TABLE `Events`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `KitchenSheets`
--
ALTER TABLE `KitchenSheets`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `KitchenTasks`
--
ALTER TABLE `KitchenTasks`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `MenuItems`
--
ALTER TABLE `MenuItems`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Menus`
--
ALTER TABLE `Menus`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `MenuSections`
--
ALTER TABLE `MenuSections`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Procedures`
--
ALTER TABLE `Procedures`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Roles`
--
ALTER TABLE `Roles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Services`
--
ALTER TABLE `Services`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Shifts`
--
ALTER TABLE `Shifts`
  ADD PRIMARY KEY (`when`);

--
-- Indexes for table `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Events`
--
ALTER TABLE `Events`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `KitchenSheets`
--
ALTER TABLE `KitchenSheets`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT for table `KitchenTasks`
--
ALTER TABLE `KitchenTasks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=793;

--
-- AUTO_INCREMENT for table `MenuItems`
--
ALTER TABLE `MenuItems`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=157;

--
-- AUTO_INCREMENT for table `Menus`
--
ALTER TABLE `Menus`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=99;

--
-- AUTO_INCREMENT for table `MenuSections`
--
ALTER TABLE `MenuSections`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;

--
-- AUTO_INCREMENT for table `Procedures`
--
ALTER TABLE `Procedures`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `Services`
--
ALTER TABLE `Services`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `Users`
--
ALTER TABLE `Users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
