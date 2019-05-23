# Logics
Jeux de logique

1 IMPORTATION DU PROJET : 

	Copier l'url du projet  (https://github.com/superdevsteph/Logics.git) dans Git Repositories
	Clic droit sur la branche master > Import Projects...
	Indiquer le chemin du fichier de configuration (dataConfig.properties) dans la classe PropertyLoader.
	

2 CONFIGURATION DES PARAMETRES DE PROPRIETES DANS LE FICHIER dataConfig.properties : 

	NB_DE_TOURS : 
	Choix du nombre de tour 
	
	codeSize : 
	Choix du nombre de chiffres dans la combinaison
	
	devMode : 
	Activation (ON) ou désactivation (OFF) du mode développeur qui affichera la solution au début du jeu.

3 Run Driver 

	Règle du jeu : Trouver la combinaison secrète en un nombre de tours donné. 
	
	3 modes sont proposés : 
	1 - Mode attaque : Le joueur doit découvrir le code secret de l'ordinateur.
	2 - Mode Défense : Le joueur entre le code secret que l'ordinateur doit découvrir
	3 - Mode duel : Le premier du joueur ou de l'ordinateur à découvrir la combinaison secrète remporte la partie. Le joueur commence.
	
	Après validation de la proposition, le résultat est donné pour chaque chiffre la composant : 
	"-" : signifie que le nombre est inférieur à la proposition.
	"+" : signifie que le nombre est supérieur à la proposition.
	"=" : signifie que le nombre est trouvé.
	