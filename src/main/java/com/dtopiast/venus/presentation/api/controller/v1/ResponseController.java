package com.dtopiast.venus.presentation.api.controller.v1;

import com.dtopiast.venus.core.service.response.IResponseService;
import com.dtopiast.venus.domain.response.dto.*;
import com.dtopiast.venus.domain.response.model.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/response")
@Tag(name = "Response", description = "Operations related to responses")
public class ResponseController {

    private final IResponseService responseService;

    @Autowired
    public ResponseController(IResponseService responseService) {
        this.responseService = responseService;
    }

    @PostMapping
    @Operation(summary = "Create a new response")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Response> createResponse(@Valid @RequestBody CreateResponseDto dto) {
        Response response = responseService.createResponse(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    @Operation(summary = "Delete a response")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Boolean> deleteResponse(@Valid @RequestBody DeleteResponseDto dto) {
        Boolean result = responseService.deleteResponse(dto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/message")
    @Operation(summary = "Update response message")

    public ResponseEntity<Response> updateResponseMessage(@Valid @RequestBody UpdateResponseMessageDto dto) {
        Response response = responseService.updateResponseMessage(dto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/solution")
    @Operation(summary = "Update response solution")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Response> updateResponseSolution( @Valid @RequestBody UpdateResponseSolutionDto dto) {
        Response response = responseService.updateResponseSolution(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @Operation(summary = "Get all responses")
    public ResponseEntity<List<Response>> getAllResponses() {
        List<Response> responses = responseService.getAllResponse();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/paginated")
    @Operation(summary = "Get all responses with pagination")
    public ResponseEntity<Page<Response>> getAllResponsesPaginated(
            @Parameter(description = "Page number") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Page size") @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Response> responses = responseService.getAllResponse(pageable);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/by-topic")
    @Operation(summary = "Get response by topic title")
    public ResponseEntity<Response> getResponseByTopic(@RequestParam String topicTitle) {
        Response response = responseService.getResponseByTopic(topicTitle);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get response by id")
    public ResponseEntity<Response> getResponseById(@PathVariable Long id) {
        Response response = responseService.getResponseById(id);
        return ResponseEntity.ok(response);
    }
}
