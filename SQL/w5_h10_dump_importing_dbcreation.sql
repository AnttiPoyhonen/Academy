-- SQL scripts, w5 Academy, harjoitus 10 -- 

-- UUSI DB
-- mysql > CREATE DATABASE harjoitus

-- DUMPIN LUOMINEN TIETOKANNASTA, VAIN TAULUKOT:
-- mysqldump -u root -p kurssi > kurssikanta.sql

-- DUMPIN LUOMINEN TIETOKANNASTA, MUKANA DB LUOMINEN:
-- mysqldump -u root --databases -p kurssi > kurssikanta2.sql

-- DB PALAUTUS DUMPISTA:
-- SOURCE c:/kurssi/kurssikanta2.sql
-- (huom. jos muokkaa dumpia, voi saada luotua kopion eri nimellä...)
