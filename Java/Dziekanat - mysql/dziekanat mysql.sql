-- phpMyAdmin SQL Dump
-- version 3.5.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Czas wygenerowania: 02 Mar 2018, 12:34
-- Wersja serwera: 5.5.21-log
-- Wersja PHP: 5.3.20

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Baza danych: `dziekanat`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `grupy`
--

CREATE TABLE IF NOT EXISTS `grupy` (
  `Grupa` varchar(10) CHARACTER SET utf16 COLLATE utf16_polish_ci NOT NULL,
  PRIMARY KEY (`Grupa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `grupy`
--

INSERT INTO `grupy` (`Grupa`) VALUES
('CA'),
('CB'),
('CBB');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pracownicy`
--

CREATE TABLE IF NOT EXISTS `pracownicy` (
  `ID` varchar(17) COLLATE utf8_polish_ci NOT NULL,
  `Nazwisko` varchar(15) CHARACTER SET utf32 COLLATE utf32_polish_ci NOT NULL,
  `Imie` varchar(15) COLLATE utf8_polish_ci NOT NULL,
  `Telefon` char(9) COLLATE utf8_polish_ci NOT NULL,
  `Ulica` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `Miejscowosc` varchar(20) CHARACTER SET utf16 COLLATE utf16_polish_ci NOT NULL,
  `Przedmiot` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `pracownicy`
--

INSERT INTO `pracownicy` (`ID`, `Nazwisko`, `Imie`, `Telefon`, `Ulica`, `Miejscowosc`, `Przedmiot`) VALUES
('T.Malinowski', 'Malinowski', 'Tadeusz', '987654321', 'Sosnowa 2/7', 'Pozna?', 'Elektryka'),
('T.Malinowski2', 'Malinowski', 'Tadeusz', '987654321', 'Sosnowa 2/7', 'Pozna?', 'Informatyka');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `przedmioty`
--

CREATE TABLE IF NOT EXISTS `przedmioty` (
  `Przedmiot` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`Przedmiot`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `przedmioty`
--

INSERT INTO `przedmioty` (`Przedmiot`) VALUES
('Ekonomia'),
('Elektryka'),
('Informatyka'),
('Technika');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `studenci`
--

CREATE TABLE IF NOT EXISTS `studenci` (
  `Nazwisko` varchar(15) COLLATE utf8_polish_ci NOT NULL,
  `Imie` varchar(15) COLLATE utf8_polish_ci NOT NULL,
  `Kierunek` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_polish_ci NOT NULL,
  `Semestr` tinyint(1) NOT NULL,
  `Przedmiot` varchar(30) CHARACTER SET utf32 COLLATE utf32_polish_ci NOT NULL,
  `Grupa` varchar(10) COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`Nazwisko`),
  KEY `Przedmiot` (`Przedmiot`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `studenci`
--

INSERT INTO `studenci` (`Nazwisko`, `Imie`, `Kierunek`, `Semestr`, `Przedmiot`, `Grupa`) VALUES
('Kowalski', 'Jan', 'aaa', 4, 'Ekonomia', 'CB'),
('Krych', 'Krzysztof', 'jakis', 2, 'Ekonomia', 'CA'),
('Lipka', 'Marcin', 'Społeczeństwo', 3, 'Ekonomia', 'CA');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
