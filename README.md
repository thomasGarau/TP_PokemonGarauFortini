Fonction du jeu :
 
Le programme se lance dans le fichier jeu
au démarrage celui-ci propose soit de chargé une sauvegarde soit de créer une nouvelle partie
 
si vous choisissez de faire une nouvelle partie le jeux vous permettra de créer un personnage comme dans un jeux pokemon :
choix du sexe du nom du pokemon de départ
 
une fois la création ou le chargement du personnage finit le jeu se déroule dans une boucle while(true) qui s'arrête lorsque vous décidez de quitter
 
dans cette boucle le jeu se déroule par tour (un tour une itération) dans lequel vous avez 7 possibilité d'actions :
 
marcher qui revient à marcher dans les hautes herbes dans un jeu Pokémon. A chaque fois que vous marchez vous avez une chance sur trois de tomber sur un pokemon sauvage ce qui lanceras alors un combat qui se dérouleras au toure par toure le joueur pouvant à chaque tours soit attaquer soit lancer une pokéball soit fuire, le pokémon sauvage répondras par une attaque automatique (un random dans la liste de c'est compétence).
 
effectuer un combat dans l'arène : lorsque deux joueur seront connectés à l'arène cela gêneras un combat au tour par tour entre les deux pokémon compagnon du joueur
 
faire évoluer un pokémon si le dresseur a au moins 2 bonbon du même nom que le pokémon
 
changé son pokémon compagnon : le pokémon compagnon étant le pokémon envoyé par défaut dans les combat en arène et contre des pokémon sauvage
 
effectuer une sauvegarde (qui sérialiser l'objet dresseur dans le fichier sauvegarde.txt)
nb: effectuer une sauvegarde écrase toute sauvegarde précédente il n'est donc pas possible d'avoir plus partie.
 
quitter la partie ce qui couperas le programme.
 
nB :
les combat sont des combat 1 pokémon contre 1
lorsque le joueur décide d'attaquer un pokémon il choisit la compétence qu'il utilise (les compétence ne possède pas de "pp" ni de dégât)
les dégat sont calculé à partir de l'élément de l'attaque est du ou des élément du pokémon cible et des pc du pokémon
 
Donner un bonbon à un pokémon pouvant évoluer revient à le faire évoluer
un pokémon qui évolue change de nom gagne des stats et peut gagner un nouveau type
 
 
Fonctionnement instanciation des pokémon :
 
Au démarrage du jeu un objet pokédex est instancié. Dans celui-ci l'ensemble des pokémon 1er évolution de la 1er génération sont instancié avec un minimum d'attributs
nom liste des porchaine evo s' il en possède liste des prochain type si son évolution lui feras gagner un type
liste de compétence avec une attaque de type normale + une attaque par type qu'il possède
c'est pokémon instancier dans dans le pokédex ne seront pas utilisé ils sont des sorte de moules de pokémon réellement utilisé.
Les pokémon sont générés dans la classe capture il sont générés de manière aléatoire sans tenir compte de la rareté du pokémon en faisant une copie d'une instance de "pokémon moule". Au attribut de la copy seras ajouté le dresseur le surnom que le joueur lui attribue ainsi que des pc et pv générer de manière aléatoire.
 
fonctionnement Arène :
Attention de lancé une instance de serveur avant de tenter de combattre 

Lorsqu'un client décide de combattre cela génère une instance tcpClient (un thread dans le client) et de Serveur Client Thread (le thread associé au client dans le serveur) qui lui permettra de communiquer avec le serveur. Le client est ensuite dans l'attente d'un autre joueur pour que le combat commence.
le serveur dans la classe multithreaded SOcketServer ajouté le client dans la liste d'attente de l'arène
dès que celle-ci contient deux joueurs elle lance le combat les deux. Le serveur détermine au hasard le premier joueur et communique au deux client leur ordre
Les clients exécutent ensuite les fonctions combat 1 et combat 2 en fonction de leurs ordres. Cette fonction se déroule au tour par tour où chaque joueur choisit une attaque, calcule les dégâts infligés et les envoie au serveur pour que celui-ci transmette le résultat à l'autre client. Puis le 1 client attend les dégâts qu'il reçoit du second.
 
nB les pv des pokémon sont des copy stockés dans une variable locale des fonction de combat dans le TCP client.
dès que les pv d'un pokémon tombe à 0 le combat s'arrête.
A la fin du combat le vainqueur reçoit un bonbon du type du pokémon qui a combattu.