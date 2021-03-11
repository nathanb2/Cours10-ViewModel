# Cours11-ViewModel
ViewModel permet de deresponsabiliser le controler de la gestion de ses donnees, desormais le controler gere interaction avec la view et le viewmodel maintient et reclame ou indique une modification a realiser sur les data


Base sur architecture Cours9

Ajout d'un ViewModel (UserViewModel) a l'architecture du Cours9 entre l'activity et le repository:

Dans le cours9 l'Activity avait une variable repository et etait donc charge et d'afficher les donnees et egalement de demander au repository de lui fournir, voir de conserver dans des variables les data que lui fournirait le repository.

Avec le viewModel nous decoupons la responsabilite de l'activity en 2:
- L'activity affiche les donnees ou indique une interaction de l'utilisateur (comme un click qui ajouterait un user a la db)
- Le ViewModel maintient les donnees necessaires a l'activity ou au fragment et les reclame au repository (ou lui indique l'action a faire realiser sur les datas dasn la source de donnees)

- Le vieModel a son propre lifecycle et par exemple il survit a la rotation, si il y a rotation, c'est la meme instance de viewModel qui sera associe a la nouvelle instance de l'activity recree apres la rotation (pour le scope du viewModel voir cours12)


ressources: slide:  https://docs.google.com/presentation/d/1nxbfVW6fEbdUoGfyjv6QuVtOTlN7Mew2zRYBFpMGO6o/edit?usp=sharing
