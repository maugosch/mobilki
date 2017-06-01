# FinAnalyzer - analizator finansowy

## Twórcy projektu
Małgorzata Graja 166711 KrDZIs3012Io <br>
Bartłomiej Korytkowski 186932 KrDZIs3012Io

## Funkcjonalności

1. Rejestracja konta użytkownika i logowanie do aplikacji
2. Wybór wskaźników i modeli finansowych spośród dostępnych: <br>
- płynność finansowa <br>
- wskaźnik wypłacalności <br>
- wskaźnik giełdowy <br>
- sprawność działania <br>
- wskaźnik rentowności <br>
- modele upadłości: Holda i Altmana <br>
3. Wprowadzenie danych na serwer
3. Analiza sytuacji finansowej spółki na podstawie wprowadzonych danych

## Dostępne funkcjonalności

<p align="center">

<img src="https://raw.githubusercontent.com/maugosch/mobilki/master/screenshots/3.png"/>
</p>

Aktywność pozwalająca na zalogowanie się uzytkownika do aplikacji wpisując swój adres e-mail oraz hasło posiadające minimum 6 znaków.
1. Sign in or register - zalogowanie lub zarejestrowanie użytkownika do aplikacji mobilnej w celu przypisania do jego konta wprowadzanych danych.


<p align="center">

<img src="https://raw.githubusercontent.com/maugosch/mobilki/master/screenshots/2.png"/>
</p>

1. Wskaźniki finansowe - umożliwia przejście do nowej aktywności w celu ułatwienia wprowadzania danych w szczegółowych wskaźnikach takich jak: 
*Płynność finansowa
*Wskaźnik wypłacalności
*Wskaźnik giełdowy
*Sprawność działania
*Wskaźnik rentowności

2. Modele upadłości - umożliwia wybór dwóch najważniejszych modeli:
*Model E. Altmana
*Model A. Hołda


<p align="center">

<img src="https://raw.githubusercontent.com/maugosch/mobilki/master/screenshots/4.png"/>
</p>


Możliwość wybrania odpowiedniego dla użytownika wskażnika finansowego w celu uzyskania porządanych informacji. 


<p align="center">

<img src="https://raw.githubusercontent.com/maugosch/mobilki/master/screenshots/5.png"/>
</p>

1. Płynność finansowa - posiada wymagane pola do których należy wpisać takie dane jak: zapasy, zobowiązania bieżące, aktywa obrotowe, krótkoterminowe rozliczenie okresowe, środki pieniężne i inne aktywa pieniężne. Za pomocą tego możliwe jest obliczenie: wskażnika płynności bieżącej, wskaźnika szybkiej płynności, wskażnik zaostrzonej płynności.

2. Wskaźnik wypłacalności - posiada wymagane pola do których należy wpisać takie dane jak: kapitał obcy, aktywa ogółem, zysk netto, zobowiązania ogółem, kapitał własny, zobowiązania długoterminowe, przeciętny stan zapasów, zysk brutto, zobowiązania, przychody ze sprzedaży, rata kapitałowa, odsetki, amortyzacja, dodatnie przepływy OP. Za pomocą tego możliwe jest obliczenie: wskaźnik ogólnego zadłużenia, wskaźnik zadłużenia kapitału własnego, wskaźnik zobowiąźan długoterminowych, wskaźnik zadłużenia długoterminowego, wskaźnik pokrycia długu, wskaźnik pokrycia odsetek zykiem, wskaźnik pokrycia długu z nadwyżka, wskaźnik pokrycia zobowiązań nadwyżka, wskaźnik pokrycia długu gotówki, wskaźnik pokrycia odsetek gotówką operacyjną.

3. Wskaźnik giełdowy - posiada wymagane pola do których należy wpisać takie dane jak: ilość akcji zwykłych, cena akcji, kapitał własny, przychody ze sprzedaży na 1 akcję, zysk netto, dywidenty. Za pomocą tego możliwe jest obliczenie: wskażnika dywidenty na akcję, ceny akcji do zysku na akcję, wartości księgowej na akcję, wskaźnik produtywności jednej akcji. 

4. Wskażnik rentowności - posiada wymagane pola do których należy wpisać takie dane jak: aktywa ogółem, przychody ze sprzedaży, zysk bieżący, kapitał własny, strata z lat ubiegłych, zysk netto. Za pomocą tego możliwe jest obliczenie: wksaźnika pokrycia strat, wskaźnika skumulowanych strat, wskaźnika operacyjności, produktywności aktywów, mnożnika kapitału własnego, rentowności kapitału własnego, rentowności majątku, rentowności sprzedaży.


Po wpisaniu i zatwierdzeniu wpisanych liczb baza danych dostaje te dane od aplikacji i dokonuje obliczeń wewnątrz siebie, dzięki temu użytkownik dostaje adnotację ze szczegółowym opisem wybranego wskażnika wraz z wyliczonym wynikiem.


