package com.backend.webappserver.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Node1 implements Serializable {
	 private Integer id; // Current node id
	  private Integer parentId; // Parent node id

	  @JsonProperty("name")
	  private String value;
	  @JsonIgnore
	  private Node1 parent;
	  
	  @JsonProperty("sequence")
	  private Integer sequence;
	  
	  @JsonProperty("issub")
	  private boolean issub;

	  
	  
	  private List<Node1> children;

	public Node1() {
	    super();
	    this.children = new ArrayList<>();
	  }
	  public Node1(String value, Integer childId, Integer parentId,Integer sequence,boolean issub) {
		    this.value = value;
		    this.id = childId;
		    this.parentId = parentId;
		    this.sequence=sequence;
		    this.issub=issub;
		    this.children = new ArrayList<>();
		  }

		  public Node1(String value, Integer childId, Integer parentId, List<Node1> children) {
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

//			  public String getId() {
//			    return id;
//			  }
//
//			  public void setId(String id) {
//			    this.id = id;
//			  }

			  public Integer getParentId() {
			    return parentId;
			  }

			  public Integer getId() {
				return id;
			}
			public void setId(Integer id) {
				this.id = id;
			}
			public void setParentId(Integer parentId) {
			    this.parentId = parentId;
			  }

			  public Node1 getParent() {
			    return parent;
			  }

			  public void setParent(Node1 parent) {
			    this.parent = parent;
			  }

			  public List<Node1> getChildren() {
			    return children;
			  }

			  public void setChildren(List<Node1> children) {
			    this.children = children;
			  }

			  public void addChild(Node1 child) {
			    if (!this.children.contains(child) && child != null) this.children.add(child);
			  }

			  @Override
			  public String toString() {
			    return "Node1 [id=" + id + ", parentId=" + parentId + ", value=" + value + ", children="
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
