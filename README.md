
## 1. Fonctionnement : 

![Fonctionnement schéma](https://github.com/AbdelhamidLarachi/rapid_sms/blob/master/fonctionnement.png?raw=true)

Pour limiter et bien gérer les ressources de notre service sms, on doit implémenter l’interface ValueEventListener, qui offre la méthode onDataChange, qui exécute un listener qui a pour mission de capturer chaque changement en base de données, pour pouvoir utiliser cette interface, on doit utiliser firebase. 

Une fois il détecte un changement, il récupère les nouvelles données (code et numéro de téléphone), le message envoyé peut avoir jusqu’à 160 caractères,  le numéro de téléphone doit correspondre au numéro algérien, commence par +213 / 00213 / 0 ensuite 5 / 6 / 7 plus les 9 numéros, si tout est correct, il envoie le sms, et retourne à son mode d’écoute. 

L’application n’as pas d’interface graphique, tout tourne en arrière-plan, et afin de faire ça, nous avons utilisé la classe IntentService qui fournit une structure simple pour exécuter une opération sur un seul thread d'arrière-plan. Cela lui permet de gérer des opérations de longue durée sans affecter la réactivité de l’ interface utilisateur. 

## 2. Diagramme de classe :

![Diagramme de classe](https://github.com/AbdelhamidLarachi/rapid_sms/blob/master/clasDiagramJavaPNG.png?raw=true)

## 3. Choix des Technologies :

  ###### - Android studio :
  Android Studio est un environnement de développement pour développer des applications mobiles Android. Il est basé sur IntelliJ IDEA et utilise le moteur de production Gradle. Utilisé pour des test de de simulation pour l’application en Android ainsi que le service SMS qui a été codé sous Android studio en utilisant Java et Firebase.
  
 ###### - Java :
  Java est un langage de programmation à usage général basé sur des classes, orienté objet, Le meilleur environnement pour un service mobile SMS, est Android, à cause de sa politique des permissions, qui nous permet d’envoyer des sms via le mobile, et choisir l’opérateur approprié et de pouvoir gérer les ressources en utilisant un intente-service dans l’arrière-plan.
  
  ###### - Firebase :
  est une base de données en temps réel, hébergée dans le cloud. Les données sont stockées au format JSON et synchronisées en temps réel avec chaque client connecté. Lorsque vous créez des applications multiplates-formes avec des SDK iOS, Android et JavaScript, tous les clients partagent une instance de base de données en temps réel et reçoivent automatiquement des mises à jour avec les données les plus récentes.
