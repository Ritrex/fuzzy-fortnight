package com.rart.license_demo.license_handler.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rart.license_demo.license_handler.DAO.ProductDAO;
import com.rart.license_demo.license_handler.factory.ConnectionFactory;
import com.rart.license_demo.license_handler.model.Agreement;
import com.rart.license_demo.license_handler.model.AgreementWithProducts;
import com.rart.license_demo.license_handler.model.Product;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.geom.AffineTransform;
import java.io.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("Agreement/")
public class AgreementController {
    private final ObjectMapper om;

    public AgreementController (ObjectMapper om){
        this.om=om;
    }

    @RequestMapping("Agreement/api/{id}")
    public ResponseEntity<String> getAgreement(Integer i){
        //URI uri=new URI(".");
        //ResponseEntity.created(uri);
        //ObjectMapper om=new ObjectMapper();

        ResponseEntity<String> re = new ResponseEntity<>("Error en el servidor",HttpStatusCode.valueOf(500));
        /*
        try{
            //File f=new File(System.getProperty("user.dir"),"Agreement.txt");
            //BufferedWriter bf = new BufferedWriter(new FileWriter(File));


        }catch(IOException ioe){
            re= new ResponseEntity<>("Error en el servidor",HttpStatusCode.valueOf(500))
        }
        */
        return re;
    }

    @PostMapping("save")
    public ResponseEntity<String> saveAgreement(@RequestBody Agreement a){
        System.out.println(a.toJSON());
            File f=new File(System.getProperty("user.dir"),"Agreement"+a.getAgreementID()+".txt");
        ResponseEntity<String> re = new ResponseEntity<>("Error en el servidor",HttpStatusCode.valueOf(500));
        try(BufferedWriter bf = new BufferedWriter(new FileWriter(f));

        ){
            om.writeValue(f,a);
            //bf.write(a.toJSON());

            re= new ResponseEntity<>(f.getAbsolutePath(),HttpStatusCode.valueOf(201));

        }catch(IOException ioe){
            re= new ResponseEntity<>("No se pudo escribir el archivo",HttpStatusCode.valueOf(500));
        }

        return re;
    }

    @PostMapping("getp")
    public ResponseEntity<AgreementWithProducts> getAssociatedProducts(@RequestBody String s){
        System.out.println(s+s.substring(s.lastIndexOf("\\")+1)+s.substring(1,s.length()-2));

        int last_slash=s.lastIndexOf("\\");
        File f= new File(s);
        System.out.printf(f.exists()+" "+f.canRead());
        AgreementWithProducts awp= null;

        try(
            FileReader fr = new FileReader(s);
            BufferedReader br = new BufferedReader(fr);){
            String JSONContent="";
            for (String currentLine= br.readLine(); currentLine!=null; currentLine=br.readLine()) {
                JSONContent=JSONContent+currentLine;
            }
            System.out.println("JSON: "+JSONContent);
            Agreement a=  om.readValue(f,Agreement.class);
            System.out.println("JSON: "+a);
            ProductDAO pdao= new ProductDAO(ConnectionFactory.getConnection());
            ArrayList<Product> associatedProducts = (ArrayList<Product>) pdao.listAssociatedProducts(a);
            for(Product product : associatedProducts){
                System.out.println(product);
            }

            return new ResponseEntity<AgreementWithProducts>(awp,HttpStatusCode.valueOf(200));

            /*

            System.out.println(a.toString());
            JSONContent=JSONContent.substring(1,JSONContent.length()-1);
            String[] values = JSONContent.split(",");
            for(String pair:values){
                System.out.println(pair.replaceAll("\'|\"",""));
                String[]  kv=pair.replace("\'|\""," ").split(":");
                for (String el : kv)
                    System.out.printf("\n%s_%s",kv);
            }

             */
        }
        catch (FileNotFoundException fnfe){
            return new ResponseEntity<AgreementWithProducts>(awp,HttpStatusCode.valueOf(404));
        }
        catch(IOException ioe){
            ioe.printStackTrace();
            return new ResponseEntity<AgreementWithProducts>(awp,HttpStatusCode.valueOf(415));
        }
        catch(Exception e){
            return new ResponseEntity<AgreementWithProducts>(awp,HttpStatusCode.valueOf(500));
        }

    }
    /*
    public void listProducts()  {
        try(Connection con = DriverManager.getConnection("my path",
                "my user",
                "my pass");
            Statement s = con.prepareStatement("Select productid,name,price,parent_productid from Product;");
        ){




            boolean result = s.execute("Select productid,name,price,parent_productid from Product;");
            ResultSet listado_resultado = s.getResultSet();
            ArrayList<HashMap<String, String>> tabla = new ArrayList<>();
            HashMap<String, String> fila = new HashMap<>();
            while (listado_resultado.next()) {
                fila.put("productid", String.valueOf(listado_resultado.getInt("productid")));
                fila.put("name", listado_resultado.getString("name"));
                fila.put("price", listado_resultado.getString("price"));
                fila.put("parent_productid", String.valueOf(listado_resultado.getInt("parent_productid")));
                tabla.add(fila);
            }
        }catch (SQLException sqlex){
            System.out.println("Error SQL");

        }
    }
    */
}
