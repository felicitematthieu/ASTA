```3.1. Informations de connexion :
- LOGIN : marie.lefebvre@asta-education.fr
- MOT DE PASSE : 1234

3.2. Informations relatives à l’outillage :
- IDE UTILISÉ : IntelliJ
- SGBD CHOISI : MariaDB 10.4.32
- Script SQL pour recréer les tables : bd.sql

3.3. Informations utiles pour lancer et tester l’application :
- Se rendre sur la page : http://localhost:8080/login
- Entrer le LOGIN et le MOT DE PASSE
- L'utilisateur est redirigé ensuite sur la page : http://localhost:8080/home pour naviguer


3.4. Questions :

a. On souhaite attirer l’attention du correcteur sur notre respect de l'architecture qui est similaire à ce qu’on a vu en cours ainsi que le style d’écriture.

b. L’une des plus grandes difficultés rencontrées est que l’on a d’abord créé une base de données initiale en prenant en compte le tableau affiché dans le sujet sauf qu’en avançant dans notre programme, on réalise que celui-ci n’est pas forcément complet et on a donc dû la recréer. Cela a fait que l’on a également eu des soucis de versioning pour certains d’entre nous car, la répartition de notre travail fait que certains des membres ont été plus impactés que d’autres. On a donc dû faire de grosses modifications.

c. Pour la répartition des tâches et des rôles, nous avons fait cela en fonction des facilités, difficultés et préférences de chacun. Patricia s’est occupée de la création de la base de données ainsi que l’ajout d’un apprenti et la création d’une année académique. Matthieu a réalisé toute la partie 1 concernant le login, l’affichage du tableau de bord synthétique avec la liste des apprentis ainsi que la fonction de recherche. Ammara a fait la partie détail des informations liées aux apprentis ainsi que la modification des champs.
Dans l’ensemble du projet, nous nous sommes beaucoup entraidés et sommes intervenus sur toutes les parties.

d.Les 3 points à retenir de ce cours et du projet sont :
- l’utilisation de JPA : on se rend compte que l’on code plus vite étant donné que nous n’avons plus à écrire nous-même les requêtes SQL
- l’injection de dépendances avec Spring Boot
- le patron MVC, étant donné que nous avons utilisé cette architecture là pour le projet

e. La fonctionnalité que nous n’avons pas eu le temps de réaliser est l’ajout d’apprenti via l’import de données car nous avons perdu beaucoup de temps à refaire la base de données et adapter le code en conséquence aux changements effectués.

f. Les principes SOLID au sein de notre projet :
- Principe Ouvert / Fermé (OCP) : on a partiellement respecté car les entités JPA et les Repository sont faciles à étendre via Spring Data. Cependant, les changements effectués sur la base de données ont forcé des modifications dans plusieurs classes.
- Ségrégation d’interface (ISP) : on a partiellement respecté car les Repository Spring Data sont spécifiques et légers. On a cependant certaines interfaces de service qui sont trop larges.
- Principe d’inversion des dépendances (DIP) : on a bien respecté car on a injecté les dépendances spring, les contrôleurs dépendent d’interfaces.
```
