AUTOR PROJEKTU: OLAF LUDWIG W RAMACH STUDIÓW NA PJATK NR. STUDENTA S21265
NAZWA: PROGRAM DO ZARZADZANIA OSIEDLEM MIESZKANIOWYM
PROGRAM IMPLEMENTUJE WSZYSTKIE FUNCKJE WSKAZANE W ZALOZENIACH PROJEKTOWYCH!
STEROWANIE NINIEJSZYM PROGRAMEM ODBYWA SIE ZA POMOCA WPISYWANIA W KONSOLI LICZB CALKOWITYCH, KTORYCH WARTOSCI
ODPOWIADAJA POSZCZEGOLNYM FUNKCJOM PROGRAMU I SA NA BIEZACO WYSWIETLANE W TRAKCIE DZIALANIA PROGRAMU.
PROGRAM MOZNA OPUSCIC POPRZEZ WPISANIE W DOWOLNYM MOMENCIE WARTOSCI 123 W KOSNOLI (NAWET JESLI PROGRAM PROSI O PSEL OSOBY, ID NIERUCHOMOSCI ITP).
ZEBY UMIESCIC PRZEDMIOT W JEDNYM POMIESZCZENIU NAJPIERW TRZEBA WYCIAGNAC GO Z INNEGO (PRZEDMIOT NIE MOZE ZNAJDOWAC SIE W DWOCH POMIESZCZENIACH JEDNOCZESNIE)
KLUCZOWE DLA DZIALANIA PROGRAMU SA KLASY:
1. OSOBA - TO W TEJ KLASIE ZNAJDUJE SIE WIEKSZOSC METOD ODPOWIEDZIALNYCH ZA WYKNONYWANIE DZIALAN NA PRZEDMIOTACH I POMIESZCZENIACH
4. PACKAGE WATKI - W TEJ PACZCE ZDEFINIOWANO WATEK KONTROLNY KTORY CO 10 SEKUND SPRAWDZA CZY NIE ZLAMANO WARUNKOW NAJMU, ORAZ WATEK CZASOWY DODAJACY CO 5 SEKUND 1 DZIEN
ZDEFINIOWANA ZOSTALA TEZ KLASA KALENDARZ KTOREJ OBIEKT W PRAKTYCE TWORZY INSTANCJE CZASU W PROGRAMIE.
2. MIESZKANIE - ZAWIERA METODY WERYFIKACYJNE PRZEKROCZENIE CZASU NAJMU
3. MIEJSCE PARKINGOWE - ZAWIERA METODY WERYFIKACYJNE PRZEKROCZENIE CZASU NAJMU
SLOWNICZEK POJEC:
PESEL OSOBY: WARTOSC TYPU INTEGER PODAWANA W KONSTRUKTORZE KONKRETNEJ OSOBY
ID NIERUCHOMOSCI: JEST TO WYRAZENIE W POSTACI "mX" (DLA MIESZKAN) LUB "pX" (DLA PARKINGOW) GDZIE "X" > 0 I WYRAZANY JEST POPRZEZ KOLEJNOSC TWORZENIA POSZCZEGOLNYCH LOKALI
NAZWA PRZEDMIOTU: JEST TO WYRAZENIE W POSTACI "StringX" GDZIE "X" > 0 I WYRAZANY JEST POPRZEZ KOLEJNOSC TWORZENIA POSZCZEGOLNYCH PRZEDMIOTOW,
A "String" JEST NAZWA PRZEDMIOTU SKIEROWANA DO KONSTRUKTORA. WAŻNE! ID POJAZDU JEST DEFINIOWANE W TEN SAM SPOSOB, GDYZ POJAZD JEST KLASA,
DZIEDZICZACA PO ABSTRAKCYJNEJ KLASIE PRZEDMIOT.
W CELU PRZEJRZYSTEGO POZNANIA DOKLADNYCH ID WSZYSTKICH ISTNIEJACYCH LOKALI, PRZEDMIOTOW, ORAZ OSOB POLECAM W PIERWSZYCH CHWILACH DZIALANIA PROGRAMU WYSWIETLIC,
TE INFORMACJE ZA POSREDNICTWEM WYDAWANYCH Z KONSOLI POLECEN.