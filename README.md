## wirtualny-dziekanat

# budowanie
1. Pobranie Oracle11g: https://www.oracle.com/database/technologies/xe-prior-releases.html
2. Zainstalowanie i podanie hasła admin123
3. Sklonowanie repozytorium
4. Otworzenie folderu w IntelliJ
5. Uruchomienie programu
6. Pobranie SQlDeveloper: https://www.oracle.com/tools/downloads/sqldev-downloads.html
7. Utworzenie nowego połączenia:   
>* Name: oracle
>* Username: system
>* Password: admin123
>* Hostname: localhost
>* Port: 1521
>* SID: xe  
8. Utworzenia nowego SQL Worksheet, Tools -> SQL Worksheet  
9. Wklejenie i wykonanie zawartości pliku **kod_tworzenie.txt**  
10. Wklejenie i wykonanie zawartości pliku **insert_sql.txt**  

# Endpointy
w miejsce {zmienna} wstawiamy wartość  
GET localhost:8081/api/studenci  
GET localhost:8081/api/studenci/{id}  
POST localhost:8081/api/studenci  
DELETE localhost:8081/api/studenci/{id}  
PATCH localhost:8081/api/studenci/{id}  
GET localhost:8081/api/studenci/{id}/oceny  
POST localhost:8081/api/studenci/id_studenta}/grupy-zajeciowe/{id_grupy_zajeciowej}  
  

GET localhost:8081/api/dziedziny  
GET localhost:8081/api/dziedziny/{id} 
POST localhost:8081/api/dziedziny
DELETE localhost:8081/api/dziedziny/{id}
PATCH localhost:8081/api/dziedziny/{id} 

  
GET localhost:8081/api/oceny  
GET localhost:8081/api/oceny/{id}  
POST localhost:8081/api/oceny
DELETE localhost:8081/api/oceny/{id}
PATCH localhost:8081/api/oceny/{id}

GET localhost:8081/api/pracownicy  
GET localhost:8081/api/pracownicy/{id}  
POST localhost:8081/api/pracownicy  
DELETE localhost:8081/api/pracownicy/{id}  
PATCH localhost:8081/api/pracownicy/{id}  
  
GET localhost:8081/api/przedmioty  
GET localhost:8081/api/przedmioty/{id}  
POST localhost:8081/api/przedmioty  
DELETE localhost:8081/api/przedmioty/{id}  
PATCH localhost:8081/api/przedmioty/{id} 


GET localhost:8081/api/wydzialy    
GET localhost:8081/api/wydzialy/{id}  
POST localhost:8081/api/wydzialy  
DELETE localhost:8081/api/wydzialy/{id}  
PATCH localhost:8081/api/wydzialy/{id} 
  
GET localhost:8081/api/grupy-zajeciowe      
GET localhost:8081/api/grupy-zajeciowe/{id}    
POST localhost:8081/api/grupy-zajeciowe   
DELETE localhost:8081/api/grupy-zajeciowe/{id}  
PATCH localhost:8081/api/grupy-zajeciowe/{id}  
POST localhost:8081/api/grupy-zajeciowe/{id_grupy_zajeciowej}/przedmioty/{id_przedmiotu}  
POST localhost:8081/api/grupy-zajeciowe/divide-students  
