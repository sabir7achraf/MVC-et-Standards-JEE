-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le : mer. 27 nov. 2024 à 22:00
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `atelier1`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `tele` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `name`, `prenom`, `tele`) VALUES
(2, 'frankie', 'JUBA', 78744451),
(152, 'achraf', 'sabir', 221445844),
(252, 'Jean Dupont', 'Développeur', 102102),
(452, 'evan', 'pobri', 64211475),
(552, 'evan', 'probi', 0),
(602, 'evan', 'probi', 0),
(652, 'evan', 'probi', 0);

-- --------------------------------------------------------

--
-- Structure de la table `client_commande`
--

CREATE TABLE `client_commande` (
  `Client_id` bigint(20) NOT NULL,
  `commandes_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `client_seq`
--

CREATE TABLE `client_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `client_seq`
--

INSERT INTO `client_seq` (`next_val`) VALUES
(751);

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `id` bigint(20) NOT NULL,
  `date_commande` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `numCmd` bigint(20) NOT NULL,
  `client_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id`, `date_commande`, `description`, `numCmd`, `client_id`) VALUES
(2, '2024-11-27 00:15:51', 'une test pour valider notre commande ', 124, 252),
(52, '2024-11-21 00:00:00', 'yarbi ysd9 hadshi ', 0, 152),
(302, '2024-11-27 15:57:16', 'uneCommande contient 2 produit  ', 124, 452),
(352, '2024-11-29 00:00:00', 'commade de si hamza (ps5) ,rabat ', 0, 2),
(402, '2024-11-27 21:19:58', 'uneCommande contient 2 produit  ', 124, 552),
(452, '2024-11-27 21:37:20', 'uneCommande contient 2 produit  ', 124, 602),
(502, '2024-11-27 21:39:47', 'uneCommande contient 2 produit  ', 124, 652);

-- --------------------------------------------------------

--
-- Structure de la table `commande_lignedecommande`
--

CREATE TABLE `commande_lignedecommande` (
  `Commande_id` bigint(20) NOT NULL,
  `lignedeCommande_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `commande_lignedecommande`
--

INSERT INTO `commande_lignedecommande` (`Commande_id`, `lignedeCommande_id`) VALUES
(302, 4),
(302, 5),
(402, 6),
(402, 7),
(452, 8),
(452, 9),
(502, 10),
(502, 11);

-- --------------------------------------------------------

--
-- Structure de la table `commande_produit`
--

CREATE TABLE `commande_produit` (
  `Commande_id` bigint(20) NOT NULL,
  `produits_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `commande_seq`
--

CREATE TABLE `commande_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `commande_seq`
--

INSERT INTO `commande_seq` (`next_val`) VALUES
(601);

-- --------------------------------------------------------

--
-- Structure de la table `lignedecommande`
--

CREATE TABLE `lignedecommande` (
  `id` bigint(20) NOT NULL,
  `prixUnitaire` double NOT NULL,
  `quantite` int(11) NOT NULL,
  `commande_id` bigint(20) DEFAULT NULL,
  `produit_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `lignedecommande`
--

INSERT INTO `lignedecommande` (`id`, `prixUnitaire`, `quantite`, `commande_id`, `produit_id`) VALUES
(1, 900, 2, NULL, 152),
(2, 900, 2, NULL, 202),
(4, 900, 2, NULL, 302),
(5, 300, 1, NULL, 303),
(6, 900, 2, NULL, 352),
(7, 300, 1, NULL, 353),
(8, 900, 2, NULL, 402),
(9, 300, 1, NULL, 403),
(10, 900, 2, NULL, 452),
(11, 300, 1, NULL, 453);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `numProduit` varchar(255) DEFAULT NULL,
  `price` float NOT NULL,
  `lignedeCommandes_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id`, `description`, `numProduit`, `price`, `lignedeCommandes_id`) VALUES
