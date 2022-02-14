CREATE TABLE `Persona` (
  `id_Persona` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `birthday` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `timestamp_register` datetime DEFAULT NULL,
  `timestamp_update` datetime DEFAULT NULL,
  `idUser` int NOT NULL,
  PRIMARY KEY (`id_Persona`),
  KEY `idUser` (`idUser`),
  CONSTRAINT `Persona_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `User` (`id_User`)
)

CREATE TABLE `Product` (
  `id_Product` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `trademark` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `price` double(13,2) DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `timestamp_register` datetime DEFAULT NULL,
  `timestamp_update` datetime DEFAULT NULL,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id_Product`)
)

CREATE TABLE `Sale` (
  `id_Sale` varchar(50) NOT NULL,
  `idUser` int NOT NULL,
  `timestamp_register` datetime DEFAULT NULL,
  `status` tinyint DEFAULT NULL,
  PRIMARY KEY (`id_Sale`),
  KEY `Sale_ibfk_1` (`idUser`),
  CONSTRAINT `Sale_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `User` (`id_User`)
)

CREATE TABLE `sale_Detail` (
  `id_SaleDetail` int NOT NULL AUTO_INCREMENT,
  `idProduct` int NOT NULL,
  `idSale` varchar(50) NOT NULL,
  `units` int NOT NULL,
  `unitPrice` double(13,2) NOT NULL,
  `timestamp_register` datetime NOT NULL,
  `timestamp_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id_SaleDetail`),
  KEY `idProduct` (`idProduct`),
  KEY `FK_Sale` (`idSale`),
  CONSTRAINT `FK_Sale` FOREIGN KEY (`idSale`) REFERENCES `Sale` (`id_Sale`),
  CONSTRAINT `sale_Detail_ibfk_1` FOREIGN KEY (`idProduct`) REFERENCES `Product` (`id_Product`)
)

CREATE TABLE `User` (
  `id_User` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `timestamp_register` datetime DEFAULT NULL,
  `timestamp_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id_User`)
)

CREATE DEFINER=`root`@`%` PROCEDURE `sp_autentication`(
in _username varchar(50),
in _password varchar(50)
)
Begin 
	Select U.id_User, username, P.id_Persona, firstname, lastname, email
    From User AS U
    Inner Join Persona As P
    ON U.id_User = P.idUser
    Where username=_username and password=_password;
END


CREATE DEFINER=`root`@`%` PROCEDURE `sp_buyCarINSERT`(
in user int,
in idProduct int
)
begin
	INSERT INTO BuyCar(idUser,timestamp_register) VALUES (user,current_timestamp());
    set@idbuyCar=(select last_insert_id());
    INSERT INTO detalleBuyCar(idProduct,idBuyCar,timestamp_register)Values(idProduct,@idbuyCar,current_timestamp());
end

CREATE DEFINER=`root`@`%` PROCEDURE `sp_productINSERT`(
in name varchar(50),
in trademark varchar(50),
in description varchar(50),
in price double(13,2),
in stock int
)
begin
	insert into Product(name,trademark,description,price,stock,timestamp_register) values(name,trademark, description, price, stock, current_timestamp());
end

CREATE DEFINER=`root`@`%` PROCEDURE `sp_productLIST`()
begin
	SELECT id_Product,name,trademark,description,price,stock,timestamp_register FROM Product WHERE status=1;
end

CREATE DEFINER=`root`@`%` PROCEDURE `sp_registerUserNEW`(
in username varchar(50),
in password varchar(50),
in firstname varchar(50),
in lastname varchar(50),
in birthday varchar(50),
in email varchar(50)
)
begin
	INSERT INTO User(username,password,timestamp_register) Values (username,password,current_timestamp());
    set @idUser=(select last_insert_id());
    INSERT INTO Persona(firstname,lastname,birthday, email, timestamp_register, idUser) Values (firstname,lastname,birthday, email, current_timestamp(), @idUser);
end

CREATE DEFINER=`root`@`%` PROCEDURE `sp_reportSalesByClient`(
in _idCustomer int
)
BEGIN
		set @IGV= 1.18;
        create temporary table if not exists tbl_View(
        idSale Varchar(50),
        register_date datetime,
        quantity int,
        subtotal double(13,2),
        igv double(13,2),
        total double(13,2)
        );
        
        Create temporary table if not exists tbl_Sales AS (
			select id_Sale, timestamp_register
            From Sale
            Where idUser = _idCustomer

        );
		
                    
		Set @countSales = (select COUNT(*)From tbl_Sales);
        
        while @countSales > 0 do
			set @total=0;
            set @subtotal=0;
            set @quantity=0;
            
            select id_Sale, timestamp_register from tbl_Sales limit 1 into @idsale, @register_datetime;
            
            Create temporary table if not exists tbl_Detail AS (
				select id_SaleDetail, units, unitPrice
                from sale_Detail
                where idSale = @idsale
            );
            
            set @countDetail =(Select count(*)from tbl_Detail);
            set @quantity = (select SUM(units) From tbl_Detail);
            While @countDetail >0 do
				
                select id_SaleDetail, units, unitPrice from tbl_Detail limit 1 into @idsaledetail, @unit, @unitPrice;
				
                set @subtotal= @subtotal+(@unit * @unitPrice);
                
                Delete from tbl_Detail where id_SaleDetail= @idsaledetail;
				set @countDetail= @countDetail -1;
            End while;
            
            set @total = @subtotal*@IGV;
            
            insert into tbl_View(idSale,register_date,quantity,subtotal, igv, total) 
            values (@idsale, @register_datetime, @quantity, @subtotal, @IGV, @total);
            
            drop temporary table if exists tbl_Detail;
            delete from tbl_Sales where id_Sale = @idSale;
			set @countSales = @countSales -1;
		End while;
        
        select idSale,register_date,quantity,subtotal, igv, total From tbl_View;
        
        Drop temporary table if exists tbl_Sales;
        Drop temporary table if exists tbl_View;
END

CREATE DEFINER=`root`@`%` PROCEDURE `sp_saleDetailget`(
in _idSale varchar(50)
)
BEGIN
	select SD.id_SaleDetail, P.id_Product, P.name, SD.units, SD.unitPrice
    from sale_Detail SD
    Inner Join Product P
    on SD.idProduct=P.id_Product
    where idsale=_idSale;
END

CREATE DEFINER=`root`@`%` PROCEDURE `sp_saledetailregister`(
in _idProduct int,
in _units int,
in _unitPrice double(13,2) ,
in _idSale varchar(50)
)
BEGIN
	INSERT INTO sale_Detail(idProduct, units, unitPrice, timestamp_register, idSale) 
    value (_idProduct, _units, _unitPrice,current_timestamp(), _idSale);
END

CREATE DEFINER=`root`@`%` PROCEDURE `sp_saleregister`(
in _idSale varchar(50),
in _idUser int
)
BEGIN
	INSERT INTO Sale(id_Sale, idUser, timestamp_register, status) 
    value (_idSale,_idUser, current_timestamp(), true);
END