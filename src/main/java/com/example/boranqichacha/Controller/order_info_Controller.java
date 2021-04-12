package com.example.boranqichacha.Controller;

import com.example.boranqichacha.service.FiOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author LT
 * @create 2021-04-12 11:19
 */
@RequestMapping("order_form")
@RestController
public class order_info_Controller {
    @Autowired
    FiOrderInfoService FiOrderInfoService;
}