(104, 'nouveau edition ,frech, rapide', 'velo', 710, NULL),
(152, 'a7sen produit f les produit dyoul mirikan ', 'pikolo', 900, NULL),
(202, 'a7sen produit f les produit dyoul mirikan ', 'pikolo', 900, NULL),
(302, 'a7sen produit f les produit dyoul mirikan ', 'pikolo', 900, NULL),
(303, 'ahsen produit 2', 'produit2', 300, NULL),
(352, 'a7sen produit f les produit dyoul mirikan ', 'pikolo', 900, NULL),
(353, 'ahsen produit 2', 'produit2', 300, NULL),
(402, 'a7sen produit f les produit dyoul mirikan ', 'pikolo', 900, NULL),
(403, 'ahsen produit 2', 'produit2', 300, NULL),
(452, 'a7sen produit f les produit dyoul mirikan ', 'pikolo', 900, NULL),
(453, 'ahsen produit 2', 'produit2', 300, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `produit_lignedecommande`
--

CREATE TABLE `produit_lignedecommande` (
  `Produit_id` bigint(20) NOT NULL,
  `lignedeCommandes_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `produit_seq`
--

CREATE TABLE `produit_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `produit_seq`
--

INSERT INTO `produit_seq` (`next_val`) VALUES
(551);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `client_commande`
--
ALTER TABLE `client_commande`
  ADD UNIQUE KEY `UK_g4j7v8973emq390de7ibb1lbq` (`commandes_id`),
  ADD KEY `FKjm28217v3gcn1gtrsbp1xoqvw` (`Client_id`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKvulim1yo1bvjsxck8kblj7mu` (`client_id`);

--
-- Index pour la table `commande_lignedecommande`
--
ALTER TABLE `commande_lignedecommande`
  ADD UNIQUE KEY `UK_bjd7top4i0klk2u81sx99nqx5` (`lignedeCommande_id`),
  ADD KEY `FKbik7i413s2owfb3t11xl16jb` (`Commande_id`);

--
-- Index pour la table `commande_produit`
--
ALTER TABLE `commande_produit`
  ADD KEY `FK7177t2pnnp1fe6kfi4llqke4c` (`produits_id`),
  ADD KEY `FK1y1y9ycbessavo0j7025whnff` (`Commande_id`);

--
-- Index pour la table `lignedecommande`
--
ALTER TABLE `lignedecommande`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmaemmfgfo3qj1vs4te0vph4ai` (`commande_id`),
  ADD KEY `FK7b19h4jdnn2xh300jgif4ol3r` (`produit_id`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5aodmdwb5f341spjgd28qcfer` (`lignedeCommandes_id`);

--
-- Index pour la table `produit_lignedecommande`
--
ALTER TABLE `produit_lignedecommande`
  ADD KEY `FK1jdei3keeu6m05ob1xdrcb0re` (`lignedeCommandes_id`),
  ADD KEY `FKdc6qhseni85e4ysj8e81dmy4l` (`Produit_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `lignedecommande`
--
ALTER TABLE `lignedecommande`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `client_commande`
--
ALTER TABLE `client_commande`
  ADD CONSTRAINT `FKbki6xdbd8jpyh4ty9n2y8dfia` FOREIGN KEY (`commandes_id`) REFERENCES `commande` (`id`),
  ADD CONSTRAINT `FKjm28217v3gcn1gtrsbp1xoqvw` FOREIGN KEY (`Client_id`) REFERENCES `client` (`id`);

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `FKvulim1yo1bvjsxck8kblj7mu` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`);

--
-- Contraintes pour la table `commande_lignedecommande`
--
ALTER TABLE `commande_lignedecommande`
  ADD CONSTRAINT `FK8isxihxfxiyp8d756fj5nh8ws` FOREIGN KEY (`lignedeCommande_id`) REFERENCES `lignedecommande` (`id`),
  ADD CONSTRAINT `FKbik7i413s2owfb3t11xl16jb` FOREIGN KEY (`Commande_id`) REFERENCES `commande` (`id`);

--
-- Contraintes pour la table `commande_produit`
--
ALTER TABLE `commande_produit`
  ADD CONSTRAINT `FK1y1y9ycbessavo0j7025whnff` FOREIGN KEY (`Commande_id`) REFERENCES `commande` (`id`),
  ADD CONSTRAINT `FK7177t2pnnp1fe6kfi4llqke4c` FOREIGN KEY (`produits_id`) REFERENCES `produit` (`id`);

--
-- Contraintes pour la table `lignedecommande`
--
ALTER TABLE `lignedecommande`
  ADD CONSTRAINT `FK7b19h4jdnn2xh300jgif4ol3r` FOREIGN KEY (`produit_id`) REFERENCES `produit` (`id`),
  ADD CONSTRAINT `FKmaemmfgfo3qj1vs4te0vph4ai` FOREIGN KEY (`commande_id`) REFERENCES `commande` (`id`);

--
-- Contraintes pour la table `produit`
--
ALTER TABLE `produit`
  ADD CONSTRAINT `FK5aodmdwb5f341spjgd28qcfer` FOREIGN KEY (`lignedeCommandes_id`) REFERENCES `lignedecommande` (`id`);

--
-- Contraintes pour la table `produit_lignedecommande`
--
ALTER TABLE `produit_lignedecommande`
  ADD CONSTRAINT `FK1jdei3keeu6m05ob1xdrcb0re` FOREIGN KEY (`lignedeCommandes_id`) REFERENCES `lignedecommande` (`id`),
  ADD CONSTRAINT `FKdc6qhseni85e4ysj8e81dmy4l` FOREIGN KEY (`Produit_id`) REFERENCES `produit` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
