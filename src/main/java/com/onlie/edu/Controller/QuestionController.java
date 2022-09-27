package com.onlie.edu.Controller;

import com.onlie.edu.Utils.BaseResponseData.ResponseData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author csz
 * @Date 2022/9/22 19:55
 */
@RequestMapping("/Question")
@RestController
public class QuestionController {

    @PostMapping("/Catalog")
    public ResponseData CatCatalog(String parentId){
        return null;
    }






}
