DELIMITER $$
CREATE PROCEDURE In_OutSP(IN Var_Id INTEGER, IN Var_Name VARCHAR(50),IN Var_City VARCHAR(50),In Var_Age Integer)
BEGIN
Select City into Var_CITY From emp where ID=VarId;
COMMIT;
END$$
DELIMITER ;
