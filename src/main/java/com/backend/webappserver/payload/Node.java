/**
 * 
 */
package com.backend.webappserver.payload;

import java.io.Serializable;
/**
 * @author ashutosh
 *
 */
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Node implements Serializable {

  private String id; // Current node id
  private Integer parentId; // Parent node id

  @JsonProperty("name")
  private String value;
  @JsonIgnore
  private Node parent;
  
  @JsonProperty("sequence")
  private Integer sequence;
  
  @JsonProperty("issub")
  private boolean issub;
  


  
  
  private List<Node> children;
	public List<Node1> getNodes() {
	return nodes;
}

public void setNodes(List<Node1> nodes) {
	this.nodes = nodes;
}

	List<Node1> nodes = new ArrayList<>();


  public Node() {
    super();
    this.children = new ArrayList<>();
  }

  public Node(String value, String childId, Integer parentId,Integer sequence,boolean issub) {
    this.value = value;
    this.id = childId;
    this.parentId = parentId;
    this.sequence=sequence;
    this.issub=issub;
    this.children = new ArrayList<>();
  }

  public Node(String value, String childId, Integer parentId, List<Node> children) {
    this.value = value;
    this.id = childId;
    this.parentId = parentId;
    this.children = children;
  }
  
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getParentId() {
    return parentId;
  }

  public void setParentId(Integer parentId) {
    this.parentId = parentId;
  }

  public Node getParent() {
    return parent;
  }

  public void setParent(Node parent) {
    this.parent = parent;
  }

  public List<Node> getChildren() {
    return children;
  }

  public void setChildren(List<Node> children) {
    this.children = children;
  }

  public void addChild(Node child) {
    if (!this.children.contains(child) && child != null) this.children.add(child);
  }

  @Override
  public String toString() {
    return "Node [id=" + id + ", parentId=" + parentId + ", value=" + value + ", children="
        + children + "]";
  }

public Integer getSequence() {
	return sequence;
}

public void setSequence(Integer sequence) {
	this.sequence = sequence;
}

public boolean isIssub() {
	return issub;
}

public void setIssub(boolean issub) {
	this.issub = issub;
}


  
}
