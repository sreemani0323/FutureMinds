package com.Eamcet.predictor.repository;

import com.Eamcet.predictor.model.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollegeRepository extends JpaRepository<College, Integer> { 
    // The type of the primary key for College is Integer (sno).
    // It was incorrectly set to String in your initial code.

    @Query(value = "SELECT * FROM colleges WHERE branch_code = :branch AND " +
                   "( " +
                   "  (CASE WHEN :category = 'oc_boys' THEN oc_boys " +
                   "        WHEN :category = 'oc_girls' THEN oc_girls " +
                   "        WHEN :category = 'sc_boys' THEN sc_boys " +
                   "        WHEN :category = 'sc_girls' THEN sc_girls " +
                   "        WHEN :category = 'st_boys' THEN st_boys " +
                   "        WHEN :category = 'st_girls' THEN st_girls " +
                   "        WHEN :category = 'bca_boys' THEN bca_boys " +
                   "        WHEN :category = 'bca_girls' THEN bca_girls " +
                   "        WHEN :category = 'bcb_boys' THEN bcb_boys " +
                   "        WHEN :category = 'bcb_girls' THEN bcb_girls " +
                   "        WHEN :category = 'bcc_boys' THEN bcc_boys " +
                   "        WHEN :category = 'bcc_girls' THEN bcc_girls " +
                   "        WHEN :category = 'bcd_boys' THEN bcd_boys " +
                   "        WHEN :category = 'bcd_girls' THEN bcd_girls " +
                   "        WHEN :category = 'bce_boys' THEN bce_boys " +
                   "        WHEN :category = 'bce_girls' THEN bce_girls " +
                   "        WHEN :category = 'oc_ews_boys' THEN oc_ews_boys " +
                   "        WHEN :category = 'oc_ews_girls' THEN oc_ews_girls " +
                   "  END BETWEEN :minRank AND :maxRank) OR " +
                   "  (CASE WHEN :category = 'oc_boys' THEN oc_boys " +
                   "        WHEN :category = 'oc_girls' THEN oc_girls " +
                   "        WHEN :category = 'sc_boys' THEN sc_boys " +
                   "        WHEN :category = 'sc_girls' THEN sc_girls " +
                   "        WHEN :category = 'st_boys' THEN st_boys " +
                   "        WHEN :category = 'st_girls' THEN st_girls " +
                   "        WHEN :category = 'bca_boys' THEN bca_boys " +
                   "        WHEN :category = 'bca_girls' THEN bca_girls " +
                   "        WHEN :category = 'bcb_boys' THEN bcb_boys " +
                   "        WHEN :category = 'bcb_girls' THEN bcb_girls " +
                   "        WHEN :category = 'bcc_boys' THEN bcc_boys " +
                   "        WHEN :category = 'bcc_girls' THEN bcc_girls " +
                   "        WHEN :category = 'bcd_boys' THEN bcd_boys " +
                   "        WHEN :category = 'bcd_girls' THEN bcd_girls " +
                   "        WHEN :category = 'bce_boys' THEN bce_boys " +
                   "        WHEN :category = 'bce_girls' THEN bce_girls " +
                   "        WHEN :category = 'oc_ews_boys' THEN oc_ews_boys " +
                   "        WHEN :category = 'oc_ews_girls' THEN oc_ews_girls " +
                   "  END IS NULL) " +
                   ")",
            nativeQuery = true)
    List<College> findByCategoryAndBranchInRange(@Param("branch") String branch,
                                                 @Param("category") String category,
                                                 @Param("minRank") int minRank,
                                                 @Param("maxRank") int maxRank);
    
    // This is the correct method name and signature for Spring Data JPA to automatically generate the query.
    List<College> findByBranchCode(String branchCode);
}