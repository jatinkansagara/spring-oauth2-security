CREATE TABLE `oauth_access_token` (
  `token_id` varchar(255) default NULL,
  `token` mediumblob,
  `authentication_id` varchar(255) NOT NULL,
  `user_name` varchar(255) default NULL,
  `client_id` varchar(255) default NULL,
  `authentication` mediumblob,
  `refresh_token` varchar(255) default NULL,
  PRIMARY KEY  (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `oauth_approvals` (
  `userId` varchar(255) default NULL,
  `clientId` varchar(255) default NULL,
  `scope` varchar(255) default NULL,
  `status` varchar(10) default NULL,
  `expiresAt` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `lastModifiedAt` timestamp NOT NULL default '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `oauth_client_details` (
  `client_id` varchar(255) NOT NULL,
  `resource_ids` varchar(255) default NULL,
  `client_secret` varchar(255) default NULL,
  `scope` varchar(255) default NULL,
  `authorized_grant_types` varchar(255) default NULL,
  `web_server_redirect_uri` varchar(255) default NULL,
  `authorities` varchar(255) default NULL,
  `access_token_validity` int(11) default NULL,
  `refresh_token_validity` int(11) default NULL,
  `additional_information` varchar(4096) default NULL,
  `autoapprove` varchar(255) default NULL,
  PRIMARY KEY  (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `oauth_client_details` (`client_id`,`resource_ids`,`client_secret`,`scope`,`authorized_grant_types`,`web_server_redirect_uri`,`authorities`,`access_token_validity`,`refresh_token_validity`,`additional_information`,`autoapprove`) VALUES 
 ('test','test123','123456789','read,write,trust','password,authorization_code,refresh_token,implicit',NULL,NULL,600,600,'{}','READ');

CREATE TABLE `oauth_client_token` (
  `token_id` varchar(255) default NULL,
  `token` mediumblob,
  `authentication_id` varchar(255) NOT NULL,
  `user_name` varchar(255) default NULL,
  `client_id` varchar(255) default NULL,
  PRIMARY KEY  (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `oauth_code` (
  `code` varchar(255) default NULL,
  `authentication` mediumblob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(255) default NULL,
  `token` mediumblob,
  `authentication` mediumblob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `role` (
  `id` int(10) NOT NULL auto_increment,
  `name` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `role` (`id`,`name`) VALUES 
 (1,'ROLE_USER'),
 (2,'ROLE_ADMIN'),
 (3,'ROLE_GUEST');
 
 CREATE TABLE `user` (
  `id` int(10) NOT NULL auto_increment,
  `name` varchar(100) default NULL,
  `login` varchar(100) default NULL,
  `password` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `user` (`id`,`name`,`login`,`password`) VALUES 
 (1,'admin,'admin,'secret123'),
 (2,'guest,'guest','guest123');
 
 
 CREATE TABLE `user_role` (
  `user_id` int(10) default NULL,
  `role_id` int(10) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `user_role` (`user_id`,`role_id`) VALUES 
 (1,1),
 (2,2);