package co.shop.luxury.controllerImpl;

import co.shop.luxury.constant.JoyeriaConstant;
import co.shop.luxury.controller.CategoryController;
import co.shop.luxury.model.Category;
import co.shop.luxury.service.CategoryService;
import co.shop.luxury.utils.JoyeriaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class CategoryControllerImpl implements CategoryController {

    @Autowired
    CategoryService categoryService;

    @Override
    public ResponseEntity<String> addNewCategory(Map<String, String> requestMap) {
        try{
            return categoryService.addNewCategory(requestMap);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return JoyeriaUtils.getResponseEntity(JoyeriaConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<Category>> getAllCategory(String filterValue) {
        try{
            categoryService.getAllCategory(filterValue);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
