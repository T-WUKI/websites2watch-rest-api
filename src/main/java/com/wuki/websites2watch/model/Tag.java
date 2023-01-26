package com.wuki.websites2watch.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="TBTAG")
@SuppressWarnings("unused")
public class Tag {

  private long id;
  private int version;
  private String val;
  private Set<Website> sites;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @Version
  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }

  public String getVal() {
    return val;
  }

  public void setVal(String val) {
    this.val = val;
  }

  @ManyToMany(mappedBy="tags")
  public Set<Website> getSites() {
    return sites;
  }

  public void setSites(Set<Website> sites) {
    this.sites = sites;
  }
}
