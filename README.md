## Capolavoro 2023-24 Acquafredda-Pice

Questo è il nostro capolavoro, una web app dinamica sviluppata in J2EE. Per la realizzazione abbiamo utilizzato:
- Java
- Html 5
- CSS
- Javascript
- Tomcat 9.0
- MySQLServer Community 8.0
- Crittografia con algoritmo MD5
- Librerie JSTL

Abbiamo scelto questo progetto come capolavoro perchè pensiamo rappresenti a grandi linee il nostro percorso scolastico. Sono stati applicati numerosi argomenti trattati in aula nel corso percorso di studi ad indirizzo informatico.

***

### Come utilizzare la nostra repository
- Scaricare [eclipse](https://www.eclipse.org/downloads/packages/release/kepler/sr2/eclipse-ide-java-ee-developers) versione J2EE
- Scaricare e configurare [Tomcat 9.0](https://tomcat.apache.org/download-90.cgi) su eclipse
- Scaricare ed eseguire [MySQLServer 8.0.36](https://dev.mysql.com/downloads/mysql/)
- Scaricare [connector/J - platform indipendent 8.0.33](https://dev.mysql.com/downloads/connector/j/) e inserirlo nella cartella lib di tomcat
- Scaricare la repository tramite il comando `git clone https://github.com/N0tFr4/capolavoro.git`
- Importare il file _capolavoro.sql_ che si trova nella directory **META-INF** tramite il comando `mysql < capolavoro.sql -u iltuoutente -p`
- Modificare nella directory **WEB-INF** il valore dei context-param _DB_USER_ e _DB_PASS_ contenuti nel file _web.xml_ in base alla propria configurazione di mySQLServer 
- Aggiungere il progetto come risorsa disponibile al server tomcat tramite il tasto `Add and Remove` del server su eclipse
- Andare nel browser e inserire l'URL `http://localhost:8080/capolavoro2/`[^1] e navigare nel sito

***

Se si vuole già ottenere un’anteprima del funzionamento del sito è possibile eseguire l'accesso con i due account admin:
- _user: fraacqua pass: admin_
- _user: frapice pass: admin_

Questi due profili contengono già dei dati inseriti ed è possibile fin da subito osservare il funzionamento del progetto.


[^1]: E' presente il numero 2 perchè ci sono stati più progetti con varie prove