<p align="center">

<img src="https://raw.githubusercontent.com/maugosch/mobilki/master/screenshots/9.png"/>
</p>


1. Model E. Altmana - zawiera pola do edycji takie jak: zyski zatrzymane, kapitał obrotowy netto, aktywa, ebit, zoboiązania ogółem, wartość wynkowa kapitału własnego, przychody ze sprzedaży. Za pomocą tego modelu użytkownik jest w stanie dowiedzieć się czy jego przedsiębiorstwo zbliża się ku upadkowi lub ku wzrostowi.

2. Model A. Hołda - zawiera pola do edycji takie jak: koszty własnej sprzedaży, sprzedaż, aktywa obrotowe, stan średni aktyw, zobowiązania, zobowiązania krótkoterminowe, wyniki netto. Dzięki tym informacją i ich obliczeniu użotkowni jest w stanie zorientować się w jakim okresie jego przedsiębiorstwo może upaść.


## Dokumentacja 
### Technologie wykorzystane w projekcie
Do przygotowania projektu "FinAnalyzer - analizator finansowy" zosały użyte następujące technologie: środowisko programistyczne Android Studio oraz język Java, Android SDK, Firebase, a także Google Services i Deign Support.
### Wykorzystane klasy

W projekcie FinAnalyzer wykorzystano 18 klas Java:

#### 1. LoginActivity
Klasa rozszerza klasę AppCompatActivity oraz implementuje LoaderCallbacks<Cursor>.
Wśród pól tej klasy przechowywane są przedewszystkim:
- email użytkownika - public static final String M_EMAIL = "com.example.sony.androidproject.M_EMAIL",
- model do tworzenia struktury bazy danych dla użytkownika na serwerze - public static ResultModel user,

Najważniejsze metody klasy służą do:
- obsługi logowania użytkownika - private void attemptLogin(),
- utworzenia struktury bazy danych dla użytkownika - protected void createDataTree(String mEmailTemp)
#### 2. MainActivity
Klasa rozszerza klasę AppCompatActivity, zaś jej podstawowe pola to:
- pola do przechowywania maila użytkownika -  private String mEmail,

Klasa zawiera dwie metody:
- przekierowująca do widoku klasy obsługującej wskaźniki finansowe - public void wskaznikiFinansowe (View view),
- przekierowująca do widoku klasy obsługującej modele upadłościowe - public void modeleUpadlosci (View view)
#### 3. MainMainActivity
Klasa zawierająca menu z wieloma rodzajami wskaźników finansowych. Klasa rozszerza klasę AppCompatActivity. Metody klasy to klasy przekierowujące do konkretnych kwestionariuszy dotyczących danych wskaźników finanswocyh:
- public void plynnoscFinansowa(View view)
- public void wskaznikGieldowy(View view)
- public void wskaznikWyplacalnosci(View view)
- public void wskaznikRentownosci(View view)
#### 4. Modele
Klasa rozszerza klasę AppCompatActivity i zawiera dwie metody przekierowujące do formularzy do odpowiednich modeli upadłościowych:
- model amerykański - public void modelAltman(View view)
- model polski - public void modelHolda(View view)
#### 5. ResultModel
Klasa, która służy do utworzenia struktury danych przechowywanych w Firebase. Zawiera pola dotyczące wszystkich danych finansowych zbieranych z kwestionariuszy dotyczących różnych wskaźników finansowych, są to:
- public int zapasy;
- public int zobBiez;
- public int ao;
- public int rmk;
- public int srPien;
- public int zyskBiez;
- public int strata;
- public int kw;
- public int kup;
- public int przychZeSprz;
- public int a;
- public int wf;
- public int ilAkcji;
- public int dywidendy;
- public int cenaAkcji;
- public int zobOg;
- public int ko;
- public int przecStanZapasow;
- public int zobDl;
- public int wfBrutto;
- public int odsetki;
- public int rataKap;
- public int amortyzacja;
- public int przecStanZob;
- public int cfOP;

Ponadto	klasa zawiera kilka konstruktorów - do każdego rodzaju wskaźników jest odrębny konstruktor.
Metody funkcji służą do połączenia danych z Firebase.
#### 6. ResultModelForModels
Klasa służy do ustrukturyzowania danych przechowywanych w bazie dotyczących modeli upadłościowych. 
Klasa zawiera pola przechowujące dane wpisane przez użytkownika w kwestionariuszach dotyczących modeli:
- private int kon;
- private int ao;
- private int zz;
- private int ebit;
- private int przychZeSprz;
- private int kw;
- private int zobOg;
- private int zobKr;
- private int a;
- private int wf;
- private int stanSrA;
- private int kosztSprz;

