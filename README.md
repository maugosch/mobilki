# FinAnalyzer - analizator finansowy

## Twórcy projektu
Małgorzata Graja 166711 KrDZIs3012Io <br>
Małgorzata Kindrat 186824 KrDZIs3012Io <br>
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
- onCreate, która pobiera dane z Firebase i, jeśli dane zostały już wprowadzoen przez użytkownika, automatycznie uzupełnia formularz danymi.
#### 12. PlynnoscFinansowa2
Klasa roszerza klasę AppCompatActivity oraz zawiera metodę:
- onCreate, która wyświetla wyniki obliczeń klasy PlynnoscFinansowa na ekranie.
#### 13. WskaznikiGieldowe
Klasa roszerza klasę AppCompatActivity oraz zawiera metodę:
- służącą do obliczenia wskaźników giełdowych - public void calculate(View view),
- onCreate, która pobiera dane z Firebase i, jeśli dane zostały już wprowadzoen przez użytkownika, automatycznie uzupełnia formularz danymi.
#### 14. WskaznikiGieldowe2
Klasa roszerza klasę AppCompatActivity oraz zawiera metodę:
- onCreate, która wyświetla wyniki obliczeń klasy WskaznikiGieldowe na ekranie.
#### 15. WskaznikRentownosci
Klasa roszerza klasę AppCompatActivity oraz zawiera metodę:
- służącą do obliczenia wskaźnikó rentowności - public void calculate(View view),
- onCreate, która pobiera dane z Firebase i, jeśli dane zostały już wprowadzoen przez użytkownika, automatycznie uzupełnia formularz danymi.
#### 16. WskaznikRentownosci2
Klasa roszerza klasę AppCompatActivity oraz zawiera metodę:
- onCreate, która wyświetla wyniki obliczeń klasy WskaznikRentownosci na ekranie.
#### 17. WskaznikWyplacalnosci
Klasa roszerza klasę AppCompatActivity oraz zawiera metodę:
- służącą do obliczenia wskaźników ywpłacalności - public void calculate(View view),
- onCreate, która pobiera dane z Firebase i, jeśli dane zostały już wprowadzoen przez użytkownika, automatycznie uzupełnia formularz danymi.
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
