package com.rart.license_demo.license_handler.DAO;

import java.sql.Connection;

public class AgreementDAO {
    private Connection con;
    AgreementDAO (Connection conexion){
        this.con=conexion;
    }

}
