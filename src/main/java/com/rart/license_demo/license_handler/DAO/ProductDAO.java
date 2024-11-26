package com.rart.license_demo.license_handler.DAO;

import com.rart.license_demo.license_handler.factory.ConnectionFactory;
import com.rart.license_demo.license_handler.model.Agreement;
import com.rart.license_demo.license_handler.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

//import java.sql.Connection;

public class ProductDAO {
    final private Connection con;

    public ProductDAO(Connection con){
        this.con=con;
    }

    public ArrayList<Product> listAssociatedProducts(Agreement a){

        ArrayList<Product> resultList= new ArrayList<>();
        try{
            PreparedStatement listingQuery= con.prepareStatement("Select * from Product where ? = Product.parent_productid",a.getProductID());
            boolean resultSignal=listingQuery.execute();
            if(resultSignal) {
                ResultSet rs= listingQuery.getResultSet();
                while(rs.next()){
                        break;
                }
            }
        }
        catch(SQLException sqle){

        }

        return  resultList;
    }

    public boolean save(Product prod){



        return false;
    }
}
