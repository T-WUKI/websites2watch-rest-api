package com.wuki.websites2watch.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="TBWEBSITE")
@SuppressWarnings("unused")
public class Website {

  private long id;
  private int version;
  private String name;
  private String requestUrl;
  private String description;
  private Set<Tag> tags;
  private Set<Action> actions;
  private Set<Region> regions;

  public Website() {
  }

  public Website(WebsiteRequest req) {
    this.name = req.getUniqueName();
    this.requestUrl = req.getRequestUrl();
    this.description = req.getDescription();
    this.tags = req.getTags();
    this.actions = req.getActions();
    this.regions = req.getRegions();
  }

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

  @Column(unique = true)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRequestUrl() {
    return requestUrl;
  }

  public void setRequestUrl(String requestUrl) {
    this.requestUrl = requestUrl;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @ManyToMany
  @JoinTable(
    name = "TBWEBSITETOTAG",
    joinColumns = @JoinColumn(name = "site_id"),
    inverseJoinColumns = @JoinColumn(name = "tag_id"))
  public Set<Tag> getTags() {
    return tags;
  }

  public void setTags(Set<Tag> tags) {
    this.tags = tags;
  }

  @ManyToMany
  @JoinTable(
    name = "TBWEBSITETOACTION",
    joinColumns = @JoinColumn(name = "site_id"),
    inverseJoinColumns = @JoinColumn(name = "action_id"))
  public Set<Action> getActions() {
    return actions;
  }

  public void setActions(Set<Action> actions) {
    this.actions = actions;
  }

  @ManyToMany
  @JoinTable(
    name = "TBWEBSITETOREGION",
    joinColumns = @JoinColumn(name = "site_id"),
    inverseJoinColumns = @JoinColumn(name = "region_id"))
  public Set<Region> getRegions() {
    return regions;
  }

  public void setRegions(Set<Region> regions) {
    this.regions = regions;
  }
}
