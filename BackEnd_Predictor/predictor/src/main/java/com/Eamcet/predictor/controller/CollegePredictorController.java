package com.Eamcet.predictor.controller;

import com.Eamcet.predictor.service.CollegePredictorService;
import com.Eamcet.predictor.service.CollegePredictorService.CollegeResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CollegePredictorController {

    private final CollegePredictorService service;

    public CollegePredictorController(CollegePredictorService service) {
        this.service = service;
    }

    /**
     * POST payload example:
     * {
     *   "rank": 12500,
     *   "branch": "CSE",
     *   "category": "sc_boys"
     * }
     */
    @PostMapping("/predict-colleges")
    public ResponseEntity<?> predict(@RequestBody Map<String, Object> payload) {
        try {
            // Extract input from JSON
            int rank = ((Number) payload.get("rank")).intValue();
            String branch = (String) payload.get("branch");
            String category = (String) payload.get("category");

            // Call service
            List<CollegeResult> results = service.predict(rank, branch, category);
            System.out.print(results);
            // Return response
            return ResponseEntity.ok(results);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(Map.of(
                    "error", ex.getMessage()
            ));
        }
    }
}

