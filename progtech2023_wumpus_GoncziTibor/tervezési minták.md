# MVC (Model-View-Controller) Mintája:

Az MVC egy tervezési minta, amelyet gyakran használnak szoftvertervezés során. Ezt a mintát általában három fő részre osztják:

**1. Modell (Model):** A modell felelős az adatok és az üzleti logika kezeléséért. Ide tartoznak az adatstruktúrák, adatbázisinterakciók és minden olyan dolog, ami a program üzleti logikájához kapcsolódik.

**2. Nézet (View):** A nézet a felhasználói felületet és annak megjelenítését kezeli. Ez foglalkozik a felhasználóval való kommunikációval és a megjelenítési logikával.

**3. Vezérlő (Controller):** A vezérlő kapcsolatot teremt a modell és a nézet között. Ezen keresztül érkeznek a felhasználói inputok a rendszerbe, és a vezérlő felelős a megfelelő modell és nézet műveletek meghívásáért.

Az MVC segít a kód szétválasztásában és könnyebb karbantarthatóságban, mivel a különböző felelősségi területeket elkülönítve kezeli.

### Más Tervezési Minták:

##### 1. Singleton Minta:
* Egyetlen példányt engedélyez egy adott osztályból. 
* Biztosítja, hogy egy adott osztályból csak egy példány létezzen, és egy központi ponton érhető el.

##### 2. Observer Minta:

* Egy objektum változásairól értesíti és frissíti azokat, akik az állapotára kíváncsiak.
* Segíti az objektumok közötti kommunikációt és függőségek kezelését.

##### 3. Factory Minta:

* Az objektum létrehozását szolgálja, de elrejti az objektum készítésének részleteit.
* Különféle típusú objektumok létrehozását könnyíti meg egy közös interfész alapján.

##### 4. Strategy Minta:

* Lehetővé teszi egy algoritmus cseréjét anélkül, hogy befolyásolná a kliens használatát.
* Az egyes algoritmusokat elkülöníti, és dinamikusan cserélhetővé teszi őket.

Ezek a tervezési minták segíthetnek a kód tisztábbá tételében, újrafelhasználhatóságban és a fejlesztési folyamatok javításában a szoftvertervezés során.