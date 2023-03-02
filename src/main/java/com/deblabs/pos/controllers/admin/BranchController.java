package com.deblabs.pos.controllers.admin;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.deblabs.pos.models.Branch;
import com.deblabs.pos.repository.BranchRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class BranchController {
    @Autowired
    private BranchRepository branchRepository;

    @PostMapping("/createBranch")
    @PreAuthorize("hasRole('ADMIN')")
    public  ResponseEntity<Branch>  createBranch(@RequestBody Branch branch) {
        Branch br = branchRepository.save(branch);
        return ResponseEntity.ok(br);
    }

    @GetMapping("/getAllBranches")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Branch>> findAll() {
        return ResponseEntity.ok(branchRepository.findAll());
    }
    
}
