package org.airtribe.LearnerManagementSystemBelC14.controller.v1;

import org.airtribe.LearnerManagementSystemBelC14.dto.PagedResponse;
import org.airtribe.LearnerManagementSystemBelC14.entity.Cohort;
import org.airtribe.LearnerManagementSystemBelC14.service.LearnerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("cohortControllerV1")
@RequestMapping("/api/v1")
public class CohortController {

    @Autowired
    private LearnerManagementService _learnerManagementService;

    @GetMapping("/cohorts")
    public org.airtribe.LearnerManagementSystemBelC14.dto.PagedResponse<Cohort> getCohorts(
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
            @RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(value = "sortBy", defaultValue = "cohortId") String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc") String sortDir
    )
    {
        if(pageNumber < 0) {
            pageNumber = 0;
        }

        if(pageSize > 2000) {
            pageSize = 10;
        }

        Sort.Direction direction;
        if(!(sortDir.equals("asc") || sortDir.equals("desc"))) {
            direction = Sort.Direction.ASC;
        }
        else if(sortDir.equals("asc")) {
            direction = Sort.Direction.ASC;
        }
        else {
            direction = Sort.Direction.DESC;
        }

        if(!(sortBy.equals("cohortId") || sortBy.equals("cohortName"))) {
            sortBy = "cohortId";
        }

        return _learnerManagementService.fetchPaginatedCohorts(pageSize, pageNumber, sortBy, direction);
    }

}
