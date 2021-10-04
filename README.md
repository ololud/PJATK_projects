**PROJEKTY WYKONANE W RAMACH STUDIÓW NA PJATK**  
**JEDYNYM AUTOREM NINIEJSZYCH PROJEKTÓW JEST: OLAF LUDWIG**




**1. AUTOR PROJEKTU**: OLAF LUDWIG W RAMACH STUDIÓW NA PJATK NR. STUDENTA S21265  
 **NAZWA**: ROGRAM DO ZARZADZANIA OSIEDLEM MIESZKANIOWYM
 
 **PROGRAM IMPLEMENTUJE WSZYSTKIE FUNCKJE WSKAZANE W ZALOZENIACH PROJEKTOWYCH!**
  - STEROWANIE NINIEJSZYM PROGRAMEM ODBYWA SIE ZA POMOCA WPISYWANIA W KONSOLI LICZB CALKOWITYCH, KTORYCH WARTOSCI ODPOWIADAJA POSZCZEGOLNYM FUNKCJOM PROGRAMU I SA NA BIEZACO WYSWIETLANE W TRAKCIE DZIALANIA PROGRAMU.
  - PROGRAM MOZNA OPUSCIC POPRZEZ WPISANIE W DOWOLNYM MOMENCIE WARTOSCI 123 W KOSNOLI (NAWET JESLI PROGRAM PROSI O PSEL OSOBY, ID NIERUCHOMOSCI ITP).
  - ZEBY UMIESCIC PRZEDMIOT W JEDNYM POMIESZCZENIU NAJPIERW TRZEBA WYCIAGNAC GO Z INNEGO (PRZEDMIOT NIE MOZE ZNAJDOWAC SIE W DWOCH POMIESZCZENIACH JEDNOCZESNIE)
 
  
 **KLUCZOWE DLA DZIALANIA PROGRAMU SA KLASY**:
 
  - OSOBA - TO W TEJ KLASIE ZNAJDUJE SIE WIEKSZOSC METOD ODPOWIEDZIALNYCH ZA WYKNONYWANIE DZIALAN NA PRZEDMIOTACH I POMIESZCZENIACH
  - PACKAGE WATKI - W TEJ PACZCE ZDEFINIOWANO WATEK KONTROLNY KTORY CO 10 SEKUND SPRAWDZA CZY NIE ZLAMANO WARUNKOW NAJMU, ORAZ WATEK CZASOWY DODAJACY CO 5 SEKUND 1 DZIEN
  - ZDEFINIOWANA ZOSTALA TEZ KLASA KALENDARZ KTOREJ OBIEKT W PRAKTYCE TWORZY INSTANCJE CZASU W PROGRAMIE.
  - MIESZKANIE - ZAWIERA METODY WERYFIKACYJNE PRZEKROCZENIE CZASU NAJMU
  - MIEJSCE PARKINGOWE - ZAWIERA METODY WERYFIKACYJNE PRZEKROCZENIE CZASU NAJMU
 
  
 **SLOWNICZEK POJEC**:
  - PESEL OSOBY: WARTOSC TYPU INTEGER PODAWANA W KONSTRUKTORZE KONKRETNEJ OSOBY
  - ID NIERUCHOMOSCI: JEST TO WYRAZENIE W POSTACI "mX" (DLA MIESZKAN) LUB "pX" (DLA PARKINGOW) GDZIE "X" > 0 I WYRAZANY JEST POPRZEZ KOLEJNOSC TWORZENIA POSZCZEGOLNYCH LOKALI
  - NAZWA PRZEDMIOTU: JEST TO WYRAZENIE W POSTACI "StringX" GDZIE "X" > 0 I WYRAZANY JEST POPRZEZ KOLEJNOSC TWORZENIA POSZCZEGOLNYCH PRZEDMIOTOW, A "String" JEST NAZWA PRZEDMIOTU SKIEROWANA DO KONSTRUKTORA. WAŻNE! ID POJAZDU JEST DEFINIOWANE W TEN SAM SPOSOB, GDYZ POJAZD JEST KLASA,
 DZIEDZICZACA PO ABSTRAKCYJNEJ KLASIE PRZEDMIOT.
 
 
 **W CELU PRZEJRZYSTEGO POZNANIA DOKLADNYCH ID WSZYSTKICH ISTNIEJACYCH LOKALI, PRZEDMIOTOW, ORAZ OSOB POLECAM W PIERWSZYCH CHWILACH DZIALANIA PROGRAMU WYSWIETLIC,
 TE INFORMACJE ZA POSREDNICTWEM WYDAWANYCH Z KONSOLI POLECEN.**

