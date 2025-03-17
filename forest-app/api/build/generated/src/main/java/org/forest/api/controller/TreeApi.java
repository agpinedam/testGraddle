/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.3.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.forest.api.controller;

import org.forest.api.model.Tree;
import org.forest.api.model.TreeCreationRequest;
import org.forest.api.model.TreeUpdateRequest;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-17T16:46:58.216673178+01:00[Europe/Paris]")
@Validated
@Tag(name = "tree", description = "the tree API")
public interface TreeApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /tree : Create a new tree
     *
     * @param treeCreationRequest  (required)
     * @return Tree created successfully (status code 201)
     */
    @Operation(
        operationId = "createTree",
        summary = "Create a new tree",
        tags = { "tree" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Tree created successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Tree.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/tree",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Tree> createTree(
        @Parameter(name = "TreeCreationRequest", description = "", required = true) @Valid @RequestBody TreeCreationRequest treeCreationRequest
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"birth\" : \"2000-01-23\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"carbonStorageCapacity\" : 0.8008281904610115 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /tree/{id} : Delete tree
     *
     * @param id Tree identifier (required)
     * @return Tree deleted successfully (status code 204)
     *         or Tree not found (status code 404)
     */
    @Operation(
        operationId = "deleteTree",
        summary = "Delete tree",
        tags = { "tree" },
        responses = {
            @ApiResponse(responseCode = "204", description = "Tree deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Tree not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/tree/{id}"
    )
    
    default ResponseEntity<Void> deleteTree(
        @Parameter(name = "id", description = "Tree identifier", required = true, in = ParameterIn.PATH) @PathVariable("id") String id
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /tree/{id} : Get tree information
     *
     * @param id Tree identifier (required)
     * @return Tree found (status code 200)
     *         or Tree not found (status code 404)
     */
    @Operation(
        operationId = "getTree",
        summary = "Get tree information",
        tags = { "tree" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Tree found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Tree.class))
            }),
            @ApiResponse(responseCode = "404", description = "Tree not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/tree/{id}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<Tree> getTree(
        @Parameter(name = "id", description = "Tree identifier", required = true, in = ParameterIn.PATH) @PathVariable("id") String id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"birth\" : \"2000-01-23\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"carbonStorageCapacity\" : 0.8008281904610115 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /tree : List all trees
     *
     * @return List of trees found (status code 200)
     */
    @Operation(
        operationId = "listTrees",
        summary = "List all trees",
        tags = { "tree" },
        responses = {
            @ApiResponse(responseCode = "200", description = "List of trees found", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Tree.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/tree",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<Tree>> listTrees(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"birth\" : \"2000-01-23\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"carbonStorageCapacity\" : 0.8008281904610115 }, { \"birth\" : \"2000-01-23\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"carbonStorageCapacity\" : 0.8008281904610115 } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /tree/{id} : Update tree
     *
     * @param id Tree identifier (required)
     * @param treeUpdateRequest  (required)
     * @return Tree updated successfully (status code 200)
     *         or Tree not found (status code 404)
     */
    @Operation(
        operationId = "updateTree",
        summary = "Update tree",
        tags = { "tree" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Tree updated successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Tree.class))
            }),
            @ApiResponse(responseCode = "404", description = "Tree not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/tree/{id}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Tree> updateTree(
        @Parameter(name = "id", description = "Tree identifier", required = true, in = ParameterIn.PATH) @PathVariable("id") String id,
        @Parameter(name = "TreeUpdateRequest", description = "", required = true) @Valid @RequestBody TreeUpdateRequest treeUpdateRequest
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"birth\" : \"2000-01-23\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"carbonStorageCapacity\" : 0.8008281904610115 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
