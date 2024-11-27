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
import java.util.List;

//import java.sql.Connection;

public class ProductDAO {
    final private Connection con;

    public ProductDAO(Connection con){
        this.con=con;
    }

    public List<Product> listAssociatedProducts(Agreement a){
        ArrayList<Product> resultList= new ArrayList<>();
        System.out.println(a);
        try(

            PreparedStatement listingQuery= con.prepareStatement("Select * from Product where parent_productid = ?");

            ){
            listingQuery.setInt(1,a.getProductID());
            ResultSet rs=listingQuery.executeQuery();

            while(rs.next()){
                resultList.add(new Product(rs.getInt("productid"),
                            rs.getString("name"),
                            rs.getDouble("price"),
                            rs.getInt("parent_productid")));
            }

        }
        catch(SQLException sqle){
            System.out.println("SQL Exception while listing");
            sqle.printStackTrace();
        }
        for(Product p : resultList){
            System.out.println(p);
        }
        return  resultList;
    }

    public boolean save(Product prod){



        return false;
    }
}
