/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.3.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.forest.api.controller;

import org.forest.api.model.CalculateForestAbsorption200Response;
import org.forest.api.model.CalculateSurfaceNeeded200Response;
import org.forest.api.model.Forest;
import org.forest.api.model.ForestCreationRequest;
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
@Tag(name = "forest", description = "the forest API")
public interface ForestApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /forest/{id}/co2-absorption : Calculate CO2 absorption capacity for a forest in kg/year
     *
     * @param id Forest identifier (required)
     * @return CO2 absorption capacity calculated (status code 200)
     */
    @Operation(
        operationId = "calculateForestAbsorption",
        summary = "Calculate CO2 absorption capacity for a forest in kg/year",
        tags = { "forest" },
        responses = {
            @ApiResponse(responseCode = "200", description = "CO2 absorption capacity calculated", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = CalculateForestAbsorption200Response.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/forest/{id}/co2-absorption",
        produces = { "application/json" }
    )
    
    default ResponseEntity<CalculateForestAbsorption200Response> calculateForestAbsorption(
        @Parameter(name = "id", description = "Forest identifier", required = true, in = ParameterIn.PATH) @PathVariable("id") String id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"absorptionKgPerYear\" : 0.8008281904610115 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /forest/surface-needed : Calculate forest surface needed to absorb a given CO2 amount
     *
     * @param co2AmountKg Amount of CO2 in kilograms (required)
     * @return Surface calculation result (status code 200)
     */
    @Operation(
        operationId = "calculateSurfaceNeeded",
        summary = "Calculate forest surface needed to absorb a given CO2 amount",
        tags = { "forest" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Surface calculation result", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = CalculateSurfaceNeeded200Response.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/forest/surface-needed",
        produces = { "application/json" }
    )
    
    default ResponseEntity<CalculateSurfaceNeeded200Response> calculateSurfaceNeeded(
        @NotNull @Parameter(name = "co2AmountKg", description = "Amount of CO2 in kilograms", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "co2AmountKg", required = true) Double co2AmountKg
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"surfaceKm2\" : 0.8008281904610115 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /forest : Create a new forest
     *
     * @param forestCreationRequest  (required)
     * @return Forest created successfully (status code 201)
     */
    @Operation(
        operationId = "createForest",
        summary = "Create a new forest",
        tags = { "forest" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Forest created successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Forest.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/forest",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Forest> createForest(
        @Parameter(name = "ForestCreationRequest", description = "", required = true) @Valid @RequestBody ForestCreationRequest forestCreationRequest
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"surface\" : 0.8008281904610115, \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"trees\" : [ { \"birth\" : \"2000-01-23\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"carbonStorageCapacity\" : 0.8008281904610115 }, { \"birth\" : \"2000-01-23\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"carbonStorageCapacity\" : 0.8008281904610115 } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /forest/{id} : Delete forest
     *
     * @param id Forest identifier (required)
     * @return Forest deleted successfully (status code 204)
     *         or Forest not found (status code 404)
     */
    @Operation(
        operationId = "deleteForest",
        summary = "Delete forest",
        tags = { "forest" },
        responses = {
            @ApiResponse(responseCode = "204", description = "Forest deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Forest not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/forest/{id}"
    )
    
    default ResponseEntity<Void> deleteForest(
        @Parameter(name = "id", description = "Forest identifier", required = true, in = ParameterIn.PATH) @PathVariable("id") String id
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /forest/{id} : Get forest information
     *
     * @param id Forest identifier (required)
     * @return Forest found (status code 200)
     *         or Forest not found (status code 404)
     */
    @Operation(
        operationId = "getForest",
        summary = "Get forest information",
        tags = { "forest" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Forest found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Forest.class))
            }),
            @ApiResponse(responseCode = "404", description = "Forest not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/forest/{id}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<Forest> getForest(
        @Parameter(name = "id", description = "Forest identifier", required = true, in = ParameterIn.PATH) @PathVariable("id") String id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"surface\" : 0.8008281904610115, \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"trees\" : [ { \"birth\" : \"2000-01-23\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"carbonStorageCapacity\" : 0.8008281904610115 }, { \"birth\" : \"2000-01-23\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"carbonStorageCapacity\" : 0.8008281904610115 } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /forest : List all forests
     *
     * @return List of forests found (status code 200)
     */
    @Operation(
        operationId = "listForests",
        summary = "List all forests",
        tags = { "forest" },
        responses = {
            @ApiResponse(responseCode = "200", description = "List of forests found", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Forest.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/forest",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<Forest>> listForests(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"surface\" : 0.8008281904610115, \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"trees\" : [ { \"birth\" : \"2000-01-23\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"carbonStorageCapacity\" : 0.8008281904610115 }, { \"birth\" : \"2000-01-23\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"carbonStorageCapacity\" : 0.8008281904610115 } ] }, { \"surface\" : 0.8008281904610115, \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"trees\" : [ { \"birth\" : \"2000-01-23\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"carbonStorageCapacity\" : 0.8008281904610115 }, { \"birth\" : \"2000-01-23\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"carbonStorageCapacity\" : 0.8008281904610115 } ] } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
