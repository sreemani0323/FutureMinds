package com.Eamcet.predictor.service;

import com.Eamcet.predictor.model.College;
import com.Eamcet.predictor.repository.CollegeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollegePredictorService {

    private final CollegeRepository repo;

    public CollegePredictorService(CollegeRepository repo) {
        this.repo = repo;
    }

    public static class CollegeResult {
        private String name;
        private String region;
        private String place;
        private String affl;
        private String branch;
        private Integer cutoff;

        public CollegeResult(String name, String region, String place, String affl, String branch, Integer cutoff) {
            this.name = name;
            this.region = region;
            this.place = place;
            this.affl = affl;
            this.branch = branch;
            this.cutoff = cutoff;
        }

        public String getName() { return name; }
        public String getRegion() { return region; }
        public String getPlace() { return place; }
        public String getAffl() { return affl; }
        public String getBranch() { return branch; }
        public Integer getCutoff() { return cutoff; }
    }

    public List<CollegeResult> predict(int rank, String branch, String category) {
        if (rank <= 0) throw new IllegalArgumentException("Rank must be > 0");
        if (branch == null || branch.isBlank()) throw new IllegalArgumentException("Branch required");
        if (category == null || category.isBlank()) throw new IllegalArgumentException("Category required");

        int requiredTotalCount = (rank <= 15000) ? 15 : 10;
        int nullCutoffMinimum = 3;

        List<College> colleges = repo.findByBranchCode(branch.trim());

        List<CollegeResult> withCutoff = new ArrayList<>();
        List<CollegeResult> nullCutoff = new ArrayList<>();

        for (College c : colleges) {
            Integer cutoff = getCutoffForCategory(c, category);
            CollegeResult cr = new CollegeResult(
                c.getNameOfTheInstitution(), c.getRegion(), c.getPlace(),
                c.getAffl(), c.getBranchCode(), cutoff
            );

            if (cutoff == null) {
                nullCutoff.add(cr);
            } else {
                withCutoff.add(cr);
            }
        }

        int minRange, maxRange;
        if (rank <= 15000) {
            minRange = 1;
            maxRange = rank + 40000;
        } else if (rank > 100000) {
            minRange = Math.max(1, rank - 25000);
            maxRange = rank + 25000;
        } else {
            minRange = Math.max(1, rank - 4000);
            maxRange = rank + 4000;
        }
        
        List<CollegeResult> filteredWithCutoff = filterCollegesByRange(withCutoff, minRange, maxRange);

        if (filteredWithCutoff.size() < requiredTotalCount) {
            int fallbackMinRange = Math.max(1, rank - 100000);
            int fallbackMaxRange = rank + 100000;
            filteredWithCutoff = filterCollegesByRange(withCutoff, fallbackMinRange, fallbackMaxRange);
        }
        
        Comparator<CollegeResult> mainComparator = Comparator.comparingInt(cr -> Math.abs(cr.getCutoff() - rank));
        filteredWithCutoff.sort(mainComparator.thenComparing(CollegeResult::getName));

        List<CollegeResult> result = new ArrayList<>();

        int nullsToAdd = Math.min(nullCutoff.size(), nullCutoffMinimum);
        result.addAll(nullCutoff.subList(0, nullsToAdd));

        int collegesNeeded = requiredTotalCount - result.size();
        int cutoffsToAdd = Math.min(filteredWithCutoff.size(), collegesNeeded);
        result.addAll(filteredWithCutoff.subList(0, cutoffsToAdd));

        int remainingNeeded = requiredTotalCount - result.size();
        if (remainingNeeded > 0) {
            int additionalNulls = Math.min(nullCutoff.size() - nullsToAdd, remainingNeeded);
            result.addAll(nullCutoff.subList(nullsToAdd, nullsToAdd + additionalNulls));
        }

        return result;
    }

    private List<CollegeResult> filterCollegesByRange(List<CollegeResult> colleges, int minRange, int maxRange) {
        return colleges.stream()
                       .filter(cr -> cr.getCutoff() != null && cr.getCutoff() >= Math.max(1, minRange) && cr.getCutoff() <= maxRange)
                       .collect(Collectors.toList());
    }

    private Integer getCutoffForCategory(College c, String category) {
        return switch (category.toLowerCase()) {
            case "oc_boys" -> c.getOcBoys();
            case "oc_girls" -> c.getOcGirls();
            case "sc_boys" -> c.getScBoys();
            case "sc_girls" -> c.getScGirls();
            case "st_boys" -> c.getStBoys();
            case "st_girls" -> c.getStGirls();
            case "bca_boys" -> c.getBcaBoys();
            case "bca_girls" -> c.getBcaGirls();
            case "bcb_boys" -> c.getBcbBoys();
            case "bcb_girls" -> c.getBcbGirls();
            case "bcc_boys" -> c.getBccBoys();
            case "bcc_girls" -> c.getBccGirls();
            case "bcd_boys" -> c.getBcdBoys();
            case "bcd_girls" -> c.getBcdGirls();
            case "bce_boys" -> c.getBceBoys();
            case "bce_girls" -> c.getBceGirls();
            case "oc_ews_boys" -> c.getOcEwsBoys();
            case "oc_ews_girls" -> c.getOcEwsGirls();
            default -> null;
        };
    }
}