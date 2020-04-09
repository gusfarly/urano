package com.ggastudios.urano.controller;

import com.ggastudios.urano.DTO.BaseRequest;
import com.ggastudios.urano.DTO.BaseResponse;
import com.ggastudios.urano.DTO.request.score.ScoreInsertRequest;
import com.ggastudios.urano.DTO.response.score.ScoreInsertResponse;
import com.ggastudios.urano.DTO.response.score.ScoreResponse;
import com.ggastudios.urano.bean.ScoreBean;
import com.ggastudios.urano.exception.UranoException;
import com.ggastudios.urano.service.ScoreService;
import com.ggastudios.urano.utils.MappersBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/scores")
public class ScoreController {

    @Autowired
    private MappersBean<ScoreInsertRequest, ScoreBean, ScoreInsertResponse> mapInsert;

    @Autowired MappersBean<BaseRequest,ScoreBean,ScoreResponse> mapGet;

    @Autowired
    private ScoreService scoreService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insert(@RequestBody ScoreInsertRequest request) throws UranoException {
        ScoreBean bean = scoreService.insert(mapInsert.map(request,ScoreBean.class));
        ScoreInsertResponse response = mapInsert.map(bean,ScoreInsertResponse.class);
        return ResponseEntity.ok(response);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTopTen(
            @RequestParam("application")String application,
            @RequestParam("level") int level,
            @RequestParam(value = "page",defaultValue = "0",required = false) int page,
            @RequestParam(value = "pageSize",defaultValue = "10",required = false)int pageSize) {

        List<ScoreResponse> response = scoreService.getTop(application,level,page,pageSize)
                .stream()
                .map(b -> mapGet.map(b,ScoreResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/previous",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPreviousTen(
            @RequestParam("application") String application,
            @RequestParam("level") int level,
            @RequestParam("score") long score,
            @RequestParam(value = "pageSize",defaultValue = "10",required = false
            )int pageSize){

        List<ScoreResponse> response = scoreService.getPrevious(application,level,score,0,pageSize)
                .stream()
                .map(b -> mapGet.map(b,ScoreResponse.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);

    }

}
