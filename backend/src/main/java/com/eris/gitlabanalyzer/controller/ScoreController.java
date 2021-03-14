package com.eris.gitlabanalyzer.controller;

import com.eris.gitlabanalyzer.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;


@RestController
@RequestMapping(path = "/api/v1/data")
public class ScoreController {

    private final ScoreService scoreService;

    @Autowired
    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping(path ="/projects/{projectId}/merge_request/{merge_request_id}/diff/score")
    public double getMergeDiffScore (@PathVariable("projectId") Long projectId,
                             @PathVariable("merge_request_id") Long merge_request_id){
        return scoreService.getMergeDiffScore(projectId, merge_request_id);
    }
    @GetMapping(path ="/projects/{projectId}/merge_requests/score")
    public double getTotalMergeDiffScore (@PathVariable("projectId") Long projectId,
                                       @RequestParam("startDateTime")
                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime startDateTime,
                                       @RequestParam("endDateTime")
                                           @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime endDateTime){
        return scoreService.getTotalMergeDiffScore(projectId, startDateTime, endDateTime);
    }

    @GetMapping(path ="/projects/{projectId}/commit/{commitId}/diff/score")
    public double getCommitDiffScore (@PathVariable("projectId") Long projectId,
                             @PathVariable("commitId") Long commitId){
        return scoreService.getCommitDiffScore(projectId, commitId);
    }
    @GetMapping(path ="/projects/{projectId}/commits/score")
    public double getTotalCommitDiffScore (@PathVariable("projectId") Long projectId,
                                       @RequestParam("startDateTime")
                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime startDateTime,
                                       @RequestParam("endDateTime")
                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime endDateTime){
        return scoreService.getTotalCommitDiffScore(projectId, startDateTime, endDateTime);
    }
}