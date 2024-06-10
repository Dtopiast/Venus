package com.dtopiast.venus.presentation.api.controller.v1;

import com.dtopiast.venus.core.service.profile.IProfileService;
import com.dtopiast.venus.domain.profile.dto.*;
import com.dtopiast.venus.domain.profile.model.Profile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/profiles")
@Api(value = "Profile Management System")
public class ProfileController {
    private final IProfileService profileService;

    @Autowired
    public ProfileController(IProfileService profileService) {
        this.profileService = profileService;
    }

    @ApiOperation(value = "Create a new profile")
    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Profile> createProfile(
            @ApiParam(value = "Profile Details", required = true)
            @Valid @RequestBody CreateProfileDto dto) {
        Profile profile = profileService.createProfileDto(dto);
        return ResponseEntity.ok(profile);
    }

    @ApiOperation(value = "Delete a profile")
    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Boolean> deleteProfile(
            @ApiParam(value = "Profile ID", required = true)
            @Valid @RequestBody DeleteProfileDto dto) {
        Boolean result = profileService.deleteProfile(dto);
        return ResponseEntity.ok(result);
    }

    @ApiOperation(value = "Update the name of a profile")
    @PutMapping("/updateName")
    public ResponseEntity<Profile> updateProfileName(
            @ApiParam(value = "Profile ID and new name", required = true)
            @Valid @RequestBody UpdateProfileNameDto dto) {
        Profile profile = profileService.updateProfileName(dto);
        return ResponseEntity.ok(profile);
    }

    @ApiOperation(value = "Get all profiles")
    @GetMapping
    public ResponseEntity<List<Profile>> getAllProfiles() {
        List<Profile> profiles = profileService.getAllProfiles();
        return ResponseEntity.ok(profiles);
    }

    @ApiOperation(value = "Get profile by name")
    @GetMapping("/byName/{name}")
    public ResponseEntity<Profile> getProfileByName(
            @ApiParam(value = "Profile name", required = true)
            @PathVariable String name) {
        Profile profile = profileService.getProfileByName(name);
        return ResponseEntity.ok(profile);
    }

    @ApiOperation(value = "Get profile by ID")
    @GetMapping("/byId/{id}")
    public ResponseEntity<Profile> getProfileById(
            @ApiParam(value = "Profile ID", required = true)
            @PathVariable Long id) {
        Profile profile = profileService.getProfileById(id);
        return ResponseEntity.ok(profile);
    }

    @ApiOperation(value = "Add a user to a profile")
    @PostMapping("/addUser")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Profile> addUserInProfile(
            @ApiParam(value = "Profile and User IDs", required = true)
            @Valid @RequestBody AddUserInProfileDto dto) {
        Profile profile = profileService.AddUserInProfileDto(dto);
        return ResponseEntity.ok(profile);
    }

    @ApiOperation(value = "Remove a user from a profile")
    @DeleteMapping("/removeUser")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Boolean> deleteUserInProfile(
            @ApiParam(value = "Profile and User IDs", required = true)
            @Valid @RequestBody DeleteUserInProfileDto dto) {
        Boolean result = profileService.deleteUserInProfileDto(dto);
        return ResponseEntity.ok(result);
    }
}
