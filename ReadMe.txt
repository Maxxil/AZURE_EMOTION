********************************************************************************
*			Azure Emotion IOT 				       *
********************************************************************************

Indispensable:
	- JDK 8 installé
	- Neatbeans ou Eclipse installé
	- JavaFX installé

Avant de commencer:
	- Ouvrir IotHubDevice.java (AZURE_EMOTION\src\iothubazure\IotHubDevice.java)
	- Ajouter la chaine de connection à l'IotHub

!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
!		Si la chaine de connection n'est pas ajouté     	           !
!		Plus problèmes seront présents					   !
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

	-Ouvrir IotHubConnection.java
	-Ajouter l'HostName de l'Iot Hub

!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
!		Si la chaine de connection n'est pas ajouté     	           !
!		Plus problèmes seront présents					   !
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

	- Ajouter un device si aucun ne s'affiche
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
!		Si aucun device est ajouté. Erreur				   !
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

	- Tester TextAnalytics:
		* Choisir un device dans la liste et appuyer sur OK.
		* Dans la liste des objets à droite des choix, appuyer sur TextAnalytics
		* Insérer un texte à analyser
		* Appuyer sur valider et attendre
	
	- Emotion Recognition:
		* Choisir un device dans la liste et appuyer sur OK.
		* Dans la liste des objets à droite des choix, appuyer sur Emotion Recognition
		* Le lien d'une image à analyser
		* Appuyer sur valider et attendre

	- Reception de message:
		* Si l'IotHub envoie un message à un device, le message s'affichera dans la console

Point important:
	- Utilisation du protocole MQTT. Il y a des bugs avec AMQP
	- Impossible d'afficher les messages recus par le device dans l'onglet adapté