Klasa zawiera 3 konstruktory - jeden do wywołania metody dataSnapshot.getValue() w celu odczytania danych z Firebase. Kolejne dwa konstruktory służą do obsługi zapisu danych z formularzy dotyczących modeli. Klasa zawiera również metody służacę do zwracania danych do Firebase.
#### 7. ModelAltman
Klasa roszerza klasę AppCompatActivity oraz zawiera metodę:
- służącą do obliczenia modelu upadłości Altmana - public void calculate(View view).
#### 8. ModelAltman2
Klasa roszerza klasę AppCompatActivity oraz służy do wyświetlenia wyników obliczeń klasy ModelAltman na ekranie.
#### 9. ModelHolda
Klasa roszerza klasę AppCompatActivity oraz zawiera metodę:
- służącą do obliczenia modelu upadłości Hołdy - public void calculate(View view).
#### 10. ModelHolda2
Klasa roszerza klasę AppCompatActivity oraz służy do wyświetlenia wyników obliczeń klasy ModelHolda na ekranie.
#### 11. PlynnoscFinansowa
Klasa roszerza klasę AppCompatActivity oraz zawiera metodę:
- służącą do obliczenia płynności finansowej - public void calculatePlynnosc(View view),
- onCreate, która pobiera dane z Firebase i, jeśli dane zostały już wprowadzone przez użytkownika, automatycznie uzupełnia formularz danymi.
#### 12. PlynnoscFinansowa2
Klasa roszerza klasę AppCompatActivity oraz zawiera metodę:
- onCreate, która wyświetla wyniki obliczeń klasy PlynnoscFinansowa na ekranie.
#### 13. WskaznikiGieldowe
Klasa roszerza klasę AppCompatActivity oraz zawiera metodę:
- służącą do obliczenia wskaźników giełdowych - public void calculate(View view),
- onCreate, która pobiera dane z Firebase i, jeśli dane zostały już wprowadzone przez użytkownika, automatycznie uzupełnia formularz danymi.
#### 14. WskaznikiGieldowe2
Klasa roszerza klasę AppCompatActivity oraz zawiera metodę:
- onCreate, która wyświetla wyniki obliczeń klasy WskaznikiGieldowe na ekranie.
#### 15. WskaznikRentownosci
Klasa roszerza klasę AppCompatActivity oraz zawiera metodę:
- służącą do obliczenia wskaźnikó rentowności - public void calculate(View view),
- onCreate, która pobiera dane z Firebase i, jeśli dane zostały już wprowadzone przez użytkownika, automatycznie uzupełnia formularz danymi.
#### 16. WskaznikRentownosci2
Klasa roszerza klasę AppCompatActivity oraz zawiera metodę:
- onCreate, która wyświetla wyniki obliczeń klasy WskaznikRentownosci na ekranie.
#### 17. WskaznikWyplacalnosci
Klasa roszerza klasę AppCompatActivity oraz zawiera metodę:
- służącą do obliczenia wskaźników ywpłacalności - public void calculate(View view),
- onCreate, która pobiera dane z Firebase i, jeśli dane zostały już wprowadzone przez użytkownika, automatycznie uzupełnia formularz danymi.
#### 18. WskaznikWyplacalnosci2
Klasa roszerza klasę AppCompatActivity oraz zawiera metodę:
- onCreate, która wyświetla wyniki obliczeń klasy WskaznikWyplacalnosci na ekranie.

### Użytkowanie aplikacji
Użytkownik tworzy konto poprzez podanie adresu e-mail oraz hasła, po czym zostaje przeniesiony do głównego menu. Tam do wyboru ma za pomocą przycisków wskaźniki finansowe bądź modele upadłości. Po naciśnięciu przycisku "Wskaźniki finansowe", ma do wyboru następujące wskaźniki: płynność finansowa, wskaźnik wypłacalności, wskaźnik giełdowy, sprawność działania, wskaźnik rentowności. Wybierając dany wskaźnik, użytkownik ma możliwość wpisania odpowiednich wartości liczbowych potrzebnych do wykonania analizy, a następnie zostaje mu zaprezentowany wynik operacji. Natomiast po naciśnięciu przycisku "Modele upadłości", na ekranie pojawiają się do wyboru dwa modele: Altmana oraz Hołdy. Wybierając jeden z nich, użytkownik wpisuje odpowiednie wartości liczbowe potrzebne do wykonania obliczeń. Na koniec zostaje mu przedstawiony wynik analizy wraz z opisem modelu i legendą. 

### Wybrane screeny z aplikacji
<p align="center">
<img src="https://raw.githubusercontent.com/maugosch/mobilki/master/screenshots/2.png"/><br>
<img src="https://raw.githubusercontent.com/maugosch/mobilki/master/screenshots/3.png"/><br>
<img src="https://raw.githubusercontent.com/maugosch/mobilki/master/screenshots/4.png"/><br>
<img src="https://raw.githubusercontent.com/maugosch/mobilki/master/screenshots/5.png"/><br>
<img src="https://raw.githubusercontent.com/maugosch/mobilki/master/screenshots/9.png"/><br>
</p>
