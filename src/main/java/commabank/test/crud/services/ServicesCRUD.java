package commabank.test.crud.services;

import commabank.test.crud.model.ModelEmployee;
import commabank.test.crud.repository.Repository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicesCRUD {

    @Autowired
    private Repository repository;

public Object insertData(String request){
    JSONObject json = new JSONObject(request);
    JSONObject output = new JSONObject();
    String name = json.getString("name");
    String phone = json.getString("phone");
    ModelEmployee input = new ModelEmployee();
    input.setName(name);
    input.setPhone(phone);
    try{
             repository.save(input);
            return new ResponseEntity<>(input, HttpStatus.CREATED);
    }catch(Exception e){
        e.printStackTrace();
        output.put("error messege",e.getMessage());
        return output.toString();
    }
}

public Object deleteData(String request) {
    JSONObject json = new JSONObject(request);
    JSONObject output = new JSONObject();
    String name = json.getString("name");
    try {
        repository.deleteByName(name);
        output.put("success delete data ",name);
        return output.toString();
    } catch (Exception e) {
        e.printStackTrace();
        output.put("error msg ", e.getMessage());
        return output.toString();
    }

}

    public Object updateData(String request){
        JSONObject json = new JSONObject(request);
        JSONObject output = new JSONObject();
        int id = json.getInt("id");
        String name = json.getString("name");
        String phone = json.getString("phone");
        try{
           repository.updateById(name,phone,id);
            output.put("success update data ", "name :"+name+", phone :"+phone);
            return output.toString();
        }catch(Exception e){
            e.printStackTrace();
            output.put("error msg",  e.getMessage());
            return output.toString();
        }
    }

    public Object selectData(){
    JSONObject output = new JSONObject();
    List<ModelEmployee> listData = new ArrayList();
    try{
        repository.findAll().forEach(listData::add);
        return new ResponseEntity<>(listData, HttpStatus.OK);
    }catch(Exception e){
        e.printStackTrace();
        output.put("Error msg ", e.getMessage());
        return output.toString();
    }
    }
}


