1- Cloner les 5 appicatiosns ainsi que le fichier docker-compose.yml dans votre workspace a traves le lien github https://github.com/AYMENLACHHEB/GenerateurIdentifiant
2- Mettez vous dans le dossier ou existe le fichier docker-compose.yml et lancer la bdd avec la commande docker-compose up -d
3- Lancer les 5 applications dans cet ordre :
    1 - config-server
    2 - discovery-server
    3 - api-gatway
    4 - ms-configuration-criteres
    5 - ms-generation-numero
4- Lancer zipkin avec la commande docker run -d -p 9411:9411 openzipkin/zipkin:latest
5- Tester les api a travers http://localhost:8282/swagger-ui/index.html#/Identifiant/recupererToutNumeros et http://localhost:8181/swagger-ui/index.html#/Identifiant/majCriteria
6- Vous pouvez regarder les videos pour mieux manipuler l'application et les api

