# Gestionnaire de dépôts et de colis

Application web simple de gestion logistique, composée d’un back-end **Spring Boot** (API REST) et d’un front-end **HTML/CSS/JavaScript**.

Le projet permet de gérer des **dépôts** et des **colis** (création, consultation, modification, suppression) via une interface web connectée à une API Java.

## Objectifs du projet

- Centraliser la gestion des dépôts (nom, adresse, capacité)
- Gérer les colis associés aux dépôts
- Exposer des endpoints REST pour les opérations CRUD
- Fournir une interface web légère pour manipuler les données

## Fonctionnalités présentes

### Côté dépôts
- Lister tous les dépôts
- Consulter un dépôt par ID
- Rechercher un dépôt par nom (`findByNomContaining`)
- Ajouter un dépôt
- Modifier un dépôt
- Supprimer un dépôt

### Côté colis
- Lister tous les colis
- Consulter un colis par ID
- Rechercher un colis par numéro (`findByNumeroContaining`)
- Ajouter un colis
- Modifier un colis
- Supprimer un colis

### Vérification API
- Endpoint de test : `GET /test/hello-world`

## Stack technique

### Back-end (Java)
- **Java 21**
- **Spring Boot 3.2.0**
- **Spring Web** (API REST)
- **Spring Data JPA**
- **MySQL Connector/J 8.0.33**
- **Maven Wrapper** (`mvnw`, `mvnw.cmd`)

### Front-end (HTML/CSS/JS)
- Pages HTML : `index.html`, `depot.html`, `colis.html`
- JavaScript natif intégré dans les pages (appels `fetch` vers `http://localhost:8080`)
- CSS personnalisé : `Front (HTML+JS)/css.css`
- Bootstrap 5.3.2 via CDN

### Répartition des responsabilités
- **Java (Back)** : logique API, persistance, accès base MySQL
- **HTML + JS (Front)** : affichage des listes/formulaires et interactions CRUD
- **CSS** : styles visuels spécifiques (footer, table, etc.)

## Prérequis

- Java **21**
- MySQL (serveur local)
- Navigateur web moderne
- (Optionnel) Maven installé globalement — non obligatoire grâce au wrapper

## Installation et lancement

### 1) Cloner le dépôt

```bash
git clone https://github.com/hichemmezemate/DepotColis.git
cd DepotColis
```

### 2) Initialiser la base de données

Le script SQL est ici :

`Back (Spring)/depotcolis/src/main/java/com/example/depotcolis/sql/depotcolis.sql`

Exemple d’exécution :

```bash
mysql -u root -p < "Back (Spring)/depotcolis/src/main/java/com/example/depotcolis/sql/depotcolis.sql"
```

### 3) Configurer la connexion MySQL

Fichier :

`Back (Spring)/depotcolis/src/main/resources/application.properties`

Configuration actuelle du dépôt :

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/depotcolis
spring.datasource.username=root
spring.datasource.password=
```

Adaptez ces valeurs à votre environnement local si nécessaire.

### 4) Lancer le back-end Spring Boot

Sous Linux/macOS :

```bash
cd "Back (Spring)/depotcolis"
./mvnw spring-boot:run
```

Sous Windows (PowerShell/CMD) :

```powershell
cd "Back (Spring)/depotcolis"
.\mvnw.cmd spring-boot:run
```

API disponible sur : `http://localhost:8080`

### 5) Ouvrir le front-end

Depuis le dossier :

`Front (HTML+JS)/`

ouvrez `index.html` dans votre navigateur (puis navigation vers `depot.html` et `colis.html`).

## Structure du projet

```text
DepotColis/
├── Back (Spring)/
│   └── depotcolis/
│       ├── pom.xml
│       ├── mvnw / mvnw.cmd
│       └── src/
│           ├── main/java/com/example/depotcolis/
│           │   ├── controllers/
│           │   ├── models/
│           │   ├── repositories/
│           │   └── sql/depotcolis.sql
│           ├── main/resources/application.properties
│           └── test/java/com/example/depotcolis/DepotcolisApplicationTests.java
├── Front (HTML+JS)/
│   ├── index.html
│   ├── depot.html
│   ├── colis.html
│   ├── css.css
│   └── images/Logo_DepotColis.png
└── LICENSE
```

## Endpoints API principaux

### Dépôts (`/depot`)
- `GET /depot`
- `GET /depot/{id}`
- `POST /depot/search`
- `POST /depot/depot`
- `PUT /depot/update/{id}`
- `DELETE /depot/delete/{id}`

### Colis (`/colis`)
- `GET /colis`
- `GET /colis/{id}`
- `POST /colis/search`
- `POST /colis/colis`
- `PUT /colis/update/{id}`
- `DELETE /colis/delete/{id}`

## Exemple de parcours utilisateur

1. Ouvrir `index.html`
2. Aller sur **Dépôts** et créer un dépôt
3. Aller sur **Colis**, sélectionner un dépôt dans la liste déroulante, puis créer un colis
4. Modifier ou supprimer un dépôt/colis depuis les boutons d’action du tableau

## Contribution

Les contributions sont les bienvenues.

1. Fork du dépôt
2. Créer une branche (`git checkout -b feature/ma-modification`)
3. Commit (`git commit -m "feat: description"`)
4. Push (`git push origin feature/ma-modification`)
5. Ouvrir une Pull Request

## Licence

Ce projet est distribué sous licence **MIT** (fichier [`LICENSE`](./LICENSE)).
