# Projet_Kotlin
Dans ce projet j'ai créé un application qui permet de créer et connecter des utilisateurs afin d'afficher une liste d'éléphants. Pour cela j'ai utilisé ROOM comme base de données pour mes utilisateurs et un API pour la liste d'éléphants.

Le code impléméenté répond aux exigence du projet, c'est à dire qu'il contient :
* Implémentation en Kotlin
* Utilisation de la base données ROOM 
* Architecture MVVM
* Clean Architecture 
* Utilisation d'une Api Rest
* Affichage d'une liste
* Une page pour créer un Utilisateur 
* Design

Lorsqu'on lance l'application voici se qui se présente à l'écran :

![alt text](https://github.com/karinamsw/Projet_Kotlin/blob/master/kotlin1.png)

Pour se connecter il faut créer un utilisateur. Si on essaye de se connecter avec un utilisateur qui n'est pas dans la base de données , voici le message d'erreur qui s'affiche :

![alt text](https://github.com/karinamsw/Projet_Kotlin/blob/master/kotlin2.png)

La page pour creer un nouvel utilisateur se présente comme ceci :

![alt text](https://github.com/karinamsw/Projet_Kotlin/blob/master/kotlin3.png)

Si l'utilisateur existe déjà un message d'erreur s'affiche :

![alt text](https://github.com/karinamsw/Projet_Kotlin/blob/master/kotlin4.png)

Au contraire si l'utilisateur n'existe pas , alors il sera creer :

![alt text](https://github.com/karinamsw/Projet_Kotlin/blob/master/kotlin5.png)

Il ne reste plus qu'à se connecter on revenant sur la page de login et alors la liste d'éléphants d'affiche :

![alt text](https://github.com/karinamsw/Projet_Kotlin/blob/master/kotlin6.PNG)


Cette API reférences et affiche une liste de 47 éléphants.
