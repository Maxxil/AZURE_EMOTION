********************************************************************************
*			Azure Emotion IOT 				       *
********************************************************************************

Indispensable:
	- JDK 8 install�
	- Neatbeans ou Eclipse install�
	- JavaFX install�

Avant de commencer:
	- Ouvrir IotHubDevice.java (AZURE_EMOTION\src\iothubazure\IotHubDevice.java)
	- Ajouter la chaine de connection � l'IotHub

!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
!		Si la chaine de connection n'est pas ajout�     	           !
!		Plus probl�mes seront pr�sents					   !
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

	-Ouvrir IotHubConnection.java
	-Ajouter l'HostName de l'Iot Hub

!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
!		Si la chaine de connection n'est pas ajout�     	           !
!		Plus probl�mes seront pr�sents					   !
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

	- Ajouter un device si aucun ne s'affiche
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
!		Si aucun device est ajout�. Erreur				   !
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

	- Tester TextAnalytics:
		* Choisir un device dans la liste et appuyer sur OK.
		* Dans la liste des objets � droite des choix, appuyer sur TextAnalytics
		* Ins�rer un texte � analyser
		* Appuyer sur valider et attendre
	
	- Emotion Recognition:
		* Choisir un device dans la liste et appuyer sur OK.
		* Dans la liste des objets � droite des choix, appuyer sur Emotion Recognition
		* Le lien d'une image � analyser
		* Appuyer sur valider et attendre

	- Reception de message:
		* Si l'IotHub envoie un message � un device, le message s'affichera dans la console

Point important:
	- Utilisation du protocole MQTT. Il y a des bugs avec AMQP
	- Impossible d'afficher les messages recus par le device dans l'onglet adapt