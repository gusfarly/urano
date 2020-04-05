package com.ggastudios.urano.controller;

import com.ggastudios.urano.DTO.BaseRequest;
import com.ggastudios.urano.DTO.request.application.AppInsertRequest;
import com.ggastudios.urano.DTO.request.application.AppUpdateRequest;
import com.ggastudios.urano.DTO.response.application.AppInsertResponse;
import com.ggastudios.urano.DTO.response.application.AppResponse;
import com.ggastudios.urano.bean.AppBean;
import com.ggastudios.urano.exception.ApplicationNotFoundException;
import com.ggastudios.urano.service.AppService;
import com.ggastudios.urano.utils.MappersBean;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/apps")
public class AppController {

    @Autowired
    private AppService appService;
    @Autowired
    private MappersBean<AppInsertRequest, AppBean, AppInsertResponse> mapperInsert;
    @Autowired
    private MappersBean<BaseRequest,AppBean, AppResponse> mapGet;
    @Autowired
    private MappersBean<AppUpdateRequest,AppBean,AppResponse> mapUpdate;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insert (@RequestBody AppInsertRequest request) throws ApplicationNotFoundException {
        AppBean bean = mapperInsert.map(request,AppBean.class);
        bean = appService.insert(bean);
        AppInsertResponse response = mapperInsert.map(bean,AppInsertResponse.class);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{idApplication}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getApplication(@PathVariable("idApplication") String idApplication) throws ApplicationNotFoundException {
        AppBean bean = appService.findById(idApplication);
        AppResponse response = mapGet.map(bean,AppResponse.class);
        return ResponseEntity.ok(response);
    }

    @PatchMapping(value = "/{idApplication}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateApplication(@RequestBody AppUpdateRequest request,@PathVariable("idApplication") String idApplication) throws ApplicationNotFoundException {
        AppBean bean = mapUpdate.map(request,AppBean.class);
        bean = appService.updateApp(bean,idApplication);
        return ResponseEntity.ok(mapUpdate.map(bean,AppResponse.class));
    }

}