**2. AUTOR PROJEKTU**: OLAF LUDWIG W RAMACH STUDIÓW NA PJATK NR. STUDENTA S21265  
 **NAZWA**: Gra AntiPlague vel. World Saver.
  
 
 Gra posiada interfejs graficzny realizowany za pomocą biblioteki Swing.  
 
 Po rozpoczęciu działania programu generowane jest okno startowe, w ktorym mozemy wybrac jedna z trzech mozliwosci:  
 
  - Nowa Gra - Przenosi nas do drugiego okna, w ktorym wybieramy interesujacy nas poziom trudnosci. Poziomy te roznia się  
 prędkością szerzenia się wirusa, a także ilością punktów możliwych do zdobycia (ostateczna liczba punktow jest  
 modyfikowana rowniez ze wzgledu na stosunek chorych do zdrowych mieszkancow swiata)  
  - Tabela wynikow - wyswietla nam liste graczy, ktorym udalo sie ukonczyc gre, wraz z ich wynikiem koncowym. Do tabeli wynikow  
 wpisywani sa jedynie ci gracze, ktorzy odniesli zwyciestwo  
  - Wyjście - natychmiast konczy dzialanie programu.  
 
 
 Podczas rozgrywki mozemy spotkac sie 3 rodzajami okien dialogowych:  
  - Okno sygnalizujace porazke, po ktorego zamknieciu wracamy do menu glownego.  
  - Okno informujace o braku mozliwosci wykupienia ulepszenia.  
  - Okno informujace o pojawieniu sie wirusa w nowym panstwie.  
 
 
 W momencie ukonczenia gry w zwiazku ze zwyciestwem, na ekranie pojawia się okno proszace nas o podanie swojej nazwy gracza.
 
 Nazwa wraz z wynikiem o tego momentu widnieć będzie w Tabeli Wyników, możliwej do zobaczenia z pozycji menu glownego.  
 
 W trakcie rozgrywki otrzymujemy walutę nazwaną "MONETY", zgromadzonej, której ilość wyświetlana będzie w górnym panelu.  
 Za walutę możemy kupować ulepszenia znajdujace się w lewym panelu poprzez wcisniecie interesujacego nas przycisku, po  
 najechaniu myszka na przycisk wyswietli nam sie, krotka charakterystyka konkretnego ulepszenia.  
 
 W gornym panelu oprocz waluty mozemy znalezc rowniez informacje o czasie trwania gry, ilosci punktow, oraz przycisk przerywajacy  
 rozgrywke. Przerwanie rozgrywki jest rownoznaczne z powrotem do menu glownego bez mozliwosci powrotu do rozgrywki. Opuscic gre  
 mozemy rowniez poprzez kombinacje klawiszy "ALT+Q"  
 
 W panelu glownym o nazwie panstwa znajduje się przesuwana lista panstw oraz grafika przedstawiajaca mape swiata. Po zaznaczeniu  
 konkretnego panstwa z listy przedstawione zostatenie jego polozenie na mampie. (po wybraniu tej mozliwosci, nie bedzie mozna juz  
 wrocic do ogolnej mapy swiata)  
 
 Panel dolny zawiera informacje dotyczace ogolnej populacji swiata oraz ogolnej liczby zarazonych. Obok tych informacji grafiki  
 reprezentuja dostepne na biezacy moment srodki transportu, w przypadku wylaczenia jednego z nich, grafika go reprezentujaca zostanie  
 zastapiona czerwonym zakazu.  
 
 Gra konczy sie gdy:  
  - Wszyscy zostana zarazeni (porażka)  
  - Wszyscy zostaną wyleczeni (wygrana)  
  - Tempo szerzenia sie wirusa spadnie do zera(wygrana)    
 
  
 Program w ramach studiow na PJATK wykonał: Olaf Ludwig s21265
