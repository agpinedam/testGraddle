package org.forest.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.forest.api.model.ForestCreationRequestTreesInner;
import org.forest.api.model.ForestType;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ForestCreationRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-17T16:46:58.216673178+01:00[Europe/Paris]")
public class ForestCreationRequest {

  private ForestType type;

  private Double surface;

  @Valid
  private List<@Valid ForestCreationRequestTreesInner> trees = new ArrayList<>();

  public ForestCreationRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ForestCreationRequest(ForestType type, Double surface, List<@Valid ForestCreationRequestTreesInner> trees) {
    this.type = type;
    this.surface = surface;
    this.trees = trees;
  }

  public ForestCreationRequest type(ForestType type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @NotNull @Valid 
  @Schema(name = "type", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public ForestType getType() {
    return type;
  }

  public void setType(ForestType type) {
    this.type = type;
  }

  public ForestCreationRequest surface(Double surface) {
    this.surface = surface;
    return this;
  }

  /**
   * Get surface
   * @return surface
  */
  @NotNull 
  @Schema(name = "surface", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("surface")
  public Double getSurface() {
    return surface;
  }

  public void setSurface(Double surface) {
    this.surface = surface;
  }

  public ForestCreationRequest trees(List<@Valid ForestCreationRequestTreesInner> trees) {
    this.trees = trees;
    return this;
  }

  public ForestCreationRequest addTreesItem(ForestCreationRequestTreesInner treesItem) {
    if (this.trees == null) {
      this.trees = new ArrayList<>();
    }
    this.trees.add(treesItem);
    return this;
  }

  /**
   * Get trees
   * @return trees
  */
  @NotNull @Valid 
  @Schema(name = "trees", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("trees")
  public List<@Valid ForestCreationRequestTreesInner> getTrees() {
    return trees;
  }

  public void setTrees(List<@Valid ForestCreationRequestTreesInner> trees) {
    this.trees = trees;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ForestCreationRequest forestCreationRequest = (ForestCreationRequest) o;
    return Objects.equals(this.type, forestCreationRequest.type) &&
        Objects.equals(this.surface, forestCreationRequest.surface) &&
        Objects.equals(this.trees, forestCreationRequest.trees);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, surface, trees);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ForestCreationRequest {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    surface: ").append(toIndentedString(surface)).append("\n");
    sb.append("    trees: ").append(toIndentedString(trees)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

