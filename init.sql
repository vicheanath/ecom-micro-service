-- init.sql

-- Create database if it doesn't exist
CREATE DATABASE IF NOT EXISTS db_user;
CREATE DATABASE IF NOT EXISTS db_order;
CREATE DATABASE IF NOT EXISTS db_cart;
CREATE DATABASE IF NOT EXISTS db_payment;
CREATE DATABASE IF NOT EXISTS db_inventory;
CREATE DATABASE IF NOT EXISTS db_keycloak;
-- Create users and grant permissions
CREATE USER IF NOT EXISTS 'user_db_user'@'%' IDENTIFIED BY 'password_user_db_user';
CREATE USER IF NOT EXISTS 'user_db_order'@'%' IDENTIFIED BY 'password_user_db_order';
CREATE USER IF NOT EXISTS 'user_db_cart'@'%' IDENTIFIED BY 'password_user_db_cart';
CREATE USER IF NOT EXISTS 'user_db_payment'@'%' IDENTIFIED BY 'password_user_db_payment';
CREATE USER IF NOT EXISTS 'user_db_inventory'@'%' IDENTIFIED BY 'password_user_db_inventory';
CREATE USER IF NOT EXISTS 'user_db_keycloak'@'%' IDENTIFIED BY 'password_user_db_keycloak';

GRANT ALL PRIVILEGES ON db_user.* TO 'user_db_user'@'%';
GRANT ALL PRIVILEGES ON db_order.* TO 'user_db_order'@'%';
GRANT ALL PRIVILEGES ON db_cart.* TO 'user_db_cart'@'%';
GRANT ALL PRIVILEGES ON db_payment.* TO 'user_db_payment'@'%';
GRANT ALL PRIVILEGES ON db_inventory.* TO 'user_db_inventory'@'%';
GRANT ALL PRIVILEGES ON db_keycloak.* TO 'user_db_keycloak'@'%';

FLUSH PRIVILEGES;
